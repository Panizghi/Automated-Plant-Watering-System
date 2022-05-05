#include <Arduino.h>
#include <U8x8lib.h>
#define MOSFET 2 // The MOSFET driver for the water pump on digital I/O 2
#define REDLED 4 // Big red LED on digital I/O 4
#define BUTTON 6 // Push button on digital I/O 6
#define BUZZER 5 // BUZZER on 5
#define MOISTURE A1
int moistureValue = 0;
#define WET_THRESH 600
auto display = U8X8_SSD1306_128X64_NONAME_HW_I2C(U8X8_PIN_NONE);
const unsigned long time1 = 100;
const unsigned long time2 = 200;
const unsigned long time3 = 1000;


unsigned long passed1 = 0;
unsigned long passed2 = 0;
int flag=0;



void setup() {
 Serial.begin(9600);
 display.begin();
 display.setFlipMode(0);
 display.clearDisplay();
 pinMode(MOSFET, OUTPUT); // Sets the D2 pin (MOSFET + Pump) to output
 pinMode(REDLED, OUTPUT); // Sets the D4 pin (LED) to output
 pinMode(BUTTON, INPUT); // Sets the D6 pin (Button) to input
 pinMode(BUZZER, OUTPUT); // BUZZER

}

void Moisturefunction() {
    
    const auto value = analogRead(MOISTURE);
    const byte data[] = {0, 0, highByte(value), lowByte(value)};

    Serial.write(data, 4);
    Serial.println();  
}

void manualbutton(){

  if (!Serial.available()){
    return;
  }
  const auto receivedData = Serial.read();

 char buf[16];
 sprintf(buf, "%03d", receivedData);

      if (receivedData == 128)
      {
        digitalWrite(MOSFET,HIGH);
      }
      else if (receivedData>=255)
      {
        digitalWrite(REDLED,HIGH);
        analogWrite(BUZZER,HIGH);
      }
      else {
       digitalWrite(MOSFET,LOW);
       digitalWrite(REDLED,LOW);
       analogWrite(BUZZER,LOW);
      }

    }  

void Automaticsystem(){
  if(analogRead(MOISTURE)>WET_THRESH) 
  {
      digitalWrite(MOSFET, HIGH);    // pump on
      digitalWrite(REDLED, HIGH);    // LED on
   } 
   else    
   {
      digitalWrite(MOSFET, LOW);    // pump off
      digitalWrite(REDLED, LOW);    // LED off
   }
}

void loop()
{  
     
  unsigned long currentTime = millis(); 
 if (currentTime - passed1 >= time1){
     Moisturefunction();
     passed1 = currentTime;
 }
 if (Serial.available()){
  unsigned long current= millis();
  flag=1;
  manualbutton();
  if (current-time2>=time3){
    flag=0;
    passed2=current;
  }
 }
 if(flag==0){
   Automaticsystem();
 }

}
