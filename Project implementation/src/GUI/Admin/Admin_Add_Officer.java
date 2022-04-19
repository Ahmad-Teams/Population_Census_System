/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import Admin.Admin;
import Admin.Admin_Add_Officer;
import Admin.Admin_OfficerList;
import Admin.Make_Report;
import com.sun.javafx.scene.control.skin.FXVK;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import login.Login;


/**
 *
 * @author user
 */
public class Admin_Add_Officer extends Application {
    
     Stage S1;
    public void start(Stage add_officers_Stage) {
        
        HBox all = new HBox();

        
// side btn section
        
        VBox section1 = new VBox();       
        section1.setPrefSize(200, 500);
        
        
        Button Add_Officer = new Button("Add Officer");
        Button Officers_list = new Button("Officers list");
        Button Make_report = new Button("Make a report");
        Button Logout = new Button("Logout");
        
        
        Add_Officer.setPrefSize(170, 125);
        Add_Officer.setFont(Font.font("tahoma", FontWeight.BOLD, 15));
        Add_Officer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                Admin_Add_Officer c2=new Admin_Add_Officer();
                S1.close();
                c2.start(new Stage());
            }
        });
        
        
        Officers_list.setPrefSize(170, 125);
        Officers_list.setFont(Font.font("tahoma", FontWeight.BOLD, 15));
        Officers_list.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                Admin_OfficerList c2=new Admin_OfficerList();
                S1.close();
                c2.start(new Stage());
            }
        });
        
        Make_report.setPrefSize(170, 125);
        Make_report.setFont(Font.font("tahoma", FontWeight.BOLD, 15));
        Make_report.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                Make_Report c2=new Make_Report();
                S1.close();
                c2.start(new Stage());
            }
        });
        
        Logout.setPrefSize(170, 150);
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
        section2.setAlignment(Pos.TOP_CENTER);
        section2.setPrefSize(530, 500);
        
        Label stage2_title = new Label("\tAdd Officer \n Officer information");
        stage2_title.setFont(Font.font("Garamond", FontWeight.BOLD, 30));
        
//user name field

        HBox h_name = new HBox();
        h_name.setPadding(new Insets(40, 0, 0, 0));
        h_name.setAlignment(Pos.CENTER);
        
        Label name = new Label("NAME       ");
        name.setFont(Font.font("arial", FontWeight.MEDIUM, 15));
        
        
        TextField name_field = new TextField();
        name_field.setPromptText("Officer name  ");
        name_field.setPrefSize(300, 40);
        
        h_name.getChildren().addAll(name,name_field);

//radio box

        HBox gender = new HBox();
        gender.setAlignment(Pos.CENTER);
        gender.setPadding(new Insets(40, 0, 0, 0));
        gender.setAlignment(Pos.CENTER);
        ToggleGroup tg = new ToggleGroup();
        
        Label sex = new Label("SEX\t \t ");
        
        sex.setFont(Font.font("arial", FontWeight.MEDIUM, 15));
        sex.setLayoutX(10);
        RadioButton male = new RadioButton("Male"); 
        male.setFont(Font.font("arial", FontWeight.MEDIUM, 15));
        male.setPadding(new Insets(0, 60, 0, 60));
        RadioButton female = new RadioButton("Female");
        female.setFont(Font.font("arial", FontWeight.MEDIUM, 15));
        female.setPadding(new Insets(0, 0, 0, 33));
        gender.getChildren().addAll(sex,male,female);
        
        tg.getToggles().addAll(male,female);

//combo box
        HBox area_section = new HBox();
        area_section.setPadding(new Insets(40, 0, 0, 0));
        area_section.setAlignment(Pos.CENTER);
        
        Label area = new Label("Area       ");
        area.setFont(Font.font("arial", FontWeight.MEDIUM, 15));
        
        ComboBox area_cbox = new ComboBox();
        
        //add cities here
        
        area_cbox.getItems().addAll("");
        area_cbox.setValue("Cairo");
        area_cbox.setPrefSize(300, 40);
        area_section.getChildren().addAll(area,area_cbox);
        
        
        
//email box
        
        HBox h_email = new HBox();
        h_email.setPadding(new Insets(40, 0, 0, 0));
        h_email.setAlignment(Pos.CENTER);
        
        Label Email = new Label("Email       ");
        Email.setFont(Font.font("arial", FontWeight.MEDIUM, 15));
        
        
        TextField Email_Field = new TextField();
        Email_Field.setPromptText("Officer Email  ");
        Email_Field.setPrefSize(300, 40);
        
        h_email.getChildren().addAll(Email,Email_Field); 
       
        
//user name field
        HBox h_user_name = new HBox();
        h_user_name.setPadding(new Insets(40, 30, 0, 0));
        h_user_name.setAlignment(Pos.CENTER);
        
        Label user_name = new Label("User Name");
        user_name.setPadding(new Insets(0, 20, 0, 0));
        user_name.setFont(Font.font("arial", FontWeight.MEDIUM, 15));
        
        
        TextField user_name_field = new TextField();
        user_name_field.setPromptText("Officer user name");
        user_name_field.setPrefSize(300, 40);

        
        h_user_name.getChildren().addAll(user_name,user_name_field);

//password field

        HBox h_pass = new HBox();
        h_pass.setPadding(new Insets(40, 30, 40, 0));
        h_pass.setAlignment(Pos.CENTER);
        
        Label pass = new Label("password");
        pass.setPadding(new Insets(0, 30, 0, 0));
        pass.setFont(Font.font("arial", FontWeight.MEDIUM, 15));
        
        
        PasswordField pass_field = new PasswordField();
        pass_field.setPrefSize(300, 40);
        
        h_pass.getChildren().addAll(pass,pass_field);        
        
        
// add officer btn

        Button add_officer_btn = new Button("Add Officer");
        add_officer_btn.setPrefSize(200, 50);
        
        section2.getChildren().addAll(stage2_title,h_name,gender,area_section,h_email,h_user_name,h_pass,add_officer_btn);
        

        
        
        
        
       
        
        all.getChildren().addAll(section1,section2);
        all.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.web("#a5cee5"), CornerRadii.EMPTY, Insets.EMPTY)));

        
        Scene scene = new Scene(all);           
        add_officers_Stage.setScene(scene);
        add_officers_Stage.setMinWidth(700);
        add_officers_Stage.setMinHeight(700);
        add_officers_Stage.setTitle("Admin Screen");
        add_officers_Stage.setResizable(false);
        add_officers_Stage.show();
        
        S1 = add_officers_Stage;
        
    }

   
    public void handle(ActionEvent event) {
        Admin_Add_Officer add_Officer_stage = new Admin_Add_Officer();
}
}
