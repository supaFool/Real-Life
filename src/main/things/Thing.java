package main.things;

/**
 * Created by supaFool on 1/30/2018.
 *
 * Parent class of everything playerside.
 */
public abstract class Thing implements intf_Thing {
    private int ID;
    private String name;

    public Thing(int ID, String name) {
        this.name = name;
        this.ID = ID;
    }

//    ID given by the xaml

    @Override
    public int getId() {
        return ID;
    }

//    The name that the game will use to refer to this to the player

    @Override
    public String getNameOfThing() {
        return name;
    }
}
