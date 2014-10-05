package fr.utt.lo02.danish.controleur;

import java.util.EventListener;

import fr.utt.lo02.danish.modele.Tour;
import fr.utt.lo02.danish.modele.action.Action;

public interface EcouteurTour extends EventListener {
	public void faitAction(Tour tour, Action action, boolean tourFini);
}
