import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

	private final int WIDTH = 500;
	private final int HEIGHT = 500;
	private final int DOT_SIZE = 10;
	private final int ALL_DOTS = 900;
	private final int RAND_POS = 29;
	private final int DELAY = 50;

	private int x[] = new int[ALL_DOTS];
	private int y[] = new int[ALL_DOTS];

	private int dots;
	private int apple_x;
	private int apple_y;


	private boolean left = false;
	private boolean right = true;
	private boolean up = false;
	private boolean down = false;
	private boolean inGame = true;
	private boolean endGame = false;
	private boolean pauseGame = false;

	private Timer timer;
	private Image ball;
	private Image apple;

	public Board() {
		addKeyListener(new TAdapter());

		setBackground(Color.black);

		ImageIcon iid = new ImageIcon(this.getClass().getResource("images/dot.png"));
		ball = iid.getImage();

		ImageIcon iia = new ImageIcon(this.getClass().getResource("images/apple.png"));
		apple = iia.getImage();

		setFocusable(true);
		initGame();
	}

	public void initGame() {

		dots = 3;

		// initialize snake (size 3)
		for (int z = 0; z < dots; z++) {
			x[z] = 200 - z * 10;
			y[z] = 200;
		}

		locateApple();
		timer = new Timer(DELAY, this);
		timer.start();
	}

	public void paint(Graphics g) {
		super.paint(g);

		if (inGame) {
			g.drawImage(apple, apple_x, apple_y, this);

			for (int z = 0; z < dots; z++) {
					g.drawImage(ball, x[z], y[z], this);
			}

			Toolkit.getDefaultToolkit().sync();
			g.dispose();
		} else if (pauseGame) {
			pauseGame(g);
		} else {
			endGame = true;
			gameOver(g);
		}
	}

	public void pauseGame(Graphics g) {

		String msgPaused = "Paused";
		String msgEscape = "Press ESCAPE to Continue";
		String msgEnter = "Press Enter to Restart";
		String msgSpace = "Press Space to Quit";
		Font small = new Font("Helvetica", Font.BOLD, 14);
		FontMetrics metr = this.getFontMetrics(small);

		g.setColor(Color.white);
		g.setFont(small);
		g.drawString(msgPaused, (WIDTH - metr.stringWidth(msgPaused)) / 2, HEIGHT / 2 - 40);	
		g.drawString(msgEscape, (WIDTH - metr.stringWidth(msgEscape)) / 2, HEIGHT / 2 - 20);	
		g.drawString(msgEnter, (WIDTH - metr.stringWidth(msgEnter)) / 2, HEIGHT / 2);	
		g.drawString(msgSpace, (WIDTH - metr.stringWidth(msgSpace)) / 2, HEIGHT / 2 + 20);	
	}

	// End Game
	public void gameOver(Graphics g) {

		// Print game over and center the text
		String msg = "Game Over";
		String replay = "Press Enter to Restart";
		String quitMsg = "Press Space to Quit";
		Font small = new Font("Helvetica", Font.BOLD, 14);
		FontMetrics metr = this.getFontMetrics(small);

		g.setColor(Color.white);
		g.setFont(small);
		g.drawString(msg, (WIDTH - metr.stringWidth(msg)) / 2, HEIGHT / 2 - 20);
		g.drawString(replay, (WIDTH - metr.stringWidth(replay)) / 2, HEIGHT / 2);
		g.drawString(quitMsg, (WIDTH - metr.stringWidth(quitMsg)) / 2, HEIGHT / 2 + 20);
	}

	// check if the apple has been eaten
	public void checkApple() {

		if ((x[0] == apple_x) && (y[0] == apple_y)) {
			dots++;
			locateApple();
		}
	}

	// move snake
	public void move() {

		// update location of each dot
		for (int z = dots; z > 0; z--) {
			x[z] = x[(z - 1)];
			y[z] = y[(z - 1)];
		}

		if (left)
			x[0] -= DOT_SIZE;
	
		if (right)
			x[0] += DOT_SIZE;

		if (up)
			y[0] -= DOT_SIZE;

		if (down) 
			y[0] += DOT_SIZE;
	}

	public void checkCollision() {

		// Check if hit itself
		for (int z = dots; z > 0; z--) {

			if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z]))
				inGame = false;
		}

		// Check if hit sides
		if (y[0] > HEIGHT)
			inGame = false;

		if (y[0] < 0)
			inGame = false;

		if (x[0] > WIDTH)
			inGame = false;

		if (x[0] < 0)
			inGame = false;
	}

	// spawn new apple
	public void locateApple() {
		int r = (int) (Math.random() * RAND_POS);
		apple_x = ((r * DOT_SIZE));
		r = (int) (Math.random() * RAND_POS);
		apple_y = ((r * DOT_SIZE));
	}

	public void actionPerformed(ActionEvent e) {

		if (inGame) {
			checkApple();
			checkCollision();
			move();
		}

		repaint();
	}

	private class TAdapter extends KeyAdapter {

		public void keyPressed(KeyEvent e) {

			int key = e.getKeyCode();

			if ((key == KeyEvent.VK_LEFT) && (!right)) {
				left = true;
				up = false;
				down = false;
			} 
			if ((key == KeyEvent.VK_RIGHT) && (!left)) {
				right = true;
				up = false;
				down = false;
			} 

			if ((key == KeyEvent.VK_UP) && (!down)) {
				up = true;
				left = false;
				right = false;
			}

			if ((key == KeyEvent.VK_DOWN) && (!up)) {
				down = true;
				left = false;
				right = false;
			}

			if ((key == KeyEvent.VK_ENTER) && (endGame || pauseGame)) {
				endGame = false;

				dots = 3;

				// initialize snake (size 3)
				for (int z = 0; z < dots; z++) {
					x[z] = 200 - z * 10;
					y[z] = 200;
				}

				locateApple();

				inGame = true;
			}

			if ((key == KeyEvent.VK_SPACE) && (endGame || pauseGame)) {
				System.exit(0);
			}

			// Pause/unPause game
			if ((key == KeyEvent.VK_ESCAPE) && !endGame) {
				if (pauseGame) {
					pauseGame = false;
					inGame = true;
				} else {
					pauseGame = true;
					inGame = false;
				}

			}
		}
	}
}



// TODO

/**
 * Difficulty
 * Ghost Mode (first (or last) dot visible)
 *
 *
 **/