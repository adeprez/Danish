package fr.utt.lo02.danish.modele.carte;

import fr.utt.lo02.danish.modele.Partie;
import fr.utt.lo02.danish.modele.Symbole;

public class CarteDix extends Carte {

	public CarteDix(Symbole symbole) {
		super(symbole, 10);
	}
	
	@Override
	public void faireEffet(Partie partie) {
		partie.getPlateau().getTas().clear();
		partie.getPlateau().getTas().add(this);
	}

}
