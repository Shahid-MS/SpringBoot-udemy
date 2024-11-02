package com.ms.gaming;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ms.gaming.Game.GameRunner;
import com.ms.gaming.Game.GamingConsole;



public class Gameplay {

  public static void main(String[] args) {
  try(var context = new AnnotationConfigApplicationContext(GameConfiguration.class)){
    context.getBean(GamingConsole.class).up();
    context.getBean(GameRunner.class).run();
  }
  }
}
