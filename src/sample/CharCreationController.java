package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import main.logic.WordLogic;
import main.things.humans.Player;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class CharCreationController {
    private String firstName;
    private String lastName;
    private Integer age;
    private String gender;
    private WordLogic wordLogic;
    private Integer SP = 50;
    private Color female_color = Color.PINK;
    private Color male_color = Color.BLUE;
    private Player player;

    @FXML
    private Button fx_continue_button;
    @FXML
    private BorderPane fx_infoscreen_borderpane;
    @FXML
    private Label fx_age_label;
    @FXML
    private Label fx_skillpoint_label;
    @FXML
    private Label fx_version_label;
    @FXML
    private Button fx_change_name_button;
    @FXML
    private Label fx_title_label;
    @FXML
    private HBox fx_infoscreen_header_wrapper_hbox;
    @FXML
    private Button fx_exit_button;
    @FXML
    private Label fx_name_label;
    @FXML
    private Label fx_gender_label;
    @FXML
    private Canvas fx_playerimage_canvas;

    private GraphicsContext gc;

    @FXML
    void ff3535(ActionEvent event) {

    }

    @FXML
    void Exit(ActionEvent event) {
        System.exit(0);
    }

    /**
     * Sets VERSION according to setting in Useful Items class
     */
    @FXML
    void setVersion() {
        fx_version_label.setText(UsefulItems.MAJOR_VERSION.toString() + "." + UsefulItems.MINOR_VERSION.toString() + "." + UsefulItems.PATCH_VERSION.toString());
    }

    @FXML
    void confirm() {
        player = new Player(gender, firstName, lastName);
        System.out.println("Player Created");
    }

    //    Updates the remaining Skill Points
    private void updateSPData(int amounttoupdate) {
        SP += amounttoupdate;
    }

    public void initialize() {
        fx_skillpoint_label.setText(SP.toString()); //sets skill point gui text
        fx_title_label.setText("Please create your pawn");
        gc = fx_playerimage_canvas.getGraphicsContext2D();
        System.out.println("gc has been made");
        setVersion();
        wordLogic = new WordLogic();
        getFirstName(null);
    }

    @FXML
    void getFirstName(ActionEvent event) {

        try {
            gender = wordLogic.getGender();
            lastName = wordLogic.getLastName();
            if (gender == "Male") {
                firstName = wordLogic.getMaleName();
            } else {
                firstName = wordLogic.getFemaleName();
            }

            age = wordLogic.getAge();
            fx_name_label.setText(firstName + " " + lastName);
            fx_age_label.setText(age.toString());
            fx_gender_label.setText(gender);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        updateSPData(-2);
        fx_skillpoint_label.setText(SP.toString());

        if (gender == "Male") {
            gc.setFill(male_color);
        } else {
            gc.setFill(female_color);
        }

        gc.fillRect(fx_playerimage_canvas.getLayoutX(), fx_playerimage_canvas.getLayoutY(), fx_playerimage_canvas.getWidth(), fx_playerimage_canvas.getHeight());
    }

}
