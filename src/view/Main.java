package view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.sun.media.jfxmediaimpl.platform.Platform;

import board.Tile;
import controller.Controller;
import controller.KeyControl;
import model.abilities.Ability;
import model.world.Champion;
import engine.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.stage.Popup;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Main extends Application {
	// private Game game;
	private Stage window;
	Tooltip t1,t2,t3,t4,c1,c2,c3,c4,c5,c6;
	public Tooltip getT4() {
		return t4;
	}
	public Tooltip getC4() {
		return c4;
	}
	public Tooltip getC5() {
		return c5;
	}
	public Tooltip getC6() {
		return c6;
	}
	public Tooltip getC1() {
		return c1;
	}
	public Tooltip getC2() {
		return c2;
	}
	public Tooltip getC3() {
		return c3;
	}
	
	private Scene scene2, scene3,scene4;
	private TextField name1, name2;
	private GridPane grid,board;
	private BorderPane l2, l3,l4;
	private Text description,ChampNames,effect;
	private Button next,ready,tog1,tog2,tog3,tog4;
	public Button getTog4() {
		return tog4;
	}

	private HBox click,bar,bar1,current,priority,abilities;
	public HBox getAbilities() {
		return abilities;
	}

	private CheckBox box1,box2,box3,box4,box5,box6;
	private ArrayList<CheckBox> checkArray;
	private ArrayList<Button> boardButtons;
	private Effect glow;
	private VBox players;
	private Controller controller;
	private MediaPlayer mediaPlayer;
	public Controller getController() {
		return controller;
	}

	private Popup popup,pop;
	//private Media attack;
	public  MediaPlayer playAttack;
	
	public TextField getName1() {
		return name1;
	}
	public TextField getName2() {
		return name2;
	}
	
	public Popup getPop() {
		return pop;
	}
	public HBox getBar() {
		return bar;
	}
	public HBox getBar1() {
		return bar1;
	}
	public Button getTog1() {
		return tog1;
	}
	public Button getTog2() {
		return tog2;
	}
	public Button getTog3() {
		return tog3;
	}
	private ToggleGroup  toggleGroup;

	public ToggleGroup getToggleGroup() {
		return toggleGroup;
	}
	public Popup getPopup() {
		return popup;
	}
	public ArrayList<Button> getBoardButtons() {
		return boardButtons;
	}
	public GridPane getBoard() {
		return board;
	}

	public Stage getWindow() {
		return window;
	}
	public ArrayList<CheckBox> getCheckArray(){
		return checkArray;
	}
	public Button getnext() {
		return next;
	}
	public Button getReady() {
		return ready;
	}
	
	public Text getDescription() {
		return description;
	}

	public Scene getScene2() {
		return scene2;
	}

	public Scene getScene3() {
		return scene3;
	}
	public Scene getScene4() {
		return scene4;
	}

	public String getP1() {

		return name1.getText();
	}

	public String getP2() {
		return name2.getText();
	}

	public void start(Stage window) throws IOException, InterruptedException {
		window.setFullScreen(true);
		Image logo = new Image("logo.jpg");
		window.getIcons().add(logo);
		window.setTitle("Marvel Game");
		
//		 Media sound= new Media(new File("music.mp3").toURI().toString());	
		 Media sound= new Media(new File("sound.mp4").toURI().toString());	
		 mediaPlayer=new MediaPlayer(sound);
	     mediaPlayer.setAutoPlay(true);
		 mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		 mediaPlayer.play();
//		 MediaView video = new MediaView(mediaPlayer);
		 
//		mediaPlayer.setVolume(1000);
//		System.out.println(mediaPlayer.isMute());
//		System.out.println(mediaPlayer.getVolume());
		
		// SCENE1
//		Screen screen = Screen.getPrimary();
//		Rectangle2D bounds = screen.getVisualBounds();
//		window.setX(bounds.getMinX());
//		window.setY(bounds.getMinY());
//		window.setWidth(bounds.getWidth());
//		window.setHeight(bounds.getHeight());

		GridPane root = new GridPane();
		
//		root.getChildren().add(video);
		
		root.setStyle("-fx-background-image: url(" + "Back.jpg" + "); "
				+ "-fx-background-size: cover;");

		Text text = new Text();
		text.setText("Please Enter the Team Names");
		text.setX(500);
		text.setY(480);
		text.setFont(Font.font("COPPERPLATE GOTHIC BOLD", 50));
		text.setFill(Color.GREY);
		text.setStyle("-fx-font-weight: bold;");
		glow = new Glow(3);
		text.setEffect(glow);
		
		name1 = new TextField();
		name1.setPromptText("Team 1 Name");
		name1.setPrefSize(300, 60);
		name1.setFont(Font.font("COPPERPLATE GOTHIC BOLD", FontWeight.BOLD, 30));
		name2 = new TextField();
		name2.setPromptText("Team 2 Name");
		name2.setPrefSize(300, 60);
		name2.setFont(Font.font("COPPERPLATE GOTHIC BOLD",FontWeight.BOLD, 30));
//		System.out.println("before");
		Button b = new Button("START");
		b.setStyle("-fx-text-fill: grey");
		// /////////b.setStyle("logo.jpg");
		b.setId("b");
		b.setFont(Font.font("COPPERPLATE GOTHIC BOLD", 40));
		Text n1 = new Text();
		Text n2 = new Text();
		controller= new Controller(this);
		b.setOnAction(controller);
		root.setOnKeyPressed(controller.getKeyControl());
		// n1.setText(name1.getText());
		// n2.setText(name2.getText());
		// window.setScene(scene2);
		// window.setFullScreen(!window.isFullScreen());
//		System.out.println("after");
		HBox names = new HBox(20);
		VBox start = new VBox(10);

		names.setPadding(new Insets(50, 50, 50, 135));
		names.getChildren().addAll(name1, name2);
		start.getChildren().addAll(text, names, b);
		start.setAlignment(Pos.CENTER);
		root.getChildren().addAll(start);
		// root.setBottom(start);
		root.setAlignment(Pos.BOTTOM_RIGHT);
		root.setPadding(new Insets(0,100,400,0));
		GridPane.setHalignment(start, HPos.CENTER);
		GridPane.setValignment(start, VPos.CENTER);
		// root.getChildren().addAll(text);
		window.setScene(new Scene(root));
		window.show();

		// ////EMPTY PLAYERSSSSSS
//		 Player p1 = new Player(n1.getText());
//		 Player p2 = new Player(n2.getText());
//		 handle = new Controller(this, p1, p2);

		// scene 2!!!!!!!!!
		l2 = new BorderPane();
		scene2 = new Scene(l2);
		BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO,
				BackgroundSize.AUTO, false, false, true, false);
		Image wall = new Image("smoke.jpg");
		Background background2 = new Background(new BackgroundImage(wall,
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, bSize));
		l2.setBackground(background2);

		// grid = new GridPane();
		// grid.setAlignment(Pos.CENTER);
		// grid.setHgap(10);
		// grid.setVgap(10);
		// Text description = new Text();
		// description.setFont(Font.font("Cooper Black", 40));
		// description.setFill(Color.WHITESMOKE);
		// description.setStyle("-fx-font-weight: bold;");
		// description.setEffect(glow);


		description = new Text();
		description.setFont(Font.font("COPPERPLATE GOTHIC BOLD", 42));
		description.setFill(Color.GRAY);
		description.setStyle("-fx-font-weight: bold;");
		description.setEffect(glow);
		l2.setRight(description);

		Text title = new Text();
		title.setText("Please select 3 Champions for each Player by turn");
		// title.setX(100);
		// title.setY(480);
		title.setFont(Font.font("COPPERPLATE GOTHIC BOLD", 60));
		title.setFill(Color.GRAY);
		title.setStyle("-fx-font-weight: bold;");
		title.setEffect(glow);
		l2.setTop(title);
		l2.setRight(description);
		l2.setPadding(new Insets(20, 250, 80, 30));
		BorderPane.setAlignment(title, Pos.CENTER_LEFT);

		next = new Button("NEXT");
		next.setId("next");
		next.setFont(Font.font("COPPERPLATE GOTHIC BOLD", 45));
		next.setVisible(false);
		next.setStyle("-fx-text-fill: grey");
		next.setOnAction(controller);
		l2.setBottom(next);
		BorderPane.setAlignment(next, Pos.CENTER);

		// SCENE3!!!!!!!!!!
		l3 = new BorderPane();
		scene3 = new Scene(l3);
		Text title1 = new Text();
		title1.setText("Please choose your team leader");
		title1.setFont(Font.font("COPPERPLATE GOTHIC BOLD", 75));
		title1.setFill(Color.GRAY);
		title1.setStyle("-fx-font-weight: bold;");
		title1.setEffect(glow);
		l3.setTop(title1);
		l3.setPadding(new Insets(60,60,60,60));
		BorderPane.setAlignment(title1, Pos.TOP_CENTER);
		
		l3.setBackground(background2);
		Button ready=new Button();
		ready.setText("Let's Fight");
		ready.setId("ready");
		ready.setStyle("-fx-text-fill: grey");
		BorderPane.setAlignment(ready, Pos.CENTER);
		ready.setFont(Font.font("COPPERPLATE GOTHIC BOLD", 60));
//		ready.setVisible(false);
		l3.setBottom(ready);
//		l3.getChildren().add(ready);
		ready.setOnAction(controller);
//		l3.getChildren().add(title1);
		l3.setPadding(new Insets(40,40,40,40));

//		SCENE4!!!!!!!!!!!!!!!!
		l4 = new BorderPane();
		scene4 = new Scene(l4);
		l4.setBackground(background2);
		StackPane sp= new StackPane();
		board = new GridPane();
		board.setAlignment(Pos.CENTER);
		board.setVisible(true);
		boardButtons= new ArrayList<Button>();
		int j=0;
		int k=5;
		for(int i=0; i<25; i++){
			Button x= new Button();
		
			boardButtons.add(x);
			x.setId("board");
			x.setOnAction(controller);
			x.setPrefHeight(135);
			x.setPrefWidth(135);
			GridPane.setConstraints(x, j, k);
			j++;
			if (j == 5) {
				k--;
				j = 0;
			}
			board.getChildren().add(x);
//			scene4.setOnKeyPressed(new KeyControl(this, new Controller(this)));
		}
		ImageView iv= new ImageView(new Image("ground.png"));
		sp.getChildren().add(iv);
		sp.getChildren().add(board);
		l4.setCenter(sp);
		TextField BoardText = new TextField();
		BoardText.setPrefSize(300, 60);
		BoardText.setFont(Font.font("COPPERPLATE GOTHIC BOLD", FontWeight.BOLD, 30));
		
		HBox controls= new HBox();
		Button leader= new Button("Leader Ability");
		leader.setFont(Font.font("COPPERPLATE GOTHIC BOLD", 30));
		leader.setId("leader");
		leader.setStyle("-fx-text-fill: grey");
		leader.setPrefHeight(80);
		leader.setPrefWidth(350);
		leader.setOnAction(controller);
		Button end= new Button("End Turn");
		end.setId("end");
		end.setFont(Font.font("COPPERPLATE GOTHIC BOLD", 30));
		end.setOnAction(controller);
		end.setStyle("-fx-text-fill: grey");
		end.setPrefHeight(80);
		end.setPrefWidth(350);
		controls.getChildren().addAll(leader,end);
		controls.setAlignment(Pos.BOTTOM_RIGHT);
//		l4.setBottom(controls);
//		l4.setPadding(new Insets(20,20,20,20));
		
		current = new HBox();
		players=new VBox();
		
		tog1= new Button("Ability 1");
		tog1.setId("1");
		tog1.setStyle("-fx-text-fill: grey");
		tog1.setFont(Font.font("COPPERPLATE GOTHIC BOLD", 30));
		tog1.setPrefHeight(80);
		tog1.setPrefWidth(300);
//		tog1.setOnMouseMoved(value);
		t1=new Tooltip();

		
		tog1.setTooltip(t1);
		tog1.setOnAction(controller);

		tog2= new Button("Ability 2");
		tog2.setId("2");
		tog2.setStyle("-fx-text-fill: grey");
		tog2.setFont(Font.font("COPPERPLATE GOTHIC BOLD", 30));
		tog2.setPrefHeight(80);
		tog2.setPrefWidth(300);
		tog2.setOnAction(controller);
		t2=new Tooltip();

		tog2.setTooltip(t2);
//		tog2.setOnMouseMoved();
		tog3= new Button("Ability 3");
		tog3.setId("3");
		tog3.setStyle("-fx-text-fill: grey");
		tog3.setPrefHeight(80);
		tog3.setFont(Font.font("COPPERPLATE GOTHIC BOLD", 30));
		tog3.setPrefWidth(300);
		tog3.setOnAction(controller);
		t3=new Tooltip();
		tog3.setTooltip(t3);
		tog4=new Button("PUNCH");
		tog4.setVisible(false);
		tog4.setId("4");
		tog4.setStyle("-fx-text-fill: grey");
		tog4.setPrefHeight(80);
		tog4.setFont(Font.font("COPPERPLATE GOTHIC BOLD", 20));
		tog4.setPrefWidth(200);
		tog4.setOnAction(controller);
		t4=new Tooltip();
		tog4.setTooltip(t4);
//		tog3.setOnMouseMoved(value);
		abilities= new HBox(tog1,tog2,tog3,tog4);
//		abilities.getChildren().addAll(leader,end);
		abilities.setAlignment(Pos.BOTTOM_LEFT);
		click= new HBox(100);
		click.setSpacing(50);
		click.setMinSize(1650, 100);
		click.setMaxSize(1650, 100);
//		click.setAlignment(Pos.BOTTOM_CENTER);
//		l4.setBottom(abilities);
//		l4.setBottom(click);
//		click.setPadding(new Insets(0,200,0,200));
		
		bar= new HBox();
		bar.setPrefHeight(50);
		bar.setMaxSize(350, 50);
		bar.setMinSize(350, 50);
		bar.setAlignment(Pos.BOTTOM_CENTER);
		bar1= new HBox();
		bar1.setPrefHeight(50);
		bar1.setMaxSize(350, 50);
		bar1.setMinSize(350, 50);
		bar1.setAlignment(Pos.BOTTOM_CENTER);
		VBox v=new VBox();
		Text cap=new Text("Current Action Points");
		cap.setTranslateX(30);
		cap.setEffect(glow);
		cap.setFill(Color.GRAY);;
		cap.setFont(Font.font("COPPERPLATE GOTHIC BOLD", 25));
		Text mana=new Text("Mana");
		mana.setTranslateX(130);
		mana.setEffect(glow);
		mana.setFill(Color.GRAY);
		mana.setFont(Font.font("COPPERPLATE GOTHIC BOLD", 25));
		v.getChildren().addAll(cap,bar,mana,bar1);
		click.getChildren().add(controls);
		click.getChildren().add(v);
		click.getChildren().add(abilities);
		click.setTranslateY(-50);
		click.setTranslateX(20);
		
//		bar.setAlignment(Pos.BOTTOM_CENTER);
		l4.setBottom(click);
		
		c1=new Tooltip();
		c2=new Tooltip();
		c3=new Tooltip();
		c4=new Tooltip();
		c5=new Tooltip();
		c6=new Tooltip();
		priority=new HBox();
		l4.setTop(priority);
//		Media attack=new Media(getClass().getResource("Punch.mp3").toExternalForm());
		
//		playAttack=new MediaPlayer(attack);
//		playAttack.setAutoPlay(true);
//		playAttack.setCycleCount(MediaPlayer.INDEFINITE);
		 
	}
	public BorderPane getL4() {
		return l4;
	}
	//public Media getAttack() {
		//return attack;
	//}
	//public MediaPlayer getPlayAttack() {
		//return playAttack;
	//}
	public Tooltip getT1() {
		return t1;
	}
	public Tooltip getT2() {
		return t2;
	}
	public Tooltip getT3() {
		return t3;
	}
	public void pop(Exception e){
		String s = "-fx-border-color: black;\n"
				+ "-fx-border-insets: 1;\n" + "-fx-border-width: 7;\n"+" -fx-background-color: #F2E38E;";
		pop= new Popup();
		Button z= new Button("Close");
		z.setAlignment(Pos.CENTER);
		z.setId("close");
		z.setOnAction(controller);
		Label l= new Label(e.getMessage());
		Text t= new Text("ERROR");
		t.setFont(Font.font("Cooper Black",20));
		t.setFill(Color.RED);
		t.setStyle("-fx-font-weight: bold;");
		VBox v= new VBox();
		v.setPrefHeight(170);
		v.setPrefWidth(380);
		v.setStyle(s);
		v.setAlignment(Pos.CENTER);
		v.getChildren().addAll(t,l,z);
		pop.getContent().add(v);
		pop.show(l4, 720, 450);
//		pop.show(window);
		pop.centerOnScreen();
		pop.setAutoHide(true);
	}
	public void hidePop(){
		pop.hide();
	}
	public void keyBoard(Scene s) throws IOException{
//		System.out.println("keyBoard");
		s.setOnKeyPressed(controller.getKeyControl());
	}
	

	public void addChampions(ArrayList<Button> b,ArrayList<Button> s) throws IOException {
//		System.out.println("dsj");
//		System.out.println(b.size());
		ArrayList<String> photos = new ArrayList<String>();
		photos.add("camerica.png");
		photos.add("deadpool.png");
		photos.add("dstrange.png");
		photos.add("electro.png");
		photos.add("rider.png");
		photos.add("hela.png");
		photos.add("hulk.png");
		photos.add("ice.png");
		photos.add("ironman.png");
		photos.add("loki.png");
		photos.add("silver.png");
		photos.add("spiderman.png");
		photos.add("thor.png");
		photos.add("venom.png");
		photos.add("yellow.png");

		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setVisible(true);
		int count = 0;
		int k = 0;
		int j = 0;
		for (int i = 0; i < photos.size(); i++) {
			ImageView imag = new ImageView(photos.get(i));
			imag.setFitWidth(189);
			imag.setPreserveRatio(true);
			b.get(i).setAlignment(Pos.CENTER);
			b.get(i).setOnAction(controller);
			b.get(i).setFont(Font.font("COPPERPLATE GOTHIC BOLD", 25));
			b.get(i).setStyle("-fx-text-fill: grey");
			s.get(i).setOnAction(controller);
			s.get(i).setAlignment(Pos.CENTER);
			s.get(i).setFont(Font.font("COPPERPLATE GOTHIC BOLD", 25));
//			s.get(i).setStyle("-fx-text-fill: grey");
			// Button select = new Button("SELECT");
			// select.setId("select");
			// select.setE
			// select.setAlignment(Pos.CENTER);
			// // select.setOnAction(e -> {
			// // addToTeam(nameChamp, p1, p2, champs);
			// // select.setDisable(true);
			// // if(p1.getTeam().size()==3 && p2.getTeam().size()==3){
			// // next.setVisible(true);}});
			// select.setOnAction(new KeyControl(this, handle));

			VBox vbox = new VBox();
			vbox.setAlignment(Pos.CENTER);
			vbox.getChildren().addAll(b.get(i), imag, s.get(i));
			String cssLayout = "-fx-border-color: grey;\n"
					+ "-fx-border-insets: 5;\n" + "-fx-border-width: 3;\n";
			vbox.setStyle(cssLayout);
			GridPane.setConstraints(vbox, j, k);
			// grid.getChildren().add(vbox);
			j++;
			if (j == 5) {
				k++;
				j = 0;
			}
			grid.getChildren().add(vbox);
			l2.setLeft(grid);
			l2.setPadding(new Insets(10,10,10,50));
		}

		// grid.setMaxSize(Double.MAX_VALUE, Double.MIN_VALUE);
		// grid.setPrefHeight(500);
		// grid.setPrefWidth(500);
		// grid.setPadding(new Insets(0,0,0,30));
		// grid.setBackground(new Background(new BackgroundFill(Color.rgb(140,
		// 200, 140), new CornerRadii(0), new Insets(0))));
		// l2.setLeft(grid);

	}

	public void moveScene2() {
		window.setScene(scene2);
	}
	public void LeaderBox(ArrayList<CheckBox> check,HBox h) throws IOException{
//		VBox vbox1=new VBox();
//		VBox vbox2=new VBox();
		checkArray=check;
		String s= "-fx-border-color: white;\n"
				+ "-fx-border-insets: 5;\n" + "-fx-border-width: 3;\n";
//		Effect glow = new Glow(0.8);
//		Text text5=new Text("Team 1");
//		text5.setFont(Font.font("Cooper Black", 60));
//		text5.setFill(Color.WHITESMOKE);
//		text5.setStyle("-fx-font-weight: bold;");
//		text5.setEffect(glow);
//		
//		Text text6=new Text("Team 2");
//		text6.setFont(Font.font("Cooper Black", 60));
//		text6.setFill(Color.WHITESMOKE);
//		text6.setStyle("-fx-font-weight: bold;");
//		text6.setEffect(glow);
//		vbox1.getChildren().addAll(text5);
//		vbox2.getChildren().add(text6);
//		for(int i=0;i<check.size()/2; i++){			
//			vbox1.getChildren().add(check.get(i));
//			vbox2.getChildren().add(check.get(check.size()-1-i));
//		}
		box1=check.get(0);
		box2=check.get(1);
		box3=check.get(2);
		box4=check.get(3);
		box5=check.get(4);
		box6=check.get(5);
		
		for(int i=0;i<check.size();i++){
			check.get(i).setPadding(new Insets(30,30,30,30));
//			check.get(i).setPrefSize(100,40);
			check.get(i).setFont(Font.font(30));
//			check.get(i).setStyle(s);
			check.get(i).setOnAction(controller);
		}
//		vbox1.setAlignment(Pos.CENTER);
//		vbox2.setAlignment(Pos.CENTER);
//		HBox hbox=new HBox();
//		hbox.setPadding(new Insets(30,30,30,30));
//		hbox.getChildren().addAll(vbox1,vbox2);
//		hbox.setAlignment(Pos.CENTER);
		l3.setCenter(h);
		
		
	}
	public void champInfo(String s){
//		Stage pop= new Stage();
//		Image logo = new Image("logo.jpg");
//		pop.getIcons().add(logo);
//		pop.setTitle("Champion Details");
//		pop.setHeight(500);
//		pop.setWidth(500);
//		pop.show();
		String x =  "-fx-background-color: #FAE8C6;";
		Button z= new Button("Close");
		z.setAlignment(Pos.CENTER);
		z.setId("close");
		z.setOnAction(controller);
        Label label = new Label(s);
        Popup popup = new Popup();
//        label.setStyle(" -fx-background-color: #FAE8C6;");
        popup.getContent().add(label);	
        label.setMinWidth(100);
        label.setMinHeight(100);
        label.setMaxSize(100, 100);
        popup.show(l4, 300, 300);
//		popup.setAutoHide(true);
		VBox v= new VBox();
		v.setPrefHeight(100);
		v.setPrefWidth(100);
		v.setStyle(x);
		v.setAlignment(Pos.CENTER);
		v.getChildren().addAll(label,z);
		popup.getContent().add(v);
        
        
        
		
	}
	public void addPriority(Text t){
		ChampNames=t;
		ChampNames.setFont(Font.font("COPPERPLATE GOTHIC BOLD", 40));
		ChampNames.setFill(Color.GRAY);
		ChampNames.setStyle("-fx-font-weight: bold;");
//		ChampNames.setEffect(glow);
		l4.setTop(ChampNames);

	}
	public void addCurrent(HBox t){
		current=t;
		current.setTranslateY(200);
		current.setTranslateX(-200);
		l4.setRight(current);

	}
	public void addTeam(VBox v){
		players.getChildren().clear();
		players.getChildren().addAll(v);
		players.setStyle("-fx-font-weight: bold;");
//		players.setEffect(glow);
		l4.setLeft(players);

	}
	public void addEffect(Text t){
		players.getChildren().add(t);
	}
	

	public CheckBox getBox1() {
		return box1;
	}
	public CheckBox getBox2() {
		return box2;
	}
	public CheckBox getBox3() {
		return box3;
	}
	public CheckBox getBox4() {
		return box4;
	}
	public CheckBox getBox5() {
		return box5;
	}
	public CheckBox getBox6() {
		return box6;
	}
	public void Priority(HBox h){
		priority=h;
		l4.setTop(priority);
		priority.setTranslateX(470);
		priority.setTranslateY(20);
	}
	public void endGame(){
		javafx.application.Platform.exit();
	}
	public static void main(String[] args) {
		launch(args);
	}


}
