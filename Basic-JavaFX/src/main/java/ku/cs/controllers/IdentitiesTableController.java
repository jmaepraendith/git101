package ku.cs.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ku.cs.models.Identity;
import ku.cs.models.IdentityList;
import ku.cs.services.Datasource;
import ku.cs.services.FXRouter;
import ku.cs.services.IdentityListFileDatasource;

import java.io.IOException;

public class IdentitiesTableController {

    @FXML
    private TableView identityTableView;
    private IdentityList identityList;
    private Datasource<IdentityList> datasource;

    @FXML
    public void initialize() {
        datasource = new IdentityListFileDatasource("data", "IdentityList.csv");
        identityList = datasource.readData();
        showTable(identityList);

        identityTableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Identity>() {
            @Override
            public void changed(ObservableValue observable, Identity oldValue, Identity newValue) {
                if (newValue != null) {
                    try {
                        // FXRouter.goTo สามารถส่งข้อมูลไปยังหน้าที่ต้องการได้ โดยกำหนดเป็น parameter ที่สอง
                        FXRouter.goTo("Identity-love", newValue.getMyFavPersonsName());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

    }

    private void showTable(IdentityList identityList) {
        TableColumn<Identity, String> NameColumn = new TableColumn<>("Name");
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("MyFavPersonsName"));

        TableColumn<Identity, String> StatusColumn = new TableColumn<>("Status");
        StatusColumn.setCellValueFactory(new PropertyValueFactory<>("TheirStatus"));

        TableColumn<Identity, String> doyoulovethemColumn = new TableColumn<>("Do you love them?");
        doyoulovethemColumn.setCellValueFactory(new PropertyValueFactory<>("DoYouLoveThem"));

        // ล้าง column เดิมทั้งหมดที่มีอยู่ใน table แล้วเพิ่ม column ใหม่
        identityTableView.getColumns().clear();
        identityTableView.getColumns().add(NameColumn);
        identityTableView.getColumns().add(StatusColumn);
        identityTableView.getColumns().add(doyoulovethemColumn);

        identityTableView.getItems().clear();

        // ใส่ข้อมูล Student ทั้งหมดจาก studentList ไปแสดงใน TableView
        for (Identity identity : identityList.getIdentities()) {
            identityTableView.getItems().add(identity);
        }

    }

    @FXML
    public void onBacktohelloButtonClick() {
        try {
            FXRouter.goTo("Identity-list");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

