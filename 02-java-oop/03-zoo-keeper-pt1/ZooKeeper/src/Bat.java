
public class Bat extends Mammal {

    public Bat(int energyLevel) {
        super(300);
    }

    private int fly() {
        System.out.println("Bat is Flying");
        return energyLevel -= 50;
    }

    public void getFly() {
        fly();
    }


    private int eatHumans() {
        System.out.println("So-well, never mind");
        return energyLevel += 25;
    }


    public void getEatHumans() {
        eatHumans();
    }


    private int attackTown() {
        System.out.println("Town is on Fire");
        return energyLevel -= 100;
    }


    public void getAttackTown() {
        attackTown();
    }

}
