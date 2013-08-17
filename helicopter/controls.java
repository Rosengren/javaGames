import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;

public class Controls extends Core implements KeyListener {

	private String message;


	public static void main(String[] args) {
		new Controls().run();
	}

	// Init also call init from superclass
	public void init() {
		super.init();

		Window win = screen.getWindow();
		win.setFocusTraversalKeysEnabled(false);
		screen.getWindow().addKeyListener(this);
	}


	// keyPressed
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		message = "Pressed : " + KeyEvent.getKeyText(keyCode);
		e.consume();
	}

	public String getText() {
		return message;
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
}