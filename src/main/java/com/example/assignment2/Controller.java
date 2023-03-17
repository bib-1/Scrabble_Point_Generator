package com.example.assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

public class Controller implements Initializable {

    @FXML
    private TextField txtWord;

    @FXML
    private TextField txtTotal;

    @FXML
    private Button btnSubmit;

    @FXML
    private Button btnB;

    @FXML
    private Label lblB;

    @FXML
    private Button btnU;

    @FXML
    private Label lblU;

    @FXML
    private Button btnT;

    @FXML
    private Label lblT;

    @FXML
    private Button btnS;

    @FXML
    private Label lblS;

    @FXML
    private Button btnR;

    @FXML
    private Label lblR;

    @FXML
    private Button btnQ;

    @FXML
    private Label lblQ;

    @FXML
    private Button btnN;

    @FXML
    private Label lblN;

    @FXML
    private Button btnM;

    @FXML
    private Label lblM;

    @FXML
    private Button btnL;

    @FXML
    private Label lblL;

    @FXML
    private Button btnK;

    @FXML
    private Label lblK;

    @FXML
    private Button btnG;

    @FXML
    private Label lblG;

    @FXML
    private Button btnF;

    @FXML
    private Label lblF;

    @FXML
    private Button btnE;

    @FXML
    private Label lblE;

    @FXML
    private Button btnD;

    @FXML
    private Label lblD;

    @FXML
    private Button btnJ;

    @FXML
    private Label lblJ;

    @FXML
    private Button btnW;

    @FXML
    private Label lblW;

    @FXML
    private Button btnP;

    @FXML
    private Label lblP;

    @FXML
    private Button btnI;

    @FXML
    private Label lblI;

    @FXML
    private Button btnV;

    @FXML
    private Label lblV;

    @FXML
    private Button btnO;

    @FXML
    private Label lblO;

    @FXML
    private Button btnH;

    @FXML
    private Label lblH;

    @FXML
    private Button btnC;

    @FXML
    private Label lblC;

    @FXML
    private Button btnA;

    @FXML
    private Label lblA;

    @FXML
    private Button btnY;

    @FXML
    private Label lblY;

    @FXML
    private Button btnX;

    @FXML
    private Label lblX;

    @FXML
    private Button btnZ;

    @FXML
    private Label lblZ;

    @FXML
    private Label lblErr;

    @FXML
    private Label lblCount;

    @FXML
    private TextArea txtPreviousWords;

    Model m1 = new Model();

    public void showTextValue(){
        lblA.setText(String.valueOf(m1.getAlphaPoints()[0]));
        lblB.setText(String.valueOf(m1.getAlphaPoints()[1]));
        lblC.setText(String.valueOf(m1.getAlphaPoints()[2]));
        lblD.setText(String.valueOf(m1.getAlphaPoints()[3]));
        lblE.setText(String.valueOf(m1.getAlphaPoints()[4]));
        lblF.setText(String.valueOf(m1.getAlphaPoints()[5]));
        lblG.setText(String.valueOf(m1.getAlphaPoints()[6]));
        lblH.setText(String.valueOf(m1.getAlphaPoints()[7]));
        lblI.setText(String.valueOf(m1.getAlphaPoints()[8]));
        lblJ.setText(String.valueOf(m1.getAlphaPoints()[9]));
        lblK.setText(String.valueOf(m1.getAlphaPoints()[10]));
        lblL.setText(String.valueOf(m1.getAlphaPoints()[11]));
        lblM.setText(String.valueOf(m1.getAlphaPoints()[12]));
        lblN.setText(String.valueOf(m1.getAlphaPoints()[13]));
        lblO.setText(String.valueOf(m1.getAlphaPoints()[14]));
        lblP.setText(String.valueOf(m1.getAlphaPoints()[15]));
        lblQ.setText(String.valueOf(m1.getAlphaPoints()[16]));
        lblR.setText(String.valueOf(m1.getAlphaPoints()[17]));
        lblS.setText(String.valueOf(m1.getAlphaPoints()[18]));
        lblT.setText(String.valueOf(m1.getAlphaPoints()[19]));
        lblU.setText(String.valueOf(m1.getAlphaPoints()[20]));
        lblV.setText(String.valueOf(m1.getAlphaPoints()[21]));
        lblW.setText(String.valueOf(m1.getAlphaPoints()[22]));
        lblX.setText(String.valueOf(m1.getAlphaPoints()[23]));
        lblY.setText(String.valueOf(m1.getAlphaPoints()[24]));
        lblZ.setText(String.valueOf(m1.getAlphaPoints()[25]));
    }

    //to check if any btn's count is over
    public void greyOutButtons(){
        System.out.println("1");
       Button[] buttons = {btnA, btnB, btnC, btnD, btnE, btnF, btnG, btnH, btnI, btnJ, btnK, btnL, btnM, btnN, btnO, btnP, btnQ, btnR, btnS, btnT, btnU, btnV, btnW, btnX, btnY, btnZ};
        if(!m1.getWordsToGreyOut().isEmpty()) {
            for (String element : m1.getWordsToGreyOut()) {
                for (Button btn: buttons) {
                    if(btn.toString().substring(13,14).equalsIgnoreCase(element)){
                        btn.setDisable(true);
                    }
                }
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showTextValue();
        lblErr.setVisible(false);
        txtTotal.setText("0");
    }

    //to make the button typeable
    @FXML
    void onClick(ActionEvent event) {
        String letter = event.getSource().toString().substring(13, 14);
        txtWord.setText(txtWord.getText() + letter.toLowerCase());
    }


    @FXML
    void onSubmit(ActionEvent event) {



        String typpedWord = txtWord.getText().trim();

        String errorCheckResult= m1.checkError(typpedWord);

        if(errorCheckResult.equalsIgnoreCase("No error")){

            if(m1.isPointCountable(typpedWord)){
                lblErr.setVisible(false);
                lblCount.setText("The count of "+ typpedWord + " is " + m1.calculateTotalPoint(typpedWord));
                txtTotal.setText(m1.getTotalPoint()); //calculating the total and showing in UX

                m1.setPreviousWords(typpedWord); //adding the typped word in the collection
                txtPreviousWords.setText(m1.getPreviousWords()); //show the text in previous text option
                txtWord.setText(""); //clearing the prompt where the text is typped
                showTextValue();
            }
            else{
                lblErr.setText("Letter(s) in the word is not available in bag");
                lblErr.setVisible(true);
            }


        }
        else
        {
            lblErr.setText(errorCheckResult);
            lblErr.setVisible(true);
        }

        greyOutButtons(); //gray out the buttons with 0 value


        //to denote gameover
        if(m1.checkGameOver()){
            lblErr.setText("Game Over");
            lblErr.setVisible(true);
        }

    }
}
