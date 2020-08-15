
public class Galaxy extends Phone implements Ringable {

	public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
	//testing @Deprecated
	@Deprecated
    public void displayInfo() {
        System.out.println("Galaxy " + this.getVersionNumber() + " " + "from " + this.getCarrier());

    }

    @Override
    public String ring() {
        return "Galaxy " + "says "+ this.getVersionNumber() + " " + this.getRingTone() + "!";
    }

    @Override
    public String unlock() {
        return "Unlocking via finger print";
    }
}
