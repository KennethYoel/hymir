package cellularAutomata;

import processing.core.PApplet;

public class Cell {
    int[] cells;
    int[] ruleset = {0, 1, 0, 1, 1, 0, 1, 0};
    int w = 2;
    int gen;

    Cell(PApplet _p) {
        p = _p;
        cells = new int[p.width / w];

        for (int i = 0; i < cells.length; i++) {
            cells[i] = 0;
        }
        cells[cells.length/2] = 1;
        gen = 0;
    }

    void generation() {
        int[] newCells = new int[cells.length];

        for (int i = 1; i < cells.length - 1; i++) {
            int left = cells[i - 1];
            int middle = cells[i];
            int right = cells[i + 1];

            int newState = rules(left, middle, right);

            newCells[i] = newState;
        }

        cells = newCells;
        gen++;
    }

    void display() {
        //int[] cells = {1,0,1,0,0,0,0,1,0,1,1,1,0,0,0,1,1,1,0,0};

        for (int i = 0; i < cells.length; i++) {
            if (cells[i] == 1) {
                p.fill(0);
            }
            else {
                p.fill(255);
            } 

            p.noStroke();
            p.circle(i * w, gen * w, i * w); // third parameter sets width and height of the ellipse by default so increas the parameter by 2
        }
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

    private PApplet p;
}
