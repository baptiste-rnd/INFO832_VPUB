package fr.bgr;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Pierre Le Fameux
 *
 */
public class Cocktail {

	// Classe interne Ingredient
	public record Ingredient(String nom, Double quantite) {}

	private final String nom;
	private final LinkedList<Ingredient> ingredients;
	private Boolean alcoolise;
	private static final List<String> INGREDIENTS_ALCOOLISES = List.of("Rhum", "Vodka", "Whisky", "Gin", "Tequila");

	/**
	 * Crée un Cocktail avec son nom
	 * @param nom le nom du cocktail
	 */
	public Cocktail(String nom) {
		this.nom = nom;
		this.ingredients = new LinkedList<>();
		this.alcoolise = false;
	}

	/**
	 * Ajoute un nouvel ingrédient dans le Cocktail.
	 * @param ingredient l'ingrédient à ajouter
	 * @param quantite la quantité de l'ingrédient
	 */
	public void add(String ingredient, Double quantite) {
		this.ingredients.add(new Ingredient(ingredient, quantite));
		if (INGREDIENTS_ALCOOLISES.contains(ingredient)) {
			this.alcoolise = true;
		}
	}

	/**
	 * Représentation du Cocktail sous forme de chaîne de caractères
	 * @return la chaîne représentant le Cocktail
	 */
	@Override
	public String toString() {
		StringBuilder retour = new StringBuilder();
		for (Ingredient ingredient : this.ingredients) {
			retour.append(ingredient.nom)
					.append(" ")
					.append(ingredient.quantite)
					.append("%\t");
		}
		return retour.toString();
	}

	public String getNom() {
		return nom;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public Boolean getAlcoolise() {
		return alcoolise;
	}
}
