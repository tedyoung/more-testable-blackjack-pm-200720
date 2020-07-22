package com.jitterted.ebp.blackjack.domain;

import com.jitterted.ebp.blackjack.Card;
import com.jitterted.ebp.blackjack.Hand;
import com.jitterted.ebp.blackjack.Rank;
import com.jitterted.ebp.blackjack.Suit;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HandValueAceTest {

  private static final Suit DONT_CARE_SUIT = Suit.of(Suit.CLUBS);

  @Test
  public void handWithOneAceTwoCardsIsValuedAt11() throws Exception {
    Hand hand = createHandOfCardsWithArbitrarySuit("A", "5");

    assertThat(hand.value())
        .isEqualTo(11 + 5);
  }

  @Test
  public void handWithOneAceAndOtherCardsEqualTo11IsValuedAs1() throws Exception {
    Hand hand = createHandOfCardsWithArbitrarySuit("A", "8", "3");

    assertThat(hand.value())
        .isEqualTo(1 + 8 + 3);
  }

  @Test
  public void handWithOneAceAndOtherCardsEquals10AceIsValuedAs11() throws Exception {
    Hand hand = createHandOfCardsWithArbitrarySuit("A", "10");

    assertThat(hand.value())
        .isEqualTo(11 + 10);
  }

  @Test
  public void handWithOneAceAndOtherCardsEquals9AceIsValuedAs11() throws Exception {
    Hand hand = createHandOfCardsWithArbitrarySuit("A", "9");

    assertThat(hand.value())
        .isEqualTo(11 + 9);
  }

  private Hand createHandOfCardsWithArbitrarySuit(String... ranks) {
    List<Card> cards = new ArrayList<>();
    for (String rank : ranks) {
      cards.add(new Card(DONT_CARE_SUIT, Rank.of(rank)));
    }
    return new Hand(cards);
  }

}
