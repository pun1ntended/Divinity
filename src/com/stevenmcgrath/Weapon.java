package com.stevenmcgrath;

public class Weapon {
	private Attribute governingAttribute;
	private boolean mainHand;
	private boolean offHand;
	private int minDamage;
	private int maxDamage;
	
	public Weapon(Attribute governingAttribute, int minDamage, int maxDamage, boolean mainHand, boolean offHand) {
		this.governingAttribute = governingAttribute;
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
		this.mainHand = mainHand;
		this.offHand = offHand;
	}
	
	public Attribute getGoverningAttribute() {
		return governingAttribute;
	}
	
	public int getMinDamage() {
		return minDamage;
	}
	
	public int getMaxDamage() {
		return maxDamage;
	}
	
	public boolean isTwoHanded() {
		return mainHand && offHand;
	}
}
