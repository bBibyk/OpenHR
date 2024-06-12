package bd;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import exceptions.ExceptionHandler;
import personnel.*;
import utils.Utils;

import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;

public class CapitalHumain {
    private List<String[]> donnees;

    public CapitalHumain() {
        try (Reader reader = Files.newBufferedReader(Path.of(System.getProperty("user.dir") + "/../../profiles.csv"))) {
            lireCSV(reader);
        } catch (Exception e) {
            ExceptionHandler.handleException(e, "Vérifiez la presence du fichier.");
        }
    }

    private void lireCSV(Reader reader) {
        try (CSVReader csvReader = new CSVReader(reader)) {
            donnees = csvReader.readAll();
        } catch (Exception e) {
            ExceptionHandler.handleException(e, "Réessayez la lecture de la base de données.");
        }
    }
    
    public boolean sauvegarder(List<Employe> employes) {
        List<String[]> lines = unbuildEmployes(employes);
        lines.addFirst(donnees.getFirst());
        try (CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("user.dir") + "/../../profiles.csv"))) {
            writer.writeAll(lines);
            return true;
        } catch (Exception e) {
            ExceptionHandler.handleException(e, "Vérifiez la presence du fichier.");
            return false;
        }
    }

    public List<Employe> buildEmployes() {
        List<Employe> employes = new ArrayList<>();
        for(int i = 1; i < donnees.size(); i++) {
            employes.add(Utils.stringArrayToEmploye(donnees.get(i)));
        }
        return employes;
    }
    
    private List<String[]> unbuildEmployes(List<Employe> employes) {
        List<String[]> result = new ArrayList<>();
        for(Employe e : employes) {
            result.add(e.toStringArray());
        }
        return result;
    }


}
