
public class Wizard extends Human {

	private int wizHealth = 50; 
	private int wizIntelligence = 8;
	
	public Wizard(int healthLevel) {
//	public Wizard(int wizHealth,  int wizIntelligence ) {
		super(healthLevel);
		this.wizHealth = wizHealth;
		this.wizIntelligence = wizIntelligence;
	}
	
	public int healHuman() {
		System.out.println("Healing other Humans by the Wizard's Intelligence");
		return healthLevel = healthLevel + wizIntelligence;
	}
	public void getHealHuman() {
        healHuman();
    }
	
}
