/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Admin;

import View.login.Login;
import View.Admin.AdminGUI;
import View.Admin.Make_Report;
import Model.database.AdminDB;
import java.awt.geom.Area;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import View.login.Login;
import Model.project.Observer;
import Model.project.Officer;
import View.Admin.OfficerTableColumn;
import Model.project.*;

/**
 *
 * @author user
 */
public class Admin_OfficerList extends Application {

    Stage S1;
    TableView<OfficerTableColumn> table = new TableView();
    OfficerTableColumn selectedColumn;
    TextField nameField;
    TextField user;
    TextField user1;
    PasswordField P;
    RadioButton Female;
    RadioButton Male;
    TextField Phone;
    ComboBox Area;
    Admin admin = new Admin(0, 0, STYLESHEET_MODENA, STYLESHEET_MODENA, STYLESHEET_MODENA, STYLESHEET_MODENA, STYLESHEET_MODENA, STYLESHEET_CASPIAN, STYLESHEET_MODENA);
//remove the above instailization later

    public Admin_OfficerList() {
    }

    public Admin_OfficerList(Admin admin) {
        this.admin = admin;
    }

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
        Add_Officer.setFocusTraversable(false);
        Add_Officer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                Admin_AddOfficer c2 = new Admin_AddOfficer();
                S1.close();
                c2.start(new Stage());
            }
        });

        Officers_list.setMinSize(170, 175);
        Officers_list.setFont(Font.font("tahoma", FontWeight.BOLD, 15));
        Officers_list.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                Admin_OfficerList c2 = new Admin_OfficerList();
                S1.close();
                c2.start(new Stage());
            }
        });

        Make_report.setMinSize(170, 175);
        Make_report.setFont(Font.font("tahoma", FontWeight.BOLD, 15));
        Make_report.setFocusTraversable(false);
        Make_report.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                Make_Report c2 = new Make_Report();
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
                Login c2 = new Login();
                S1.close();
                c2.start(new Stage());
            }
        });

        section1.getChildren().addAll(Add_Officer, Officers_list, Make_report, Logout);

