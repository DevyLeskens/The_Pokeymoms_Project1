package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LijnStukTest {
    private Punt punt1 = new Punt(10, 20);
    private Punt punt2 = new Punt(190, 30);

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

    @Test (expected = DomainException.class)
    public void getOmhullende_gooit_exception_als_het_de_foute_output_is() {
        LijnStuk lijnstuk = new LijnStuk(punt1, punt2);
        Omhullende omhullende = new Omhullende(new Punt(100,100), 15, 20);
        assertEquals(lijnstuk.getOmhullende(), omhullende);
    }
}
	
