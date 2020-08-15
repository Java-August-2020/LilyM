
public class Mammal {

	protected int energyLevel = 100; // available within the same package

	public Mammal(int energyLevel) {
		this.energyLevel = energyLevel;
	}

	/**
	 * @return the energyLevel
	 */
	public int getEnergyLevel() {
		return energyLevel;
	}

	/**
	 * @param energyLevel the energyLevel to set
	 */
	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}

	public int displayEnergyLevel() {
		System.out.println("Energy Level is:" + getEnergyLevel());
		return getEnergyLevel();
	}
}
