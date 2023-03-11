package com.example.demo.player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    @GetMapping
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    //method to add new player to database
    public void addNewPlayer(Player player){
        Optional<Player> playerOptional = playerRepository
                .findPlayerByEmail(player.getEmail());

        //if statement checks if email is already present on database
        //exception thrown if found
        if(playerOptional.isPresent()){
            throw new IllegalStateException("Email taken");
        }
        playerRepository.save(player);

        System.out.println(player);
    }

    //method to delete existing player from database
    public void deletePlayer(Long playerId){
        boolean playerExists = playerRepository.existsById(playerId);

        if(!playerExists){
            throw new IllegalStateException("Player with id "+ playerId+ " does not exist");
        }

        playerRepository.deleteById(playerId);
    }

    //Edit UserName
    @Transactional
    public void updatePlayer(Long playerId,
                             String username,
                             String email){
        //Find player with player id
        // or throw exception
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new IllegalStateException(
                        "Player with id "+ playerId + "does not exist"));

        //use if statement to check if name is empty and check if name in database
        //is the same as the name currently inputted
        //if not setUsername is used to change username in database
        if (username != null &&
                    username.length() > 0 &&
                    !Objects.equals(player.getUsername(),username)){
            Optional<Player> playerOptional = playerRepository.findPlayerByEmail(email);
            if (playerOptional.isPresent()){
                throw new IllegalStateException("Email taken");
            }
            player.setUsername(username);
        }

        //use if statement to check if email is empty and check if email in database
        //is the same as the email currently inputted
        //another if statement is used to check if the email is used for any other players
        //if email is found an exception is thrown
        //if not in both cases, setEmail is used to change email in database
        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(player.getEmail(),email)){
            player.setEmail(email);
        }
    }






}


