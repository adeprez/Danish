package fr.utt.lo02.danish.modele.action;

import fr.utt.lo02.danish.modele.Partie;

public class ActionPioche implements Action {

	
	@Override
	public void faireEffet(Partie partie) {
		partie.piocher();
	}
	
	@Override
	public String toString() {
		return "Piocher";
	}

}
