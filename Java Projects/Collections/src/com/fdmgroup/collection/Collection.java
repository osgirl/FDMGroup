package com.fdmgroup.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashMap;
import java.awt.Color;

public class Collection {
	private Set<String> firstNameSeries;
	private Map<String, Color> colorHashMap;
	private Map<Character, Integer> characterHashMap;
	private List<String> duplicatedWords;
	private List<?> reverseList;
	private Set<String> tokenizedString; 
	private Queue<Double> prioritize;
	
	//Constructor
	public Collection(){
		firstNameSeries = new TreeSet<String>();
		colorHashMap = new HashMap<String, Color>();
		characterHashMap = new HashMap<Character, Integer>();
		duplicatedWords = new ArrayList<String>();
		reverseList = new LinkedList<Object>();
		tokenizedString = new TreeSet<String>();
	}

	//Part II Number 1
	protected Set<String> storeUniqueNames(String...names){
		if(names != null){
			for(String name : names){
				if(!(firstNameSeries.contains(name))){
					firstNameSeries.add(name);
				}
			}
		}
		return firstNameSeries;
	}
	
	protected Set<String> getFirstNameSeries() {
		return firstNameSeries;
	}

	protected void setFirstNameSeries(Set<String> firstNameSeries) {
		this.firstNameSeries = firstNameSeries;
	}
	
	//Part II Number 2
	protected void setHashMapColor(){
		colorHashMap.put("black", Color.black);
		colorHashMap.put("blue", Color.blue);
		colorHashMap.put("cyan", Color.cyan);
		colorHashMap.put("darkgray", Color.darkGray);
		colorHashMap.put("gray", Color.gray);
		colorHashMap.put("green", Color.green);
		colorHashMap.put("lightgray", Color.lightGray);
		colorHashMap.put("magenta", Color.magenta);
		colorHashMap.put("orange", Color.orange);
		colorHashMap.put("pink", Color.pink);
		colorHashMap.put("red", Color.red);
		colorHashMap.put("white", Color.white);
		colorHashMap.put("yellow", Color.yellow);
	}

	protected HashMap<String, Color> getHashMapColor(){
		setHashMapColor();
		return (HashMap<String, Color>) colorHashMap;
	}
	
	//Part II Number 3
	protected void getCharacterCount(String input){
		if(input != null){
			for(int index = 0; index < input.length(); index++){
				if((characterHashMap.isEmpty()) && (Character.isLetter(input.charAt(index)))){
					characterHashMap.put(input.charAt(index), 1);
				}
				else if((characterHashMap.containsKey(input.charAt(index))) && (Character.isLetter(input.charAt(index)))){
					int newCount = characterHashMap.get(input.charAt(index));
					characterHashMap.put(input.charAt(index), newCount);
				}
			}
		}
	}
	
	protected HashMap<Character, Integer> getCharacterHashMap() {
		return (HashMap<Character, Integer>) characterHashMap;
	}

	protected void setCharacterHashMap(HashMap<Character, Integer> characterHashMap) {
		this.characterHashMap = characterHashMap;
	}
	
	//Part II Number 4
	protected ArrayList<String> getWordsInSentence(String sentence){
		if(sentence == null){
			return null;
		}
		
		String[] words = sentence.split(" ");
		for(String word1 : words){
			for(String word2 : words){
				if(word1.toLowerCase().compareTo(word2.toLowerCase()) == 0){
					if(!(duplicatedWords.contains(word1))){
						duplicatedWords.add(word1);
					}
				}
			} 
		}
		return (ArrayList<String>) duplicatedWords;
	}
	
	//Part II Number 5
	protected <T> LinkedList<T> reverseLinkedList(LinkedList<T> linked){
		if(linked != null){
			LinkedList<T> temp = new LinkedList<T>();
			for(int index = linked.size(); index >= 0; index++){
				temp.add(linked.get(index));
			}
			reverseList = temp;
		}
		return (LinkedList<T>) reverseList;
	}
	
	//Part II Number 6
	protected TreeSet<String> tokenizeString(String textInput){
		if(textInput == null){
			return null;
		}
		String[] temp = textInput.split(" ");
		for(String text : temp){
			tokenizedString.add(text);
		}
		return (TreeSet<String>) tokenizedString;
	}
	
	//Part II Number 7
	protected void descendDouble(Double...args){
		prioritize = new PriorityQueue<Double>();
		for(Double myDouble : args){
			prioritize.add(myDouble);
		}
	}
}
