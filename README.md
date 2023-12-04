# Automated Watering System for Plants

## Introduction

This project aims to create an automated/manual watering system for plants using the Java programming language and an Arduino UNO compatible board. By detecting soil moisture levels, the system can graph moisture levels vs. time, automatically water the plant when the soil is dry, and allow manual watering through a Java interface. The project also features a live moisture level vs. time graph and the ability to control a buzzer and LED based on a Java slider.

## Context

The project utilizes a combination of Arduino and Java for their ability to exchange data seamlessly. Arduino serves as the main receiver for both automated and manual watering, while Java is responsible for graphing and user interface controls. The communication between Arduino and Java is facilitated through the computer's serial port.

## Technical Requirements / Specifications

- **Automated Watering:** The system detects soil moisture levels and waters the plant automatically.
- **Manual Operation:** Manual watering is possible through buttons implemented in Java.
- **Live Graphing:** The system graphs live moisture levels using data received from Arduino.
- **LED and Buzzer Control:** A slider in Java controls the on/off state of the LED and buzzer.

## Components List

**Physical Components:**
- Battery Pack
- MOSFET
- Arduino Grove Board
- Wires
- 5V Pump
- Tube
- Water Container
- Plant
- Moisture Sensor

**Software Components:**
- IntellijIDEA
- Arduino IDE

## Procedure

### Setting up the Physical Components

1. Connect MOSFET to the battery pack and the pump.
2. Connect the pump to D2 and swap the moisture sensor wire input, connecting it to A1.
3. Connect the board to the computer and place the moisture sensor in the soil, with the water pump in the water container.

### Software

#### Arduino

- Set up void setups for each sensor, serial begin, etc.
- Create void setups for live graphing, manual button/slider, and the automated system.
- Implement specifications for the slider in the manual part void function to control the buzzer and LED based on data received from Java.
- Create a loop in Java with time intervals for Arduino to receive data and perform analog reads based on the time interval conditions.

#### Java

- **Main Class:**
  - Code for the slider button, byte sent on mouse press/release, JavaFX stage, and slider.
- **SerialPortService:**
  - Bridge between Arduino and Java, enabling Java to send data (byte) to Arduino.
- **MYGRAPH Class:**
  - Graph specifications such as title, window size, y and x-axis labels, etc.
- **Data Controller Class:**
  - Establishes the connection between Java and Arduino, allowing Java to receive data from Arduino.

Import VM to JavaFX, use important libraries for serial port connection, and compile all components to make the system operational.

## References

- James Andrew Smith, Associate Professor, Department of Electrical Engineering and Computer Science, Lassonde School of Engineering.
- Eric Prandovszky, Laboratory Technologist, Department of Electrical Engineering and Computer Science, Lassonde School of Engineering.
