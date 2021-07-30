package com.skilldistillery.fighters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.fighters.entities.Fighter;

public interface FighterRepository extends JpaRepository<Fighter, Integer>{

	
}
