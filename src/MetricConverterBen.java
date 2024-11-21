//Ben Braniff
//Unit conversion to metric

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
//import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class MetricConverterBen extends Application {
    private TextField meterIn = new TextField();
    private TextField feetOut = new TextField();
    //private Button convertBut = new Button("Calculate that");
    private TextField anyUnitIn = new TextField();
    private TextField meterOut = new TextField();
    private Button convert2 = new Button("Convert");
    

    ObservableList<String> options = FXCollections.observableArrayList("feet", "inches", "miles");
    ComboBox<String> cmb = new ComboBox<String>(options);

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        
        
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        
        /* 
        [label: meters:] [meterIn]
        [label: feet:]   [feetOut]
        []               [convertBut]
        */
        // gridPane.add(new Label("meters:"), 0, 0);
        // gridPane.add(meterIn, 1, 0);
        // gridPane.add(new Label("feet:"), 0, 1);
        // gridPane.add(feetOut, 1, 1);
        // gridPane.add(convertBut, 1, 2);
        
        /*
        [dropDown:]      [anyUnitIn]
        [label: meters]  [meterOut]
        []               [convert2]
        */
        gridPane.add(cmb, 0, 0);
        gridPane.add(anyUnitIn, 1, 0);
        gridPane.add(new Label("meters:"), 0, 1);
        gridPane.add(meterOut, 1, 1);
        gridPane.add(convert2, 1, 2);

        gridPane.setAlignment(Pos.CENTER);
        
        feetOut.setEditable(false);
        meterOut.setEditable(false);

        //convertBut.setOnAction(e -> calculateTheConversion());
        convert2.setOnAction(e -> convertWithDropdown());

        Scene scene = new Scene(gridPane, 400, 250);
        primaryStage.setTitle("Ben's MetricConverter");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    private void calculateTheConversion() {
        double metricNum = Double.parseDouble(meterIn.getText());
        double feetNum = metricNum * (3.28084);
        String feetString = String.valueOf(feetNum);
        feetOut.setText(feetString);
    }

    private void convertWithDropdown() {
        String dropDownUnit = cmb.getValue();
        if(dropDownUnit == "miles") {
            double Unit = Double.parseDouble(anyUnitIn.getText());
            double meter = Unit * 1609.34;
            String meterString = String.valueOf(meter);
            meterOut.setText(meterString);
        }
        else if(dropDownUnit == "inches") {
            double Unit = Double.parseDouble(anyUnitIn.getText());
            double meter = Unit * 0.0254;
            String meterString = String.valueOf(meter);
            meterOut.setText(meterString);
        }
        //else assume its feet
        else {
            double Unit = Double.parseDouble(anyUnitIn.getText());
            double meter = Unit * 0.3048;
            String meterString = String.valueOf(meter);
            meterOut.setText(meterString);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}