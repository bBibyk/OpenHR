package personnel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Profil {
    private String poste;
    private String departement;
    private Contrat contrat;
    private Set<String> certifications;
    private Set<String> formations;

    public Profil(String poste, String departement, Contrat contrat, Set<String> certifications, Set<String> formations) {
        this.poste = poste;
        this.departement = departement;
        this.contrat = contrat;
        this.certifications = certifications;
        this.formations = formations;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Profil profil) {
            return ((profil.poste == null || poste.equals(profil.poste))
                    && (profil.departement == null || departement.equals(profil.departement))
                    && (profil.formations == null || formations.containsAll(profil.formations))
                    && (profil.certifications == null || certifications.containsAll(profil.certifications))
                    && contrat.equals(profil.contrat));
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 31 * (poste.hashCode() + departement.hashCode() + contrat.hashCode() + certifications.hashCode() + formations.hashCode());
    }

    public List<String> toStringList() {
        List<String> result = new ArrayList<>();
        result.add(poste);
        result.add(departement);
        result.addAll(contrat.toStringList());
        result.add(certifications.toString());
        result.add(formations.toString());
        return result;
    }

    public String getPoste() {
        return poste;
    }

    public String getDepartement() {
        return departement;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public void setFormations(Set<String> formations) {
        this.formations = formations;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public void setCertifications(Set<String> certifications) {
        this.certifications = certifications;
    }

    public Set<String> getCertifications() {
        return certifications;
    }

    public Set<String> getFormations() {
        return formations;
    }

    public void addFormation(String formation) {
        this.formations.add(formation);
    }

    public void addCertification(String certification) {
        this.certifications.add(certification);
    }

    @Override
    public String toString() {
        return poste + "-" + departement + "-" + contrat + "-" + certifications.toString() + "-" + formations.toString();
    }
}
