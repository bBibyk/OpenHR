package bd;

import personnel.Employe;
import personnel.Profil;

import java.util.*;

public class Recherche {
    private Map<Profil, List<Employe>> employesTries = new HashMap<>();

    public Recherche(List<Employe> employes) {
        employesTries = new HashMap<>();

        for(Employe employe : employes) {
            Profil profil = employe.getProfil();
            employesTries.computeIfAbsent(profil, key -> new ArrayList<>());
            employesTries.get(profil).add(employe);
        }
    }

    private List<Employe> trouverParProfil(Profil profil) {
        List<Employe> result = new ArrayList<>();
        for (Map.Entry<Profil, List<Employe>> entry : employesTries.entrySet()) {
            Profil key = entry.getKey();
            List<Employe> value = entry.getValue();
            if (key.equals(profil)) {
                result.addAll(value);
            }
        }
        return result;
    }

    private List<Employe> trouverParEmploye(FormulaireRecherche formulaire){
        List<Employe> result = new ArrayList<>();
        for (List<Employe> entry : employesTries.values()) {
            for(Employe e : entry) {
                if(e.equals(formulaire)) {
                    result.add(e);
                }
            }
        }
        return result;
    }

    public Resultat trouver(FormulaireRecherche formulaire) {
        if(formulaire.estProfil()) {
            return new Resultat(trouverParProfil(formulaire.getProfil()));
        }
        return new Resultat(trouverParEmploye(formulaire));
    }
}
