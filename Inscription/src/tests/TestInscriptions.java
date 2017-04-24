package tests;

import static org.junit.Assert.*;

import java.util.Set;

import junit.framework.TestCase;
import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

import org.junit.Test;

public class TestInscriptions extends TestCase{

//Competition c=i.CreateCompetition("foot","12/01/01",true);

Inscriptions i= Inscriptions.getInscriptions();
Competition co = i.createCompetition("Volley", null, false);
Equipe eq = i.createEquipe("EquipeTest");
Personne pe = i.createPersonne("TEST", "test", "tTEST@gmail.com");


@Test
public void testGetInscriptions()  {
	assertNotNull(i);
}

@Test
public void testreinitialiser(){
	i.reinitialiser();
	assertNotEquals(Inscriptions.getInscriptions(),i);
}

@Test
public void testGetCompetitions() {
	Set<Competition>setCompetitions=i.getCompetitions();
	assertFalse(setCompetitions.isEmpty());
}

@Test
public void testGetCandidats() {
	Set<Candidat> setCandidatTest = i.getCandidats();
	assertFalse(setCandidatTest.isEmpty());
}

@Test
public void testGetPersonnes() {
	Set<Personne> setPersonneTest =i.getPersonnes();
	assertFalse(setPersonneTest.isEmpty());
}

@Test
public void testGetEquipes() {
	Set<Equipe> setEquipeTest = i.getEquipes();
	assertFalse(setEquipeTest.isEmpty());
}

@Test
public void testCreateCompetition() {
	Competition co2 = i.createCompetition("Foot", null, false);
	Set <Competition> setCompetitionTest = i.getCompetitions();
	assertTrue(setCompetitionTest.contains(co2));
}

@Test
public void testCreatePersonne() {
	Personne pe1=i.createPersonne("Ticoire", "Elliot", "tricoireelliot@gmail.com");
	Set<Personne> setPersonneTest =i.getPersonnes();
	assertTrue(setPersonneTest.contains(pe1));
}

@Test
public void testCreateEquipe() {
	Equipe equipeTest2 = i.createEquipe("");
	Set<Candidat>setEquipeTest2 = i.getCandidats();
	assertTrue(setEquipeTest2.contains(equipeTest2));
}

@Test
public void testRemoveCompetition() {
	Set<Competition> setCompetitionTest = i.getCompetitions();
	co.delete();
	assertFalse(setCompetitionTest.contains(co));
}

@Test
public void testRemoveCandidat() {
	Set<Candidat>setCandidatTest=i.getCandidats();
	
	
}
}