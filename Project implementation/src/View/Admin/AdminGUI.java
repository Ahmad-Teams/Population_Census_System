/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Admin;

import View.login.Login;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import View.login.Login;
import Model.project.Admin;

/**
 *
 * @author user
 */
public class AdminGUI extends Application  {
    Stage S1;
    Admin admin ;//= new Admin(0, 0, STYLESHEET_MODENA, STYLESHEET_MODENA, STYLESHEET_MODENA, STYLESHEET_MODENA, STYLESHEET_MODENA, STYLESHEET_CASPIAN, STYLESHEET_MODENA);
    //remove the above instailization later
        public AdminGUI(){
        
    }

    public AdminGUI(Admin admin) {
        this.admin = admin;
    }
    @Override
        public void start(Stage stage) {
        
        HBox all = new HBox();


        
// side btn section
        
        VBox section1 = new VBox();       
        section1.setPrefSize(170, 500);

        
        Button Add_Officer = new Button("Add Officer");
        Button Officers_list = new Button("Officers list");
        Button Make_report = new Button("Make a report");
        Button Logout = new Button("Logout");
        
        
        Add_Officer.setPrefSize(170, 175);
        Add_Officer.setFont(Font.font("tahoma", FontWeight.BOLD, 15));
        Add_Officer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                Admin_AddOfficer c2=new Admin_AddOfficer();
                S1.close();
                c2.start(new Stage());
            }
        });
        
        
        Officers_list.setPrefSize(170, 175);
        Officers_list.setFont(Font.font("tahoma", FontWeight.BOLD, 15));
        Officers_list.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                Admin_OfficerList c2=new Admin_OfficerList();
                S1.close();
                c2.start(new Stage());
            }
        });
        
        Make_report.setPrefSize(170, 175);
        Make_report.setFont(Font.font("tahoma", FontWeight.BOLD, 15));
        Make_report.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                Make_Report c2=new Make_Report();
                S1.close();
                c2.start(new Stage());
            }
        });
        
        Logout.setPrefSize(170, 175);
        Logout.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.web("#bf1f21"), CornerRadii.EMPTY, Insets.EMPTY)));
        Logout.setBorder(new Border(new BorderStroke((javafx.scene.paint.Color.web("#79b5d9")), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        Logout.setFont(Font.font("tahoma", FontWeight.BOLD, 15));
        Logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                Login c2=new Login();
                S1.close();
                c2.start(new Stage());
            }
        });

        
        section1.getChildren().addAll(Add_Officer,Officers_list,Make_report,Logout);
        
//second section

        VBox section2 = new VBox();
        section2.setPrefSize(530, 500);
       
        
        ImageView assitant_Image = new ImageView("Images/admin.png");
        assitant_Image.setFitHeight(250);
        assitant_Image.setFitWidth(250);
        
        
        Label word =new Label("welcome in Adminstrator part \n\n click any button to start work");
        word.setFont(Font.font("Garamond", FontWeight.BOLD, 30));
        word.setTextFill(javafx.scene.paint.Color.BLACK);
        word.setPadding(new Insets(20));
        
        section2.getChildren().addAll(assitant_Image,word);
        section2.setAlignment(Pos.CENTER);
        
        all.getChildren().addAll(section1,section2);
        all.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.web("#a5cee5"), CornerRadii.EMPTY, Insets.EMPTY)));

        
        Scene scene = new Scene(all);           
        stage.setScene(scene);
        stage.setMinWidth(700);
        stage.setMinHeight(700);
        stage.setTitle("Admin Screen");
        stage.setResizable(false);
        
        stage.show();
        S1=stage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

