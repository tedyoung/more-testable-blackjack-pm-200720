package com.jitterted.ebp.blackjack;

import org.fusesource.jansi.Ansi;

import java.util.List;

public class Suit {
  public static final String HEARTS = "♥";
  public static final String CLUBS = "♣";
  private String suit;

  public Suit(String suit) {
    this.suit = suit;
  }

  public static Suit of(String suit) {
    return new Suit(suit);
  }

  public static List<Suit> allSuits() {
    return List.of(Suit.of("♠"), Suit.of("♦"), Suit.of("♥"), Suit.of("♣"));
  }

  public Ansi.Color color() {
    return "♥♦".contains(suit) ? Ansi.Color.RED : Ansi.Color.BLACK;
  }

  public String getSuit() {
    return suit;
  }

  public void setSuit(String suit) {
    this.suit = suit;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Suit suit1 = (Suit) o;

    return suit.equals(suit1.suit);
  }

  @Override
  public int hashCode() {
    return suit.hashCode();
  }

  @Override
  public String toString() {
    return "Suit{" +
        "suit='" + suit + '\'' +
        '}';
  }
}
