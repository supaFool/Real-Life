package main.things;

/**
 * Created by supaFool on 1/30/2018.
 */
public abstract class Structures extends Thing {

    private double integrity;
    private double currentIntegrity;

    public Structures(int ID, String name, double hp) {
        super(ID, name);
        this.integrity = hp;
    }

    public abstract boolean canBeDeconstructed();

    public abstract boolean canBeDamaged();

    public double getCurrentIntegrity() {
        return currentIntegrity;
    }
}
