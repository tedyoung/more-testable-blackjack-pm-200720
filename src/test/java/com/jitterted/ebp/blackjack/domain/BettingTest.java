package com.jitterted.ebp.blackjack.domain;

import com.jitterted.ebp.blackjack.Game;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BettingTest {

  @Test
  public void newGamePlayerStartsWith100Dollars() throws Exception {
    Game game = new Game();

    assertThat(game.playerBalance())
        .isEqualTo(100);
  }

  @Test
  public void playerBets10BalanceRemainingIs90() throws Exception {
    Game game = new Game();

    game.playerBets(10);

    assertThat(game.playerBalance())
        .isEqualTo(90);
  }

  @Test
  public void playerWins10BetBalanceBecomes110() throws Exception {
    Game game = new Game();
    game.playerBets(10);

    game.playerWins();

    assertThat(game.playerBalance())
        .isEqualTo(110);
  }
}
