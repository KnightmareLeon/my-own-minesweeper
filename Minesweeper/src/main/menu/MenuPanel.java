package main.menu;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import main.DefaultPanel;

public abstract class MenuPanel extends DefaultPanel {
    protected final GridBagConstraints GBC = new GridBagConstraints(); 
    public MenuPanel(){
        this.setLayout(new GridBagLayout());
        this.GBC.gridwidth = GridBagConstraints.REMAINDER;
        this.GBC.fill = GridBagConstraints.HORIZONTAL;
        this.GBC.insets = new Insets(0, 0, 30, 0);
        this.GBC.gridx = this.GBC.gridy = 0;
    }

    protected void addButton(MenuButton menuButton){
        this.add(menuButton, GBC);
        this.GBC.gridy++;
    }
}
