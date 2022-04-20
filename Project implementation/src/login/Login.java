/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import Admin.AdminGUI;
import Admin.Admin_Add;
import Officer.OfficerGUI;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import User.UserGUI;
/**
 *
 * @author user
 */
public class Login extends Application{
    Stage S1;
    String t;
    @Override
    public void start(Stage primaryStage) {
         //create login title

        GridPane gp = new GridPane();
        ////////////////////////////////////////
        Pane v1=new Pane();
        v1.setPrefSize(400, 700);
        ImageView imgv=new ImageView("members.png");
        imgv.setFitWidth(250);
        imgv.setFitHeight(150);
        imgv.setLayoutY(90);
        imgv.setLayoutX(40);
        Label wel =new Label("Welcome to");
        wel.setLayoutY(220);
        wel.setLayoutX(95);
        wel.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 22));
        wel.setTextFill(Color.WHITE);
        Label l2 =new Label("Population_Census_System -->");
        l2.setLayoutY(248);
        l2.setFont(Font.font("Arial", FontWeight.BOLD, 21));
        l2.setPadding(new Insets(0,0,0,0));
        l2.setLayoutX(4);
        l2.setTextFill(Color.WHITE);
        v1.getChildren().addAll(wel,l2,imgv);
        v1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        v1.setBackground(new Background(new BackgroundFill(Color.web("#2596be"), CornerRadii.EMPTY, Insets.EMPTY)));
        gp.add(v1, 0, 0);
        /////////////////////////////////////////////
        Pane v2=new Pane();
        v2.setPadding(new Insets(0,10,0,30));
        v2.setPrefSize(450, 700);
        ImageView img=new ImageView("240_F_31331324_bqXgqwmlnnXaOeXwFv8CrO6oMHpAKPum.jpg");
        img.setFitWidth(300);
        img.setFitHeight(100);
        img.setLayoutY(40);
        img.setLayoutX(25);
        v2.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.NONE, CornerRadii.EMPTY, new BorderWidths(2))));
        v2.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        /////////////////////////////////////////////
        Label email =new Label("Email");
        email.setLayoutY(150);
        email.setLayoutX(25);
        email.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 17));
        TextField user=new TextField();
        user.setStyle("-fx-background-radius: 30px ;");
        user.setPromptText("Email");
        user.setLayoutY(180);
        user.setLayoutX(25);
        user.setPrefWidth(330);
        
    
        Label pass =new Label("Password");
        pass.setLayoutY(240);
        pass.setLayoutX(25);
        pass.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 17));
        PasswordField P=new PasswordField();
        P.setStyle("-fx-background-radius: 30px ;");
        P.setPromptText("Password");
        P.setLayoutY(270);
        P.setLayoutX(25);
        P.setPrefWidth(330);
        
        Button log=new Button("Login");
        log.setStyle("-fx-background-radius: 300px ;");
        log.setLayoutY(320);
        log.setLayoutX(135);
        log.setPrefWidth(100);
        log.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
        t=user.getText();
      if(t.equals("Admin")){  
      AdminGUI c1=new AdminGUI();
      S1.close();
      c1.start(new Stage());
            }
      else if(t.equals("officer")){
      OfficerGUI c1=new OfficerGUI();
      S1.close();
      c1.start(new Stage());
      }
      else if (t.equals("User")){
      UserGUI c1=new UserGUI();
      S1.close();
      c1.start(new Stage());   
      }
            }});
        v2.getChildren().addAll(email,user,pass,P,log,img);
        gp.add(v2, 1, 0);

        
        Scene scene = new Scene(gp, 700, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Screen");
        primaryStage.setResizable(false);
        primaryStage.show();
        S1=primaryStage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
