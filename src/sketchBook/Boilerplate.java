package sketchBook;

import processing.core.PApplet;

public class Boilerplate {  // The Boilerplate object.
    int c, d;  // Objects have data.

    Boilerplate(PApplet _p) {  // Objects have a constructor-a special function where the class are initialized.
        p = _p;
        c = 80;
        d = 80;
    }

    void display() {  // Objects have functions aka functionality.
        p.stroke(0);
    }

    void step() {  // Objects have functions.
        if (p.mousePressed) {
            p.fill(74, 72, 67, 75);
        } else {
            p.fill(255);
        }
        p.ellipse(p.mouseX, p.mouseY, c, d);
    }

    private PApplet p;
}

