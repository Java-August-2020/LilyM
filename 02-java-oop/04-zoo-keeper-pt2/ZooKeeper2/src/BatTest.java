import ZooKeeper1.Mammal;
package ZooKeeper2;
public class BatTest {

	public static void main(String[] args) {
		
		Bat bat = new Bat(300); // instantiate

        bat.getFly();
        bat.displayEnergyLevel();

        bat.getEatHumans();
        bat.displayEnergyLevel();

        bat.getAttackTown();
        bat.displayEnergyLevel();

	}

}
