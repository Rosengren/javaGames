import java.awt.Image;
import java.util.ArrayList;
import java.lang.String;

public class Animation {

	private ArrayList scenes;
	private int sceneIndex;	//arrayList index
	private long movieTime;
	private long totalTime;

	// Constructor
	public Animation() {
		scenes = new ArrayList();
		totalTime = 0;
		start();
	}

	// Add scene to arrayList and set time for each scene
	public synchronized void addScene(Image i, long t) {
		totalTime += t;
		scenes.add(new OneScene(i, totalTime));
	}

	// Start animation from beginnning
	public synchronized void start() {
		movieTime = 0;
		sceneIndex = 0;
	}

	// Change Scene
	public synchronized void update(long timePassed) {
		if (scenes.size() > 1) {
			movieTime += timePassed;
			if (movieTime >= totalTime) {
				// reset animation
				movieTime = 0;
				sceneIndex = 0;
			}
			while (movieTime > getScene(sceneIndex).endTime) {
				sceneIndex++;
			}
		}
	}

	// Get animation's current scene
	public synchronized Image getImage() {
		if (scenes.size() == 0) {
			return null;
		} else {
			return getScene(sceneIndex).pic;
		}
	}

	// Get scene
	private OneScene getScene(int x) {
		return (OneScene)scenes.get(x);
	}

	// Private Inner Class //

	private class OneScene {
		Image pic;
		long endTime;

		public OneScene(Image pic, long endTime) {
			this.pic = pic;
			this.endTime = endTime;
		}
	}
}