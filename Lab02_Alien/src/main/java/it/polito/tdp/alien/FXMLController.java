package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	private AlienDictionary dictionary;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtInput;

	@FXML
	private Button btnTranslate;

	@FXML
	private TextArea txtRisposta;

	@FXML
	private Button btnReset;

	@FXML
	void doReset(ActionEvent event) {
		txtRisposta.clear();
	}

	@FXML
	void doTranslate(ActionEvent event) {
		String testo = this.txtInput.getText().toLowerCase().trim();
		String pattern = "[a-zA-Z ]*";
		if (!testo.matches(pattern)) {
			this.txtInput.clear();
			this.txtRisposta.appendText("Inserire solo caratteri alfabetici!\n");
			return;
		}
		if (testo.contains(" ")) {
			boolean agg = false;
			String array[] = testo.split(" ");
			String parola = array[0];
			String traduzione = array[1];
			agg = dictionary.addWord(parola, traduzione);
			if (agg) {
				this.txtRisposta.appendText("parola aggiunta \n");
			} else {
				this.txtRisposta.appendText("traduzione aggiunta \n");
			}
		} else {
			this.txtRisposta.appendText(
					"La traduzione della parola " + testo + " è/sono:\n" + dictionary.getTraduzione(testo.trim()) + "\n");
		}
	}

	@FXML
	void initialize(AlienDictionary dictionary) {
		assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtRisposta != null : "fx:id=\"txtRisposta\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

	}

	public void setAlienDictionary(AlienDictionary dictionary2) {
		// TODO Auto-generated method stub
		this.dictionary = dictionary2;
	}
}
