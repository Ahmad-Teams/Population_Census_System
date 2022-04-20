/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Officer;

import Admin.Admin_OfficerList;
import java.util.Set;
import login.Login;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import login.Login;


/**
 *
 * @author user
 */
public class OfficerGUI extends Application {
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

        
        Button view_request = new Button("View New\n" +
"Requests");
        Button Logout = new Button("Logout");
        
        
        view_request.setMinSize(170, 350);
        view_request.setFont(Font.font("tahoma", FontWeight.BOLD, 17));
     view_request.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent even) {
                Officer_View c2=new Officer_View();
                S1.close();
                c2.start(new Stage());
            }
        });
        
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
               section2.setPrefSize(530, 500);
       
        
        ImageView assitant_Image = new ImageView("Picture1.png");
        assitant_Image.setFitHeight(250);
        assitant_Image.setFitWidth(250);
        
        
        Label word =new Label("welcome in Officerstrator part \n\n click any button to start work");
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
