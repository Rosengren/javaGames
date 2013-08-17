import java.awt.*;
import javax.swing.*;

public class Item {

	private Image image;
	public Item(String location) {
		// image = new ImageIcon(this.getClass().getResource(location)).getImage();
		image = new ImageIcon("/Users/kevinrosengren/Documents/javaGames/helicopter/images").getImage();
	}

	public void changeImage(String location) {
		image = new ImageIcon(this.getClass().getResource(location)).getImage();
	}

	public Image getImage() {
		return image;
	}
}

/*


	// Load images and add scenes
	public void loadImages() {
		bg = new ImageIcon("/Users/kevinrosengren/Documents/javaGames/images/background.png").getImage();
		Image eyeOpen = new ImageIcon("/Users/kevinrosengren/Documents/javaGames/images/opened.jpg").getImage();
		Image eyeClose = new ImageIcon("/Users/kevinrosengren/Documents/javaGames/images/closed.jpg").getImage();

		a = new Animation();
		a.addScene(eyeOpen, 1000);
		a.addScene(eyeClose, 250);

		sprite = new Sprite(a);
		sprite.setVelocityX(0.3f);
		sprite.setVelocityY(0.3f);
	}
*/