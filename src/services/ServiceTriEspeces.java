package services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

import models.EspeceDetail;

public class ServiceTriEspeces {

    /**
     * Trie la listeDesEpspece par ordre alphabétiquer du nom commun, sans modifier
     * l'ordre de la liste passée en paramètre
     * 
     * @param lstEspeceDetails la liste des espèces à trier.
     * 
     * @return une nouvelle liste des espèces triées
     */
    public TreeSet<EspeceDetail> getEspecesTrieesParNomCommun(ArrayList<EspeceDetail> lstEspeceDetails) {

        TreeSet<EspeceDetail> listeDesEspecesTriee = new TreeSet<EspeceDetail>(lstEspeceDetails);

        Collections.sort(listeDesEspecesTriee, new Comparator<EspeceDetail>() {
            @Override
            public int compareTo(EspeceDetail espece1, EspeceDetail espece2) {
                return espece1.getNomCommun().compare(espece2.getNomCommun());
            }
        });
        return listeDesEspecesTriee;

    }

    /**
     * Trie la listeDesEpspece par ordre alphabétiquer du nom scientifique, sans
     * modifier l'ordre de la liste
     * passée en paramètre
     * 
     * @param lstEspeceDetails la liste des espèces à trier.
     * 
     * @return une nouvelle liste des espèces triées
     */
    public ArrayList<EspeceDetail> getEspecesTrieesParNomScientifique(ArrayList<EspeceDetail> lstEspeceDetails) {

        ArrayList<EspeceDetail> listeDesEspecesTriee = new ArrayList<EspeceDetail>(lstEspeceDetails);
        // Dans ce cas on profite de la méthode compareTo, surchargée dans la classe
        // Espece, qui implémente l'interface Comparable
        Collections.sort(listeDesEspecesTriee);
        return listeDesEspecesTriee;
    }

    /**
     * Trie la listeDesEpspece par le nombre de ponte. Si le nombre de ponte est
     * égale entre deux espèces, trie alors par la durée de séjour au nid.
     * 
     * @param lstEspeceDetails la liste des espèces à trier.
     * 
     * @return une nouvelle liste des espèces triées
     */
    public ArrayList<EspeceDetail> getEspecesTrieesParPonte(ArrayList<EspeceDetail> lstEspeceDetails) {

        ArrayList<EspeceDetail> listeDesEspecesTriee = new ArrayList<EspeceDetail>(lstEspeceDetails);
        Collections.sort(listeDesEspecesTriee, new Comparator<EspeceDetail>() {
            @Override
            public int compare(EspeceDetail espece1, EspeceDetail espece2) {
                int resultat;

                resultat = espece1.getCaracteristiques().getDureeSejourNidJours()
                        .compareTo(espece2.getCaracteristiques().getNombreDePontes());
                if (resultat == 0) {
                    resultat = espece1.getCaracteristiques().getDureeSejourNidJours()
                            .compareTo(espece2.getCaracteristiques().getNombreDePontes());
                }
                return resultat;
            }
        });
        return listeDesEspecesTriee;
    }
}
