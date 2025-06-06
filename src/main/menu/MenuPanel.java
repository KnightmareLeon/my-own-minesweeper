package main.menu;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import main.defaults.DefaultPanel;

public abstract class MenuPanel extends DefaultPanel {
    protected final GridBagConstraints GBC = new GridBagConstraints(); 
    public MenuPanel(){
        this.setLayout(new GridBagLayout());
        this.GBC.gridwidth = GridBagConstraints.REMAINDER;
        this.GBC.fill = GridBagConstraints.HORIZONTAL;
        this.GBC.insets = new Insets(0, 0, 30, 0);
        this.GBC.gridx = this.GBC.gridy = 0;
    }

    protected void addComponent(Component component){
        this.add(component, GBC);
        this.GBC.gridy++;
    }
}
