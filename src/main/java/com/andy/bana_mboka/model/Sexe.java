
package com.andy.bana_mboka.model;

/**
 *
 * @author admin
 */
public enum Sexe {
    MASCULIN('M'),FEMININ('F');
    char Code;

    private Sexe(char Code) {
        this.Code = Code;
    }
    public static Sexe codeToSexe(char code){
        if(code=='M')return MASCULIN;
        if(code=='m')return MASCULIN;
        if(code=='F')return FEMININ;
        if(code=='f')return FEMININ;
        throw new UnsupportedOperationException("Caractere invalide");
    }
}
