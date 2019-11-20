package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;

public class BattleLog extends StackPane {
	
	private ObservableList<Label> logdata = FXCollections.observableArrayList();
	private ListView<Label> logListView;
	
	public BattleLog() {
		logListView = new ListView<Label>(logdata);
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
