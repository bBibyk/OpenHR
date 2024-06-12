package main;

import bd.CapitalHumain;
import bd.FormulaireRecherche;
import bd.Recherche;
import bd.Resultat;
import personnel.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Initialisation : \n");
        CapitalHumain capitalHumain = new CapitalHumain();
        List<Employe> employes = capitalHumain.buildEmployes();
        System.out.println(Arrays.toString(employes.toArray()));

        System.out.println(employes.get(12));
        System.out.println(employes.get(10));

        System.out.println("Recherche : \n");
        Recherche recherche = new Recherche(employes);
        Set<String> formations = new HashSet<>();
        formations.add("B");
        FormulaireRecherche formulaire = new FormulaireRecherche();
        formulaire.setTypeContrat(TypeContrat.STAGE);
        formulaire.setSexe(Sexe.FEMME);
        Resultat result = recherche.trouver(formulaire);
        System.out.println(result);

        System.out.println(employes.get(12).equals(formulaire));
    }
}
