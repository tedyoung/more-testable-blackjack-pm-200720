package com.jitterted.ebp.blackjack.domain;

import com.jitterted.ebp.blackjack.Hand;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class HandValueAceTest {

  @Test
  public void handWithOneAceTwoCardsIsValuedAt11() throws Exception {
    Hand hand = StubHandFactory.createHandOfCardsWithArbitrarySuit("A", "5");

    assertThat(hand.value())
        .isEqualTo(11 + 5);
  }

  @Test
  public void handWithOneAceAndOtherCardsEqualTo11IsValuedAs1() throws Exception {
    Hand hand = StubHandFactory.createHandOfCardsWithArbitrarySuit("A", "8", "3");

    assertThat(hand.value())
        .isEqualTo(1 + 8 + 3);
  }

  @Test
  public void handWithOneAceAndOtherCardsEquals10AceIsValuedAs11() throws Exception {
    Hand hand = StubHandFactory.createHandOfCardsWithArbitrarySuit("A", "10");

    assertThat(hand.value())
        .isEqualTo(11 + 10);
  }

  @Test
  public void handWithOneAceAndOtherCardsEquals9AceIsValuedAs11() throws Exception {
    Hand hand = StubHandFactory.createHandOfCardsWithArbitrarySuit("A", "9");

    assertThat(hand.value())
        .isEqualTo(11 + 9);
  }

}
