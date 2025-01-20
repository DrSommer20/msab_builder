package de.sommer.msab_builder.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import de.sommer.msab_builder.db.SQLDB;
import de.sommer.msab_builder.util.ComboItem;

public class LoadoutPanel extends JPanel {

    private String aircraftName;
    private String aircraftId;
    private JLabel pictureLabel;

    public LoadoutPanel(JPanel parent, String aircraft_id, String aircraft) {
        this.aircraftName = aircraft;
        this.aircraftId = aircraft_id;
        this.pictureLabel = new JLabel();
        setLayout(new GridBagLayout());
        JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(parent), "Loadout", true);
        dialog.setLayout(new BorderLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        add(pictureLabel, gbc);
        loadPicture();

        gbc.gridwidth = 1;
        

        JLabel fuelLabel = new JLabel("Fuel:");
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        add(fuelLabel, gbc);
        JPanel fuelPanel = new JPanel(new BorderLayout());
        JSlider fuelSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        fuelSlider.setMajorTickSpacing(10);
        fuelSlider.setMinorTickSpacing(1);
        fuelSlider.setPaintTicks(true);
        fuelSlider.setPaintLabels(true);
        fuelPanel.add(fuelSlider, BorderLayout.WEST);
        JTextField fuelTextField = new JTextField(3);
        fuelTextField.setText(String.valueOf(fuelSlider.getValue()));
        fuelPanel.add(fuelTextField, BorderLayout.EAST);
        gbc.gridy++;
        add(fuelPanel, gbc);
        // Add ChangeListener to slider to update text field
        fuelSlider.addChangeListener(e -> fuelTextField.setText(String.valueOf(fuelSlider.getValue())));
        // Add DocumentListener to text field to update slider
        fuelTextField.addActionListener(new CustomSliderActionListener(fuelSlider, fuelTextField));


        JLabel gunLabel = new JLabel("Gun:");
        gbc.gridx = 0;
        gbc.gridy++;
        add(gunLabel, gbc);
        JPanel gunPanel = new JPanel(new BorderLayout());

        JSlider gunSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        gunSlider.setMajorTickSpacing(10);
        gunSlider.setMinorTickSpacing(1);
        gunSlider.setPaintTicks(true);
        gunSlider.setPaintLabels(true);
        gunPanel.add(gunSlider, BorderLayout.WEST);

        JTextField gunTextField = new JTextField(3);
        gunTextField.setText(String.valueOf(gunSlider.getValue()));
        gunPanel.add(gunTextField, BorderLayout.EAST);
        gbc.gridy++;
        add(gunPanel, gbc);
        // Add ChangeListener to slider to update text field
        gunSlider.addChangeListener(e -> gunTextField.setText(String.valueOf(gunSlider.getValue())));
        // Add DocumentListener to text field to update slider
        gunTextField.addActionListener(new CustomSliderActionListener(gunSlider, gunTextField));

        JLabel chaffLabel = new JLabel("Chaff:");
        gbc.gridx = 2;
        gbc.gridy -= 3;
        add(chaffLabel, gbc);
        JPanel chaffPanel = new JPanel(new BorderLayout());
        JSlider chaffSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        chaffSlider.setMajorTickSpacing(10);
        chaffSlider.setMinorTickSpacing(1);
        chaffSlider.setPaintTicks(true);
        chaffSlider.setPaintLabels(true);
        chaffPanel.add(chaffSlider, BorderLayout.WEST);
        gbc.gridy++;
        JTextField chaffTextField = new JTextField(3);
        chaffTextField.setText(String.valueOf(chaffSlider.getValue()));
        chaffPanel.add(chaffTextField, BorderLayout.EAST);
        
        add(chaffPanel, gbc);
        // Add ChangeListener to slider to update text field
        chaffSlider.addChangeListener(e -> chaffTextField.setText(String.valueOf(chaffSlider.getValue())));
        // Add DocumentListener to text field to update slider
        chaffTextField.addActionListener(new CustomSliderActionListener(chaffSlider, chaffTextField));

        JLabel flareLabel = new JLabel("Flare:");
        gbc.gridx = 2;
        gbc.gridy++;
        add(flareLabel, gbc);
        JPanel flarePanel = new JPanel(new BorderLayout());
        JSlider flareSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        flareSlider.setMajorTickSpacing(10);
        flareSlider.setMinorTickSpacing(1);
        flareSlider.setPaintTicks(true);
        flareSlider.setPaintLabels(true);
        flarePanel.add(flareSlider, BorderLayout.WEST);
        
        JTextField flareTextField = new JTextField(3);
        flareTextField.setText(String.valueOf(flareSlider.getValue()));
        flarePanel.add(flareTextField, BorderLayout.EAST);
        gbc.gridy++;
        add(flarePanel, gbc);

        // Add ChangeListener to slider to update text field
        flareSlider.addChangeListener(e -> flareTextField.setText(String.valueOf(flareSlider.getValue())));
        // Add DocumentListener to text field to update slider
        flareTextField.addActionListener(new CustomSliderActionListener(flareSlider, flareTextField));
        
        List<JComboBox<ComboItem>> comboBoxes = new ArrayList<>();
        int maxWidth = 0;

        // Fetch pylon names for the aircraft
        List<Integer> pylonNames = SQLDB.getPylonNames(aircraftId);
        int half = (int) Math.ceil(pylonNames.size() / 2.0);
        int count = 0;
        int initialGbcY = gbc.gridy; // Store the initial gbc.gridy value
        gbc.gridy++;

        for (Integer pylon : pylonNames) {
            JLabel pylonLabel = new JLabel("Pylon " + pylon + ":");
            gbc.gridx = count < half ? 0 : 2;
            gbc.anchor = GridBagConstraints.WEST;
            add(pylonLabel, gbc);

            JComboBox<ComboItem> weaponComboBox = new JComboBox<>();
            List<ComboItem> weapons = SQLDB.getWeaponForPylon(aircraftId, String.valueOf(pylon));
            weaponComboBox.addItem(new ComboItem("", ""));
            for (ComboItem weapon : weapons) {
                weaponComboBox.addItem(weapon);
            }

            Dimension preferredSize = weaponComboBox.getPreferredSize();
            if (preferredSize.width > maxWidth) {
                maxWidth = preferredSize.width;
            }

            
            gbc.gridy++;
            add(weaponComboBox, gbc);
            comboBoxes.add(weaponComboBox);
            gbc.gridy++;
            count++;
            if(count == half) {
                gbc.gridy = initialGbcY +1;    
            }
            
        }

        // Set the preferred width of all comboboxes to the maximum width found
        for (JComboBox<ComboItem> comboBox : comboBoxes) {
            comboBox.setPreferredSize(new Dimension(maxWidth, comboBox.getPreferredSize().height));
        }

        // // Set the preferred width of all comboboxes to the maximum width found
        // for (JComboBox<ComboItem> comboBox : comboBoxes) {
        //     Dimension preferredSize = comboBox.getPreferredSize();
        //     preferredSize.width = maxWidth;
        //     comboBox.setPreferredSize(preferredSize);
        // }

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> dialog.dispose());
        gbc.gridx = 2;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;
        add(saveButton, gbc);

        dialog.add(this, BorderLayout.CENTER);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void loadPicture() {
        String imagePath = "msab_builder/src/main/java/resources/images/" + aircraftName + ".png";
        File imageFile = new File(imagePath);
        if (imageFile.exists()) {
            ImageIcon icon = new ImageIcon(imagePath);
            Image image = icon.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH);
            pictureLabel.setIcon(new ImageIcon(image));
        } else {
            pictureLabel.setText("Image not found");
        }
    }
}


class CustomSliderActionListener implements ActionListener {

    private JSlider slider;
    private JTextField fuelTextField;

    public CustomSliderActionListener(JSlider slider, JTextField fuelTextField) {
        this.slider = slider;
        this.fuelTextField = fuelTextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateSlider();
    }

    private void updateSlider() {
        try {
            int value = Integer.parseInt(fuelTextField.getText());
            if (value >= slider.getMinimum() && value <= slider.getMaximum()) {
                slider.setValue(value);
            }
        } catch (NumberFormatException ex) {
            // Do nothing
        }
    }
}