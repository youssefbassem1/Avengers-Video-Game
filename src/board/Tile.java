package board;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {
	
	private championT champion;
	public boolean hasChamp(){
		return champion !=null;
	}
	public championT getChampion(){
		return champion;
	}
	public void setChampion(championT champion){
		this.champion=champion;
	}
	
	public Tile(boolean light, int x, int y){
		setWidth(BoardGame.TILE_SIZE);
		setHeight(BoardGame.TILE_SIZE);
		
		relocate(x*BoardGame.TILE_SIZE,y*BoardGame.TILE_SIZE);
		setFill(light? Color.DARKGRAY:Color.BEIGE);
	}

}
