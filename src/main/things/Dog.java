package main.things;

import main.logic.GameplayLogic;

/**
 * Created by supaFool on 2/6/2018.
 */
public class Dog extends Being {


    public Dog(int ID, String name, GameplayLogic.MOOD mood, int age, Being.Gender gender) {
        super(ID, name, mood, age, gender);
    }

    @Override
    public double getweight() {
        return 35;
    }

    @Override
    public String getDescription() {
        return "A Tame Animal";
    }

    @Override
    public boolean isHostile() {
        return false;
    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public boolean isPlayer() {
        return false;
    }
}
