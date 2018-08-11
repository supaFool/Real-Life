package main.logic;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by supaFool on 2/6/2018.
 * <p>
 * Part of the AI that builds stories
 */
public class WordLogic {

    private String rootLocation = "src\\main\\logic\\words\\";
    private Random r = new Random();

    public WordLogic() {
        try {
            makeConditionIfIWill();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getAge() {
        int age = 0;
        while (age < 16) {
            age = r.nextInt(75);
        }
        return age;
    }

    public String getGender() {
        if (r.nextBoolean() == true) {
            return "Male";
        } else {
            return "Female";
        }
    }

    public String getAdverb() throws IOException, SAXException, ParserConfigurationException {
        FileReader input = new FileReader(rootLocation + "Adverbs.txt");
        BufferedReader bufRead = new BufferedReader(input);
        String myLine;
        ArrayList<String> adverbs = new ArrayList<>();
        while ((myLine = bufRead.readLine()) != null) {
            adverbs.add(myLine.trim());
        }
        return adverbs.get(r.nextInt(adverbs.size()));
    }

    public String getAdjective() throws IOException, SAXException, ParserConfigurationException {
        FileReader input = new FileReader(rootLocation + "Adjectives.txt");
        BufferedReader bufRead = new BufferedReader(input);
        String myLine;
        ArrayList<String> adjective = new ArrayList<>();
        while ((myLine = bufRead.readLine()) != null) {
            adjective.add(myLine.trim());
        }
        return adjective.get(r.nextInt(adjective.size()));
    }

    public String getVerb() throws IOException, SAXException, ParserConfigurationException {
        FileReader input = new FileReader(rootLocation + "Verbs.txt");
        BufferedReader bufRead = new BufferedReader(input);
        String myLine;
        ArrayList<String> verbs = new ArrayList<>();
        while ((myLine = bufRead.readLine()) != null) {
            verbs.add(myLine.trim());
        }
        return verbs.get(r.nextInt(verbs.size()));
    }

    public String getPreposition() throws IOException, SAXException, ParserConfigurationException {
        FileReader input = new FileReader(rootLocation + "Prepositions.txt");
        BufferedReader bufRead = new BufferedReader(input);
        String myLine;
        ArrayList<String> prepositions = new ArrayList<>();
        while ((myLine = bufRead.readLine()) != null) {
            prepositions.add(myLine.trim());
        }
        return prepositions.get(r.nextInt(prepositions.size()));
    }

    public String getNoun() throws IOException, SAXException, ParserConfigurationException {
        FileReader input = new FileReader(rootLocation + "Nouns.txt");
        BufferedReader bufRead = new BufferedReader(input);
        String myLine;
        ArrayList<String> nouns = new ArrayList<>();
        while ((myLine = bufRead.readLine()) != null) {
            nouns.add(myLine.trim());
        }
        return nouns.get(r.nextInt(nouns.size()));
    }

    public String getFemaleName() throws IOException, SAXException, ParserConfigurationException {
        FileReader input = new FileReader(rootLocation + "female-first.txt");
        BufferedReader bufRead = new BufferedReader(input);
        String myLine;
        ArrayList<String> names = new ArrayList<>();
        while ((myLine = bufRead.readLine()) != null) {
            names.add(myLine.replaceAll("[0-9 , .]", "").trim());
        }
        return names.get(r.nextInt(names.size()));
    }

    public String getMaleName() throws IOException, SAXException, ParserConfigurationException {
        FileReader input = new FileReader(rootLocation + "male-first.txt");
        BufferedReader bufRead = new BufferedReader(input);
        String myLine;
        ArrayList<String> names = new ArrayList<>();
        while ((myLine = bufRead.readLine()) != null) {
            names.add(myLine.replaceAll("[0-9 , .]", "").trim());
        }
        return names.get(r.nextInt(names.size()));
    }

    public String getLastName() throws IOException, SAXException, ParserConfigurationException {
        FileReader input = new FileReader(rootLocation + "last.txt");
        BufferedReader bufRead = new BufferedReader(input);
        String myLine;
        ArrayList<String> last_names = new ArrayList<>();
        while ((myLine = bufRead.readLine()) != null) {
            last_names.add(myLine.replaceAll("[0-9 , .]", "").trim());
        }
        return last_names.get(r.nextInt(last_names.size()));
    }

    //    First method made EXAMPLE RETURN (If you pour slowly the delightful branch, I will learn the little mountain.)
    public String makeConditionIfIWill() throws ParserConfigurationException, SAXException, IOException {
        String sent;
        int limit = 125;
        int compare = limit / 100;
        int ran = r.nextInt(limit);
        if (ran <= compare) {
            sent = "If" + (r.nextBoolean() ? " you " : " they ") + getVerb() + " " + (r.nextBoolean() ? getAdverb() + " " : "") + "the " + (r.nextBoolean() ? getAdjective() + " " : "") + (r.nextBoolean() ? getAdjective() + " " : "") + getNoun() + (r.nextBoolean() ? ", I " : ", They ") + "will " + getVerb() + " the " + (r.nextBoolean() ? getAdjective() + " " : "") + getNoun() + ".";

            return sent;
        } else {

            return null;
        }

    }
}
