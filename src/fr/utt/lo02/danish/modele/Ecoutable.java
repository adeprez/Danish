package fr.utt.lo02.danish.modele;

import java.util.EventListener;

import javax.swing.event.EventListenerList;

public class Ecoutable {
	private final EventListenerList ecouteurs;
	
	
	public Ecoutable() {
		ecouteurs = new EventListenerList();
	}
	
	public <T extends EventListener> void ajoutEcouteur(Class<T> classe, T listener) {
		ecouteurs.add(classe, listener);
	}
	
	public <T extends EventListener> void retireEcouteur(Class<T> classe, T listener) {
		ecouteurs.remove(classe, listener);
	}
	
	public <T extends EventListener> T[] getEcouteurs(Class<T> classe) {
		return ecouteurs.getListeners(classe);
	}

}
