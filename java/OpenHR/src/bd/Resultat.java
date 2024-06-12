package bd;

import personnel.Employe;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Resultat implements Iterable<Employe> {
    private Employe[] resultats;
    private int nbResultats;

    public Resultat(List<Employe> liste) {
        nbResultats = liste.size();
        resultats = liste.toArray(new Employe[0]);
    }

    public int getNbResultats() {
        return nbResultats;
    }

    @Override
    public Iterator<Employe> iterator() {
        return new Iterateur();
    }

    private class Iterateur implements Iterator<Employe> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < nbResultats;
        }

        @Override
        public Employe next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return resultats[index++];
        }

        public Employe previous() {
            if (index == 0) {
                throw new NoSuchElementException();
            }
            return resultats[--index];
        }
    }

    @Override
    public String toString(){
        String result = "";
        for(int i = 0; i < nbResultats; i++) {
            result += resultats[i].toString() + "\n";
        }
        return result;
    }
}
