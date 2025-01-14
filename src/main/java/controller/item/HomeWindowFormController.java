package controller.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class HomeWindowFormController {
    public AnchorPane DashboardAnchorPane;


    public void btnOnActionCustomerForm(ActionEvent actionEvent) throws IOException {


        URL resource = this.getClass().getResource("/view/add_customer_view_form.fxml");

        assert resource != null;

        Parent load = FXMLLoader.load(resource);
        this.DashboardAnchorPane.getChildren().clear();
        this.DashboardAnchorPane.getChildren().add(load);
    }

    public void btnOnActionItemForm(ActionEvent actionEvent) throws IOException {

        URL resource = this.getClass().getResource("/view/add_item_form.fxml");

        assert resource != null;

        Parent load = FXMLLoader.load(resource);
        this.DashboardAnchorPane.getChildren().clear();
        this.DashboardAnchorPane.getChildren().add(load);
    }

    public void btnOnActionOrderForm(ActionEvent actionEvent) throws IOException {

        URL resource = this.getClass().getResource("/view/orderForm.fxml");

        assert resource != null;

        Parent load = FXMLLoader.load(resource);
        this.DashboardAnchorPane.getChildren().clear();
        this.DashboardAnchorPane.getChildren().add(load);
    }
}
