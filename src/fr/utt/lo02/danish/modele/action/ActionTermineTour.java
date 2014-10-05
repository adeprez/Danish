package fr.utt.lo02.danish.modele.action;

import fr.utt.lo02.danish.modele.Partie;

public class ActionTermineTour implements Action {


	@Override
	public void faireEffet(Partie partie) {}
	
	@Override
	public String toString() {
		return "Terminer tour";
	}
}
