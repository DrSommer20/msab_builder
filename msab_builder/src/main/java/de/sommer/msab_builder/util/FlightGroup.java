package de.sommer.msab_builder.util;

public class FlightGroup {

    private String groupName;
    private String aircraft;
    private String airport;
    private int count;
    private String loadout;
    private String skill;

    public FlightGroup(String groupName, String aircraft, String airport, int count, String loadout, String skill) {
        this.groupName = groupName;
        this.aircraft = aircraft;
        this.airport = airport;
        this.count = count;
        this.loadout = loadout;
        this.skill = skill;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getLoadout() {
        return loadout;
    }

    public void setLoadout(String loadout) {
        this.loadout = loadout;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((groupName == null) ? 0 : groupName.hashCode());
        result = prime * result + ((aircraft == null) ? 0 : aircraft.hashCode());
        result = prime * result + ((airport == null) ? 0 : airport.hashCode());
        result = prime * result + count;
        result = prime * result + ((loadout == null) ? 0 : loadout.hashCode());
        result = prime * result + ((skill == null) ? 0 : skill.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FlightGroup other = (FlightGroup) obj;
        if (groupName == null) {
            if (other.groupName != null)
                return false;
        } else if (!groupName.equals(other.groupName))
            return false;
        if (aircraft == null) {
            if (other.aircraft != null)
                return false;
        } else if (!aircraft.equals(other.aircraft))
            return false;
        if (airport == null) {
            if (other.airport != null)
                return false;
        } else if (!airport.equals(other.airport))
            return false;
        if (count != other.count)
            return false;
        if (loadout == null) {
            if (other.loadout != null)
                return false;
        } else if (!loadout.equals(other.loadout))
            return false;
        if (skill == null) {
            if (other.skill != null)
                return false;
        } else if (!skill.equals(other.skill))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "FlightGroup [groupName=" + groupName + ", aircraft=" + aircraft + ", airport=" + airport + ", count="
                + count + ", loadout=" + loadout + ", skill=" + skill + "]";
    }

}
