import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Core {

	public ItemManager items;
	public ScreenManager screen;

	public void init() {
		screen = new ScreenManager();
		items = new ItemManager();
	}

	public void run() {
		try {
			init();
			gameLoop();
		} catch(Exception e){}
	}

	public void gameLoop() {

		int fps = 0;
		int frames = 0;
		long totalTime = 0;
		long currTime = System.currentTimeMillis();
		long lastTime = currTime;
		
		while (true) {

			try {
				lastTime = currTime;
				currTime = System.currentTimeMillis();
				totalTime += currTime - lastTime;

				if (totalTime > 1000) {
					totalTime -= 1000;
					fps = frames;
					frames = 0;
				}

				++frames;


				screen.update2D();
				items.draw2D(screen);
				screen.update();

		        Thread.yield();
			} finally {
				if (screen.getGraphics() != null)
					screen.dispose();
				if (screen.getGraphics2D() != null)
					screen.dispose2D();
			}
		}	
    }
}