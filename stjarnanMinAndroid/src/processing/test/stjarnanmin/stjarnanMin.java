package processing.test.stjarnanmin;

import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import ketai.camera.*; 
import ketai.net.nfc.record.*; 
import ketai.net.*; 
import ketai.ui.*; 
import ketai.cv.facedetector.*; 
import ketai.sensors.*; 
import ketai.net.nfc.*; 
import ketai.net.wifidirect.*; 
import ketai.data.*; 
import ketai.net.bluetooth.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class stjarnanMin extends PApplet {












// Stjarnan m\u00edn
// By Le\u00f3 Stef\u00e1nsson
// for N\u00edna Hei\u00f0r\u00f3s
String[] starBase;

public void setup() {
 
  background(0);
  starBase = loadStrings("hygxyz.csv");
  for (int i = 1; i < 10; i++) { // 0 is the header
    for (int j = 0; j < 23; j++) {
      split(starBase[i], ',');
    }
    println(starBase[i]);
  }
}

public void draw() {
}


// borrowing this from the Form/Star example
public void star(float x, float y, float radius1, float radius2, int npoints) {
  float angle = TWO_PI / npoints;
  float halfAngle = angle/2.0f;
  beginShape();
  fill(255, 255, 0);
  for (float a = 0; a < TWO_PI; a += angle) {
    float sx = x + cos(a) * radius2;
    float sy = y + sin(a) * radius2;
    vertex(sx, sy);
    sx = x + cos(a+halfAngle) * radius1;
    sy = y + sin(a+halfAngle) * radius1;
    vertex(sx, sy);
  }
  endShape(CLOSE);
}

public void randomSky() {
  float x, y;
  for (int i = 0; i < 30; i++) {
    x = random(width);
    y = random(height);
    star(x, y, 8, 20, 5);
  }
}

public void mousePressed() {
  star(mouseX, mouseY, 12, 30, 5);
}


  public int sketchWidth() { return 100; }
  public int sketchHeight() { return 100; }
}
