package com.skilldistillery.fighters.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Legs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="legs_type")
	private String type;

	@OneToMany(mappedBy="legs")
	private List<Fighter> fighters;
	
	
	
	public Legs() {}
	
	public Legs(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	
	public List<Fighter> getFighters() {
		return fighters;
	}

	public void setFighters(List<Fighter> fighters) {
		this.fighters = fighters;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Legs other = (Legs) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Legs [id=" + id + ", type=" + type + "]";
	}

}
