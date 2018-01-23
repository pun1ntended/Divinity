package com.stevenmcgrath;

import java.util.ArrayList;

public class Player {
	private ArrayList<Attribute> attributes = new ArrayList<>();
	private ArrayList<Skill> skills = new ArrayList<>();
	private ArrayList<Talent> talents  = new ArrayList<>();
	private ArrayList<CombatAbility> combatAbilities = new ArrayList<>();
	private Weapon mainHand = null;
	private Weapon offHand = null;
	private int level = 1;
	private int minDamage =1;
	private int maxDamage = 2;
	private int allocatedSkillSlots = 0;
	private int maxSkillSlots = 4;
	private int allocatedAttributes = 60;
	private int maxAttributes = 63;
	private int allocatedTalents = 0;
	private int maxTalents = 1;
	private int allocatedCombatAbilities = 0;
	private int maxCombatAbilities = 2;
	private double criticalMultiplier = 1.5;
	
	
	public Player() {
		attributes.add(new Attribute("Strength", 10, true));
		attributes.add(new Attribute("Finesse", 10, true));
		attributes.add(new Attribute("Intelligence", 10, true));
		attributes.add(new Attribute("Constitution", 10, true));
		attributes.add(new Attribute("Memory", 10,true ));
		attributes.add(new Attribute("Wits", 10, true));
		
		attributes.add(new Attribute("Critical Chance", 5, false));
		attributes.add(new Attribute("Dodging", 0, false));
		attributes.add(new Attribute("Accuracy", 95, false));
		
		combatAbilities.add(new CombatAbility("Two Handed", 0));
		combatAbilities.add(new CombatAbility("Single Handed", 0));
		combatAbilities.add(new CombatAbility("Dual Wielding", 0));
		combatAbilities.add(new CombatAbility("Ranged", 0));
		combatAbilities.add(new CombatAbility("Aerothurge", 0));
		combatAbilities.add(new CombatAbility("Geomancer", 0));
		combatAbilities.add(new CombatAbility("Huntsman", 0));
		combatAbilities.add(new CombatAbility("Hydrosophist", 0));
		combatAbilities.add(new CombatAbility("Necromancer", 0));
		combatAbilities.add(new CombatAbility("Polymorph", 0));
		combatAbilities.add(new CombatAbility("Pyrokinetic", 0));
		combatAbilities.add(new CombatAbility("Scoundrel", 0));
		combatAbilities.add(new CombatAbility("Summoning", 0));
		combatAbilities.add(new CombatAbility("Warfare", 0));
		
		
	}
	
	public void updateSkillSlots() {
		if (attributes.get(4).getValue() > 10) {
			this.skillSlots = (4 + (attributes.get(4).getValue() - 10));
		}
	}
	
	public void equipMainHand(Weapon mainHand) {
		if (mainHand.isTwoHanded()) {
			this.mainHand = mainHand;
			this.minDamage = mainHand.getMinDamage();
			this.maxDamage = mainHand.getMaxDamage();
			equipOffHand(new Weapon(mainHand.getGoverningAttribute(), 0, 0, false, true));
			
		} else {
			this.mainHand = mainHand;
			this.minDamage = mainHand.getMinDamage();
			this.maxDamage = mainHand.getMaxDamage();
		}
	}
	
	public void equipOffHand(Weapon offHand) {
		if (mainHand.isTwoHanded()) {
			this.offHand = null;
		}
		this.offHand = offHand;
		this.minDamage = (offHand.getMinDamage() / 2);
		this.maxDamage = (offHand.getMaxDamage() / 2);
	}
	
	public void levelUp() {
		this.level += 1;
		this.maxAttributes += 2;
		this.maxCombatAbilities += 1;
		if (level == 4 || level == 10 || level == 16 || level == 22 || level == 30) {
			this.maxTalents += 1;
		}
	}
	
	public boolean assignCombatAbilityPoint(CombatAbility combatAbility) {
		if (this.allocatedCombatAbilities == this.maxCombatAbilities) {
			return false;
		}
		int position = combatAbilities.indexOf(combatAbility);
		CombatAbility selectedAbility = combatAbilities.get(position);
		selectedAbility.setValue(selectedAbility.getValue() + 1);
		this.allocatedCombatAbilities += 1;
		return true;
	}
	
	public boolean assignAttributePoint(Attribute attribute) {
		if (this.allocatedAttributes == this.maxAttributes || !attribute.isPlayerModifiable()) {
			return false;
		}
		int position = attributes.indexOf(attribute);
		Attribute selectedAttribute = attributes.get(position);
		selectedAttribute.setValue(selectedAttribute.getValue() + 1);
		return true;
	}
	
	
	
	
}
