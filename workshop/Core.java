import java.awt.*;
import javax.swing.*;

public abstract class Core {

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
	protected ScreenManager s;

	// Stop Method
	public void stop() {
		running = false;
	}

	// Call initial and gameLoop
	public void run() {
		try {
			init();
			gameLoop();
		} finally {
			s.restoreScreen();
		}
	}

	// Set to full Screen
	public void init() {
		s = new ScreenManager();
		DisplayMode dm = s.findFirstCompatibleMode(modes);
		s.setFullScreen(dm);

		Window w = s.getFullScreenWindow();
		w.setFont(new Font("Arial", Font.PLAIN, 20));
		w.setBackground(Color.BLACK);
		w.setForeground(Color.WHITE);
		running = true;
	}

	// Main gameLoop
	public void gameLoop() {
		long startTime = System.currentTimeMillis();
		long totalTime = startTime;

		while (running) {
			long timePassed = System.currentTimeMillis()	- totalTime;
			totalTime += timePassed;

			update(timePassed);

			Graphics2D g = s.getGraphics();
			draw(g);
			g.dispose();
			s.update();

			try {
				Thread.sleep(20);
			} catch (Exception e) {};
		}
	}

	// Update Animation
	public void update(long timePassed) {

	}	

	// Draws to Screen
	public abstract void draw(Graphics2D g);
}