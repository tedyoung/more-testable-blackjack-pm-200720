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

  @Test
  public void playerBets25AndLosesBalanceIs75() throws Exception {
    Game game = new Game();
    game.playerBets(25);

    game.playerLoses();

    assertThat(game.playerBalance())
        .isEqualTo(75);
  }

  @Test
  public void playerBets50AndGetsBlackjackBalanceIs175() throws Exception {
    Game game = new Game();
    game.playerBets(50);

    game.playerWinsBlackjack();

    assertThat(game.playerBalance())
        .isEqualTo(50 + (int) (50 * 2.5));
  }

  @Test
  public void playerBets35AndPushesResultsInSameAsStartingBalance() throws Exception {
    Game game = new Game();
    int initialBalance = game.playerBalance();
    game.playerBets(35);

    game.playerPushes();

    assertThat(game.playerBalance())
        .isEqualTo(initialBalance);
  }

}
