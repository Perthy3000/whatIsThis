package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

public class BattleLog extends StackPane {
	
	private ObservableList<Label> logdata = FXCollections.observableArrayList();
	private ListView<Label> logListView;
	
	public BattleLog() {
		setStyle("-fx-padding: 15;" + 
                      "-fx-background-width: 3;" +
                      "-fx-background-insets: 5;" + 
                      "-fx-background-image: url(file:pokemon/border3.png);" +
                      "-fx-background-size: 425 150;" +
                      "-fx-background-position: top center;" +
                      "-fx-background-repeat: no-repeat;");
		setAlignment(Pos.CENTER);
		logListView = new ListView<Label>(logdata);
		setPrefHeight(150);
		logListView.setMaxWidth(400);
		logListView.setFocusTraversable(false);
		
		getChildren().addAll(logListView);
	}
	
	public void addData(String log) {
		Label nlabel = new Label(log);
		logdata.add(nlabel);
		logListView.scrollTo(nlabel);
	}
	
	public ListView<Label> getListView() {
		return logListView;
	}
}
