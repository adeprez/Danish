package fr.utt.lo02.danish.modele.carte;

import fr.utt.lo02.danish.modele.Symbole;

public class CarteDeux extends Carte {

	public CarteDeux(Symbole symbole) {
		super(symbole, 2);
	}

	@Override
	public boolean peutRecouvrir(Carte carte) {
		return true;
	}
	
}
