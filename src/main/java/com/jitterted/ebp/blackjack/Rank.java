package com.jitterted.ebp.blackjack;

public class Rank {
  private final String rank;

  public static Rank of(String rank) {
    return new Rank(rank);
  }

  public Rank(String rank) {
    this.rank = rank;
  }

  public String display() {
    return rank;
  }

  public int rankValue() {
    if (isFaceCard()) {
      return 10;
    } else if (isAce()) {
      return 1;
    }
    return numericValue();
  }

  private int numericValue() {
    return Integer.parseInt(rank);
  }

  private boolean isAce() {
    return rank.equals("A");
  }

  private boolean isFaceCard() {
    return "JQK".contains(rank);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Rank rank1 = (Rank) o;

    return rank.equals(rank1.rank);
  }

  @Override
  public int hashCode() {
    return rank.hashCode();
  }
}
