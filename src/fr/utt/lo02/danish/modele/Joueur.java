package fr.utt.lo02.danish.modele;

import java.util.ArrayList;
import java.util.List;

import fr.utt.lo02.danish.controleur.EcouteurJoueur;
import fr.utt.lo02.danish.modele.carte.Carte;

public class Joueur extends Ecoutable {
	private List<List<Carte>> cartes;
	private final String nom;


	public Joueur(String nom) {
		this.nom = nom;
		cartes = new ArrayList<List<Carte>>();
		for (int i = 0; i < Paquet.values().length; i++)
			cartes.add(new ArrayList<Carte>());
	}
	
	public void ajoutCarte(Paquet paquet, Carte carte) {
		if(getPaquet(paquet).add(carte)) {
			//notifier ajout carte
			for (final EcouteurJoueur l : getEcouteurs(EcouteurJoueur.class))
				l.ajouteCarte(this, carte);
		}
	}
	
	public void retireCarte(Paquet paquet, Carte carte) {
		if(getPaquet(paquet).remove(carte)) {
			//notifier suppression carte
			for (final EcouteurJoueur l : getEcouteurs(EcouteurJoueur.class))
				l.ajouteCarte(this, carte);
		}
	}
	
	public List<Carte> getPaquet(Paquet paquet) {
		return cartes.get(paquet.ordinal());
	}
	
	@Override
	public String toString() {
		return nom;
	}
	
	public enum Paquet {
		MAIN, CACHEES, VISIBLES;
		public static final int CARTES_PAR_PAQUET = 3;
	}
	
}
