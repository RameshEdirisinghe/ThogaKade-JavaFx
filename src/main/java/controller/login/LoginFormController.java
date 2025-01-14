package controller.login;

import controller.item.ItemController;
import controller.signIn.SignInController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Item;

import java.io.IOException;

public class LoginFormController {


    public TextField txtUserName;
    public PasswordField txtPassword;

    public void btnOnActionLogin(ActionEvent actionEvent) {
        int usrId = LoginController.getInstance().login(txtUserName.getText(),txtPassword.getText());
        if(usrId!=-1){
            System.out.println("awa");
            newForm();
        }else{
            new Alert(Alert.AlertType.INFORMATION,"Invalid user Name or Password").show();
        }
    }

    public void newForm(){
        Stage st = new Stage();
        try {

            st.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/home_window_form.fxml"))));
            st.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void linkOnActionSignIn(ActionEvent actionEvent) {
        try {

            Stage stage = new Stage();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/signInForm.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
