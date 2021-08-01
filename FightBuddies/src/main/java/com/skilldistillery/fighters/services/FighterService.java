package com.skilldistillery.fighters.services;

import java.util.List;

import com.skilldistillery.fighters.entities.Fighter;

public interface FighterService {
	
	List<Fighter> allFighters();

	Fighter showFighter(int fid);
	
	Fighter createFighter(Fighter fighter);
	
	Fighter updateFighter(int fid, Fighter fighter);
	
	boolean deleteFighter(int fid);
}
