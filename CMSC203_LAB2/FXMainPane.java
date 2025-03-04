package application;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {
	//student Task #2:
	Button but1;
	Button but2;
	Button but3;
	Button but4;
	Button but5;
	Button but6;
	Label label;
	TextField textField;
	HBox hBox1;
	HBox hBox2;
	
	//student Task #4:
	DataManager dataManager;
	
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		but1 = new Button("Hello");
		but2 = new Button("Howdy");
		but3 = new Button("Chinese");
		but4 = new Button("Clear");
		but5 = new Button("Exit");
		label = new Label("Feedback:");
		textField = new TextField();
		hBox1 = new HBox();
		hBox2 = new HBox();
		
		//student Task #4:
		dataManager = new DataManager();
		but1.setOnAction(new ButtonHandler());
		but2.setOnAction(new ButtonHandler());
		but3.setOnAction(new ButtonHandler());
		but4.setOnAction(new ButtonHandler());
		but5.setOnAction(new ButtonHandler());
		Insets inset = new Insets(10);
		HBox.setMargin(but1, inset);
		HBox.setMargin(but2, inset);
		HBox.setMargin(but3, inset);
		HBox.setMargin(but4, inset);
		HBox.setMargin(but5, inset);
		hBox1.setAlignment(Pos.CENTER);
		hBox2.setAlignment(Pos.CENTER);
		
		but6 = new Button("Russian");
		but6.setOnAction(new ButtonHandler());
		HBox.setMargin(but6, inset);
		
		//student Task #3:
		hBox1.getChildren().addAll(but1, but2, but3, but6, but4, but5);
		hBox2.getChildren().addAll(label, textField);
		this.getChildren().addAll(hBox1, hBox2);
	}
	
	//Task #4:
	class ButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			EventTarget target = event.getTarget();
			if(target == but1) {
				textField.setText(dataManager.getHello());
			} else if(target == but2) {
				textField.setText(dataManager.getHowdy());
			} else if(target == but3) {
				textField.setText(dataManager.getChinese());
			} else if(target == but4) {
				textField.setText("");
			} else if(target == but5) {
				Platform.exit();
				System.exit(0); 
			} else if(target == but6) {
				textField.setText(dataManager.getRussian());
			}
		}
		
	}
}
	
