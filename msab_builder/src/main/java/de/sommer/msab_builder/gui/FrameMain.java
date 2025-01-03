package de.sommer.msab_builder.gui;

import javax.swing.JFrame;

public class FrameMain extends JFrame {
    public FrameMain() {
        // Set the frame properties
        setTitle("DCS - MSAB Mission Builder - Version 0.1");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new MissionPlanningPanel());
    }
}

