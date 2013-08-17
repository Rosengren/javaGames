import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput extends Core implements KeyListener {

	public static void main(String[] args) {
		new KeyInput().run();
	}

	private String message = "";

	// Init also call init from superclass
	public void init() {
		super.init();

		Window win = s.getFullScreenWindow();
		win.setFocusTraversalKeysEnabled(false);
		win.addKeyListener(this);
		message = "press escape to exit";
	}

	// keyPressed
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_ESCAPE)
			stop();
		else {
			message = "Pressed :" + KeyEvent.getKeyText(keyCode);
			e.consume();
		}
	}

	// keyReleased
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		message = "Released :" + KeyEvent.getKeyText(keyCode);
		e.consume();
	}

	// Last method from interface
	public void keyTyped(KeyEvent e) {
		e.consume();
	}

	// draw to screen
	public synchronized void draw(Graphics2D g) {
		Window w = s.getFullScreenWindow();
		g.setColor(w.getBackground());
		g.fillRect(0,0,s.getWidth(), s.getHeight());
		g.setColor(w.getForeground());
		g.drawString(message, 30,30);
	}
}