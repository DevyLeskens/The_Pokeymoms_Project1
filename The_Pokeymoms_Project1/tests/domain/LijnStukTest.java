package domain;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LijnStukTest {
    private Punt punt1;
    private Punt punt2;
    private Punt linkerBovenhoek;
    private int hoogte, breedte;
    private LijnStuk lijnstuk;
    private Omhullende omhullende, omhullende2;

    @Before
    public void setUp(){
        punt1 = new Punt(10, 20);
        punt2 = new Punt(190, 30);
        linkerBovenhoek = punt1;
        hoogte = 10;
        breedte = 20;
        lijnstuk = new LijnStuk(punt1, punt2);
        omhullende = new Omhullende(new Punt(100,100), 15, 20);
        omhullende2 = new Omhullende(linkerBovenhoek, 180, 10);

    }

    @Test
    public void LijnStuk_moet_lijnstuk_aanmaken_met_gegeven_startPunt_en_eindPunt() {
        LijnStuk lijnstuk = new LijnStuk(punt1, punt2);

        assertEquals(punt1, lijnstuk.getStartPunt());
        assertEquals(punt2, lijnstuk.getEindPunt());
    }

    @Test(expected = DomainException.class)
    public void LijnStuk_Aanmaken_Geeft_Fout_als_startPunt_en_eindPunt_gelijk_zijn() {
        new LijnStuk(punt1, punt1);
    }

    @Test(expected = DomainException.class)
    public void LijnStuk_Moet_exception_gooien_als_startpunt_null() {
        new LijnStuk(null, punt2);
    }

    @Test(expected = DomainException.class)
    public void LijnStuk_Moet_exception_gooien_als_eindpunt_null() {
        new LijnStuk(punt1, null);
    }

    @Test
    public void equals_moet_true_teruggeven_als_begin_en_eindpunt_gelijk_zijn() {
        LijnStuk lijnStuk = new LijnStuk(punt1, punt2);
        LijnStuk zelfdeLijnStuk = new LijnStuk(punt1, punt2);
        assertTrue(lijnStuk.equals(zelfdeLijnStuk));
    }

    @Test
    public void equals_moet_false_teruggeven_als_parameter_null() {
        LijnStuk lijnStuk = new LijnStuk(punt1, punt2);
        assertFalse(lijnStuk.equals(null));
    }

    @Test
    public void equals_moet_true_teruggeven_als_beginPunt_en_eindPunt_zijn_omgewisseld() {
        LijnStuk lijnStuk = new LijnStuk(punt1, punt2);
        LijnStuk lijnStuk1 = new LijnStuk(punt2, punt1);

        assertTrue(lijnStuk.equals(lijnStuk1));
    }

    @Test
    public void getOmhullende_geeft_false_als_het_de_foute_output_geeft(){
        assertNotEquals(lijnstuk.getOmhullende(), omhullende);
    }

    @Test
    public void getOmhullende_geeft_true_als_het_de_juiste_output_geeft(){
       assertEquals(lijnstuk.getOmhullende(), omhullende2);
    }
}
	
