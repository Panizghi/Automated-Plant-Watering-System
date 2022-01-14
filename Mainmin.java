package sample;
import javafx.collections.FXCollections;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;




public class Mainmin extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    private final static int MAX_POTENTIOMETER_VALUE = 1 << 10;
    @Override
    public void start(Stage primaryStage) {
        var sp = SerialPortService.getSerialPort("/dev/cu.usbserial-0001");
        var outputStream = sp.getOutputStream();
        var button = new Button("PUMP!");
        var pane = new BorderPane();

        var slider = new Slider();
        slider.setMin(0.0);
        slider.setMax(100.0);

        button.setOnMousePressed(value->{
            try {
                outputStream.write(128);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        button.setOnMouseReleased(value-> {
            try {
                outputStream.write(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        slider.valueProperty().addListener((observableValue, oldValue, newValue)->{
            try{
                outputStream.write(newValue.byteValue());
                if(newValue.byteValue()<50){
                    outputStream.write(255);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        pane.setCenter(slider);
        pane.setPadding(new Insets(0, 20, 0, 20));
        pane.setTop(button);

        var scene = new Scene(pane, 400, 200);

        primaryStage.setScene(scene);
        primaryStage.show();





        }
}








