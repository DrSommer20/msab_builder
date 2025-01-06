package de.sommer.msab_builder.gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import de.sommer.msab_builder.util.CustomJButton;

public class MissionPlanningPanel extends JPanel {

    private ConfiguratorTabbedPane tabbedPane;

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
        CustomJButton resetButton = new CustomJButton("Reset", CustomJButton.TYPE_DANGER);
        buttonPanel.add(resetButton, BorderLayout.WEST);

        // Spacer
        JPanel spacer = new JPanel();
        buttonPanel.add(spacer, BorderLayout.CENTER);

        // Save Button
        CustomJButton saveButton = new CustomJButton("Save", CustomJButton.TYPE_SUBMIT);
        saveButton.addActionListener(e -> displaySaveInformation());
        buttonPanel.add(saveButton, BorderLayout.EAST);

        // Add button panel to the south
        add(buttonPanel, BorderLayout.SOUTH);


        tabbedPane = new ConfiguratorTabbedPane();
        add(tabbedPane, BorderLayout.CENTER);
    }

    private void displaySaveInformation() {
        // Gather information from the tabbed pane
        StringBuilder info = new StringBuilder();
        info.append("Mission Planning Information:\n");

        // Assuming ContextPanel and FlightGroupsPanel have methods to get their information
        ContextPanel contextPanel = (ContextPanel) tabbedPane.getComponentAt(0);
        FlightGroupsTabPanel flightGroupsPanel = (FlightGroupsTabPanel) tabbedPane.getComponentAt(1);

        info.append(contextPanel.getInformation());
        //info.append(flightGroupsPanel.getInformation());

        // Display the information in a popup window
        JOptionPane.showMessageDialog(this, info.toString(), "Save Information", JOptionPane.INFORMATION_MESSAGE);
    }
}