package fr.bgr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PubTest {

    private Pub pub;
    private Boisson coca;
    private Boisson eau;
    private Boisson whisky;
    private Boisson bierre;

    @BeforeEach
    void setUp() {
        pub = new Pub(); // Initialisation du pub
        coca = new Boisson("Coca");
        eau = new Boisson("Eau");
        whisky = new Boisson("Whisky", 40.0F);
        bierre = new Boisson("Bierre", 8.0F);
    }

    @Test
    void testPubContientBarEtCave() {
        // Vérifier que le pub contient bien un bar et une cave
        assertNotNull(pub.getBar(), "Le bar ne doit pas être nul");
        assertNotNull(pub.getCave(), "La cave ne doit pas être nulle");
    }

    @Test
    void testApprovisionnerBar() {
        // Ajouter des boissons à la cave
        pub.getCave().add(coca);
        pub.getCave().add(eau);
        pub.getCave().add(whisky);
        pub.getCave().add(bierre);

        // Approvisionner le bar avec les boissons
        pub.approvisionnerBar("Coca");
        pub.approvisionnerBar("Eau");
        pub.approvisionnerBar("Whisky");
        pub.approvisionnerBar("Bierre");

        // Vérifier que les boissons ont été ajoutées au bar
        assertTrue(pub.getBar().getBoissonFroide().contains(coca), "Le Coca doit être dans le bar");
        assertTrue(pub.getBar().getBoissonFroide().contains(eau), "L'Eau doit être dans le bar");
        assertTrue(pub.getBar().getBoissonAlcoolisee().contains(whisky), "Le Whisky doit être dans le bar");
        assertTrue(pub.getBar().getBoissonAlcoolisee().contains(bierre), "La Bière doit être dans le bar");
    }

    @Test
    void testTake() {
        // Ajouter une boisson à la cave
        pub.getCave().add(coca);

        // Vérifier que la cave contient la boisson
        assertTrue(pub.getCave().getRayons().contains(coca), "La cave doit contenir le Coca");

        // Retirer la boisson de la cave avec la méthode take()
        Boisson boissonRetiree = pub.getCave().take("Coca");

        // Vérifier que la boisson a bien été retirée de la cave
        assertFalse(pub.getCave().getRayons().contains(coca), "La cave ne doit pas contenir le Coca après avoir été pris");
        assertEquals(coca, boissonRetiree, "La boisson retirée doit être le Coca");
    }

    @Test
    void testMain() {
        // Exécuter la méthode main() et vérifier qu'elle ne génère pas d'exception
        try {
            Pub.main(new String[]{});
        } catch (Exception e) {
            fail("La méthode main a échoué avec l'exception : " + e.getMessage());
        }
    }

    @Test
    void testCaveNeEstPasVide() {
        // Ajouter une boisson à la cave et vérifier qu'elle n'est pas vide
        pub.getCave().add(coca);
        assertFalse(pub.getCave().getRayons().isEmpty(), "La cave ne doit pas être vide après ajout d'une boisson");
    }

    @Test
    void testBarNeEstPasVide() {
        // Ajouter une boisson au bar et vérifier qu'il n'est pas vide
        pub.getBar().add(coca);
        assertFalse(pub.getBar().getBoissonFroide().isEmpty(), "Le bar ne doit pas être vide après ajout d'une boisson");
    }
}
