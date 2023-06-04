package controller;

import java.awt.CheckboxGroup;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import org.xml.sax.ErrorHandler;

import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.effects.EffectType;
import model.world.Champion;
import model.world.Condition;
import model.world.Cover;
import model.world.Damageable;
import model.world.Hero;
import model.world.Villain;
//import view.KeyControl;
import view.KeyWithString;
import view.Main;
import board.BoardGame;
import board.championT;

import com.sun.glass.ui.View;

import engine.Game;
import engine.Player;
import engine.PriorityQueue;
import exceptions.AbilityUseException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class Controller implements EventHandler<ActionEvent> {
	private static Game game, game1;
	private Main view;
	private Effect glow = new Glow(0.8);
	private KeyControl keyControl;
	private ArrayList<String> allChamp;
	private boolean flag;
	private int numAbility;
	private Button z;

	int count = 0;

	// championT card;
	// ArrayList<championT> stack;

	public Game getGame() {
		return game;
	}

	public Game getGame1() {
		return game1;
	}

	public KeyControl getKeyControl() {
		return keyControl;
	}

	// btnsChamps =new ArrayList<>();

	public Controller(Main view) throws IOException {
		this.view = view;
		allChamp = new ArrayList<String>();
		// game = new Game(p1, p2);
		// game.loadAbilities("Abilities.csv");
		// game.loadChampions("Champions.csv");
		//
		// ArrayList<Champion> champs = game.getAvailableChampions();
		// ArrayList<Button> btnNames = new ArrayList<Button>();
		// ArrayList<Button> btnSelect = new ArrayList<Button>();
		//
		// for (Champion c : champs) {
		// Button name = new Button();
		// name.setId("name");
		// name.setText(c.getName());
		// // name.setOnAction(this);
		// btnNames.add(name);
		//
		// Button select = new Button("Select");
		// select.setId("select");
		// select.setOnAction(new KeyWithString(view, this, c.getName()));
		// btnSelect.add(select);
		//
		// }
		// view.addChampions(btnNames, btnSelect);
	}

	public void handle(ActionEvent event) {
		if (event.getSource() instanceof Button) {
			Button button = (Button) event.getSource();
			if (button.getId().equals("b")) {
				handleStart(event);
			} else if (button.getId().equals("next")) {
				handleNext(event);
			} else if (button.getId().equals("name")) {
				handleName(event);
			} else if (button.getId().equals("Captain America")) {
				handleNext1(event);
			} else if (button.getId().equals("Deadpool")) {
				handleNext2(event);
			} else if (button.getId().equals("Dr Strange")) {
				handleNext3(event);
			} else if (button.getId().equals("Electro")) {
				handleNext4(event);
			} else if (button.getId().equals("Ghost Rider")) {
				handleNext5(event);
			} else if (button.getId().equals("Hela")) {
				handleNext6(event);
			} else if (button.getId().equals("Hulk")) {
				handleNext7(event);
			} else if (button.getId().equals("Iceman")) {
				handleNext8(event);
			} else if (button.getId().equals("Ironman")) {
				handleNext9(event);
			} else if (button.getId().equals("Loki")) {
				handleNext10(event);
			} else if (button.getId().equals("Quicksilver")) {
				handleNext11(event);
			} else if (button.getId().equals("Spiderman")) {
				handleNext12(event);
			} else if (button.getId().equals("Thor")) {
				handleNext13(event);
			} else if (button.getId().equals("Venom")) {
				handleNext14(event);
			} else if (button.getId().equals("Yellow Jacket")) {
				handleNext15(event);
			} else if (button.getId().equals("leader")) {
				Leader(event);
			} else if (button.getId().equals("close")) {
				view.hidePop();
			} else if (button.getId().equals("endgame")) {
				// Stage window = (Stage) ((Button)
				// event.getSource()).getScene()
				// .getWindow();
				// window.close();
				view.endGame();
			} else if (button.getId().equals("ready")) {
				try {
					handleReady(event);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (button.getId().equals("board")) {
				handleBoard(event);
			} else if (button.getId().equals("end")) {
				handleEnd(event);
				// } else if (button.getId().equals("mini")) {
				// miniToString(event);

			} else if (button.getId().equals("1")) {
				if (game1.getCurrentChampion().getAbilities().get(0)
						.getCastArea() == AreaOfEffect.SINGLETARGET)
					handleSingle(event);
				else if (game1.getCurrentChampion().getAbilities().get(0)
						.getCastArea() == AreaOfEffect.DIRECTIONAL)
					keyControl.handleDirection(event);
				else
					handleAbility(event);

			} else if (button.getId().equals("2")) {
				if (game1.getCurrentChampion().getAbilities().get(1)
						.getCastArea() == AreaOfEffect.SINGLETARGET)
					handleSingle(event);
				else if (game1.getCurrentChampion().getAbilities().get(1)
						.getCastArea() == AreaOfEffect.DIRECTIONAL)
					keyControl.handleDirection(event);
				else
					handleAbility(event);

			} else if (button.getId().equals("3")) {
				if (game1.getCurrentChampion().getAbilities().get(2)
						.getCastArea() == AreaOfEffect.SINGLETARGET)
					handleSingle(event);
				else if (game1.getCurrentChampion().getAbilities().get(2)
						.getCastArea() == AreaOfEffect.DIRECTIONAL)
					keyControl.handleDirection(event);
				else
					handleAbility(event);
			} else if (button.getId().equals("4")) {
				if (game1.getCurrentChampion().getAbilities().get(3)
						.getCastArea() == AreaOfEffect.SINGLETARGET)
					handleSingle(event);
				else if (game1.getCurrentChampion().getAbilities().get(3)
						.getCastArea() == AreaOfEffect.DIRECTIONAL)
					keyControl.handleDirection(event);
				else
					handleAbility(event);
			}

		} else if (event.getSource() instanceof CheckBox) {
			CheckBox button = (CheckBox) event.getSource();
			if (button.getId().equals("Captain America")) {
				HelperCheck(event);
			} else if (button.getId().equals("Deadpool")) {
				HelperCheck(event);
			} else if (button.getId().equals("Dr Strange")) {
				HelperCheck(event);
			} else if (button.getId().equals("Electro")) {
				HelperCheck(event);
			} else if (button.getId().equals("Ghost Rider")) {
				HelperCheck(event);
			} else if (button.getId().equals("Hela")) {
				HelperCheck(event);
			} else if (button.getId().equals("Hulk")) {
				HelperCheck(event);
			} else if (button.getId().equals("Iceman")) {
				HelperCheck(event);
			} else if (button.getId().equals("Ironman")) {
				HelperCheck(event);
			} else if (button.getId().equals("Loki")) {
				HelperCheck(event);
			} else if (button.getId().equals("Quicksilver")) {
				HelperCheck(event);
			} else if (button.getId().equals("Spiderman")) {
				HelperCheck(event);
			} else if (button.getId().equals("Thor")) {
				HelperCheck(event);
			} else if (button.getId().equals("Venom")) {
				HelperCheck(event);
			} else if (button.getId().equals("Yellow Jacket")) {
				HelperCheck(event);
			}

		}
	}

	private void Leader(ActionEvent event) {
		try {
			game1.useLeaderAbility();
			RealBoard();
		} catch (LeaderNotCurrentException e) {
			// TODO Auto-generated catch block
			error(e);
			e.printStackTrace();
		} catch (LeaderAbilityAlreadyUsedException e) {
			// TODO Auto-generated catch block
			error(e);
			e.printStackTrace();
		}

	}

	private void handleBoard(ActionEvent event) {
		if (flag) {
			flag = false;
			int x = 0;
			int y = 0;
			ArrayList<Button> a = view.getBoardButtons();
			for (int i = 0; i < a.size(); i++) {
				if (a.get(i).equals(event.getSource())) {
					x = (i / 5);
					y = i % 5;
				}
			}
			Champion c = game1.getCurrentChampion();
			String s = ((Button) event.getSource()).getId();
			Ability b = c.getAbilities().get(numAbility);
			try {
				game1.castAbility(b, x, y);
			} catch (NotEnoughResourcesException e) {
				e.printStackTrace();
			} catch (AbilityUseException e) {
				error(e);
				e.printStackTrace();
			} catch (InvalidTargetException e) {
				error(e);
				e.printStackTrace();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RealBoard();
		}

	}

	public void error(Exception e) {
		view.pop(e);
	}

	private void handleSingle(ActionEvent event) {
		flag = true;
		numAbility = Integer.parseInt(((Button) event.getSource()).getId()) - 1;
	}

	private void handleAbility(ActionEvent event) {
		Champion c = game1.getCurrentChampion();
		String s = ((Button) event.getSource()).getId();
		try {
			game1.castAbility(c.getAbilities().get(Integer.parseInt(s) - 1));
		} catch (NotEnoughResourcesException e2) {
			error(e2);
			e2.printStackTrace();
		} catch (AbilityUseException e2) {
			error(e2);
			e2.printStackTrace();
		} catch (CloneNotSupportedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		RealBoard();

	}

	private boolean isLeader(Champion c) {
		if (game1.getFirstPlayer().getTeam().contains(c)) {
			if (c == game1.getFirstPlayer().getLeader())
				return true;
		} else if (game1.getSecondPlayer().getTeam().contains(c)) {
			if (c == game1.getSecondPlayer().getLeader())
				return true;
		}
		return false;
	}

	// private void miniToString(ActionEvent event) {
	// String m = "";
	// Ability a;
	// String name = ((Button) event.getSource()).getText();
	// ArrayList<Champion> champs = game.getAvailableChampions();
	// for (int i = 0; i < champs.size(); i++) {
	// Champion c = champs.get(i);
	// if (c.getName().equals(name)) {
	// m += "Name: " + c.getName() + "\n";
	// m += "Type: ";
	// if (c instanceof Hero)
	// m += "HERO" + "\n";
	// else if (c instanceof Villain)
	// m += "VILLIAN" + "\n";
	// else
	// m += "ANTI-HERO" + "\n";
	// m += "Max HP: " + c.getMaxHP() + "\n";
	// m += "Mana:  " + c.getMana() + " \n";
	// m += "Max Action Points: " + c.getMaxActionPointsPerTurn()
	// + "\n";
	// m += "Speed: " + c.getSpeed() + "\n";
	// m += "Attack Range: " + c.getAttackRange() + "\n";
	// m += "Attack Damage: " + c.getAttackDamage() + "\n";
	// if (isLeader(c)) {
	// m += "Leader Ability: ";
	// if (game1.getFirstPlayer().getTeam().contains(c)) {
	// if (game1.isFirstLeaderAbilityUsed())
	// m += "Used" + "\n";
	// else
	// m += "Not Used" + "\n";
	// } else {
	// if (game1.isSecondLeaderAbilityUsed())
	// m += "Used" + "\n";
	// else
	// m += "Not Used" + "\n";
	// }
	//
	// }
	// for (int j = 0; j < c.getAppliedEffects().size(); j++) {
	// m += "Applied Effect " + j + 1 + ": "
	// + c.getAppliedEffects().get(j).getName() + "\n";
	// m += "Duration: "
	// + c.getAppliedEffects().get(j).getDuration();
	// }
	// }
	// }
	//
	// // Alert alert= new Alert(AlertType.NONE);
	// // alert.setContentText(m);
	// view.champInfo(m);
	//
	// }

	public void handleStart(ActionEvent event) {
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

	// private void handleOptions(CheckBox box1 ,CheckBox box2 ,CheckBox
	// box3,Player p ) {
	//
	// if (box1.isSelected(game.setLeader(p.getTeam().get(0))));
	// if (box2.isSelected(game.setLeader(p.getTeam().get(1)))) ;
	// if (box3.isSelected(game.setLeader(p.getTeam().get(2)))) ;
	//
	// }

	public void handleName(ActionEvent event) {
		view.getDescription().setText(toString(event));
	}

	public void handleEnd(ActionEvent event) {
		game1.endTurn();
		PriorityNames();
		toStringCurrent();
		ActionPoints();
		RealBoard();
		if (game1.getCurrentChampion().getAbilities().size() == 4) {
			view.getTog4().setVisible(true);
		} else
			view.getTog4().setVisible(false);
	}

	public void handleNext(ActionEvent event) {
		addToTeam(allChamp);
		Stage window = (Stage) ((Button) event.getSource()).getScene()
				.getWindow();
		window.setScene(view.getScene3());
		window.setFullScreen(!window.isFullScreen());
		ArrayList<CheckBox> arrayCheck = new ArrayList<CheckBox>();
		Text t1 = new Text(game.getFirstPlayer().getTeam().get(0).getName());
		Text t2 = new Text(game.getFirstPlayer().getTeam().get(1).getName());
		Text t3 = new Text(game.getFirstPlayer().getTeam().get(2).getName());
		Text t4 = new Text(game.getSecondPlayer().getTeam().get(0).getName());
		Text t5 = new Text(game.getSecondPlayer().getTeam().get(1).getName());
		Text t6 = new Text(game.getSecondPlayer().getTeam().get(2).getName());

		t1.setFont(Font.font("COPPERPLATE GOTHIC BOLD", 42));
		t1.setFill(Color.GRAY);
		t1.setStyle("-fx-font-weight: bold;");
		t1.setTranslateY(30);
		t1.setEffect(glow);

		t2.setFont(Font.font("COPPERPLATE GOTHIC BOLD", 42));
		t2.setFill(Color.GRAY);
		t2.setStyle("-fx-font-weight: bold;");
		t2.setTranslateY(30);
		t2.setEffect(glow);

		t3.setFont(Font.font("COPPERPLATE GOTHIC BOLD", 42));
		t3.setFill(Color.GRAY);
		t3.setStyle("-fx-font-weight: bold;");
		t3.setTranslateY(30);
		t3.setEffect(glow);

		t4.setFont(Font.font("COPPERPLATE GOTHIC BOLD", 42));
		t4.setFill(Color.GRAY);
		t4.setStyle("-fx-font-weight: bold;");
		t4.setTranslateY(30);
		t4.setEffect(glow);

		t5.setFont(Font.font("COPPERPLATE GOTHIC BOLD", 42));
		t5.setFill(Color.GRAY);
		t5.setStyle("-fx-font-weight: bold;");
		t5.setTranslateY(30);
		t5.setEffect(glow);

		t6.setFont(Font.font("COPPERPLATE GOTHIC BOLD", 42));
		t6.setFill(Color.GRAY);
		t6.setStyle("-fx-font-weight: bold;");
		t6.setTranslateY(30);
		t6.setEffect(glow);

		CheckBox box1 = new CheckBox();
		CheckBox box2 = new CheckBox();
		CheckBox box3 = new CheckBox();
		CheckBox box4 = new CheckBox();
		CheckBox box5 = new CheckBox();
		CheckBox box6 = new CheckBox();
		HBox h1 = new HBox(box1, t1);
		HBox h2 = new HBox(box2, t2);
		HBox h3 = new HBox(box3, t3);
		HBox h4 = new HBox(box4, t4);
		HBox h5 = new HBox(box5, t5);
		HBox h6 = new HBox(box6, t6);
		VBox v1 = new VBox();
		VBox v2 = new VBox();
		v1.setAlignment(Pos.CENTER);
		v2.setAlignment(Pos.CENTER);

		String s = "-fx-border-color: white;\n" + "-fx-border-insets: 5;\n"
				+ "-fx-border-width: 3;\n";
		Effect glow = new Glow(0.8);
		Text text5 = new Text(game.getFirstPlayer().getName() + "'s Team");
		text5.setFont(Font.font("COPPERPLATE GOTHIC BOLD", 60));
		text5.setFill(Color.GRAY);
		text5.setStyle("-fx-font-weight: bold;");
		text5.setEffect(glow);

		Text text6 = new Text(game.getSecondPlayer().getName() + "'s Team");
		text6.setFont(Font.font("COPPERPLATE GOTHIC BOLD", 60));
		text6.setFill(Color.GRAY);
		text6.setStyle("-fx-font-weight: bold;");
		text6.setEffect(glow);

		v1.getChildren().addAll(text5);
		v2.getChildren().add(text6);
		v1.getChildren().addAll(h1, h2, h3);
		v2.getChildren().addAll(h4, h5, h6);
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(30, 30, 30, 30));
		hbox.getChildren().addAll(v1, v2);
		hbox.setAlignment(Pos.CENTER);

		arrayCheck.add(box1);
		arrayCheck.add(box2);
		arrayCheck.add(box3);
		arrayCheck.add(box4);
		arrayCheck.add(box5);
		arrayCheck.add(box6);
		box1.setId(game.getFirstPlayer().getTeam().get(0).getName());
		box2.setId(game.getFirstPlayer().getTeam().get(1).getName());
		box3.setId(game.getFirstPlayer().getTeam().get(2).getName());
		box4.setId(game.getSecondPlayer().getTeam().get(0).getName());
		box5.setId(game.getSecondPlayer().getTeam().get(1).getName());
		box6.setId(game.getSecondPlayer().getTeam().get(2).getName());

		try {
			view.LeaderBox(arrayCheck, hbox);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String toString(ActionEvent event) {
		String m = "";
		Ability a;
		String name = ((Button) event.getSource()).getText();
		ArrayList<Champion> champs = game.getAvailableChampions();
		for (int i = 0; i < champs.size(); i++) {
			Champion c = champs.get(i);
			if (c.getName().equals(name)) {
				m += "\n";
				m += "\n";
				m += "\n";
				m += "\n";
				m += "Name: " + c.getName() + "\n";
				m += "Type: ";
				if (c instanceof Hero)
					m += "HERO" + "\n";
				else if (c instanceof Villain)
					m += "VILLIAN" + "\n";
				else
					m += "ANTI-HERO" + "\n";
				m += "Max HP: " + c.getMaxHP() + "\n";
				m += "Mana:  " + c.getMana() + " \n";
				m += "Max Action Points: " + c.getMaxActionPointsPerTurn()
						+ "\n";
				m += "Speed: " + c.getSpeed() + "\n";
				m += "Attack Range: " + c.getAttackRange() + "\n";
				m += "Attack Damage: " + c.getAttackDamage() + "\n";
				m += "--------------------------------------------------------"
						+ "\n";

				for (int j = 0; j < c.getAbilities().size(); j++) {
					a = c.getAbilities().get(j);
					m += "Ability" + (j + 1) + ": " + a.getName() + "\n";
					// m += "area of effect: " + a.getCastArea() + "\n";
					// m += "cast range: " + a.getCastRange() + "\n";
					// m += "ability mana: " + a.getManaCost() + "\n";
					// m += "action cost: " + a.getRequiredActionPoints() +
					// "\n";
					// m += " current cool down: " + a.getCurrentCooldown() +
					// "\n";
					// m += "base cool down " + a.getBaseCooldown() + "\n";
				}
			}
		}
		return m;

	}

	public void toStringCurrent() {
		String m = "";
		Ability a;
		Effect e;
		String name = ((Champion) game1.getTurnOrder().peekMin()).getName();
		ArrayList<Champion> champs = game1.getAvailableChampions();
		for (int i = 0; i < champs.size(); i++) {
			Champion c = champs.get(i);
			if (c.getName().equals(name)) {
				m += c.getName() + "'s Details: " + "\n";
				m += "Type: ";
				if (c instanceof Hero)
					m += "HERO" + "\n";
				else if (c instanceof Villain)
					m += "VILLIAN" + "\n";
				else
					m += "ANTI-HERO" + "\n";
				m += "Max HP: " + c.getMaxHP() + "\n";
				m += "Mana:  " + c.getMana() + " \n";
				m += "Max Action Points: " + c.getMaxActionPointsPerTurn()
						+ "\n";
				m += "Speed: " + c.getSpeed() + "\n";
				m += "Attack Range: " + c.getAttackRange() + "\n";
				m += "Attack Damage: " + c.getAttackDamage() + "\n";
				// m +=
				// "--------------------------------------------------------"
				// + "\n";

				// for (int j = 0; j < c.getAbilities().size(); j++) {
				// a = c.getAbilities().get(j);
				// m += "Ability" + (j + 1) + ": " + "\n";
				// m += "Ability name: " + a.getName() + "\n";
				// m += "area of effect: " + a.getCastArea() + "\n";
				// m += "cast range: " + a.getCastRange() + "\n";
				// m += "ability mana: " + a.getManaCost() + "\n";
				// m += "action cost: " + a.getRequiredActionPoints() + "\n";
				// m += " current cool down: " + a.getCurrentCooldown() + "\n";
				// m += "base cool down " + a.getBaseCooldown() + "\n";
				// }
			}
		}
		Text t = new Text(m);
		t.setFill(Color.GRAY);
		t.setFont(Font.font("COPPERPLATE GOTHIC BOLD", 35));
		t.setFill(Color.DARKGRAY);
		t.setStyle("-fx-font-weight: bold;");
		t.setEffect(glow);
		HBox result = new HBox();
		result.setStyle("-fx-border-color: white;");
		result.getChildren().add(t);
		result.setMaxSize(450, 400);
		result.setMinSize(450, 400);
		// t.setStyle(value);
		// t.setFont(Font.font("COPPERPLATE GOTHIC BOLD", FontWeight.BOLD));
		view.addCurrent(result);

	}

	public void toStringEffect() {
		String m = "";
		// String name = ((Champion) game1.getTurnOrder().peekMin()).getName();
		Champion c = game1.getCurrentChampion();
		// System.out.println(name+"effect");
		// ArrayList<Champion> champs = game1.getAvailableChampions();
		for (int i = 0; i < c.getAppliedEffects().size(); i++) {
			m += "Applied Effect " + (i + 1) + ": " + "\n"
					+ "                          "
					+ c.getAppliedEffects().get(i).getName() + "\n";
			m += "Duration: " + c.getAppliedEffects().get(i).getDuration()
					+ "\n";
		}

		Text t = new Text(m);
		// System.out.println("effect");
		System.out.println(m);
		t.setFill(Color.GRAY);
		t.setFont(Font.font("COPPERPLATE GOTHIC BOLD", 30));
		t.setFill(Color.GREY);
		t.setStyle("-fx-font-weight: bold;");
		glow = new Glow(3);
		t.setEffect(glow);
		// view.addCurrent(t);
		view.addEffect(t);
	}

	private void handleReady(ActionEvent event) throws IOException {
		Champion c1 = null;
		Champion c2 = null;
		String name;
		game1 = new Game(game.getFirstPlayer(), game.getSecondPlayer());
		for (int i = 0; i < view.getCheckArray().size(); i++) {
			if (view.getCheckArray().get(i).isSelected()) {
				name = view.getCheckArray().get(i).getId();
				for (int j = 0; j < game1.getFirstPlayer().getTeam().size(); j++) {
					if (game1.getFirstPlayer().getTeam().get(j).getName()
							.equals(name)) {
						c1 = game1.getFirstPlayer().getTeam().get(j);
					}
				}
				game1.getFirstPlayer().setLeader(c1);
			}
			if (view.getCheckArray().get(view.getCheckArray().size() - 1 - i)
					.isSelected()) {
				name = view.getCheckArray()
						.get(view.getCheckArray().size() - 1 - i).getId();
				for (int j = 0; j < game1.getSecondPlayer().getTeam().size(); j++) {
					if (game1.getSecondPlayer().getTeam().get(j).getName()
							.equals(name)) {
						c2 = game1.getSecondPlayer().getTeam().get(j);
					}
				}
				game1.getSecondPlayer().setLeader(c2);
			}

		}
		Stage window = (Stage) ((Button) event.getSource()).getScene()
				.getWindow();
		window.setScene(view.getScene4());
		window.setFullScreen(!window.isFullScreen());

		try {
			game1.loadAbilities("Abilities.csv");
			game1.loadChampions("Champions.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PriorityNames();
		toStringCurrent();
		RealBoard();
		keyControl = new KeyControl(view, game1);
		view.keyBoard(view.getScene4());

	}

	public void RealBoard() {

		view.getT1().setText(Ability1());
		view.getT2().setText(Ability2());
		view.getT3().setText(Ability3());
		if (game1.getCurrentChampion().getAbilities().size() == 4) {
			view.getT4().setText(Ability4());
		}
		if (game1.getFirstPlayer().getTeam().size() > 0)
			view.getC1().setText(Champion1());
		if (game1.getFirstPlayer().getTeam().size() > 1)
			view.getC2().setText(Champion2());
		if (game1.getFirstPlayer().getTeam().size() > 2)
			view.getC3().setText(Champion3());
		if (game1.getSecondPlayer().getTeam().size() > 0)
			view.getC4().setText(Champion4());
		if (game1.getSecondPlayer().getTeam().size() > 1)
			view.getC5().setText(Champion5());
		if (game1.getSecondPlayer().getTeam().size() > 2)
			view.getC6().setText(Champion6());
		// toStringEffect();
        
		ArrayList<Button> a = view.getBoardButtons();
		Object[][] b = game1.getBoard();
		ArrayList<Damageable> da;
		int k = 0;
		ImageView v;
		String style = "";
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (b[i][j] instanceof Champion) {
					if (((Champion) b[i][j]).getCurrentHP() <= 0) {
						da = new ArrayList<Damageable>();
						da.add((Champion) b[i][j]);
						game1.cleanup(da);
					}
				}
				if (b[i][j] == null) {
					a.get(k).setGraphic(null);
					a.get(k).setText(null);
					a.get(k).setStyle(null);
					style = "-fx-alignment: bottom-center; -fx-content-display: top; -fx-background-color:transparent;-fx-text-fill: white ;";
					a.get(k).setStyle(style);
				}
				
				if (b[i][j] instanceof Cover) {
					// a.get(k).setText("COVER");
					v = CoverIcon((Cover) b[i][j]);
					a.get(k).setGraphic(v);
					String s = ((Cover) b[i][j]).getCurrentHP() + "";
					style = "-fx-alignment: bottom-center; -fx-content-display: top; -fx-background-color:transparent ;-fx-text-fill: white ;";
					a.get(k).setText(s);
					a.get(k).setStyle(style);
				} else if (b[i][j] instanceof Champion) {

					if ((Champion) b[i][j] == game1.getCurrentChampion())
						a.get(k).setStyle("-fx-border-color: yellow;");
					v = ChampIcon((Champion) b[i][j]);
					a.get(k).setGraphic(v);
					String s = ((Champion) b[i][j]).getCurrentHP() + "/"
							+ ((Champion) b[i][j]).getMaxHP();
					a.get(k).setText(s);
					if (game1.getFirstPlayer().getTeam()
							.contains(((Champion) b[i][j]))) {
						if((Champion) b[i][j] == game1.getCurrentChampion())
							style = "-fx-alignment: bottom-center; -fx-content-display: top; -fx-background-color:transparent; -fx-border-color: yellow; -fx-border-width: 5;-fx-text-fill: white ;";
						else style = "-fx-alignment: bottom-center; -fx-content-display: top; -fx-background-color:transparent;-fx-text-fill: white ;";
					} else {
						if((Champion) b[i][j] == game1.getCurrentChampion())
							style = "-fx-alignment: bottom-center; -fx-content-display: top; -fx-background-color:transparent; -fx-border-color: yellow; -fx-border-width: 5;-fx-text-fill: white ;";
						else style = "-fx-alignment: bottom-center; -fx-content-display: top; -fx-background-color:transparent;-fx-text-fill: white ;";
					}
					a.get(k).setStyle(style);
				}
				k++;
			}
		}
		if (game1.checkGameOver() != null) {
			Player p = game1.checkGameOver();
			pop(p);
		}
		ActionPoints();
		Teams();
		toStringEffect();
		PriorityNames();

	}

	public String Champion6() {
		String m = "";
		Champion c = game1.getSecondPlayer().getTeam().get(2);
		m += "Name: " + c.getName() + "\n";
		m += "Type: ";
		if (c instanceof Hero)
			m += "HERO" + "\n";
		else if (c instanceof Villain)
			m += "VILLIAN" + "\n";
		else
			m += "ANTI-HERO" + "\n";
		m += "Current HP: " + c.getCurrentHP() + "\n";
		m += "Mana:  " + c.getMana() + " \n";
		m += "Max Action Points: " + c.getMaxActionPointsPerTurn() + "\n";
		m += "Speed: " + c.getSpeed() + "\n";
		m += "Attack Range: " + c.getAttackRange() + "\n";
		m += "Attack Damage: " + c.getAttackDamage() + "\n";
		if (isLeader(c)) {
			m += "Leader Ability: ";
			if (game1.isSecondLeaderAbilityUsed())
				m += "Used" + "\n";
			else
				m += "Not Used" + "\n";

		} else
			m += "Not Leader" + "\n";
		for (int j = 0; j < c.getAppliedEffects().size(); j++) {
			m += "Applied Effect " + (j + 1) + ": "
					+ c.getAppliedEffects().get(j).getName() + "\n";
			m += "Duration: " + c.getAppliedEffects().get(j).getDuration();
		}
		return m;
	}

	public String Champion5() {
		String m = "";
		Champion c = game1.getSecondPlayer().getTeam().get(1);
		m += "Name: " + c.getName() + "\n";
		m += "Type: ";
		if (c instanceof Hero)
			m += "HERO" + "\n";
		else if (c instanceof Villain)
			m += "VILLIAN" + "\n";
		else
			m += "ANTI-HERO" + "\n";
		m += "Current HP: " + c.getCurrentHP() + "\n";
		m += "Mana:  " + c.getMana() + " \n";
		m += "Max Action Points: " + c.getMaxActionPointsPerTurn() + "\n";
		m += "Speed: " + c.getSpeed() + "\n";
		m += "Attack Range: " + c.getAttackRange() + "\n";
		m += "Attack Damage: " + c.getAttackDamage() + "\n";
		if (isLeader(c)) {
			m += "Leader Ability: ";
			if (game1.isSecondLeaderAbilityUsed())
				m += "Used" + "\n";
			else
				m += "Not Used" + "\n";

		} else
			m += "Not Leader" + "\n";
		for (int j = 0; j < c.getAppliedEffects().size(); j++) {
			m += "Applied Effect " + j + 1 + ": "
					+ c.getAppliedEffects().get(j).getName() + "\n";
			m += "Duration: " + c.getAppliedEffects().get(j).getDuration();
		}
		return m;
	}

	public String Champion4() {
		String m = "";
		Champion c = game1.getSecondPlayer().getTeam().get(0);
		m += "Name: " + c.getName() + "\n";
		m += "Type: ";
		if (c instanceof Hero)
			m += "HERO" + "\n";
		else if (c instanceof Villain)
			m += "VILLIAN" + "\n";
		else
			m += "ANTI-HERO" + "\n";
		m += "Current HP: " + c.getCurrentHP() + "\n";
		m += "Mana:  " + c.getMana() + " \n";
		m += "Max Action Points: " + c.getMaxActionPointsPerTurn() + "\n";
		m += "Speed: " + c.getSpeed() + "\n";
		m += "Attack Range: " + c.getAttackRange() + "\n";
		m += "Attack Damage: " + c.getAttackDamage() + "\n";
		if (isLeader(c)) {
			m += "Leader Ability: ";
			if (game1.isSecondLeaderAbilityUsed())
				m += "Used" + "\n";
			else
				m += "Not Used" + "\n";

		} else
			m += "Not Leader" + "\n";
		for (int j = 0; j < c.getAppliedEffects().size(); j++) {
			m += "Applied Effect " + j + 1 + ": "
					+ c.getAppliedEffects().get(j).getName() + "\n";
			m += "Duration: " + c.getAppliedEffects().get(j).getDuration();
		}
		return m;
	}

	public String Champion3() {
		String m = "";
		Champion c = game1.getFirstPlayer().getTeam().get(2);
		m += "Name: " + c.getName() + "\n";
		m += "Type: ";
		if (c instanceof Hero)
			m += "HERO" + "\n";
		else if (c instanceof Villain)
			m += "VILLIAN" + "\n";
		else
			m += "ANTI-HERO" + "\n";
		m += "Current HP: " + c.getCurrentHP() + "\n";
		m += "Mana:  " + c.getMana() + " \n";
		m += "Max Action Points: " + c.getMaxActionPointsPerTurn() + "\n";
		m += "Speed: " + c.getSpeed() + "\n";
		m += "Attack Range: " + c.getAttackRange() + "\n";
		m += "Attack Damage: " + c.getAttackDamage() + "\n";
		if (isLeader(c)) {
			m += "Leader Ability: ";
			if (game1.isFirstLeaderAbilityUsed())
				m += "Used" + "\n";
			else
				m += "Not Used" + "\n";

		} else
			m += "Not Leader" + "\n";
		for (int j = 0; j < c.getAppliedEffects().size(); j++) {
			m += "Applied Effect " + j + 1 + ": "
					+ c.getAppliedEffects().get(j).getName() + "\n";
			m += "Duration: " + c.getAppliedEffects().get(j).getDuration();
		}
		return m;
	}

	public String Champion2() {
		String m = "";
		Champion c = game1.getFirstPlayer().getTeam().get(1);
		m += "Name: " + c.getName() + "\n";
		m += "Type: ";
		if (c instanceof Hero)
			m += "HERO" + "\n";
		else if (c instanceof Villain)
			m += "VILLIAN" + "\n";
		else
			m += "ANTI-HERO" + "\n";
		m += "Current HP: " + c.getCurrentHP() + "\n";
		m += "Mana:  " + c.getMana() + " \n";
		m += "Max Action Points: " + c.getMaxActionPointsPerTurn() + "\n";
		m += "Speed: " + c.getSpeed() + "\n";
		m += "Attack Range: " + c.getAttackRange() + "\n";
		m += "Attack Damage: " + c.getAttackDamage() + "\n";
		if (isLeader(c)) {
			m += "Leader Ability: ";
			if (game1.isFirstLeaderAbilityUsed())
				m += "Used" + "\n";
			else
				m += "Not Used" + "\n";

		} else
			m += "Not Leader" + "\n";
		for (int j = 0; j < c.getAppliedEffects().size(); j++) {
			m += "Applied Effect " + j + 1 + ": "
					+ c.getAppliedEffects().get(j).getName() + "\n";
			m += "Duration: " + c.getAppliedEffects().get(j).getDuration();
		}
		return m;
	}

	public String Champion1() {
		String m = "";
		Champion c = game1.getFirstPlayer().getTeam().get(0);
		m += "Name: " + c.getName() + "\n";
		m += "Type: ";
		if (c instanceof Hero)
			m += "HERO" + "\n";
		else if (c instanceof Villain)
			m += "VILLIAN" + "\n";
		else
			m += "ANTI-HERO" + "\n";
		m += "Current HP: " + c.getCurrentHP() + "\n";
		m += "Mana:  " + c.getMana() + " \n";
		m += "Max Action Points: " + c.getMaxActionPointsPerTurn() + "\n";
		m += "Speed: " + c.getSpeed() + "\n";
		m += "Attack Range: " + c.getAttackRange() + "\n";
		m += "Attack Damage: " + c.getAttackDamage() + "\n";
		if (isLeader(c)) {
			m += "Leader Ability: ";
			if (game1.isFirstLeaderAbilityUsed())
				m += "Used" + "\n";
			else
				m += "Not Used" + "\n";

		} else
			m += "Not Leader" + "\n";
		for (int j = 0; j < c.getAppliedEffects().size(); j++) {
			m += "Applied Effect " + j + 1 + ": "
					+ c.getAppliedEffects().get(j).getName() + "\n";
			m += "Duration: " + c.getAppliedEffects().get(j).getDuration();
		}
		return m;
	}

	public void ActionPoints() {
		String s = "-fx-border-color: white;\n";
		HBox h = view.getBar();
		HBox h1 = view.getBar1();

		h.getChildren().clear();
		h.setPrefHeight(50);
		h.setMaxSize(350, 50);
		h1.getChildren().clear();
		h1.setPrefHeight(50);
		h1.setMaxSize(350, 50);
		// h.setStyle(s);
		Champion c = game1.getCurrentChampion();
		int a = c.getCurrentActionPoints();
		int b = c.getMana() / 100;
		// System.out.println(b);
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
		for (int i = 0; i < b; i++) {
			ImageView v = new ImageView(new Image("square1.png"));
			h1.getChildren().add(v);
		}

	}

	public ImageView ChampMini(Champion c) {
		ImageView i = null;
		if (c.getName().equals("Captain America"))
			if (isLeader(c))
				i = new ImageView(new Image("xcaptain.png"));
			else
				i = new ImageView(new Image("zcaptain.png"));
		else if (c.getName().equals("Deadpool"))
			if (isLeader(c))
				i = new ImageView(new Image("xdeadpool.png"));
			else
				i = new ImageView(new Image("zdeadpool.png"));
		else if (c.getName().equals("Dr Strange"))
			if (isLeader(c))
				i = new ImageView(new Image("xdr.png"));
			else
				i = new ImageView(new Image("zdrstrange.png"));
		else if (c.getName().equals("Electro"))
			if (isLeader(c))
				i = new ImageView(new Image("xelectro.png"));
			else
				i = new ImageView(new Image("zelectro.png"));
		else if (c.getName().equals("Ghost Rider"))
			if (isLeader(c))
				i = new ImageView(new Image("xghost.png"));
			else
				i = new ImageView(new Image("zghost.png"));
		else if (c.getName().equals("Hela"))
			if (isLeader(c))
				i = new ImageView(new Image("xhela.png"));
			else
				i = new ImageView(new Image("zhela.png"));
		else if (c.getName().equals("Hulk"))
			if (isLeader(c))
				i = new ImageView(new Image("xhulk.png"));
			else
				i = new ImageView(new Image("zhulk.png"));
		else if (c.getName().equals("Iceman"))
			if (isLeader(c))
				i = new ImageView(new Image("xice.png"));
			else
				i = new ImageView(new Image("ziceman.png"));
		else if (c.getName().equals("Ironman"))
			if (isLeader(c))
				i = new ImageView(new Image("xironman.png"));
			else
				i = new ImageView(new Image("zironman.png"));
		else if (c.getName().equals("Loki"))
			if (isLeader(c))
				i = new ImageView(new Image("xloki.png"));
			else
				i = new ImageView(new Image("zloki.png"));
		else if (c.getName().equals("Quicksilver"))
			if (isLeader(c))
				i = new ImageView(new Image("xquick.png"));
			else
				i = new ImageView(new Image("zquick.png"));
		else if (c.getName().equals("Spiderman"))
			if (isLeader(c))
				i = new ImageView(new Image("xspiderman.png"));
			else
				i = new ImageView(new Image("zspiderman.png"));
		else if (c.getName().equals("Thor"))
			if (isLeader(c))
				i = new ImageView(new Image("xthor.png"));
			else
				i = new ImageView(new Image("zthor.png"));
		else if (c.getName().equals("Venom"))
			if (isLeader(c))
				i = new ImageView(new Image("xvenom.png"));
			else
				i = new ImageView(new Image("zvenom.png"));
		else if (c.getName().equals("Yellow Jacket"))
			if (isLeader(c))
				i = new ImageView(new Image("xyellow.png"));
			else
				i = new ImageView(new Image("zyellow.png"));
		return i;
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

	public void Teams() {

		Text name1 = new Text(game1.getFirstPlayer().getName() + "'s Team");
		name1.setFont(Font.font("COPPERPLATE GOTHIC BOLD", 40));
		name1.setFill(Color.BLACK);
		name1.setStyle("-fx-font-weight: bold;");
		// name1.setEffect(glow);
		Text name2 = new Text(game1.getSecondPlayer().getName() + "'s Team");
		name2.setFont(Font.font("COPPERPLATE GOTHIC BOLD", 40));
		name2.setFill(Color.BLACK);
		name2.setStyle("-fx-font-weight: bold;");
		// name2.setEffect(glow);
		VBox v1 = new VBox(20);
		v1.getChildren().add(name1);
		v1.setPadding(new Insets(10, 10, 10, 10));
		VBox v2 = new VBox(20);
		v2.getChildren().add(name2);
		v2.setPadding(new Insets(10, 10, 10, 10));
		ImageView v;

		for (int i = 0; i < game1.getFirstPlayer().getTeam().size(); i++) {
			Button p = new Button(game1.getFirstPlayer().getTeam().get(i)
					.getName());
			p.setId("mini");
			p.setPrefSize(200, 50);
			if (i == 0)
				p.setTooltip(view.getC1());
			if (i == 1)
				p.setTooltip(view.getC2());
			if (i == 2)
				p.setTooltip(view.getC3());
			p.setFont(Font.font("COPPERPLATE GOTHIC BOLD", 23));
			p.setStyle("-fx-text-fill: grey");
			// p.setOnAction(this);
			// p.setFill(Color.WHITESMOKE);
			// p.setEffect(new Glow(1.5));
			v = ChampMini(game1.getFirstPlayer().getTeam().get(i));
			HBox h = new HBox(v, p);
			h.setSpacing(10.0);
			v1.getChildren().add(h);
		}
		for (int i = 0; i < game1.getSecondPlayer().getTeam().size(); i++) {
			Button p = new Button(game1.getSecondPlayer().getTeam().get(i)
					.getName());
			p.setId("mini");
			p.setPrefSize(200, 50);
			if (i == 0)
				p.setTooltip(view.getC4());
			if (i == 1)
				p.setTooltip(view.getC5());
			if (i == 2)
				p.setTooltip(view.getC6());
			p.setFont(Font.font("COPPERPLATE GOTHIC BOLD", 23));
			p.setStyle("-fx-text-fill: grey");
			// current.setFill(Color.GRAY);
			p.setOnAction(this);
			// p.setFill(Color.WHITESMOKE);
			// p.setEffect(new Glow(1.5));
			v = ChampMini(game1.getSecondPlayer().getTeam().get(i));
			HBox h = new HBox(v, p);
			h.setSpacing(10.0);
			v2.getChildren().add(h);
		}
		VBox h = new VBox(v1, v2);
		h.setPadding(new Insets(20, 20, 20, 20));
		view.addTeam(h);

	}

	// public void handleName(ActionEvent event) {
	// System.out.println("zzz");
	// }
	// public void handleName(ActionEvent event){
	// System.out.println(((Button)event.getSource()).getText());
	// view.getDescription().setText(key.toString(event));
	// }

	// public String toString(ActionEvent event) {
	// System.out.println("e");
	// String m = "";
	// Ability a;
	// String name = ((Button) event.getSource()).getText();
	// ArrayList<Champion> champs = game.getAvailableChampions();
	// for (int i = 0; i < champs.size(); i++) {
	// Champion c = champs.get(i);
	// if (c.getName().equals(name)) {
	// // m+= "Type: " + c.getType + "\n";
	// m += "Name: " + c.getName() + "\n";
	// m += "Max HP: " + c.getMaxHP() + "\n";
	// m += "Mana:  " + c.getMana() + " \n";
	// m += "Max Action Points: " + c.getMaxActionPointsPerTurn()
	// + "\n";
	// m += "Speed: " + c.getSpeed() + "\n";
	// m += "Attack Range: " + c.getAttackRange() + "\n";
	// m += "Attack Damage: " + c.getAttackDamage() + "\n";
	//
	// // for (int j = 0; j < c.getAbilities().size(); j++) {
	// // a = c.getAbilities().get(j);
	// // m += "Ability: " + (j + 1) + "\n";
	// // m += "Ability name: " + a.getName() + "\n";
	// // m += "area of effect: " + a.getCastArea() + "\n";
	// // m += "cast range: " + a.getCastRange() + "\n";
	// // m += "ability mana: " + a.getManaCost() + "\n";
	// // m += "action cost: " + a.getRequiredActionPoints() + "\n";
	// // m += " current cool down: " + a.getCurrentCooldown() + "\n";
	// // m += "base cool down " + a.getBaseCooldown() + "\n";
	// // }
	// }
	// }
	// return m;
	//
	// }
	private void handleNext1(ActionEvent event) {
		String nameChamp = ((Button) event.getSource()).getId();
		// addToTeam(nameChamp, game.getFirstPlayer(), game.getSecondPlayer(),
		// game.getAvailableChampions());
		allChamp.add(nameChamp);
		((Button) event.getSource()).setDisable(true);
		if (allChamp.size() == 6) {
			view.getnext().setVisible(true);
		}
	}

	private void handleNext2(ActionEvent event) {
		String nameChamp = ((Button) event.getSource()).getId();
		// addToTeam(nameChamp, game.getFirstPlayer(), game.getSecondPlayer(),
		// game.getAvailableChampions());
		allChamp.add(nameChamp);
		((Button) event.getSource()).setDisable(true);
		if (allChamp.size() == 6) {
			view.getnext().setVisible(true);
		}
	}

	private void handleNext3(ActionEvent event) {

		String nameChamp = ((Button) event.getSource()).getId();
		// addToTeam(nameChamp, game.getFirstPlayer(), game.getSecondPlayer(),
		// game.getAvailableChampions());
		allChamp.add(nameChamp);
		((Button) event.getSource()).setDisable(true);
		if (allChamp.size() == 6) {
			view.getnext().setVisible(true);
		}
	}

	private void handleNext4(ActionEvent event) {
		String nameChamp = ((Button) event.getSource()).getId();
		// addToTeam(nameChamp, game.getFirstPlayer(), game.getSecondPlayer(),
		// game.getAvailableChampions());
		allChamp.add(nameChamp);
		((Button) event.getSource()).setDisable(true);
		if (allChamp.size() == 6) {
			view.getnext().setVisible(true);
		}
	}

	private void handleNext5(ActionEvent event) {
		String nameChamp = ((Button) event.getSource()).getId();
		// addToTeam(nameChamp, game.getFirstPlayer(), game.getSecondPlayer(),
		// game.getAvailableChampions());
		allChamp.add(nameChamp);
		((Button) event.getSource()).setDisable(true);
		if (allChamp.size() == 6) {
			view.getnext().setVisible(true);
		}

	}

	private void handleNext6(ActionEvent event) {
		String nameChamp = ((Button) event.getSource()).getId();
		// addToTeam(nameChamp, game.getFirstPlayer(), game.getSecondPlayer(),
		// game.getAvailableChampions());
		allChamp.add(nameChamp);
		((Button) event.getSource()).setDisable(true);
		if (allChamp.size() == 6) {
			view.getnext().setVisible(true);
		}
	}

	private void handleNext7(ActionEvent event) {
		String nameChamp = ((Button) event.getSource()).getId();
		// addToTeam(nameChamp, game.getFirstPlayer(), game.getSecondPlayer(),
		// game.getAvailableChampions());
		allChamp.add(nameChamp);
		((Button) event.getSource()).setDisable(true);
		if (allChamp.size() == 6) {
			view.getnext().setVisible(true);
		}
	}

	private void handleNext8(ActionEvent event) {
		String nameChamp = ((Button) event.getSource()).getId();
		// addToTeam(nameChamp, game.getFirstPlayer(), game.getSecondPlayer(),
		// game.getAvailableChampions());
		allChamp.add(nameChamp);
		((Button) event.getSource()).setDisable(true);
		if (allChamp.size() == 6) {
			view.getnext().setVisible(true);
		}
	}

	private void handleNext9(ActionEvent event) {
		String nameChamp = ((Button) event.getSource()).getId();
		// addToTeam(nameChamp, game.getFirstPlayer(), game.getSecondPlayer(),
		// game.getAvailableChampions());
		allChamp.add(nameChamp);
		((Button) event.getSource()).setDisable(true);
		if (allChamp.size() == 6) {
			view.getnext().setVisible(true);
		}
	}

	private void handleNext10(ActionEvent event) {
		String nameChamp = ((Button) event.getSource()).getId();
		// addToTeam(nameChamp, game.getFirstPlayer(), game.getSecondPlayer(),
		// game.getAvailableChampions());
		allChamp.add(nameChamp);
		((Button) event.getSource()).setDisable(true);
		if (allChamp.size() == 6) {
			view.getnext().setVisible(true);
		}
	}

	private void handleNext11(ActionEvent event) {
		String nameChamp = ((Button) event.getSource()).getId();
		// addToTeam(nameChamp, game.getFirstPlayer(), game.getSecondPlayer(),
		// game.getAvailableChampions());
		allChamp.add(nameChamp);
		((Button) event.getSource()).setDisable(true);
		if (allChamp.size() == 6) {
			view.getnext().setVisible(true);
		}
	}

	private void handleNext12(ActionEvent event) {
		String nameChamp = ((Button) event.getSource()).getId();
		// addToTeam(nameChamp, game.getFirstPlayer(), game.getSecondPlayer(),
		// game.getAvailableChampions());
		allChamp.add(nameChamp);
		((Button) event.getSource()).setDisable(true);
		if (allChamp.size() == 6) {
			view.getnext().setVisible(true);
		}
	}

	private void handleNext13(ActionEvent event) {
		String nameChamp = ((Button) event.getSource()).getId();
		// addToTeam(nameChamp, game.getFirstPlayer(), game.getSecondPlayer(),
		// game.getAvailableChampions());
		allChamp.add(nameChamp);
		((Button) event.getSource()).setDisable(true);
		if (allChamp.size() == 6) {
			view.getnext().setVisible(true);
		}
	}

	private void handleNext14(ActionEvent event) {
		String nameChamp = ((Button) event.getSource()).getId();
		// addToTeam(nameChamp, game.getFirstPlayer(), game.getSecondPlayer(),
		// game.getAvailableChampions());
		allChamp.add(nameChamp);
		((Button) event.getSource()).setDisable(true);
		if (allChamp.size() == 6) {
			view.getnext().setVisible(true);
		}
	}

	private void handleNext15(ActionEvent event) {
		String nameChamp = ((Button) event.getSource()).getId();
		// addToTeam(nameChamp, game.getFirstPlayer(), game.getSecondPlayer(),
		// game.getAvailableChampions());
		allChamp.add(nameChamp);
		((Button) event.getSource()).setDisable(true);
		if (allChamp.size() == 6) {
			view.getnext().setVisible(true);
		}
	}

	private void HelperCheck(ActionEvent event) {
		String name = ((CheckBox) event.getSource()).getId();
		Player p;
		Champion c = null;
		for (int i = 0; i < game.getAvailableChampions().size(); i++) {
			if (name.equals(game.getAvailableChampions().get(i).getName())) {
				c = game.getAvailableChampions().get(i);
				break;
			}
		}
		if (game.getFirstPlayer().getTeam().contains(c))
			p = game.getFirstPlayer();
		else
			p = game.getSecondPlayer();
		for (int i = 0; i < view.getCheckArray().size(); i++) {
			for (int j = 0; j < p.getTeam().size(); j++) {
				if (view.getCheckArray().get(i).getId()
						.equals(p.getTeam().get(j).getName())
						&& p.getTeam().get(j) != c) {
					view.getCheckArray().get(i).setSelected(false);
				}
			}
		}
		// int count=0;
		// for(int i=0; i<view.getCheckArray().size();i++){
		// if(view.getCheckArray().get(i).isSelected())
		// count++;
		// }
		// if(count==2)
		// view.getReady().setVisible(true);

	}

	// public void addToBoard(){
	// stack= new ArrayList<championT>();
	//
	// for(int i=0; i<game.getFirstPlayer().getTeam().size(); i++){
	// championT champ= new
	// championT((String)(game.getFirstPlayer().getTeam().get(i).getName()) ,
	// "p1" ,(Point)((game.getFirstPlayer().getTeam().get(i).getLocation())) );
	// stack.add(champ);
	// }
	// for(int i=0; i<game.getSecondPlayer().getTeam().size(); i++){
	// championT champ= new
	// championT((String)(game.getFirstPlayer().getTeam().get(i).getName()) ,
	// "p2", (Point)((game.getFirstPlayer().getTeam().get(i).getLocation())));
	// stack.add(champ);
	// }
	//
	//
	//
	// game.placeChampions();
	// for(int i=0; i<game.getBoard().length; i++){
	//
	// }
	//
	// }

	private void addToTeam(ArrayList<String> champs) {
		Champion c = null;
		for (int i = 0; i < champs.size(); i++) {
			for (int j = 0; j < game.getAvailableChampions().size(); j++) {
				if (game.getAvailableChampions().get(j).getName()
						.equals(champs.get(i))) {
					c = game.getAvailableChampions().get(j);
					break;
				}
			}
			if (i % 2 == 0)
				game.getFirstPlayer().getTeam().add(c);
			else
				game.getSecondPlayer().getTeam().add(c);
		}
	}

	public void PriorityNames() {
		PriorityQueue p = game1.getTurnOrder();
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Champion> champion = new ArrayList<Champion>();
		HBox turns = new HBox();
		// ImageView arrow =new ImageView(new Image("arrow.png"));
		while (!p.isEmpty()) {
			Champion c = (Champion) p.remove();
			if (c.getCondition() != Condition.INACTIVE)
				names.add(c.getName());
			champion.add(c);
		}
		for (int i = 0; i < champion.size(); i++) {
			p.insert(champion.get(i));
		}
		ImageView j = null;
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).equals("Captain America"))
				j = new ImageView(new Image("iconcaptain.png"));
			else if (names.get(i).equals("Deadpool"))
				j = new ImageView(new Image("icondeadpool.png"));
			else if (names.get(i).equals("Dr Strange"))
				j = new ImageView(new Image("icondrstrange.png"));
			else if (names.get(i).equals("Electro"))
				j = new ImageView(new Image("iconelectro.png"));
			else if (names.get(i).equals("Ghost Rider"))
				j = new ImageView(new Image("iconghost.png"));
			else if (names.get(i).equals("Hela"))
				j = new ImageView(new Image("iconhela.png"));
			else if (names.get(i).equals("Hulk"))
				j = new ImageView(new Image("iconhulk.png"));
			else if (names.get(i).equals("Iceman"))
				j = new ImageView(new Image("iconiceman.png"));
			else if (names.get(i).equals("Ironman"))
				j = new ImageView(new Image("iconironman.png"));
			else if (names.get(i).equals("Loki"))
				j = new ImageView(new Image("iconloki.png"));
			else if (names.get(i).equals("Quicksilver"))
				j = new ImageView(new Image("iconquick.png"));
			else if (names.get(i).equals("Spiderman"))
				j = new ImageView(new Image("iconspiderman.png"));
			else if (names.get(i).equals("Thor"))
				j = new ImageView(new Image("iconthor.png"));
			else if (names.get(i).equals("Venom"))
				j = new ImageView(new Image("iconvenom.png"));
			else if (names.get(i).equals("Yellow Jacket"))
				j = new ImageView(new Image("iconyellow.png"));
			turns.getChildren().add(j);
			if (i < names.size() - 1) {
				turns.getChildren().add(new ImageView(new Image("arr.png")));
			}
		}
		// System.out.println("hi");
		view.Priority(turns);
	}

	public String Ability1() {
		Champion c = game1.getCurrentChampion();
		Ability a = c.getAbilities().get(0);
		String m = "";
		m += "Ability name: " + a.getName() + "\n";
		if (a instanceof DamagingAbility)
			m += "Ability Type: " + " Damaging" + "\n";
		if (a instanceof HealingAbility)
			m += "Ability Type: " + " Healing" + "\n";
		if (a instanceof CrowdControlAbility) {
			if (((CrowdControlAbility) a).getEffect().getType() == EffectType.BUFF)
				m += "Ability Type: " + " CrowdControl-Buff" + "\n";
			else
				m += "Ability Type: " + " CrowdControl-Debuff" + "\n";
		}
		m += "Area of Effect: " + a.getCastArea() + "\n";
		m += "Cast Range: " + a.getCastRange() + "\n";
		m += "Ability Mana: " + a.getManaCost() + "\n";
		m += "Action cost: " + a.getRequiredActionPoints() + "\n";
		m += "Current CoolDown: " + a.getCurrentCooldown() + "\n";
		m += "Base CoolDown: " + a.getBaseCooldown() + "\n";

		return m;
	}

	public String Ability2() {
		Champion c = game1.getCurrentChampion();
		Ability a = c.getAbilities().get(1);
		String m = "";
		m += "Ability name: " + a.getName() + "\n";
		if (a instanceof DamagingAbility)
			m += "Ability Type: " + " Damaging" + "\n";
		if (a instanceof HealingAbility)
			m += "Ability Type: " + " Healing" + "\n";
		if (a instanceof CrowdControlAbility) {
			if (((CrowdControlAbility) a).getEffect().getType() == EffectType.BUFF)
				m += "Ability Type: " + " CrowdControl-Buff" + "\n";
			else
				m += "Ability Type: " + " CrowdControl-Debuff" + "\n";
		}
		m += "Area of Effect: " + a.getCastArea() + "\n";
		m += "Cast Range: " + a.getCastRange() + "\n";
		m += "Ability Mana: " + a.getManaCost() + "\n";
		m += "Action cost: " + a.getRequiredActionPoints() + "\n";
		m += "Current CoolDown: " + a.getCurrentCooldown() + "\n";
		m += "Base CoolDown: " + a.getBaseCooldown() + "\n";
		return m;
	}

	public String Ability3() {
		Champion c = game1.getCurrentChampion();
		Ability a = c.getAbilities().get(2);
		String m = "";
		m += "Ability name: " + a.getName() + "\n";
		if (a instanceof DamagingAbility)
			m += "Ability Type: " + " Damaging" + "\n";
		if (a instanceof HealingAbility)
			m += "Ability Type: " + " Healing" + "\n";
		if (a instanceof CrowdControlAbility) {
			if (((CrowdControlAbility) a).getEffect().getType() == EffectType.BUFF)
				m += "Ability Type: " + " CrowdControl-Buff" + "\n";
			else
				m += "Ability Type: " + " CrowdControl-Debuff" + "\n";
		}
		m += "Area of Effect: " + a.getCastArea() + "\n";
		m += "Cast Range: " + a.getCastRange() + "\n";
		m += "Ability Mana: " + a.getManaCost() + "\n";
		m += "Action cost: " + a.getRequiredActionPoints() + "\n";
		m += "Current CoolDown: " + a.getCurrentCooldown() + "\n";
		m += "Base CoolDown: " + a.getBaseCooldown() + "\n";
		return m;
	}

	public String Ability4() {
		Champion c = game1.getCurrentChampion();
		Ability a = c.getAbilities().get(3);
		String m = "";
		m += "Ability name: " + a.getName() + "\n";
		if (a instanceof DamagingAbility)
			m += "Ability Type: " + " Damaging" + "\n";
		if (a instanceof HealingAbility)
			m += "Ability Type: " + " Healing" + "\n";
		if (a instanceof CrowdControlAbility) {
			if (((CrowdControlAbility) a).getEffect().getType() == EffectType.BUFF)
				m += "Ability Type: " + " CrowdControl-Buff" + "\n";
			else
				m += "Ability Type: " + " CrowdControl-Debuff" + "\n";
		}
		m += "Area of Effect: " + a.getCastArea() + "\n";
		m += "Cast Range: " + a.getCastRange() + "\n";
		m += "Ability Mana: " + a.getManaCost() + "\n";
		m += "Action cost: " + a.getRequiredActionPoints() + "\n";
		m += "Current CoolDown: " + a.getCurrentCooldown() + "\n";
		m += "Base CoolDown: " + a.getBaseCooldown() + "\n";
		return m;
	}

	public void pop(Player p) {
		String s = "-fx-border-color: black;\n" + "-fx-border-insets: 1;\n"
				+ "-fx-border-width: 7;\n" + " -fx-background-color: #F2E38E;";
		Popup pop = new Popup();
		z = new Button("END GAME");
		z.setAlignment(Pos.CENTER);
		z.setId("endgame");
		z.setOnAction(this);
		Label l = new Label(p.getName() + ", You Won!");
		Text t = new Text("Congratulations!!!!");
		t.setFont(Font.font("Cooper Black", 20));
		t.setFill(Color.RED);
		l.setFont(Font.font("Cooper Black", 20));
		t.setStyle("-fx-font-weight: bold;");
		VBox v = new VBox();
		v.setPrefHeight(600);
		v.setPrefWidth(600);
		v.setStyle(s);
		v.setAlignment(Pos.CENTER);
		v.getChildren().addAll(t, l, z);
		pop.getContent().add(v);
		pop.show(view.getL4(), 635, 215);
		// pop.show(window);
		pop.centerOnScreen();
		pop.setAutoHide(true);
	}

}
