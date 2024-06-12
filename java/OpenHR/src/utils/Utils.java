package utils;

import exceptions.ExceptionHandler;
import personnel.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Utils {
    public static Set<String> stringToSetOfString(String string) {
        if (string.equals("null")) {
            return new HashSet<>();
        }
        string = string.replace("[", "");
        string = string.replace("]", "");
        return new HashSet<>(Arrays.asList(string.split(", ")));
    }

    public static int[] stringToArrayOfInteger(String string) {
        if(string.equals("null")) {
            return new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        }
        string = string.replace("[", "");
        string = string.replace("]", "");
        String[] array = string.split(", ");
        int[] intArray = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            intArray[i] = stringToInt(array[i]);
        }
        return intArray;
    }

    public static double stringToDouble(String string) {
        if(string.equals("null")) {
            return 0.0;
        }
        return Double.parseDouble(string);
    }

    public static int stringToInt(String string) {
        if(string.equals("null")) {
            return 0;
        }
        return Integer.parseInt(string);
    }

    public static Sexe stringToSexe(String string) {
        switch (string) {
            case "HOMME":
                return Sexe.HOMME;
            case "FEMME":
                return Sexe.FEMME;
            default:
                return null;
        }
    }

    public static Date stringToDate(String string) {
        if(string.equals("null")) {
            return new Date(Long.MAX_VALUE);
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return simpleDateFormat.parse(string);
        } catch (Exception e) {
            ExceptionHandler.handleException(e, "Date invalide.");
        }
        return null;
    }

    public static TypeContrat stringToTypeContrat(String string) {
        switch (string) {
            case "CDI":
                return TypeContrat.CDI;
            case "CDD":
                return TypeContrat.CDD;
            case "APPRENTISSAGE":
                return TypeContrat.APPRENTISSAGE;
            case "PROFESSIONNALISATION":
                return TypeContrat.PROFESSIONNALISATION;
            case "STAGE":
                return TypeContrat.STAGE;
            default:
                return null;
        }
    }

    public static Contrat stringArrayToContrat(String[] row) {
        Date debutContrat = stringToDate(row[12]);
        Date finContrat = stringToDate(row[13]);
        TypeContrat typeContrat = stringToTypeContrat(row[14]);
        double tauxHoraire = stringToDouble(row[15]);
        double supplementHoraire = stringToDouble(row[16]);
        int heuresParJour = stringToInt(row[17]);
        return new Contrat(debutContrat, finContrat, typeContrat, tauxHoraire, supplementHoraire, heuresParJour);
    }

    public static Profil stringArrayToProfil(String[] row) {
        String poste = row[10];
        String departement = row[11];
        Contrat contrat = stringArrayToContrat(row);
        Set<String> certifications = stringToSetOfString(row[18]);
        Set<String> formations = stringToSetOfString(row[19]);
        return new Profil(poste, departement, contrat, certifications, formations);
    }

    public static Employe stringArrayToEmploye(String[] row) {
        int nie = stringToInt(row[0]);
        int nieSuperviseur = stringToInt(row[1]);
        DonneesPersonnelles donneesPersonnelles = new DonneesPersonnelles(row[2], row[3], row[4], row[5], stringToSexe(row[6]));
        Historique historique = new Historique(stringToArrayOfInteger(row[7]), stringToArrayOfInteger(row[8]), stringToArrayOfInteger(row[9]));
        Profil profil = stringArrayToProfil(row);
        return new Employe(nie, nieSuperviseur, donneesPersonnelles, historique, profil);
    }
}
