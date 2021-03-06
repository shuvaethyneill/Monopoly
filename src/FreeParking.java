import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * The FreeParking class extends BoardSpace and represents
 * a space that is specifically free parking
 *
 * @author Evan Smedley
 * @verion 1.0
 * @since 2021-10-22
 */
public class FreeParking extends BoardSpace {

    /**
     * The amount of money currently at free parking
     */
    private int amount;

    public FreeParking() {
        this("", "", -1);
    }

    /**
     * FreeParking constructor
     *
     * @param name String, the name of the free parking space
     */
    public FreeParking(String name, String path, int position) {
        super(name, "free parking", path, position);
        this.amount = 0;
    }

    /**
     * A method to add an amount of money to free parking
     *
     * @param amount int, the amount of money to add
     */
    public void addAmount(int amount) {
        this.amount += amount;
    }

    /**
     * A getter for the amount of money currently at free parking
     *
     * @return int, the amount of money currently at free parking
     */
    public int getAmount() {
        return this.amount;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
        ImageIcon freeParkingIcon = null;
        boolean displayIcon = false;
        if (name.equals("COMMUNITY CHEST")) {
            System.out.println(name);
            freeParkingIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/community_chest.gif")));
            displayIcon = true;
        } else if (name.equals("CHANCE")) {
            System.out.println(name);
            freeParkingIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/chance.png")));
            displayIcon = true;
        } else if (name.equals("FREE PARKING")) {
            System.out.println(name);
            freeParkingIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/free_parking.png")));
            displayIcon = true;
        }

        if (displayIcon) {
            centerPanel.add(new JLabel(new ImageIcon(freeParkingIcon.getImage().getScaledInstance(40, 40, Image.SCALE_FAST))), BorderLayout.CENTER);
        }
    }

    /**
     * A method for displaying information about the free parking space
     */
    @Override
    public String displayInfo() {
        return "\nYou are now located at: " + getName() + "\nThis is a free space!\n";
    }

    /**
     * Method to check if a FreeParking object is equivalent to another FreeParking object
     *
     * @param o Object, the object to be compared with the object this method is called on
     * @return boolean, if the objects are equivalent
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FreeParking that = (FreeParking) o;
        return amount == that.amount;
    }

    /**
     * Returns a String representation of this instance of the property object
     *
     * @return String, string representation of the property object
     */
    @Override
    public String toString() {
        return "Name: " + getName() + ", Amount: " + amount;
    }
}
