package fr.bgr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BarTest {

    private Bar bar;
    private Boisson boissonAlcoolisee;
    private Boisson boissonNonAlcoolisee;
    private Boisson boissonChaude;
    private Cocktail cocktailAlcoolise;
    private Cocktail cocktailSansAlcool;

    @BeforeEach
    void setUp() {
        bar = new Bar();
        boissonAlcoolisee = new Boisson("Bière", 5.0F);
        boissonNonAlcoolisee = new Boisson("Eau");
        boissonChaude = new Boisson("Café");
        cocktailAlcoolise = new Cocktail("Mojito");
        cocktailAlcoolise.add("Rhum", 40.0);
        cocktailSansAlcool = new Cocktail("Virgin Mojito");
        cocktailSansAlcool.add("Menthe", 10.0);
    }

    @Test
    void addBoissonAlcoolisee() {
        bar.add(boissonAlcoolisee);
        assertTrue(bar.getBoissonAlcoolisee().contains(boissonAlcoolisee), "La boisson alcoolisée doit être ajoutée à boissonAlcoolisee");
    }

    @Test
    void addBoissonNonAlcoolisee() {
        bar.add(boissonNonAlcoolisee);
        assertTrue(bar.getBoissonFroide().contains(boissonNonAlcoolisee), "La boisson non alcoolisée doit être ajoutée à boissonFroide");
    }

    @Test
    void addBoissonChaude() {
        bar.add(boissonChaude);
        assertTrue(bar.getBoissonChaude().contains(boissonChaude), "La boisson chaude doit être ajoutée à boissonChaude");
    }

    @Test
    void addCocktailAlcoolise() {
        bar.add(cocktailAlcoolise);
        assertTrue(bar.getCocktailAvecAlcoole().contains(cocktailAlcoolise), "Le cocktail alcoolisé doit être ajouté à cocktailAvecAlcoole");
    }

    @Test
    void addCocktailSansAlcool() {
        bar.add(cocktailSansAlcool);
        assertTrue(bar.getCocktailSansAlcoole().contains(cocktailSansAlcool), "Le cocktail sans alcool doit être ajouté à cocktailSansAlcoole");
    }

    @Test
    void servCocktailExistant() {
        bar.add(cocktailSansAlcool);
        assertNotNull(bar.serv("Virgin Mojito"), "Le cocktail Virgin Mojito doit être servi");
        assertFalse(bar.getCocktailSansAlcoole().contains(cocktailSansAlcool), "Le cocktail doit être retiré de la liste après avoir été servi");
    }

    @Test
    void servBoissonExistante() {
        bar.add(boissonAlcoolisee);
        assertNotNull(bar.serv("Bière"), "La boisson Bière doit être servie");
        assertFalse(bar.getBoissonAlcoolisee().contains(boissonAlcoolisee), "La boisson doit être retirée de la liste après avoir été servie");
    }

    @Test
    void servBoissonInexistante() {
        assertNull(bar.serv("Whisky"), "Une boisson inexistante doit retourner null");
    }

    @Test
    void toStringTest() {
        // Ajouter des éléments au bar
        bar.add(boissonAlcoolisee);
        bar.add(boissonNonAlcoolisee);
        bar.add(cocktailAlcoolise);
        bar.add(cocktailSansAlcool);
        bar.add(boissonChaude); // Ajouter la boisson chaude

        // Définir la sortie attendue
        String expectedOutput = "Bar : \n\t Sans alcool\n\t\tEau\n\t Avec alcool\n\t\tBière\n\t Cocktail sans alcool\n\t\tVirgin Mojito\n\t Cocktail avec alcool\n\t\tMojito\n\t Boissons chaudes\n\t\tCafé\n";

        // Obtenir la sortie réelle du bar
        String actualOutput = bar.toString();

        // Nettoyer les chaînes de caractères pour supprimer les espaces ou retours à la ligne excédentaire
        expectedOutput = expectedOutput.replaceAll("\\s+", " ").trim();
        actualOutput = actualOutput.replaceAll("\\s+", " ").trim();

        // Vérification de la sortie
        assertEquals(expectedOutput, actualOutput, "La méthode toString() doit renvoyer la représentation correcte du bar");
    }

    @Test
    void ajouterDoublon() {
        bar.add(boissonAlcoolisee);
        bar.add(boissonAlcoolisee); // Ajouter une boisson en doublon
        assertEquals(1, bar.getBoissonAlcoolisee().size(), "La boisson ne doit pas être ajoutée en doublon");
    }

    // Tests d'exception

    @Test
    void ajouterBoissonNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> bar.add((Boisson) null));
        assertEquals("La boisson ne peut pas être null", exception.getMessage(), "Le bar doit lancer une exception si on essaie d'ajouter une boisson null");
    }
}
