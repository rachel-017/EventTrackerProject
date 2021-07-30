package com.skilldistillery.fighters.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Head {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="head_type")
	private String type;

	@OneToMany(mappedBy="head")
	private List<Fighter> fighters;
	
	
	
	public Head() {
		
	}
	
	public Head(int id, String type) {
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

	public List<Fighter> getFighters() {
		return fighters;
	}

	public void setFighters(List<Fighter> fighters) {
		this.fighters = fighters;
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
		Head other = (Head) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Head [id=" + id + ", type=" + type + "]";
	}

}
