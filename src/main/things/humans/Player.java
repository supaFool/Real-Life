package main.things.humans;

/**
 * Created by supaFool on 5/27/2018.
 */
public class Player {

    protected String gender;
    protected String firstName;
    protected String lastName;
    private String ID;

    public Player(String gender, String firstname, String lastname) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.gender = gender;

        init();
    }

    private void init() {
        createID();
        System.out.println(getID());
    }

    private void createID() {
        ID = firstName + " " + lastName;
    }

    public String getID() {
        return ID;
    }

}
