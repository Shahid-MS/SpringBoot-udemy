package com.ms.gaming;

import com.ms.gaming.Game.GameRunner;
import com.ms.gaming.Game.MarioGame;
import com.ms.gaming.Game.SupercontraGame;

public class Gameplay {

  public static void main(String[] args) {
    var marioGame = new MarioGame();
    var supercontraGame = new SupercontraGame();
    var gameRunner = new GameRunner(marioGame);
    // This will not run as high coupled
    var gameRunner2 = new GameRunner(supercontraGame);

    gameRunner.run();
    gameRunner2.run();
  }
}
