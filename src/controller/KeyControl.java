package controller;

import java.io.IOException;
import java.util.ArrayList;

import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.world.Champion;
import model.world.Cover;
import model.world.Direction;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import view.Main;
import engine.Game;
import engine.Player;
import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;

public class KeyControl implements EventHandler<KeyEvent> {
	private static Game game;
	private Main view;
	private boolean direction;
	private Controller controller;
	private int abNum;
	private Button z;

	public KeyControl(Main view, Game g) {
		// System.out.println("key constructor");
		this.view = view;
		game = g;
		controller= view.getController();
	}

	public void handle(KeyEvent event) {
		if (event.getCode().equals(KeyCode.ENTER)) {
			if (view.getName1().getText() != null&& view.getName2().getText() != null)
				handleStart(event);
		}
		if (event.getCode().equals(KeyCode.UP)) {
			if (direction) {
				direction = false;
				try {
					game.castAbility(game.getCurrentChampion().getAbilities()
							.get(abNum), Direction.UP);
					RealBoard();
				} catch (NotEnoughResourcesException e) {
					error(e);
					e.printStackTrace();
				} catch (AbilityUseException e) {
					error(e);
					e.printStackTrace();
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
			} else {
				try {
					game.move(Direction.UP);
					RealBoard();
				} catch (NotEnoughResourcesException e) {
					error(e);
					e.printStackTrace();
				} catch (UnallowedMovementException e) {
					error(e);
					e.printStackTrace();
				}
			}
		}

		if (event.getCode().equals(KeyCode.DOWN)) {
			if (direction) {
				direction = false;
				try {
					game.castAbility(game.getCurrentChampion().getAbilities()
							.get(abNum), Direction.DOWN);
					RealBoard();
				} catch (NotEnoughResourcesException e) {
					error(e);
					e.printStackTrace();
				} catch (AbilityUseException e) {
					error(e);
					e.printStackTrace();
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
			} else {
				try {
					game.move(Direction.DOWN);
					RealBoard();
				} catch (NotEnoughResourcesException e) {
					error(e);
					e.printStackTrace();
				} catch (UnallowedMovementException e) {
					error(e);
					e.printStackTrace();
				}
			}
		}

		if (event.getCode().equals(KeyCode.RIGHT)) {
			if (direction) {
				direction = false;
				try {
					game.castAbility(game.getCurrentChampion().getAbilities()
							.get(abNum), Direction.RIGHT);
					RealBoard();
				} catch (NotEnoughResourcesException e) {
					error(e);
					e.printStackTrace();
				} catch (AbilityUseException e) {
					error(e);
					e.printStackTrace();
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
			} else {
				try {
					game.move(Direction.RIGHT);
					RealBoard();
				} catch (NotEnoughResourcesException e) {
					error(e);
					e.printStackTrace();
				} catch (UnallowedMovementException e) {
					error(e);
					e.printStackTrace();
				}
			}
		}
		if (event.getCode().equals(KeyCode.LEFT)) {
			if (direction) {
				direction = false;
				try {
					game.castAbility(game.getCurrentChampion().getAbilities()
							.get(abNum), Direction.LEFT);
					RealBoard();
				} catch (NotEnoughResourcesException e) {
					error(e);
					e.printStackTrace();
				} catch (AbilityUseException e) {
					error(e);
					e.printStackTrace();
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
			} else {
				try {
					game.move(Direction.LEFT);
					RealBoard();
				} catch (NotEnoughResourcesException e) {
					error(e);
					e.printStackTrace();
				} catch (UnallowedMovementException e) {
					error(e);
					e.printStackTrace();
				}
			}
		}
		if (event.getCode().equals(KeyCode.S)) {
			try {
				game.attack(Direction.DOWN);
				RealBoard();
				view.playAttack.play();
				// AudioClip hit = new
				// AudioClip(getClass().getResource("/resources/Punch.mp3").toString());
				// hit.play();
				// System.out.println(hit.toString());

			} catch (NotEnoughResourcesException e) {
				error(e);
				e.printStackTrace();
			} catch (ChampionDisarmedException e) {
				error(e);
				e.printStackTrace();
			} catch (InvalidTargetException e) {
				error(e);
				e.printStackTrace();
			}
		}
		if (event.getCode().equals(KeyCode.W)) {
			try {
				game.attack(Direction.UP);
				RealBoard();
				view.playAttack.play();
				//view.getPlayAttack().play();
			} catch (NotEnoughResourcesException e) {
				error(e);
				e.printStackTrace();
			} catch (ChampionDisarmedException e) {
				error(e);
				e.printStackTrace();
			} catch (InvalidTargetException e) {
				error(e);
				e.printStackTrace();
			}

		}
		if (event.getCode().equals(KeyCode.D)) {
			try {
				game.attack(Direction.RIGHT);
				RealBoard();
				view.playAttack.play();
//				view.getPlayAttack().play();
			} catch (NotEnoughResourcesException e) {
				error(e);
				e.printStackTrace();
			} catch (ChampionDisarmedException e) {
				error(e);
				e.printStackTrace();
			} catch (InvalidTargetException e) {
				error(e);
				e.printStackTrace();
			}
		}
		if (event.getCode().equals(KeyCode.A)) {
			try {
				game.attack(Direction.LEFT);
				RealBoard();
				view.playAttack.play();
//				view.getPlayAttack().play();
			} catch (NotEnoughResourcesException e) {
				error(e);
				e.printStackTrace();
			} catch (ChampionDisarmedException e) {
				error(e);
				e.printStackTrace();
			} catch (InvalidTargetException e) {
				error(e);
				e.printStackTrace();
			}

		}
	}

	public void handleStart(KeyEvent event) {
		Stage window = (Stage) ((Button) event.getSource()).getScene()
				.getWindow();
		window.setScene(view.getScene2());
		window.setFullScreen(!window.isFullScreen());
		Player p1 = new Player(view.getP1());
		Player p2 = new Player(view.getP2());
		game = new Game(p1, p2);
		try {
			game.loadAbilities("Abilities.csv");
			game.loadChampions("Champions.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<Champion> champs = game.getAvailableChampions();
		ArrayList<Button> btnNames = new ArrayList<Button>();
		ArrayList<Button> btnSelect = new ArrayList<Button>();

		for (Champion c : champs) {
			Button name = new Button();
			name.setId("name");
			name.setText(c.getName());
			// name.setOnAction(this);
			btnNames.add(name);

			Button select = new Button("Select");
			select.setId(c.getName());
			// select.setOnAction(new KeyWithString(view, this, c.getName()));
			btnSelect.add(select);

		}
		try {
			view.addChampions(btnNames, btnSelect);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void RealBoard() {
//		view.getT1().setText(controller.Ability1());
//		view.getT2().setText(controller.Ability2());
//		view.getT3().setText(controller.Ability3());
//		if(game.getCurrentChampion().getAbilities().size()==4){
//			view.getT4().setText(controller.Ability4());
//		}
//
//		view.getC1().setText(controller.Champion1());
//		view.getC2().setText(controller.Champion2());
//		view.getC3().setText(controller.Champion3());
//		view.getC4().setText(controller.Champion4());
//		view.getC5().setText(controller.Champion5());
//		view.getC6().setText(controller.Champion6());
//		
//		ArrayList<Button> a = view.getBoardButtons();
//		Object[][] b = game.getBoard();
//		int k = 0;
//		ImageView v;
//		String style = "";
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 5; j++) {
//				if (b[i][j] == null) {
//					a.get(k).setGraphic(null);
//					a.get(k).setText(null);
//					a.get(k).setStyle(null);
//				}
//				if (b[i][j] instanceof Cover) {
//					// a.get(k).setText("COVER");
//					v = CoverIcon((Cover) b[i][j]);
//					a.get(k).setGraphic(v);
//					String s = ((Cover) b[i][j]).getCurrentHP() + "";
//					style = "-fx-alignment: bottom-center; -fx-content-display: top";
//					a.get(k).setText(s);
//					a.get(k).setStyle(style);
//				} else if (b[i][j] instanceof Champion) {
//					if ((Champion) b[i][j] == game.getCurrentChampion())
//						a.get(k)
//								.setStyle(
//										"-fx-border-color: red; -fx-background-color: lightgray;");
//					v = ChampIcon((Champion) b[i][j]);
//					a.get(k).setGraphic(v);
//					String s = ((Champion) b[i][j]).getCurrentHP() + "/"
//							+ ((Champion) b[i][j]).getMaxHP();
//					a.get(k).setText(s);
//					if (game.getFirstPlayer().getTeam()
//							.contains(((Champion) b[i][j]))) {
//						style = "-fx-alignment: bottom-center; -fx-content-display: top; -fx-background-color:#ABADF3;";
//					} else {
//						style = "-fx-alignment: bottom-center; -fx-content-display: top; -fx-background-color:#EAC3C5;";
//					}
//					a.get(k).setStyle(style);
//				}
//				k++;
//			}
//		}
//		if(game.checkGameOver()!=null){
//			Player p=game.checkGameOver();
//			pop(p);
//		}
//		ActionPoints();
//		controller.Teams();
//		controller.toStringEffect();
		controller.RealBoard();
	}
	public void pop(Player p){
//		String s = "-fx-border-color: black;\n"
//				+ "-fx-border-insets: 1;\n" + "-fx-border-width: 7;\n"+" -fx-background-color: #F2E38E;";
//		Popup pop= new Popup();
//		z= new Button("END GAME");
//		z.setAlignment(Pos.CENTER);
//		z.setId("endgame");
//		z.setOnAction(controller);
//		Label l= new Label(p.getName());
//		Text t= new Text("Congratulations!!!!");
//		t.setFont(Font.font("Cooper Black",20));
//		t.setFill(Color.RED);
//		t.setStyle("-fx-font-weight: bold;");
//		VBox v= new VBox();
//		v.setPrefHeight(600);
//		v.setPrefWidth(600);
//		v.setStyle(s);
//		v.setAlignment(Pos.CENTER);
//		v.getChildren().addAll(l,t,z);
//		pop.getContent().add(v);
//		pop.show(view.getL4(), 720, 450);
////		pop.show(window);
//		pop.centerOnScreen();
//		pop.setAutoHide(true);
		controller.pop(p);
	}
	public void ActionPoints() {
		String s = "-fx-border-color: white;\n";
		HBox h = view.getBar();
		h.getChildren().clear();
		h.setPrefHeight(50);
		h.setMaxSize(350, 50);
		// h.setStyle(s);
		Champion c = game.getCurrentChampion();
		int a = c.getCurrentActionPoints();
		System.out.println("CAP" + a);
		for (int i = 0; i < a; i++) {
			ImageView v = new ImageView(new Image("actionpoint.png"));
			// Rectangle r= new Rectangle();
			// // r.setStyle(s);
			// r.setFill(Color.BLUE);
			// r.setStrokeType(StrokeType.CENTERED);
			// r.setWidth(50);
			// r.setHeight(50);
			h.getChildren().add(v);
		}

	}

	public void error(Exception e) {
		view.pop(e);
	}

	public ImageView ChampIcon(Champion c) {
		ImageView i = null;
		if (c.getName().equals("Captain America"))
			i = new ImageView(new Image("iconcaptain.png"));
		else if (c.getName().equals("Deadpool"))
			i = new ImageView(new Image("icondeadpool.png"));
		else if (c.getName().equals("Dr Strange"))
			i = new ImageView(new Image("icondrstrange.png"));
		else if (c.getName().equals("Electro"))
			i = new ImageView(new Image("iconelectro.png"));
		else if (c.getName().equals("Ghost Rider"))
			i = new ImageView(new Image("iconghost.png"));
		else if (c.getName().equals("Hela"))
			i = new ImageView(new Image("iconhela.png"));
		else if (c.getName().equals("Hulk"))
			i = new ImageView(new Image("iconhulk.png"));
		else if (c.getName().equals("Iceman"))
			i = new ImageView(new Image("iconiceman.png"));
		else if (c.getName().equals("Ironman"))
			i = new ImageView(new Image("iconironman.png"));
		else if (c.getName().equals("Loki"))
			i = new ImageView(new Image("iconloki.png"));
		else if (c.getName().equals("Quicksilver"))
			i = new ImageView(new Image("iconquick.png"));
		else if (c.getName().equals("Spiderman"))
			i = new ImageView(new Image("iconspiderman.png"));
		else if (c.getName().equals("Thor"))
			i = new ImageView(new Image("iconthor.png"));
		else if (c.getName().equals("Venom"))
			i = new ImageView(new Image("iconvenom.png"));
		else if (c.getName().equals("Yellow Jacket"))
			i = new ImageView(new Image("iconyellow.png"));
		return i;
	}

	public ImageView CoverIcon(Cover d) {
		ImageView i = new ImageView(new Image("brownwall.png"));
		return i;
	}

	public void handleDirection(ActionEvent event) {
		System.out.println("hhh");
		direction = true;
		abNum = Integer.parseInt(((Button) event.getSource()).getId()) - 1;
	}
}
