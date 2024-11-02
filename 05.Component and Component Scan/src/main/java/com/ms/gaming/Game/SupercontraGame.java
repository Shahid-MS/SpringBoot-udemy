package com.ms.gaming.Game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Supercontra Qualifier")
public class SupercontraGame implements GamingConsole {
    public void up() {
        System.out.println("Upside");
      }
    
      public void down() {
        System.out.println("Downside");
      }
    
      public void right() {
        System.out.println("Rightside Turn");
      }
    
      public void left() {
        System.out.println("Leftside Turn");
      }
}
