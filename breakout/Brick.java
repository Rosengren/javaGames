import javax.swing.ImageIcon;

public class Brick extends Sprite {

	String brickie = "images/brick.png";

	boolean destroyed;

	public Brick(int x, int y) {
		this.x = x;
		this.y = y;

		ImageIcon tempImage = new ImageIcon(this.getClass().getResource(brickie));
		image = tempImage.getImage();
	
		width = image.getWidth(null);
		height = image.getHeight(null);

		destroyed = false;
	}

	public boolean isDestroyed() {
		return destroyed;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}
}
