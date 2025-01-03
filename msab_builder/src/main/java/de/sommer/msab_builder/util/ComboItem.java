package de.sommer.msab_builder.util;

public class ComboItem {
    private String key;
    private String value;
    
    public ComboItem(String value, String key) {
        this.key = key;
        this.value = value;
    }
    
    public String getKey() {
        return key;
    }
    
    public String getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return value;
    }
    
}
