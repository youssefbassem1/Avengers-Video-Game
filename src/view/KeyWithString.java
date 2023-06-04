package view;

import java.io.IOException;
import java.util.ArrayList;

import model.world.Champion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import controller.Controller;
import engine.Game;
import engine.Player;

public class KeyWithString implements EventHandler<ActionEvent> {
	private static Game game;
	private Main view;
	private Controller key;
	private String text;

	// btnsChamps =new ArrayList<>();

	public KeyWithString(Main view, Controller key, String text)throws IOException{
		this.view = view;
		this.key = key;
		this.text = text;
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() instanceof Button) {
			Button button = (Button) event.getSource();
			if (button.getId().equals("select")) {
				handleSelect(event);
			}
		}
	}

	public void handleSelect(ActionEvent event) {
		String nameChamp = text;
		System.out.println(game.getAvailableChampions().size());
		System.out.println(key.getGame().getFirstPlayer().getName());
		addToTeam(nameChamp, game.getFirstPlayer(), game.getSecondPlayer(),game.getAvailableChampions());
		 ((Button)event.getSource()).setDisable(true);
		// if(p1.getTeam().size()==3 && p2.getTeam().size()==3){
		// next.setVisible(true);}});

	}

	private void addToTeam(String name, Player p1, Player p2,
			ArrayList<Champion> champs) {
		for (int i = 0; i < champs.size(); i++) {
			Champion c = champs.get(i);
			if (c.getName().equals(name)) {
				if (p1.getTeam().size() < 3)
					p1.getTeam().add(c);
				else
					p2.getTeam().add(c);
			}
		}
	}
}
