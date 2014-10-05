package fr.utt.lo02.danish.controleur;

import java.util.EventListener;

import fr.utt.lo02.danish.modele.Joueur;

public interface EcouteurListeJoueur extends EventListener {
	public void ajouteJoueur(Joueur joueur);
	public void retireJoueur(Joueur joueur);
}
