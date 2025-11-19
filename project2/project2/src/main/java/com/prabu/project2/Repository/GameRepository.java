package com.prabu.project2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prabu.project2.entities.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

}
