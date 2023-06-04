package controller;

import model.abilities.Ability;
import model.world.Champion;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import view.Main;
import engine.Game;

public class MouseControl implements EventHandler<MouseEvent> {
	private static Game game;
	private Main view;
	private boolean direction;
	private Controller controller;
	private int abNum;

	public MouseControl(Main view, Game g) {
		// System.out.println("key constructor");
		this.view = view;
		game = g;
	}

	public void handle(MouseEvent event) {
		if (((Button) event.getSource()).getId().equals("1")) {
			handleAbility(event);
		}

	}

	private void handleAbility(MouseEvent event) {
		Champion c = game.getCurrentChampion();
		Ability a = c.getAbilities().get(
				Integer.parseInt(((Button) event.getSource()).getId()) - 1);
		String m = "";
		m += "Ability name: " + a.getName() + "\n";
		m += "area of effect: " + a.getCastArea() + "\n";
		m += "cast range: " + a.getCastRange() + "\n";
		m += "ability mana: " + a.getManaCost() + "\n";
		m += "action cost: " + a.getRequiredActionPoints() + "\n";
		m += " current cool down: " + a.getCurrentCooldown() + "\n";
		m += "base cool down " + a.getBaseCooldown() + "\n";
		System.out.println(m);

	}
}
