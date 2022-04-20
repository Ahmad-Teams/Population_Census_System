/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import login.Login;
import Admin.AdminGUI;
import Admin.Make_Report;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
import login.Login;

/**
 *
 * @author user
 */
public class Make_Report extends Application {
            Stage S1;
        TableView table=new TableView();
    @Override
    public void start(Stage stage) {
               GridPane all = new GridPane();
        all.setHgap(10);
        
// side btn section
        
        VBox section1 = new VBox();       
        section1.setPrefSize(170, 500);

        
        Button Add_Officer = new Button("Add Officer");
        Button Officers_list = new Button("Officers list");
        Button Make_report = new Button("Make a report");
        Button Logout = new Button("Logout");
        
        
        Add_Officer.setMinSize(170, 175);
        Add_Officer.setFont(Font.font("tahoma", FontWeight.BOLD, 15));
        Add_Officer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                Admin_Add c2=new Admin_Add();
                S1.close();
                c2.start(new Stage());
            }
        });
        
        Officers_list.setMinSize(170, 175);
        Officers_list.setFont(Font.font("tahoma", FontWeight.BOLD, 15));
         Officers_list.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                Admin_OfficerList c2=new Admin_OfficerList();
                S1.close();
                c2.start(new Stage());
            }
        });

        
        Make_report.setMinSize(170, 175);
        Make_report.setFont(Font.font("tahoma", FontWeight.BOLD, 15));
        Make_report.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                Make_Report c2=new Make_Report();
                S1.close();
                c2.start(new Stage());
            }
        });
        
        Logout.setMinSize(170, 175);
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

        VBox section2 = new VBox(30);
        section2.setPrefSize(530, 500);
        Label H=new Label("Report on Family members");
        H.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 22));
        H.setPadding(new Insets(5, 0, 0, 100));
        table.setEditable(true);
        TableColumn FristName =new TableColumn("ID");
        TableColumn SecondName =new TableColumn("Name");
        SecondName.setPrefWidth(500);
        table.getColumns().addAll(FristName,SecondName);
        table.setMinHeight(1000);
        
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(table);
        scrollPane.pannableProperty().set(true);
        scrollPane.fitToWidthProperty().set(true);
        scrollPane.fitToHeightProperty().set(true);
        scrollPane.setPrefHeight(350);
        scrollPane.setMaxWidth(900);
        scrollPane.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        /////searching on//////
        HBox search=new HBox(15);
        Label Searching=new Label("Searching on: ");
        Searching.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 18));
        ComboBox Search=new ComboBox();
        Search.setPrefWidth(100);
        search.setPadding(new Insets(10, 0, 0, 70));
        search.getChildren().addAll(Searching,Search);
        /////////////Select an option to display////////////////
        HBox Display_search=new HBox(15);
        Label display=new Label("Select an option to display: ");
        display.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 18));
        ComboBox Select_display=new ComboBox();
        Select_display.setPrefWidth(100);
        Display_search.setPadding(new Insets(0, 0, 20, 20));
        Display_search.getChildren().addAll(display,Select_display);
        /////Select an option to sort on/////////////
        HBox option_search=new HBox(15);
        Label option=new Label("Select an option to sort on: ");
        option.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 18));
        ComboBox Select_option=new ComboBox();
        Select_option.setPrefWidth(100);
        option_search.setPadding(new Insets(10, 0, 0, 20));
        option_search.getChildren().addAll(option,Select_option);
        ////////////////////////
        section2.getChildren().addAll(H,search,Display_search,option_search,scrollPane);
        all.add(section1, 0, 0);
        all.add(section2, 1, 0);
        all.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.web("#a5cee5"), CornerRadii.EMPTY, Insets.EMPTY)));

        
        Scene scene = new Scene(all,700,700);           
        stage.setScene(scene);;
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
