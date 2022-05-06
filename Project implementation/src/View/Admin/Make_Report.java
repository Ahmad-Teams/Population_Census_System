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
import Model.project.Admin;

/**
 *
 * @author user
 */
public class Make_Report extends Application {

    Stage S1;
    Admin admin;
    ComboBox Search = new ComboBox();
    ComboBox Select_display = new ComboBox();
    ComboBox Select_option = new ComboBox();
    TableView table = new TableView();
    ScrollPane scrollPane = new ScrollPane();

    public Make_Report() {
    }

    public Make_Report(Admin admin) {
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
        Officers_list.setFocusTraversable(false);
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
        VBox section2 = new VBox(30);
        section2.setPrefSize(530, 500);
        Label H = new Label("Report on Family members");
        H.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 22));
        H.setPadding(new Insets(5, 0, 0, 100));

        table.setEditable(true);
        table.setMinHeight(1000);
        table.setMinWidth(760);
        table.setDisable(true);

        scrollPane.setContent(table);
        scrollPane.pannableProperty().set(true);
        scrollPane.fitToWidthProperty().set(true);
        scrollPane.fitToHeightProperty().set(true);
        scrollPane.setPrefHeight(300);
        scrollPane.setMaxWidth(900);
        scrollPane.hbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.ALWAYS);

        /////searching on//////
        HBox search = new HBox(15);
        Label Searching = new Label("Searching on: ");
        Searching.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 18));
        Search.setPrefWidth(100);
        search.setPadding(new Insets(10, 0, 0, 70));
        search.getChildren().addAll(Searching, Search);

        Search.setOnAction(event -> {
            String selectionValue = Search.getValue().toString();
            Select_display.getItems().clear();
            if (selectionValue.equals("User")) {
                Select_display.getItems().addAll("Has dependance", "Doesn`t has dependance");
                Select_display.setValue("Has dependance");
            } else if (selectionValue.equals("Officer")) {
                Select_display.getItems().addAll("Has Users", "Doesn`t has Users");
                Select_display.setValue("Has Users");
            } else if (selectionValue.equals("Family members")) {
                Select_display.getItems().addAll("Under your responsibility", "Others");
                Select_display.setValue("Under your responsibility");
            }
        });

        /////////////Select an option to display////////////////
        HBox Display_search = new HBox(15);
        Label display = new Label("Select an option to display: ");
        display.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 18));
        Select_display.setPrefWidth(180);
        Display_search.setPadding(new Insets(0, 0, 20, 20));
        Display_search.getChildren().addAll(display, Select_display);
        /////Select an option to sort on/////////////
        HBox option_search = new HBox(15);
        Label option = new Label("Select an option to sort on: ");
        option.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 18));
        Select_option.setPrefWidth(120);
        option_search.setPadding(new Insets(10, 0, 0, 20));
        option_search.getChildren().addAll(option, Select_option);

        setdefaultComboBoxes();
        ////////////////////////
        HBox B = new HBox(100);
        B.setPadding(new Insets(0, 0, 0, 180));
        Button D = new Button("Make a Report");
        D.setStyle("-fx-background-radius: 300px ;-fx-background-color:yellow; ");
        D.setMinWidth(120);
        D.setFont(Font.font("tahoma", FontWeight.BOLD, 15.5));
        D.setTextFill(javafx.scene.paint.Color.BLACK);
        D.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                table.getColumns().clear();
                table.setDisable(false);
                String selectionValue = Search.getValue().toString();
                if (selectionValue.equals("User")) {
                    TableColumn<UserTableColumn, Integer> ID = new TableColumn<>("ID");
                    ID.setCellValueFactory(new PropertyValueFactory("UID"));

                    TableColumn<UserTableColumn, String> name = new TableColumn<>("Name");
                    name.setCellValueFactory(new PropertyValueFactory("name"));

                    TableColumn<UserTableColumn, String> sex = new TableColumn<>("Sex");
                    sex.setCellValueFactory(new PropertyValueFactory("Sex"));

                    TableColumn<UserTableColumn, String> email = new TableColumn<>("Email");
                    email.setCellValueFactory(new PropertyValueFactory("Email"));

                    TableColumn<UserTableColumn, String> phone = new TableColumn<>("Phone");
                    phone.setCellValueFactory(new PropertyValueFactory("phone"));

                    TableColumn<UserTableColumn, String> areaName = new TableColumn<>("Area");
                    areaName.setCellValueFactory(new PropertyValueFactory("areaName"));

                    TableColumn<UserTableColumn, String> city = new TableColumn<>("City");
                    city.setCellValueFactory(new PropertyValueFactory("city"));

                    TableColumn<UserTableColumn, String> address = new TableColumn<>("Address");
                    address.setCellValueFactory(new PropertyValueFactory("address"));

                    ID.setPrefWidth(50);
                    name.setPrefWidth(110);
                    sex.setPrefWidth(60);
                    email.setPrefWidth(120);
                    phone.setPrefWidth(120);
                    areaName.setPrefWidth(100);
                    city.setPrefWidth(100);
                    address.setPrefWidth(100);

                    table.getColumns().addAll(ID, name, sex, email, phone, areaName, city, address);

                } else if (selectionValue.equals("Officer")) {

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

                    table.getColumns().addAll(ID, name, sex, email, username, password, phone, areaName);
                } else if (selectionValue.equals("Family members")) {

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

                    table.getColumns().addAll(ID, name, sex, email, username, password, phone, areaName);
                }
            }

        });
        B.getChildren().add(D);

        section2.getChildren().addAll(H, search, Display_search, option_search, B, this.scrollPane);
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

    private void setdefaultComboBoxes() {
        Search.getItems().addAll("User", "Officer", "Family members");
        Search.setValue("User");
        Select_display.getItems().addAll("Has dependance", "Doesn`t has dependance");
        Select_display.setValue("Has dependance");
        Select_option.getItems().addAll("Ascending", "Descending");
        Select_option.setValue("Ascending");
    }

}
