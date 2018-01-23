package com.stevenmcgrath;

public class Attribute {
	private String name;
	private int value;
	private boolean playerModifiable;
	
	public Attribute(String name, int value, boolean playerModifiable) {
		this.name = name;
		this.value = value;
		this.playerModifiable = playerModifiable;
	}
	
	public String getName() {
		return name;
	}
	
	public int getValue() {
		return value;
	}
	
	public boolean isPlayerModifiable() {
		return playerModifiable;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
}
