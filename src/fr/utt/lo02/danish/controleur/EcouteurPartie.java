package fr.utt.lo02.danish.controleur;

import java.util.EventListener;

import fr.utt.lo02.danish.modele.Partie;
import fr.utt.lo02.danish.modele.Tour;

public interface EcouteurPartie extends EventListener {
	public void commence(Partie partie);
	public void nouveauTour(Tour tour);
}
