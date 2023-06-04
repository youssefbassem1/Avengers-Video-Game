package board;



import java.awt.Point;

import model.world.Champion;
import engine.Player;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class championT extends StackPane {
	private champTeam team;
	private String name;
	private Player player;
	private Point loc;
	
	public Point getLoc() {
		return loc;
	}
	public void setLoc(Point loc) {
		this.loc = loc;
	}
	public champTeam getTeam(){
		return team;
	}
	public String getName(){
		return name;
	}
	
	public championT(String name,String team, Point p){
		loc=p;
		this.name=name;
		//relocate(x*BoardGame.TILE_SIZE,y*BoardGame.TILE_SIZE);
		
		Ellipse bg=new Ellipse(BoardGame.TILE_SIZE*0.3125,BoardGame.TILE_SIZE*0.26 );
		bg.setFill(Color.BLACK);
		bg.setStroke(Color.BLACK);
		bg.setStrokeWidth(BoardGame.TILE_SIZE*0.03); 
		
		bg.setTranslateX(BoardGame.TILE_SIZE-BoardGame.TILE_SIZE*0.3125);
		bg.setTranslateY(BoardGame.TILE_SIZE-BoardGame.TILE_SIZE*0.26+BoardGame.TILE_SIZE*0.07);
		
		Ellipse ellipse=new Ellipse(BoardGame.TILE_SIZE*0.3125,BoardGame.TILE_SIZE*0.26 );
		ellipse.setFill(team.equals("t1")? Color.LIGHTGRAY: Color.DARKVIOLET);
		ellipse.setStroke(Color.BLACK);
		ellipse.setStrokeWidth(BoardGame.TILE_SIZE*0.03); 
		
		ellipse.setTranslateX(BoardGame.TILE_SIZE-BoardGame.TILE_SIZE*0.3125);
		ellipse.setTranslateY(BoardGame.TILE_SIZE-BoardGame.TILE_SIZE*0.26);
		
		getChildren().addAll(bg,ellipse);
	}

}