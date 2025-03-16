package main.defaults;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;

import javax.swing.JPanel;

public class DefaultPanel extends JPanel{
    private final int DEFAULT_FONT_STYLE = Font.PLAIN;
    private final int DEFAULT_FONT_SIZE = 30;
    private final String FONT_FILE_PATH = "src/resources/fonts/Retro Gaming.ttf";
    private Font font;
    
    public DefaultPanel(){
        this.setBackground(new Color(218, 218, 218));
        try {
            font  = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(
                new File(FONT_FILE_PATH))).deriveFont(DEFAULT_FONT_STYLE, DEFAULT_FONT_SIZE);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

    }

    protected void setUpFont(Container container){
        for (Component child : container.getComponents()){
            if(child instanceof Container){
                setUpFont((Container) child);
            }
            child.setFont(font);
        }
    }

    protected void setUpFont(Container container, int size){
        for (Component child : container.getComponents()){
            if(child instanceof Container){
                setUpFont((Container) child, size);
            }
            child.setFont(font.deriveFont(DEFAULT_FONT_STYLE, size));
        }
    }
}
