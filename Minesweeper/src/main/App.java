package main;

import com.formdev.flatlaf.FlatLightLaf;

public class App {
    public static void main(String[] args) throws Exception {
        FlatLightLaf.setup();
        MainFrame mFrame = new MainFrame();
        mFrame.setContentPane(MainFrame.MAIN_MENU);
        
    }
}
