//package view;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//import controller.Controller;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.control.Button;
//import javafx.stage.Stage;
//import model.abilities.Ability;
//import model.world.Champion;
//import engine.Game;
//import engine.Player;
//
//public class KeyControl implements EventHandler<ActionEvent> {
//	private static Game game;
//	private Main view;
////	private Controller key;
//
//	// btnsChamps =new ArrayList<>();
//
//	public KeyControl(Main view) throws IOException {
//		this.view = view;
////		this.key = key;
//	}
//
//	@Override
//	public void handle(ActionEvent event) {
//		if (event.getSource() instanceof Button) {
//			Button button = (Button) event.getSource();
//			if (button.getId().equals("name")) {
//				handleName(event);
//			}
//			else if (button.getId().equals("next")){
//				handleNext(event);
//			}
////			else if (button.getId().equals("select")){
////				handleSelect(event);
////			}
//		}
//	}
//
//	public void handleName(ActionEvent event) {
//		view.getDescription().setText(toString(event));
//	}
//	public void handleNext(ActionEvent event){
//		Stage window=(Stage)((Button)event.getSource()).getScene().getWindow();
//		window.setScene(view.getScene3());
//	}
////	public void handleSelect(ActionEvent event){
//////		select.setOnAction(e -> {
////		String nameChamp=
////		addToTeam(nameChamp, game.getFirstPlayer(), game.getSecondPlayer(), game.getAvailableChampions());
//////		select.setDisable(true);
//////		if(p1.getTeam().size()==3 && p2.getTeam().size()==3){
//////			next.setVisible(true);}});
////		
////}
//	public String toString(ActionEvent event) {
//		String m = "";
//		Ability a;
//		String name = ((Button) event.getSource()).getText();
//		ArrayList<Champion> champs = game.getAvailableChampions();
//		for (int i = 0; i < champs.size(); i++) {
//			Champion c = champs.get(i);
//			if (c.getName().equals(name)) {
//				// m+= "Type: " + c.getType + "\n";
//				m += "Name: " + c.getName() + "\n";
//				m += "Max HP: " + c.getMaxHP() + "\n";
//				m += "Mana:  " + c.getMana() + " \n";
//				m += "Max Action Points: " + c.getMaxActionPointsPerTurn()
//						+ "\n";
//				m += "Speed: " + c.getSpeed() + "\n";
//				m += "Attack Range: " + c.getAttackRange() + "\n";
//				m += "Attack Damage: " + c.getAttackDamage() + "\n";
//
//				for (int j = 0; j < c.getAbilities().size(); j++) {
//					a = c.getAbilities().get(j);
//					m += "Ability" + (j + 1) + ": " + "\n";
//					m += "Ability name: " + a.getName() + "\n";
//					m += "area of effect: " + a.getCastArea() + "\n";
//					m += "cast range: " + a.getCastRange() + "\n";
//					m += "ability mana: " + a.getManaCost() + "\n";
//					m += "action cost: " + a.getRequiredActionPoints() + "\n";
//					m += " current cool down: " + a.getCurrentCooldown() + "\n";
//					m += "base cool down " + a.getBaseCooldown() + "\n";
//				}
//			}
//		}
//		return m;
//
//	}
//
//
//	private void addToTeam(String name, Player p1, Player p2,
//			ArrayList<Champion> champs) {
//		for (int i = 0; i < champs.size(); i++) {
//			Champion c = champs.get(i);
//			if (c.getName().equals(name)) {
//				if (p1.getTeam().size() < 3)
//					p1.getTeam().add(c);
//				else
//					p2.getTeam().add(c);
//			}
//		}
//	}
//
//}
