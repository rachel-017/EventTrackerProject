package com.skilldistillery.fighters.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.fighters.entities.Fighter;
import com.skilldistillery.fighters.services.FighterService;

@RequestMapping("api")
@RestController
public class FighterController {

	@Autowired
	private FighterService fightSrv;
	
	
	
	@GetMapping("fighters")
	public List<Fighter> listFighters(){
	return fightSrv.allFighters();
	}
	
	@GetMapping("fighters/{fid}")
	public Fighter getById(@PathVariable Integer fid){
		Fighter film = fightSrv.showFighter(fid);
		return film;
	}
	
	@PostMapping("fighters")
	public Fighter createFighter(@RequestBody Fighter fighter){
		return fightSrv.createFighter(fighter);
	}

	@PostMapping("fighters/{fid}")
	public Fighter updateFighter(@PathVariable Integer fid, @RequestBody Fighter fighter){
		fighter = fightSrv.updateFighter(fid, fighter);
		return fighter;
	}
	
	@DeleteMapping("fighters/{fid}")
	public void deleteFighter(@PathVariable Integer fid){
		Boolean deleted = fightSrv.deleteFighter(fid);
	}
}
