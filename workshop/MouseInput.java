import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class MouseInput extends Core implements KeyListener, MouseMotionListener, MouseListener, MouseWheelListener {

	public static void main(String[] args) {
		new MouseInput().run();
	}

	private String message = "";

	// init calls super init
	public void init() {
		super.init();

		Window w = s.getFullScreenWindow();
		w.addMouseListener(this);
		w.addMouseMotionListener(this);
		w.addMouseWheelListener(this);
		w.addKeyListener(this);

	}

	// draw
	public synchronized void draw(Graphics2D g) {
		Window w = s.getFullScreenWindow();
		g.setColor(w.getBackground());
		g.fillRect(0,0, s.getWidth(), s.getHeight());
		g.setColor(w.getForeground());
		g.drawString(message, 40, 50);
	}

	// Mouse Listener Interface
	public void mousePressed(MouseEvent e) {
		message = "You pressed down the mouse";
	}

	// Mouse Release Interface
	public void mouseReleased(MouseEvent e) {
		message = "You Released the mouse";
	}

	// Unused interface methods
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	// Mouse move interface
	public void mouseMoved(MouseEvent e) {
		message = "You are moving the mouse";
	}
	
	// Mouse motion interface
	public void mouseDragged(MouseEvent e) {
		message = "You are Dragging the mouse";
	}

	// Mouse wheel move
	public void mouseWheelMoved(MouseWheelEvent e) {
		message = "You are moving mouse wheel";
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
}