
public class Ninja extends Human {

		private int ninjaStealth = 10; 
			
		public Ninja (int healthLevel) {
			super(healthLevel);
			this.ninjaStealth = ninjaStealth;
		}
		
		public int runAway() {
			System.out.println("I am a running Ninja -stealing your health by 10 points!");
			return healthLevel = healthLevel - 10;
		}
		public void getRunAway() {
	        runAway();
	    }
		

	
	
}
