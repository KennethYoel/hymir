/******************************************************************************
 * PixelFace
 * scaling up a small PGraphics for pixel-aesthetic display in a larger sketch.
 * 2018-01-27 Jeremy Douglass - Processing 3.3.6
 ******************************************************************************/

package sketchBook;

import processing.core.PApplet;
import processing.core.PGraphics;

public class PixelFace {

    private PApplet p;
    PGraphics pg;
    PGraphics sized;

    PixelFace(PApplet _p) {
        p = _p;

        pg = p.createGraphics(30, 30);
        face(pg);
        sized = p.createGraphics(p.width, p.height);
        sized.beginDraw();
        sized.image(pg, 0, 0, sized.width, sized.height);
        sized.endDraw();
    } 

    void face(PGraphics pg) {
        pg.beginDraw();
        pg.noSmooth();
        pg.background(192);
        pg.noFill();
        pg.rect(0, 0, 31, 31);     // head
        pg.set(10, 10, p.color(0));  // eye
        pg.set(21, 10, p.color(0));  // eye
        pg.ellipse(15, 15, 6, 6);  // nose
        pg.line(10, 21, 21, 21);   // mouth
        pg.rect(27, 10, 2, 8);     // ear
        pg.endDraw();
    }

    void displayPixelArt() {
        p.background(255);
        p.image(sized, 0, 0);
        p.image(pg, 0, 0);
    }
}
