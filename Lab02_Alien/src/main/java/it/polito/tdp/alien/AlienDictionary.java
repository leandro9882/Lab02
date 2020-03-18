package it.polito.tdp.alien;
import java.util.*;
public class AlienDictionary {
	List<Word> parole;
	
	public AlienDictionary() {
		parole=new LinkedList<Word>();
	}
	public boolean addWord(String nome,String traduzione) {
		Word p=new Word(nome,traduzione);
		for(Word w:parole) {
			if(w!=null) {
				if(w.getParola().compareTo(nome)==0) {
					w.addTraduzione(traduzione);
					return false;
				}
			}
		}
		parole.add(p);
		p.addTraduzione(traduzione);
		return true;
	}
	public String getTraduzione(String w) {
		for(Word p:parole) {
			if(p!=null) {
				if(p.getParola().compareTo(w)==0) {
					return p.getTraduzioni();
				}
			}
		}
		return null;
	}
	
}
