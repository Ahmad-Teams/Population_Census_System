/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Admin.Admin_AddOfficer;
import Admin.Admin_OfficerList;
import Admin.Make_Report;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import login.Login;
import User.View_Correction;
import User.View_Your_Request;
import User.View_Family_Members;
import User.Make_Request;
import javafx.scene.control.DatePicker;

/**
 *
 * @author user
 */
public class View_Correction extends Application {
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

        VBox section2 = new VBox(15);
        section2.setPrefSize(700, 550);
        //section2.setPadding(new Insets(5, 0, 0, 20));
        VBox NameField=new VBox(15);
        VBox PassField=new VBox(20);
        HBox horiz=new HBox(50);
        horiz.setPadding(new Insets(5, 0, 0, 25));
        Label H=new Label("Correction Requests");
        H.setFont(Font.font("Garamond", FontWeight.BOLD, 30));
        H.setPadding(new Insets(5, 0, 0, 200));
        table.setEditable(true);
        TableColumn FristName =new TableColumn("ID");
        TableColumn SecondName =new TableColumn("Name");
        SecondName.setPrefWidth(500);
        table.getColumns().addAll(FristName,SecondName);
        table.setMinHeight(800);
        table.setMinWidth(900);
        
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(table);
        scrollPane.pannableProperty().set(true);
        scrollPane.fitToWidthProperty().set(true);
        scrollPane.fitToHeightProperty().set(true);
        scrollPane.setPrefHeight(300);
        scrollPane.setMaxWidth(900);
        scrollPane.hbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.ALWAYS);
        /////Name field//////
        HBox Name=new HBox(30);
        Label l1=new Label("Name : ");
        l1.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 16));
        TextField name =new TextField();
        name.setPromptText("Name");
        name.setStyle("-fx-background-radius: 30px ;");
        name.setMaxWidth(300);
        Name.getChildren().addAll(l1,name);
        ///////Area////////////
        HBox area=new HBox(55);
        Label l2=new Label("Area: ");
        l2.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 16));
        ComboBox Area=new ComboBox();
        Area.setPrefWidth(150);
        area.getChildren().addAll(l2,Area);
        /////////////State//////////////////
        HBox state=new HBox(50);
        Label s1=new Label("State: ");
        s1.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 16));
        ComboBox State=new ComboBox();
        State.setPrefWidth(150);
        state.getChildren().addAll(s1,State);
        //////education///////////////
        HBox Education=new HBox(15);
        Label e1=new Label("Education: ");
        e1.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 16));
        ComboBox edu=new ComboBox();
        edu.setPrefWidth(150);
        Education.getChildren().addAll(e1,edu);
        //////email //////////
        HBox Email = new HBox(40);
        Label email =new Label("Email : ");
        email.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 16));
        TextField user=new TextField();
        user.setStyle("-fx-background-radius: 30px ;");
        user.setPromptText("Email");
        user.setMaxWidth(300);
        Email.getChildren().addAll(email,user);
        ////////////username/////////////
        HBox User=new HBox(1);
        Label u =new Label("User Name : ");
        u.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 16));
        TextField user1=new TextField();
        user1.setStyle("-fx-background-radius: 30px ;");
        user1.setPromptText("UserName");
        user1.setMaxWidth(300);
        User.getChildren().addAll(u,user1);
        /////////// password /////////////
        HBox password =new HBox(10);
        Label pass =new Label("Password : ");
        pass.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 16));
        PasswordField P=new PasswordField();
        P.setMaxWidth(300);
        P.setStyle("-fx-background-radius: 30px ;");
        P.setPromptText("Password");
        password.getChildren().addAll(pass,P);
        ///////////sex /////////////
        HBox S=new HBox(50);
        Label s =new Label("SEX :");
        s.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 17));
        ToggleGroup tg = new ToggleGroup();
        RadioButton Male=new RadioButton("Male: ");
        RadioButton Female=new RadioButton("Female");
        tg.getToggles().addAll(Male,Female);
        S.getChildren().addAll(s,Male,Female);
        ///////////////////phone/////////////
        HBox mobile =new HBox(30);
        Label ph=new Label("Phone : ");
        ph.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 17));
        TextField Phone=new TextField();
        Phone.setStyle("-fx-background-radius: 30px ;");
        Phone.setPromptText("Phone");
        Phone.setMaxWidth(300);
        mobile.getChildren().addAll(ph,Phone);
        ///////////////////////////////////
        HBox Occupation =new HBox(10);
        Label O=new Label("Occupation : ");
        O.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 17));
        TextField Occupat=new TextField();
        Occupat.setStyle("-fx-background-radius: 30px ;");
        Occupat.setPromptText("Occupation");
        Occupat.setMaxWidth(300);
        Occupation.getChildren().addAll(O,Occupat);
        ///////////////////////////////////////
        HBox Address =new HBox(30);
        Label A=new Label("Address : ");
        A.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 17));
        TextField Addr=new TextField();
        Addr.setStyle("-fx-background-radius: 30px ;");
        Addr.setPromptText("Address");
        Addr.setMaxWidth(300);
        Address.getChildren().addAll(A,Addr);
        //////Date////////////////
        HBox Dt =new HBox(40);
        Label data=new Label("Date : ");
        data.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 17));
        DatePicker Date=new DatePicker();
        Dt.getChildren().addAll(data,Date);
        //////////////////button///////
        HBox B=new HBox(100);
        B.setPadding(new Insets(10, 0, 0, 150));
        Button D=new Button(" Reject ");
        Button U=new Button(" Accept ");
        D.setStyle("-fx-background-radius: 300px ;-fx-background-color:Red; ");
        U.setStyle("-fx-background-radius: 300px ;-fx-background-color:Orange;");
        D.setMinWidth(120);
        U.setMinWidth(120);
        D.setFont(Font.font("tahoma", FontWeight.BOLD, 15.5));
        D.setTextFill(javafx.scene.paint.Color.BLACK);
        U.setFont(Font.font("tahoma", FontWeight.BOLD, 15.5));
        U.setTextFill(javafx.scene.paint.Color.BLACK);
        B.getChildren().addAll(D,U);
        ////////////////////////
        NameField.getChildren().addAll(Name,area,state,Education,Email,User);
        PassField.getChildren().addAll(S,Occupation,Address,Dt,mobile,password);
        horiz.getChildren().addAll(NameField,PassField);
        section2.getChildren().addAll(H,scrollPane,horiz,B);
        all.add(section1, 0, 0);
        all.add(section2, 1, 0);
        all.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.web("#a5cee5"), CornerRadii.EMPTY, Insets.EMPTY)));

        
        Scene scene = new Scene(all,900,700);           
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
