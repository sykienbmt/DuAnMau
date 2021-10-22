package model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Model_Card {

    private ImageIcon icon;
    private String title;
    private String description;

    public Model_Card() {
    }
    
    public Model_Card(ImageIcon icon, String title, String description) {
        this.icon = icon;
        this.title = title;
        this.description = description;
    }

    
    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
