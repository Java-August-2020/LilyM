
public class Gorilla extends Mammal {

	public Gorilla(int energyLevel) {
		super(energyLevel);
	}

	public int throwThings() {
		System.out.println("Throwing Things");
		return energyLevel -= 5;
	}

	public int eatBananas() {
		System.out.println("Gorilla is satisfied");
		return energyLevel += 5;
	}

	public int climb() {
		System.out.println("Gorilla climbed a tree");
		return energyLevel -= 5;
	}
}
