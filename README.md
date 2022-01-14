# Automated-Watering-system-for-plants
In this program, the combination of Arduino and Java has been used. The reason behind this
selection is the ability to send and receive data between two programming platforms. While
Arduino acts as the main receiver in the automated and manual part of the project. In graphing
part, it turned to be a data sender where java uses this data to graph the function. Both Arduino
and Java are the main pieces of this project which held the design output desirable. The bridge of
connection between java and Arduino is the computer Serial port which either sends data from
Arduino to java or vice versa. This serial port connection is the main key to the success of the
project since the main aim is communication between java and Arduino which could use data in
a sufficient pathway.

1) Setting up the physical components :
• Connecting the MOSFET to the battery pack and the pump
• connecting the pump to D2 and swapping the moisture sensor wire input and connect it to A1.
• Connecting the board to the computer and place the moisture sensor in the soil and water pump in the water container.
2) Software
Arduino: Setting up the void setup for each sensor, serial begin, etc.
i) creating three void setups for three conditions that we have ( Live graph Manual button/slider
and automated system. The automated system does not depend on java data.
I added specifications of the slider to the manual part void function as a range so the buzzer and
led turn on-off based on the data received from java.
ii) Creating the loop in java by using time intervals allows Arduino to receive data from java and
then analog read based on the time interval conditions. Flagging plays an important role since if
Arduino receives data from java without having a flag it would ignore the rest of the code.
iii) Java files include :
Main class:
Including the code for slider button and the byte that will send if the mouse is pressed or
released the JavaFX, and stage of button and slider.
SerialPortService:
make the bridge between Arduino and Java and allow java to send data (byte) to Arduino.
MYGRAPH class :
Graph specifications such as title variable size of the window, y, and x-axis labels, etc.
data controller class:
the class that makes the connection between java and Arduino and allows java to receive
data from Arduino ( uses in the graph of the moisture sensor value).
