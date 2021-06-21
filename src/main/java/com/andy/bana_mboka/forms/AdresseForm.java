package com.andy.bana_mboka.forms;

import com.andy.bana_mboka.model.Adresse;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author admin
 */
public class AdresseForm {

    public static final String PROVINCE = "province";
    public static final String VILLE = "ville";
    public static final String COMMUNE = "commune";
    public static final String QUARTIER = "quartier";
    public static final String AVENUE = "avenue";
    public static final String NUMERO = "numero";

    static Integer numeroGetter(HttpServletRequest req) throws FormException {
        String num = req.getParameter(NUMERO);
        int a;
        try {
            a = Integer.valueOf(num).intValue();
            return a;
        } catch (NullPointerException ex) {
            throw new FormException("Aucune donnée à convertir");
        } catch (NumberFormatException nb) {
            throw new FormException("Impossible de convertir cette donnée");
        }
    }

    static String valueValidator(HttpServletRequest req, String champ) throws FormException {
        String val = valueGetter(req, champ);
        try {
            val = val.toLowerCase(Locale.ROOT);
            return val;
        } catch (NullPointerException ex) {
            throw new FormException("le champ " + champ + " ne doit pas etre vide");
        }
    }

    static String valueGetter(HttpServletRequest req, String champ) {
        return req.getParameter(champ);
    }

    public static Adresse getAdress(HttpServletRequest req) throws FormException {
        Adresse adresse = new Adresse();

        String province = valueValidator(req, PROVINCE);
        adresse.setProvince(province);
        String ville = valueValidator(req, VILLE);
        adresse.setVille(ville);
        int num = numeroGetter(req);
        adresse.setNumero(num);

        String commune = valueGetter(req, COMMUNE);
        String quartier = valueGetter(req, QUARTIER);
        String avenue = valueGetter(req, AVENUE);
        adresse.setCommune(commune);
        adresse.setQuartier(quartier);
        adresse.setAvenue(avenue);

        return adresse;
    }
}
