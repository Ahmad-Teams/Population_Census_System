/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Officer;

import Controller.OfficerViewController;
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
import javafx.scene.control.TextArea;
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
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import View.login.Login;
import View.User.UserRequestTableColumn;
import View.User.View_Correction;
import View.User.View_Family_Members;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author user
 */
public class ViewNewRequests extends Application {

    Stage S1;
    int officerID = 10;
    TableView table = new TableView();
    Text t = new Text();
    OfficerViewController officerController = new OfficerViewController(officerID);
    UserRequestTableColumn selectedColumn;
    boolean isSelectedColumnHasCorrectionRequest;
    TextArea Correct = new TextArea();
    TextField name_field = new TextField();
    Label name2 = new Label("Title:       ");
    Label name3 = new Label("Reason:       ");
    VBox SEND = new VBox(10);
    Button SendButton = new Button("Send");

    public ViewNewRequests() {
    }

    public ViewNewRequests(int officerID) {
        this.officerID = officerID;
    }

    @Override
    public void start(Stage stage) {
        GridPane all = new GridPane();
        all.setHgap(10);

// side btn section
        VBox section1 = new VBox();
        section1.setPrefSize(170, 500);

        Button View_my_family = new Button("Add User");
        Button View_Correction = new Button("   View New \n"
                + "User Request");
        Button Logout = new Button("Logout");

        View_my_family.setMinSize(170, 258);
        View_my_family.setFont(Font.font("tahoma", FontWeight.BOLD, 15));
        View_my_family.setFocusTraversable(false);
        View_my_family.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                AddUser c2 = new AddUser();
                S1.close();
                c2.start(new Stage());
            }
        });

        View_Correction.setMinSize(170, 258);
        View_Correction.setFont(Font.font("tahoma", FontWeight.BOLD, 15));
        View_Correction.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                ViewNewRequests c2 = new ViewNewRequests();
                S1.close();
                c2.start(new Stage());
            }
        });

        Logout.setMinSize(170, 259);
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

        section1.getChildren().addAll(View_my_family, View_Correction, Logout);

        //////////////////////////////////////
        VBox section2 = new VBox(6);
        section2.setPrefSize(530, 400);
        section2.setMinHeight(300);
        Label H = new Label("New Requests");
        H.setFont(Font.font("Garamond", FontWeight.BOLD, 30));
        H.setPadding(new Insets(5, 0, 0, 180));
        table.setEditable(true);
        table.setMinHeight(1400);
        table.setMinWidth(860);
        table.setOnMouseClicked(e -> {
            tableClickeEvent();
        });
        TableColumn<UserRequestTableColumn, String> requestID = new TableColumn<>("Request ID");
        requestID.setCellValueFactory(new PropertyValueFactory("requestID"));
        requestID.setPrefWidth(80);

        TableColumn<UserRequestTableColumn, String> requestState = new TableColumn<>("Request State");
        requestState.setCellValueFactory(new PropertyValueFactory("requestState"));
        requestState.setPrefWidth(100);

        TableColumn<UserRequestTableColumn, String> ID = new TableColumn<>("Member ID");
        ID.setCellValueFactory(new PropertyValueFactory("MID"));
        ID.setPrefWidth(80);

        TableColumn<UserRequestTableColumn, String> name = new TableColumn<>("Name");
        name.setCellValueFactory(new PropertyValueFactory("name"));
        name.setPrefWidth(120);

        TableColumn<UserRequestTableColumn, String> address = new TableColumn<>("Address");
        address.setCellValueFactory(new PropertyValueFactory("address"));
        address.setPrefWidth(120);

        TableColumn<UserRequestTableColumn, String> education = new TableColumn("Education");
        education.setCellValueFactory(new PropertyValueFactory("education"));
        education.setPrefWidth(110);

        TableColumn<UserRequestTableColumn, String> sex = new TableColumn("Sex");
        sex.setCellValueFactory(new PropertyValueFactory("Sex"));
        sex.setPrefWidth(50);

        TableColumn<UserRequestTableColumn, String> occupation = new TableColumn("Occupation");
        occupation.setCellValueFactory(new PropertyValueFactory("occupation"));
        occupation.setPrefWidth(100);

        TableColumn<UserRequestTableColumn, String> email = new TableColumn("Email");
        email.setCellValueFactory(new PropertyValueFactory("Email"));
        email.setPrefWidth(100);

        TableColumn<UserRequestTableColumn, String> phone = new TableColumn("phone");
        phone.setCellValueFactory(new PropertyValueFactory("phone"));
        phone.setPrefWidth(100);

        TableColumn<UserRequestTableColumn, String> DOB = new TableColumn("Date Of Birth");
        DOB.setCellValueFactory(new PropertyValueFactory("DOB"));
        DOB.setPrefWidth(100);

        TableColumn<UserRequestTableColumn, String> area = new TableColumn("Area");
        area.setCellValueFactory(new PropertyValueFactory("areaName"));
        area.setPrefWidth(100);

        table.getColumns().addAll(requestID, requestState, ID, name, address, education, sex, occupation, email, phone, DOB, area);
        table.setMaxHeight(300);
        table.setMinWidth(1150);
        table.setItems(officerController.getPendingUserRequests());
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(table);
        scrollPane.pannableProperty().set(true);
        scrollPane.fitToWidthProperty().set(true);
        scrollPane.fitToHeightProperty().set(true);
        scrollPane.setPrefHeight(300);
        scrollPane.setMaxWidth(900);
        //scrollPane.hbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.ALWAYS);
        //////////////////////////////////////////////////////////////////////////////////
        HBox h_name = new HBox();
        h_name.setPadding(new Insets(30, 0, 0, 0));
        h_name.setAlignment(Pos.CENTER);

        name2.setFont(Font.font("arial", FontWeight.BOLD, 17));
        name2.setVisible(false);

        name_field.setPromptText("Title Of Correction Request  ");
        name_field.setPrefSize(200, 40);
        name_field.setVisible(false);

        h_name.getChildren().addAll(name2, name_field);

        //////////////////
        HBox h_name2 = new HBox();
        h_name2.setPadding(new Insets(30, 0, 0, 0));
        h_name2.setAlignment(Pos.CENTER);
        name3.setFont(Font.font("arial", FontWeight.BOLD, 17));
        //Correct.setStyle("-fx-background-radius: 30px ;");
        Correct.setPromptText("Message");
        Correct.setMaxHeight(220);
        Correct.setWrapText(true);
        Correct.setVisible(false);
        name3.setVisible(false);
        h_name2.getChildren().addAll(name3, Correct);
        ///////////////////////////////////////////////////////////////////////////////////////
        SendButton.setFont(Font.font("tahoma", FontWeight.LIGHT, 16));
        SendButton.setTextFill(javafx.scene.paint.Color.BLACK);
        SendButton.setStyle("-fx-background-radius: 300px ;");
        SendButton.setMinWidth(120);
        SendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {

                t.setText("Correction Request sent!");
                t.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20));
                if (isSelectedColumnHasCorrectionRequest) {
                    officerController.updateCorrectionRequest(selectedColumn.getRequestID(), name_field.getText(), Correct.getText());
                    tableClickeEvent();
                } else {
                    officerController.makeCorrectionRequest(selectedColumn.getRequestID(), selectedColumn.getUID(), officerID, name_field.getText(), Correct.getText());
                }
                officerController.updateStateOfUserRequestToRejected(selectedColumn.getRequestID());
                table.setItems(officerController.getPendingUserRequests());
                name2.setVisible(false);
                name_field.setVisible(false);
                Correct.setVisible(false);
                name3.setVisible(false);
                SendButton.setVisible(false);
                t.setVisible(true);
            }
        });
        SEND.setPadding(new Insets(0, 0, 0, 230));
        SEND.getChildren().addAll(t, SendButton);
        SEND.setVisible(false);
        //////////////////////////////////////////////////////////////
        HBox B = new HBox(100);
        B.setPadding(new Insets(10, 0, 10, 130));
        Button reject = new Button("Reject");
        Button accept = new Button("Accept");
        reject.setStyle("-fx-background-radius: 300px ;-fx-background-color:Red; ");
        accept.setStyle("-fx-background-radius: 300px ;-fx-background-color:Orange;");
        reject.setMinWidth(110);
        accept.setMinWidth(110);
        reject.setFont(Font.font("tahoma", FontWeight.LIGHT, 16));
        reject.setTextFill(javafx.scene.paint.Color.BLACK);
        accept.setFont(Font.font("tahoma", FontWeight.LIGHT, 16));
        accept.setTextFill(javafx.scene.paint.Color.BLACK);
        accept.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                name2.setVisible(false);
                name_field.setVisible(false);
                Correct.setVisible(false);
                name3.setVisible(false);
                SEND.setVisible(false);
                t.setVisible(false);
                SendButton.setVisible(false);
                officerController.updateStateOfUserRequestToAccepted(selectedColumn.getRequestID());
                tableClickeEvent();
                table.setItems(officerController.getPendingUserRequests());

            }
        });
        reject.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                name2.setVisible(true);
                name_field.setVisible(true);
                Correct.setVisible(true);
                name3.setVisible(true);
                SEND.setVisible(true);
                t.setVisible(false);
                SendButton.setVisible(true);
            }
        });
        B.getChildren().addAll(reject, accept);
        section2.getChildren().addAll(H, scrollPane, B, name2, name_field, name3, Correct, SEND);
        //////////////////////////////////////
        all.add(section1, 0, 0);
        all.add(section2, 1, 0);
        all.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.web("#a5cee5"), CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(all, 800, 775);
        stage.setScene(scene);
        stage.setTitle("Officer Screen");
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
        selectedColumn = (UserRequestTableColumn) table.getSelectionModel().getSelectedItems().get(0);
        isSelectedColumnHasCorrectionRequest = officerController.checkSelectedColumnHasCorrectionRequest(selectedColumn.getRequestID());
        if (isSelectedColumnHasCorrectionRequest) {
            officerController.setTitleAndReasonOfCorrectionRequest(this.name_field, this.Correct, selectedColumn.getRequestID());
            name2.setVisible(true);
            name_field.setVisible(true);
            Correct.setVisible(true);
            name3.setVisible(true);
            SEND.setVisible(true);
            t.setVisible(false);
            SendButton.setVisible(true);
        } else {
            officerController.setTitleAndReasonOfCorrectionRequest(this.name_field, this.Correct, selectedColumn.getRequestID());
            name2.setVisible(false);
            name_field.setVisible(false);
            Correct.setVisible(false);
            name3.setVisible(false);
            SEND.setVisible(false);
            t.setVisible(false);
            SendButton.setVisible(false);
            name_field.setText("");
            Correct.setText("");
        }
    }

}
