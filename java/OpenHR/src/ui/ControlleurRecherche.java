package ui;

import bd.CapitalHumain;
import bd.FormulaireRecherche;
import bd.Recherche;
import bd.Resultat;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import personnel.Employe;
import utils.Utils;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.time.ZoneId;
import java.util.*;

public class ControlleurRecherche implements Initializable {
    private CapitalHumain capitalHumain = new CapitalHumain();
    private List<Employe> employes = capitalHumain.buildEmployes();
    private Resultat resultat;

    @FXML
    private ComboBox<String> comboBoxTypeContrat;

    @FXML
    private Button buttonRecherche;

    @FXML
    private TreeTableColumn<?, ?> columnGenre;

    @FXML
    private TreeTableColumn<?, ?> columnMail;

    @FXML
    private TreeTableColumn<?, ?> columnNIE;

    @FXML
    private TreeTableColumn<?, ?> columnNom;

    @FXML
    private TreeTableColumn<?, ?> columnNumero;

    @FXML
    private TreeTableColumn<?, ?> columnPoste;

    @FXML
    private TreeTableColumn<?, ?> columnPrenom;

    @FXML
    private ComboBox<String> comboBoxSexe;

    @FXML
    private DatePicker datePickerDebutContrat;

    @FXML
    private DatePicker datePickerFinContrat;

    @FXML
    private AnchorPane formulaiireAnchor;

    @FXML
    private AnchorPane resultatsAnchor;

    @FXML
    private Spinner<Integer> spinnerCM1;

    @FXML
    private Spinner<Integer> spinnerCM10;

    @FXML
    private Spinner<Integer> spinnerCM11;

    @FXML
    private Spinner<Integer> spinnerCM12;

    @FXML
    private Spinner<Integer> spinnerCM2;

    @FXML
    private Spinner<Integer> spinnerCM3;

    @FXML
    private Spinner<Integer> spinnerCM4;

    @FXML
    private Spinner<Integer> spinnerCM5;

    @FXML
    private Spinner<Integer> spinnerCM6;

    @FXML
    private Spinner<Integer> spinnerCM7;

    @FXML
    private Spinner<Integer> spinnerCM8;

    @FXML
    private Spinner<Integer> spinnerCM9;

    @FXML
    private Spinner<Integer> spinnerCV1;

    @FXML
    private Spinner<Integer> spinnerCV10;

    @FXML
    private Spinner<Integer> spinnerCV11;

    @FXML
    private Spinner<Integer> spinnerCV12;

    @FXML
    private Spinner<Integer> spinnerCV2;

    @FXML
    private Spinner<Integer> spinnerCV3;

    @FXML
    private Spinner<Integer> spinnerCV4;

    @FXML
    private Spinner<Integer> spinnerCV5;

    @FXML
    private Spinner<Integer> spinnerCV6;

    @FXML
    private Spinner<Integer> spinnerCV7;

    @FXML
    private Spinner<Integer> spinnerCV8;

    @FXML
    private Spinner<Integer> spinnerCV9;

    @FXML
    private Spinner<Integer> spinnerHA1;

    @FXML
    private Spinner<Integer> spinnerHA10;

    @FXML
    private Spinner<Integer> spinnerHA11;

    @FXML
    private Spinner<Integer> spinnerHA12;

    @FXML
    private Spinner<Integer> spinnerHA2;

    @FXML
    private Spinner<Integer> spinnerHA3;

    @FXML
    private Spinner<Integer> spinnerHA4;

    @FXML
    private Spinner<Integer> spinnerHA5;

    @FXML
    private Spinner<Integer> spinnerHA6;

    @FXML
    private Spinner<Integer> spinnerHA7;

    @FXML
    private Spinner<Integer> spinnerHA8;

    @FXML
    private Spinner<Integer> spinnerHA9;

    @FXML
    private Spinner<Integer> spinnerHPJ;

    @FXML
    private TreeTableView<?> tableResultats;

    @FXML
    private TextField textFieldCertifications;

    @FXML
    private TextField textFieldFormations;

    @FXML
    private TextField textFieldNIE;

    @FXML
    private TextField textFieldNIEs;

    @FXML
    private TextField textFieldNom;

    @FXML
    private TextField textFieldPoste;

