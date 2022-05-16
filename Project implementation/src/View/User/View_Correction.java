package View.User;

import Controller.UserViewController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
import View.login.Login;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.DatePicker;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author email_field
 */
public class View_Correction extends Application {

    Stage S1;
    TableView<CorrectionRequestTableColumn> table = new TableView();
    CorrectionRequestTableColumn selectedColumn;
    UserRequestTableColumn UserRequest;
    TextField nameField;
    ComboBox education_field;
    TextField email_field;
    RadioButton Female;
    RadioButton Male;
    TextField Phone;
    TextField occupation_field;
    TextField address_field;
    DatePicker Date;

    int userID = 1;
    UserViewController userController;

    public View_Correction() {
    }

    public View_Correction(int userID) {
        this.userID = userID;
        userController = new UserViewController(userID);

    }

    @Override
    public void start(Stage stage) {

        GridPane all = new GridPane();
        all.setHgap(10);

// side btn section
        VBox section1 = new VBox();
        section1.setPrefSize(170, 500);

        Button View_my_family = new Button("View My Family\n" + "Members");
        Button Make_request = new Button("Make a request\n" + "for Adding New\n" + "member");
        Button view_request = new Button("View Your\n" + "Requests");
        Button View_Correction = new Button("View Correction\n" + "Requests");
        Button Logout = new Button("Logout");

        View_my_family.setMinSize(170, 140);
        View_my_family.setFont(Font.font("tahoma", FontWeight.BOLD, 15));
        View_my_family.setFocusTraversable(false);
        View_my_family.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                View_Family_Members c2 = new View_Family_Members(userID);
                S1.close();
                c2.start(new Stage());
            }
        });

        Make_request.setMinSize(170, 140);
        Make_request.setFont(Font.font("tahoma", FontWeight.BOLD, 15));
        Make_request.setFocusTraversable(false);
        Make_request.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                Make_Request c2 = new Make_Request(userID);
                S1.close();
                c2.start(new Stage());
            }
        });

        view_request.setMinSize(170, 140);
        view_request.setFont(Font.font("tahoma", FontWeight.BOLD, 15));
        view_request.setFocusTraversable(false);
        view_request.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                View_Your_Request c2 = new View_Your_Request(userID);
                S1.close();
                c2.start(new Stage());
            }
        });

        View_Correction.setMinSize(170, 140);
        View_Correction.setFont(Font.font("tahoma", FontWeight.BOLD, 15));
        View_Correction.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                View_Correction c2 = new View_Correction(userID);
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
                Login c2 = new Login();
                S1.close();
                c2.start(new Stage());
            }
        });

        section1.getChildren().addAll(View_my_family, Make_request, view_request, View_Correction, Logout);

