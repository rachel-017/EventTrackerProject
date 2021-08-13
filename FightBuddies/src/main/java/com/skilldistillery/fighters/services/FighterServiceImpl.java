package com.skilldistillery.fighters.services;

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
		return repo.findAll();
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
		Optional<Fighter> fighterOpt = repo.findById(fid);
		if (fighterOpt.isPresent()) {
			Fighter managed = fighterOpt.get();
			managed.setHead(fighter.getHead());
			managed.setHealth(fighter.getHealth());
			managed.setLegs(fighter.getLegs());
			managed.setTorso(fighter.getTorso());
			managed.setName(fighter.getName());
			managed.setIntelligence(fighter.getIntelligence());
			managed.setSpeed(fighter.getSpeed());
			managed.setStrength(fighter.getStrength());
//			if (fighter.getLanguage() != null) {
//				managed.setLanguage(fighter.getLanguage());
//			}
			repo.saveAndFlush(managed);
			return managed;
		}
		return null;
	}
	
	
	@Override
	public boolean deleteFighter(int fid) {
		boolean deleted = false;
		if (repo.existsById(fid)) {
			repo.deleteById(fid);
			deleted = true;
		}
		return deleted;
	}
}
