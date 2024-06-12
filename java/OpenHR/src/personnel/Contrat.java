package personnel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Contrat {
    private Date debutContrat;
    private Date finContrat;
    private TypeContrat typeContrat;
    private Double tauxHoraire;
    private Double supplementHoraire;
    private Integer heuresParJour;

    public Contrat(Date debutContrat, Date finContrat, TypeContrat typeContrat, Double tauxHoraire, Double supplementHoraire, Integer heuresParJour) {
        this.debutContrat = debutContrat;
        this.finContrat = finContrat;
        this.typeContrat = typeContrat;
        this.tauxHoraire = tauxHoraire;
        this.supplementHoraire = supplementHoraire;
        this.heuresParJour = heuresParJour;
    }

    @Override
    public String toString() {
        return debutContrat + "-" + finContrat + "-" + typeContrat + "-" + tauxHoraire + "-" + supplementHoraire + "-" + heuresParJour;
    }



    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Contrat contrat) {
            return ((contrat.debutContrat == null || debutContrat.equals(contrat.debutContrat))
                    && (contrat.finContrat == null || finContrat.equals(contrat.finContrat))
                    && (contrat.typeContrat == null || typeContrat.equals(contrat.typeContrat))
                    && (contrat.tauxHoraire == null || Objects.equals(tauxHoraire, contrat.tauxHoraire))
                    && (contrat.supplementHoraire == null || Objects.equals(supplementHoraire, contrat.supplementHoraire))
                    && (contrat.heuresParJour == null || Objects.equals(heuresParJour, contrat.heuresParJour)));
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 31 * (debutContrat.hashCode() + finContrat.hashCode() + typeContrat.hashCode() + Double.hashCode(tauxHoraire) + Double.hashCode(supplementHoraire) + Integer.hashCode(heuresParJour));
    }

    public List<String> toStringList() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String debutContratFormated = simpleDateFormat.format(debutContrat);
        String finContratFormated = simpleDateFormat.format(finContrat);
        return List.of(debutContratFormated, finContratFormated, typeContrat.toString(), tauxHoraire.toString(), supplementHoraire.toString(), heuresParJour.toString());
    }

    public Date getDebutContrat() {
        return debutContrat;
    }

    public Date getFinContrat() {
        return finContrat;
    }

    public TypeContrat getTypeContrat() {
        return typeContrat;
    }

    public double getTauxHoraire() {
        return tauxHoraire;
    }

    public double getSupplementHoraire() {
        return supplementHoraire;
    }

    public int getHeuresParJour() {
        return heuresParJour;
    }

    public void setDebutContrat(Date debutContrat) {
        this.debutContrat = debutContrat;
    }

    public void setFinContrat(Date finContrat) {
        this.finContrat = finContrat;
    }

    public void setTypeContrat(TypeContrat typeContrat) {
        this.typeContrat = typeContrat;
    }

    public void setTauxHoraire(double tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }

    public void setSupplementHoraire(double supplementHoraire) {
        this.supplementHoraire = supplementHoraire;
    }

    public void setHeuresParJour(int heuresParJour) {
        this.heuresParJour = heuresParJour;
    }
}
