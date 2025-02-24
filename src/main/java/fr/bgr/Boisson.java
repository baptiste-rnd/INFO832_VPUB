package fr.bgr;

/**
 * Représente une boisson, qu'elle soit alcoolisée ou non.
 *
 * @author Pierre Le Fameux
 */
public class Boisson {

	private final String nom;
	private final boolean alcoolise;
	private final Float degre;

	/**
	 * Constructeur pour une boisson non alcoolisée.
	 *
	 * @param nom Le nom de la boisson
	 */
	public Boisson(String nom) {
		this.nom = nom;
		this.alcoolise = false;
		this.degre = null;
	}

	/**
	 * Constructeur pour une boisson alcoolisée avec un degré d'alcool.
	 *
	 * @param nom Le nom de la boisson
	 * @param degre Le degré d'alcool de la boisson
	 */
	public Boisson(String nom, float degre) {
		this.nom = nom;
		this.degre = degre;
		this.alcoolise = true;
	}

	/**
	 * Retourne une représentation sous forme de chaîne de caractères de la boisson.
	 *
	 * @return Une chaîne de caractères qui représente la boisson
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(nom);

		if (alcoolise) {
			sb.append(" (l'abus d'alcool est dangereux pour la santé)");
		}

		if (degre != null && alcoolise) {
			sb.append(" - Degré d'alcool : ").append(degre).append("%");
		}

		return sb.toString();
	}

	// Getters et setters pour le degré d'alcool, permettant de modifier une boisson alcoolisée
	public String getNom() {
		return nom;
	}

	public boolean getAlcoolise() {
		return alcoolise;
	}

	public Float getDegre() {
		return degre;
	}
}
