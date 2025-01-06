package de.sommer.msab_builder.util;

import java.util.ArrayList;
import java.util.List;

public class Mission {

    private String date;
    private String time;
    private String theater;
    private String weather;
    private String wind;
    private String missionType;
    private String timePeriod;
    private String missionName;
    private String missionDescription;

    private String dateMissionString;
    private String weahterMissionString;
    private String colaitionMissionString;
    

    private List<FlightGroup> flightGroups;

    private boolean ambientAAA;
    private boolean ambientArtillery;
    private boolean inacurateWaypoint;
    private boolean carrierGroup;

    public Mission(String date, String time, String theater, String weather, String wind, String missionType, String timePeriod, String missionName, String missionDescription, List<FlightGroup> flightGroups, boolean ambientAAA, boolean ambientArtillery, boolean inacurateWaypoint, boolean carrierGroup) {
        this.date = date;
        this.time = time;
        this.theater = theater;
        this.weather = weather;
        this.wind = wind;
        this.missionType = missionType;
        this.timePeriod = timePeriod;
        this.missionName = missionName;
        this.missionDescription = missionDescription;
        this.flightGroups = flightGroups;
        this.ambientAAA = ambientAAA;
        this.ambientArtillery = ambientArtillery;
        this.inacurateWaypoint = inacurateWaypoint;
        this.carrierGroup = carrierGroup;
    }

    public Mission(){
        this.date = "";
        this.time = "";
        this.theater = "";
        this.weather = "";
        this.wind = "";
        this.missionType = "";
        this.timePeriod = "";
        this.missionName = "";
        this.missionDescription = "";
        this.flightGroups = new ArrayList<>();
        this.ambientAAA = false;
        this.ambientArtillery = false;
        this.inacurateWaypoint = false;
        this.carrierGroup = false;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTheater() {
        return theater;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getMissionType() {
        return missionType;
    }

    public void setMissionType(String missionType) {
        this.missionType = missionType;
    }

    public String getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public String getMissionDescription() {
        return missionDescription;
    }

    public void setMissionDescription(String missionDescription) {
        this.missionDescription = missionDescription;
    }

    public List<FlightGroup> getFlightGroups() {
        return flightGroups;
    }

    public void setFlightGroups(List<FlightGroup> flightGroups) {
        this.flightGroups = flightGroups;
    }

    public boolean isAmbientAAA() {
        return ambientAAA;
    }

    public void setAmbientAAA(boolean ambientAAA) {
        this.ambientAAA = ambientAAA;
    }

    public boolean isAmbientArtillery() {
        return ambientArtillery;
    }

    public void setAmbientArtillery(boolean ambientArtillery) {
        this.ambientArtillery = ambientArtillery;
    }

    public boolean isInacurateWaypoint() {
        return inacurateWaypoint;
    }

    public void setInacurateWaypoint(boolean inacurateWaypoint) {
        this.inacurateWaypoint = inacurateWaypoint;
    }

    public boolean isCarrierGroup() {
        return carrierGroup;
    }

    public void setCarrierGroup(boolean carrierGroup) {
        this.carrierGroup = carrierGroup;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((time == null) ? 0 : time.hashCode());
        result = prime * result + ((theater == null) ? 0 : theater.hashCode());
        result = prime * result + ((weather == null) ? 0 : weather.hashCode());
        result = prime * result + ((wind == null) ? 0 : wind.hashCode());
        result = prime * result + ((missionType == null) ? 0 : missionType.hashCode());
        result = prime * result + ((timePeriod == null) ? 0 : timePeriod.hashCode());
        result = prime * result + ((missionName == null) ? 0 : missionName.hashCode());
        result = prime * result + ((missionDescription == null) ? 0 : missionDescription.hashCode());
        result = prime * result + ((flightGroups == null) ? 0 : flightGroups.hashCode());
        result = prime * result + (ambientAAA ? 1231 : 1237);
        result = prime * result + (ambientArtillery ? 1231 : 1237);
        result = prime * result + (inacurateWaypoint ? 1231 : 1237);
        result = prime * result + (carrierGroup ? 1231 : 1237);
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
        Mission other = (Mission) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (time == null) {
            if (other.time != null)
                return false;
        } else if (!time.equals(other.time))
            return false;
        if (theater == null) {
            if (other.theater != null)
                return false;
        } else if (!theater.equals(other.theater))
            return false;
        if (weather == null) {
            if (other.weather != null)
                return false;
        } else if (!weather.equals(other.weather))
            return false;
        if (wind == null) {
            if (other.wind != null)
                return false;
        } else if (!wind.equals(other.wind))
            return false;
        if (missionType == null) {
            if (other.missionType != null)
                return false;
        } else if (!missionType.equals(other.missionType))
            return false;
        if (timePeriod == null) {
            if (other.timePeriod != null)
                return false;
        } else if (!timePeriod.equals(other.timePeriod))
            return false;
        if (missionName == null) {
            if (other.missionName != null)
                return false;
        } else if (!missionName.equals(other.missionName))
            return false;
        if (missionDescription == null) {
            if (other.missionDescription != null)
                return false;
        } else if (!missionDescription.equals(other.missionDescription))
            return false;
        if (flightGroups == null) {
            if (other.flightGroups != null)
                return false;
        } else if (!flightGroups.equals(other.flightGroups))
            return false;
        if (ambientAAA != other.ambientAAA)
            return false;
        if (ambientArtillery != other.ambientArtillery)
            return false;
        if (inacurateWaypoint != other.inacurateWaypoint)
            return false;
        if (carrierGroup != other.carrierGroup)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Mission [date=" + date + ", time=" + time + ", theater=" + theater
                + ", weather=" + weather + ", wind=" + wind + ", missionType=" + missionType + ", timePeriod="
                + timePeriod + ", missionName=" + missionName + ", missionDescription=" + missionDescription
                + ", flightGroups=" + flightGroups + ", ambientAAA=" + ambientAAA + ", ambientArtillery="
                + ambientArtillery + ", inacurateWaypoint=" + inacurateWaypoint + ", carrierGroup=" + carrierGroup
                + "]";
    }
}
