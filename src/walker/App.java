package walker;

import processing.core.PApplet;

public class App extends PApplet {

    // The argument passed to main must match the class name
    public static void main(String[] args) {
        PApplet.main("walker.App");
    }

    // Method for setting the size of the window
    public void settings() {
        size(640, 360);
    }

    Walker w;

    // Identical use to setup in Processing IDE except for size()
    public void setup() {
        w = new Walker(this); // Avoid a NULL Exception by using keyword this. So the Object does point to something.
        background(255);
    }

    // Identical use to draw in Processing IDE
    public void draw() {
        w.step();
        w.display();
        saveFrame("img/output/#####.png"); // Type in Terminal the following bash gifenc.sh %05d.png anim.gif(or any file name I want).
    }

    // public class Walker {
    //     int x;
    //     int y;
    
    //     Walker() {
    //         x = width / 2;
    //         y = height / 2;
    //     }
    
    //     void display() {
    //         stroke(0);
    //         point(x, y);
    //     }
    
    //     void step() {
    //         float stepx = random(-1, 1);
    //         float stepy = random(-1, 1);
    //         x += stepx;
    //         y += stepy;
    //     }
    // }
}
