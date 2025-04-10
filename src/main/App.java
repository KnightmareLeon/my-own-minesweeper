package main;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import main.frames.MainFrame;

public class App {
    public static void main(String[] args) {
        FlatLightLaf.setup();
        try {
            UIManager.put("TitlePane.font", Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(
                    new File("src/resources/fonts/Retro Gaming.ttf"))).deriveFont(Font.PLAIN, 30));
            
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(MainFrame::new);
        
    }
}

