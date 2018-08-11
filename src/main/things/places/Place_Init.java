package main.things.places;

import java.util.ArrayList;

/**
 * Created by supaFool on 5/28/2018.
 */
public class Place_Init {
    private ArrayList<String> places;

    /**
     * Recommended to save the return int to an array that you can access. This, In theory, will make it
     * easier to obtain the object.
     *
     * @param place_name This is the name of the place you wish to store.
     * @return This method returns the index spot, as to which the current String has been saved.
     */
    public int addPlace(String place_name) {
        places.add(place_name);
        return places.size();
    }

    /**
     * @param place The pos in the places array as to which the cureent string name is stored.
     * @return The String that is associated with the List index.
     */
    public String getPlaceName(int place) {
        return places.get(place);
    }

}
