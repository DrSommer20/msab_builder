package de.sommer.msab_builder.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

    public static List<ComboItem> sort(List<ComboItem> list) {
        Collections.sort(list, new CustomComparator());
        return list;
    }
    
}

class CustomComparator implements Comparator<ComboItem> {
    @Override
    public int compare(ComboItem o1, ComboItem o2) {
        return o1.getValue().compareTo(o2.getValue());
    }
}
