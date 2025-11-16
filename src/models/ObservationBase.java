package models;

import java.time.*;

public class ObservationBase {

    private LocalDate date;
    private String auteur;
    private String notes;

    public ObservationBase(LocalDate date, String auteur, String notes) {
        this.date = date;
        this.auteur = auteur;
        this.notes = notes;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return  this.getDate() + " / " + this.getAuteur();
    }

    public int compareTo(ObservationBase autreObservation){
        return autreObservation.getDate().compareTo(autreObservation.getDate());
    }
}
