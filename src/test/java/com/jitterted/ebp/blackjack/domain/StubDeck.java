package com.jitterted.ebp.blackjack.domain;

import com.jitterted.ebp.blackjack.Card;
import com.jitterted.ebp.blackjack.Deck;

import java.util.Iterator;
import java.util.List;

class StubDeck extends Deck {
  private final Iterator<Card> cardIterator;

  public StubDeck(List<Card> cards) {
    this.cardIterator = cards.iterator();
  }

  @Override
  public Card draw() {
    return cardIterator.next();
  }
}
