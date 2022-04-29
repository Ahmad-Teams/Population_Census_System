/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Admin.Admin_AddOfficer;
import Admin.Admin_OfficerList;
import Admin.Make_Report;
import Admin.UserTableColumn;
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
import database.AdminDB;
import database.OfficerDB;
import database.UserDB;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import javafx.scene.control.cell.PropertyValueFactory;
import project.*;

/**
 *
 * @author email_field
 */
public class View_Correction extends Application {
    Stage S1;
    TableView <CorrectionRequest> table=new TableView();
    CorrectionRequest selectedColumn;
    TextField nameField;
    ComboBox Area_field;
    ComboBox State_field;
    ComboBox education_field;
    TextField email_field;
    TextField username_field;
    PasswordField password_field;
    RadioButton Female;
    RadioButton Male;
    TextField Phone;
    TextField occupation_field;
    TextField address_field;
    DatePicker Date;
    
    User userr = new User(1, STYLESHEET_CASPIAN, STYLESHEET_CASPIAN, STYLESHEET_CASPIAN, STYLESHEET_CASPIAN, STYLESHEET_MODENA, STYLESHEET_MODENA, STYLESHEET_MODENA, 0, STYLESHEET_MODENA, STYLESHEET_MODENA);
    //remove the above instailization later

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
        
        TableColumn<CorrectionRequest, Integer> RID = new TableColumn<>("Request ID");
        RID.setCellValueFactory(new PropertyValueFactory("RequestID"));
        
        TableColumn<CorrectionRequest, String> UserRequest_ID = new TableColumn<>("UserRequest ID");
        UserRequest_ID.setCellValueFactory(new PropertyValueFactory("UserRequestID"));
        
        TableColumn<CorrectionRequest, String> Request_Title = new TableColumn<>("Request Title");
        Request_Title.setCellValueFactory(new PropertyValueFactory("RequestTitle"));
        
        TableColumn<CorrectionRequest, String> Request_Content = new TableColumn<>("Request content");
        Request_Content.setCellValueFactory(new PropertyValueFactory("RequestContent"));
        
