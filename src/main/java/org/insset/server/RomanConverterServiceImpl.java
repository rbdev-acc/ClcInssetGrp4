/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.RomanConverterService;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author user
 */
@SuppressWarnings("serial")
public class RomanConverterServiceImpl extends RemoteServiceServlet implements
        RomanConverterService {

    @Override
    public String convertDateYears(String nbr) throws IllegalArgumentException {
        //Implement your code
        if (nbr == null || !nbr.matches("\\d{2}/\\d{2}/\\d{4}")) {     // \\d  pour décimale le {2} pour 2 décimales à la suite
            throw new IllegalArgumentException("Le format de la date doit être 'DD/MM/YYYY'.");
        }

        // Séparer le jour, le mois et l'année
        String[] dateParts = nbr.split("/");
        int day = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int year = Integer.parseInt(dateParts[2]);

        // Convertir chaque partie en chiffres romains
        String dayRoman = convertArabeToRoman(day);
        String monthRoman = convertArabeToRoman(month);
        String yearRoman = convertArabeToRoman(year);

        // Construire la date modifiée
        String datemodif = dayRoman + "/" + monthRoman + "/" + yearRoman;
        return datemodif;
    
    }

    @Override
    public Integer convertRomanToArabe(String nbr) throws IllegalArgumentException {
        if (nbr == null || nbr.isEmpty()) {
            throw new IllegalArgumentException("Le nombre romain ne peut pas être vide ou nul.");
        }

        // Map des valeurs romaines et leurs équivalents en chiffres arabes
        Map<Character, Integer> romanToArabicMap = new HashMap<>();  // C'était soit une map soit un dictionnaire 
        romanToArabicMap.put('I', 1);
        romanToArabicMap.put('V', 5);
        romanToArabicMap.put('X', 10);
        romanToArabicMap.put('L', 50);
        romanToArabicMap.put('C', 100);
        romanToArabicMap.put('D', 500);
        romanToArabicMap.put('M', 1000);

        int length = nbr.length();
        int total = 0;
        int previousValue = 0;

        // Parcourir le nombre romain de droite à gauche
        for (int i = length - 1; i >= 0; i--) {
            char currentChar = nbr.charAt(i);
            int currentValue = romanToArabicMap.getOrDefault(currentChar, -1); // .getOrDefault pour récupérer la valeur dans le dico , -1 comme retour si existe pas

            if (currentValue == -1) {
                throw new IllegalArgumentException("Caractère invalide dans le nombre romain : " + currentChar);
            }

            // Si la valeur actuelle est inférieure à la valeur précédente, elle doit être soustraite
            if (currentValue < previousValue) {
                total -= currentValue;
            } else {
                // Sinon, elle doit être ajoutée
                total += currentValue;
            }

            // Mettre à jour la valeur précédente
            previousValue = currentValue;
        }

        return total;
    }

    @Override
    public String convertArabeToRoman(Integer nbr) throws IllegalArgumentException {
        if (nbr == null || nbr <= 0 || nbr >= 3000) {
            throw new IllegalArgumentException("Le nombre arabe doit être compris entre 1 et 3000.");
        }

        // Tableau des valeurs arabes et leurs équivalents romains
        int[] arabicValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();

        // Conversion du nombre arabe en chiffre romain
        for (int i = 0; i < arabicValues.length; i++) {
            while (nbr >= arabicValues[i]) {
                result.append(romanSymbols[i]);
                nbr -= arabicValues[i];
            }
        }

        return result.toString();
    }

}
