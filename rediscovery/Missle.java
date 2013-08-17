import java.awt.Image;
import javax.swing.ImageIcon;

public class Missile {

	private int x, y;
	private Image image;
	boolean visible;

	private final int BOARD_WIDTH = 390;
	private final int MISSLE_SPEED = 2;

	public Missile(int x, int y) {
		ImageIcon ii = new ImageIcon(this.getClass().getResource("missile.png"));
		imae = ii.getImage();

		this.x = x;
		this.y = y;
	}

	public Image getImage() {
		return image;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isVisible() {
		return visible;
	}

	public void move() {
		x += MISSLE_SPEED;
		if (x > BOARD_WIDTH)
			visible = false;
	}
}