import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
public abstract class ClockAnimator extends AnimationTimer {
	Canvas canvas;
	public ClockAnimator(Canvas canvas) {
		this.canvas = canvas;
	}
}
