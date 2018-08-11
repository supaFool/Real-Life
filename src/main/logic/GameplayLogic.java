package main.logic;

/**
 * Created by supaFool on 5/8/2018.
 */
public class GameplayLogic {

    private float moodLevel = 1.0f; //Default

    public void figureMood(float moodLevel) {
        MOOD mood;//mood spaceholder
        if (moodLevel <= .33335) {
            mood = MOOD.ANGRY;
        } else if (moodLevel > .33335 && moodLevel < .66665) {
            mood = MOOD.SAD;
        } else if (moodLevel > .66665) {
            mood = MOOD.HAPPY;
        } else {
            mood = MOOD.HAPPY;
        }
        System.out.println(mood);
    }

    public enum MOOD {
        HAPPY, SAD, ANGRY
    }
}
