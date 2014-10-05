package fr.utt.lo02.danish.modele.carte;

import fr.utt.lo02.danish.modele.Joueur;
import fr.utt.lo02.danish.modele.Partie;
import fr.utt.lo02.danish.modele.Symbole;
import fr.utt.lo02.danish.modele.action.ActionEnvoiTas;

public class CarteAs extends Carte {

	public CarteAs(Symbole symbole) {
		super(symbole, AS);
	}

	@Override
	public void faireEffet(Partie partie) {
		for (final Joueur joueur : partie.getJoueurs().getJoueurs())
			partie.getTour().ajouteAction(new ActionEnvoiTas(joueur));
	}
	
}
