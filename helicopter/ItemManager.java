import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class ItemManager {

	private Item first;
	private Controls buttons;

	
	public ItemManager() {
		initImages();
		buttons = new Controls();
	}

	public void initImages() {
		first = new Item("/images/helicopter.png");
	}

	// DRAW 2D Graphic Items
	public void draw2D(ScreenManager screen) {

		Random r = new Random();
		int i = r.nextInt(200);

		screen.getGraphics2D().setColor(new Color(25,i,50));
		screen.getGraphics2D().fillRect(50,50,50,50);

		String b = buttons.getText();
		screen.getGraphics2D().setFont( new Font( "Courier New", Font.PLAIN, 17 ) );
		screen.getGraphics2D().setColor( Color.GREEN );
		screen.getGraphics2D().drawString( String.format("TEST -- ", b), 20, 20 );
	}

	public void draw(ScreenManager screen) {
		Image image = new ImageIcon("/Users/kevinrosengren/Documents/javaGames/helicopter/images").getImage();
		screen.getGraphics2D().drawImage(image, 40, 40, null);
	}
}