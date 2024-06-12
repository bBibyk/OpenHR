package personnel;

import java.util.ArrayList;
import java.util.List;

public class Employe {
    private Integer nie;
    private Integer nieSuperviseur;
    private DonneesPersonnelles donneesPersonnelles;
    private Historique historique;
    private Profil profil;


    public Employe(Integer nie, Integer nieSuperviseur, DonneesPersonnelles donneesPersonnelles, Historique historique, Profil profil) {
        this.nie = nie;
        this.nieSuperviseur = nieSuperviseur;
        this.donneesPersonnelles = donneesPersonnelles;
        this.historique = historique;
        this.profil = profil;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Employe employe) {
            return ((employe.nie == null || nie.equals(employe.nie))
                    && (employe.nieSuperviseur == null || nieSuperviseur.equals(employe.nieSuperviseur))
                    && profil.equals(employe.profil)
                    && donneesPersonnelles.equals(employe.donneesPersonnelles)
                    && historique.equals(employe.historique));
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 31 * (nie.hashCode() + nieSuperviseur.hashCode() + profil.hashCode() + donneesPersonnelles.hashCode() + historique.hashCode());
    }

    @Override
    public String toString() {
        return nie + "-" + nieSuperviseur + "-" + donneesPersonnelles.toString() + "-" + historique.toString() + "-" + profil.toString() + "\n";
    }

    public String[] toStringArray() {
        List<String> historiqueAsList = historique.toStringList();
        List<String> profilAsList = profil.toStringList();
        List<String> donneesPersonnellesAsList = donneesPersonnelles.toStringList();
        List<String> employeAsList = new ArrayList<>();
        employeAsList.add(nie.toString());
        employeAsList.add(nieSuperviseur.toString());
        employeAsList.addAll(donneesPersonnellesAsList);
        employeAsList.addAll(historiqueAsList);
        employeAsList.addAll(profilAsList);
        return employeAsList.toArray(new String[0]);
    }

    public Integer getNie() {
        return nie;
    }

    public Integer getNieSuperviseur() {
        return nieSuperviseur;
    }

    public Profil getProfil() {
        return profil;
    }

    public DonneesPersonnelles getDonneesPersonnelles() {
        return donneesPersonnelles;
    }

    public Historique getHistorique() {
        return historique;
    }

    public void setNie(Integer nie) {
        this.nie = nie;
    }

    public void setNieSuperviseur(Integer nieSuperviseur) {
        this.nieSuperviseur = nieSuperviseur;
    }
}
