import javax.swing.JFrame;

public class Collision extends JFrame {

	public Collision() {
		add(new Board());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 500);
		setLocationRelativeTo(null);
		setTitle("Collision");
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Collision();
	}
}