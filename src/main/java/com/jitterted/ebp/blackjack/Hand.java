package com.jitterted.ebp.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.fusesource.jansi.Ansi.ansi;

public class Hand {
  private final List<Card> hand = new ArrayList<>();
  private final Deck deck;

  public Hand(Deck deck) {
    this.deck = deck;
  }

  public boolean isHandBusted() {
    return value() > 21;
  }

  public void drawCardFromDeck() {
    addCard(deck.draw());
  }

  private void addCard(Card card) {
    hand.add(card);
  }

  public void displayHand() {
    System.out.println(hand.stream()
                           .map(Card::display)
                           .collect(Collectors.joining(
                               ansi().cursorUp(6).cursorRight(1).toString())));
  }


  public int value() {
    int handValue = hand
        .stream()
        .mapToInt(Card::rankValue)
        .sum();

    // does the hand contain at least 1 Ace?
    boolean hasAce = hand
        .stream()
        .anyMatch(card -> card.rankValue() == 1);

    // if the total hand value <= 11, then count the Ace as 11 by adding 10
    if (hasAce && handValue <= 11) {
      handValue += 10;
    }

    return handValue;
  }


  public String displayForFirstCard() {
    return hand.get(0).display();
  }

  @Override
  public int hashCode() {
    return value();
  }

  boolean beats(Hand hand) {
    return value() > hand.value();
  }

  boolean pushesWith(Hand hand) {
    return value() == hand.value();
  }
}
