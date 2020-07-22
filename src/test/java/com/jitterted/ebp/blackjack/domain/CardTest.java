package com.jitterted.ebp.blackjack.domain;

import com.jitterted.ebp.blackjack.Card;
import com.jitterted.ebp.blackjack.Rank;
import com.jitterted.ebp.blackjack.Suit;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.fusesource.jansi.Ansi.ansi;

class CardTest {

  private static final Suit DONT_CARE_SUIT = Suit.of(Suit.HEARTS);

  @Test
  public void withNumberCardHasNumericValueOfTheNumber() throws Exception {
    Card card = new Card(DONT_CARE_SUIT, Rank.of("7"));

    assertThat(card.rankValue())
        .isEqualTo(7);
  }

  @Test
  public void withValueOfQueenHasNumericValueOf10() throws Exception {
    Card card = new Card(DONT_CARE_SUIT, Rank.of("Q"));

    assertThat(card.rankValue())
        .isEqualTo(10);
  }

  @Test
  public void withAceHasNumericValueOf1() throws Exception {
    Card card = new Card(DONT_CARE_SUIT, Rank.of("A"));

    assertThat(card.rankValue())
        .isEqualTo(1);
  }


}