package fr.utt.lo02.danish.modele;

import java.util.ArrayList;
import java.util.List;

import fr.utt.lo02.danish.controleur.EcouteurTour;
import fr.utt.lo02.danish.modele.Joueur.Paquet;
import fr.utt.lo02.danish.modele.action.Action;
import fr.utt.lo02.danish.modele.action.ActionPioche;
import fr.utt.lo02.danish.modele.action.ActionPoseCarte;
import fr.utt.lo02.danish.modele.carte.Carte;

public class Tour extends Ecoutable {
	private List<Action> actions;
	private final Partie partie;
	private final Joueur joueur;

	
	public Tour(Partie partie, Joueur joueur) {
		this.partie = partie;
		this.joueur = joueur;
		actions = new ArrayList<Action>();
		ajouteActionsPoseCarte();
		if(actions.isEmpty())
			ajouteAction(new ActionPioche());
	}
	
	public void ajouteActionsPoseCarte() {
		for (final Carte c : joueur.getPaquet(Paquet.MAIN))
			if(partie.getPlateau().peutEtrePosee(c))
				ajouteAction(new ActionPoseCarte(c));
	}

	public Partie getPartie() {
		return partie;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void ajouteAction(Action action) {
		actions.add(action);
	}
	
	public List<Action> getActions() {
		return actions;
	}
	
	public void faireAction(int index) {
		Action a = actions.get(index);
		actions.clear();
		a.faireEffet(partie);
		ajouteActionsPoseCarte();
		boolean fini = actions.isEmpty();
		for (EcouteurTour e : getEcouteurs(EcouteurTour.class))
			e.faitAction(this, a, fini);
		if(fini)
			partie.nouveauTour();
	}
	
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < actions.size(); i++) {
			s += "(" + (i + 1) + ") " + actions.get(i) + "\n";
		}
		return s;
	}	
	
}
