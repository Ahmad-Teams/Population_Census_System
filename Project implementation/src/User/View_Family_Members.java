/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package User;

import Admin.Admin_Add;
import Admin.Admin_OfficerList;
import Admin.Make_Report;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import login.Login;

/**
 *
 * @author dell
 */
public class View_Family_Members extends Application {
    
    Stage S1;
        TableView table=new TableView();
    @Override
         public void start(Stage stage) {
        
        GridPane all = new GridPane();
        all.setHgap(10);
        
// side btn section
        
        VBox section1 = new VBox();       
        section1.setPrefSize(170, 500);

        
      Button View_my_family = new Button("View My Family\n" +"Members");
        Button Make_request = new Button("Make a request\n" +"for Adding New\n" +"member");
        Button view_request = new Button("View Your\n" +"Requests");
        Button View_Correction  = new Button("View Correction\n" +"Requests");
        Button Logout = new Button("Logout");
        
        
        View_my_family.setMinSize(170, 140);
        View_my_family.setFont(Font.font("tahoma", FontWeight.BOLD, 15));
        View_my_family.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                View_Family_Members c2=new View_Family_Members();
                S1.close();
                c2.start(new Stage());
            }
        });
        
        
        Make_request.setMinSize(170, 140);
        Make_request.setFont(Font.font("tahoma", FontWeight.BOLD, 15));
        Make_request.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                Make_Request c2=new Make_Request();
                S1.close();
                c2.start(new Stage());
            }
        });
        
        view_request.setMinSize(170, 140);
        view_request.setFont(Font.font("tahoma", FontWeight.BOLD, 15));
        view_request.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                View_Your_Request c2=new View_Your_Request();
                S1.close();
                c2.start(new Stage());
            }
        });
        
        View_Correction.setMinSize(170, 140);
        View_Correction.setFont(Font.font("tahoma", FontWeight.BOLD, 15));
        View_Correction.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                View_Correction c2=new View_Correction();
                S1.close();
                c2.start(new Stage());
            }
        });
        
        Logout.setMinSize(170, 160);
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

        
        section1.getChildren().addAll(View_my_family,Make_request,view_request,View_Correction,Logout);
//second section

        VBox section2 = new VBox();
        section2.setPrefSize(530, 500);
        Label H=new Label("Family Members");
        H.setFont(Font.font("Garamond", FontWeight.BOLD, 30));
        H.setPadding(new Insets(20, 0, 50, 200));
        table.setEditable(true);
        TableColumn FristName =new TableColumn("ID");
        TableColumn SecondName =new TableColumn("Name");
        SecondName.setPrefWidth(400);
        TableColumn tName =new TableColumn("Name");
        TableColumn fName =new TableColumn("Name");
        TableColumn ffName =new TableColumn("Name");
        table.getColumns().addAll(FristName,SecondName,tName,fName,ffName);
        table.setMinHeight(1000);
        table.setMinWidth(900);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(table);
        scrollPane.pannableProperty().set(true);
        scrollPane.fitToWidthProperty().set(true);
        scrollPane.fitToHeightProperty().set(true);
        scrollPane.setPrefHeight(350);
        scrollPane.setMaxWidth(900);
        scrollPane.hbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.ALWAYS);
        section2.setPadding(new Insets(20, 0, 50, 50));
        section2.getChildren().addAll(H,scrollPane);
       // section2.setAlignment(Pos.CENTER);
        
        all.add(section1, 0, 0);
        all.add(section2, 1, 0);
        all.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.web("#a5cee5"), CornerRadii.EMPTY, Insets.EMPTY)));

        
           
        Scene scene = new Scene(all,800,700);           
        stage.setScene(scene);;
        stage.setTitle("User Screen");
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
