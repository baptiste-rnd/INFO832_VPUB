package fr.bgr;
import java.util.ArrayList;
import java.util.List;

public class Bar {
	private final List<Boisson> boissonChaude;
	private final List<Boisson> boissonFroide;
	private final List<Boisson> boissonAlcoolisee;
	private final List<Cocktail> cocktailSansAlcoole;
	private final List<Cocktail> cocktailAvecAlcoole;
	private static final List<String> BOISSONS_CHAUDES = List.of("Café", "Thé");

	// Constructeur
	public Bar(){
		this.boissonChaude = new ArrayList<>();
		this.boissonFroide = new ArrayList<>();
		this.boissonAlcoolisee = new ArrayList<>();
		this.cocktailAvecAlcoole = new ArrayList<>();
		this.cocktailSansAlcoole = new ArrayList<>();
	}

	// Ajout d'une boisson
	public void add(Boisson boisson){
		if(boisson.getAlcoolise()){
			if (!this.boissonAlcoolisee.contains(boisson)) {
				this.boissonAlcoolisee.add(boisson);
			}
		} else {
			if (BOISSONS_CHAUDES.contains(boisson.getNom())) {
				if (!this.boissonChaude.contains(boisson)) {
					this.boissonChaude.add(boisson);
				}
			} else {
				if (!this.boissonFroide.contains(boisson)) {
					this.boissonFroide.add(boisson);
				}
			}

		}
	}

	public void add(Cocktail cocktail){
		if(Boolean.TRUE.equals(cocktail.getAlcoolise())){
			if (!this.cocktailAvecAlcoole.contains(cocktail)) {
				this.cocktailAvecAlcoole.add(cocktail);
			}
		} else {
			if (!this.cocktailSansAlcoole.contains(cocktail)) {
				this.cocktailSansAlcoole.add(cocktail);
			}
		}
	}

	// Méthode pour servir une boisson ou un cocktail
	public Object serv(String command) {
		// Recherche dans les boissons froides, alcoolisées et chaudes
		Boisson retourB = findAndRemove(this.boissonFroide, command);
		if (retourB != null) return retourB;

		retourB = findAndRemove(this.boissonAlcoolisee, command);
		if (retourB != null) return retourB;

		retourB = findAndRemove(this.boissonChaude, command);
		if (retourB != null) return retourB;

		// Recherche dans les cocktails sans alcool et avec alcool
		Cocktail retourC = findAndRemove(this.cocktailSansAlcoole, command);
		if (retourC != null) return retourC;

		retourC = findAndRemove(this.cocktailAvecAlcoole, command);
        return retourC;// Si la boisson ou le cocktail n'est pas trouvé
    }

	// Méthode générique pour trouver et supprimer un élément
	private <T> T findAndRemove(List<T> list, String name) {
		for (T item : list) {
			if (item instanceof Boisson boisson && boisson.getNom().equalsIgnoreCase(name)) {
				list.remove(item);
				return (T) boisson;
			} else if (item instanceof Cocktail cocktail && cocktail.getNom().equalsIgnoreCase(name)) {
				list.remove(item);
				return (T) cocktail;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuilder retour = new StringBuilder();
		String eol = System.lineSeparator();

		retour.append("Bar : ").append(eol);

		// Ajouter les boissons sans alcool
		appendNames(retour, "\t Sans alcool", boissonFroide);
		// Ajouter les boissons alcoolisées
		appendNames(retour, "\t Avec alcool", boissonAlcoolisee);
		// Ajouter les cocktails sans alcool
		appendNames(retour, "\t Cocktail sans alcool", cocktailSansAlcoole);
		// Ajouter les cocktails avec alcool
		appendNames(retour, "\t Cocktail avec alcool", cocktailAvecAlcoole);
		// Ajouter les boissons chaudes
		appendNames(retour, "\t Boissons chaudes", boissonChaude);

		return retour.toString();
	}

	// Méthode pour ajouter les noms des éléments d'une liste
	private <T> void appendNames(StringBuilder retour, String header, List<T> items) {
		retour.append(header).append(System.lineSeparator());
		for (T item : items) {
			if (item instanceof Boisson boisson) {
                retour.append("\t\t").append(boisson.getNom()).append(System.lineSeparator());
			} else if (item instanceof Cocktail cocktail) {
                retour.append("\t\t").append(cocktail.getNom()).append(System.lineSeparator());
			}
		}
	}

	public List<Boisson> getBoissonChaude() {
		return boissonChaude;
	}

	public List<Boisson> getBoissonFroide() {
		return boissonFroide;
	}

	public List<Boisson> getBoissonAlcoolisee() {
		return boissonAlcoolisee;
	}

	public List<Cocktail> getCocktailSansAlcoole() {
		return cocktailSansAlcoole;
	}

	public List<Cocktail> getCocktailAvecAlcoole() {
		return cocktailAvecAlcoole;
	}
}
