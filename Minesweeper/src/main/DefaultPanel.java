package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;

import javax.swing.JPanel;

public abstract class DefaultPanel extends JPanel{
    private final int FONT_STYLE = Font.PLAIN;
    private final int FONT_SIZE = 30;
    private final String FONT_FILE_PATH = "src/resources/Retro Gaming.ttf";
    private Font font;

    public DefaultPanel(){
        this.setBackground(new Color(218, 218, 218));
        try {
            font  = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(
                new File(FONT_FILE_PATH))).deriveFont(FONT_STYLE, FONT_SIZE);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

    }

    protected void setUpFont(){
        for (Component child : this.getComponents()){
            child.setFont(font);;
        }
    }
}
