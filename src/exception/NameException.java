package exception;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class NameException extends Exception implements Alertable {

	private static final long serialVersionUID = 1L;

	private String string;
	
	public NameException(String string) {
		this.string = string;
	}

	@Override
	public void showAlertBox() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setContentText(string);
		alert.show();
	}
	
	
}
