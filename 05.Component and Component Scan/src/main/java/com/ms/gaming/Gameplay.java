package com.ms.gaming;

import com.ms.gaming.Game.GameRunner;
import com.ms.gaming.Game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.ms.gaming.Game")
public class Gameplay {

  public static void main(String[] args) {
    try (var context = new AnnotationConfigApplicationContext(Gameplay.class)) {
      context.getBean(GamingConsole.class).up();
      context.getBean(GameRunner.class).run();
    }
  }
}
