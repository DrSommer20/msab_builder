package de.sommer.msab_builder;

import javax.swing.SwingUtilities;

import com.formdev.flatlaf.IntelliJTheme;

import de.sommer.msab_builder.gui.FrameMain;

public class App 
{
    public static void main( String[] args )
    {
        IntelliJTheme.setup( App.class.getResourceAsStream("/resources/Night Owl.theme.json" ) );
        SwingUtilities.invokeLater(() -> { FrameMain frame = new FrameMain(); frame.setVisible(true); });
    }        
}