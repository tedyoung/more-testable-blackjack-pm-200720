package com.jitterted.ebp.blackjack.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WalletTest {

  @Test
  public void newWalletIsEmpty() throws Exception {
    Wallet wallet = new Wallet();

    assertThat(wallet.isEmpty())
        .isTrue();
  }

  @Test
  public void newWalletWithAddedMoneyIsNotEmpty() throws Exception {
    Wallet wallet = new Wallet();
    wallet.addMoney(7);

    assertThat(wallet.isEmpty())
        .isFalse();
  }

  @Test
  public void add10DollarsToWalletResultsInWalletHaving10Dollars() throws Exception {
    Wallet wallet = new Wallet();

    wallet.addMoney(10);

    assertThat(wallet.balance())
        .isEqualTo(10);
  }

  @Test
  public void add5DollarsToWalletWith10DollarsResultsInWalletHaving15Dollars() throws Exception {
    // Given When Then
    Wallet wallet = new Wallet();
    wallet.addMoney(10);

    wallet.addMoney(5);

    assertThat(wallet.balance())
        .isEqualTo(15);
  }
}
