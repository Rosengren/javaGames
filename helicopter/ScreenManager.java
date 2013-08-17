import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class ScreenManager {

	/** Initialize Graphics Items **/
	private GraphicsDevice videoCard;
	private GraphicsEnvironment mainEnviro;
	private GraphicsDevice graphicsDevice;
	private GraphicsConfiguration graphicsConfig;
	private Graphics2D graphics2D;
	private Graphics graphics;
	private BufferedImage imageBuffer;
	private Color background;
	private	BufferStrategy buffer;
	private Canvas mainCanvas;
	private JFrame mainWindow;

	public ScreenManager() {
		buildGameWindow();
		buildEnvironment();
		initGraphics();
	}

	public void buildGameWindow() {

		// init Frame
		mainWindow = new JFrame();

		mainWindow.setIgnoreRepaint(true);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		// init Canvas
		mainCanvas = new Canvas();
		mainCanvas.setIgnoreRepaint(true);
		mainCanvas.setSize(700,500);

		// add Canvas to Frame
		mainWindow.add(mainCanvas);
		mainWindow.pack();
		mainWindow.setVisible(true);

		mainCanvas.createBufferStrategy(2); // 2 buffers
    	buffer = mainCanvas.getBufferStrategy();
	}

	// Construct the Graphics Environment
	public void buildEnvironment() {

		mainEnviro = GraphicsEnvironment.getLocalGraphicsEnvironment();
		graphicsDevice = mainEnviro.getDefaultScreenDevice();
		graphicsConfig = graphicsDevice.getDefaultConfiguration();

		// Create off-screen drawing surface
		imageBuffer = graphicsConfig.createCompatibleImage(700, 500);
	}

	// initialize Graphics
	public void initGraphics() {
		graphics = null;
		graphics2D = null;
		background = Color.WHITE;
	}

	// get Graphics2D object
	public Graphics2D getGraphics2D() {
		return graphics2D;
	}

	// get Graphics object
	public Graphics getGraphics() {
		return graphics;
	}

	// update graphics2D
	public void update2D() {
		graphics2D = imageBuffer.createGraphics();
		graphics2D.setColor(background);
		graphics2D.fillRect(0, 0, 699, 499);
	}

	// update Graphics
	public void update() {
        graphics = buffer.getDrawGraphics();
        graphics.drawImage(imageBuffer, 0, 0, null );
        if(!buffer.contentsLost())
          buffer.show();
	}

	// clear graphics2D
	public void dispose2D() {
		graphics2D.dispose();
	}

	// clear graphics
	public void dispose() {
		graphics.dispose();
	}

	public Window getWindow() {
		return mainWindow;
	}
}
