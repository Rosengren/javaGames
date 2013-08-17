import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player extends Sprite implements Commons {

	/** Player starting coordinates (x, y) **/
	private final int START_X = 270;
	private final int START_Y = 280;

	/** Player file location **/
	private final String player = "sprites/ship.png";

	/** width of player object **/
	private int width;


	// Initialize Player
	public Player() {

		ImageIcon tempImage = new ImageIcon(this.getClass().getResource(player));

		// set width of player based on image width
		width = tempImage.getImage().getWidth(null);

		//set image of object
		setImage(tempImage.getImage());

		// set start location
		setX(START_X);
		setY(START_Y);
	}

	public void act() {

		// move player according to key pressed
		x += dx;

		// keep player in game bounds
		if (x <= 2)
			x = 2;

		if (x >= BOARD_WIDTH - 2 * width)
			x = BOARD_WIDTH - 2 * width;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		// move player left or right 2 pixels
		if (key == KeyEvent.VK_LEFT)
			dx = -2;
		else if (key == KeyEvent.VK_RIGHT)
			dx = 2;
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT)
			dx = 0;
		else if (key == KeyEvent.VK_RIGHT)
			dx = 0;
	}
}