        RID.setPrefWidth(100);
        UserRequest_ID.setPrefWidth(100);
        Request_Title.setPrefWidth(350);
        Request_Content.setPrefWidth(350);
        table.getColumns().addAll(RID,UserRequest_ID,Request_Title,Request_Content);
        table.setMinHeight(800);
        table.setMinWidth(900);
        table.setItems(getCorrectionRequests());
        table.setOnMouseClicked(e -> {
            tableClickeEvent();
        });

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
        Label name=new Label("Name : ");
        name.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 16));
        nameField =new TextField();
        nameField.setPromptText("Name");
        nameField.setStyle("-fx-background-radius: 30px ;");
        nameField.setMaxWidth(300);
        Name.getChildren().addAll(name,nameField);
        ///////Area////////////
        HBox Area=new HBox(55);
        Label area=new Label("Area: ");
        area.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 16));
        Area_field=new ComboBox();
        Area_field.setPrefWidth(150);
        Area.getChildren().addAll(area,Area_field);
        /////////////State//////////////////
        HBox state=new HBox(50);
        Label State=new Label("State: ");
        State.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 16));
        State_field=new ComboBox();
        State_field.setPrefWidth(150);
        state.getChildren().addAll(State,State_field);
        //////education///////////////
        HBox Education=new HBox(15);
        Label education=new Label("Education: ");
        education.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 16));
        education_field=new ComboBox();
        education_field.setPrefWidth(150);
        Education.getChildren().addAll(education,education_field);
        //////email //////////
        HBox Email = new HBox(40);
        Label email =new Label("Email : ");
        email.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 16));
        email_field=new TextField();
        email_field.setStyle("-fx-background-radius: 30px ;");
        email_field.setPromptText("Email");
        email_field.setMaxWidth(300);
        Email.getChildren().addAll(email,email_field);
        ////////////username/////////////
        HBox User=new HBox(1);
        Label user =new Label("User Name : ");
        user.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 16));
        username_field=new TextField();
        username_field.setStyle("-fx-background-radius: 30px ;");
        username_field.setPromptText("UserName");
        username_field.setMaxWidth(300);
        User.getChildren().addAll(user,username_field);
        /////////// password /////////////
        HBox password =new HBox(10);
        Label pass =new Label("Password : ");
        pass.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 16));
        password_field=new PasswordField();
        password_field.setMaxWidth(300);
        password_field.setStyle("-fx-background-radius: 30px ;");
        password_field.setPromptText("Password");
        password.getChildren().addAll(pass,password_field);
        ///////////sex /////////////
        HBox S=new HBox(50);
        Label sex =new Label("SEX :");
        sex.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 17));
        ToggleGroup tg = new ToggleGroup();
        Male=new RadioButton("Male: ");
        Female=new RadioButton("Female");
        tg.getToggles().addAll(Male,Female);
        S.getChildren().addAll(sex,Male,Female);
        ///////////////////phone/////////////
        HBox mobile =new HBox(30);
        Label phone=new Label("Phone : ");
        phone.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 17));
        Phone=new TextField();
        Phone.setStyle("-fx-background-radius: 30px ;");
        Phone.setPromptText("Phone");
        Phone.setMaxWidth(300);
        mobile.getChildren().addAll(phone,Phone);
        ///////////////////////////////////
        HBox Occupation =new HBox(10);
        Label occupation=new Label("Occupation : ");
        occupation.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 17));
        occupation_field=new TextField();
        occupation_field.setStyle("-fx-background-radius: 30px ;");
        occupation_field.setPromptText("Occupation");
        occupation_field.setMaxWidth(300);
        Occupation.getChildren().addAll(occupation,occupation_field);
        ///////////////////////////////////////
        HBox Address =new HBox(30);
        Label address=new Label("Address : ");
        address.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 17));
        address_field=new TextField();
        address_field.setStyle("-fx-background-radius: 30px ;");
        address_field.setPromptText("Address");
        address_field.setMaxWidth(300);
        Address.getChildren().addAll(address,address_field);
        //////Date////////////////
        HBox Dt =new HBox(40);
        Label data=new Label("Date : ");
        data.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 17));
        Date=new DatePicker();
        Dt.getChildren().addAll(data,Date);
        //////////////////button///////
        HBox B=new HBox(100);
        B.setPadding(new Insets(10, 0, 0, 150));
        Button D=new Button("Delete");
        Button U=new Button("Update");
        D.setStyle("-fx-background-radius: 300px ;-fx-background-color:Red; ");
        U.setStyle("-fx-background-radius: 300px ;-fx-background-color:Orange;");
        D.setMinWidth(120);
        U.setMinWidth(120);
        D.setFont(Font.font("tahoma", FontWeight.BOLD, 15.5));
        D.setTextFill(javafx.scene.paint.Color.BLACK);
        U.setFont(Font.font("tahoma", FontWeight.BOLD, 15.5));
        U.setTextFill(javafx.scene.paint.Color.BLACK);
        B.getChildren().addAll(D,U);
        
        D.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                OfficerDB.deleteCorrectionRequest(selectedColumn.getRequestID());
                
                nameField.setText("");
                Area_field.getItems().clear();
                Area_field.setValue("");
                State_field.getItems().clear();
                State_field.setValue("");
                education_field.getItems().clear();
                education_field.setValue("");
                email_field.setText("");
                username_field.setText("");
                password_field.setText("");
                Male.setSelected(false);
                Female.setSelected(false);
                Phone.setText("");
                occupation_field.setText("");
                address_field.setText("");
                Date.setValue(null);

                table.setItems(getCorrectionRequests());
            }
        });
        
        U.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                String Sex = "male";
                if (Female.isSelected()) {
                    Sex = "female";
                }
                //UserDB.updateUserRequests(new Member(address_field.getText(), State_field.getSelectionModel().getSelectedItem().toString(), education_field.getSelectionModel().getSelectedItem().toString(), Phone.getText(), email_field.getText(), Date.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), nameField.getText(), AdminDB.getAreaID(Area_field.getSelectionModel().getSelectedItem().toString()), Sex, occupation_field.getText(), userr.getUID()));
                table.setItems(getCorrectionRequests());
                // clear the fields
                nameField.setText("");
                Area_field.getItems().clear();
                Area_field.setValue("");
                State_field.getItems().clear();
                State_field.setValue("");
                education_field.getItems().clear();
                education_field.setValue("");
                email_field.setText("");
                username_field.setText("");
                password_field.setText("");
                Male.setSelected(false);
                Female.setSelected(false);
                Phone.setText("");
                occupation_field.setText("");
                address_field.setText("");
                Date.setValue(null);
                
            }
        });
        ////////////////////////
        NameField.getChildren().addAll(Name,Area,state,Education,Email,User);
        PassField.getChildren().addAll(S,Occupation,Address,Dt,mobile,password);
        horiz.getChildren().addAll(NameField,PassField);
        section2.getChildren().addAll(H,scrollPane,horiz,B);
        all.add(section1, 0, 0);
        all.add(section2, 1, 0);
        all.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.web("#a5cee5"), CornerRadii.EMPTY, Insets.EMPTY)));

        
        Scene scene = new Scene(all,900,700);           
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
    
    private ObservableList<CorrectionRequest> getCorrectionRequests() {
        ObservableList<CorrectionRequest> CorrectionRequestList = FXCollections.observableArrayList();
        ArrayList<CorrectionRequest> Requests = UserDB.getCorrectionRequests();
        for (int i = 0; i < Requests.size(); i++) {
            CorrectionRequestList.add(Requests.get(i));
        }
        return CorrectionRequestList;
    }
    
    private UserRequest getselectedRequest(int userRequestID){
        ArrayList<UserRequest> userRequests = UserDB.getUserRequests();
        for (int i = 0; i < userRequests.size(); i++) {
            if(userRequests.get(i).getUID()==userRequestID){
                return userRequests.get(i);
            }
        }
        return null;
    }
    
    private void tableClickeEvent() {
        selectedColumn = table.getSelectionModel().getSelectedItems().get(0);
        UserRequest selectedRequest = getselectedRequest(selectedColumn.getUserRequestID());
        //nameField.setText(selectedRequest.getName());
        education_field.setValue(selectedRequest.getEducation());
        //username_field.setText(selectedRequest.getUsername());
        email_field.setText(selectedRequest.getEmail());
        //password_field.setText(selectedRequest.getPassword());
        Phone.setText(selectedRequest.getPhone());
        occupation_field.setText(selectedRequest.getOccupation());
        address_field.setText(selectedRequest.getAddress());
        Date.setValue(LocalDate.parse(selectedRequest.getDOB(),DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        if (selectedRequest.getSex().equals("male")) {
            Male.setSelected(true);
        } else {
            Female.setSelected(true);
        }
        
        education_field.getItems().addAll("Graduate", "Undergraduate", "Secondary school", "Preparatory school", "Primary school", "KG", "none");
        
        Area_field.getItems().clear();
        Area_field.setValue(AdminDB.getAreaName(selectedRequest.getAreaID()));

        ArrayList<project.Area> areas = AdminDB.getAreas();
        for (int i = 0; i < areas.size(); i++) {
            Area_field.getItems().add(areas.get(i).getAreaName());
        }
    }
    
}
