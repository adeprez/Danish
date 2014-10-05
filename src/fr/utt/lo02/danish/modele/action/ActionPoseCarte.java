package fr.utt.lo02.danish.modele.action;

import fr.utt.lo02.danish.modele.Partie;
import fr.utt.lo02.danish.modele.Joueur.Paquet;
import fr.utt.lo02.danish.modele.carte.Carte;

public class ActionPoseCarte implements Action {
	private Carte carte;

	
	public ActionPoseCarte(Carte carte) {
		this.carte = carte;
	}
	
	@Override
	public void faireEffet(Partie partie) {
		partie.poser(Paquet.MAIN, carte);
	}

	@Override
	public String toString() {
		return "poser " + carte;
	}
	
}
