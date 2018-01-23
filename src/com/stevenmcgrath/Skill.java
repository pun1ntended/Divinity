package com.stevenmcgrath;

public class Skill {
	private String name;
	private Family skillFamily;
	private boolean starterSkill;
	
	public Skill(String name, Family skillFamily, boolean starterSkill) {
		this.name = name;
		this.skillFamily = skillFamily;
		this.starterSkill = starterSkill;
	}
}
