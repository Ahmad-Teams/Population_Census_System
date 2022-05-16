package View.User;

import Controller.UserViewController;
import java.time.format.DateTimeFormatter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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

/**
 *
 * @author dell
 */
public class Make_Request extends Application {

    Stage S1;
    int userID = 1;
    UserViewController userController;
    TableView table = new TableView();

    public Make_Request() {
    }

    public Make_Request(int userID) {
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
        View_Correction.setFocusTraversable(false);
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
        section2.setPrefSize(700, 500);
        VBox NameField = new VBox(15);
        VBox PassField = new VBox(20);
        HBox horiz = new HBox(50);
        Label H = new Label("Add New Family Member");
        H.setFont(Font.font("Garamond", FontWeight.EXTRA_BOLD, 30));
        H.setPadding(new Insets(50, 0, 75, 140));

        /////Name field//////
        HBox Name = new HBox(30);
        Label name = new Label("Name :");
        name.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 20));
        TextField name_field = new TextField();
        name_field.setPromptText("User's name");
        name_field.setStyle("-fx-background-radius: 10px ;");
        name_field.setPrefSize(150, 23);
        Name.getChildren().addAll(name, name_field);
        Name.setPadding(new Insets(0, 20, 25, 10));

        ///////// education //////////
        HBox h_education = new HBox(20);
        Label education = new Label("Education: ");
        education.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 16));
        ComboBox education_cbox = new ComboBox();
        education_cbox.getItems().addAll("Graduate", "Undergraduate", "Secondary school", "Preparatory school", "Primary school", "KG", "none");
        education_cbox.setValue("none");
        education_cbox.setPrefWidth(150);
        h_education.getChildren().addAll(education, education_cbox);
        h_education.setPadding(new Insets(0, 20, 25, 10));

        //////email //////////
        HBox h_email = new HBox(40);
        Label Email = new Label("Email : ");
        Email.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 16));
        TextField Email_field = new TextField();
        Email_field.setStyle("-fx-background-radius: 30px ;");
        Email_field.setPromptText("Email");
        Email_field.setMaxWidth(300);
        h_email.getChildren().addAll(Email, Email_field);
        h_email.setPadding(new Insets(0, 20, 25, 10));

        ///////////sex /////////////
        HBox gender = new HBox(50);
        Label sex = new Label("SEX :");
        sex.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 17));
        ToggleGroup tg = new ToggleGroup();
        RadioButton Male = new RadioButton("Male ");
        RadioButton Female = new RadioButton("Female");
        tg.getToggles().addAll(Male, Female);
        gender.getChildren().addAll(sex, Male, Female);
        gender.setPadding(new Insets(0, 20, 25, 10));

        ////////////////Occupation///////////////////
        HBox h_Occupation = new HBox(10);
        Label Occupation = new Label("Occupation : ");
        Occupation.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 17));
        TextField Occupation_field = new TextField();
        Occupation_field.setStyle("-fx-background-radius: 30px ;");
        Occupation_field.setPromptText("Occupation");
        Occupation_field.setMaxWidth(300);
        h_Occupation.getChildren().addAll(Occupation, Occupation_field);
        h_Occupation.setPadding(new Insets(0, 20, 25, 10));

        ///////////////Address////////////////////////
        HBox h_address = new HBox(30);
        Label address = new Label("Address : ");
        address.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 17));
        TextField address_field = new TextField();
        address_field.setStyle("-fx-background-radius: 30px ;");
        address_field.setPromptText("Address");
        address_field.setMaxWidth(300);
        h_address.getChildren().addAll(address, address_field);
        h_address.setPadding(new Insets(0, 20, 15, 10));

        //////date////////////////////
        HBox h_data = new HBox(30);
        Label data = new Label("Date : ");
        data.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 17));
        DatePicker calendar = new DatePicker();
        h_data.getChildren().addAll(data, calendar);
        h_data.setPadding(new Insets(0, 20, 25, 10));

        /////////////phone///////////////////
        HBox h_Phone = new HBox(30);
        Label Phone = new Label("Phone : ");
        Phone.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 17));
        TextField Phone_field = new TextField();
        Phone_field.setStyle("-fx-background-radius: 30px ;");
        Phone_field.setPromptText("Phone");
        Phone_field.setMaxWidth(300);
        h_Phone.getChildren().addAll(Phone, Phone_field);
        h_Phone.setPadding(new Insets(0, 20, 18, 10));

        //////////////////button/////////////////
        HBox h_Box = new HBox(100);
        h_Box.setPadding(new Insets(10, 0, 0, 150));
        Button reset_botton = new Button(" Reset ");
        Button makeRequest = new Button(" Make Request ");
        reset_botton.setStyle("-fx-background-radius: 300px ;-fx-background-color:Red; ");
        makeRequest.setStyle("-fx-background-radius: 300px ;-fx-background-color:Orange;");
        reset_botton.setMinWidth(120);
        makeRequest.setMinWidth(120);
        reset_botton.setFont(Font.font("tahoma", FontWeight.BOLD, 15.5));
        reset_botton.setTextFill(javafx.scene.paint.Color.BLACK);
        makeRequest.setFont(Font.font("tahoma", FontWeight.BOLD, 15.5));
        makeRequest.setTextFill(javafx.scene.paint.Color.BLACK);
        h_Box.getChildren().addAll(reset_botton, makeRequest);
        ////////////// add botton /////////////////
        makeRequest.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                try {
                    String name = name_field.getText();
                    String sex = "Male";
                    String Occupation = Occupation_field.getText();
                    String address = address_field.getText();
                    String education = education_cbox.getSelectionModel().getSelectedItem().toString();
                    String date = calendar.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    String email = Email_field.getText();
                    String phone = Phone_field.getText();
                    if (Female.isSelected()) {
                        sex = "Female";
                    }
                    userController.addUserRequest(name, address, education, phone, email, date,sex, Occupation, userID);
                    // clear the fields
                    name_field.setText("");
                    Male.setSelected(false);
                    Female.setSelected(false);
//                area_cbox.setValue(areas.get(0).getAreaName());
                    Occupation_field.setText("");
                    address_field.setText("");
                    education_cbox.setValue("none");
                    calendar.setValue(null);
                    Email_field.setText("");
                    Phone_field.setText("");
                } catch (Exception e) {
                }

            }
        });
        /////////// reset botton /////////////
        reset_botton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                // clear the fields
                name_field.setText("");
                Male.setSelected(false);
                Female.setSelected(false);
//                area_cbox.setValue(areas.get(0).getAreaName());
                Occupation_field.setText("");
                address_field.setText("");
                education_cbox.setValue("none");
                calendar.setValue(null);
                Email_field.setText("");
                Phone_field.setText("");
            }
        });
        ////////////////////////
        NameField.getChildren().addAll(Name, h_education, h_email, h_Phone);
        PassField.getChildren().addAll(gender, h_Occupation, h_address, h_data);
        horiz.getChildren().addAll(NameField, PassField);
        section2.getChildren().addAll(H, horiz, h_Box);
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

 
}
