package com.jitterted.ebp.blackjack.domain;

import com.jitterted.ebp.blackjack.Card;
import com.jitterted.ebp.blackjack.Deck;
import com.jitterted.ebp.blackjack.Hand;
import com.jitterted.ebp.blackjack.Rank;
import com.jitterted.ebp.blackjack.Suit;

import java.util.ArrayList;
import java.util.List;

public class StubHandFactory {
  private static final Suit DONT_CARE_SUIT = Suit.of(Suit.CLUBS);

  public static Hand createHandOfCardsWithArbitrarySuit(String... ranks) {
    List<Card> cards = new ArrayList<>();
    for (String rank : ranks) {
      cards.add(new Card(DONT_CARE_SUIT, Rank.of(rank)));
    }
    Deck deck = new StubDeck(cards);
    Hand hand = new Hand(deck);
    for (int i = 0; i < ranks.length; i++) {
      hand.drawCardFromDeck();
    }
    return hand;
  }
}
