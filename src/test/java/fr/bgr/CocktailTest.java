package fr.bgr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CocktailTest {

    // Test pour la méthode add()
    @Test
    void add() {
        // Créer un cocktail
        Cocktail cocktail = new Cocktail("Mojito");

        // Ajouter des ingrédients
        cocktail.add("Menthe", 10.0);
        cocktail.add("Rhum", 40.0);

        // Vérifier que la taille de la liste des ingrédients est correcte
        assertEquals(2, cocktail.getIngredients().size(), "Le nombre d'ingrédients doit être 2");

        // Vérifier que les ingrédients ont été ajoutés avec les bonnes valeurs
        assertEquals("Menthe", cocktail.getIngredients().get(0).nom(), "Le premier ingrédient doit être 'Menthe'");
        assertEquals(10.0, cocktail.getIngredients().get(0).quantite(), "La quantité de menthe doit être 10.0%");

        assertEquals("Rhum", cocktail.getIngredients().get(1).nom(), "Le deuxième ingrédient doit être 'Rhum'");
        assertEquals(40.0, cocktail.getIngredients().get(1).quantite(), "La quantité de rhum doit être 40.0%");
    }

    // Test pour la méthode alcoolFree()
    @Test
    void alcoolFree() {
        // Créer un cocktail sans alcool
        Cocktail cocktailSansAlcool = new Cocktail("Virgin Mojito");
        // Ajouter des ingrédients sans alcool
        cocktailSansAlcool.add("Menthe", 10.0);
        cocktailSansAlcool.add("Jus de citron", 20.0);

        // Vérifier que le cocktail sans alcool renvoie bien false pour alcoolFree
        assertFalse(cocktailSansAlcool.getAlcoolise(), "Un cocktail sans alcool devrait renvoyer false");

        // Créer un cocktail avec alcool
        Cocktail cocktailAvecAlcool = new Cocktail("Mojito");
        // Ajouter un ingrédient alcoolisé
        cocktailAvecAlcool.add("Rhum", 40.0);

        // Vérifier que le cocktail avec alcool renvoie true pour alcoolFree
        assertTrue(cocktailAvecAlcool.getAlcoolise(), "Un cocktail avec alcool devrait renvoyer true");
    }

    // Test pour la méthode toString()
    @Test
    void testToString() {
        // Créer un cocktail
        Cocktail cocktail = new Cocktail("Mojito");
        cocktail.add("Menthe", 10.0);
        cocktail.add("Rhum", 40.0);

        // Vérifier la sortie de toString()
        String expectedOutput = "Menthe 10.0%\tRhum 40.0%\t";
        assertEquals(expectedOutput, cocktail.toString(), "La méthode toString() doit retourner la chaîne correcte");

        // Créer un autre cocktail sans alcool
        Cocktail cocktailSansAlcool = new Cocktail("Virgin Mojito");
        cocktailSansAlcool.add("Menthe", 10.0);
        cocktailSansAlcool.add("Jus de citron", 20.0);

        // Vérifier la sortie de toString() pour un cocktail sans alcool
        expectedOutput = "Menthe 10.0%\tJus de citron 20.0%\t";
        assertEquals(expectedOutput, cocktailSansAlcool.toString(), "La méthode toString() doit retourner la chaîne correcte pour un cocktail sans alcool");
    }
}
