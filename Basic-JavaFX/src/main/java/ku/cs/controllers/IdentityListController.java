package ku.cs.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import ku.cs.models.Identity;
import ku.cs.models.IdentityList;
import ku.cs.services.FXRouter;
import ku.cs.services.IdentityHardCodeDataSource;

import java.io.IOException;
import ku.cs.services.Datasource;
import ku.cs.services.IdentityListFileDatasource;

public class IdentityListController {

    @FXML private ListView<Identity> IdentityListView;
    @FXML private Label nameLabel;
    @FXML private Label statusLabel;
    @FXML private Label ansloveLabel;

    @FXML private Label errorLabel;
    @FXML private TextField giveTextField;

    private Datasource<IdentityList> datasource;

    private IdentityList identityList;
    private Identity selectPerson;

    @FXML
    public void initialize() {
        errorLabel.setText("");
        clearIdentityInfo();
        //IdentityHardCodeDataSource datasource = new IdentityHardCodeDataSource();
        //Datasource<IdentityList> datasource = new IdentityHardCodeDataSource();
        //Datasource<IdentityList> datasource = new IdentityListFileDatasource("data", "Identitylist.csv");
        datasource = new IdentityListFileDatasource("data", "IdentityList.cvs");

        identityList = datasource.readData();
        showList(identityList);
        IdentityListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Identity>() {
            @Override
            public void changed(ObservableValue<? extends Identity> observableValue, Identity oldValue, Identity newValue) {
                if (newValue == null) {
                    clearIdentityInfo();
                    selectPerson = null;
                } else {
                    showIdentityInfo(newValue);
                    selectPerson = newValue;
                }
            }
        });
    }

    private void clearIdentityInfo() {
        nameLabel.setText("");
        statusLabel.setText("");
        ansloveLabel.setText("");
    }

    private void showList(IdentityList identityList) {
        IdentityListView.getItems().clear();
        IdentityListView.getItems().addAll(identityList.getIdentities());
    }

    private void showIdentityInfo(Identity person) {
        nameLabel.setText(person.getMyFavPersonsName());
        statusLabel.setText(person.getTheirStatus());
        ansloveLabel.setText(person.getDoYouLoveThem());
    }

    @FXML
    public void onBacktowork2ButtonClick() {
        try {
            FXRouter.goTo("Identity-profile");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void onGiveButtonClick() {
        if (selectPerson != null) {
            String errorMessage = "";
            try {
                IdentityList.giveloveTold(selectPerson.getMyFavPersonsName(), giveTextField.getText());
                showIdentityInfo(selectPerson);
                datasource.writeData(identityList);
                showList(identityList);
            } catch (NumberFormatException e) {
                errorMessage = "Please insert your answer";
                errorLabel.setText(errorMessage);
            } finally {
                if (errorMessage.equals("")) {
                    giveTextField.setText("");
                }
            }
        } else {
            giveTextField.setText("");
            errorLabel.setText("");
        }
    }

}
