import java.awt.Image;

public class Sprite {

	/** set sprite visibility **/
	private boolean visible;
	private Image image;

	/** sprite location & direction **/
	protected int x, y, dx;

	/** set sprite dying **/
	protected boolean dying;

	// initialize sprite
	public Sprite() {
		visible = true;
	}

	// kill sprite
	public void die() {
		visible = false;
	}

	// check if sprite is on screen
	public boolean isVisible() {
		return visible;
	}

	// set whether sprite is to be visible
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	// set image of sprite
	public void setImage(Image image) {
		this.image = image;
	}

	// get image of sprite
	public Image getImage() {
		return image;
	}

	// set x coordinate
	public void setX(int x) {
		this.x = x;
	}

	// set y coordinate
	public void setY(int y) {
		this.y = y;
	}

	// get x coordinate
	public int getX() {
		return x;
	}	
	// get y coordinate
	public int getY() {
		return y;
	}

	// set whether or not sprite is dying
	public void setDying(boolean dying) {
		this.dying = dying;
	}

	// check if sprite is dying
	public boolean isDying() {
		return this.dying;
	}
}