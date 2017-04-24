package tests;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;
import inscriptions.*;

public class TestPersonne {
	
	Inscriptions inscriptionTest = Inscriptions.getInscriptions();
	Personne personneTest = inscriptionTest.createPersonne ("Elliot", "Sama", "Elliotsamma@gmail.com");
	

	@Test
	public void testDelete() {
		Equipe equipeTest = inscriptionTest.createEquipe("L'EQUIPE TEST");
		equipeTest.add(personneTest);
		Set<Equipe> setEquipesTest = personneTest.getEquipes();
		personneTest.delete();
		assertFalse(setEquipesTest.contains(personneTest));
	}

	@Test
	public void testGetPrenom() {
		assertEquals("Sama", personneTest.getPrenom());
	}

	@Test
	public void testSetPrenom() {
		personneTest.setPrenom("test1");
		assertEquals("test1", personneTest.getPrenom());
	}

	@Test
	public void testGetMail() {
		assertEquals("Elliotsamma@gmail.com", personneTest.getMail());
	}

	@Test
	public void testSetMail() {
		personneTest.setMail("Elliotsamma@gmail.com");
		assertEquals("Elliotsamma@gmail.com", personneTest.getMail());
	}

	@Test
	public void testGetEquipes() {
		Equipe equipeTest = inscriptionTest.createEquipe("L'EQUIPE TEST");
		equipeTest.add(personneTest);
		Set<Equipe> setEquipesTest = personneTest.getEquipes();
		assertTrue(setEquipesTest.contains(equipeTest));
	}

}