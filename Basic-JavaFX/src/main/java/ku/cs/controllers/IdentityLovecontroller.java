package ku.cs.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ku.cs.models.Identity;
import ku.cs.models.IdentityList;
import ku.cs.services.Datasource;
import ku.cs.services.FXRouter;
import ku.cs.services.IdentityListFileDatasource;

import java.io.IOException;

public class IdentityLovecontroller {
    @FXML private Label nameLabel;
    @FXML private Label giveansLabel;
    @FXML private Label statusLabel ;
    @FXML private Label errorLabel;
    @FXML private TextField giveanswerTextField ;

    private Datasource<IdentityList> datasource;
    private IdentityList identityList;
    private Identity identity;

    public void initialize(){
        datasource = new IdentityListFileDatasource("data","Identitylist.csv");
        identityList = datasource.readData();

        String nameIden = (String) FXRouter.getData();
        identity = identityList.findthatperson(nameIden);
        showIdentity(identity);
        errorLabel.setText("");
    }

    private void showIdentity(Identity identity) {
        nameLabel.setText(identity.getMyFavPersonsName());
        statusLabel.setText(identity.getTheirStatus());
        giveansLabel.setText(identity.getDoYouLoveThem());
    }

    @FXML
    public void handleGiveButton() {
        String giveans = giveanswerTextField.getText().trim();
        if (giveans.equals("")) {
            errorLabel.setText("Enter your answer");
            return;
        }
        try {
            errorLabel.setText("");
            identityList.giveloveTold(identity.getMyFavPersonsName(),giveans);
            giveanswerTextField.clear();
            datasource.writeData(identityList);
            showIdentity(identity);
        } catch (NumberFormatException e) {
            errorLabel.setText("Enter your answer");
        }
    }

    @FXML
    public void handleBackToTableButton() {
        try {
            FXRouter.goTo("Identity-table");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
