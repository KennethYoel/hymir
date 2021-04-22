package sorting;

import processing.core.PApplet;

public class SketchBook extends PApplet {
	
	QuickSort sort;
	int[] values;
	int w = 10;
	
	public static void main(String[] args) {
		PApplet.main("sorting.SketchBook");
	}
	
	public void settings() {
		// In Eclipse the settings() always comes first and the only method to call in it is size().
		size(640, 360);
	}
	
	public void setup() {
		background(245, 245, 241);
		sort = new QuickSort(this);
		values = new int[width/w];
		for (int i = 0; i < values.length; i++) {
			values[i] = (int) random(height);
		}
		sort.quickSort(values, 0, values.length - 1);
	}
	
	public void draw() {
		for (int i = 0; i < values.length; i++) {
			//fill(229, 9, 20);
			fill(255);
			ellipse(i * w, height - values[i], values[i],  values[i]); // width could be variable w and the shape rect.
		}
	}
}
