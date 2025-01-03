package de.sommer.msab_builder.gui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class MissionPlanningPanel extends JPanel {

    public MissionPlanningPanel() {
        // Set the panel layout
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 10, 10, 10));

        
        

        JLabel headerLabel = new JLabel("DCS - MSAB Mission Builder");
        headerLabel.setFont(headerLabel.getFont().deriveFont(24.0f));
        add(headerLabel, BorderLayout.NORTH);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new BorderLayout());

        // Reset Button
        JButton resetButton = new JButton("Reset");
        buttonPanel.add(resetButton, BorderLayout.WEST);

        // Spacer
        JPanel spacer = new JPanel();
        buttonPanel.add(spacer, BorderLayout.CENTER);

        // Save Button
        JButton saveButton = new JButton("Save");
        buttonPanel.add(saveButton, BorderLayout.EAST);

        // Add button panel to the south
        add(buttonPanel, BorderLayout.SOUTH);


        JTabbedPane tabbedPane = new ConfiguratorTabbedPane();
        add(tabbedPane, BorderLayout.CENTER);



    }
}