package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DriehoekTest {
    private Punt punt1;
    private Punt zelfdeAlsPunt1;
    private Punt verschillendVanPunt1;
    private Punt punt2;
    private Punt zelfdeAlsPunt2;
    private Punt verschillendVanPunt2;
    private Punt punt3;
    private Punt zelfdeAlsPunt3;
    private Punt verschillendVanPunt3;
    private Driehoek driehoek;
    private Omhullende omhullende, omhullende2;

    @Before
    public void setUp(){
        punt1 = new Punt(10, 20);
        punt2 = new Punt(20, 40);
        punt3 = new Punt(190, 30);
        zelfdeAlsPunt1 = new Punt(10, 20);
        zelfdeAlsPunt2 = new Punt(20, 40);
        zelfdeAlsPunt3 = new Punt(190, 30);
        verschillendVanPunt1 = new Punt(15, 20);
        verschillendVanPunt2 = new Punt(40, 20);
        verschillendVanPunt3 = new Punt(120, 100);
        driehoek = new Driehoek(punt1, punt2, punt3);
        omhullende = new Omhullende(new Punt(100, 100), 15, 20);
        omhullende2 = new Omhullende(new Punt(10,20), 180,20);
    }

    @Test
    public void Driehoek_moet_DrieHoek_aanmaken_met_gegeven_hoekpunten() {
        Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);

        assertEquals(punt1, drieHoek.getHoekPunt1());
        assertEquals(punt2, drieHoek.getHoekPunt2());
        assertEquals(punt3, drieHoek.getHoekPunt3());
    }

    @Test (expected = DomainException.class)
    public void Driehoek_Moet_exception_gooien_als_hoekpunt1_null()  {
        new Driehoek(null, punt2, punt3);
    }

    @Test (expected = DomainException.class)
    public void Driehoek_Moet_exception_gooien_als_hoekpunt2_null()  {
        new Driehoek(punt1, null, punt3);
    }

    @Test (expected = DomainException.class)
    public void DrieHoek_Moet_exception_gooien_als_hoekpunt3_null()  {
        new Driehoek(punt1, punt2, null);
    }

    @Test
    public void equals_moet_false_teruggeven_als_hoekPunt1_verschillend(){
        Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);
        Driehoek andereDriehoek = new Driehoek(verschillendVanPunt1, zelfdeAlsPunt2, zelfdeAlsPunt3);
        assertFalse(drieHoek.equals(andereDriehoek));
    }

    @Test
    public void equals_moet_false_teruggeven_als_hoekPunt2_verschillend(){
        Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);
        Driehoek andereDriehoek = new Driehoek(zelfdeAlsPunt1, verschillendVanPunt2, zelfdeAlsPunt3);
        assertFalse(drieHoek.equals(andereDriehoek));
    }

    @Test
    public void equals_moet_false_teruggeven_als_hoekPunt3_verschillend(){
        Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);
        Driehoek andereDriehoek = new Driehoek(zelfdeAlsPunt1, zelfdeAlsPunt2, verschillendVanPunt3);
        assertFalse(drieHoek.equals(andereDriehoek));
    }

    @Test
    public void equals_moet_false_teruggeven_als_parameter_null(){
        Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);
        assertFalse(drieHoek.equals(null));
    }

    @Test
    public void getOmhullende_geeft_false_als_het_de_foute_output_is() {
        assertNotEquals(driehoek.getOmhullende(), omhullende);
    }

    @Test
    public void getOmhullende_geeft_true_als_het_de_juiste_output_is() {
        assertEquals(driehoek.getOmhullende().getLinkerBovenhoek(), omhullende2.getLinkerBovenhoek());
        assertEquals(driehoek.getOmhullende().getBreedte(), omhullende2.getBreedte());
        assertEquals(driehoek.getOmhullende().getHoogte(), omhullende2.getHoogte());
    }
}