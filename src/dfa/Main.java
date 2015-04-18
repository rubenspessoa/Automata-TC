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
import java.util.Scanner;
import java.util.StringTokenizer;
import dfa.State;
import dfa.Automata;

public class Main {
	
	public static boolean verifyWord(Automata automata, String word) {
		
		State actualState = automata.getInitialState();
		
		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			if (!automata.getAlphabet().contains(Character.toString(letter))) {
				return false;
			} else {
				actualState = actualState.changeBy(Character.toString(letter));
			}
		}
		
		if (actualState.isFinalState()) {
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
		// AUTOMATA DATA ENTRY
		
		Scanner entry = new Scanner(System.in);
		
		String statesEntry = entry.nextLine();
		statesEntry = (String) statesEntry.subSequence(5, statesEntry.length() - 1);
		String[] states = statesEntry.split(",");
		
		String alphabetEntry = entry.nextLine();
		alphabetEntry = (String) alphabetEntry.subSequence(5, alphabetEntry.length() - 1);
		String[] alphabet = alphabetEntry.split(",");
		
		String transitionsEntry = entry.nextLine();
		transitionsEntry = (String) transitionsEntry.subSequence(5, transitionsEntry.length() - 1);
		StringTokenizer multiTokenizer = new StringTokenizer(transitionsEntry, " (),");
		ArrayList<String> statesTransitions = new ArrayList<String>();
		while (multiTokenizer.hasMoreTokens()) {
			statesTransitions.add(multiTokenizer.nextToken());
		}
		
		String initialStatesEntry = entry.nextLine();
		initialStatesEntry = (String) initialStatesEntry.subSequence(5, initialStatesEntry.length());
		String[] initialStates = initialStatesEntry.split(",");
		
		String finalStatesEntry = entry.nextLine();
		finalStatesEntry = (String) finalStatesEntry.subSequence(5, finalStatesEntry.length() - 1);
		String[] finalStates = finalStatesEntry.split(",");
		
		String wordEntry = entry.nextLine();
		wordEntry = (String) wordEntry.subSequence(4, wordEntry.length());
		
		entry.close();

		// AUTOMATA CREATION
		System.out.println("Criacao do Automato");
		
		Automata automata = new Automata();
		System.out.println("Criou do Automato");
		
		for (String letter : alphabet) {
			System.out.println(letter);
			automata.addLetter(letter);
		}
		
		// STATES CREATION
		
		System.out.println("Criacao de Estados");
		for (String state : states) {
			State q = new State(state);
			automata.addState(q);
		}
		System.out.println("Criou de Estados");
		
		// ADDING TRANSITIONS
		
		System.out.println("adicao de transicoes");
		for (int i = 1; i < statesTransitions.size(); i = i + 2) {			
			String transition = statesTransitions.get(i);
			State fromState = Automata.searchFor(statesTransitions.get(i - 1));
			StringTokenizer multiTokenizer1 = new StringTokenizer(transition, "->");
			while (multiTokenizer1.hasMoreTokens()) {
				String letter = multiTokenizer1.nextToken();
				State toState = null;
				if (multiTokenizer1.hasMoreTokens()) {
					toState = Automata.searchFor(multiTokenizer1.nextToken());
				}
				
				fromState.addTransition(letter, toState);
			}
		}
		System.out.println("criou transicoes");
		
		// SET INITIAL STATES
		
		for (int i = 0; i < initialStates.length; i++) {
			State state = Automata.searchFor(initialStates[i]);
			state.setIsInitial();
		}
		
		// SET FINAL STATES
		
		for (int i = 0; i < finalStates.length; i++) {
			State state = Automata.searchFor(finalStates[i]);
			state.setIsFinal();
		}
		
		// LET THE GAME BEGINS
		
		if (verifyWord(automata, wordEntry)) {
			System.out.println("ACEITA");
		} else {
			System.out.println("REJEITA");
		}
	}
}
