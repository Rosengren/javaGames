// package donut;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
// import javax.swing.Timer;


public class Board extends JPanel implements Runnable {

    private Image heli;
    private Thread animator;
    private int x, y;

    private final int DELAY = 5;


    public Board() {
    	setBackground(Color.BLACK);
    	setDoubleBuffered(true);

    	ImageIcon ii = new ImageIcon(this.getClass().getResource("helicopter.png"));
    	heli = ii.getImage();

    	x = y = 10;
    }

    public void addNotify() {
    	super.addNotify();
    	animator = new Thread(this);
    	animator.start();
    }

    public void paint(Graphics g) {
    	super.paint(g);

    	Graphics2D g2d = (Graphics2D)g;
    	g2d.drawImage(heli, x, y, this);
    	Toolkit.getDefaultToolkit().sync();
    	g.dispose();
    }


	public void cycle() {
		x += 1;
    	y += 1;

    	if (y > 500) {
    		y = -45;
    		x = -45;
    	}
    	repaint();
    }

    public void run() {

    	long beforeTime, timeDiff, sleep;

    	beforeTime = System.currentTimeMillis();

    	while (true) {

    		cycle();
    		repaint();

    		timeDiff = System.currentTimeMillis() - beforeTime;
    		sleep = DELAY - timeDiff;

    		if (sleep < 0)
    			sleep = 2;
    		try {
    			Thread.sleep(sleep);
    		} catch (Exception e) {
    			System.out.println("interrupted");
    		}

    		beforeTime = System.currentTimeMillis();
    	}
    }
}