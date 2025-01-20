package de.sommer.msab_builder.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import de.sommer.msab_builder.util.ComboItem;
import de.sommer.msab_builder.util.CustomJButton;

public class FlightGroupsTabPanel extends JPanel {
    private JPanel flightGroupsContainer;
    private List<JPanel> flightGroupPanels;
    private int counterGridbag = 0;   

    public FlightGroupsTabPanel() {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(5, 5, 5, 5));

        // Initialize components and layout
        flightGroupsContainer = new JPanel(new GridBagLayout());
        flightGroupPanels = new ArrayList<>();
        add(flightGroupsContainer, BorderLayout.CENTER);

        // Container for flight groups
        flightGroupsContainer = new JPanel();
        flightGroupsContainer.setLayout(new GridBagLayout());

        // Scroll pane for flight groups
        JScrollPane scrollPane = new JScrollPane(flightGroupsContainer);
        add(scrollPane, BorderLayout.CENTER);
        
        // Add Flight Group button
        CustomJButton addFlightGroupButton = new CustomJButton("Add Flight Group");
        addFlightGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFlightGroupPanel(); }                
        });
        add(addFlightGroupButton, BorderLayout.SOUTH);
    }

    

    // Method to add a new flight group panel
    private void addFlightGroupPanel() {
        
        FlightGroupPanel flightGroupPanel = new FlightGroupPanel(this);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = counterGridbag++;
        gbc2.fill = GridBagConstraints.HORIZONTAL;

        flightGroupsContainer.add(flightGroupPanel, gbc2);
        flightGroupPanels.add(flightGroupPanel);
        flightGroupsContainer.revalidate();
        flightGroupsContainer.repaint();
    }
   
    // Method to check if a parking slot is already taken
    @SuppressWarnings("unchecked")
    boolean isParkingSlotTaken(String parkingSlotKey) {
        for (JPanel flightGroupPanel : flightGroupPanels) {
            for (Component component : flightGroupPanel.getComponents()) {
                if (component instanceof JPanel) {
                    JPanel slotsPanel = (JPanel) component;
                    for (Component slotComponent : slotsPanel.getComponents()) {
                        if (slotComponent instanceof JComboBox) {
                            JComboBox<ComboItem> comboBox = (JComboBox<ComboItem>) slotComponent;
                            ComboItem selectedItem = (ComboItem) comboBox.getSelectedItem();
                            if (selectedItem != null && selectedItem.getKey().equals(parkingSlotKey)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    // Method to check for duplicate parking slots
    @SuppressWarnings("unchecked")
    void checkDuplicateParkingSlots(JComboBox<ComboItem> sourceComboBox) {
        ComboItem selectedItem = (ComboItem) sourceComboBox.getSelectedItem();
        if (selectedItem == null) return;

        for (JPanel flightGroupPanel : flightGroupPanels) {
            for (Component component : flightGroupPanel.getComponents()) {
                if (component instanceof JPanel) {
                    JPanel slotsPanel = (JPanel) component;
                    for (Component slotComponent : slotsPanel.getComponents()) {
                        if (slotComponent instanceof JComboBox && slotComponent != sourceComboBox) {
                            JComboBox<ComboItem> comboBox = (JComboBox<ComboItem>) slotComponent;
                            ComboItem item = (ComboItem) comboBox.getSelectedItem();
                            if (item != null && selectedItem.getKey().equals(item.getKey())) {
                                JOptionPane.showMessageDialog(this, "This parking slot is already selected by another aircraft.", "Duplicate Parking Slot", JOptionPane.WARNING_MESSAGE);
                                sourceComboBox.setSelectedIndex(-1);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    // Method to remove a flight group panel
    void removeFlightGroupPanel(JPanel flightGroupPanel) {
        flightGroupsContainer.remove(flightGroupPanel);
        flightGroupPanels.remove(flightGroupPanel);
        flightGroupsContainer.revalidate();
        flightGroupsContainer.repaint();
    }


    
}