package de.sommer.msab_builder.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import de.sommer.msab_builder.db.SQLDB;
import de.sommer.msab_builder.util.ComboItem;

public class ContextPanel extends JPanel {
    
    public ContextPanel() {
        super();
        setLayout(new GridBagLayout());
        setBorder(new EmptyBorder(10, 10, 10, 10));
        addComponents();
    }

    private void addComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        JLabel headerLabel = new JLabel("Context & Environment");
        headerLabel.setFont(headerLabel.getFont().deriveFont(18.0f));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(headerLabel, gbc);


        JLabel missionNameLabel = new JLabel("Mission Name:");
        JTextField missionName = new JTextField();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(missionNameLabel, gbc);
        gbc.gridy = 2;
        add(missionName, gbc);

        JLabel theaterLabel = new JLabel("Theater:");
        JComboBox<String> theater = new JComboBox<>(new String[] {"Syria", "Caucasus", "Nevada", "Persian Gulf"});
        gbc.gridx = 2;
        gbc.gridy = 1;
        add(theaterLabel, gbc);
        gbc.gridy = 2;
        add(theater, gbc);
        theater.setSelectedIndex(0);
        theater.setEnabled(false);

        JLabel timeLabel = new JLabel("Time:");
        JComboBox<String> time = new JComboBox<>(new String[] {"Morning", "Day", "Evening", "Night"});
        gbc.gridx = 3;
        gbc.gridy = 1;
        add(timeLabel, gbc);
        gbc.gridy = 2;
        add(time, gbc);

        JSeparator sep = new JSeparator();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 5;
        add(sep, gbc);



        JLabel seasonLabel = new JLabel("Season:");
        JComboBox<String> season = new JComboBox<>(new String[] {"Winter", "Spring", "Summer", "Autumn"});
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        add(seasonLabel, gbc);
        gbc.gridy = 6;
        add(season, gbc);


        JLabel weatherLabel = new JLabel("Weather:");
        JComboBox<ComboItem> weather = new JComboBox<>();
        for (ComboItem w : SQLDB.getWeather()) {
            weather.addItem(w);
        }
        gbc.gridx = 2;
        gbc.gridy = 5;
        add(weatherLabel, gbc);
        gbc.gridy = 6;
        add(weather, gbc); 

        JLabel windLabel = new JLabel("Wind:");
        JComboBox<ComboItem> wind = new JComboBox<>();
        for (ComboItem w : SQLDB.getWind()) {
            wind.addItem(w);
        }
        gbc.gridx = 3;
        gbc.gridy = 5;
        add(windLabel, gbc);
        gbc.gridy = 6;
        add(wind, gbc);

        JSeparator sep2 = new JSeparator();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 5;
        add(sep2, gbc);

        JLabel missionTypeLabel = new JLabel("Mission Type:");
        JComboBox<ComboItem> missionType = new JComboBox<>();
        for (ComboItem w : SQLDB.getMissionTypes()) {
            missionType.addItem(w);
        }
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        add(missionTypeLabel, gbc);
        gbc.gridy = 9;
        add(missionType, gbc);

        JLabel timePeriodLabel = new JLabel("Time Period:");
        JComboBox<ComboItem> timePeriod = new JComboBox<>();
        for (ComboItem w : SQLDB.getTimePeriods()) {
            timePeriod.addItem(w);
        }
        gbc.gridx = 2;
        gbc.gridy = 8;
        add(timePeriodLabel, gbc);
        gbc.gridy = 9;
        add(timePeriod, gbc);

        // Add MISC Panel
        JPanel miscPanel = createMiscPanel();
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 5;
        add(miscPanel, gbc);

        

        
    }

    private JPanel createMiscPanel() {
        JPanel miscPanel = new JPanel();
        miscPanel.setLayout(new BoxLayout(miscPanel, BoxLayout.Y_AXIS));
        miscPanel.setBorder(BorderFactory.createTitledBorder("Misc"));

        List<ComboItem> miscItems = SQLDB.getMisc();

        for (ComboItem item : miscItems) {
            JRadioButton radioButton = new JRadioButton(item.toString());
            radioButton.setActionCommand(item.getValue());
            miscPanel.add(radioButton);
        }

        return miscPanel;
    }
    
}
