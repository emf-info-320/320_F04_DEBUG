package services;

public class ServiceFormatageNomOiseau {

    /**
     * Formatte le nom d'un oiseau en le mettant en minuscule et en remplaçant les
     * espaces par des underscores.
     * 
     * Cette méthode prend en entrée une chaîne de caractères représentant le nom
     * d'un oiseau composé de deux mots séparés par un espace.
     * Elle retourne ce nom formaté avec des minuscules et un underscore à la place
     * de l'espace.
     * 
     * Si la chaîne en entrée est nulle, vide ou ne contient pas d'espace la méthode
     * retourne "entrée incorrecte".
     *
     * @param nomOiseau le nom de l'oiseau à formater. Il doit être composé de deux
     *                  mots séparés par un espace.
     * @return le nom de l'oiseau formaté en minuscules avec un underscore, ou
     *         "entrée incorrecte" si l'entrée est invalide.
     * 
     */
    public String formatterNomOiseau(String nomOiseau) {
        String resultat = "entrée incorrecte";

        if (nomOiseau != null) {
            if ((!nomOiseau.isEmpty()) && nomOiseau.contains(" ")) {
                resultat = nomOiseau.toLowerCase().replace(" ", "_");
            }
        }
        return resultat;
    }

}
