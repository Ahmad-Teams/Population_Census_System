/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Admin;

import Controller.AdminViewController;
import View.User.UserTableColumn;
import View.login.Login;
import View.Admin.Make_Report;
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

/**
 *
 * @author user
 */
public class Make_Report extends Application {

    Stage S1;
    int adminID;
    ComboBox SearchOn = new ComboBox();
    ComboBox SearchOptions = new ComboBox();
    ComboBox SortByOption = new ComboBox();
    ComboBox OrderOption = new ComboBox();
    TableView table = new TableView();
    ScrollPane scrollPane = new ScrollPane();
    AdminViewController adminController;

    public Make_Report() {
    }

    public Make_Report(int adminID) {
        this.adminID = adminID;
        adminController = new AdminViewController(adminID);
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
                Admin_AddOfficer c2 = new Admin_AddOfficer(adminID);
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
                Admin_OfficerList c2 = new Admin_OfficerList(adminID);
                S1.close();
                c2.start(new Stage());
            }
        });

        Make_report.setMinSize(170, 175);
        Make_report.setFont(Font.font("tahoma", FontWeight.BOLD, 15));
        Make_report.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                Make_Report c2 = new Make_Report(adminID);
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
        SearchOn.setPrefWidth(100);
        search.setPadding(new Insets(10, 0, 0, 70));
        search.getChildren().addAll(Searching, SearchOn);

        SearchOn.setOnAction(event -> {
            String selectionValue = SearchOn.getValue().toString();
            SearchOptions.getItems().clear();
            SortByOption.getItems().clear();
            if (selectionValue.equals("User")) {
                SearchOptions.getItems().addAll("Has descendants", "Doesn`t has descendants");
                SearchOptions.setValue("Has descendants");
                SortByOption.getItems().addAll("userID", "Name", "Sex", "Email", "Phone", "Address");
                SortByOption.setValue("userID");
            } else if (selectionValue.equals("Officer")) {
                SearchOptions.getItems().addAll("Has Users", "Doesn`t has Users");
                SearchOptions.setValue("Has Users");
                SortByOption.getItems().addAll("officerID", "Name", "Sex", "Email", "Phone", "Username", "Password");
                SortByOption.setValue("officerID");
            }
        });

        /////////////Select an option to display////////////////
        HBox Display_search = new HBox(15);
        Label display = new Label("Select an option to display: ");
        display.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 18));
        SearchOptions.setPrefWidth(180);
        Display_search.setPadding(new Insets(0, 0, 20, 20));
        Display_search.getChildren().addAll(display, SearchOptions);
        /////Select an option to sort on/////////////
        HBox sortOptionBox = new HBox(15);
        Label sortByLable = new Label("Sort By: ");
        sortByLable.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 18));
        SortByOption.setPrefWidth(120);
        sortOptionBox.setPadding(new Insets(10, 0, 0, 20));
        sortOptionBox.getChildren().addAll(sortByLable, SortByOption);

        /////Select an order to sort on/////////////
        HBox optionOrder = new HBox(15);
        Label option = new Label("Order: ");
        option.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 18));
        OrderOption.setPrefWidth(120);
        optionOrder.setPadding(new Insets(10, 0, 0, 20));
        optionOrder.getChildren().addAll(option, OrderOption);

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
                table.getItems().clear();
                table.setDisable(false);
                String selectionValue = SearchOn.getValue().toString();
                if (selectionValue.equals("User")) {
                    TableColumn<UserTableColumn, Integer> ID = new TableColumn<>("userID");
                    ID.setCellValueFactory(new PropertyValueFactory("userID"));

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

                    TableColumn<UserTableColumn, String> address = new TableColumn<>("Address");
                    address.setCellValueFactory(new PropertyValueFactory("address"));

                    ID.setPrefWidth(50);
                    name.setPrefWidth(110);
                    sex.setPrefWidth(60);
                    email.setPrefWidth(120);
                    phone.setPrefWidth(120);
                    areaName.setPrefWidth(100);
                    address.setPrefWidth(100);
                    table.getColumns().addAll(ID, name, sex, email, phone, areaName, address);
                } else if (selectionValue.equals("Officer")) {

                    TableColumn<OfficerTableColumn, Integer> ID = new TableColumn<>("officerID");
                    ID.setCellValueFactory(new PropertyValueFactory("officerID"));

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
                table.setItems(adminController.getReport(SearchOn.getValue().toString(), SearchOptions.getValue().toString(), SortByOption.getValue().toString(), OrderOption.getValue().toString()));
            }

        });
        B.getChildren().add(D);

        section2.getChildren().addAll(H, search, Display_search, sortOptionBox, optionOrder, B, this.scrollPane);
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

    

    private void setdefaultComboBoxes() {
        SearchOn.getItems().addAll("User", "Officer");
        SearchOn.setValue("User");
        SearchOptions.getItems().addAll("Has descendants", "Doesn`t has descendants");
        SearchOptions.setValue("Has descendants");
        SortByOption.getItems().addAll("userID", "Name", "Sex", "Email", "Phone", "Address");
        SortByOption.setValue("userID");
        OrderOption.getItems().addAll("Ascending", "Descending");
        OrderOption.setValue("Ascending");
    }

}
