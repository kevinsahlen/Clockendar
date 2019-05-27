import java.awt.MouseInfo;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.WeekFields;
import java.util.Locale;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class ClockGraphics extends Canvas {
	
	//.start
	//--> handle
	//.stop
	
	private GraphicsContext gx;
	private GraphicsContext gxbg;
	private boolean blocking;
	
	ClockGraphics(Canvas saveCanvas){
		
		//TODO fix fullscreen
		setWidth(1000);
		setHeight(1000);
		saveCanvas.setWidth(getWidth());
		saveCanvas.setHeight(getHeight());
		gx = getGraphicsContext2D();
		gxbg = saveCanvas.getGraphicsContext2D();
	}//constructor
	
	private void arcDrawer(GraphicsContext gz, double radie, double startAngle, double arcExtent) {
		gz.strokeArc(getWidth()/2-radie, getHeight()/2-radie, radie*2, radie*2, Math.toDegrees(Math.PI/2-startAngle), Math.toDegrees(-arcExtent), ArcType.OPEN);
	}
	
	public void drawBG() {
		//draw BG, day indicator and DB Objects
		gxbg.clearRect(0, 0, getWidth(), getHeight());
		gxbg.setFill(Color.rgb(20,20,20));
		gxbg.fillRect(0, 0, getWidth(), getHeight());
		gxbg.setLineCap(StrokeLineCap.BUTT);
		
//SET FONT AND DRAW YEAR NUMBER
		gxbg.setTextBaseline(VPos.CENTER);
		gxbg.setFont(new Font("Impact Regular", 32));
		gxbg.setTextAlign(TextAlignment.CENTER);
		gxbg.setFill(Color.WHITE);
		gxbg.setLineWidth(2);
		
		gxbg.fillText(Year.now()+"",500, 500);
		
		
		for (LocalDate date = Year.now().atDay(1); date.isBefore(Year.now().plusYears(1).atDay(1)); date = date.plusDays(1)) {
	        if (date.getDayOfMonth() == 1) {
				//TODO
			}
	    }
	}
	
	public void createEvent() {
		blocking = false;
		new ClockAnimator(this) { //defined class that extends TimerTask to pass values in the constructor. refer to this as canvas
			@Override
			public void handle(long now) {
				
				//CODE HERE loops
				
				
				//UNTIL HERE
				if (blocking) {
					//CODE HERE runs after loop
					
					
					
					//UNTIL HERE
					stop();
				}//if
			}//handle
		}.start();//ClockAnimator	
	}//createEvent
	
	public void stop() {
		blocking = true;
	}//stop ClockAnimator
	
	public GraphicsContext save(Canvas canvasBg) {
		GraphicsContext gxbg = canvasBg.getGraphicsContext2D();
		return gxbg;
	}//save
	
	
	int ld(){ //TODO delete. use type it out...
		LocalDate ld = LocalDate.now();
		int week = ld.get(WeekFields.ISO.weekOfWeekBasedYear());
		return week;
	}
	
	
	
	
}//class ClockGraphics