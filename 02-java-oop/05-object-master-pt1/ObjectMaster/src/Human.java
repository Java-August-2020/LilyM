
public class Human {
	
	protected int healthLevel = 100; // available within same PACKAGE
	protected int strength = 3;
	protected int intelligence = 3;
	protected int stealth = 3;
	
	
	public Human(int healthLevel) {
		this.healthLevel = healthLevel;
		this.strength = strength;
		this.intelligence = intelligence;
		this.stealth = stealth;		
	}

	//getters/setters**
	public int getHealthLevel() {
		return healthLevel;
	}
	public void setHealthLevel(int healthLevel) {
		this.healthLevel = healthLevel;
	}

	//methods
	public int displayHealthLevel() {
		System.out.println("Health Level is:" + getHealthLevel());
		return getHealthLevel();
	}
	
	public int attackedHuman() {     //reduce health by strength
		System.out.println("Attacked Human");
		return healthLevel = healthLevel - strength;
	}


}
