package com.jitterted.ebp.blackjack.domain;

import com.jitterted.ebp.blackjack.Suit;
import org.fusesource.jansi.Ansi;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SuitColorTest {

  @Test
  public void heartsHasColorRed() throws Exception {
    Suit hearts = Suit.of(Suit.HEARTS);

    assertThat(hearts.color())
        .isEqualTo(Ansi.Color.RED);
  }

  @Test
  public void clubsHasColorBlack() throws Exception {
    Suit clubs = Suit.of(Suit.CLUBS);

    assertThat(clubs.color())
        .isEqualTo(Ansi.Color.BLACK);
  }

}
