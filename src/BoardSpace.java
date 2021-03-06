import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * The BoardSpace class is an abstract class that
 * represents a space on the board
 *
 * @author Evan Smedley, Harsismran Kanwar, Dorothy Tran, Shuvaethy Neill
 * @version 3.0
 * @since 2021-11-21
 */
public abstract class BoardSpace extends JPanel implements Serializable {

    /**
     * The name of the board space
     */
    private String name;

    /**
     * The type of board space
     */
    private String type;

    /**
     * Position number of the BoardSpace
     */
    private int position;

    /**
     * An arraylist of all the player icons
     */
    private ArrayList<JLabel> playerIcons;

    /**
     * An arraylist of the path of each player icon
     */
    private ArrayList<String> playerIconPaths;

    /**
     * The panel that the player icons are displayed in
     */
    private JPanel playerIconPanel;

    protected JPanel centerPanel;

    /**
     * The constructor for a BoardSpace object
     */
    public BoardSpace(String name, String type, String path, int position) {
        super(new BorderLayout());
        this.name = name;
        this.type = type;
        this.position = position;
        this.playerIcons = new ArrayList<>();
        this.playerIconPaths = new ArrayList<>(Arrays.asList("images/yellow-player.png", "images/blue-player.png",
                "images/red-player.png", "images/purple-player.png", "images/greenp.png", "images/pink.png","images/burgundyP.png","images/turquoiseP.png"));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        playerIconPanel = new JPanel(new GridLayout(1,8));
        playerIconPanel.setPreferredSize(new Dimension(56,7));
        playerIconPanel.setOpaque(false);
        this.add(playerIconPanel, BorderLayout.PAGE_END);

        for (String playerIconPath : playerIconPaths) {
            ImageIcon playerIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource(playerIconPath)));
            playerIcons.add(new JLabel(new ImageIcon(playerIcon.getImage().getScaledInstance(6, 6, Image.SCALE_FAST))));
        }

        centerPanel = new JPanel(new BorderLayout());
        centerPanel.setOpaque(false);
        this.add(centerPanel, BorderLayout.CENTER);

        this.setPreferredSize(new Dimension(56, 56));
        this.setBackground(Color.lightGray);
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
     * A getter for the position of this board space
     *
     * @return int, the position of this board space
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * Add a player icon to this board space
     *
     * @param playerIndex int, the index of the player to add
     */
    public void addPlayerIcon(int playerIndex) {
        playerIconPanel.add(playerIcons.get(playerIndex));
    }

    /**
     * Remove all player icons from this board space
     */
    public void clearPlayerIcons() {
        playerIconPanel.removeAll();
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
        JLabel nameLabel = new JLabel("<html><div style='text-align: center;'>" + name + "</div></html>", JLabel.CENTER);
        nameLabel.setFont(new Font("Serif", Font.PLAIN, 8));
        centerPanel.add(nameLabel, BorderLayout.PAGE_START);
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @param position
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * An abstract method for displaying information about the board space
     */
    public abstract String displayInfo();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardSpace that = (BoardSpace) o;
        return position == that.position && Objects.equals(name, that.name) && Objects.equals(type, that.type) && Objects.equals(playerIcons, that.playerIcons) && Objects.equals(playerIconPaths, that.playerIconPaths) && Objects.equals(playerIconPanel, that.playerIconPanel) && Objects.equals(centerPanel, that.centerPanel);
    }
}