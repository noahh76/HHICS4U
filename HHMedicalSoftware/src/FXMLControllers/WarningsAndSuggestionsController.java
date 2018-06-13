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
        txtYellow.setText("");
        for (int x=0; x<MainController.testTypes.size(); x++){
            for (int y=0; y<MainController.testTypes.get(x).getTests().size(); y++){
                MedicalTestType type = MainController.testTypes.get(x);
                MedicalTestResult result = MainController.testTypes.get(x).getTests().get(y);
            
                if (result.getScore() <= type.getGreenMaximumScore() && result.getScore() >= type.getGreenMinimumScore()){
                    result.setFlag(Flag.green);
                } else if (result.getScore()<=type.getYellowMaximumScore() && result.getScore()>= type.getYellowMinimumScore()){
                    result.setFlag(Flag.yellow);
                            if (type.getName().equals("Calcium (mg/dL)")){
                                txtSuggestions.appendText("Due to calcium levels being off, it is recommended to either reduce/increase dairy intake. ");
                            } 
                            if (type.getName().equals("Chloride (mEq/L)")){
                                txtSuggestions.appendText("Since chloride levels aren't correct, take another blood test after a few weeks and see if it has improved. ");    
                            }       
                            if (type.equals(2)){
                                txtSuggestions.appendText("Because of hemoglobin being off, iron levels are also impaired. Reduce of increase iron through red meat or supplements. ");    
                            }       
                            if (y==3){
                                txtSuggestions.appendText("Be careful to maintain proper mineral levels since phophorus is slighly off. ");    
                            }       
                            if (y==4){
                                txtSuggestions.appendText("Your platelet count isn't correct, see your doctor since worsening of condition could induce fatal bleeding. ");    
                            }        
                            if (y==5){
                                txtSuggestions.appendText("Potassium levels are bad, be careful that you are recieving all essential minerals. ");    
                            }        
                            if (y==6){
                                txtSuggestions.appendText("Red blood cell levels are not correct. See your doctor as many serious conditions may not be far away. ");    
                            }       
                            if (y==7){
                                txtSuggestions.appendText("Check your diet and eat healthier due to sodium amount in your blood being outside of the green zone. ");    
                            }       
                            if (y==8){
                                txtSuggestions.appendText("Check your diet and eat healthier due to sugar amount in your blood being outside of the green zone. ");    
                            }        
                            if (y==9){
                                txtSuggestions.appendText("White blood cell levels are not correct. See your doctor as many serious conditions may not be far away. ");    
                                    
                                
                        }
                            
                            
                    txtYellow.appendText("Yellow Zone: " + testTypes.get(x) +"\n");
                } else {
                    result.setFlag(Flag.red);
                    if (type.getName().equals("Calcium (mg/dL)")){
                            txtSuggestions.appendText("Due to calcium levels being extreme, see your doctor as cancer is possible. ");
                    }    
                        if (type.getName().equals("Chloride (mEq/L)")){    
                            txtSuggestions.appendText("Since chloride levels are very high/low, hyper/hypo chloremia is possible, contact your doctor. ");
                        } 
                        if (type.getName().equals("Hemoglobin (g/dL)")){
                                txtSuggestions.appendText("Because of hemoglobin being extremely off, iron is also greatly impacted. Anemia is very probable due to this data so see your doctor! ");    
                        }           
                            if (type.getName().equals("Phosphorus (mg/dL)")){
                                txtSuggestions.appendText("A diet plan may be required since phosphorus is dangerously low/high. Contact your healthcare advisor. ");    
                            }       
                            if (type.getName().equals("Platelets (mL)")){
                                txtSuggestions.appendText("Your platelet count is extremely off. Seeing your doctor is mandatory due to the risk of blood not clotting. ");    
                            }        
                            if (type.getName().equals("Potassium (mEq/L)")){
                                txtSuggestions.appendText("A diet plan may be required since potassium is dangerously low/high. Contact your healthcare advisor. ");    
                            }       
                            if (type.getName().equals("RBC (million cmm)")){
                                txtSuggestions.appendText("Red blood cell levels are terribly off, see your doctor many life threatening situations may be looming including anemia or leukemia. ");    
                            }        
                            if (type.getName().equals("Sodium (mEq/L)")){
                                txtSuggestions.appendText("You must change your diet since sodium levels are extremely wrong! Not changing your diet will lead to condition such as heart disease or obesity. ");    
                            }       
                            if (type.getName().equals("Sugar (mg/dL)")){
                                txtSuggestions.appendText("You must change your diet since sugar levels are extremely wrong! Not changing your diet will lead to condition such as diabetes or obesity. ");    
                            }      
                            if (type.getName().equals("WBC (per ccm)")){
                                txtSuggestions.appendText("White blood cell levels are terribly off. See your doctor many life threatening situations may be looming, such as leukemia. ");    
                                    
                            }         
                    txtRed.appendText("Red Zone: " +testTypes.get(x) +"\n");
                
                           
                //Moved all } from between ifs to the end.... worked for yellow but not for red, suggestions still off....   
            }
     }
    }
    }
 
}
