package com.example.demo.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository
        extends JpaRepository<Player, Long> {

    //Find out if user email already exists on the database

    @Query("SELECT s FROM Player s WHERE s.email = ?1")
    Optional<Player> findPlayerByEmail(String email);

}

