/*
	Automata Implementation in JAVA.
    Copyright (C) 2015 Author: Rubens Pessoa de Barros Filho

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package dfa;
import java.util.ArrayList;
import dfa.State;

public class Automata {
	
	private static ArrayList<State> states;
	private ArrayList<String> alphabet;
	
	public Automata(){
		Automata.states = new ArrayList<State>();
		this.alphabet = new ArrayList<String>();
	}
	
	public void addLetter(String letter) {
		this.alphabet.add(letter);
	}
	
	public void addState(State state) {
		Automata.states.add(state);
	}
	
	public static State searchFor(String state) {
		for (int i = 0; i < states.size(); i++) {
			if (states.get(i).getState().equals(state)) {
				return states.get(i);
			}
		}
		return null;
	}

	public static ArrayList<State> getStates() {
		return states;
	}

	public ArrayList<String> getAlphabet() {
		return alphabet;
	}
	
	public State getInitialState() {
		for (int i = 0; i < states.size(); i++) {
			if (states.get(i).isInitialState()) {
				return states.get(i);
			}
		}
		return null;
	}
}
