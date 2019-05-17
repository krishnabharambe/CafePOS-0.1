package com.krishnabharambe.cafepos;

import static com.krishnabharambe.cafepos.CommonClasses.CMN.buildSessionFactory;
import com.krishnabharambe.cafepos.HClass.users;
import java.net.URL;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.hibernate.Query;
import org.hibernate.Session;

public class FXMLController implements Initializable {

    @FXML
    private TextField txtusername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnPowerOff;
    @FXML
    private Label lbtime;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        DateFormat dateFormat = null;
        String strDate = dateFormat.format(new Date());
        lbtime.setText(LocalDate.now().getDayOfWeek().name() + ", " +strDate);
    }

    private void ActionMoveToNext(KeyEvent event) {

    }

    @FXML
    private void ActionKeyLogin(KeyEvent event) {
    }

    @FXML
    private void ActionKeyPower(KeyEvent event) {
    }

    @FXML
    private void movetopassword(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            txtPassword.requestFocus();
        }
    }

    @FXML
    private void movetobtnLogin(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            btnLogin.requestFocus();
        }
    }

    @FXML
    private void ActionLogin(ActionEvent event) {
        if (txtusername.getText().trim().equals("") || txtusername.getText().trim().trim().equals(null)
                || txtPassword.getText().trim().equals("") || txtPassword.getText().trim().equals(null)) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Please, Check Username and Password.");
            alert.showAndWait();
        } else {
            //check for login
//            users user = null;
//            Session sessionObj = buildSessionFactory().openSession();
//            sessionObj.beginTransaction();
//            user = new users();
//            user.setUsername("Admin");
//            user.setPassword("Admin");
//            sessionObj.save(user);
//            sessionObj.getTransaction().commit();
//            sessionObj.close();
//            System.out.println("Suucess");

            users user = null;
            Session sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();

            String hql = "SELECT count(*) FROM users u WHERE u.username = '" + txtusername.getText().trim() + "' AND u.password = '" + txtPassword.getText().trim() + "'";

            Query query = sessionObj.createQuery(hql);
            List<Long> results = (List<Long>) query.list();
//            int r = results[0];
            System.out.println("Resukt : " + results.get(0));

            if (Math.toIntExact(results.get(0)) == 1) {
                System.out.println("=== Login Success ===");
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Please, Check Username and Password.");
                alert.showAndWait();
            }

            sessionObj.getTransaction().commit();
            sessionObj.close();
            System.out.println("Suucess");

        }
    }

    @FXML
    private void ActionPoweroff(ActionEvent event) {
        System.exit(0);
    }

}
