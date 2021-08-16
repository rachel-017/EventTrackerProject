package com.skilldistillery.fighters.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.fighters.entities.Fighter;
import com.skilldistillery.fighters.repositories.FighterRepository;

@Service
public class FighterServiceImpl implements FighterService{

	@Autowired
	private FighterRepository repo;
	
	
	@Override
	public List<Fighter> allFighters() {
		List<Fighter> fighters = new ArrayList<Fighter>();
		fighters.addAll(repo.findAll());
		return fighters;
	}
	
	
	@Override
	public Fighter showFighter(int fid) {
		Fighter fighter = null;
		Optional<Fighter> fighterOpt = repo.findById(fid);
		if (fighterOpt.isPresent()) {
			fighter = fighterOpt.get();
		}
		return fighter;
	}
	
	
	@Override
	public Fighter createFighter(Fighter fighter) {
		
		return repo.saveAndFlush(fighter);
	}
	
	
	@Override
	public Fighter updateFighter(int fid, Fighter fighter) {
		
		fighter.setId(fid);
		return repo.saveAndFlush(fighter);
	}
	
	
	@Override
	public boolean deleteFighter(int fid) {
		repo.deleteById(fid);
		return !repo.findById(fid).isPresent();
	}
}
