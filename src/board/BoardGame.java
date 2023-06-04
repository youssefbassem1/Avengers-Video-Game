package board;

import engine.Game;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BoardGame extends Application{
	
	public static final int TILE_SIZE=100;
	public static final int WIDTH=Game.getBoardwidth();
	public static final int HEIGHT=Game.getBoardheight();
	private Group tileGroup=new Group();
	private Group championGroup=new Group();
	
	public Parent createContent(){
		Pane root=new Pane();
		root.setPrefSize(WIDTH*TILE_SIZE, HEIGHT*TILE_SIZE);
		root.getChildren().addAll(tileGroup,championGroup);
		for(int i=0; i<HEIGHT;i++){
			for(int j=0; j<WIDTH;j++){
				Tile tile=new Tile((i+j)%2==0,i,j);
				tileGroup.getChildren().add(tile);
			}
		}
		
		
		return root;
	}
	
	public void start (Stage primaryStage) throws Exception{
		Scene scene=new Scene(createContent());
		primaryStage.setTitle("Board");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
//	private championT makeChampion(champTeam team, int x , int y){
//		championT champion=new championT(team,x,y);
//		return champion;
//	}
	
	public static void main(String[] args){
		launch(args);
	}

}