//second section
        VBox section2 = new VBox(15);
        section2.setPrefSize(700, 550);
        //section2.setPadding(new Insets(5, 0, 0, 20));
        VBox NameField = new VBox(15);
        VBox PassField = new VBox(20);
        HBox horiz = new HBox(50);
        horiz.setPadding(new Insets(5, 0, 0, 25));
        Label H = new Label("Correction Requests");
        H.setFont(Font.font("Garamond", FontWeight.BOLD, 30));
        H.setPadding(new Insets(5, 0, 0, 200));
        table.setEditable(true);

        TableColumn<CorrectionRequestTableColumn, String> UserRequest_ID = new TableColumn<>("UserRequest ID");
        UserRequest_ID.setCellValueFactory(new PropertyValueFactory("UserRequestID"));

        TableColumn<CorrectionRequestTableColumn, String> Request_Title = new TableColumn<>("Request Title");
        Request_Title.setCellValueFactory(new PropertyValueFactory("RequestTitle"));

        TableColumn<CorrectionRequestTableColumn, String> Request_Content = new TableColumn<>("Request content");
        Request_Content.setCellValueFactory(new PropertyValueFactory("RequestContent"));

        UserRequest_ID.setPrefWidth(100);
        Request_Title.setPrefWidth(250);
        Request_Content.setPrefWidth(550);
        table.getColumns().addAll(UserRequest_ID, Request_Title, Request_Content);
        table.setMinHeight(800);
        table.setMinWidth(900);
        table.setItems(userController.getCorrectionRequests());
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
        HBox Name = new HBox(30);
        Label name = new Label("Name : ");
        name.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 16));
        nameField = new TextField();
        nameField.setPromptText("Name");
        nameField.setStyle("-fx-background-radius: 30px ;");
        nameField.setMaxWidth(300);
        Name.getChildren().addAll(name, nameField);
        //////education///////////////
        HBox Education = new HBox(15);
        Label education = new Label("Education: ");
        education.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 16));
        education_field = new ComboBox();
        education_field.setPrefWidth(150);
        Education.getChildren().addAll(education, education_field);
        //////email //////////
        HBox Email = new HBox(40);
        Label email = new Label("Email : ");
        email.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 16));
        email_field = new TextField();
        email_field.setStyle("-fx-background-radius: 30px ;");
        email_field.setPromptText("Email");
        email_field.setMaxWidth(300);
        Email.getChildren().addAll(email, email_field);
        ///////////sex /////////////
        HBox S = new HBox(50);
        Label sex = new Label("SEX :");
        sex.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 17));
        ToggleGroup tg = new ToggleGroup();
        Male = new RadioButton("Male: ");
        Female = new RadioButton("Female");
        tg.getToggles().addAll(Male, Female);
        S.getChildren().addAll(sex, Male, Female);
        ///////////////////phone/////////////
        HBox mobile = new HBox(30);
        Label phone = new Label("Phone : ");
        phone.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 17));
        Phone = new TextField();
        Phone.setStyle("-fx-background-radius: 30px ;");
        Phone.setPromptText("Phone");
        Phone.setMaxWidth(300);
        mobile.getChildren().addAll(phone, Phone);
        ///////////////////////////////////
        HBox Occupation = new HBox(10);
        Label occupation = new Label("Occupation : ");
        occupation.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 17));
        occupation_field = new TextField();
        occupation_field.setStyle("-fx-background-radius: 30px ;");
        occupation_field.setPromptText("Occupation");
        occupation_field.setMaxWidth(300);
        Occupation.getChildren().addAll(occupation, occupation_field);
        ///////////////////////////////////////
        HBox Address = new HBox(30);
        Label address = new Label("Address : ");
        address.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 17));
        address_field = new TextField();
        address_field.setStyle("-fx-background-radius: 30px ;");
        address_field.setPromptText("Address");
        address_field.setMaxWidth(300);
        Address.getChildren().addAll(address, address_field);
        //////Date////////////////
        HBox Dt = new HBox(40);
        Label data = new Label("Date : ");
        data.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 17));
        Date = new DatePicker();
        Dt.getChildren().addAll(data, Date);
        //////////////////button///////
        HBox B = new HBox(100);
        B.setPadding(new Insets(10, 0, 0, 260));
        Button U = new Button("Update");
        U.setStyle("-fx-background-radius: 300px ;-fx-background-color:Orange;");
        U.setMinWidth(120);
        U.setFont(Font.font("tahoma", FontWeight.BOLD, 15.5));
        U.setTextFill(javafx.scene.paint.Color.BLACK);
        B.getChildren().addAll(U);

        U.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                String name = nameField.getText();
                String sex = "Male";
                String Occupation = occupation_field.getText();
                String address = address_field.getText();
                String education = education_field.getSelectionModel().getSelectedItem().toString();
                String date = Date.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                String email = email_field.getText();
                String phone = Phone.getText();
                String Sex = "male";
                if (Female.isSelected()) {
                    Sex = "female";
                }

                userController.updateUserRequest(UserRequest, name, sex, Occupation, address, education, date, email, phone, Sex);
                table.setItems(userController.getCorrectionRequests());

            }
        });
        ////////////////////////
        NameField.getChildren().addAll(Name, Education, Email, mobile);
        PassField.getChildren().addAll(S, Occupation, Address, Dt);
        horiz.getChildren().addAll(NameField, PassField);
        section2.getChildren().addAll(H, scrollPane, horiz, B);
        all.add(section1, 0, 0);
        all.add(section2, 1, 0);
        all.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.web("#a5cee5"), CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(all, 900, 700);
        stage.setScene(scene);
        stage.setTitle("User Screen");
        stage.setResizable(false);

        stage.show();
        S1 = stage;
    }

    private void tableClickeEvent() {
        selectedColumn = table.getSelectionModel().getSelectedItems().get(0);
        UserRequest = userController.getUserRequestTableColumn(selectedColumn.getUserRequestID());
        nameField.setText(UserRequest.getName());
        education_field.setValue(UserRequest.getEducation());
        email_field.setText(UserRequest.getEmail());
        Phone.setText(UserRequest.getPhone());
        occupation_field.setText(UserRequest.getOccupation());
        address_field.setText(UserRequest.getAddress());
        Date.setValue(LocalDate.parse(UserRequest.getDOB(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        if (UserRequest.getSex().equals("male")) {
            Male.setSelected(true);
        } else {
            Female.setSelected(true);
        }

        education_field.getItems().addAll("Graduate", "Undergraduate", "Secondary school", "Preparatory school", "Primary school", "KG", "none");

    }

}
