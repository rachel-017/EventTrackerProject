package com.skilldistillery.fighters.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Fighter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;

	private int strength;
	
	private int speed;
	
	private int intelligence;
	
	private int health;
	
	@ManyToOne
	@JoinColumn(name="head_id")
	private Head head;
	
	@ManyToOne
	@JoinColumn(name="torso_id")
	private Torso torso;
	
	@ManyToOne
	@JoinColumn(name="legs_id")
	private Legs legs;
	
	
	
	

	public Fighter(int id, String name, int strength, int speed, int intelligence, int health, Head head, Torso torso,
			Legs legs) {
		super();
		this.id = id;
		this.name = name;
		this.strength = strength;
		this.speed = speed;
		this.intelligence = intelligence;
		this.health = health;
		this.head = head;
		this.torso = torso;
		this.legs = legs;
	}

	public Fighter() {}

	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	public Torso getTorso() {
		return torso;
	}

	public void setTorso(Torso torso) {
		this.torso = torso;
	}

	public Legs getLegs() {
		return legs;
	}

	public void setLegs(Legs legs) {
		this.legs = legs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fighter other = (Fighter) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fighter [id=" + id + ", name=" + name + ", strength=" + strength + ", speed=" + speed
				+ ", intelligence=" + intelligence + ", health=" + health + ", head=" + head.getType() + ", torso="
				+ torso.getType()
				+ ", legs=" + legs.getType() + "]";
	}
	
}