    @FXML
    private TextField textFieldPrenom;

    @FXML
    private TextField textFieldSup;

    @FXML
    private TextField textFieldTaux;

    @FXML
    private TextField textfieldDepartement;

    @FXML
    public void initialize(URL url, ResourceBundle resources) {


        buttonRecherche.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Recherche recherche = new Recherche(employes);
                FormulaireRecherche formulaireRecherche = new FormulaireRecherche();

                if(!textFieldNom.getText().isEmpty()) {
                    formulaireRecherche.setNom(textFieldNom.getText());
                }
                if(!textFieldPrenom.getText().isEmpty()) {
                    formulaireRecherche.setPrenom(textFieldPrenom.getText());
                }
                if(!textFieldNIE.getText().isEmpty()) {
                    formulaireRecherche.setNie(Integer.parseInt(textFieldNIE.getText()));
                }
                if(!textFieldNIEs.getText().isEmpty()) {
                    formulaireRecherche.setNieSuperviseur(Integer.parseInt(textFieldNIEs.getText()));
                }
                if(!textFieldPoste.getText().isEmpty()) {
                    formulaireRecherche.setPoste(textFieldPoste.getText());
                }
                if(!textfieldDepartement.getText().isEmpty()) {
                    formulaireRecherche.setDepartement(textfieldDepartement.getText());
                }
                if(!textFieldCertifications.getText().isEmpty()) {
                    formulaireRecherche.setCertifications(new HashSet<>(Arrays.asList(textFieldCertifications.getText().split(","))));
                }
                if(!textFieldFormations.getText().isEmpty()) {
                    formulaireRecherche.setFormations(new HashSet<>(Arrays.asList(textFieldFormations.getText().split(","))));
                }
                if(!textFieldTaux.getText().isEmpty()) {
                    formulaireRecherche.setTauxHoraire(Double.parseDouble(textFieldTaux.getText()));
                }
                if(!textFieldSup.getText().isEmpty()) {
                    formulaireRecherche.setSupplementHoraire(Double.parseDouble(textFieldSup.getText()));
                }
                if(!comboBoxSexe.getSelectionModel().isEmpty()) {
                    formulaireRecherche.setSexe(Utils.stringToSexe(comboBoxSexe.getSelectionModel().getSelectedItem()));
                }
                if(!comboBoxTypeContrat.getSelectionModel().isEmpty()) {
                    formulaireRecherche.setTypeContrat(Utils.stringToTypeContrat(comboBoxTypeContrat.getSelectionModel().getSelectedItem()));
                }

                if(!(spinnerCM1.getValue()==0 && spinnerCM2.getValue()==0 && spinnerCM3.getValue()==0 && spinnerCM4.getValue()==0 && spinnerCM5.getValue()==0
                        && spinnerCM6.getValue()==0 && spinnerCM7.getValue()==0 && spinnerCM8.getValue()==0 && spinnerCM9.getValue()==0 && spinnerCM10.getValue()==0
                        && spinnerCM11.getValue()==0 && spinnerCM12.getValue()==0)) {
                    formulaireRecherche.setJoursCongesMaladie(new int[]{spinnerCM1.getValue(), spinnerCM2.getValue(), spinnerCM3.getValue(), spinnerCM4.getValue(),
                            spinnerCM5.getValue(), spinnerCM6.getValue(), spinnerCM7.getValue(), spinnerCM8.getValue(), spinnerCM9.getValue(), spinnerCM10.getValue(),
                            spinnerCM11.getValue(), spinnerCM12.getValue()});
                }

                if(!(spinnerCV1.getValue()==0 && spinnerCV2.getValue()==0 && spinnerCV3.getValue()==0 && spinnerCV4.getValue()==0 && spinnerCV5.getValue()==0
                        && spinnerCV6.getValue()==0 && spinnerCV7.getValue()==0 && spinnerCV8.getValue()==0 && spinnerCV9.getValue()==0 && spinnerCV10.getValue()==0
                        && spinnerCV11.getValue()==0 && spinnerCV12.getValue()==0)) {
                    formulaireRecherche.setJoursCongesVacances(new int[]{spinnerCV1.getValue(), spinnerCV2.getValue(), spinnerCV3.getValue(), spinnerCV4.getValue(),
                            spinnerCV5.getValue(), spinnerCV6.getValue(), spinnerCV7.getValue(), spinnerCV8.getValue(), spinnerCV9.getValue(), spinnerCV10.getValue(),
                            spinnerCV11.getValue(), spinnerCV12.getValue()});
                }

                if(!(spinnerHA1.getValue()==0 && spinnerHA2.getValue()==0 && spinnerHA3.getValue()==0 && spinnerHA4.getValue()==0 && spinnerHA5.getValue()==0
                        && spinnerHA6.getValue()==0 && spinnerHA7.getValue()==0 && spinnerHA8.getValue()==0 && spinnerHA9.getValue()==0 && spinnerHA10.getValue()==0
                        && spinnerHA11.getValue()==0 && spinnerHA12.getValue()==0)) {
                    formulaireRecherche.setHeuresAbsences(new int[]{spinnerHA1.getValue(), spinnerHA2.getValue(), spinnerHA3.getValue(), spinnerHA4.getValue(),
                            spinnerHA5.getValue(), spinnerHA6.getValue(), spinnerHA7.getValue(), spinnerHA8.getValue(), spinnerHA9.getValue(), spinnerHA10.getValue(),
                            spinnerHA11.getValue(), spinnerHA12.getValue()});
                }

                if(datePickerDebutContrat.getValue()!=null) {
                    formulaireRecherche.setDebutContrat(Date.from(datePickerDebutContrat.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
                }

                if(datePickerFinContrat.getValue()!=null) {
                    formulaireRecherche.setFinContrat(Date.from(datePickerFinContrat.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
                }

                resultat = recherche.trouver(formulaireRecherche);

                System.out.println(resultat);
            }
        });

        initializeAllSpinners();

        comboBoxSexe.setItems(FXCollections.observableArrayList("HOMME", "FEMME"));
        comboBoxTypeContrat.setItems(FXCollections.observableArrayList("CDD", "CDI", "APPRENTISSAGE", "PROFESSIONNALISATION", "STAGE"));



    }

    private void initializeAllSpinners(){
        initializeSpinner(spinnerCM1, 31);
        initializeSpinner(spinnerCM2, 31);
        initializeSpinner(spinnerCM3, 31);
        initializeSpinner(spinnerCM4, 31);
        initializeSpinner(spinnerCM5, 31);
        initializeSpinner(spinnerCM6, 31);
        initializeSpinner(spinnerCM7, 31);
        initializeSpinner(spinnerCM8, 31);
        initializeSpinner(spinnerCM9, 31);
        initializeSpinner(spinnerCM10, 31);
        initializeSpinner(spinnerCM11, 31);
        initializeSpinner(spinnerCM12, 31);

        initializeSpinner(spinnerCV1, 31);
        initializeSpinner(spinnerCV2, 31);
        initializeSpinner(spinnerCV3, 31);
        initializeSpinner(spinnerCV4, 31);
        initializeSpinner(spinnerCV5, 31);
        initializeSpinner(spinnerCV6, 31);
        initializeSpinner(spinnerCV7, 31);
        initializeSpinner(spinnerCV8, 31);
        initializeSpinner(spinnerCV9, 31);
        initializeSpinner(spinnerCV10, 31);
        initializeSpinner(spinnerCV11, 31);
        initializeSpinner(spinnerCV12, 31);

        initializeSpinner(spinnerHA1, 744);
        initializeSpinner(spinnerHA2, 744);
        initializeSpinner(spinnerHA3, 744);
        initializeSpinner(spinnerHA4, 744);
        initializeSpinner(spinnerHA5, 744);
        initializeSpinner(spinnerHA6, 744);
        initializeSpinner(spinnerHA7, 744);
        initializeSpinner(spinnerHA8, 744);
        initializeSpinner(spinnerHA9, 744);
        initializeSpinner(spinnerHA10, 744);
        initializeSpinner(spinnerHA11, 744);
        initializeSpinner(spinnerHA12, 744);

        initializeSpinner(spinnerHPJ, 24);
    }

    private void initializeSpinner(Spinner<Integer> spinner, Integer maxValue) {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, maxValue);
        valueFactory.setValue(0);
        spinner.setValueFactory(valueFactory);
    }
}
