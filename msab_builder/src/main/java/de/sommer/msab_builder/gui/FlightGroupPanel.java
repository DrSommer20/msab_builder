package de.sommer.msab_builder.gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import de.sommer.msab_builder.db.SQLDB;
import de.sommer.msab_builder.util.ComboItem;
import de.sommer.msab_builder.util.CustomJButton;

public class FlightGroupPanel extends JPanel {

    private JComboBox<ComboItem> airportComboBox;
    private JComboBox<ComboItem> parkingSlotsComboBox;
    private JComboBox<ComboItem> aircraftTypeComboBox;
    private JComboBox<ComboItem> aircraftComboBox;
    private JSpinner countSpinner;
    private FlightGroupsTabPanel parent;
    private JPanel slotsPanel;

    public FlightGroupPanel(FlightGroupsTabPanel parent) {
        super(new GridBagLayout());
        this.parent = parent;
        airportComboBox = new JComboBox<>();
        parkingSlotsComboBox = new JComboBox<>();


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Group Name
        JLabel groupNameLabel = new JLabel("Group Name:");
        JTextField groupNameField = new JTextField(10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(groupNameLabel, gbc);
        gbc.gridy = 1;
        add(groupNameField, gbc);

        // Airport
        JLabel airportLabel = new JLabel("Airport:");
        airportComboBox = new JComboBox<>();
        airportComboBox.addActionListener(e -> updateParkingSlots());
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(airportLabel, gbc);
        gbc.gridy = 1;
        add(airportComboBox, gbc);

        // Aircraft Type
        JLabel aircraftTypeLabel = new JLabel("Aircraft Type:");
        aircraftTypeComboBox = new JComboBox<>();
        aircraftTypeComboBox.addItem(new ComboItem("Plane", "Plane"));
        aircraftTypeComboBox.addItem(new ComboItem("Helicopter", "Helicopter"));
        gbc.gridx = 2;
        gbc.gridy = 0;
        add(aircraftTypeLabel, gbc);
        gbc.gridy = 1;
        add(aircraftTypeComboBox, gbc);

        aircraftTypeComboBox.addActionListener(e -> updateAircrafts());

        airportComboBox.removeAllItems();
        for (ComboItem item : SQLDB.getAirports(((ComboItem) aircraftTypeComboBox.getSelectedItem()).getKey())) {
            airportComboBox.addItem(item);
        }

        // Aircraft
        JLabel aircraftLabel = new JLabel("Aircraft:");
        aircraftComboBox = new JComboBox<>(getPlanes());
        gbc.gridx = 3;
        gbc.gridy = 0;
        add(aircraftLabel, gbc);
        gbc.gridy = 1;
        add(aircraftComboBox, gbc);
        

        // Number of planes
        JLabel countLabel = new JLabel("Number of Planes:");
        countSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        gbc.gridx = 4;
        gbc.gridy = 0;
        add(countLabel, gbc);
        gbc.gridy = 1;
        add(countSpinner, gbc);

        // Add slots for each plane
        slotsPanel = new JPanel(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        add(slotsPanel, gbc);
        gbc.gridwidth = 1;

        // Update slots panel based on the number of planes
        updateSlotsPanel((int) countSpinner.getValue(), ((ComboItem) airportComboBox.getSelectedItem()).getKey());
        countSpinner.addChangeListener(e -> updateSlotsPanel((int) countSpinner.getValue(), ((ComboItem) airportComboBox.getSelectedItem()).getKey()));
        airportComboBox.addActionListener(e -> updateSlotsPanel((int) countSpinner.getValue(), ((ComboItem) airportComboBox.getSelectedItem()).getKey()));
        aircraftComboBox.addActionListener(e -> updateSlotsPanel((int) countSpinner.getValue(), ((ComboItem) airportComboBox.getSelectedItem()).getKey()));

        // Spacer to push the delete button to the end of the line
        gbc.gridx = 5;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(new JPanel(), gbc);
        gbc.weightx = 0.5;
        gbc.gridwidth = 1;

        // Delete button
        CustomJButton deleteButton = new CustomJButton("Delete", CustomJButton.TYPE_DANGER);
        deleteButton.addActionListener(e -> parent.removeFlightGroupPanel(this));
        gbc.gridx = 6;
        gbc.gridy = 1;
        add(deleteButton, gbc);

        // Edit Loadout button
        CustomJButton editLoadoutButton = new CustomJButton("Edit Loadout", CustomJButton.TYPE_DEFAULT);
        editLoadoutButton.addActionListener(e -> setLoadouts());
        gbc.gridx = 7;
        gbc.gridy = 1;
        add(editLoadoutButton, gbc);

        
    }
    // Method to update the slots panel based on the number of planes
    private void updateSlotsPanel(int count, String airport_id) {
        slotsPanel.removeAll();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        for (int i = 0; i < count; i++) {
            // Add separator
            JSeparator separator = new JSeparator();
            gbc.gridx = 0;
            gbc.gridy = i * 2;
            gbc.gridwidth = 5;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            slotsPanel.add(separator, gbc);
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.NONE;

            // Aircraft counter label
            JLabel aircraftCounterLabel = new JLabel("Aircraft " + (i + 1));
            aircraftCounterLabel.setFont(aircraftCounterLabel.getFont().deriveFont(14.0f));
            aircraftCounterLabel.setFont(getFont().deriveFont(Font.BOLD));

            // Liverie label and combo box
            JLabel liverieLabel = new JLabel("Liverie:");
            JComboBox<ComboItem> liverieComboBox = new JComboBox<>();
            liverieComboBox.addItem(new ComboItem("Liverie 1", "Liverie 2"));

            // Parking spot label and combo box
            JLabel parkingSpotLabel = new JLabel("Parking Spot:");
            JComboBox<ComboItem> parkingSpotComboBox = new JComboBox<>(getParkingSpots(airport_id));

            // Select the next available parking slot
            for (int j = 0; j < parkingSpotComboBox.getItemCount(); j++) {
                ComboItem item = parkingSpotComboBox.getItemAt(j);
                if (!parent.isParkingSlotTaken(item.getKey())) {
                    parkingSpotComboBox.setSelectedIndex(j);
                    break;
                }
                
                
            }

            // Add ActionListener to check for duplicate parking slots
            parkingSpotComboBox.addActionListener(e -> parent.checkDuplicateParkingSlots(parkingSpotComboBox));

            // Add components to slots panel
            gbc.gridx = 0;
            gbc.gridy = i * 2 + 1;
            slotsPanel.add(aircraftCounterLabel, gbc);
            gbc.gridx = 1;
            slotsPanel.add(liverieLabel, gbc);
            gbc.gridx = 2;
            slotsPanel.add(liverieComboBox, gbc);
            gbc.gridx = 3;
            slotsPanel.add(parkingSpotLabel, gbc);
            gbc.gridx = 4;
            slotsPanel.add(parkingSpotComboBox, gbc);
        }

        slotsPanel.revalidate();
        slotsPanel.repaint();
    }
    // Method to update parking slots
    private void updateParkingSlots() {
        parkingSlotsComboBox.removeAllItems();
        for (ComboItem item : SQLDB.getParkingSlots(((ComboItem) airportComboBox.getSelectedItem()).getKey())) {
            parkingSlotsComboBox.addItem(item);
        }
    }

    private void updateAircrafts() {
        if (((ComboItem) aircraftTypeComboBox.getSelectedItem()).getKey().equals("Plane")) {
            aircraftComboBox.removeAllItems();
            for (ComboItem item : getPlanes()) {
                aircraftComboBox.addItem(item);
            }
        } else {
            aircraftComboBox.removeAllItems();
            for (ComboItem item : getHelicopters()) {
                aircraftComboBox.addItem(item);
            }
        }
        for( ActionListener al : airportComboBox.getActionListeners() ) {
            airportComboBox.removeActionListener( al );
        }
        airportComboBox.removeAllItems();
        for (ComboItem item : SQLDB.getAirports(((ComboItem) aircraftTypeComboBox.getSelectedItem()).getKey())) {
            airportComboBox.addItem(item);
        }
        updateSlotsPanel((int) countSpinner.getValue(), ((ComboItem) airportComboBox.getSelectedItem()).getKey());
        airportComboBox.addActionListener(e -> updateSlotsPanel((int) countSpinner.getValue(), ((ComboItem) airportComboBox.getSelectedItem()).getKey()));
    }

    private void setLoadouts(){
        LoadoutPanel loadoutPanel = new LoadoutPanel(parent , ((ComboItem) aircraftComboBox.getSelectedItem()).getKey(), ((ComboItem) aircraftComboBox.getSelectedItem()).getValue());
    }




    // Method to get planes
    private ComboItem[] getPlanes() {
        List<ComboItem> planes = SQLDB.getFlyableAircrafts();
        return planes.toArray(new ComboItem[planes.size()]);
    }
    // Method to get helicopters
    private ComboItem[] getHelicopters() {
        List<ComboItem> helicopters = SQLDB.getFlyableHelicopters();
        return helicopters.toArray(new ComboItem[helicopters.size()]);
    }
    // Method to get parking spots
    private ComboItem[] getParkingSpots(String airport_id) {
        ComboItem[] parkingSpots = SQLDB.getParkingSlots(airport_id, ((ComboItem)aircraftTypeComboBox.getSelectedItem()).getKey(), ((ComboItem)aircraftComboBox.getSelectedItem()).getKey()).toArray(new ComboItem[0]);
        System.out.println(parkingSpots.length);
        return parkingSpots;
    }

    
}
