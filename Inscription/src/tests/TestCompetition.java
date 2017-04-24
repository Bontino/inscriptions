package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Set;

import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;
import inscriptions.Candidat;

import org.junit.Test;

public class TestCompetition {
	Inscriptions i = Inscriptions.getInscriptions();
	Competition co = i.createCompetition("volley", null, true);
	Personne pe=i.createPersonne("Felana", "Manyado", "fefe@gmail.com");
	Equipe eq=i.createEquipe("Fefe");
	


	@Test
	public void testGetNom() {
		assertNotNull(co.getNom());
	}

	@Test
	public void testSetNom() {
		String anciennom = co.getNom(); 
		co.setNom("football");
		assertNotEquals(anciennom,co.getNom());
	}

	@Test
	public void testInscriptionsOuvertes() {
		assert(co.inscriptionsOuvertes());
	}

	@Test
	public void testGetDateCloture() {
		assertEquals(null,co.getDateCloture());
	}

	@Test
	public void testEstEnEquipe() {
		assertNotNull(co.estEnEquipe());
	}

	@Test
	public void testSetDateCloture() {
		LocalDate olddate = co.getDateCloture();
		LocalDate newdate = LocalDate.of(2016, 12, 3);
		assertNotEquals(olddate,newdate);
	}

	@Test
	public void testGetCandidats() {
		assertNotNull(co.getCandidats());
	}

	
	@Test
	public void testAddPersonne() {
		co.add(eq);
		Set<Candidat>setCandidatTest = co.getCandidats();
		assertTrue(setCandidatTest.contains(eq));

	}

	@Test
	public void testAddEquipe() {
		assert(co.add(eq));
	}

	@Test
	public void testRemove() {
		Equipe eq2 = i.createEquipe("Phoenix");
		co.add(eq);
		co.add(eq2);
		Set<Candidat>setCandidatTest =co.getCandidats();
		co.remove(eq2);
		assertFalse(setCandidatTest.contains(eq2));
	}

	@Test
	public void testDelete() {
		co=i.createCompetition("volley", null, true);
		co.delete();
		Set<Competition> setCompetitionTest = i.getCompetitions();
		assertFalse(setCompetitionTest.contains(co));
	}

	@Test
	public void testCompareTo() {
		Competition co2 = i.createCompetition("volley", null, true);
		assertTrue(co.compareTo(co2)== 0);

	}
}
