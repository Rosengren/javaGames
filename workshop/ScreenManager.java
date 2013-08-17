import java.awt.*;
import javax.swing.JFrame;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class ScreenManager {

	private GraphicsDevice vc; // Object for video card

	// Give vc access to monitor screen
	public ScreenManager() {
		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
		vc = e.getDefaultScreenDevice();
	}

	// Get all compatible DM
	public DisplayMode[] getCompatibleDisplayModes() {
		return vc.getDisplayModes();
	}

	// Compares DM passed in to vc DM and see if they match
	public DisplayMode findFirstCompatibleMode(DisplayMode modes[]) {
		DisplayMode goodModes[] = vc.getDisplayModes();
		for (int x = 0; x < modes.length; x++) {
			for (int y = 0; y < goodModes.length; y++) {
				if (displayModesMatch(modes[x], goodModes[y])) {
					return modes[x];
				}
			}
		}
		return null;
	}

	// Get current DM (Display Mode)
	public DisplayMode getCurrentDisplayMode() {
		return vc.getDisplayMode();
	}

	// Check if two modes match each other
	public boolean displayModesMatch(DisplayMode m1, DisplayMode m2) {

		// compare resolution
		if (m1.getWidth() != m2.getWidth() || m1.getHeight() != m2.getHeight())
			return false;

		// compare bit depth
		if (m1.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI &&
			m2.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI &&
			m1.getBitDepth() != m2.getBitDepth())
			return false;

		// compare refresh rate
		if (m1.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN &&
			m2.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN &&
			m1.getRefreshRate() != m2.getRefreshRate())
			return false;

		// display modes match
		return true;
	}

	// Make frame full screen
	public void setFullScreen(DisplayMode dm) {
		JFrame fr = new JFrame();
		fr.setUndecorated(true);
		fr.setIgnoreRepaint(true);
		fr.setResizable(false);
		vc.setFullScreenWindow(fr);

		if (dm != null && vc.isDisplayChangeSupported()) {
			try {
				vc.setDisplayMode(dm);
			} catch (Exception e) {}

		}
		fr.createBufferStrategy(2); // 2 buffers
	}

	// we will set Graphics object = to this
	public Graphics2D getGraphics() {
		Window w = vc.getFullScreenWindow();
		if (w != null) {
			BufferStrategy s = w.getBufferStrategy();
			return (Graphics2D)s.getDrawGraphics();
		}
		
		return null;
	}

	// Updates display
	public void update() {
		Window w = vc.getFullScreenWindow();
		if (w != null) {
			BufferStrategy s = w.getBufferStrategy();
			if (!s.contentsLost()) {
				s.show();
			}
		} 
	}

	// Return full screen window
	public Window getFullScreenWindow() {
		return vc.getFullScreenWindow();
	}

	// Return window width
	public int getWidth() {
		Window w = vc.getFullScreenWindow();
		if (w != null)
			return w.getWidth();
		return 0;
	}

	// Return window height
	public int getHeight() {
		Window w = vc.getFullScreenWindow();
		if (w != null) 
			return w.getHeight();
		return 0;
	}

	// Get out of fullscreen
	public void restoreScreen() {
		Window w = vc.getFullScreenWindow();
		if (w != null)
			w.dispose();
		vc.setFullScreenWindow(null);
	}

	// Create image compatible with monitor
	public BufferedImage createCompatibleImage(int w, int h, int t) {
		Window window = vc.getFullScreenWindow();
		if (window != null) {
			GraphicsConfiguration gc = window.getGraphicsConfiguration();
			return gc.createCompatibleImage(w, h, t);
		}

		return null;
	}
}