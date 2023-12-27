/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jjonestheatrerevenue;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Jacob Jones
 * This program accepts four variables, two which get the amount of tickets sold, and the others obtain the price for each variable.
 * The parameters are split into two groups, one for adults and one for children.
 * The program will then calculate the gross and net revenues for adult and child tickets, then calculates the total gross and net revenue.
 */
public class JJonesTheatreRevenue extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        final double theatreRate = 0.2; //The percent of revenue the theatre keeps.
        
        //Sets up the size multipliers
        final double widthMult2 = 1.175;
        final double widthMult3 = 1.35;
        final double heightMult2 = 1.13;
        final double heightMult3 = 1.26;
        
        //Sets up the default window and field sizes
        final int windowWidth = 485;
        final int windowHeight = 355;
        final int fieldWidth = 75;
        final int fieldHeight = 10;
        
        //Font Sizes
        final Font fontSize1 = new Font(14);
        final Font fontSize2 = new Font(18);
        final Font fontSize3 = new Font(22);
        
        GridPane layout = new GridPane(); //This will group together all of the different labels and fields
        layout.setPadding(new Insets(10)); //Keeps the UI from being right next to the edges
        layout.setGridLinesVisible(true); //Makes the application look nice
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout, windowWidth, windowHeight); //Sets up the scene
        
        //Sets up the appearance of the window
        primaryStage.setResizable(false); //Makes spacing out the program easier
        primaryStage.setWidth(windowWidth); //Sets the initial width
        primaryStage.setHeight(windowHeight); //Sets the height
        primaryStage.setTitle("Theatre Revenue Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();

        //Sets up the labels and fields related to the adult tickets
        Label adultPriceLabel = new Label("Adult Ticket Price:"); 
        adultPriceLabel.setPadding(new Insets(10));
        TextField adultPriceField = new TextField();
        adultPriceField.setAlignment(Pos.CENTER);
        adultPriceField.setMaxSize(fieldWidth, fieldHeight);
        Label adultSoldLabel = new Label("Adult Tickets Sold:");
        adultSoldLabel.setPadding(new Insets(10));
        TextField adultSoldField = new TextField();
        adultSoldField.setAlignment(Pos.CENTER);
        adultSoldField.setMaxSize(fieldWidth, fieldHeight);
        
        //Sets up the labels and fields related to the child tickets
        Label childPriceLabel = new Label("Child Ticket Price:");
        childPriceLabel.setPadding(new Insets(10));
        TextField childPriceField = new TextField();
        childPriceField.setAlignment(Pos.CENTER);
        childPriceField.setMaxSize(fieldWidth, fieldHeight);
        Label childSoldLabel = new Label("Child Tickets Sold:");
        childSoldLabel.setPadding(new Insets(10));
        TextField childSoldField = new TextField();
        childSoldField.setMaxSize(fieldWidth, fieldHeight);
        childSoldField.setAlignment(Pos.CENTER);
        
        //Sets up the revenue information related to the adult tickets
        Label adultGrossLabel = new Label("Adult Ticket Gross Revenue:");
        adultGrossLabel.setPadding(new Insets(10));
        Label adultGrossNum = new Label("");
        adultGrossNum.setPadding(new Insets(10));
        Label adultNetLabel = new Label("Adult Ticket Net Revenue:");
        adultNetLabel.setPadding(new Insets(10));
        Label adultNetNum = new Label("");
        adultNetNum.setPadding(new Insets(10));
        
        //Sets up the revenue information related to the child tickets
        Label childGrossLabel = new Label("Child Ticket Gross Revenue:");
        childGrossLabel.setPadding(new Insets(10));
        Label childGrossNum = new Label("");
        childGrossNum.setPadding(new Insets(10));
        Label childNetLabel = new Label("Child Ticket Net Revenue:");
        childNetLabel.setPadding(new Insets(10));
        Label childNetNum = new Label("");
        childNetNum.setPadding(new Insets(10));
        
        //Sets up the total revenue information
        Label totalGrossLabel = new Label("Total Gross Revenue:");
        totalGrossLabel.setPadding(new Insets(10));
        Label totalGrossNum = new Label("");
        totalGrossNum.setPadding(new Insets(10));
        Label totalNetLabel = new Label("Total Net Revenue:");
        totalNetLabel.setPadding(new Insets(10));
        Label totalNetNum = new Label("");
        totalNetNum.setPadding(new Insets(10));
        
        //Combines each column into their own VBox. Keeps all of the contents horizontally aligned.
        VBox firstCol = new VBox(adultPriceLabel, adultSoldLabel, childPriceLabel, childSoldLabel, totalGrossLabel);
        VBox secondCol = new VBox(10, adultPriceField, adultSoldField, childPriceField, childSoldField, totalGrossNum);
        secondCol.setPadding(new Insets(10));
        secondCol.setAlignment(Pos.CENTER);
        VBox thirdCol = new VBox(adultGrossLabel, adultNetLabel, childGrossLabel, childNetLabel, totalNetLabel);
        VBox fourthCol = new VBox(adultGrossNum, adultNetNum, childGrossNum, childNetNum, totalNetNum);

        //Combines all of the VBoxes into one HBox. Done to center the button underneath.
        HBox information = new HBox(firstCol, secondCol, thirdCol, fourthCol);
        layout.add(information, 0,0);
        
        //Sets up the labels and fields' sizes since I want them to be a bit bigger
        setLabelSize(fontSize1, adultPriceLabel, adultSoldLabel, childPriceLabel, childSoldLabel, totalGrossLabel, 
            adultGrossLabel, adultNetLabel, childGrossLabel, childNetLabel, totalNetLabel, 
            adultGrossLabel, adultNetLabel, childGrossLabel, childNetLabel, totalNetLabel, 
            totalGrossLabel, totalGrossNum, totalNetLabel, totalNetNum,
            adultGrossNum, adultNetNum, childGrossNum, childNetNum, totalNetNum);

        setFieldSize(fontSize1, fieldWidth, fieldHeight, adultPriceField, adultSoldField, childPriceField, childSoldField);

        //Sets up the calculation button
        Button calcButton = new Button();
        calcButton.setText("Calculate");
        calcButton.setOnAction(new EventHandler<ActionEvent>() { //Calculates the revenue
            @Override
            public void handle(ActionEvent event) {
                
                //Sets up the adult and child ticket information
                double adultPrice = 0;
                int adultSold = 0;
                double childPrice = 0;
                int childSold = 0;
                
                //Collects the numbers from the fields, assigning them to the variables if they are not empty and are above 0
                if(!adultPriceField.getText().isEmpty() && adultPriceField.getText().matches("^[0-9]*$") && Double.parseDouble(adultPriceField.getText()) > 0){
                    adultPrice = Double.parseDouble(adultPriceField.getText());
                }
                if(!adultSoldField.getText().isEmpty() && adultSoldField.getText().matches("^[0-9]*$") && Integer.parseInt(adultSoldField.getText()) > 0){
                    adultSold = Integer.parseInt(adultSoldField.getText());
                }
                if(!childPriceField.getText().isEmpty() && childPriceField.getText().matches("^[0-9]*$") && Double.parseDouble(childPriceField.getText()) > 0){
                    childPrice = Double.parseDouble(childPriceField.getText());
                }
                if(!childPriceField.getText().isEmpty() && childPriceField.getText().matches("^[0-9]*$") && Double.parseDouble(childPriceField.getText()) > 0){
                    childSold = Integer.parseInt(childSoldField.getText());
                }
                
                //Calculates and combines the adult and child gross and net revenues.
                double adultGrossRevenue = adultPrice * adultSold;
                double adultNetRevenue = adultGrossRevenue * theatreRate;
                double childGrossRevenue = childPrice * childSold;
                double childNetRevenue = childGrossRevenue * theatreRate;
                double totalGross = adultGrossRevenue + childGrossRevenue;
                double totalNet = adultNetRevenue + childNetRevenue;
                
                //Puts the variables above into the blank labels
                adultGrossNum.setText(String.format("$ %.2f", adultGrossRevenue));
                adultNetNum.setText(String.format("$ %.2f", adultNetRevenue));
                childGrossNum.setText(String.format("$ %.2f", childGrossRevenue));
                childNetNum.setText(String.format("$ %.2f", childNetRevenue));
                totalGrossNum.setText(String.format("$ %.2f", totalGross));
                totalNetNum.setText(String.format("$ %.2f", totalNet));
                
                //Checks which size the window is
                if(totalGrossNum.getFont().getSize() == fontSize3.getSize()){
                    primaryStage.setWidth(widthMult3 * (windowWidth + 45 + (fontSize3.getSize() - 5) * digitCheck(totalGrossNum)));
                }else if(totalGrossNum.getFont().getSize() == fontSize2.getSize()){
                    primaryStage.setWidth(widthMult2 * (windowWidth + 40 + (fontSize2.getSize() - 5) * digitCheck(totalGrossNum)));
                } else{
                    primaryStage.setWidth(windowWidth + 35 + (fontSize1.getSize() - 7) * digitCheck(totalGrossNum));
                }
                
                //Disables the fields
                //Mainly done to see what I could do with them
                adultPriceField.setDisable(true);
                adultSoldField.setDisable(true);
                childPriceField.setDisable(true);
                childSoldField.setDisable(true);
            }
        });
        
        //Sets up the reset button
        Button resetButton = new Button();
        resetButton.setText("Reset");
        resetButton.setOnAction(new EventHandler<ActionEvent>() { //Resets the fields
            @Override
            public void handle(ActionEvent event) {
                //Clears the gross/net labels
                adultGrossNum.setText("");
                adultNetNum.setText("");
                childGrossNum.setText("");
                childNetNum.setText("");
                totalGrossNum.setText("");
                totalNetNum.setText("");
                
                //Clears the text fields
                adultPriceField.clear();
                adultSoldField.clear();
                childPriceField.clear();
                childSoldField.clear();
                
                //Reenables the fields
                adultPriceField.setDisable(false);
                adultSoldField.setDisable(false);
                childPriceField.setDisable(false);
                childSoldField.setDisable(false);
                
                //Checks which size the window is
                if(totalGrossNum.getFont().getSize() == fontSize3.getSize()){
                    primaryStage.setWidth(widthMult3 * windowWidth);
                }else if(totalGrossNum.getFont().getSize() == fontSize2.getSize()){
                    primaryStage.setWidth(widthMult2 * windowWidth);
                } else{
                    primaryStage.setWidth(windowWidth);
                }
            }
        });
        
        HBox buttonRow = new HBox(10, calcButton, resetButton);
        buttonRow.setAlignment(Pos.CENTER); //Centers the buttons
        buttonRow.setPadding(new Insets(10));
        layout.add(buttonRow, 0, 1);
        
        //Sets up the first size button
        Button sizeButton1 = new Button();
        sizeButton1.setText("Size 1");
        sizeButton1.setOnAction(new EventHandler<ActionEvent>() { //Resets the fields
        @Override
        public void handle(ActionEvent event) {
            //Checks to see if there is content in the (most likely) largest field.
            //If there is, then it performs the digit check done in the calculate button.
            if(totalGrossNum.getText().isEmpty()){
                primaryStage.setWidth(windowWidth);
            } else{
                primaryStage.setWidth(windowWidth + 35 + (fontSize1.getSize() - 7) * digitCheck(totalGrossNum));
            }
            
            primaryStage.setHeight(windowHeight);

            //Sets the text to normal size
            setLabelSize(fontSize1, adultPriceLabel, adultSoldLabel, childPriceLabel, childSoldLabel, totalGrossLabel, 
                adultGrossLabel, adultNetLabel, childGrossLabel, childNetLabel, totalNetLabel, 
                adultGrossLabel, adultNetLabel, childGrossLabel, childNetLabel, totalNetLabel, 
                totalGrossLabel, totalGrossNum, totalNetLabel, totalNetNum,
                adultGrossNum, adultNetNum, childGrossNum, childNetNum, totalNetNum);

            setFieldSize(fontSize1, fieldWidth, fieldHeight, adultPriceField, adultSoldField, childPriceField, childSoldField);
        }
        });
        
        //Sets up the second size button
        Button sizeButton2 = new Button();
        sizeButton2.setText("Size 2");
        sizeButton2.setOnAction(new EventHandler<ActionEvent>() { //Resets the fields
        @Override
        public void handle(ActionEvent event) {
            if(adultNetNum.getText().isEmpty()){
                primaryStage.setWidth(windowWidth * widthMult2);
            } else{
                primaryStage.setWidth(widthMult2 * (windowWidth + 40 + (fontSize2.getSize() - 5) * digitCheck(totalGrossNum)));
            }
            
            primaryStage.setHeight(heightMult2 * windowHeight);

             //Sets the text to double size
            setLabelSize(fontSize2, adultPriceLabel, adultSoldLabel, childPriceLabel, childSoldLabel, totalGrossLabel, 
                adultGrossLabel, adultNetLabel, childGrossLabel, childNetLabel, totalNetLabel, 
                adultGrossLabel, adultNetLabel, childGrossLabel, childNetLabel,
                totalNetLabel, totalGrossLabel, totalGrossNum, totalNetLabel, totalNetNum,
                adultGrossNum, adultNetNum, childGrossNum, childNetNum, totalNetNum);

            setFieldSize(fontSize2, fieldWidth, fieldHeight, adultPriceField, adultSoldField, childPriceField, childSoldField);
            
        }
        });
        
        //Sets up the second size button
        Button sizeButton3 = new Button();
        sizeButton3.setText("Size 3");
        sizeButton3.setOnAction(new EventHandler<ActionEvent>() { //Resets the fields
        @Override
        public void handle(ActionEvent event) {
            if(adultNetNum.getText().isEmpty()){
                primaryStage.setWidth(windowWidth * widthMult3);
            } else{
                primaryStage.setWidth(widthMult3 * (windowWidth + 45 + (fontSize3.getSize() - 5) * digitCheck(totalGrossNum)));
            }
            
            primaryStage.setHeight(heightMult3 * windowHeight);

             //Sets the text to double size
            setLabelSize(fontSize3, adultPriceLabel, adultSoldLabel, childPriceLabel, childSoldLabel, totalGrossLabel, 
                adultGrossLabel, adultNetLabel, childGrossLabel, childNetLabel, totalNetLabel, 
                adultGrossLabel, adultNetLabel, childGrossLabel, childNetLabel,
                totalNetLabel, totalGrossLabel, totalGrossNum, totalNetLabel, totalNetNum,
                adultGrossNum, adultNetNum, childGrossNum, childNetNum, totalNetNum);

            setFieldSize(fontSize3, fieldWidth, fieldHeight, adultPriceField, adultSoldField, childPriceField, childSoldField);
        }
        });
        
        HBox sizeRow = new HBox(10, sizeButton1, sizeButton2, sizeButton3);
        sizeRow.setAlignment(Pos.CENTER); //Centers the buttons
        sizeRow.setPadding(new Insets(10));
        layout.add(sizeRow, 0, 2);
    }
    
    /**
    *   This method sets the size of the labels according to the parameters
    *   @param fontSize - The desired font size
    *   @param labels - A vararg (variable argument) that represents all Labels.
    * 
    *   Note: Found out about varargs from research
    */
    private void setLabelSize(Font fontSize, Label... labels) {
        for (Label label : labels) {
            label.setFont(fontSize);
        }
    }
    
    /**
    *   This method sets the size of the fields according to the parameters
    *   @param fontSize - The desired font size
    *   @param fieldWidth - The desired field width
    *   @param fieldHeight - The desired field height
    *   @param fields - A vararg (variable argument) that represents all Labels.
    * 
    *   Note: Found out about varargs from research
    */
    private void setFieldSize(Font fontSize, int fieldWidth, int fieldHeight, TextField... fields) {
        for (TextField field : fields) {
            field.setMaxSize(fieldWidth, fieldHeight);
            field.setFont(fontSize);
        }
    }
    
    /**
    *   This method checks to see how many integral digits are in a number.
    *   @param testNum - The label/number the method is checking
    */
    private int digitCheck(Label testNum) {
        short digits = 0;
        double totalGross = Double.parseDouble(testNum.getText().substring(2)); //Checks a substring to get rid of the dollar sign.
        while(totalGross > 9){
            totalGross /= 10;
            digits++;
        }
        return digits;
    }
}
