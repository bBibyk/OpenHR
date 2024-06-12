package bd;

import personnel.*;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

public class FormulaireRecherche extends Employe {
    public FormulaireRecherche() {
        super(null, null,
                new DonneesPersonnelles(null, null, null, null, null),
                new Historique(null, null, null),
                new Profil(null, null,
                        new Contrat(null, null, null, null, null, null),null, null));
    }

    public boolean estProfil() {
        return this.getDonneesPersonnelles().getContactEmail() == null
                && this.getDonneesPersonnelles().getContactNumero() == null
                && this.getDonneesPersonnelles().getPrenom() == null
                && this.getDonneesPersonnelles().getNom() == null
                && this.getDonneesPersonnelles().getSexe() == null
                && this.getHistorique().getJoursCongesMaladie() == null
                && this.getHistorique().getJoursCongesVacances() == null
                && this.getHistorique().getHeuresAbsences() == null
                && this.getNie() == null
                && this.getNieSuperviseur() == null;
    }

    public void setPoste(String poste) {
        this.getProfil().setPoste(poste);
    }

    public void setFormations(Set<String> formations) {
        this.getProfil().setFormations(formations);
    }

    public void setDepartement(String departement) {
        this.getProfil().setDepartement(departement);
    }

    public void setCertifications(Set<String> certifications) {
        this.getProfil().setCertifications(certifications);
    }

    public void setDebutContrat(Date debutContrat) {
        this.getProfil().getContrat().setDebutContrat(debutContrat);
    }

    public void setFinContrat(Date finContrat) {
        this.getProfil().getContrat().setFinContrat(finContrat);
    }

    public void setTypeContrat(TypeContrat typeContrat) {
        this.getProfil().getContrat().setTypeContrat(typeContrat);
    }

    public void setTauxHoraire(double tauxHoraire) {
        this.getProfil().getContrat().setTauxHoraire(tauxHoraire);
    }

    public void setSupplementHoraire(double supplementHoraire) {
        this.getProfil().getContrat().setSupplementHoraire(supplementHoraire);
    }

    public void setHeuresParJour(int heuresParJour) {
        this.getProfil().getContrat().setHeuresParJour(heuresParJour);
    }

    public void setHeuresAbsences(int[] heuresAbsences) {
        this.getHistorique().setHeuresAbsences(heuresAbsences);
    }

    public void setJoursCongesVacances(int[] joursCongesVacances) {
        this.getHistorique().setJoursCongesVacances(joursCongesVacances);
    }

    public void setJoursCongesMaladie(int[] joursCongesMaladie) {
        this.getHistorique().setJoursCongesMaladie(joursCongesMaladie);
    }

    public void setNom(String nom) {
        this.getDonneesPersonnelles().setNom(nom);
    }

    public void setPrenom(String prenom) {
        this.getDonneesPersonnelles().setPrenom(prenom);
    }

    public void setSexe(Sexe sexe) {
        this.getDonneesPersonnelles().setSexe(sexe);
    }
}
