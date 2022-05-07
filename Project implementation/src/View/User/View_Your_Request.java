/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.User;

import Controller.UserViewController;
import View.Admin.Admin_AddOfficer;
import View.Admin.Admin_OfficerList;
import View.Admin.Make_Report;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.STYLESHEET_CASPIAN;
import static javafx.application.Application.STYLESHEET_MODENA;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import View.login.Login;

/**
 *
 * @author userID
 */
public class View_Your_Request extends Application {
    Stage S1;
    TableView <UserRequestTableColumn> table=new TableView();
    int userID ;
    UserViewController userController = new UserViewController(userID);
    //remove the above line
    public View_Your_Request() {
    }

    public View_Your_Request(int userID) {
        this.userID = userID;
    }
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
        Label H=new Label("Your Requests");
        H.setFont(Font.font("Garamond", FontWeight.BOLD, 30));
        H.setPadding(new Insets(20, 0, 50, 200));
        table.setEditable(true);
        TableColumn<UserRequestTableColumn, String> requestID = new TableColumn<>("Request ID");
        requestID.setCellValueFactory(new PropertyValueFactory("requestID"));
        requestID.setPrefWidth(80);
        
        TableColumn<UserRequestTableColumn, String> requestState = new TableColumn<>("Request State");
        requestState.setCellValueFactory(new PropertyValueFactory("requestState"));
        requestState.setPrefWidth(80);
        
        TableColumn<UserRequestTableColumn, String> ID = new TableColumn<>("Member ID");
        ID.setCellValueFactory(new PropertyValueFactory("MID"));
        ID.setPrefWidth(80);
        
        TableColumn<UserRequestTableColumn, String> name = new TableColumn<>("Name");
        //name.setCellValueFactory(new PropertyValueFactory("name"));
        name.setPrefWidth(120);
        
        TableColumn<UserRequestTableColumn, String> address = new TableColumn<>("Address");
        address.setCellValueFactory(new PropertyValueFactory("address"));
        address.setPrefWidth(120);
        
        TableColumn <UserRequestTableColumn, String>education =new TableColumn("Education");
        education.setCellValueFactory(new PropertyValueFactory("education"));
        education.setPrefWidth(110);
        
        TableColumn <UserRequestTableColumn, String>sex =new TableColumn("Sex");
        sex.setCellValueFactory(new PropertyValueFactory("Sex"));
        sex.setPrefWidth(50);
        
        TableColumn <UserRequestTableColumn, String>occupation =new TableColumn("Occupation");
        occupation.setCellValueFactory(new PropertyValueFactory("occupation"));
        occupation.setPrefWidth(100);
        
        TableColumn <UserRequestTableColumn, String>email =new TableColumn("Email");
        email.setCellValueFactory(new PropertyValueFactory("Email"));
        email.setPrefWidth(100);
        
        TableColumn <UserRequestTableColumn, String>phone =new TableColumn("phone");
        phone.setCellValueFactory(new PropertyValueFactory("phone"));
        phone.setPrefWidth(100);
        
        TableColumn <UserRequestTableColumn, String>DOB =new TableColumn("Date Of Birth");
        DOB.setCellValueFactory(new PropertyValueFactory("DOB"));
        DOB.setPrefWidth(100);
        
        TableColumn <UserRequestTableColumn, String>area =new TableColumn("Area");
        area.setCellValueFactory(new PropertyValueFactory("areaName"));
        area.setPrefWidth(100);
        
        table.getColumns().addAll(requestID,requestState,ID,name,address,education,sex,occupation,email,phone,DOB,area);
        table.setMinHeight(1000);
        table.setMinWidth(1150);
        table.setItems(userController.getuserRequests());
        
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(table);
        scrollPane.pannableProperty().set(true);
        scrollPane.fitToWidthProperty().set(true);
        scrollPane.fitToHeightProperty().set(true);
        scrollPane.setPrefHeight(400);
        scrollPane.setMinWidth(600);
        scrollPane.hbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.ALWAYS);
        //section2.setPadding(new Insets(20, 0, 50, 50));
        section2.getChildren().addAll(H,scrollPane);
       // section2.setAlignment(Pos.CENTER);
       
        all.add(section1, 0, 0);
        all.add(section2, 1, 0);
        all.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.web("#a5cee5"), CornerRadii.EMPTY, Insets.EMPTY)));

        
           
        Scene scene = new Scene(all,800,700);           
        stage.setScene(scene);
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
