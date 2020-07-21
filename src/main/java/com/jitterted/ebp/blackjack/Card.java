package com.jitterted.ebp.blackjack;

import org.fusesource.jansi.Ansi;

import static org.fusesource.jansi.Ansi.ansi;

public class Card {
  private final Suit suit;
  private final String rank;

  public Card(Suit suit, String rank) {
    this.suit = suit;
    this.rank = rank;
  }

  // how to refactor?
  // 1. Refactor to an Enum
  // 2. Switch case
  // 3. Map
  // 4. Rank?

  // information known at compile-time or at run-time

  // YAGNI

  // discussing & reasoning --> code it

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

  public String display() {
    String[] lines = new String[7];
    lines[0] = "┌─────────┐";
    lines[1] = String.format("│%s%s       │", rank, rank.equals("10") ? "" : " ");
    lines[2] = "│         │";
    lines[3] = String.format("│    %s    │", suit);
    lines[4] = "│         │";
    lines[5] = String.format("│       %s%s│", rank.equals("10") ? "" : " ", rank);
    lines[6] = "└─────────┘";

    Ansi.Color cardColor = suit.color();
    return ansi()
        .fg(cardColor).toString()
        + String.join(ansi().cursorDown(1)
                            .cursorLeft(11)
                            .toString(), lines);
  }

  @Override
  public String toString() {
    return "Card {" +
        "suit=" + suit +
        ", rank=" + rank +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Card card = (Card) o;

    if (!suit.equals(card.suit)) return false;
    return rank.equals(card.rank);
  }

  @Override
  public int hashCode() {
    int result = suit.hashCode();
    result = 31 * result + rank.hashCode();
    return result;
  }
}
