package personnel;

import java.util.Arrays;
import java.util.List;

public class Historique {
    private int[] heuresAbsences;
    private int[] joursCongesVacances;
    private int[] joursCongesMaladie;

    public Historique(int[] heuresAbsences, int[] joursCongesVacances, int[] joursCongesMaladie) {
        this.heuresAbsences = heuresAbsences;
        this.joursCongesVacances = joursCongesVacances;
        this.joursCongesMaladie = joursCongesMaladie;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Historique historique) {
            return ((historique.heuresAbsences == null || Arrays.equals(heuresAbsences, historique.heuresAbsences))
                    && (historique.joursCongesVacances == null || Arrays.equals(joursCongesVacances, historique.joursCongesVacances))
                    && (historique.joursCongesMaladie == null || Arrays.equals(joursCongesMaladie, historique.joursCongesMaladie)));
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 31 * (Arrays.hashCode(heuresAbsences) + Arrays.hashCode(joursCongesVacances) + Arrays.hashCode(joursCongesMaladie));
    }

    @Override
    public String toString() {
        return Arrays.toString(heuresAbsences) + "-"
                + Arrays.toString(joursCongesVacances) + "-" + Arrays.toString(joursCongesMaladie);
    }

    public List<String> toStringList(){
        return Arrays.asList(Arrays.toString(heuresAbsences), Arrays.toString(joursCongesVacances), Arrays.toString(joursCongesMaladie));
    }

    public int[] getHeuresAbsences() {
        return heuresAbsences;
    }

    public void setHeuresAbsences(int[] heuresAbsences) {
        this.heuresAbsences = heuresAbsences;
    }

    public void setJoursCongesVacances(int[] joursCongesVacances) {
        this.joursCongesVacances = joursCongesVacances;
    }

    public void setJoursCongesMaladie(int[] joursCongesMaladie) {
        this.joursCongesMaladie = joursCongesMaladie;
    }

    public int[] getJoursCongesVacances() {
        return joursCongesVacances;
    }

    public int[] getJoursCongesMaladie() {
        return joursCongesMaladie;
    }

    public void ajouterHeureAbsence(int mois) {
        heuresAbsences[mois]++;
    }

    public void ajouterJourCongesVacances(int mois) {
        joursCongesVacances[mois]++;
    }

    public void ajouterJourCongesMaladie(int mois) {
        joursCongesMaladie[mois]++;
    }
}