package com.andy.bana_mboka.model;

/**
 *
 * @author admin
 */
public enum TypeCompte {
    PARTICULIER, ENTREPRISE;

    public static TypeCompte typeGetter(String typeCompte) {
        if (typeCompte.toLowerCase().matches(PARTICULIER.name().toLowerCase())) {
            return PARTICULIER;
        } else if (typeCompte.toLowerCase().matches(ENTREPRISE.name().toLowerCase())) {
            return ENTREPRISE;
        } else {
            return null;
        }
    }
}
