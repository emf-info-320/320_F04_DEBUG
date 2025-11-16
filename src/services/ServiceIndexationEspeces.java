package services;

import java.util.ArrayList;
import java.util.TreeSet;

import models.EspeceDetail;

public class ServiceIndexationEspeces {

    private final TreeSet<String> listNomCommuns;

    /**
     * Constructeur, initialise les attributs de la classe.
     */
    public ServiceIndexationEspeces() {

        listNomCommuns = new TreeSet<String>();
    }

    /**
     * Indexe chacune des espèces reçues de manière à ce qu'ensuite la méthode
     * getlstNomCommun() puisse faire son travail très rapidement.
     * 
     * @param listEspeceDetails la liste des espèces à indexer
     */
    public void indexerLesEspeces(ArrayList<EspeceDetail> listEspeces) {
        for (EspeceDetail especeDetail : listEspeces) {
            listNomCommuns.add(especeDetail.getNomCommun());
        }
    }

    /**
     * Retourne rapidement une nouvelle liste de tous les noms communs des espèces,
     * et ce sans doublons et triée par ordre alphabétique.
     * 
     * @return la liste précitée.
     */
    public ArrayList<String> getlstNomCommun() {
        return new ArrayList<String>(listNomCommuns);
    }
}
