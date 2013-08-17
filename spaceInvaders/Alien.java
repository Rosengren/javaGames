import javax.swing.ImageIcon;

public class Alien extends Sprite {

	/** Bomb contained in alien ship **/
	private Bomb bomb;

	/** Alien ship image location **/
	private final String alien = "sprites/alien.png";

	// Initialize Alien
	public Alien(int x, int y) {
		this.x = x;
		this.y = y;

		bomb = new Bomb(x, y);
		ImageIcon tempImage = new ImageIcon(this.getClass().getResource(alien));
		setImage(tempImage.getImage());
	}

	// Alien Sprite
	public void act(int direction) {
		this.x += direction;
	}

	public Bomb getBomb() {
		return bomb;
	}

	// Bomb held by alien
	public class Bomb extends Sprite {

		/** Bomb image location **/
		private final String bomb = "sprites/bomb.png";

		/** Bomb condition **/
		private boolean destroyed;

		// Initialize Bomb
		public Bomb(int x, int y) {
			setDestroyed(true);

			// set bomb starting location (coordinates)
			this.x = x;
			this.y = y;
			ImageIcon tempImage = new ImageIcon(this.getClass().getResource(bomb));
			setImage(tempImage.getImage());
		}

		// Set the condition to destroyed (false)
		// or not destroyed (true)
		public void setDestroyed(boolean destroyed) {
			this.destroyed = destroyed;
		}

		// Check bomb condition
		public boolean isDestroyed() {
			return destroyed;
		}
	}
}