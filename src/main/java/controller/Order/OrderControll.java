package controller.Order;

import dbconnection.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderControll {
    public static OrderControll Instance;
    private OrderControll(){

    }
    public String getOrderId()  {
        

        try {
            ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery("SELECT id FROM orders ORDER BY id DESC LIMIT 1");
            if (rst.next()){
                return String.format("D%03d",(Integer.parseInt(rst.getString(1).substring(1))+1));
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static OrderControll getInstance(){
        return Instance==null?Instance=new OrderControll():Instance;
    }
}
