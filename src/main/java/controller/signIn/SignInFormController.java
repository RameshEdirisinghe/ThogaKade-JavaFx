package controller.signIn;

import controller.item.ItemController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Item;

import java.io.IOException;

public class SignInFormController {
    public TextField lblUserName;
    public TextField lblEmail;
    public TextField lblPassword;

    public void btnOnActionSignIn(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            if(SignInController.getInstance().addUser(lblUserName.getText(),lblEmail.getText(),lblPassword.getText())){
                new Alert(Alert.AlertType.INFORMATION,"Sign In Successful...").show();
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/loginForm.fxml"))));
                stage.show();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
