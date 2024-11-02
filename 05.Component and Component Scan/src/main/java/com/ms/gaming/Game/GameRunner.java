package com.ms.gaming.Game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

  GamingConsole game;

  public GameRunner(@Qualifier("Supercontra Qualifier") GamingConsole game) {
    this.game = game;
  }

  public void run() {
    System.out.println("Game : " + game);
    game.up();
    game.down();
    game.left();
    game.right();
  }
}
