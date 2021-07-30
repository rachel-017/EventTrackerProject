package com.skilldistillery.fighters.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.fighters.entities.Fighter;
import com.skilldistillery.fighters.repositories.FighterRepository;

@Service
public class FighterServiceImpl implements FighterService{

	@Autowired
	private FighterRepository fightRepo;
	
	public List<Fighter> allFighters(){
		return fightRepo.findAll();
	}
}
