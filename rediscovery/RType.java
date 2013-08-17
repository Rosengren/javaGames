import javax.swing.JFrame;

public class RType extends JFrame {

	public RType() {

		add(new Board());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 500);
		setLocationRelativeTo(null);
		setTitle("Helicotper");
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new RType();
	}
}