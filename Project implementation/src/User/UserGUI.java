/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Officer.Officer_View;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import login.Login;

/**
 *
 * @author user
 */
public class UserGUI extends Application {
     Stage S1;
    TableView table=new TableView();
    Text t=new Text();;
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

        
        //////////////////////////////////////
        VBox section2 = new VBox(6);
        section2.setPrefSize(530, 500);
               section2.setPrefSize(530, 500);
       
        
        ImageView assitant_Image = new ImageView("famil.png");
        assitant_Image.setFitHeight(250);
        assitant_Image.setFitWidth(250);
        
        
        Label word =new Label("welcome in User part click \n\n any button to start work");
        word.setFont(Font.font("Garamond", FontWeight.BOLD, 30));
        word.setTextFill(javafx.scene.paint.Color.BLACK);
        word.setPadding(new Insets(20));
        
        section2.getChildren().addAll(assitant_Image,word);
        section2.setAlignment(Pos.CENTER);
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
