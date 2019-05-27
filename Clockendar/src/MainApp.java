import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainApp extends Application {


	@Override
	public void start(Stage stage) throws Exception {
		Pane pane = new Pane();
		Canvas bg = new Canvas();
		ClockGraphics clock = new ClockGraphics(bg);
		pane.getChildren().addAll(clock, bg);
		stage.setScene(new Scene(pane));
		stage.show();
		
		clock.drawBG();
	}//start
	
	
	
	public static void main(String[] args) {
		launch();
		
	}//main
}//class MainApp