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
import java.util.HashMap;
import java.util.Map;


public class State {
	
	private String state;
	private boolean isInitialState = false;
	private boolean isFinalState = false;
	private Map<String, State> transitions;
	
	public State(String state) {
		this.state = state;
		transitions = new HashMap<String, State>();
	}
	
	public void addTransition(String letter, State transition) {
		transitions.put(letter, transition);
	}
	
	public void setIsInitial() {
		this.isInitialState = true;
	}
	
	public void setIsFinal() {
		this.isFinalState = true;
	}

	public String getState() {
		return state;
	}

	public boolean isInitialState() {
		return isInitialState;
	}

	public boolean isFinalState() {
		return isFinalState;
	}

	public State changeBy(String letter) {
		return transitions.get(letter);
	}
	
	

}
