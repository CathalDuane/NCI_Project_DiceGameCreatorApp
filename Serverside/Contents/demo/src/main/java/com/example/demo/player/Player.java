package com.example.demo.player;

import javax.persistence.*;

@Entity
@Table
public class Player {

    @Id
    @SequenceGenerator(
            name = "player_sequence",
            sequenceName = "player_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
           strategy = GenerationType.SEQUENCE,
            generator ="player_sequence"
    )
    //Data for user table
    private Long playerId;
    private String username;
    private String email;
    private String password;

    //Contructors
    public Player(){

    }

    public Player(Long id, String username, String email, String password) {
        this.playerId = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    //Contructers without id
    public Player(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    //Getters and Setters
    public Long getId() {
        return playerId;
    }

    public void setId(Long id) {
        this.playerId = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //ToString() to print data
    @Override
    public String toString() {
        return "User{" +
                "playerId=" + playerId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
