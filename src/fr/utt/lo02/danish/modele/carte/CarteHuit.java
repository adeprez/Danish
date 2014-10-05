package fr.utt.lo02.danish.modele.carte;

import fr.utt.lo02.danish.modele.Partie;
import fr.utt.lo02.danish.modele.Symbole;

public class CarteHuit extends Carte {

	
	public CarteHuit(Symbole symbole) {
		super(symbole, 8);
	}
	
	@Override
	public void faireEffet(Partie partie) {
		partie.getJoueurs().ajoutPasseTour();
	}

}
