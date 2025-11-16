package models;

public abstract class Espece implements IEspeceInfo, implements Comparable {
    private String nomCommun;
    private String nomScientifique;
    private String description;

    public Espece(String nomCommun, String nomScientifique, String description) {
        this.nomCommun = nomCommun;
        this.nomScientifique = nomScientifique;
        this.description = description;
    }

    @Override
    public String getNomCommun() {
        return nomCommun;
    }

    @Override
    public String getNomScientifique() {
        return nomScientifique;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
