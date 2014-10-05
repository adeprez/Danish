package fr.utt.lo02.danish.modele.carte;

import fr.utt.lo02.danish.modele.Symbole;

public class CarteSept extends Carte {

	public CarteSept(Symbole symbole) {
		super(symbole, 7);
	}
	
	@Override
	public boolean controlePrioritaire() {
		return true;
	}
	
	@Override
	protected boolean peutEtreRecouvertePar(Carte carte) {
		return carte.getNumero() <= getNumero();
	}
	
}
