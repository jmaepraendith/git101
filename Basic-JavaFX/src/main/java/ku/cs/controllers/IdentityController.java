package ku.cs.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ku.cs.models.Identity;
import ku.cs.services.FXRouter;
import java.io.IOException;

public class IdentityController {
    @FXML
    Label myfavpersonsnameLabel;
    @FXML
    Label theirstatusLabel;
    @FXML
    Label myfavnumberLabel;
    @FXML
    Label calculateSquareLabel;

    @FXML
    public void initialize() {
        Identity identity = new Identity("Alexandra Mikhailov", "Fictional Character",1945 );
        showIdentity(identity);
    }

    private void showIdentity(Identity identity) {
        myfavpersonsnameLabel.setText(identity.getMyFavPersonsName());
        theirstatusLabel.setText(identity.getTheirStatus());
        String numberformat = String.format("%d",identity.getYearThatTheyreBorn());
        myfavnumberLabel.setText(numberformat);
        String calnumber = String.format("%d",identity.CalAge());
        calculateSquareLabel.setText(calnumber);
    }

    @FXML
    protected void ontomyprofilebutton(){
        //System.out.println("it's work");
        try{
            FXRouter.goTo("hello");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}
