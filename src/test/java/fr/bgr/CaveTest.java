package fr.bgr;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class CaveTest {

    private Cave cave;
    private Boisson boisson1;
    private Boisson boisson2;

    @BeforeEach
    void setUp() {
        // Initialisation avant chaque test
        cave = new Cave();
        boisson1 = new Boisson("Coca", 1.5F);
        boisson2 = new Boisson("Pepsi", 1.3F);
    }

    // Test 1 : Vérifier l'instanciation correcte de la cave
    @Test
    void testCaveInitialization() {
        assertNotNull(cave, "La cave doit être correctement instanciée.");
        assertTrue(cave.getRayons().isEmpty(), "La cave doit être initialement vide.");
    }

    // Test 2 : Vérifier l'ajout d'une boisson dans la cave
    @Test
    void testAddBoisson() {
        cave.add(boisson1);
        assertTrue(cave.getRayons().contains(boisson1), "La cave doit contenir la boisson ajoutée.");
    }

    // Test 3 : Vérifier la méthode take() avec une boisson existante
    @Test
    void testTakeExistingBoisson() {
        cave.add(boisson1);  // Ajouter une boisson
        Boisson takenBoisson = cave.take("Coca");  // Récupérer la boisson

        assertNotNull(takenBoisson, "La boisson devrait être récupérée.");
        assertEquals(boisson1, takenBoisson, "La boisson récupérée devrait correspondre à la boisson recherchée.");
        assertFalse(cave.getRayons().contains(boisson1), "La boisson devrait être retirée de la cave.");
    }

    // Test 4 : Vérifier la méthode take() avec une boisson inexistante
    @Test
    void testTakeNonExistingBoisson() {
        cave.add(boisson1);
        Boisson takenBoisson = cave.take("Fanta");

        assertNull(takenBoisson, "La boisson 'Fanta' n'existant pas, le retour devrait être null.");
        assertTrue(cave.getRayons().contains(boisson1), "La cave ne doit pas être modifiée si la boisson n'existe pas.");
    }

    // Test 5 : Vérifier la méthode toString() pour afficher les boissons
    @Test
    void testToString() {
        cave.add(boisson1);
        cave.add(boisson2);
        String result = cave.toString();
        assertTrue(result.contains("Coca"), "Le nom de la boisson doit être inclus dans la sortie.");
        assertTrue(result.contains("Pepsi"), "Le nom de la deuxième boisson doit être inclus dans la sortie.");
    }

}