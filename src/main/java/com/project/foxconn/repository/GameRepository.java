package com.project.foxconn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.foxconn.model.Game;


public interface GameRepository extends JpaRepository<Game,Integer> {

}
