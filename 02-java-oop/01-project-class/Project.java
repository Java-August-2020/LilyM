
public class Project {

  // Create a Project class that has the fields of name and description.
  // Create an instance method called elevatorPitch that will return the name and description separated by a colon.
  // Overload the constructor method in three different ways.
  //      public Project() {}
  //      public Project(String name) {}
  //      public Project(String name, String description) {}
  // Create getter and setters for each field
  // Create a ProjectTest file that will test all the functionality.

  private String name;
  private String description;

    public String elevatorPitch(String nameParm, String descParm){
      // System.out.println("Project Name and Description ->: " + nameParm + " : " + descParm);
      String returnField = (nameParm + " : " + descParm);
      return returnField;
    }

    public Project(){
      //ask about this empty one...am I understanding the different constructs?
    }

    public Project(String name) {
      this.name = name;
    }

    public Project(String name, String description) {
      this.name = name;
      this.description = description;
    }

    // name getter/setter
    public String getName() {
        return this.name;
    }
    public void setName(String nameParm) {
        this.name = nameParm;      
    }
    // description  getter/setter
    public String getDesc() {
      return this.description;
    }
    public void setDesc(String descParm) {
      this.description = descParm;      
    }
    
}