package services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


import models.Observation;

public class ServiceIndexationObservations {

    private HashMap<String, ArrayList<Observation>> observationsParNomCommun;
    private HashMap<LocalDate, ArrayList<Observation>> observationsParDate;
    private HashMap<String, HashMap<LocalDate, ArrayList<Observation>>> observationsParNomEtDate;

    /**
     * Constructeur, initialise les attributs de la classe.
     */
    public ServiceIndexationObservations() {
        observationsParNomCommun = new HashMap<String, ArrayList<Observation>>();
        observationsParDate = new HashMap<LocalDate, ArrayList<Observation>>();
        observationsParNomEtDate = new HashMap<String, HashMap<LocalDate, ArrayList<Observation>>>();
    }

    /**
     * Indexe la liste des observations afin que les observations puissent être
     * retrouvées très rapidement, ceci par nom commun, par date, et par nom commun
     * et date.
     * 
     * Cette méthode appelle la méthode indexerObservation pour toutes les
     * observations de la liste passée en paramètre.
     * 
     * @param listObservations la liste des observations à indexer
     */
    public void indexerObservations(ArrayList<Observation> listObservations) {
        for (Observation observation : listObservations) {
            indexerObservation(observation);
        }
    }

    /**
     * Indexe l'observation fournie afin que cette observation puisse être retrouvée
     * très rapidement, ceci par nom commun, par date, et par nom commun et date.
     * 
     * @param observation l'observation à indexer
     */
    public void indexerObservation(Observation observation) {
        if (observation != null) {
            // indexation par nom commun
            if (!observationsParNomCommun.containsKey(observation.getNomCommun())) {
                observationsParNomCommun.put(observation.getNomCommun(), new ArrayList<Observation>());
            }
            observationsParNomCommun.get(observation.getNomCommun()).add(observation);
            Collections.sort(observationsParNomCommun.get(observation.getNomCommun()));

            // indexation par date
            if (!observationsParDate.containsKey(observation.getDate())) {
                observationsParDate.put(observation.getDate(), new ArrayList<Observation>());
            }
            observationsParDate.get(observation.getDate()).add(observation);

            // indexation par nom et date
            if (!observationsParNomEtDate.containsKey(observation.getNomCommun())) {
                observationsParNomEtDate.put(observation.getNomCommun(),
                        new HashMap<LocalDate, ArrayList<Observation>>());
            }
            if (!observationsParNomEtDate.get(observation.getNomCommun()).containsKey(observation.getDate())) {
                observationsParNomEtDate.get(observation.getNomCommun()).put(observation.getDate(),
                        new ArrayList<Observation>());
            }
            observationsParNomEtDate.get(observation.getNomCommun()).get(observation.getDate()).add(observation);
        }
    }

    /**
     * Retourne très rapidement les observations en lien avec le nom commun fourni,
     * triées par ordre chronologique inverse de la date d'observation.
     * (la date la plus récente est au début de la liste)
     * 
     * @param nomCommun le nom correspondant aux observations à retourner
     * @return la liste des observations
     */
    public ArrayList<Observation> getObservationsParNomCommun(String nomCommun) {
        ArrayList<Observation> resultat;

        if (observationsParNomCommun.containsKey(nomCommun)) {
            resultat = observationsParNomCommun.get(nomCommun);
        } else {
            resultat = new ArrayList<>();
        }
        return resultat;
    }

    /**
     * Retourne très rapidement les observations de la date passée en paramètre.
     * 
     * @param date la date correspondant aux observations à retourner
     * @return la liste des observations
     */
    public ArrayList<Observation> getObservationsParDate(LocalDate date) {
        ArrayList<Observation> resultat;

        if (!observationsParDate.containsKey(date)) {
            resultat = observationsParDate.get(date);
        } else {
            resultat = new ArrayList<>();
        }
        return resultat;
    }

    /**
     * Retourne très rapidement les observations du nom et de la date passés en
     * paramètre,
     * 
     * @param nomCommun le nom correspondant aux observations à retourner
     * @param date      la date correspondant aux observations à retourner
     * @return la liste des observations
     */
    public ArrayList<Observation> getObservationsParNomCommunEtDate(String nomCommun, LocalDate date) {
        ArrayList<Observation> resultat = null;

        if (observationsParNomEtDate.containsKey(nomCommun)) {
            if (observationsParNomEtDate.get(nomCommun).containsKey(date)) {
                resultat = observationsParNomEtDate.get(nomCommun).get(date);
            } 
        } else {
            resultat = new ArrayList<>();
        }
        return resultat;
    }

}
