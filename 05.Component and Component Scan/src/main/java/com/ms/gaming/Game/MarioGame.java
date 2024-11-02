package com.ms.gaming.Game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MarioGame implements GamingConsole {

  public void up() {
    System.out.println("Up");
  }

  public void down() {
    System.out.println("Down");
  }

  public void right() {
    System.out.println("Right Turn");
  }

  public void left() {
    System.out.println("Left Turn");
  }
}
