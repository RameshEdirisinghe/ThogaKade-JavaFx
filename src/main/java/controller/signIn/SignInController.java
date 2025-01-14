package controller.signIn;

import controller.login.LoginController;
import dbconnection.DBConnection;
import org.jasypt.util.text.BasicTextEncryptor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignInController {
    public static SignInController instance;
    public  String key="1228";
    public BasicTextEncryptor basicTextEncryptor;

    private  SignInController(){
        basicTextEncryptor = new BasicTextEncryptor();
        basicTextEncryptor.setPassword(key);
    }

    public static SignInController getInstance(){
        return instance==null?instance=new SignInController():instance;
    }

    public boolean addUser(String userName,String Email,String password){
        System.out.println(basicTextEncryptor);
        try {
            PreparedStatement prepaeStm = DBConnection.getInstance().getConnection().prepareStatement("INSERT INTO users(username,email,password) VALUES(?,?,?)");
            prepaeStm.setString(1, userName);
            prepaeStm.setString(2, Email);
            prepaeStm.setString(3, basicTextEncryptor.encrypt(password));

            return prepaeStm.executeUpdate() >0 ;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }

    }
}
