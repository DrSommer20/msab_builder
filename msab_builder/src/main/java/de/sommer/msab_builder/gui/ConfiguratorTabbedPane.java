package de.sommer.msab_builder.gui;

import java.awt.BorderLayout;

import javax.swing.JTabbedPane;

public class ConfiguratorTabbedPane extends JTabbedPane {

    public ConfiguratorTabbedPane() {
        super();
        addTab("Context", new ContextPanel());
        addTab("Flight Groups", new FlightGroupsPanel());
    }
    
}
