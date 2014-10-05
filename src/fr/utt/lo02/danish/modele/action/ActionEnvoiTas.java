package fr.utt.lo02.danish.modele.action;

import fr.utt.lo02.danish.modele.Joueur;
import fr.utt.lo02.danish.modele.Partie;
import fr.utt.lo02.danish.modele.Joueur.Paquet;
import fr.utt.lo02.danish.modele.carte.Carte;

public class ActionEnvoiTas implements Action {
	private Joueur joueur;

	
	public ActionEnvoiTas(Joueur joueur) {
		this.joueur = joueur;
	}
	
	@Override
	public void faireEffet(Partie partie) {
		Carte c;
		while((c = partie.getPlateau().retireTas()) != null)
			joueur.ajoutCarte(Paquet.MAIN, c);
	}

	@Override
	public String toString() {
		return "Donner le tas à " + joueur;
	}
	
}
