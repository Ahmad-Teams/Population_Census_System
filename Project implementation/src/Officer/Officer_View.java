/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Officer;

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
import login.Login;
import project.Officer;

/**
 *
 * @author user
 */
public class Officer_View extends Application {
    Stage S1;
    Officer officer;
    TableView table=new TableView();
    Text t=new Text();
    public Officer_View() {
    }

    public Officer_View(Officer officer) {
        this.officer = officer;
    }
    @Override
    public void start(Stage stage) {
        GridPane all = new GridPane();
        all.setHgap(10);
        
// side btn section
        
        VBox section1 = new VBox();       
        section1.setPrefSize(170, 500);

        
        Button view_request = new Button("View New\n" +
"Requests");
        Button Logout = new Button("Logout");
        
        
        view_request.setMinSize(170, 350);
        view_request.setFont(Font.font("tahoma", FontWeight.BOLD, 17));
     
        Logout.setMinSize(170, 350);
        Logout.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.web("#bf1f21"), CornerRadii.EMPTY, Insets.EMPTY)));
        Logout.setBorder(new Border(new BorderStroke((javafx.scene.paint.Color.web("#79b5d9")), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        Logout.setFont(Font.font("tahoma", FontWeight.BOLD, 17));
       Logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                Login c2=new Login();
                S1.close();
                c2.start(new Stage());
            }
        });

        
        section1.getChildren().addAll(view_request,Logout);
        
        //////////////////////////////////////
        VBox section2 = new VBox(6);
        section2.setPrefSize(530, 500);
        Label H=new Label("New Requests");
        H.setFont(Font.font("Garamond", FontWeight.BOLD, 30));
        H.setPadding(new Insets(5, 0, 0, 180));
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
        //////////////////////////////////////////////////////////////////////////////////
        TextArea Correct=new TextArea();
        //Correct.setStyle("-fx-background-radius: 30px ;");
        Correct.setPromptText("Message");
        Correct.setMaxHeight(220);
        Correct.setMaxWidth(520);
        Correct.setWrapText(true);
        Correct.setVisible(false);
        ///////////////////////////////////////////////////////////////////////////////////////
        VBox SEND=new VBox(10);
        Button S=new Button("Send");
        S.setFont(Font.font("tahoma", FontWeight.LIGHT, 16));
        S.setTextFill(javafx.scene.paint.Color.BLACK);
        S.setStyle("-fx-background-radius: 300px ;");
        S.setMinWidth(120);
        S.setOnAction(new EventHandler<ActionEvent>() {
        @Override
         public void handle(ActionEvent even) {
             Correct.setVisible(false);
             S.setVisible(false);
               t.setVisible(true);
               t.setText("Message has been sent");
               t.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20));
               SEND.setPadding(new Insets(0, 0, 0, 160));
         }
      });
        SEND.setPadding(new Insets(0, 0, 0, 200));
        SEND.getChildren().addAll(t,S);
        SEND.setVisible(false);
        //////////////////////////////////////////////////////////////
        HBox B=new HBox(100);
        B.setPadding(new Insets(10, 0, 10, 80));
        Button R=new Button("Reject");
        Button A=new Button("Accept");
        R.setStyle("-fx-background-radius: 300px ;-fx-background-color:Red; ");
        A.setStyle("-fx-background-radius: 300px ;-fx-background-color:Orange;");
        R.setMinWidth(120);
        A.setMinWidth(120);
        R.setFont(Font.font("tahoma", FontWeight.LIGHT, 17));
        R.setTextFill(javafx.scene.paint.Color.BLACK);
        A.setFont(Font.font("tahoma", FontWeight.LIGHT, 17));
        A.setTextFill(javafx.scene.paint.Color.BLACK);
        R.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                Correct.setVisible(true);
                SEND.setVisible(true);
                t.setVisible(false);
                S.setVisible(true);
                SEND.setPadding(new Insets(0, 0, 0, 200));
            }
        });
        B.getChildren().addAll(A,R);
        section2.getChildren().addAll(H,scrollPane,B,Correct ,  SEND);
        //////////////////////////////////////
        all.add(section1, 0, 0);
        all.add(section2, 1, 0);
        all.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.web("#a5cee5"), CornerRadii.EMPTY, Insets.EMPTY)));

        
        Scene scene = new Scene(all,700,700);           
        stage.setScene(scene);
        stage.setTitle("Officer Screen");
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
