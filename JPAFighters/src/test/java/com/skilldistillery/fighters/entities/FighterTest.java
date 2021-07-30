package com.skilldistillery.fighters.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FighterTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Fighter fighter;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPAFighters");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		fighter = em.find(Fighter.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		fighter = null;
		em.close();
	}

	@Test
	@DisplayName("testing fighter mapping")
	void test() {
		assertNotNull(fighter);
		assertEquals("Boulder", fighter.getName());
		assertEquals(1, fighter.getId());
	}
	
	@Test
	@DisplayName("testing fighter to head torso and legs mapping")
	void test1() {
		assertNotNull(fighter);
		assertEquals("bear", fighter.getHead().getType());
		assertEquals("lion", fighter.getTorso().getType());
		assertEquals("bear", fighter.getLegs().getType());
	}
}
