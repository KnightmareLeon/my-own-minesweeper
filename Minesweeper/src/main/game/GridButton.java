package main.game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;

import main.DefaultButton;

public class GridButton extends DefaultButton{
    public GridButton(){
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                setBackground(Color.LIGHT_GRAY);
                setEnabled(false);
                setBorder(null);
            }
        });
    }
}
