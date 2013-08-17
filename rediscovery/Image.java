import javax.swing.JFrame;

public class Image extends JFrame {

	public Image() {

		add(new Board());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,500);
		setLocationRelativeTo(null);
		setTitle("Bardejov");
		setVisible(true);
	}

	public static void main(String[] args) {
		new Image();
	}
}