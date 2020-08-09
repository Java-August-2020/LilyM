import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import java.util.Set;
import java.util.HashMap;

public class TrackList{
    public static void main(String[] args) {
        HashMap<String, String> trackMap = new HashMap<String, String>();
        trackMap.put("WHEN THE Covid IS GONE", 
        "One day the Covid will be gone and life as we knew it will go on...");
        trackMap.put("STAYCATION BLUES",
         "I've traveled near and far, from my kitchen to my bar...");
        trackMap.put("THE WORLD OUTSIDE my WINDOW",
         "I didn't see all the bees and butterflies, I never saw the birds hanging out on the trees...");
         trackMap.put("TAKE-OUT DELIGHT",
         "Hey, calling all my fav restaurants and givin' them the business...");
        // get the keys by using the keySet method
        Set<String> keys = trackMap.keySet();
        for(String key : keys) {
            System.out.println(key);
            System.out.println(trackMap.get(key));    
        }
    }
}

