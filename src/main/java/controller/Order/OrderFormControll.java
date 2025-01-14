package controller.Order;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Duration;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;

public class OrderFormControll implements Initializable {
    public Label lblDate;
    public Label lblTime;
    public Label lblOrderId;
    public ComboBox cmbCusId;
    public Label lblCusName;
    public ComboBox cmbItemCode;
    public TextField txtFieldDes;
    public TextField txtFieldPrice;
    public TextField txtFieldQtyOnHand;
    public TextField txtFieldQty;
    public TableView tblOrderDetails;
    public TableColumn colCode;
    public TableColumn colDes;
    public TableColumn colQty;
    public TableColumn colPrice;
    public TableColumn colTotal;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        updateDate();
        reloadOrderId();
    }

    public void reloadOrderId(){
        lblOrderId.setText(OrderControll.getInstance().getOrderId());
    }

    public void updateDate(){
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(f.format(date));


            Timeline time = new Timeline(new KeyFrame(Duration.ZERO, e -> {
                LocalTime cTime = LocalTime.now();
                lblTime.setText(
                        cTime.getHour() + ":" + cTime.getMinute() + ":" + cTime.getSecond()
                );
            }),
                    new KeyFrame(Duration.seconds(1))
            );
            time.setCycleCount(Animation.INDEFINITE);
            time.play();


    }

    public void btnOnClickActionAdd(ActionEvent actionEvent) {
    }

    public void btnOnClickActionRemove(ActionEvent actionEvent) {
    }
}
