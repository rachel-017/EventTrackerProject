package com.skilldistillery.fighters.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public Fighter createFighter(@RequestBody Fighter fighter, HttpServletRequest req,
			HttpServletResponse res){
		try {
			fighter = fightSrv.createFighter(fighter);
			res.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(fighter.getId());
			res.setHeader("Location", url.toString());
		} catch (Exception e) {
			res.setStatus(400);
		}
		return fighter;
	}

	@PostMapping("fighters/{fid}")
	public Fighter updateFighter(@PathVariable Integer fid, @RequestBody Fighter fighter,
			HttpServletResponse res) {
		try {
			fighter = fightSrv.updateFighter(fid, fighter);
			if (fighter == null) {
				res.setStatus(404);
			}
			else {
				res.setStatus(200);
			}
		} catch (Exception e) {
			res.setStatus(400);
			fighter = null;
		}
		return fighter;
	}
	
	@DeleteMapping("fighters/{fid}")
	public void deleteFighter(@PathVariable Integer fid){
		Boolean deleted = fightSrv.deleteFighter(fid);
	}
}
