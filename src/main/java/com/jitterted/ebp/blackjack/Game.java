package com.jitterted.ebp.blackjack;

import org.fusesource.jansi.Ansi;

import java.util.Scanner;

import static org.fusesource.jansi.Ansi.ansi;

public class Game {

  private final Deck deck;

  private final Hand dealerHand;
  private final Hand playerHand;
  private int playerBalance;
  private int playerBet;

  public static void main(String[] args) {

    printWelcomeScreen();

    playGame();

    resetScreen();
  }

  private static void playGame() {
    Game game = new Game();
    game.initialDeal();
    game.play();
  }

  private static void resetScreen() {
    System.out.println(ansi().reset());
  }

  private static void printWelcomeScreen() {
    System.out.println(ansi()
                           .bgBright(Ansi.Color.WHITE)
                           .eraseScreen()
                           .cursor(1, 1)
                           .fgGreen().a("Welcome to")
                           .fgRed().a(" Jitterted's")
                           .fgBlack().a(" BlackJack"));
  }

  public Game() {
    playerBalance = 100;
    deck = new Deck();
    playerHand = new Hand(deck);
    dealerHand = new Hand(deck);
  }

  public void initialDeal() {

    // deal first round of cards, players first
    dealCardToAll();

    // deal next round of cards
    dealCardToAll();
  }

  private void dealCardToAll() {
    playerHand.drawCardFromDeck();
    dealerHand.drawCardFromDeck();
  }


  public void play() {
    // get Player's decision: hit until they stand, then they're done (or they go bust)
    boolean playerBusted = playerPlays();

    // Dealer makes its choice automatically based on a simple heuristic (<=16, hit, 17>stand)
    dealerPlays(playerBusted);

    displayFinalGameState();

    displayFinalGameMessage(playerBusted);
  }

  private void dealerPlays(boolean playerBusted) {
    if (!playerBusted) {
      while (dealerHand.value() <= 16) {
        dealerHand.drawCardFromDeck();
      }
    }
  }

  private boolean playerPlays() {
    boolean playerBusted = false;
    while (!playerBusted) {
      displayGameState();
      String playerChoice = inputFromPlayer().toLowerCase();
      if (playerChoice.startsWith("s")) {
        break;
      }
      if (playerChoice.startsWith("h")) {
        playerHand.drawCardFromDeck();
        playerBusted = playerHand.isHandBusted();
      } else {
        System.out.println("You need to [H]it or [S]tand");
      }
    }
    return playerBusted;
  }


  private void displayFinalGameMessage(boolean playerBusted) {
    if (playerBusted) {
      System.out.println("You Busted, so you lose.  💸");
    } else if (dealerHand.isHandBusted()) {
      System.out.println("Dealer went BUST, Player wins! Yay for you!! 💵");
    } else if (playerHand.beats(dealerHand)) {
      System.out.println("You beat the Dealer! 💵");
    } else if (playerHand.pushesWith(dealerHand)) {
      System.out.println("Push: The house wins, you Lose. 💸");
    } else {
      System.out.println("You lost to the Dealer. 💸");
    }
  }


  private String inputFromPlayer() {
    System.out.println("[H]it or [S]tand?");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }

  private void displayGameState() {
    System.out.print(ansi().eraseScreen().cursor(1, 1));
    System.out.println("Dealer has: ");
    System.out.println(dealerHand.displayForFirstCard()); // first card is Face Up

    // second card is the hole card, which is hidden
    displayBackOfCard();

    System.out.println();
    System.out.println("Player has: ");
    playerHand.displayHand();
    System.out.println(" (" + playerHand.value() + ")");
  }

  private void displayBackOfCard() {
    System.out.print(
        ansi()
            .cursorUp(7)
            .cursorRight(12)
            .a("┌─────────┐").cursorDown(1).cursorLeft(11)
            .a("│░░░░░░░░░│").cursorDown(1).cursorLeft(11)
            .a("│░ J I T ░│").cursorDown(1).cursorLeft(11)
            .a("│░ T E R ░│").cursorDown(1).cursorLeft(11)
            .a("│░ T E D ░│").cursorDown(1).cursorLeft(11)
            .a("│░░░░░░░░░│").cursorDown(1).cursorLeft(11)
            .a("└─────────┘"));
  }

  private void displayFinalGameState() {
    System.out.print(ansi().eraseScreen().cursor(1, 1));
    System.out.println("Dealer has: ");
    dealerHand.displayHand();
    System.out.println(" (" + dealerHand.value() + ")");

    System.out.println();
    System.out.println("Player has: ");
    playerHand.displayHand();
    System.out.println(" (" + playerHand.value() + ")");
  }

  public int playerBalance() {
    return playerBalance;
  }

  public void playerBets(int betAmount) {
    playerBalance -= betAmount;
    playerBet = betAmount;
  }

  public void playerLoses() {
    playerWinsWithPayoff(0);
  }

  public void playerWins() {
    playerWinsWithPayoff(2);
  }

  public void playerWinsBlackjack() {
    playerWinsWithPayoff(2.5);
  }

  public void playerPushes() {
    playerWinsWithPayoff(1);
  }

  private void playerWinsWithPayoff(double payoffMultiplier) {
    playerBalance += playerBet * payoffMultiplier;
  }

}
