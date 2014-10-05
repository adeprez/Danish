package fr.utt.lo02.danish.controleur;

import java.util.EventListener;

import fr.utt.lo02.danish.modele.Joueur;
import fr.utt.lo02.danish.modele.carte.Carte;

public interface EcouteurJoueur extends EventListener {
	public void ajouteCarte(Joueur joueur, Carte carte);
	public void retireCarte(Joueur joueur, Carte carte);
}
