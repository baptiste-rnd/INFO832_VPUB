package fr.bgr;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

/**
 * @author Pierre Le Fameux
 *
 */
public class Cave {
	private final LinkedList<Boisson> rayons;

	/**
	 * Constructeur par défaut
	 */
	public Cave() {
		this.rayons = new LinkedList<>();
	}

	/**
	 * Ajoute une boisson dans la cave
	 * @param b la boisson à ajouter
	 */
	public void add(Boisson b) {
		this.rayons.add(b);
	}

	/**
	 * Retire et retourne la boisson avec le nom spécifié
	 * @param nom le nom de la boisson
	 * @return la boisson si elle existe, sinon null
	 */
	public Boisson take(String nom) {
		Iterator<Boisson> iterator = this.rayons.iterator();
		while (iterator.hasNext()) {
			Boisson b = iterator.next();
			if (b.getNom().equalsIgnoreCase(nom)) {
				iterator.remove();
				return b;
			}
		}
		return null;
	}

	/**
	 * Affiche les boissons présentes dans la cave
	 * @return une représentation sous forme de chaîne
	 */
	@Override
	public String toString() {
		StringBuilder retour = new StringBuilder();
		String eol = System.lineSeparator();
		retour.append("Cave :").append(eol);
		for (Boisson boisson : this.rayons) {
			retour.append("\t").append(boisson).append(eol);
		}
		return retour.toString();
	}

	public List<Boisson> getRayons() {
		return rayons;
	}
}
