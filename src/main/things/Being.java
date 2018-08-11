package main.things;

import main.logic.GameplayLogic.MOOD;

/**
 * Created by supaFool on 1/30/2018.
 *
 * Being is anything that is living
 *
 */
public abstract class Being extends Thing {

    private MOOD mood;
    private int age;
    private Gender gender;
    private int life_expectancy;
    private int stat_length = 25;

    public Being(int ID, String name, MOOD mood, int age, Gender gender) {
        super(ID, name);
        this.age = age;
        this.gender = gender;
        this.mood = mood;
    }



    //    GETTERS and SETTERS
    public MOOD getMood() {
        return mood;
    }

    public void setMood(MOOD mood) {
        this.mood = mood;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    //    OVERRIDES
    @Override
    public boolean typeCanBeModded() {
        return false;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public boolean isLiving() {
        return true;
    }

    //    ABSTRACTS
    public abstract boolean isHostile();

    public abstract boolean isDead();

    public abstract boolean isPlayer();

    //    LOCAL
    public enum Gender {
        MALE, FEMALE
    }

    public void die(){
        //TODO
        //Removes this object from memory
    }

    public class Mood {
        //        Anything that has a positive mood enhancement should add to this
        private float positiveModifier = 0;
        //       Anything that has a negative mood enhancement should add to this
        private float negativeModifier = 0;

        //        Adds to Modifier, then when comes time will subtract;
        public void addToNegMoodMod(float amount_to_add) {
            this.negativeModifier += amount_to_add;
        }

        public float getNegativeModifier() {
            return this.negativeModifier;
        }
    }

    public String[] getStats(){

        String[] stats = new String[25];

        return null;
    }

    public int getLife_expectancy() {
        return life_expectancy;
    }

    public void setLife_expectancy(int life_expectancy) {
        this.life_expectancy = life_expectancy;
    }
}

