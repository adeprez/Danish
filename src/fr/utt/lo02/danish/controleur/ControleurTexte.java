package fr.utt.lo02.danish.controleur;

import java.util.List;
import java.util.Scanner;

import fr.utt.lo02.danish.modele.Joueur;
import fr.utt.lo02.danish.modele.Joueur.Paquet;
import fr.utt.lo02.danish.modele.ListeJoueurs;
import fr.utt.lo02.danish.modele.Partie;
import fr.utt.lo02.danish.modele.Tour;
import fr.utt.lo02.danish.modele.action.Action;
import fr.utt.lo02.danish.modele.carte.Carte;

public class ControleurTexte implements EcouteurListeJoueur, EcouteurPartie, EcouteurTour {
	private static final String[] COMMANDES = new String[] {
		"help/aide : Affiche les commandes disponibles", 
		"quit/exit : Quitter", 
		"new : Lance une nouvelle partie", 
		"go/start : Démarre une partie", 
		"who/qui : affiche les joueurs",
		"add/+ [nom] : Ajoute le joueur 'nom'", 
		"remove/- [numero joueur] : Retire le joueur d'apres son numero"
	};
	private final Scanner entree;
	private Partie partie;
	private boolean actif;
	
	public ControleurTexte() {
		nouvellePartie();
		entree = new Scanner(System.in);
	}
	
	public void lancer() {
		actif = true;
		System.out.println("Bienvenue dans la bataille Norvégienne.");
		afficheOptions();
		while(actif)
			action(entree.nextLine());
	}
	
	public void afficheOptions() {
		System.out.println("Options disponibles :");
		for(final String s : COMMANDES)
			System.out.println(s);
	}
	
	public void nouvellePartie() {
		ListeJoueurs l = new ListeJoueurs();
		l.ajoutEcouteur(EcouteurListeJoueur.class, this);
		partie = new Partie(l);
		partie.ajoutEcouteur(EcouteurPartie.class, this);
	}

	public void action(String ligne) {
		try {
			actionJeu(Integer.valueOf(ligne) - 1);
		} catch(Exception err) {
			String[] options = ligne.split(" ");
			if(options.length > 0) {
				switch(options[0].trim().toLowerCase()) {
				case "aide":
				case "help":
					afficheOptions();
					break;
				case "exit":
				case "quit":
					actif = false;
					break;
				case "new":
					nouvellePartie();
					break;
				case "start":
				case "go":
					partie.lancer();
					break;
				case "qui":
				case "who":
					System.out.println(partie.getJoueurs());
					break;
				case "+":
				case "add":
					try {
						partie.getJoueurs().ajouterJoueur(new Joueur(options[1]));
					} catch(Exception e) {
						System.out.println("Ajoutez le nom du joueur apres la commande 'add'");
					}
					break;
				case "-":
				case "remove":
					try {
						partie.getJoueurs().retirerJoueur(- 1 + Integer.valueOf(options[1]));
					} catch(Exception e) {
						e.printStackTrace();
						System.out.println("Ajoutez le numero du joueur apres la commande 'remove'");
					}
					break;
				default:
					System.out.println("Commande invalide");
					break;
				}
			}
		}
	}

	public void actionJeu(int action) {
		partie.getTour().faireAction(action);
	}
	
	public void afficheActions(Tour tour) {
		List<Carte> tas = tour.getPartie().getPlateau().getTas();
		System.out.println("Carte sur le dessus du paquet : " + 
				(tas.isEmpty() ? "Aucune" : tas.get(0)));
		for (Paquet p : Joueur.Paquet.values())
			System.out.println("Cartes " + p.toString().toLowerCase() + " : " 
					+ tour.getJoueur().getPaquet(p));
		System.out.println("Entrez le numéro de l'action à effectuer :\n" + tour);
	}

	@Override
	public void commence(Partie partie) {
		System.out.println("La partie commence");
	}

	@Override
	public void nouveauTour(Tour tour) {
		tour.ajoutEcouteur(EcouteurTour.class, this);
		System.out.println("Au tour de " + tour.getJoueur() + " de jouer");
		afficheActions(tour);
	}

	@Override
	public void ajouteJoueur(Joueur joueur) {
		System.out.println(joueur + " rejoint la partie");
	}

	@Override
	public void retireJoueur(Joueur joueur) {
		System.out.println(joueur + " quitte la partie");
	}

	@Override
	public void faitAction(Tour tour, Action action, boolean fini) {
		System.out.print(tour.getJoueur() + " fait l'action '" + action + "'");
		if(fini)
			System.out.println(" et termine son tour");
		else {
			System.out.println();
			afficheActions(tour);
		}
	}
	
}
