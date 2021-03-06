package com.jitterted.ebp.blackjack;

public enum GameOutcome {
  PLAYER_LOSES(0),
  PLAYER_PUSHES(1),
  PLAYER_WINS(2),
  PLAYER_BLACKJACK(2.5);

  private final double payoffMultiplier;

  GameOutcome(double payoffMultiplier) {
    this.payoffMultiplier = payoffMultiplier;
  }

  public double payoffMultiplier() {
    return payoffMultiplier;
  }

}
