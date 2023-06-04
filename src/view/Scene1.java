package view;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Scene1 {
	private AnchorPane mainePane;
	private Scene mainScene;
	private Stage mainStage;
	
	public Scene1 (){
		mainePane=new AnchorPane();
		mainScene=new Scene(mainePane);
		mainStage=new Stage();
		mainStage.setScene(mainScene);
	}
	public Stage getMainStage(){
		return mainStage;
	}

}
