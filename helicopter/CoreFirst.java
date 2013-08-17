import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Core {

	// Set display bassed on Video Card
	private static DisplayMode modes[] = {
		new DisplayMode(800,600,32,0),
		new DisplayMode(800,600,24,0),
		new DisplayMode(800,600,16,0),
		new DisplayMode(800,600,32,0),
		new DisplayMode(800,600,24,0),
		new DisplayMode(800,600,16,0),
	};

	private boolean running;
	protected ScreenManager mainScreen;

	public void stop() {
		running = false;
	}

	public void run() {
		try {
			init();
			gameLoop();
		} catch (Exception e) {
			System.out.println("ERROR 1: " + e);
		} finally {
			mainScreen.restoreScreen()
		}
	}

	public void init() {
		mainScreen = new ScreenManager();
		DisplayMode display = mainScreen.findFirstCompatibleMode(modes);
		s.setScreen(display);
	}




}