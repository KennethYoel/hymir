package sketchBook;

import processing.core.PApplet;
import processing.core.PGraphics;

public class Cell {
    PGraphics pg;
    PGraphics upScale;
    int[] cells;
    //int[] ruleset = {0, 0, 0, 1, 1, 1, 1, 0}; // ruleset 30
    //int[] ruleset = {0, 1, 0, 1, 1, 0, 1, 0}; // ruleset 90 aka SierpinskiTriangle
    //int[] ruleset = {0, 1, 1, 0, 1, 1, 1, 0}; // ruleset 110
    int[] ruleset = {1, 0, 0, 1, 0, 1, 1, 0}; // ruleset 150, could create a 1d or 2d array with all rulesets 0-255
    //int[] ruleset = {0, 0, 0, 1, 1, 1, 0, 1}; // ruleset 184
    int cellWidth = 1;
    float w;
    float h;
    float diameter;
    float radii;
    int gen;

    Cell(PApplet _p) {
        p = _p;

        cells = new int[40 / cellWidth]; // instead of p.width the final windowed resolution use initial resolution.

        for (int i = 0; i < cells.length; i++) {
            cells[i] = 0;
        }
        cells[cells.length/2] = 1;
        gen = 0;

        pg = p.createGraphics(40, 23);
        upScale = p.createGraphics(p.width, p.height);
    }

    void generation() {
        int[] newCells = new int[cells.length];

        for (int i = 1; i < cells.length - 1; i++) {
            int left = cells[i - 1];
            int middle = cells[i]; // Instead of i, we use (int)p.random(1) to choose an int between 0 and 1.
            int right = cells[i + 1];

            int newState = rules(left, middle, right);

            newCells[i] = newState;
        }

        cells = newCells;
        gen++;
    }

    int rules(int a, int b, int c) {
        String s = "" + a + b + c;
        int index = Integer.parseInt(s,2);
        
        return ruleset[index];

        // if (a == 1 && b == 1 && c == 1)
        //     return ruleset[0];
        // else if (a == 1 && b == 1 && c == 0)
        //     return ruleset[1];
        // else if (a == 1 && b == 0 && c == 1)
        //     return ruleset[2];
        // else if (a == 1 && b == 0 && c == 0)
        //     return ruleset[3];
        // else if (a == 0 && b == 1 && c == 1)
        //     return ruleset[4];
        // else if (a == 0 && b == 1 && c == 0)
        //     return ruleset[5];
        // else if (a == 0 && b == 0 && c == 1)
        //     return ruleset[6];
        // else if (a == 0 && b == 0 && c == 0)
        //     return ruleset[7];

        //return 0;
    }

    void renderCA() {
        w = 4;
        h = 4;
        //diameter = 4;

        for (int i = 0; i < cells.length; i++) {
            pg.beginDraw();
            //int spectrum = p.color(204 - gen, 153 - i, 0);
            if (cells[i] == 1) {
                pg.fill(255, 196, 13);
            }
            else {
                pg.fill(76, 76, 73);
            } 
            pg.noStroke();
            pg.rect(i * cellWidth, gen * cellWidth, w, h); 
            pg.endDraw();

            //p.image(pg, 0, 0);
        }
    }

    void displayPixels() {
        for (int i = 0; i < cells.length; i++) {
            //int beluga = p.color(76, 76, 73);
            //int white = p.color(255);
            int flatYellow = p.color(255, 196, 13);
            //p.loadPixels();
            for (int j = 0; j < p.width * p.height; j++) {
                //int spectrum = p.color(204 - gen, 153 - i, 0);
                if (cells[i] == 1) {
                    //p.pixels[(gen * cellWidth) * p.width + (i * cellWidth)] = spectrum;
                    // sets a pixel chosen by the x,y coordinate to a color
                    p.set(i * cellWidth, gen * cellWidth, flatYellow);
                }
                // else {
                //     //p.pixels[(gen * cellWidth) * p.width + (i * cellWidth)] = white; // Throws ArrayIndexOutOfBoundsException
                //     p.set(i * cellWidth, gen * cellWidth, white);
                // }
            }
            //p.updatePixels();
        }
    }

    void display2DPrimitives() {
        w = 4;
        h = 4;
        diameter = 4;
        // radii = 7;
        for (int i = 0; i < cells.length; i++) {
            //int spectrum = p.color(204 - gen, 153 - i, 0);
            if (cells[i] == 1) {
                p.fill(255, 196, 13);
            }
            else {
                p.fill(76, 76, 73);
            } 
            p.noStroke();
            p.rect(i * cellWidth, gen * cellWidth, w, h);
            //p.ellipse(i * cellWidth, gen * cellWidth, diameter, diameter); // third parameter sets width and height of the ellipse by default so * the parameter by i
        }
    }

    void displayPixelArt() {
        upScale.beginDraw();
        upScale.image(pg, 0, 0, upScale.width, upScale.height);
        upScale.endDraw();

        p.image(upScale, 0, 0);
    }
    private PApplet p;
}
