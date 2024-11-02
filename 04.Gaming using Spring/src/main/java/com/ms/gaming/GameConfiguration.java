package com.ms.gaming;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ms.gaming.Game.GameRunner;
import com.ms.gaming.Game.GamingConsole;
import com.ms.gaming.Game.MarioGame;

@Configuration
public class GameConfiguration {
    @Bean
    public GamingConsole game(){
        var game = new MarioGame();
        return game;
    }

    @Bean
    public GameRunner gameRunner (){
        var gameRunner = new GameRunner(game());
        return gameRunner;
    }
}
