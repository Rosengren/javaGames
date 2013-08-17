import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class ItemManager {

	private Random rand;
	
	public ItemManager() {
		rand = new Random();
	}


	// DRAW 2D Graphic Items
	public void draw2D(ScreenManager screen) {

	}

	public void draw(ScreenManager screen) {

	}

	/*public void drawObject(ScreenManager screen) {
		//draw rectangles (deprecate)
		for (int i = 0; i < 20; ++i) {

          int r = rand.nextInt(256);
          int g = rand.nextInt(256);
          int b = rand.nextInt(256);

          screen.getGraphics2D().setColor(new Color(r, g, b));
          

          int x = rand.nextInt( 640/2 );
          int y = rand.nextInt( 480/2 );
          int w = rand.nextInt( 640/2 );
          int h = rand.nextInt( 480/2 );

          screen.getGraphics2D().fillRect( x, y, w, h );
			
		}	
		// Display FPS
		screen.getGraphics2D().setFont( new Font( "Courier New", Font.PLAIN, 12 ) );
	    screen.getGraphics2D().setColor( Color.GREEN );
		screen.getGraphics2D().drawString( String.format( "FPS: %s", fps ), 20, 20 );
		*/
		        
	}
}