//second section
        VBox section2 = new VBox(15);
        section2.setPrefSize(600, 500);
        VBox NameField = new VBox(15);
        VBox PassField = new VBox(20);
        HBox horiz = new HBox(15);
        Label H = new Label("Office List");
        H.setFont(Font.font("Garamond", FontWeight.BOLD, 30));
        H.setPadding(new Insets(5, 0, 0, 250));

        table.setEditable(true);
        table.setMinHeight(1000);
        table.setMinWidth(760);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(table);
        scrollPane.pannableProperty().set(true);
        scrollPane.fitToWidthProperty().set(true);
        scrollPane.fitToHeightProperty().set(true);
        scrollPane.setPrefHeight(300);
        scrollPane.setMaxWidth(900);
        scrollPane.hbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.ALWAYS);

        TableColumn<OfficerTableColumn, Integer> ID = new TableColumn<>("ID");
        ID.setCellValueFactory(new PropertyValueFactory("OID"));

        TableColumn<OfficerTableColumn, String> name = new TableColumn<>("Name");
        name.setCellValueFactory(new PropertyValueFactory("name"));

        TableColumn<OfficerTableColumn, String> sex = new TableColumn<>("Sex");
        sex.setCellValueFactory(new PropertyValueFactory("Sex"));

        TableColumn<OfficerTableColumn, String> email = new TableColumn<>("Email");
        email.setCellValueFactory(new PropertyValueFactory("Email"));

        TableColumn<OfficerTableColumn, String> phone = new TableColumn<>("Phone");
        phone.setCellValueFactory(new PropertyValueFactory("phone"));

        TableColumn<OfficerTableColumn, String> areaName = new TableColumn<>("Area");
        areaName.setCellValueFactory(new PropertyValueFactory("areaName"));

        TableColumn<OfficerTableColumn, String> username = new TableColumn<>("Username");
        username.setCellValueFactory(new PropertyValueFactory("username"));

        TableColumn<OfficerTableColumn, String> password = new TableColumn<>("Password");
        password.setCellValueFactory(new PropertyValueFactory("password"));

        ID.setPrefWidth(50);
        name.setPrefWidth(110);
        sex.setPrefWidth(60);
        email.setPrefWidth(120);
        phone.setPrefWidth(120);
        areaName.setPrefWidth(100);
        username.setPrefWidth(100);
        password.setPrefWidth(100);

        table.getColumns().addAll(ID, name, sex, email, phone, areaName, username, password);
        table.setMinHeight(1000);
        table.setItems(getOfficers());
        table.setOnMouseClicked(e -> {
            tableClickeEvent();
        });

        /////Name field//////
        HBox Name = new HBox(30);
        Label l1 = new Label("Name : ");
        l1.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 16));
        this.nameField = new TextField();
        nameField.setPromptText("Name");
        nameField.setStyle("-fx-background-radius: 30px ;");
        nameField.setMaxWidth(300);
        Name.getChildren().addAll(l1, nameField);
        ///////Area////////////
        HBox area = new HBox(50);
        Label l2 = new Label("Area: ");
        l2.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 16));
        this.Area = new ComboBox();
        Area.setPrefWidth(150);
        area.getChildren().addAll(l2, Area);
        //////email //////////
        HBox Email = new HBox(40);
        Label emailLable = new Label("Email : ");
        emailLable.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 16));
        this.user = new TextField();
        user.setStyle("-fx-background-radius: 30px ;");
        user.setPromptText("Email");
        user.setMaxWidth(300);
        Email.getChildren().addAll(emailLable, user);
        ////////////username/////////////
        HBox User = new HBox(1);
        Label u = new Label("User Name : ");
        u.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 16));
        this.user1 = new TextField();
        user1.setStyle("-fx-background-radius: 30px ;");
        user1.setPromptText("UserName");
        user1.setMaxWidth(300);
        User.getChildren().addAll(u, user1);
        /////////// passwordBox /////////////
        HBox passwordBox = new HBox(10);
        Label pass = new Label("Password : ");
        pass.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 16));
        this.P = new PasswordField();
        P.setMaxWidth(300);
        P.setStyle("-fx-background-radius: 30px ;");
        P.setPromptText("Password");
        passwordBox.getChildren().addAll(pass, P);
        ///////////sex /////////////
        HBox S = new HBox(50);
        Label s = new Label("SEX :");
        ToggleGroup tg = new ToggleGroup();
        this.Male = new RadioButton("Male: ");
        this.Female = new RadioButton("Female");
        tg.getToggles().addAll(Male, Female);
        S.getChildren().addAll(s, Male, Female);
        ///////////////////phone/////////////
        HBox mobile = new HBox(30);
        Label ph = new Label("Phone : ");
        ph.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 17));
        this.Phone = new TextField();
        Phone.setStyle("-fx-background-radius: 30px ;");
        Phone.setPromptText("Phone");
        Phone.setMaxWidth(300);
        mobile.getChildren().addAll(ph, Phone);
        //////////////////button///////
        HBox B = new HBox(100);
        B.setPadding(new Insets(10, 0, 0, 80));
        Button D = new Button("Delete Officer");
        Button U = new Button("Update Officer");
        D.setStyle("-fx-background-radius: 300px ;-fx-background-color:Red; ");
        U.setStyle("-fx-background-radius: 300px ;-fx-background-color:Orange;");
        D.setMinWidth(120);
        U.setMinWidth(120);
        D.setFont(Font.font("tahoma", FontWeight.BOLD, 15.5));
        D.setTextFill(javafx.scene.paint.Color.BLACK);
        U.setFont(Font.font("tahoma", FontWeight.BOLD, 15.5));
        U.setTextFill(javafx.scene.paint.Color.BLACK);
        B.getChildren().addAll(D, U);

        D.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                AdminDB.deleteOfficer(selectedColumn.getOID());

                nameField.setText("");
                user1.setText("");
                user.setText("");
                P.setText("");
                Phone.setText("");
                Male.setSelected(false);
                Female.setSelected(false);
                Area.getItems().clear();
                Area.setValue("");

                table.setItems(getOfficers());

            }

        });

        U.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                String Sex = "male";
                if (Female.isSelected()) {
                    Sex = "female";
                }
                AdminDB.updateOfficer(new Officer(Phone.getText(), user.getText(), selectedColumn.getOID(), nameField.getText(), AdminDB.getAreaID(Area.getSelectionModel().getSelectedItem().toString()), Sex, user1.getText(), P.getText(), admin.getAID()));
                table.setItems(getOfficers());
            }
        });
        ////////////////////////
        NameField.getChildren().addAll(Name, area, Email, User);
        PassField.getChildren().addAll(S, mobile, passwordBox);
        horiz.getChildren().addAll(NameField, PassField);
        section2.getChildren().addAll(H, scrollPane, horiz, B);
        all.add(section1, 0, 0);
        all.add(section2, 1, 0);
        all.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.web("#a5cee5"), CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(all, 800, 700);
        stage.setScene(scene);
        stage.setTitle("Admin Screen");
        stage.setResizable(false);

        stage.show();
        S1 = stage;
    }
    
   /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void tableClickeEvent() {
        selectedColumn = table.getSelectionModel().getSelectedItems().get(0);
        nameField.setText(selectedColumn.getName());
        user1.setText(selectedColumn.getUsername());
        user.setText(selectedColumn.getEmail());
        P.setText(selectedColumn.getPassword());
        Phone.setText(selectedColumn.getPhone());

        if (selectedColumn.getSex().equals("male")) {
            Male.setSelected(true);
        } else {
            Female.setSelected(true);
        }
        Area.getItems().clear();
        Area.setValue(AdminDB.getAreaName(selectedColumn.getAreaID()));

        ArrayList<Model.project.Area> areas = AdminDB.getAreas();
        for (int i = 0; i < areas.size(); i++) {
            Area.getItems().add(areas.get(i).getAreaName());
        }
    }

    private ObservableList<OfficerTableColumn> getOfficers() {
        ObservableList<OfficerTableColumn> officerList = FXCollections.observableArrayList();
        ArrayList<Officer> officers = AdminDB.getOfficers();
        for (int i = 0; i < officers.size(); i++) {
            Officer officer = officers.get(i);
            officerList.add(new OfficerTableColumn(officer, AdminDB.getAreaName(officer.getAreaID())));
        }
        return officerList;
    }

}
