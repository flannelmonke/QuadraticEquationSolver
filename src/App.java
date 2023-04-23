import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        TextField a = new TextField();
        TextField b = new TextField();
        TextField c = new TextField();
        TextField resultPos = new TextField();
        TextField resultNeg = new TextField();
        resultPos.setEditable(false);
        resultNeg.setEditable(false);
        Label aLabel = new Label("A Value");
        Label bLabel = new Label("B Value");
        Label cLabel = new Label("C Value");
        Label result1 = new Label("Result 1:");
        Label result2 = new Label("Result 2:");
        Label aTitle = new Label("Quadratic Equation Calculator");
        gridPane.setMargin(a, new Insets(10, 10, 10, 10));
        gridPane.setMargin(b, new Insets(10, 10, 10, 10));
        gridPane.setMargin(c, new Insets(10, 10, 10, 10));
        gridPane.setMargin(resultPos, new Insets(5, 20, 5, 5));
        gridPane.setMargin(resultNeg, new Insets(5, 20, 5, 5));
        

        Button solve = new Button("Solve");
        solve.setOnAction(e -> {
            String aIn = a.getText();
            String bIn = b.getText();
            String cIn = c.getText();
            double aOp = Double.parseDouble(aIn);
            double bOp = Double.parseDouble(bIn);
            double cOp = Double.parseDouble(cIn);
            double discriminant = bOp * bOp - 4 * aOp * cOp;
            double rootPos = 0;
            double rootNeg = 0;
            double specResult = 0;
            if (discriminant < 0) {
                System.out.println("This equation has no real roots");
                resultNeg.setText("This equation has no real roots");
            }else if(aOp== 0 && bOp ==0){
                System.out.println("There is no equation");
                resultPos.setText("There is no equation");
            } 
            else if (aOp == 0) {
                specResult = (cOp/bOp)*-1;
                System.out.println(specResult);
                resultPos.setText(String.valueOf(specResult));
            } else {
                System.out.println("quadratic method");
                rootPos = (-bOp + Math.sqrt(bOp * bOp - 4 * aOp * cOp)) / (2 * aOp);
                rootNeg = (-bOp - Math.sqrt(bOp * bOp - 4 * aOp * cOp)) / (2 * aOp);
                resultPos.setText(String.valueOf(rootPos));
                resultNeg.setText(String.valueOf(rootNeg));
            }
        
        });
        Button clear = new Button("Clear");
        clear.setOnAction(e -> {
            a.clear();
            b.clear();
            c.clear();
            resultPos.clear();
            resultNeg.clear();
        });
        gridPane.addRow(0,aLabel,a);
        gridPane.addRow(1,bLabel,b);
        gridPane.addRow(2,cLabel,c);
        gridPane.addRow(3,result1,resultPos);
        gridPane.addRow(4,result2,resultNeg);
        gridPane.addRow(5,solve,clear);
        GridPane.setHalignment(solve, HPos.RIGHT);
        gridPane.setAlignment(Pos.CENTER);
        // aTitle.setAlignment(Pos.TOP_CENTER);
        BorderPane.setAlignment(aTitle, Pos.TOP_CENTER);
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridPane);
        HBox hbox = new HBox();
        hbox.getChildren().addAll(aTitle);
        borderPane.setTop(hbox);
        Scene scene = new Scene(borderPane, 300, 350);
        primaryStage.setTitle("Quadratic Equation");

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args){   
        launch(args);
    }
}