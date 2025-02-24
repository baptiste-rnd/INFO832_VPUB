package fr.bgr;

import java.util.logging.Logger;

/**
 * Virtual PUB
 */
public class Pub {

	private static final Logger LOGGER = Logger.getLogger(Pub.class.getName());
	private static final String BIERE = "Bière";
	private final Bar bar;
	private final Cave cave;

	/**
	 * Constructeur du Pub
	 */
	public Pub() {
		this.bar = new Bar();
		this.cave = new Cave();
	}

	public void approvisionnerBar(String nom) {
		Boisson boisson = this.cave.take(nom);
		if (boisson != null) {
			this.bar.add(boisson);
		} else {
			LOGGER.warning(() -> "Boisson " + nom + " non disponible en cave.");
		}
	}

	/**
	 * @param args Arguments de la fonction
	 */
	public static void main(String[] args) {
		/* Création du pub */
		Pub pub = new Pub();

		Boisson coca = new Boisson("Coca");
		Boisson eau = new Boisson("Eau");
		Boisson whisky = new Boisson("Whisky", 40F);
		Boisson biere = new Boisson(BIERE, 8F);

		pub.cave.add(coca);
		pub.cave.add(whisky);
		pub.cave.add(whisky);
		pub.cave.add(biere);
		pub.cave.add(biere);
		pub.cave.add(eau);

		LOGGER.warning(() -> "Cave initiale :\n" + pub.cave);

		pub.approvisionnerBar(BIERE);
		pub.approvisionnerBar("Whisky");
		pub.approvisionnerBar("Coca");
		pub.approvisionnerBar("Eau");

		Cocktail mazout = new Cocktail("Mazout");
		mazout.add(BIERE, 50.0);
		mazout.add("Coca", 50.0);
		pub.bar.add(mazout);

		Boisson cafe = new Boisson("Café");
		pub.bar.getBoissonChaude().add(cafe);

		LOGGER.warning(pub.cave::toString);
		LOGGER.warning(pub.bar::toString);

		LOGGER.warning(() -> "Boisson servie : " + pub.bar.serv("Café"));
		LOGGER.warning(pub.bar::toString);
	}

	public Bar getBar() {
		return bar;
	}

	public Cave getCave() {
		return cave;
	}
}
