package controller.login;

import controller.signIn.SignInController;
import dbconnection.DBConnection;
import org.jasypt.util.text.BasicTextEncryptor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    public static LoginController instance;
    public BasicTextEncryptor basicTextEncryptor;
    private  LoginController(){
        basicTextEncryptor = new BasicTextEncryptor();
        basicTextEncryptor.setPassword(SignInController.getInstance().key);

    }

    public static LoginController getInstance(){
        return instance==null?instance=new LoginController():instance;
    }

    public int login(String userName,String Password){
        try {
            ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery("Select * from Users");
            System.out.println( basicTextEncryptor);
            while (rst.next()){
                if (rst.getString(3).equals(userName)){
                    ResultSet rst1 = DBConnection.getInstance().getConnection().createStatement().executeQuery("Select * from Users where email='"+userName+"'");
                    if(basicTextEncryptor.decrypt(rst.getString(4)).equals(Password)){
                        return rst.getInt(1);
                    }
                }

            }
            return -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
