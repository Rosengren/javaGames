import javax.swing.ImageIcon;

public class Shot extends Sprite {

	/** image of bullet **/
	private String shot = "sprites/shot.png";

	/** Bullet dimensions **/
	private final int H_SPACE = 6;
	private final int V_SPACE = 1;

	public Shot() {

	}

	// initialize bullet
	public Shot(int x, int y) {
		
		// load image file
		ImageIcon tempImage = new ImageIcon(this.getClass().getResource(shot));
		setImage(tempImage.getImage());

		// set start position
		setX(x + H_SPACE);
		setY(y - V_SPACE);
	}
}