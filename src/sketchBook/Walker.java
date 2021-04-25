package sketchBook;

import processing.core.PApplet;

public class Walker {
    int x;
    int y;

    Walker(PApplet _p) {
        p = _p;
        x = p.width / 2;
        y = p.height / 2;
    }

    void display() {
        p.stroke(0);
        p.point(x, y);
    }

    void step() {
        int choice = (int)p.random(4);

        if (choice == 0) { // The random “choice” determines our step.
            x++;
        } else if (choice == 1) {
            x--;
        } else if (choice == 2) {
            y++;
        } else {
            y--;
        }
    }

    private PApplet p;
}
