package com.skilldistillery.fighters.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
