package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Buyinglog extends VBox {
	private ObservableList<Label> logdata = FXCollections.observableArrayList();
	private ListView<Label> logListView;
	private StackPane stack = new StackPane();
	public Buyinglog() {
		stack.setAlignment(Pos.CENTER_LEFT);
		logListView = new ListView<Label>(logdata);
		setPrefHeight(150);
		logListView.setPrefWidth(300);
		logListView.setFocusTraversable(false);
		Label BuyinglogZone = new Label("Activity log");
		BuyinglogZone.setFont(new Font(18));
		stack.getChildren().add(logListView);
		getChildren().addAll(BuyinglogZone,stack);
	}
	public void addData(String log) {
		Label nlabel = new Label(log);
		logdata.add(nlabel);
		logListView.scrollTo(nlabel);
	}
}
