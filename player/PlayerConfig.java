package com.example.demo.player;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.*;

@Configuration
public class PlayerConfig {

    @Bean
    CommandLineRunner commandLineRunner(PlayerRepository repository ){
        return args -> {
           Player player1 =  new Player(
                   "Player1",
                    "Player1@email.com",
                    "password123"
                );

            Player player2 =  new Player(
                     "Player12",
                    "Player2@email.com",
                    "password124"
            );
            repository.saveAll(
                    List.of(player1,player2)
            );

        };
    }
}
