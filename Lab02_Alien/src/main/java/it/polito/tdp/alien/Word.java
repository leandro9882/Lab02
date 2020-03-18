package it.polito.tdp.alien;

import java.util.*;

public class Word {
	String parola;
	String traslation;
	List<String> traduzioni;

	public Word(String parola, String traduzione) {
		this.parola = parola;
		this.traslation = traduzione;
		traduzioni = new LinkedList<String>();
	}

	public void addTraduzione(String t) {
		boolean giaPresente = false;
		for (String s : traduzioni) {
			if (s != null) {
				if (s.compareTo(t) == 0)
					giaPresente = true;
			}
		}
		if (giaPresente == false) {
			traduzioni.add(t);
		}
	}

	public String getTraduzioni() {
		String risultato = "";
		for (String s : traduzioni) {
			if (s != null) {
				risultato += s + "\n";
			}
		}

		return risultato.trim();
	}

	public String getParola() {
		return parola;
	}

	public String getTraslation() {
		return this.traslation;
	}

	public void setTraslation(String traslation) {
		this.traslation = traslation;
	}

}
