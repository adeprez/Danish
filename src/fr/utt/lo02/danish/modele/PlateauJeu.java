package fr.utt.lo02.danish.modele;

import java.util.ArrayList;
import java.util.List;

import fr.utt.lo02.danish.modele.carte.Carte;

public class PlateauJeu {
	private final List<Carte> pioche, tas;


	public PlateauJeu(List<Carte> cartes) {
		this.pioche = cartes;
		tas = new ArrayList<Carte>();
	}
	
	public boolean peutEtrePosee(Carte carte) {
		return tas.isEmpty() || carte.peutRecouvrir(tas.get(0));
	}

	public List<Carte> getPioche() {
		return pioche;
	}

	public List<Carte> getTas() {
		return tas;
	}
	
	public Carte ajoutTas(Carte carte) {
		tas.add(0, carte);
		return carte;
	}
	
	public Carte retirePioche() {
		if(tas.isEmpty())
			return null;
		Carte c = tas.get(0);
		tas.remove(0);
		return c;
	}
	
	public Carte retireTas() {
		if(tas.isEmpty())
			return null;
		Carte c = tas.get(0);
		tas.remove(0);
		return c;
	}
	
	
	
}
