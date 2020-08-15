
public class Human2 {
	private int healthLevel = 100; // available within this class
	private int strength = 3;
	private int intelligence = 3;
	private int stealth = 3;
	
	
	public Human2(int healthLevel) {
		this.healthLevel = healthLevel;
	}

	//getters/setters**
	public int getHealthLevel() {
		return healthLevel;
	}

	public void setHealthLevel(int healthLevel) {
		this.healthLevel = healthLevel;
	}

	public int displayHealthLevel() {
		System.out.println("Health Level is:" + getHealthLevel());
		return getHealthLevel();
	}
	
	public int attackedHuman() {     //reduce health by strength
		System.out.println("Attacked Human");
		return healthLevel = healthLevel - strength;
	}


}
