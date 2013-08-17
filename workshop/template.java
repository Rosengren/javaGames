import java.awt.*;
import javax.swing.*;

public class template {

	public static void main(String args[]) {
		template t = new template();
		t.run();
	}

	private Sprite sprite;
	private Animation a;
	private ScreenManager s;
	private Image bg;

	private static final DisplayMode modes1[] = {
		new DisplayMode(800,600,32,0),
		new DisplayMode(800,600,24,0),
		new DisplayMode(800,600,16,0),
		new DisplayMode(640,480,32,0),
		new DisplayMode(640,480,24,0),
		new DisplayMode(640,480,16,0)
	};

	// Load images and add scenes
	public void loadImages() {
		bg = new ImageIcon("/Users/kevinrosengren/Documents/javaGames/images/background.png").getImage();
		Image eyeOpen = new ImageIcon("/Users/kevinrosengren/Documents/javaGames/images/opened.jpg").getImage();
		Image eyeClose = new ImageIcon("/Users/kevinrosengren/Documents/javaGames/images/closed.jpg").getImage();

		a = new Animation();
		a.addScene(eyeOpen, 1000);
		a.addScene(eyeClose, 250);

		sprite = new Sprite(a);
		sprite.setVelocityX(0.3f);
		sprite.setVelocityY(0.3f);
	}

	// Run method called from main
	public void run() {
		s = new ScreenManager();
		try {
			DisplayMode dm = s.findFirstCompatibleMode(modes1);
			s.setFullScreen(dm);
			loadImages();
			movieLoop();
		} finally {
			s.restoreScreen();
		}
	}

	// Play movie
	public void movieLoop() {
		long startingTime = System.currentTimeMillis();
		long currTime = startingTime;

		// runs for 5 seconds
		while (currTime - startingTime < 5000) {
			long timePassed = System.currentTimeMillis() - currTime;
			currTime += timePassed;
			update(timePassed);

			// draw and update screen
			Graphics2D g = s.getGraphics();
			draw(g);
			g.dispose();
			s.update();

			try {
				Thread.sleep(5);
			} catch (Exception e) {}
		}
	}

	// Draw graphics
	public void draw(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		g.drawImage(sprite.getImage(), Math.round(sprite.getX()), Math.round(sprite.getY()), null);
	}

	// Update Sprite
	public void update(long timePassed) {
		if (sprite.getX() < 0)
			sprite.setVelocityX(Math.abs(sprite.getVelocityX()));
		else if (sprite.getX() + sprite.getWidth() >= s.getWidth())
			sprite.setVelocityX(-Math.abs(sprite.getVelocityX()));

		if (sprite.getY() < 0)
			sprite.setVelocityY(Math.abs(sprite.getVelocityY()));		
		else if (sprite.getY() + sprite.getHeight() >= s.getHeight())
			sprite.setVelocityY(-Math.abs(sprite.getVelocityY()));


		sprite.update(timePassed);
	}

}