import java.util.ArrayList;

public class ProjectTest {
    public static void main(String[] args) {
        //elevatorPitch
        Project iD = new Project();
        String name = "Covid-19";
        String description = "Eradicating Covid-19";
        String projNameDesc = iD.elevatorPitch(name, description);
        System.out.println("This is my Elevator Pitch -> " + projNameDesc); 

        //getters/setters
        Project newProject = new Project("Java Bootcamp", "Become a Java Ninja @Dojo");
            // System.out.println(newProject.getName());
            // System.out.println(newProject.getDesc());
        System.out.println("Project:  " + newProject.getName() + " : " + newProject.getDesc());
        newProject.setName("Gardening");
        newProject.setDesc("Learn to have a green thumb!");     
        System.out.println("Project:  " + newProject.getName() + " : " + newProject.getDesc());
        
    }
}


