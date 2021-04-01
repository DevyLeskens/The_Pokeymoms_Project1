package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CirkelTest {
    private Punt middelpunt;
    private int radius;
    private Cirkel cirkel;
    private Omhullende omhullende, omhullende2;

    @Before
    public void setUp() throws Exception {
        middelpunt = new Punt(5, 10);
        radius = 5;
        cirkel = new Cirkel(middelpunt, radius);
        omhullende = new Omhullende(new Punt(100, 40), 15, 20);
        omhullende2 = new Omhullende(new Punt(middelpunt.getX() - radius,middelpunt.getY() - radius),radius*2,radius*2);
    }
//    ik kan een cirkel aanmaken met een geldig middelpunt en een
//    geldige straal


    @Test
    public void Cirkel_met_geldig_middelpunt_en_straal() {
        cirkel = new Cirkel(middelpunt, radius);
    }


//    o ik krijg een exception wanneer ik een cirkel wil aanmaken met
//    middelpunt = null

    @Test(expected = DomainException.class)
    public void exception_met_middelpunt_null() {
        new Cirkel(null, radius);
    }

//    o ik krijg een exception wanneer ik een cirkel wil aanmaken met
//    straal < 0

    @Test(expected = DomainException.class)
    public void exception_met_straal_kleiner_0() {
        new Cirkel(middelpunt, -5);
    }


//    o ik krijg een exception wanneer ik een cirkel wil aanmaken met
//    straal = 0

    @Test(expected = DomainException.class)
    public void Gooit_exception_als_straal_0_is() {
        new Cirkel(middelpunt, 0);
    }

//    o Twee cirkels zijn gelijk wanneer ze hetzelfde middelpunt en
//    dezelfde straal hebben

    @Test
    public void equals_zelfde_geg() {
        assert (cirkel.equals(new Cirkel(middelpunt, radius)));
    }

    //    o Twee cirkels zijn verschillend wanneer de tweede cirkel null is
    @Test
    public void equals_niet_dezelfde_cirkel() {
        assert (!cirkel.equals(null));
    }

    //    o Twee cirkels zijn verschillend wanneer hun middelpunt verschillend
//            is
    @Test
    public void equals_verschillend_mid() {
        Cirkel newCirkel = new Cirkel(new Punt(10, 5), radius);
        assertFalse(cirkel.equals(newCirkel));
    }

    //    o Twee cirkels zijn verschillend wanneer hun straal verschillend is
    @Test
    public void Verschillende_stralen() {
        assert (!cirkel.equals(new Cirkel(middelpunt, 2)));
    }

    @Test
    public void getOmhullende_geeft_false_als_het_de_foute_output_geeft(){
        assertNotEquals(cirkel.getOmhullende(), omhullende);
    }

    @Test
    public void getOmhullende_geeft_true_als_het_de_juiste_output_geeft(){
        assertEquals(cirkel.getOmhullende().getLinkerBovenhoek(), omhullende2.getLinkerBovenhoek());
        assertEquals(cirkel.getOmhullende().getBreedte(), omhullende2.getBreedte());
        assertEquals(cirkel.getOmhullende().getHoogte(), omhullende2.getHoogte());
    }


}