import javax.swing.JFrame;

public class SpaceInvaders extends JFrame implements Commons {

	// Initialize Game
	public SpaceInvaders() {

		// Setup Game
		add(new Board());
		setTitle("Space Invaders");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(BOARD_WIDTH, BOARD_HEIGHT);
		setLocationRelativeTo(null); // center game window
		setVisible(true);
		setResizable(false);
	}

	/** MAIN **/
	public static void main(String[] args) {
		new SpaceInvaders();
	}
}