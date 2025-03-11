package main.stats;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import main.DefaultPanel;
import main.MainFrame;
import main.menu.MainMenuButton;

public class StatsPanel extends DefaultPanel{
    private final String STATS_FILE_PATH = "src/resources/stats/stats.txt";
    private File statsFile;
    
    private int easyGamesPlayed, normalGamesPlayed, hardGamesPlayed;
    private int easyWins, normalWins, hardWins;
    private int easyFastestTime, normalFastestTime, hardFastestTime;

    private JLabel easyGamesPlayedLabel, normalGamesPlayedLabel, hardGamesPlayedLabel;
    private JLabel easyWinsLabel, normalWinsLabel, hardWinsLabel;
    private JLabel easyFastestTimeLabel, normalFastestTimeLabel, hardFastestTimeLabel;

    private MainMenuButton back;
    public StatsPanel(MainFrame mFrame){
        back = new MainMenuButton(mFrame);
        statsFile = new File(STATS_FILE_PATH);
        System.out.println(statsFile.getAbsolutePath());
        try {
            BufferedReader reader = new BufferedReader(new FileReader(statsFile));
            easyGamesPlayed = Integer.parseInt(reader.readLine());
            easyWins = Integer.parseInt(reader.readLine());
            easyFastestTime = Integer.parseInt(reader.readLine());
            normalGamesPlayed = Integer.parseInt(reader.readLine());
            normalWins = Integer.parseInt(reader.readLine());
            normalFastestTime = Integer.parseInt(reader.readLine());
            hardGamesPlayed = Integer.parseInt(reader.readLine());
            hardWins = Integer.parseInt(reader.readLine());
            hardFastestTime = Integer.parseInt(reader.readLine());
            reader.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        easyGamesPlayedLabel = new JLabel("Easy Games Played: " + easyGamesPlayed);
        easyWinsLabel = new JLabel("Easy Games Won: " + easyWins);
        easyFastestTimeLabel = new JLabel("Easy Fastest Time: " + 
        easyFastestTime/60 + ":" + String.format("%02d",easyFastestTime%60));

        normalGamesPlayedLabel = new JLabel("Normal Games Played: " + normalGamesPlayed);
        normalWinsLabel = new JLabel("Normal Games Won: " + normalWins);
        normalFastestTimeLabel = new JLabel("Normal Fastest Time: " +
        normalFastestTime/60 + ":" + String.format("%02d",normalFastestTime%60));

        hardGamesPlayedLabel = new JLabel("Hard Games Played: " + hardGamesPlayed);
        hardWinsLabel = new JLabel("Hard Games Won: " + hardWins);
        hardFastestTimeLabel = new JLabel("Hard Fastest Time: " +
        hardFastestTime/60 + ":" + String.format("%02d",hardFastestTime%60));

        GridBagConstraints GBC = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        GBC.gridwidth = GridBagConstraints.REMAINDER;
        GBC.fill = GridBagConstraints.HORIZONTAL;
        GBC.insets.set(0, 0, 30, 0);
        GBC.gridx = GBC.gridy = 0;
        this.add(easyGamesPlayedLabel, GBC); GBC.gridy++;
        this.add(easyWinsLabel, GBC); GBC.gridy++;
        this.add(easyFastestTimeLabel, GBC); GBC.gridy++;

        this.add(normalGamesPlayedLabel, GBC); GBC.gridy++;
        this.add(normalWinsLabel, GBC); GBC.gridy++;
        this.add(normalFastestTimeLabel, GBC); GBC.gridy++;

        this.add(hardGamesPlayedLabel, GBC); GBC.gridy++;
        this.add(hardWinsLabel, GBC); GBC.gridy++;
        this.add(hardFastestTimeLabel, GBC); GBC.gridy++;

        this.add(back, GBC);
        this.setUpFont(this);
    }
}
