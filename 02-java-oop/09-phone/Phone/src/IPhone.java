public class IPhone extends Phone implements Ringable {
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
      //testing @Deprecated
    @Deprecated
    public String ring() {
    	return "iPhone " + "says "+ this.getVersionNumber() + " " + this.getRingTone() + "!";
    }
//    @Override
    public String unlock() {
    	return "Please place thumb on screen to unlock";
    }
    @Override
    public void displayInfo() {
    	System.out.println("iPhone " + this.getVersionNumber() + " " + "from " + this.getCarrier());       
    }
}
