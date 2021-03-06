package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Set;
import inscriptions.Inscriptions;

import inscriptions.*;

public class TestEquipe {
	Inscriptions inscriptionTest = Inscriptions.getInscriptions();
	Equipe equipeTest = inscriptionTest.createEquipe("L'EQUIPE TEST");
	Personne personneTest = inscriptionTest.createPersonne("felana", "fefe","fefe@gmail.com");

	@Test
	public void testGetMembres() {
		Set<Personne> setMembresTest = equipeTest.getMembres();
		equipeTest.add(personneTest);
		assertEquals(setMembresTest, equipeTest.getMembres());
	}

	@Test
	public void testAddPersonne() {
		Set<Personne> setMembresTest = equipeTest.getMembres();
		equipeTest.add(personneTest);
		assertTrue(setMembresTest.contains(personneTest));
		assertTrue(personneTest.getEquipes().contains(equipeTest));
	}

	@Test
	public void testRemovePersonne() {
		Set<Personne> setMembresTest = equipeTest.getMembres();
		equipeTest.add(personneTest);
		equipeTest.remove(personneTest);
		assertFalse(setMembresTest.contains(personneTest));
	}
}