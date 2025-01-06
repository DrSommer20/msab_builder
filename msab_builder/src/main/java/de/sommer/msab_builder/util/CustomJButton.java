package de.sommer.msab_builder.util;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class CustomJButton extends JButton {
    public static final int TYPE_DEFAULT = 0;
    public static final int TYPE_DANGER = 1;
    public static final int TYPE_SUBMIT = 2;
    public static final int TYPE_WARNING = 3;

    public CustomJButton(String text, int type) {
        super(text);
        switch (type) {
            case TYPE_DANGER ->
                setForeground(Color.decode("#ff746c"));
            case TYPE_SUBMIT ->
                setForeground(Color.decode("#4CAF50"));
            case TYPE_WARNING ->
                setForeground(java.awt.Color.ORANGE);
            default ->
                setForeground(java.awt.Color.WHITE);
        }
        setFont(getFont().deriveFont(Font.BOLD)); 
    }

    public CustomJButton(String text) {
        this(text, TYPE_DEFAULT);
    }

}
