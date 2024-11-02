package com.ms.gaming.Game;

public class GameRunner {

  GamingConsole game;

  public GameRunner(GamingConsole game) {
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
