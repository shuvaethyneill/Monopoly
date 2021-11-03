import javax.swing.*;
import java.awt.*;

/**
 * The BoardSpace class is an abstract class that
 * represents a space on the board
 *
 * @author Evan Smedley
 * @version 1.0
 * @since 2021-10-22
 */
public abstract class BoardSpace extends JPanel {

    /**
     * The name of the board space
     */
    private final String name;

    /**
     * The type of board space
     */
    private final String type;

    /**
     * The constructor for a BoardSpace object
     */
    public BoardSpace(String name, String type) {
        super();
        this.name = name;
        this.type = type;

        this.add(new JLabel(name, JLabel.CENTER), BorderLayout.PAGE_START);
    }

    /**
     * Getter for the name of the board space
     *
     * @return String, name of the board space
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for the type of the board space
     *
     * @return String, type of the board space
     */
    public String getType() {
        return this.type;
    }

    /**
     * An abstract method for displaying information about the board space
     */
    public abstract void displayInfo();

    public abstract void updatePanel();
}
