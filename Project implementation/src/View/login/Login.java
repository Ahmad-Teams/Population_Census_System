/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.login;

import View.Admin.Admin_AddOfficer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
import View.Officer.ViewNewRequests;
import View.User.View_Family_Members;
import Model.project.*;
import Model.database.*;
/**
 *
 * @author userName_field
 */
public class Login extends Application {

    Stage S1;
    Admin admin = new Admin(STYLESHEET_MODENA, STYLESHEET_MODENA, STYLESHEET_CASPIAN, STYLESHEET_MODENA);
    //User user = new User(0, STYLESHEET_CASPIAN, STYLESHEET_CASPIAN, STYLESHEET_CASPIAN, STYLESHEET_CASPIAN, STYLESHEET_MODENA, STYLESHEET_MODENA, STYLESHEET_MODENA, 0, STYLESHEET_MODENA, STYLESHEET_MODENA);
    Officer officer = new Officer(STYLESHEET_MODENA, STYLESHEET_CASPIAN, STYLESHEET_MODENA, 0, STYLESHEET_MODENA, STYLESHEET_MODENA, STYLESHEET_MODENA, 0);
    String userName;
    String password;
    String accountType;

    @Override
    public void start(Stage primaryStage) {
        //create login title

        GridPane gp = new GridPane();
        ////////////////////////////////////////
        Pane v1 = new Pane();
        v1.setPrefSize(400, 700);
        ImageView imgv = new ImageView("Images/members.png");
        imgv.setFitWidth(250);
        imgv.setFitHeight(150);
        imgv.setLayoutY(90);
        imgv.setLayoutX(40);
        Label wel = new Label("Welcome to");
        wel.setLayoutY(220);
        wel.setLayoutX(95);
        wel.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 22));
        wel.setTextFill(Color.WHITE);
        Label l2 = new Label("Population_Census_System -->");
        l2.setLayoutY(248);
        l2.setFont(Font.font("Arial", FontWeight.BOLD, 21));
        l2.setPadding(new Insets(0, 0, 0, 0));
        l2.setLayoutX(4);
        l2.setTextFill(Color.WHITE);
        v1.getChildren().addAll(wel, l2, imgv);
        v1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        v1.setBackground(new Background(new BackgroundFill(Color.web("#2596be"), CornerRadii.EMPTY, Insets.EMPTY)));
        gp.add(v1, 0, 0);
        /////////////////////////////////////////////
        Pane v2 = new Pane();
        v2.setPadding(new Insets(0, 10, 0, 30));
        v2.setPrefSize(450, 700);
        ImageView img = new ImageView("Images/240_F_31331324_bqXgqwmlnnXaOeXwFv8CrO6oMHpAKPum.jpg");
        img.setFitWidth(300);
        img.setFitHeight(100);
        img.setLayoutY(40);
        img.setLayoutX(25);
        v2.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.NONE, CornerRadii.EMPTY, new BorderWidths(2))));
        v2.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        /////////////////////////////////////////////
        Label email = new Label("Email");
        email.setLayoutY(150);
        email.setLayoutX(25);
        email.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 17));
        TextField userName_field = new TextField();
        userName_field.setStyle("-fx-background-radius: 30px ;");
        userName_field.setPromptText("Email");
        userName_field.setLayoutY(180);
        userName_field.setLayoutX(25);
        userName_field.setPrefWidth(330);

        Label pass = new Label("Password");
        pass.setLayoutY(240);
        pass.setLayoutX(25);
        pass.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 17));
        PasswordField password_Field = new PasswordField();
        password_Field.setStyle("-fx-background-radius: 30px ;");
        password_Field.setPromptText("Password");
        password_Field.setLayoutY(270);
        password_Field.setLayoutX(25);
        password_Field.setPrefWidth(330);

        Button log = new Button("Login");
        log.setStyle("-fx-background-radius: 300px ;");
        log.setLayoutY(320);
        log.setLayoutX(135);
        log.setPrefWidth(100);
        log.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                userName = userName_field.getText();
                password = password_Field.getText();
                if (OfficerDB.check(userName, password)) {
                    accountType = getAccountType(userName, password);
                    if (accountType.equals("Admin")) {
                        // here should be a function to set the admin data
                        Admin_AddOfficer c1 = new Admin_AddOfficer(0);
                        S1.close();
                        c1.start(new Stage());
                    } else if (accountType.equals("Officer")) {
                        // here should be a function to set the officer data
                        ViewNewRequests c1 = new ViewNewRequests();
                        S1.close();
                        c1.start(new Stage());
                    } else if (accountType.equals("User")) {
                        // here should be a function to set the user data
                        View_Family_Members c1 = new View_Family_Members();
                        S1.close();
                        c1.start(new Stage());
                    }
                } else {
                    System.out.println("wrong usrename or password");
                }
            }
        });
        v2.getChildren().addAll(email, userName_field, pass, password_Field, log, img);
        gp.add(v2, 1, 0);

        Scene scene = new Scene(gp, 700, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Screen");
        primaryStage.setResizable(false);
        primaryStage.show();
        S1 = primaryStage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private String getAccountType(String userName, String password) {
        String Accounttype = "";
        ArrayList<System_user> allAccounts = OfficerDB.getSystemUsers();
        for (int i = 0; i < allAccounts.size(); i++) {
            if (allAccounts.get(i).getUsername().equals(userName) && allAccounts.get(i).getPassword().equals(password)) {
                Accounttype = allAccounts.get(i).getType();
                break;
            }
        }
        return Accounttype;
    }
}
