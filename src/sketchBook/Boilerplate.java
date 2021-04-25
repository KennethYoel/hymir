package sketchBook;

import processing.core.PApplet;

public class Boilerplate {
    int c, d;

    Boilerplate(PApplet _p) {
        p = _p;
        c = 80;
        d = 80;
    }

    void display() {
        p.stroke(0);
    }

    void step() {
        if (p.mousePressed) {
            p.fill(74, 72, 67, 75);
        } else {
            p.fill(255);
        }
        p.ellipse(p.mouseX, p.mouseY, c, d);
    }

    private PApplet p;
}

