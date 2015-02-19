/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.singletons;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author User
 */
public class Singletons {
    Locale locale = new Locale.Builder().setLanguage("pt").setRegion("BR").build();
    DateFormat dateFormatMedium = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
    

    private Singletons() {
    }
    
    public static Singletons getInstance() {
        return SingletonsHolder.INSTANCE;
    }
    
    private static class SingletonsHolder {

        private static final Singletons INSTANCE = new Singletons();
    }

    public Locale getLocale() {
        return locale;
    }    

    public DateFormat getDateFormatMedium() {
        return dateFormatMedium;
    }

    public NumberFormat getCurrencyFormat() {
        return currencyFormat;
    }
    
    
    
}
