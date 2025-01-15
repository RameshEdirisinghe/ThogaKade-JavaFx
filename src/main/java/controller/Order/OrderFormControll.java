package controller.Order;

import controller.customer.CustomerController;
import controller.item.ItemController;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import model.*;

import javax.sound.midi.Soundbank;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
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
    ObservableList<TableOrder> itemsObservableArray = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        updateDate();
        reloadOrderId();
        reloadCustomerIdComboBox();
        reloadItemCodeComboBox();


    }

    public void reloadItemCodeComboBox(){
        ObservableList<String> itemCode = FXCollections.observableArrayList();
        ItemController.getInstance().getItemCodes().forEach(itemcode ->{
            itemCode.add(itemcode);
        });
        cmbItemCode.setItems(itemCode);
    }

    public void reloadCustomerIdComboBox(){
        ObservableList<String> cusId = FXCollections.observableArrayList();
        CustomerController.getInstance().getCustomerIDs().forEach(customerid ->{
            cusId.add(customerid);
        });
        cmbCusId.setItems(cusId);
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
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDes.setCellValueFactory(new PropertyValueFactory<>("Description"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("Qty"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("Total"));


        int index = itemsObservableArray.indexOf(new TableOrder(
                cmbItemCode.getSelectionModel().getSelectedItem().toString(),
                null,
                0,
                0.0,
                0.0));

        if(index!=-1) {
            TableOrder alreadyExitOrder = itemsObservableArray.get(index);
            itemsObservableArray.set(index,new TableOrder(
                    cmbItemCode.getSelectionModel().getSelectedItem().toString(),
                    txtFieldDes.getText(),
                    Integer.parseInt(txtFieldQty.getText())+alreadyExitOrder.getQty(),
                    Double.parseDouble(txtFieldPrice.getText()),
                    Integer.parseInt(txtFieldQty.getText())*Double.parseDouble(txtFieldPrice.getText())+alreadyExitOrder.getTotal()));
        }else {

            itemsObservableArray.add(new TableOrder(
                    cmbItemCode.getSelectionModel().getSelectedItem().toString(),
                    txtFieldDes.getText(),
                    Integer.parseInt(txtFieldQty.getText()),
                    Double.parseDouble(txtFieldPrice.getText()),
                    Integer.parseInt(txtFieldQty.getText()) * Double.parseDouble(txtFieldPrice.getText()))
            );
            tblOrderDetails.setItems(itemsObservableArray);
        }
    }

    public void btnOnClickActionRemove(ActionEvent actionEvent) {
    }

    public void changeOnActionCusId(ActionEvent actionEvent) {

        lblCusName.setText(CustomerController.getInstance().getCustomerName(cmbCusId.getSelectionModel().getSelectedItem().toString()));
    }

    public void changeOnActionItemCode(ActionEvent actionEvent) {
        Item item = ItemController.getInstance().searchItem(cmbItemCode.getSelectionModel().getSelectedItem().toString());

        txtFieldDes.setText(item.getDescription());
        txtFieldPrice.setText(item.getUnitPrice().toString());
        txtFieldQtyOnHand.setText(item.getQtyOnHand().toString());

    }


    public void btnOnActionPlaceOrder(ActionEvent actionEvent) {
        ArrayList<OrderDetail> orderDetails = new ArrayList<>();
        orderDetails.add(new OrderDetail(
                lblOrderId.getText(),
                tblOrderDetails.
        ));
    }
}
