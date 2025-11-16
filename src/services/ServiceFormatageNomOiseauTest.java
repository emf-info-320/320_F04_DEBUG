package services;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ServiceFormatageNomOiseauTest {
    @Test
    public void testFormatterNomOiseau() {

        ServiceFormatageNomOiseau serviceFormatageNomOiseau = new ServiceFormatageNomOiseau();

        //Pas de test: la valeur est nul
        assertEquals("entrée incorrecte", serviceFormatageNomOiseau.formatterNomOiseau(null));
        //Pas de test: la valeur est vide
        assertEquals("entrée incorrecte", serviceFormatageNomOiseau.formatterNomOiseau(""));
        //Pas de test: le valeur est mauvaise, car elle ne contient pas d'espace
         assertEquals("entrée incorrecte", serviceFormatageNomOiseau.formatterNomOiseau("Mésange"));
        //Pas de test: la valeur est bonne
         assertEquals("mésange_bleue", serviceFormatageNomOiseau.formatterNomOiseau("Mésange bleue"));
         //Pas de test: le valeur est bonne, avec plusieurs majuscules
         assertEquals("huppe_fasciée", serviceFormatageNomOiseau.formatterNomOiseau("HUPPE fasciée"));
    }
}
