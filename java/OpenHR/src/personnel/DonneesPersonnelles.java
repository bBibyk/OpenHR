package personnel;

import java.util.List;

public class DonneesPersonnelles {
    private String nom;
    private String prenom;
    private String contactNumero;
    private String contactEmail;
    private Sexe sexe;

    public DonneesPersonnelles(String nom , String prenom, String contactNumero, String contactEmail, Sexe sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.contactNumero = contactNumero;
        this.contactEmail = contactEmail;
    }

    public String getNom() {
        return nom;
    }

    public String getContactNumero() {
        return contactNumero;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public void setContactNumero(String contactNumero) {
        this.contactNumero = contactNumero;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DonneesPersonnelles donneesPersonnelles) {
            return ((donneesPersonnelles.nom == null || nom.equals(donneesPersonnelles.nom))
                    && (donneesPersonnelles.prenom == null || prenom.equals(donneesPersonnelles.prenom))
                    && (donneesPersonnelles.contactNumero == null || contactNumero.equals(donneesPersonnelles.contactNumero))
                    && (donneesPersonnelles.contactEmail == null || contactEmail.equals(donneesPersonnelles.contactEmail))
                    && (donneesPersonnelles.sexe == null || sexe.equals(donneesPersonnelles.sexe)));
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 31 * (nom.hashCode() + prenom.hashCode() + contactNumero.hashCode() + contactEmail.hashCode() + sexe.hashCode());
    }

    @Override
    public String toString() {
        return nom + "-" + prenom + "-" + contactNumero + "-" + contactEmail + "-" + sexe;
    }

    public List<String> toStringList() {
        return List.of(nom, prenom, contactNumero, contactEmail, sexe.toString());
    }
}