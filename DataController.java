//import fazecast for serial port conncetion packges including the rest of the classes and javafx for the graph visuals
package sample;
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortEvent;
import com.fazecast.jSerialComm.SerialPortMessageListenerWithExceptions;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

import java.nio.ByteBuffer;

//public classes for lsitening to data and override elemts to override the element in superclass

public class DataController implements SerialPortMessageListenerWithExceptions {
    private static final byte[] DELIMITER = new byte[]{'\n'};
    private final ObservableList<XYChart.Data<Number, Number>> dataPoints;

    public DataController() {
        this.dataPoints = FXCollections.observableArrayList();
    }

    public ObservableList<XYChart.Data<Number, Number>> getDataPoints() {
        return dataPoints;
    }

    @Override
    public int getListeningEvents() {
        return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
    }

    @Override
    public void serialEvent(SerialPortEvent serialPortEvent) {
        if (serialPortEvent.getEventType() != SerialPort.LISTENING_EVENT_DATA_RECEIVED){
            return;
        }
        var data = serialPortEvent.getReceivedData();
        var value = ByteBuffer.wrap(data).getInt();
        var time = System.currentTimeMillis();
        var dataPoints = new XYChart.Data<Number,Number>(time,value);
        Platform.runLater(() -> this.dataPoints.add(dataPoints));
    }

    @Override
    public void catchException(Exception e) {
        e.printStackTrace();
    }

    @Override
    public byte[] getMessageDelimiter() {
        return DELIMITER;
    }

    @Override
    public boolean delimiterIndicatesEndOfMessage() {
        return true;
    }
}


