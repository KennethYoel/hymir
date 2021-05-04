package sketchBook;

import processing.core.PApplet;

public class App extends PApplet {

    // The argument passed to main must match the class name
    public static void main(String[] args) {
        PApplet.main("sketchBook.App");
    }

    // Method for setting the size of the window
    public void settings() {
        size(640, 360);
    }

    Cell ca;  // a Cell object where we are modeling a cellular automata.
    Walker w;

    // Identical use to setup in Processing IDE except for size()
    public void setup() {
        ca = new Cell(this); // Avoid a NULL Exception by using keyword this. So the Object does point to something.
        w = new Walker(this);
        background(76, 76, 73);
    }

    // Identical use to draw in Processing IDE
    public void draw() {
        ca.generation();
        //ca.displayPixels();
        ca.display2DPrimitives();
        //w.step();
        //w.display();
        //saveFrame("img/output/#####.png"); // Type in Terminal the following bash gifenc.sh %05d.png anim.gif(or any file name I want).
    }
}
