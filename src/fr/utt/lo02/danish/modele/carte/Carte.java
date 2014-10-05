package fr.utt.lo02.danish.modele.carte;

import java.util.ArrayList;
import java.util.List;

import fr.utt.lo02.danish.modele.Partie;
import fr.utt.lo02.danish.modele.Symbole;
import fr.utt.lo02.danish.modele.Tour;


public class Carte {
	public static final int AS = 1, VALET = 11, DAME = 12, ROI = 13;
	private final Symbole symbole;
	private final int numero;
	
	
	public Carte(Symbole symbole, int numero) {
		this.symbole = symbole;
		this.numero = numero;
	}

	public Symbole getSymbole() {
		return symbole;
	}

	public int getNumero() {
		return numero;
	}
	
	public boolean controlePrioritaire() {
		return false;
	}
	
	protected boolean peutEtreRecouvertePar(Carte carte) {
		return numero <= carte.numero;
	}
	
	public boolean peutRecouvrir(Carte carte) {
		return carte.controlePrioritaire() ? carte.peutEtreRecouvertePar(this) 
				: numero >= carte.numero;
	}
	
	public void faireEffet(Partie partie) {
		
	}
	
	public String getNom() {
		switch(numero) {
		case AS: 
			return "As";
		case VALET: 
			return "Valet";
		case DAME: 
			return "Dame";
		case ROI: 
			return "Roi";
		default: 
			return numero + "";
		}
	}

	@Override
	public String toString() {
		return getNom() + " de " + symbole.toString().toLowerCase();
	}
	
	public static Carte creerCarte(Symbole symbole, int numero) {
		switch(numero) {
		case 2:
			return new CarteDeux(symbole);
		case 7:
			return new CarteSept(symbole);
		case 8:
			return new CarteHuit(symbole);
		default:
			return new Carte(symbole, numero);
		}
	}
	
	public static List<Carte> creerPaquet(int nombre) {
		List<Carte> cartes = new ArrayList<Carte>();
		for (int i = 0; i < nombre; i++)
			for (final Symbole s : Symbole.values())
				for (int numero = AS; numero <= ROI; numero++)
					cartes.add(creerCarte(s, numero));
		return cartes;
	}
	
}