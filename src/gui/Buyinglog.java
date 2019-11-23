package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;

public class Buyinglog extends StackPane {
	private ObservableList<Label> logdata = FXCollections.observableArrayList();
	private ListView<Label> logListView;
	public Buyinglog() {
		setAlignment(Pos.CENTER);
		logListView = new ListView<Label>(logdata);
		setPrefHeight(150);
		logListView.setPrefWidth(300);
		logListView.setFocusTraversable(false);
		
		getChildren().add(logListView);
	}
	public void addData(String log) {
		Label nlabel = new Label(log);
		logdata.add(nlabel);
		logListView.scrollTo(nlabel);
	}
}
