import java.awt.*;
import javax.swing.JFrame;

public class Screen {

	// object 
	private GraphicsDevice vc;

	public Screen() {

		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment(); 
		vc = env.getDefaultScreenDevice();
	}

	public void setFullScreen(DisplayMode dm, JFrame window) {

		// remove top/bottom bars
		window.setUndecorated(true);

		// disable window resize
		window.setResizable(false);

		// set the window to full screen
		vc.setFullScreenWindow(window);

		if (dm != null &&vc.isDisplayChangeSupported()) {

			try {
				vc.setDisplayMode(dm);
			} catch (Exception e) {}
		}

	}
	public Window getFullScreenWindow() {
		return vc.getFullScreenWindow();
	}

	public void restoreScreen() {
		Window w = vc.getFullScreenWindow();

		if (w != null) {

			// freeze resorces when closing window
			w.dispose();
		}

		// disable full screen
		vc.setFullScreenWindow(null);
	}

}
