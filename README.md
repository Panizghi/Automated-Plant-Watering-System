# Automated-Watering-system-for-plants
### INTRODUCTION:

In this project, It has been tried to build an automated/manual watering plant system by using Java programming language and Arduino UNO compatible board. By detecting the moisture level of soil and sending data to java the project is able to graph the moisture level vs time, Arduino water the plant if the soil is dry, and use the java button to manually water the plant. Moreover, the project can demonstrate live moisture level vs time graph and turn on and off the buzzer and LED based on the slider that has been made in Java.

### CONTEXT:

In this program, the combination of Arduino and Java has been used. The reason behind this selection is the ability to send and receive data between two programming platforms. While Arduino acts as the main receiver in the automated and manual parts of the project. In graphing part, it turned out to be a data sender where java uses this data to graph the function. Both Arduino and Java are the main pieces of this project which held the design output desirable. The bridge of connection between java and Arduino is the computer Serial port which either sends data from Arduino to java or vice versa. This serial port connection is the main key to the success of the project since the main aim is communication between java and Arduino which could use data in a sufficient pathway.

### TECHNICAL REQUIREMENTS / SPECIFICATIONS:

- The system is able to detect the moisture level of the soil and water the plant automatically.

By having the wet threshold if the analog read of the moisture sensor is high- the soil is dry- and the pump would be turned by the code in Arduino on otherwise, the pump remains off.

- The system can work manually with buttons implemented in java

Since the system is not able to receive data from two sources at the same time for some time interval the system can use the byte data sent from java to turn the pump on and off manually.

- The system is able to show a live graph of moisture level

Java graph the live moisture level of the sensor by receiving data from Arduino

- The system is able to turn the LED and buzzer on and off with the slider implemented in java.

By sending a specific byte value range from java to Arduino the LED and buzzer turn on and off proportional to the slide movement.

Most of the java part is based on the specifications that when the button on JavaFX is pressed sends a specific byte value to Arduino and when the Arduino receives this specific byte go through a conditional statement and does what it need suppose to do. The slider also has been set within the range of 1-100 which again makes a condition in java that if it is more than 50 send a particular byte value and go through else if the condition that has been made for the button.

### COMPONENTS LIST:

Physical components:

- Battery Pack
- MOSFET
- Arduino Grove Board
- wire
- 5v Pump
- Tube
- Water and container
- Plant
- Moisture sensor

Software components:

- IntellijIDEA
- Arduino

### PROCEDURE:

1) Setting up the physical components :

- Connecting the MOSFET to the battery pack and the pump
- connecting the pump to D2 and swapping the moisture sensor wire input and connecting it to A1.
- Connect the board to the computer and place the moisture sensor in the soil and water pump in the water container.

2) Software

- Arduino: Setting up the void setup for each sensor, serial begin, etc.
    - creating three void setups for three conditions that we have ( Live graph Manual button/slider and automated system. The automated system does not depend on java data.
    - I added specifications of the slider to the manual part void function as a range so the buzzer and led turn on-off based on the data received from java.
    - Creating the loop in java by using time intervals allows Arduino to receive data from java and then analog read based on the time interval conditions. Flagging plays an important role since if Arduino receives data from java without having a flag it would ignore the rest of the code.
- Java files include :
    - Main class:
        - Including the code for the slider button and the byte that will send if the mouse is pressed or released the JavaFX, and the stage of the button and slider.
    - SerialPortService:
        - Make the bridge between Arduino and Java and allow java to send data (byte) to Arduino.
    - MYGRAPH class :
        - Graph specifications such as title variable size of the window, y, and x-axis labels, etc.
    - Data controller class:
        - The class that makes the connection between java and Arduino and allows java to receive data from Arduino (used in the graph of the moisture sensor value).
- I imported the VM to the JavaFX so I would be able to demonstrate the button slider and the graph and important library for connection of the serial port from maven and library of java SDK 14. Finally, by putting all these components together the system starts to work!

Refrences :

James Andrew Smith • Associate professor
  Department of Electrical Engineering and Computer Science
	Lassonde School of Engineering

Eric Prandovszky • Laboratory Technologist
	Department of Electrical Engineering and Computer Science
	Lassonde School of Engineering
