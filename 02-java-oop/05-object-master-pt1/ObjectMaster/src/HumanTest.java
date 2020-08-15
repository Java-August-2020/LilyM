
public class HumanTest {

	public static void main(String[] args) {
		
		Human human = new Human(100);    //instantiate
		human.displayHealthLevel();
		human.attackedHuman();
//		human.attackedHuman();
		human.displayHealthLevel();
		
//another type of Human
		Wizard wizard = new Wizard(100);
		wizard.getHealHuman();
		wizard.displayHealthLevel();  //why this is not human.displayHealthLevel
		
//another type of Human
		Ninja ninja = new Ninja (100);
		ninja.runAway();
		ninja.displayHealthLevel();  //why this is not human.displayHealthLevel
			
	}

}
