package fr.bgr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoissonTest {

    private Boisson boissonSansAlcool;
    private Boisson boissonAvecAlcool;

    // Avant chaque test, on instancie les objets à tester
    @BeforeEach
    void setUp() {
        boissonSansAlcool = new Boisson("Eau");
        boissonAvecAlcool = new Boisson("Bière", 5.0f);
    }

    // Test de l'instanciation avec un seul paramètre (nom)
    @Test
    void testInstantiationWithNameOnly() {
        assertNotNull(boissonSansAlcool);
        assertEquals("Eau", boissonSansAlcool.getNom());
        assertFalse(boissonSansAlcool.getAlcoolise());
        assertNull(boissonSansAlcool.getDegre());  // Le degré d'alcool n'est pas initialisé
    }

    // Test de l'instanciation avec un nom et un degré d'alcool
    @Test
    void testInstantiationWithNameAndAlcoholDegree() {
        assertNotNull(boissonAvecAlcool);
        assertEquals("Bière", boissonAvecAlcool.getNom());
        assertEquals(5.0f, boissonAvecAlcool.getDegre(), 0);
        assertTrue(boissonAvecAlcool.getAlcoolise());
    }

    // Test de la méthode toString() avec une boisson sans alcool
    @Test
    void testToStringWithoutAlcohol() {
        assertEquals("Eau", boissonSansAlcool.toString());
    }

    // Test de la méthode toString() avec une boisson avec alcool
    @Test
    void testToStringWithAlcohol() {
        assertEquals("Bière (l'abus d'alcool est dangereux pour la santé) - Degré d'alcool : 5.0%", boissonAvecAlcool.toString());
    }

    // Test pour vérifier l'initialisation correcte des attributs
    @Test
    void testAttributesInitialization() {
        // Test sans alcool
        assertEquals("Eau", boissonSansAlcool.getNom());
        assertNull(boissonSansAlcool.getDegre());  // Pas d'alcool
        assertFalse(boissonSansAlcool.getAlcoolise());

        // Test avec alcool
        assertEquals("Bière", boissonAvecAlcool.getNom());
        assertEquals(5.0f, boissonAvecAlcool.getDegre());  // Degré d'alcool correct
        assertTrue(boissonAvecAlcool.getAlcoolise());
    }
}
