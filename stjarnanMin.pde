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

// Stjarnan mín
// By Leó Stefánsson
// for Nína Heiðrós
String[] starBase;

void setup() {
  size(100, 100);
  background(0);
  starBase = loadStrings("hygxyz.csv");
  for (int i = 1; i < 10; i++) { // 0 is the header
    for (int j = 0; j < 23; j++) {
      split(starBase[i], ',');
    }
    println(starBase[i]);
  }
}

void draw() {
}


// borrowing this from the Form/Star example
void star(float x, float y, float radius1, float radius2, int npoints) {
  float angle = TWO_PI / npoints;
  float halfAngle = angle/2.0;
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

void randomSky() {
  float x, y;
  for (int i = 0; i < 30; i++) {
    x = random(width);
    y = random(height);
    star(x, y, 8, 20, 5);
  }
}

void mousePressed() {
  star(mouseX, mouseY, 12, 30, 5);
}

