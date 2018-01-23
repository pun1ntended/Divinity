package com.stevenmcgrath;

public class CombatAbility {
	private String name;
	private int value;
	
	
	public CombatAbility(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	
	public int getValue() {
		return value;
	}
}
