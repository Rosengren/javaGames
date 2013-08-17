import javax.swing.ImageIcon;

public class Ball extends Sprite implements Commons {

	private int dx;
	private int dy;

	protected String ball = "images/ball.png";

	public Ball() {
		dx = 1;
		dy = -1;

		ImageIcon tempImage = new ImageIcon(this.getClass().getResource(ball));
		image = tempImage.getImage();

		width = image.getWidth(null);
		height = image.getHeight(null);

		resetState();
	}

	public void move() {
		x += dx;
		y += dy;

		if (x == 0)
			setDX(1);

		if (y == 0)
			setDY(1);

		if (x == BALL_RIGHT)
			setDX(-1);
	}

	public void resetState() {
		x = 230;
		y = 355;
	}

	public void setDX(int x) {
		dx = x;
	}

	public void setDY(int y) {
		dy = y;
	}


	public int getDY() {
		return dy;
	}

}