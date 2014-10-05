package fr.utt.lo02.danish.modele;

import java.util.ArrayList;
import java.util.List;

import fr.utt.lo02.danish.controleur.EcouteurListeJoueur;

public class ListeJoueurs extends Ecoutable {
	private final List<Joueur> joueurs;
	private int passeTour;
	
	
	public ListeJoueurs() {
		joueurs = new ArrayList<Joueur>();
	}
	
	public void ajouterJoueur(Joueur joueur) {
		joueurs.add(joueur);
		//notifier ajout joueur
		for (final EcouteurListeJoueur l : getEcouteurs(EcouteurListeJoueur.class))
			l.ajouteJoueur(joueur);
	}
	
	public void retirerJoueur(int indexJoueur) {
		Joueur j = joueurs.remove(indexJoueur);
		//notifier suppression joueur
		for (final EcouteurListeJoueur l : getEcouteurs(EcouteurListeJoueur.class))
			l.retireJoueur(j);
	}
	
	public Joueur getJoueurSuivant(Joueur joueur) {
		Joueur j = joueurs.get((joueurs.indexOf(joueur) + passeTour + 1) % joueurs.size());
		passeTour = 0;
		return j;
	}
	
	public void ajoutPasseTour() {
		passeTour++;
	}
	
	public List<Joueur> getJoueurs() {
		return joueurs;
	}
	
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < joueurs.size(); i++) {
			s += "(" + (i + 1) + ") " + joueurs.get(i) + "\n";
		}
		return s;
	}
	
}
