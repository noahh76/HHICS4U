package FXMLControllers;

import DataTypes.Flag;
import DataTypes.MedicalTestResult;
import DataTypes.MedicalTestType;
import static FXMLControllers.MainController.testTypes;
import MainClasses.WarningsAndSuggestionsScreen;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



public class WarningsAndSuggestionsController implements Initializable{
    /* Inject all FXML Components */
    @FXML
    private Button btnBack;

    @FXML
    private Rectangle rectangle1;

    @FXML
    private Rectangle rectangle2;

    @FXML
    private Button btnSearch;

    @FXML
    private Rectangle rectangle3;

    @FXML
    private Rectangle rectangle4;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private TextArea txtSuggestions;

    @FXML
    private Pane mainPane;

    @FXML
    private TextArea txtYellow;
    
    @FXML
    private TextArea txtRed;
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /* When back button is pressed close window */
        btnBack.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                WarningsAndSuggestionsScreen.close();
            }  
        });
       btnSearch.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
            searchArrays();
            
           
       }
    });
       txtYellow.setText("These textboxes will display all medical data that falls into the respecive yellow or red"
               + " zones. Once the search button is pressed, this text will be removed and updated with red/yellow tests. Green tests don't appear!");
    
    
}
    public void searchArrays () {
        for (int x=0; x<MainController.testTypes.size(); x++){
            for (int y=0; y<MainController.testTypes.get(x).getTests().size()-1; y++){
                MedicalTestType type = MainController.testTypes.get(x);
                MedicalTestResult result = MainController.testTypes.get(x).getTests().get(y);
            
                if (result.getScore() <= type.getGreenMaximumScore() && result.getScore() >= type.getGreenMinimumScore()){
                    result.setFlag(Flag.green);
                } else if (result.getScore()<=type.getYellowMaximumScore() && result.getScore()>= type.getYellowMinimumScore()){
                    result.setFlag(Flag.yellow);
                        if (x==0){
                            txtSuggestions.appendText("Due to calcium levels being off, it is reconmended to either reduce/increase dairy intake.");
                            
                        }
                    txtYellow.setText("Yellow Zone: " + testTypes.get(x) +"\n");
                } else {
                    result.setFlag(Flag.red);
                    if (x==0){
                            txtSuggestions.appendText("Due to calcium levels being extreme, see your doctor as cancer is posible.");
                            
                        }
                    txtRed.setText("Red Zone: " +testTypes.get(x) +"\n");
                }
            }
     }
    }
 
}
