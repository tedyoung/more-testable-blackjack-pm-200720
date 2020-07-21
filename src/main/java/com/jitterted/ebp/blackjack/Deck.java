package com.jitterted.ebp.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
  private final List<Card> cards = new ArrayList<>();

  public Deck() {
    createDeck();
    shuffleDeck();
  }

  private void shuffleDeck() {
    Collections.shuffle(cards);
  }

  private void createDeck() {
    var cardValues = List.of("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");
    for (Suit suit : Suit.allSuits()) {
      addSuitToDeck(cardValues, suit);
    }
  }

  private void addSuitToDeck(List<String> cardValues, Suit suit) {
    for (String cardValue : cardValues) {
      addNewCard(cardValue, suit);
    }
  }

  private void addNewCard(String cardValue, Suit suit) {
    cards.add(new Card(suit, cardValue));
  }

  public int size() {
    return cards.size();
  }

  public Card draw() {
    return cards.remove(0);
  }
}
