import java.awt.Image;

public class Sprite {

	private Animation a;

	// coordinates
	private float x;
	private float y;

	// velocity
	private float vx;
	private float vy;

	// Constructor
	public Sprite(Animation a) {
		this.a = a;
	}

	// Change Position
	public void update(long timePassed) {
		// calculate where image should be
		x += vx * timePassed;
		y += vy * timePassed;

		// update animation
		a.update(timePassed);
	}

	// Get x position
	public float getX() {
		return x;
	}

	// Get y position
	public float getY() {
		return y;
	}

	// Set sprite x position
	public void setX(float x) {
		this.x = x;
	}

	// Set sprite y position
	public void setY(float y) {
		this.y = y;
	}

	// Get sprite width
	public int getWidth() {
		return a.getImage().getWidth(null);
	}

	// Get sprite height
	public int getHeight() {
		return a.getImage().getHeight(null);
	}

	// Get horizontal velocity
	public float getVelocityX() {
		return vx;
	}

	// Get vertical velocity
	public float getVelocityY() {
		return vy;
	}

	// Set horizontal velocity
	public void setVelocityX(float vx) {
		this.vx = vx;
	}
	// Set vertical velocity
	public void setVelocityY(float vy) {
		this.vy = vy;
	}

	// Get sprite | image
	public Image getImage() {
		return a.getImage();
	}

}