package fr.utt.lo02.danish.modele;

import java.util.Collections;
import java.util.List;

import fr.utt.lo02.danish.controleur.EcouteurPartie;
import fr.utt.lo02.danish.modele.Joueur.Paquet;
import fr.utt.lo02.danish.modele.carte.Carte;

public class Partie extends Ecoutable {
	private final ListeJoueurs joueurs;
	private PlateauJeu plateau;
	private Tour tour;

	
	public Partie(ListeJoueurs joueurs) {
		this.joueurs = joueurs;
	}
	
	public void lancer() {
		List<Carte> cartes = Carte.creerPaquet(joueurs.getJoueurs().size() < 6 ? 1 : 2);
		Collections.shuffle(cartes);
		for (Joueur j : joueurs.getJoueurs())
			for (final Paquet paquet : Paquet.values())
				for (int k = 0; k < Joueur.Paquet.CARTES_PAR_PAQUET; k++)
					j.ajoutCarte(paquet, cartes.remove(0));
		plateau = new PlateauJeu(cartes);
		//Notifier debut partie
		for (final EcouteurPartie e : getEcouteurs(EcouteurPartie.class))
			e.commence(this);
		nouveauTour();
	}
	
	public void nouveauTour() {
		tour = new Tour(this, joueurs.getJoueurSuivant(tour == null ? 
				joueurs.getJoueurs().get(0) : tour.getJoueur()));
		//Notifier nouveau tour
		for (final EcouteurPartie e : getEcouteurs(EcouteurPartie.class))
			e.nouveauTour(tour);
	}

	public ListeJoueurs getJoueurs() {
		return joueurs;
	}

	public PlateauJeu getPlateau() {
		return plateau;
	}

	public Tour getTour() {
		return tour;
	}

	public void poser(Paquet paquet, Carte carte) {
		tour.getJoueur().retireCarte(Paquet.MAIN, carte);
		plateau.ajoutTas(carte);
	}
	
	public void piocher() {
		tour.getJoueur().ajoutCarte(Paquet.MAIN, plateau.retirePioche());
	}
	
	

}
