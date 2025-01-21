package de.sommer.msab_builder.util;

import java.util.ArrayList;
import java.util.List;

public class Mission {
    public GroundControl groundControl;
    public RequiredModules requiredModules;
    public Date date;
    public Trig trig;
    public int maxDictId;
    public Result result;
    public PictureFileName pictureFileNameN;
    public Drawings drawings;
    public String descriptionNeutralsTask;
    public PictureFileName pictureFileNameServer;
    public Weather weather;
    public String theatre;
    public Triggers triggers;
    public Map map;
    public Coalitions coalitions;
    public String descriptionText;
    public PictureFileName pictureFileNameR;
    public String descriptionBlueTask;
    public Goals goals;
    public String descriptionRedTask;
    public PictureFileName pictureFileNameB;
    public Coalition coalition;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\"mission\" = \n{\n");
        sb.append(groundControl.toString());
        sb.append(requiredModules.toString());
        sb.append(date.toString());
        sb.append(trig.toString());
        sb.append("\t[\"maxDictId\"] = ").append(maxDictId).append(",\n");
        sb.append(result.toString());
        sb.append("\t[\"pictureFileNameN\"] = {},\n");
        sb.append(drawings.toString());
        sb.append("\t[\"descriptionNeutralsTask\"] = \"").append(descriptionNeutralsTask).append("\",\n");
        sb.append("\t[\"pictureFileNameServer\"] = {},\n");
        sb.append(weather.toString());
        sb.append("\t[\"theatre\"] = \"").append(theatre).append("\",\n");
        sb.append(triggers.toString());
        sb.append(map.toString());
        sb.append(coalitions.toString());
        sb.append("\t[\"descriptionText\"] = \"").append(descriptionText).append("\",\n");
        sb.append("\t[\"pictureFileNameR\"] = {},\n");
        sb.append("\t[\"descriptionBlueTask\"] = \"").append(descriptionBlueTask).append("\",\n");
        sb.append(goals.toString());
        sb.append("\t[\"descriptionRedTask\"] = \"").append(descriptionRedTask).append("\",\n");
        sb.append("\t[\"pictureFileNameB\"] = {},\n");
        sb.append(coalition.toString());
        sb.append("}, -- end of [\"mission\"]\n");
        return sb.toString();
    }

    public static class GroundControl {
        private Passwords passwords;
        private Roles roles;
        private boolean isPilotControlVehicles;

        public Passwords getPasswords() {
            return passwords;
        }

        public void setPasswords(Passwords passwords) {
            this.passwords = passwords;
        }

        public Roles getRoles() {
            return roles;
        }

        public void setRoles(Roles roles) {
            this.roles = roles;
        }

        public boolean isPilotControlVehicles() {
            return isPilotControlVehicles;
        }

        public void setPilotControlVehicles(boolean isPilotControlVehicles) {
            this.isPilotControlVehicles = isPilotControlVehicles;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t[\"groundControl\"] = \n\t{\n");
            sb.append(passwords.toString());
            sb.append(roles.toString());
            sb.append("\t\t[\"isPilotControlVehicles\"] = ").append(isPilotControlVehicles).append(",\n");
            sb.append("\t}, -- end of [\"groundControl\"]\n");
            return sb.toString();
        }
    }

    public static class Passwords {
        private List<String> artillery_commander = new ArrayList<>();
        private List<String> instructor = new ArrayList<>();
        private List<String> observer = new ArrayList<>();
        private List<String> forward_observer = new ArrayList<>();

        public List<String> getArtillery_commander() {
            return artillery_commander;
        }

        public void setArtillery_commander(List<String> artillery_commander) {
            this.artillery_commander = artillery_commander;
        }

        public List<String> getInstructor() {
            return instructor;
        }

        public void setInstructor(List<String> instructor) {
            this.instructor = instructor;
        }

        public List<String> getObserver() {
            return observer;
        }

        public void setObserver(List<String> observer) {
            this.observer = observer;
        }

        public List<String> getForward_observer() {
            return forward_observer;
        }

        public void setForward_observer(List<String> forward_observer) {
            this.forward_observer = forward_observer;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t[\"passwords\"] = \n\t\t{\n");
            sb.append("\t\t\t[\"artillery_commander\"] = {},\n");
            sb.append("\t\t\t[\"instructor\"] = {},\n");
            sb.append("\t\t\t[\"observer\"] = {},\n");
            sb.append("\t\t\t[\"forward_observer\"] = {},\n");
            sb.append("\t\t}, -- end of [\"passwords\"]\n");
            return sb.toString();
        }
    }

    public static class Roles {
        private Role artillery_commander;
        private Role instructor;
        private Role observer;
        private Role forward_observer;

        public Role getArtillery_commander() {
            return artillery_commander;
        }

        public void setArtillery_commander(Role artillery_commander) {
            this.artillery_commander = artillery_commander;
        }

        public Role getInstructor() {
            return instructor;
        }

        public void setInstructor(Role instructor) {
            this.instructor = instructor;
        }

        public Role getObserver() {
            return observer;
        }

        public void setObserver(Role observer) {
            this.observer = observer;
        }

        public Role getForward_observer() {
            return forward_observer;
        }

        public void setForward_observer(Role forward_observer) {
            this.forward_observer = forward_observer;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t[\"roles\"] = \n\t\t{\n");
            sb.append("\t\t\t[\"artillery_commander\"] = \n\t\t\t{\n");
            sb.append("\t\t\t\t[\"neutrals\"] = ").append(artillery_commander.getNeutrals()).append(",\n");
            sb.append("\t\t\t\t[\"blue\"] = ").append(artillery_commander.getBlue()).append(",\n");
            sb.append("\t\t\t\t[\"red\"] = ").append(artillery_commander.getRed()).append(",\n");
            sb.append("\t\t\t}, -- end of [\"artillery_commander\"]\n");
            sb.append("\t\t\t[\"instructor\"] = \n\t\t\t{\n");
            sb.append("\t\t\t\t[\"neutrals\"] = ").append(instructor.getNeutrals()).append(",\n");
            sb.append("\t\t\t\t[\"blue\"] = ").append(instructor.getBlue()).append(",\n");
            sb.append("\t\t\t\t[\"red\"] = ").append(instructor.getRed()).append(",\n");
            sb.append("\t\t\t}, -- end of [\"instructor\"]\n");
            sb.append("\t\t\t[\"observer\"] = \n\t\t\t{\n");
            sb.append("\t\t\t\t[\"neutrals\"] = ").append(observer.getNeutrals()).append(",\n");
            sb.append("\t\t\t\t[\"blue\"] = ").append(observer.getBlue()).append(",\n");
            sb.append("\t\t\t\t[\"red\"] = ").append(observer.getRed()).append(",\n");
            sb.append("\t\t\t}, -- end of [\"observer\"]\n");
            sb.append("\t\t\t[\"forward_observer\"] = \n\t\t\t{\n");
            sb.append("\t\t\t\t[\"neutrals\"] = ").append(forward_observer.getNeutrals()).append(",\n");
            sb.append("\t\t\t\t[\"blue\"] = ").append(forward_observer.getBlue()).append(",\n");
            sb.append("\t\t\t\t[\"red\"] = ").append(forward_observer.getRed()).append(",\n");
            sb.append("\t\t\t}, -- end of [\"forward_observer\"]\n");
            sb.append("\t\t}, -- end of [\"roles\"]\n");
            return sb.toString();
        }
    }

    public static class Role {
        private int neutrals;
        private int blue;
        private int red;

        public int getNeutrals() {
            return neutrals;
        }

        public void setNeutrals(int neutrals) {
            this.neutrals = neutrals;
        }

        public int getBlue() {
            return blue;
        }

        public void setBlue(int blue) {
            this.blue = blue;
        }

        public int getRed() {
            return red;
        }

        public void setRed(int red) {
            this.red = red;
        }
    }

    public static class RequiredModules {
        private String Massun92_Humans;
        private String UH_60L;

        public String getMassun92_Humans() {
            return Massun92_Humans;
        }

        public void setMassun92_Humans(String massun92_Humans) {
            Massun92_Humans = massun92_Humans;
        }

        public String getUH_60L() {
            return UH_60L;
        }

        public void setUH_60L(String UH_60L) {
            this.UH_60L = UH_60L;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t[\"requiredModules\"] = \n\t{\n");
            sb.append("\t\t[\"Massun92-Humans\"] = \"").append(Massun92_Humans).append("\",\n");
            sb.append("\t\t[\"UH-60L\"] = \"").append(UH_60L).append("\",\n");
            sb.append("\t}, -- end of [\"requiredModules\"]\n");
            return sb.toString();
        }
    }

    public static class Date {
        private int Day;
        private int Year;
        private int Month;

        public int getDay() {
            return Day;
        }

        public void setDay(int day) {
            Day = day;
        }

        public int getYear() {
            return Year;
        }

        public void setYear(int year) {
            Year = year;
        }

        public int getMonth() {
            return Month;
        }

        public void setMonth(int month) {
            Month = month;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t[\"date\"] = \n\t{\n");
            sb.append("\t\t[\"Day\"] = ").append(Day).append(",\n");
            sb.append("\t\t[\"Year\"] = ").append(Year).append(",\n");
            sb.append("\t\t[\"Month\"] = ").append(Month).append(",\n");
            sb.append("\t}, -- end of [\"date\"]\n");
            return sb.toString();
        }
    }

    public static class Trig {
        private List<String> actions = new ArrayList<>();
        private List<String> events = new ArrayList<>();
        private List<String> custom = new ArrayList<>();
        private List<String> func = new ArrayList<>();
        private List<Boolean> flag = new ArrayList<>();
        private List<String> conditions = new ArrayList<>();
        private List<String> customStartup = new ArrayList<>();
        private List<String> funcStartup = new ArrayList<>();

        public List<String> getActions() {
            return actions;
        }

        public void setActions(List<String> actions) {
            this.actions = actions;
        }

        public List<String> getEvents() {
            return events;
        }

        public void setEvents(List<String> events) {
            this.events = events;
        }

        public List<String> getCustom() {
            return custom;
        }

        public void setCustom(List<String> custom) {
            this.custom = custom;
        }

        public List<String> getFunc() {
            return func;
        }

        public void setFunc(List<String> func) {
            this.func = func;
        }

        public List<Boolean> getFlag() {
            return flag;
        }

        public void setFlag(List<Boolean> flag) {
            this.flag = flag;
        }

        public List<String> getConditions() {
            return conditions;
        }

        public void setConditions(List<String> conditions) {
            this.conditions = conditions;
        }

        public List<String> getCustomStartup() {
            return customStartup;
        }

        public void setCustomStartup(List<String> customStartup) {
            this.customStartup = customStartup;
        }

        public List<String> getFuncStartup() {
            return funcStartup;
        }

        public void setFuncStartup(List<String> funcStartup) {
            this.funcStartup = funcStartup;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t[\"trig\"] = \n\t{\n");
            sb.append("\t\t[\"actions\"] = \n\t\t{\n");
            for (int i = 0; i < actions.size(); i++) {
                sb.append("\t\t\t[").append(i + 1).append("] = \"").append(actions.get(i)).append("\",\n");
            }
            sb.append("\t\t}, -- end of [\"actions\"]\n");
            sb.append("\t\t[\"events\"] = {},\n");
            sb.append("\t\t[\"custom\"] = {},\n");
            sb.append("\t\t[\"func\"] = \n\t\t{\n");
            for (int i = 0; i < func.size(); i++) {
                sb.append("\t\t\t[").append(i + 1).append("] = \"").append(func.get(i)).append("\",\n");
            }
            sb.append("\t\t}, -- end of [\"func\"]\n");
            sb.append("\t\t[\"flag\"] = \n\t\t{\n");
            for (int i = 0; i < flag.size(); i++) {
                sb.append("\t\t\t[").append(i + 1).append("] = ").append(flag.get(i)).append(",\n");
            }
            sb.append("\t\t}, -- end of [\"flag\"]\n");
            sb.append("\t\t[\"conditions\"] = \n\t\t{\n");
            for (int i = 0; i < conditions.size(); i++) {
                sb.append("\t\t\t[").append(i + 1).append("] = \"").append(conditions.get(i)).append("\",\n");
            }
            sb.append("\t\t}, -- end of [\"conditions\"]\n");
            sb.append("\t\t[\"customStartup\"] = {},\n");
            sb.append("\t\t[\"funcStartup\"] = \n\t\t{\n");
            for (int i = 0; i < funcStartup.size(); i++) {
                sb.append("\t\t\t[").append(i + 1).append("] = \"").append(funcStartup.get(i)).append("\",\n");
            }
            sb.append("\t\t}, -- end of [\"funcStartup\"]\n");
            sb.append("\t}, -- end of [\"trig\"]\n");
            return sb.toString();
        }
    }

    public static class Result {
        private Offline offline;
        private int total;
        private BlueResult blue;
        private Red red;

        public Offline getOffline() {
            return offline;
        }

        public void setOffline(Offline offline) {
            this.offline = offline;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public BlueResult getBlue() {
            return blue;
        }

        public void setBlue(BlueResult blue) {
            this.blue = blue;
        }

        public Red getRed() {
            return red;
        }

        public void setRed(Red red) {
            this.red = red;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t[\"result\"] = \n\t{\n");
            sb.append(offline.toString());
            sb.append("\t\t[\"total\"] = ").append(total).append(",\n");
            sb.append(blue.toString());
            sb.append(red.toString());
            sb.append("\t}, -- end of [\"result\"]\n");
            return sb.toString();
        }
    }

    public static class Offline {
        private List<String> conditions = new ArrayList<>();
        private List<String> actions = new ArrayList<>();
        private List<String> func = new ArrayList<>();

        public List<String> getConditions() {
            return conditions;
        }

        public void setConditions(List<String> conditions) {
            this.conditions = conditions;
        }

        public List<String> getActions() {
            return actions;
        }

        public void setActions(List<String> actions) {
            this.actions = actions;
        }

        public List<String> getFunc() {
            return func;
        }

        public void setFunc(List<String> func) {
            this.func = func;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t[\"offline\"] = \n\t\t{\n");
            sb.append("\t\t\t[\"conditions\"] = {},\n");
            sb.append("\t\t\t[\"actions\"] = {},\n");
            sb.append("\t\t\t[\"func\"] = {},\n");
            sb.append("\t\t}, -- end of [\"offline\"]\n");
            return sb.toString();
        }
    }

    public static class BlueResult {
        private List<String> conditions = new ArrayList<>();
        private List<String> actions = new ArrayList<>();
        private List<String> func = new ArrayList<>();

        public List<String> getConditions() {
            return conditions;
        }

        public void setConditions(List<String> conditions) {
            this.conditions = conditions;
        }

        public List<String> getActions() {
            return actions;
        }

        public void setActions(List<String> actions) {
            this.actions = actions;
        }

        public List<String> getFunc() {
            return func;
        }

        public void setFunc(List<String> func) {
            this.func = func;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t[\"blue\"] = \n\t\t{\n");
            sb.append("\t\t\t[\"conditions\"] = {},\n");
            sb.append("\t\t\t[\"actions\"] = {},\n");
            sb.append("\t\t\t[\"func\"] = {},\n");
            sb.append("\t\t}, -- end of [\"blue\"]\n");
            return sb.toString();
        }
    }

    public static class Red {
        private List<String> conditions = new ArrayList<>();
        private List<String> actions = new ArrayList<>();
        private List<String> func = new ArrayList<>();

        public List<String> getConditions() {
            return conditions;
        }

        public void setConditions(List<String> conditions) {
            this.conditions = conditions;
        }

        public List<String> getActions() {
            return actions;
        }

        public void setActions(List<String> actions) {
            this.actions = actions;
        }

        public List<String> getFunc() {
            return func;
        }

        public void setFunc(List<String> func) {
            this.func = func;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t[\"red\"] = \n\t\t{\n");
            sb.append("\t\t\t[\"conditions\"] = {},\n");
            sb.append("\t\t\t[\"actions\"] = {},\n");
            sb.append("\t\t\t[\"func\"] = {},\n");
            sb.append("\t\t}, -- end of [\"red\"]\n");
            return sb.toString();
        }
    }

    public static class PictureFileName {
        private List<String> pictureFileName = new ArrayList<>();

        public List<String> getPictureFileName() {
            return pictureFileName;
        }

        public void setPictureFileName(List<String> pictureFileName) {
            this.pictureFileName = pictureFileName;
        }
    }

    public static class Drawings {
        private Options options;
        private List<Layer> layers = new ArrayList<>();

        public Options getOptions() {
            return options;
        }

        public void setOptions(Options options) {
            this.options = options;
        }

        public List<Layer> getLayers() {
            return layers;
        }

        public void setLayers(List<Layer> layers) {
            this.layers = layers;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t[\"drawings\"] = \n\t{\n");
            sb.append(options.toString());
            sb.append("\t\t[\"layers\"] = \n\t\t{\n");
            for (int i = 0; i < layers.size(); i++) {
                sb.append("\t\t\t[").append(i + 1).append("] = \n\t\t\t{\n");
                sb.append(layers.get(i).toString());
                sb.append("\t\t\t}, -- end of [").append(i + 1).append("]\n");
            }
            sb.append("\t\t}, -- end of [\"layers\"]\n");
            sb.append("\t}, -- end of [\"drawings\"]\n");
            return sb.toString();
        }
    }

    public static class Options {
        private HiddenOnF10Map hiddenOnF10Map;

        public HiddenOnF10Map getHiddenOnF10Map() {
            return hiddenOnF10Map;
        }

        public void setHiddenOnF10Map(HiddenOnF10Map hiddenOnF10Map) {
            this.hiddenOnF10Map = hiddenOnF10Map;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t[\"options\"] = \n\t\t{\n");
            sb.append(hiddenOnF10Map.toString());
            sb.append("\t\t}, -- end of [\"options\"]\n");
            return sb.toString();
        }
    }

    public static class HiddenOnF10Map {
        private Observer Observer;
        private Instructor Instructor;
        private ForwardObserver ForwardObserver;
        private ArtilleryCommander ArtilleryCommander;
        private Spectrator Spectrator;
        private Pilot Pilot;

        public Observer getObserver() {
            return Observer;
        }

        public void setObserver(Observer observer) {
            Observer = observer;
        }

        public Instructor getInstructor() {
            return Instructor;
        }

        public void setInstructor(Instructor instructor) {
            Instructor = instructor;
        }

        public ForwardObserver getForwardObserver() {
            return ForwardObserver;
        }

        public void setForwardObserver(ForwardObserver forwardObserver) {
            ForwardObserver = forwardObserver;
        }

        public ArtilleryCommander getArtilleryCommander() {
            return ArtilleryCommander;
        }

        public void setArtilleryCommander(ArtilleryCommander artilleryCommander) {
            ArtilleryCommander = artilleryCommander;
        }

        public Spectrator getSpectrator() {
            return Spectrator;
        }

        public void setSpectrator(Spectrator spectrator) {
            Spectrator = spectrator;
        }

        public Pilot getPilot() {
            return Pilot;
        }

        public void setPilot(Pilot pilot) {
            Pilot = pilot;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t[\"hiddenOnF10Map\"] = \n\t\t\t{\n");
            sb.append(Observer.toString());
            sb.append(Instructor.toString());
            sb.append(ForwardObserver.toString());
            sb.append(ArtilleryCommander.toString());
            sb.append(Spectrator.toString());
            sb.append(Pilot.toString());
            sb.append("\t\t\t}, -- end of [\"hiddenOnF10Map\"]\n");
            return sb.toString();
        }
    }

    public static class Observer {
        private boolean Neutral;
        private boolean Blue;
        private boolean Red;

        public boolean isNeutral() {
            return Neutral;
        }

        public void setNeutral(boolean neutral) {
            Neutral = neutral;
        }

        public boolean isBlue() {
            return Blue;
        }

        public void setBlue(boolean blue) {
            Blue = blue;
        }

        public boolean isRed() {
            return Red;
        }

        public void setRed(boolean red) {
            Red = red;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t\t[\"Observer\"] = \n\t\t\t\t{\n");
            sb.append("\t\t\t\t\t[\"Neutral\"] = ").append(Neutral).append(",\n");
            sb.append("\t\t\t\t\t[\"Blue\"] = ").append(Blue).append(",\n");
            sb.append("\t\t\t\t\t[\"Red\"] = ").append(Red).append(",\n");
            sb.append("\t\t\t\t}, -- end of [\"Observer\"]\n");
            return sb.toString();
        }
    }

    public static class Instructor {
        private boolean Neutral;
        private boolean Blue;
        private boolean Red;

        public boolean isNeutral() {
            return Neutral;
        }

        public void setNeutral(boolean neutral) {
            Neutral = neutral;
        }

        public boolean isBlue() {
            return Blue;
        }

        public void setBlue(boolean blue) {
            Blue = blue;
        }

        public boolean isRed() {
            return Red;
        }

        public void setRed(boolean red) {
            Red = red;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t\t[\"Instructor\"] = \n\t\t\t\t{\n");
            sb.append("\t\t\t\t\t[\"Neutral\"] = ").append(Neutral).append(",\n");
            sb.append("\t\t\t\t\t[\"Blue\"] = ").append(Blue).append(",\n");
            sb.append("\t\t\t\t\t[\"Red\"] = ").append(Red).append(",\n");
            sb.append("\t\t\t\t}, -- end of [\"Instructor\"]\n");
            return sb.toString();
        }
    }

    public static class ForwardObserver {
        private boolean Neutral;
        private boolean Blue;
        private boolean Red;

        public boolean isNeutral() {
            return Neutral;
        }

        public void setNeutral(boolean neutral) {
            Neutral = neutral;
        }

        public boolean isBlue() {
            return Blue;
        }

        public void setBlue(boolean blue) {
            Blue = blue;
        }

        public boolean isRed() {
            return Red;
        }

        public void setRed(boolean red) {
            Red = red;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t\t[\"ForwardObserver\"] = \n\t\t\t\t{\n");
            sb.append("\t\t\t\t\t[\"Neutral\"] = ").append(Neutral).append(",\n");
            sb.append("\t\t\t\t\t[\"Blue\"] = ").append(Blue).append(",\n");
            sb.append("\t\t\t\t\t[\"Red\"] = ").append(Red).append(",\n");
            sb.append("\t\t\t\t}, -- end of [\"ForwardObserver\"]\n");
            return sb.toString();
        }
    }

    public static class ArtilleryCommander {
        private boolean Neutral;
        private boolean Blue;
        private boolean Red;

        public boolean isNeutral() {
            return Neutral;
        }

        public void setNeutral(boolean neutral) {
            Neutral = neutral;
        }

        public boolean isBlue() {
            return Blue;
        }

        public void setBlue(boolean blue) {
            Blue = blue;
        }

        public boolean isRed() {
            return Red;
        }

        public void setRed(boolean red) {
            Red = red;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t\t[\"ArtilleryCommander\"] = \n\t\t\t\t{\n");
            sb.append("\t\t\t\t\t[\"Neutral\"] = ").append(Neutral).append(",\n");
            sb.append("\t\t\t\t\t[\"Blue\"] = ").append(Blue).append(",\n");
            sb.append("\t\t\t\t\t[\"Red\"] = ").append(Red).append(",\n");
            sb.append("\t\t\t\t}, -- end of [\"ArtilleryCommander\"]\n");
            return sb.toString();
        }
    }

    public static class Spectrator {
        private boolean Neutral;
        private boolean Blue;
        private boolean Red;

        public boolean isNeutral() {
            return Neutral;
        }

        public void setNeutral(boolean neutral) {
            Neutral = neutral;
        }

        public boolean isBlue() {
            return Blue;
        }

        public void setBlue(boolean blue) {
            Blue = blue;
        }

        public boolean isRed() {
            return Red;
        }

        public void setRed(boolean red) {
            Red = red;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t\t[\"Spectrator\"] = \n\t\t\t\t{\n");
            sb.append("\t\t\t\t\t[\"Neutral\"] = ").append(Neutral).append(",\n");
            sb.append("\t\t\t\t\t[\"Blue\"] = ").append(Blue).append(",\n");
            sb.append("\t\t\t\t\t[\"Red\"] = ").append(Red).append(",\n");
            sb.append("\t\t\t\t}, -- end of [\"Spectrator\"]\n");
            return sb.toString();
        }
    }

    public static class Pilot {
        private boolean Neutral;
        private boolean Blue;
        private boolean Red;

        public boolean isNeutral() {
            return Neutral;
        }

        public void setNeutral(boolean neutral) {
            Neutral = neutral;
        }

        public boolean isBlue() {
            return Blue;
        }

        public void setBlue(boolean blue) {
            Blue = blue;
        }

        public boolean isRed() {
            return Red;
        }

        public void setRed(boolean red) {
            Red = red;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t\t[\"Pilot\"] = \n\t\t\t\t{\n");
            sb.append("\t\t\t\t\t[\"Neutral\"] = ").append(Neutral).append(",\n");
            sb.append("\t\t\t\t\t[\"Blue\"] = ").append(Blue).append(",\n");
            sb.append("\t\t\t\t\t[\"Red\"] = ").append(Red).append(",\n");
            sb.append("\t\t\t\t}, -- end of [\"Pilot\"]\n");
            return sb.toString();
        }
    }

    public static class Layer {
        private boolean visible;
        private String name;
        private List<Object> objects = new ArrayList<>();

        public boolean isVisible() {
            return visible;
        }

        public void setVisible(boolean visible) {
            this.visible = visible;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Object> getObjects() {
            return objects;
        }

        public void setObjects(List<Object> objects) {
            this.objects = objects;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t\t[\"visible\"] = ").append(visible).append(",\n");
            sb.append("\t\t\t\t[\"name\"] = \"").append(name).append("\",\n");
            sb.append("\t\t\t\t[\"objects\"] = {},\n");
            return sb.toString();
        }
    }

    public static class Weather {
        private Wind wind;
        private boolean enable_fog;
        private Season season;
        private double qnh;
        private List<String> cyclones = new ArrayList<>();
        private int dust_density;
        private boolean enable_dust;
        private Clouds clouds;
        private int atmosphere_type;
        private double groundTurbulence;
        private Halo halo;
        private int type_weather;
        private boolean modifiedTime;
        private Fog2 fog2;
        private String name;
        private Fog fog;
        private Visibility visibility;

        public Wind getWind() {
            return wind;
        }

        public void setWind(Wind wind) {
            this.wind = wind;
        }

        public boolean isEnable_fog() {
            return enable_fog;
        }

        public void setEnable_fog(boolean enable_fog) {
            this.enable_fog = enable_fog;
        }

        public Season getSeason() {
            return season;
        }

        public void setSeason(Season season) {
            this.season = season;
        }

        public double getQnh() {
            return qnh;
        }

        public void setQnh(double qnh) {
            this.qnh = qnh;
        }

        public List<String> getCyclones() {
            return cyclones;
        }

        public void setCyclones(List<String> cyclones) {
            this.cyclones = cyclones;
        }

        public int getDust_density() {
            return dust_density;
        }

        public void setDust_density(int dust_density) {
            this.dust_density = dust_density;
        }

        public boolean isEnable_dust() {
            return enable_dust;
        }

        public void setEnable_dust(boolean enable_dust) {
            this.enable_dust = enable_dust;
        }

        public Clouds getClouds() {
            return clouds;
        }

        public void setClouds(Clouds clouds) {
            this.clouds = clouds;
        }

        public int getAtmosphere_type() {
            return atmosphere_type;
        }

        public void setAtmosphere_type(int atmosphere_type) {
            this.atmosphere_type = atmosphere_type;
        }

        public double getGroundTurbulence() {
            return groundTurbulence;
        }

        public void setGroundTurbulence(double groundTurbulence) {
            this.groundTurbulence = groundTurbulence;
        }

        public Halo getHalo() {
            return halo;
        }

        public void setHalo(Halo halo) {
            this.halo = halo;
        }

        public int getType_weather() {
            return type_weather;
        }

        public void setType_weather(int type_weather) {
            this.type_weather = type_weather;
        }

        public boolean isModifiedTime() {
            return modifiedTime;
        }

        public void setModifiedTime(boolean modifiedTime) {
            this.modifiedTime = modifiedTime;
        }

        public Fog2 getFog2() {
            return fog2;
        }

        public void setFog2(Fog2 fog2) {
            this.fog2 = fog2;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Fog getFog() {
            return fog;
        }

        public void setFog(Fog fog) {
            this.fog = fog;
        }

        public Visibility getVisibility() {
            return visibility;
        }

        public void setVisibility(Visibility visibility) {
            this.visibility = visibility;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t[\"weather\"] = \n\t{\n");
            sb.append(wind.toString());
            sb.append("\t\t[\"enable_fog\"] = ").append(enable_fog).append(",\n");
            sb.append(season.toString());
            sb.append("\t\t[\"qnh\"] = ").append(qnh).append(",\n");
            sb.append("\t\t[\"cyclones\"] = {},\n");
            sb.append("\t\t[\"dust_density\"] = ").append(dust_density).append(",\n");
            sb.append("\t\t[\"enable_dust\"] = ").append(enable_dust).append(",\n");
            sb.append(clouds.toString());
            sb.append("\t\t[\"atmosphere_type\"] = ").append(atmosphere_type).append(",\n");
            sb.append("\t\t[\"groundTurbulence\"] = ").append(groundTurbulence).append(",\n");
            sb.append(halo.toString());
            sb.append("\t\t[\"type_weather\"] = ").append(type_weather).append(",\n");
            sb.append("\t\t[\"modifiedTime\"] = ").append(modifiedTime).append(",\n");
            sb.append(fog2.toString());
            sb.append("\t\t[\"name\"] = \"").append(name).append("\",\n");
            sb.append(fog.toString());
            sb.append(visibility.toString());
            sb.append("\t}, -- end of [\"weather\"]\n");
            return sb.toString();
        }
    }

    public static class Wind {
        private At8000 at8000;
        private AtGround atGround;
        private At2000 at2000;

        public At8000 getAt8000() {
            return at8000;
        }

        public void setAt8000(At8000 at8000) {
            this.at8000 = at8000;
        }

        public AtGround getAtGround() {
            return atGround;
        }

        public void setAtGround(AtGround atGround) {
            this.atGround = atGround;
        }

        public At2000 getAt2000() {
            return at2000;
        }

        public void setAt2000(At2000 at2000) {
            this.at2000 = at2000;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t[\"wind\"] = \n\t\t{\n");
            sb.append(at8000.toString());
            sb.append(atGround.toString());
            sb.append(at2000.toString());
            sb.append("\t\t}, -- end of [\"wind\"]\n");
            return sb.toString();
        }
    }

    public static class At8000 {
        private double speed;
        private int dir;

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        public int getDir() {
            return dir;
        }

        public void setDir(int dir) {
            this.dir = dir;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t[\"at8000\"] = \n\t\t\t{\n");
            sb.append("\t\t\t\t[\"speed\"] = ").append(speed).append(",\n");
            sb.append("\t\t\t\t[\"dir\"] = ").append(dir).append(",\n");
            sb.append("\t\t\t}, -- end of [\"at8000\"]\n");
            return sb.toString();
        }
    }

    public static class AtGround {
        private double speed;
        private double dir;

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        public double getDir() {
            return dir;
        }

        public void setDir(double dir) {
            this.dir = dir;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t[\"atGround\"] = \n\t\t\t{\n");
            sb.append("\t\t\t\t[\"speed\"] = ").append(speed).append(",\n");
            sb.append("\t\t\t\t[\"dir\"] = ").append(dir).append(",\n");
            sb.append("\t\t\t}, -- end of [\"atGround\"]\n");
            return sb.toString();
        }
    }

    public static class At2000 {
        private double speed;
        private int dir;

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        public int getDir() {
            return dir;
        }

        public void setDir(int dir) {
            this.dir = dir;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t[\"at2000\"] = \n\t\t\t{\n");
            sb.append("\t\t\t\t[\"speed\"] = ").append(speed).append(",\n");
            sb.append("\t\t\t\t[\"dir\"] = ").append(dir).append(",\n");
            sb.append("\t\t\t}, -- end of [\"at2000\"]\n");
            return sb.toString();
        }
    }

    public static class Season {
        private int temperature;

        public int getTemperature() {
            return temperature;
        }

        public void setTemperature(int temperature) {
            this.temperature = temperature;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t[\"season\"] = \n\t\t{\n");
            sb.append("\t\t\t[\"temperature\"] = ").append(temperature).append(",\n");
            sb.append("\t\t}, -- end of [\"season\"]\n");
            return sb.toString();
        }
    }

    public static class Clouds {
        private int thickness;
        private int density;
        private String preset;
        private int base;
        private int iprecptns;

        public int getThickness() {
            return thickness;
        }

        public void setThickness(int thickness) {
            this.thickness = thickness;
        }

        public int getDensity() {
            return density;
        }

        public void setDensity(int density) {
            this.density = density;
        }

        public String getPreset() {
            return preset;
        }

        public void setPreset(String preset) {
            this.preset = preset;
        }

        public int getBase() {
            return base;
        }

        public void setBase(int base) {
            this.base = base;
        }

        public int getIprecptns() {
            return iprecptns;
        }

        public void setIprecptns(int iprecptns) {
            this.iprecptns = iprecptns;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t[\"clouds\"] = \n\t\t{\n");
            sb.append("\t\t\t[\"thickness\"] = ").append(thickness).append(",\n");
            sb.append("\t\t\t[\"density\"] = ").append(density).append(",\n");
            sb.append("\t\t\t[\"preset\"] = \"").append(preset).append("\",\n");
            sb.append("\t\t\t[\"base\"] = ").append(base).append(",\n");
            sb.append("\t\t\t[\"iprecptns\"] = ").append(iprecptns).append(",\n");
            sb.append("\t\t}, -- end of [\"clouds\"]\n");
            return sb.toString();
        }
    }

    public static class Halo {
        private String preset;

        public String getPreset() {
            return preset;
        }

        public void setPreset(String preset) {
            this.preset = preset;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t[\"halo\"] = \n\t\t{\n");
            sb.append("\t\t\t[\"preset\"] = \"").append(preset).append("\",\n");
            sb.append("\t\t}, -- end of [\"halo\"]\n");
            return sb.toString();
        }
    }

    public static class Fog2 {
        private int mode;

        public int getMode() {
            return mode;
        }

        public void setMode(int mode) {
            this.mode = mode;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t[\"fog2\"] = \n\t\t{\n");
            sb.append("\t\t\t[\"mode\"] = ").append(mode).append(",\n");
            sb.append("\t\t}, -- end of [\"fog2\"]\n");
            return sb.toString();
        }
    }

    public static class Fog {
        private int thickness;
        private int visibility;

        public int getThickness() {
            return thickness;
        }

        public void setThickness(int thickness) {
            this.thickness = thickness;
        }

        public int getVisibility() {
            return visibility;
        }

        public void setVisibility(int visibility) {
            this.visibility = visibility;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t[\"fog\"] = \n\t\t{\n");
            sb.append("\t\t\t[\"thickness\"] = ").append(thickness).append(",\n");
            sb.append("\t\t\t[\"visibility\"] = ").append(visibility).append(",\n");
            sb.append("\t\t}, -- end of [\"fog\"]\n");
            return sb.toString();
        }
    }

    public static class Visibility {
        private int distance;

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t[\"visibility\"] = \n\t\t{\n");
            sb.append("\t\t\t[\"distance\"] = ").append(distance).append(",\n");
            sb.append("\t\t}, -- end of [\"visibility\"]\n");
            return sb.toString();
        }
    }

    public static class Triggers {
        private List<Zone> zones = new ArrayList<>();

        public List<Zone> getZones() {
            return zones;
        }

        public void setZones(List<Zone> zones) {
            this.zones = zones;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t[\"triggers\"] = \n\t{\n");
            sb.append("\t\t[\"zones\"] = \n\t\t{\n");
            for (int i = 0; i < zones.size(); i++) {
                sb.append("\t\t\t[").append(i + 1).append("] = \n\t\t\t{\n");
                sb.append(zones.get(i).toString());
                sb.append("\t\t\t}, -- end of [").append(i + 1).append("]\n");
            }
            sb.append("\t\t}, -- end of [\"zones\"]\n");
            sb.append("\t}, -- end of [\"triggers\"]\n");
            return sb.toString();
        }
    }

    public static class Zone {
        private double radius;
        private int zoneId;
        private Color color;
        private List<String> properties = new ArrayList<>();
        private boolean hidden;
        private double y;
        private double x;
        private String name;
        private double heading;
        private int linkUnit;
        private int type;

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        public int getZoneId() {
            return zoneId;
        }

        public void setZoneId(int zoneId) {
            this.zoneId = zoneId;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public List<String> getProperties() {
            return properties;
        }

        public void setProperties(List<String> properties) {
            this.properties = properties;
        }

        public boolean isHidden() {
            return hidden;
        }

        public void setHidden(boolean hidden) {
            this.hidden = hidden;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getHeading() {
            return heading;
        }

        public void setHeading(double heading) {
            this.heading = heading;
        }

        public int getLinkUnit() {
            return linkUnit;
        }

        public void setLinkUnit(int linkUnit) {
            this.linkUnit = linkUnit;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t\t[\"radius\"] = ").append(radius).append(",\n");
            sb.append("\t\t\t\t[\"zoneId\"] = ").append(zoneId).append(",\n");
            sb.append(color.toString());
            sb.append("\t\t\t\t[\"properties\"] = {},\n");
            sb.append("\t\t\t\t[\"hidden\"] = ").append(hidden).append(",\n");
            sb.append("\t\t\t\t[\"y\"] = ").append(y).append(",\n");
            sb.append("\t\t\t\t[\"x\"] = ").append(x).append(",\n");
            sb.append("\t\t\t\t[\"name\"] = \"").append(name).append("\",\n");
            sb.append("\t\t\t\t[\"heading\"] = ").append(heading).append(",\n");
            sb.append("\t\t\t\t[\"linkUnit\"] = ").append(linkUnit).append(",\n");
            sb.append("\t\t\t\t[\"type\"] = ").append(type).append(",\n");
            return sb.toString();
        }
    }

    public static class Color {
        private double r;
        private double g;
        private double b;
        private double a;

        public double getR() {
            return r;
        }

        public void setR(double r) {
            this.r = r;
        }

        public double getG() {
            return g;
        }

        public void setG(double g) {
            this.g = g;
        }

        public double getB() {
            return b;
        }

        public void setB(double b) {
            this.b = b;
        }

        public double getA() {
            return a;
        }

        public void setA(double a) {
            this.a = a;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t\t[\"color\"] = \n\t\t\t\t{\n");
            sb.append("\t\t\t\t\t[\"r\"] = ").append(r).append(",\n");
            sb.append("\t\t\t\t\t[\"g\"] = ").append(g).append(",\n");
            sb.append("\t\t\t\t\t[\"b\"] = ").append(b).append(",\n");
            sb.append("\t\t\t\t\t[\"a\"] = ").append(a).append(",\n");
            sb.append("\t\t\t\t}, -- end of [\"color\"]\n");
            return sb.toString();
        }
    }

    public static class Map {
        private double centerY;
        private double zoom;
        private double centerX;

        public double getCenterY() {
            return centerY;
        }

        public void setCenterY(double centerY) {
            this.centerY = centerY;
        }

        public double getZoom() {
            return zoom;
        }

        public void setZoom(double zoom) {
            this.zoom = zoom;
        }

        public double getCenterX() {
            return centerX;
        }

        public void setCenterX(double centerX) {
            this.centerX = centerX;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t[\"map\"] = \n\t{\n");
            sb.append("\t\t[\"centerY\"] = ").append(centerY).append(",\n");
            sb.append("\t\t[\"zoom\"] = ").append(zoom).append(",\n");
            sb.append("\t\t[\"centerX\"] = ").append(centerX).append(",\n");
            sb.append("\t}, -- end of [\"map\"]\n");
            return sb.toString();
        }
    }

    public static class Coalitions {
        private List<Integer> blue = new ArrayList<>();
        private List<Integer> neutrals = new ArrayList<>();
        private List<Integer> red = new ArrayList<>();

        public List<Integer> getBlue() {
            return blue;
        }

        public void setBlue(List<Integer> blue) {
            this.blue = blue;
        }

        public List<Integer> getNeutrals() {
            return neutrals;
        }

        public void setNeutrals(List<Integer> neutrals) {
            this.neutrals = neutrals;
        }

        public List<Integer> getRed() {
            return red;
        }

        public void setRed(List<Integer> red) {
            this.red = red;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t[\"coalitions\"] = \n\t{\n");
            sb.append("\t\t[\"blue\"] = {},\n");
            sb.append("\t\t[\"neutrals\"] = {},\n");
            sb.append("\t\t[\"red\"] = {},\n");
            sb.append("\t}, -- end of [\"coalitions\"]\n");
            return sb.toString();
        }
    }

    public static class Goals {
        private List<String> goals = new ArrayList<>();

        public List<String> getGoals() {
            return goals;
        }

        public void setGoals(List<String> goals) {
            this.goals = goals;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t[\"goals\"] = \n\t{\n");
            sb.append("\t\t[\"goals\"] = {},\n");
            sb.append("\t}, -- end of [\"goals\"]\n");
            return sb.toString();
        }
    }

    public static class Coalition {
        private Neutrals neutrals;
        private Blue blue;

        public Neutrals getNeutrals() {
            return neutrals;
        }

        public void setNeutrals(Neutrals neutrals) {
            this.neutrals = neutrals;
        }

        public Blue getBlue() {
            return blue;
        }

        public void setBlue(Blue blue) {
            this.blue = blue;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t[\"coalition\"] = \n\t{\n");
            sb.append(neutrals.toString());
            sb.append(blue.toString());
            sb.append("\t}, -- end of [\"coalition\"]\n");
            return sb.toString();
        }
    }

    public static class Neutrals {
        private Bullseye bullseye;
        private List<String> nav_points = new ArrayList<>();
        private String name;
        private List<String> country = new ArrayList<>();

        public Bullseye getBullseye() {
            return bullseye;
        }

        public void setBullseye(Bullseye bullseye) {
            this.bullseye = bullseye;
        }

        public List<String> getNav_points() {
            return nav_points;
        }

        public void setNav_points(List<String> nav_points) {
            this.nav_points = nav_points;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getCountry() {
            return country;
        }

        public void setCountry(List<String> country) {
            this.country = country;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t[\"neutrals\"] = \n\t\t{\n");
            sb.append(bullseye.toString());
            sb.append("\t\t\t[\"nav_points\"] = {},\n");
            sb.append("\t\t\t[\"name\"] = \"").append(name).append("\",\n");
            sb.append("\t\t\t[\"country\"] = {},\n");
            sb.append("\t\t}, -- end of [\"neutrals\"]\n");
            return sb.toString();
        }
    }

    public static class Bullseye {
        private double y;
        private double x;

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t[\"bullseye\"] = \n\t\t\t{\n");
            sb.append("\t\t\t\t[\"y\"] = ").append(y).append(",\n");
            sb.append("\t\t\t\t[\"x\"] = ").append(x).append(",\n");
            sb.append("\t\t\t}, -- end of [\"bullseye\"]\n");
            return sb.toString();
        }
    }

    public static class Blue {
        private Bullseye bullseye;
        private List<String> nav_points = new ArrayList<>();
        private String name;
        private List<Country> country = new ArrayList<>();

        public Bullseye getBullseye() {
            return bullseye;
        }

        public void setBullseye(Bullseye bullseye) {
            this.bullseye = bullseye;
        }

        public List<String> getNav_points() {
            return nav_points;
        }

        public void setNav_points(List<String> nav_points) {
            this.nav_points = nav_points;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Country> getCountry() {
            return country;
        }

        public void setCountry(List<Country> country) {
            this.country = country;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t[\"blue\"] = \n\t\t{\n");
            sb.append(bullseye.toString());
            sb.append("\t\t\t[\"nav_points\"] = {},\n");
            sb.append("\t\t\t[\"name\"] = \"").append(name).append("\",\n");
            sb.append("\t\t\t[\"country\"] = {},\n");
            sb.append("\t\t}, -- end of [\"blue\"]\n");
            return sb.toString();
        }
    }

    public static class Country {
        private Helicopter helicopter;
        private String name;
        private Ship ship;
        private int id;
        private Vehicle vehicle;
        private Plane plane;

        public Helicopter getHelicopter() {
            return helicopter;
        }

        public void setHelicopter(Helicopter helicopter) {
            this.helicopter = helicopter;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Ship getShip() {
            return ship;
        }

        public void setShip(Ship ship) {
            this.ship = ship;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Vehicle getVehicle() {
            return vehicle;
        }

        public void setVehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
        }

        public Plane getPlane() {
            return plane;
        }

        public void setPlane(Plane plane) {
            this.plane = plane;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t\t[\"helicopter\"] = {},\n");
            sb.append("\t\t\t\t[\"name\"] = \"").append(name).append("\",\n");
            sb.append("\t\t\t\t[\"ship\"] = {},\n");
            sb.append("\t\t\t\t[\"id\"] = ").append(id).append(",\n");
            sb.append("\t\t\t\t[\"vehicle\"] = {},\n");
            sb.append("\t\t\t\t[\"plane\"] = {},\n");
            return sb.toString();
        }
    }

    public static class Helicopter {
        private List<Group> group = new ArrayList<>();

        public List<Group> getGroup() {
            return group;
        }

        public void setGroup(List<Group> group) {
            this.group = group;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t\t\t[\"group\"] = {},\n");
            return sb.toString();
        }
    }

    public static class Group {
        private boolean modulation;
        private List<String> tasks = new ArrayList<>();
        private boolean radioSet;
        private String task;
        private boolean uncontrolled;
        private Route route;
        private int groupId;
        private boolean hidden;
        private List<Unit> units = new ArrayList<>();
        private double y;
        private double x;
        private String name;
        private boolean communication;
        private int start_time;
        private boolean uncontrollable;
        private double frequency;

        public boolean isModulation() {
            return modulation;
        }

        public void setModulation(boolean modulation) {
            this.modulation = modulation;
        }

        public List<String> getTasks() {
            return tasks;
        }

        public void setTasks(List<String> tasks) {
            this.tasks = tasks;
        }

        public boolean isRadioSet() {
            return radioSet;
        }

        public void setRadioSet(boolean radioSet) {
            this.radioSet = radioSet;
        }

        public String getTask() {
            return task;
        }

        public void setTask(String task) {
            this.task = task;
        }

        public boolean isUncontrolled() {
            return uncontrolled;
        }

        public void setUncontrolled(boolean uncontrolled) {
            this.uncontrolled = uncontrolled;
        }

        public Route getRoute() {
            return route;
        }

        public void setRoute(Route route) {
            this.route = route;
        }

        public int getGroupId() {
            return groupId;
        }

        public void setGroupId(int groupId) {
            this.groupId = groupId;
        }

        public boolean isHidden() {
            return hidden;
        }

        public void setHidden(boolean hidden) {
            this.hidden = hidden;
        }

        public List<Unit> getUnits() {
            return units;
        }

        public void setUnits(List<Unit> units) {
            this.units = units;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isCommunication() {
            return communication;
        }

        public void setCommunication(boolean communication) {
            this.communication = communication;
        }

        public int getStart_time() {
            return start_time;
        }

        public void setStart_time(int start_time) {
            this.start_time = start_time;
        }

        public boolean isUncontrollable() {
            return uncontrollable;
        }

        public void setUncontrollable(boolean uncontrollable) {
            this.uncontrollable = uncontrollable;
        }

        public double getFrequency() {
            return frequency;
        }

        public void setFrequency(double frequency) {
            this.frequency = frequency;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t\t\t[\"modulation\"] = ").append(modulation).append(",\n");
            sb.append("\t\t\t\t\t[\"tasks\"] = {},\n");
            sb.append("\t\t\t\t\t[\"radioSet\"] = ").append(radioSet).append(",\n");
            sb.append("\t\t\t\t\t[\"task\"] = \"").append(task).append("\",\n");
            sb.append("\t\t\t\t\t[\"uncontrolled\"] = ").append(uncontrolled).append(",\n");
            sb.append(route.toString());
            sb.append("\t\t\t\t\t[\"groupId\"] = ").append(groupId).append(",\n");
            sb.append("\t\t\t\t\t[\"hidden\"] = ").append(hidden).append(",\n");
            sb.append("\t\t\t\t\t[\"units\"] = {},\n");
            sb.append("\t\t\t\t\t[\"y\"] = ").append(y).append(",\n");
            sb.append("\t\t\t\t\t[\"x\"] = ").append(x).append(",\n");
            sb.append("\t\t\t\t\t[\"name\"] = \"").append(name).append("\",\n");
            sb.append("\t\t\t\t\t[\"communication\"] = ").append(communication).append(",\n");
            sb.append("\t\t\t\t\t[\"start_time\"] = ").append(start_time).append(",\n");
            sb.append("\t\t\t\t\t[\"uncontrollable\"] = ").append(uncontrollable).append(",\n");
            sb.append("\t\t\t\t\t[\"frequency\"] = ").append(frequency).append(",\n");
            return sb.toString();
        }
    }

    public static class Route {
        private List<Point> points = new ArrayList<>();

        public List<Point> getPoints() {
            return points;
        }

        public void setPoints(List<Point> points) {
            this.points = points;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t\t\t\t[\"points\"] = {},\n");
            return sb.toString();
        }
    }

    public static class Point {
        private double alt;
        private String action;
        private String alt_type;
        private double speed;
        private Task task;
        private String type;
        private double ETA;
        private boolean ETA_locked;
        private double y;
        private double x;
        private boolean speed_locked;
        private String formation_template;

        public double getAlt() {
            return alt;
        }

        public void setAlt(double alt) {
            this.alt = alt;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public String getAlt_type() {
            return alt_type;
        }

        public void setAlt_type(String alt_type) {
            this.alt_type = alt_type;
        }

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        public Task getTask() {
            return task;
        }

        public void setTask(Task task) {
            this.task = task;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getETA() {
            return ETA;
        }

        public void setETA(double ETA) {
            this.ETA = ETA;
        }

        public boolean isETA_locked() {
            return ETA_locked;
        }

        public void setETA_locked(boolean ETA_locked) {
            this.ETA_locked = ETA_locked;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public boolean isSpeed_locked() {
            return speed_locked;
        }

        public void setSpeed_locked(boolean speed_locked) {
            this.speed_locked = speed_locked;
        }

        public String getFormation_template() {
            return formation_template;
        }

        public void setFormation_template(String formation_template) {
            this.formation_template = formation_template;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t\t\t\t\t[\"alt\"] = ").append(alt).append(",\n");
            sb.append("\t\t\t\t\t\t\t[\"action\"] = \"").append(action).append("\",\n");
            sb.append("\t\t\t\t\t\t\t[\"alt_type\"] = \"").append(alt_type).append("\",\n");
            sb.append("\t\t\t\t\t\t\t[\"speed\"] = ").append(speed).append(",\n");
            sb.append(task.toString());
            sb.append("\t\t\t\t\t\t\t[\"type\"] = \"").append(type).append("\",\n");
            sb.append("\t\t\t\t\t\t\t[\"ETA\"] = ").append(ETA).append(",\n");
            sb.append("\t\t\t\t\t\t\t[\"ETA_locked\"] = ").append(ETA_locked).append(",\n");
            sb.append("\t\t\t\t\t\t\t[\"y\"] = ").append(y).append(",\n");
            sb.append("\t\t\t\t\t\t\t[\"x\"] = ").append(x).append(",\n");
            sb.append("\t\t\t\t\t\t\t[\"speed_locked\"] = ").append(speed_locked).append(",\n");
            sb.append("\t\t\t\t\t\t\t[\"formation_template\"] = \"").append(formation_template).append("\",\n");
            return sb.toString();
        }
    }

    public static class Task {
        private String id;
        private Params params;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Params getParams() {
            return params;
        }

        public void setParams(Params params) {
            this.params = params;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t\t\t\t\t\t[\"id\"] = \"").append(id).append("\",\n");
            sb.append(params.toString());
            return sb.toString();
        }
    }

    public static class Params {
        private List<String> tasks = new ArrayList<>();

        public List<String> getTasks() {
            return tasks;
        }

        public void setTasks(List<String> tasks) {
            this.tasks = tasks;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t\t\t\t\t\t\t[\"tasks\"] = {},\n");
            return sb.toString();
        }
    }

    public static class Unit {
        private double alt;
        private boolean hardpoint_racks;
        private String alt_type;
        private String livery_id;
        private String skill;
        private String parking;
        private double ropeLength;
        private double speed;
        private AddPropAircraft AddPropAircraft;
        private String type;
        private Radio Radio;
        private int unitId;
        private double psi;
        private String onboard_num;
        private String parking_id;
        private double x;
        private String name;
        private Payload payload;
        private double y;
        private double heading;
        private Callsign callsign;

        public double getAlt() {
            return alt;
        }

        public void setAlt(double alt) {
            this.alt = alt;
        }

        public boolean isHardpoint_racks() {
            return hardpoint_racks;
        }

        public void setHardpoint_racks(boolean hardpoint_racks) {
            this.hardpoint_racks = hardpoint_racks;
        }

        public String getAlt_type() {
            return alt_type;
        }

        public void setAlt_type(String alt_type) {
            this.alt_type = alt_type;
        }

        public String getLivery_id() {
            return livery_id;
        }

        public void setLivery_id(String livery_id) {
            this.livery_id = livery_id;
        }

        public String getSkill() {
            return skill;
        }

        public void setSkill(String skill) {
            this.skill = skill;
        }

        public String getParking() {
            return parking;
        }

        public void setParking(String parking) {
            this.parking = parking;
        }

        public double getRopeLength() {
            return ropeLength;
        }

        public void setRopeLength(double ropeLength) {
            this.ropeLength = ropeLength;
        }

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        public AddPropAircraft getAddPropAircraft() {
            return AddPropAircraft;
        }

        public void setAddPropAircraft(AddPropAircraft addPropAircraft) {
            AddPropAircraft = addPropAircraft;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Radio getRadio() {
            return Radio;
        }

        public void setRadio(Radio radio) {
            Radio = radio;
        }

        public int getUnitId() {
            return unitId;
        }

        public void setUnitId(int unitId) {
            this.unitId = unitId;
        }

        public double getPsi() {
            return psi;
        }

        public void setPsi(double psi) {
            this.psi = psi;
        }

        public String getOnboard_num() {
            return onboard_num;
        }

        public void setOnboard_num(String onboard_num) {
            this.onboard_num = onboard_num;
        }

        public String getParking_id() {
            return parking_id;
        }

        public void setParking_id(String parking_id) {
            this.parking_id = parking_id;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Payload getPayload() {
            return payload;
        }

        public void setPayload(Payload payload) {
            this.payload = payload;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public double getHeading() {
            return heading;
        }

        public void setHeading(double heading) {
            this.heading = heading;
        }

        public Callsign getCallsign() {
            return callsign;
        }

        public void setCallsign(Callsign callsign) {
            this.callsign = callsign;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t\t\t[\"alt\"] = ").append(alt).append(",\n");
            sb.append("\t\t\t\t\t[\"hardpoint_racks\"] = ").append(hardpoint_racks).append(",\n");
            sb.append("\t\t\t\t\t[\"alt_type\"] = \"").append(alt_type).append("\",\n");
            sb.append("\t\t\t\t\t[\"livery_id\"] = \"").append(livery_id).append("\",\n");
            sb.append("\t\t\t\t\t[\"skill\"] = \"").append(skill).append("\",\n");
            sb.append("\t\t\t\t\t[\"parking\"] = \"").append(parking).append("\",\n");
            sb.append("\t\t\t\t\t[\"ropeLength\"] = ").append(ropeLength).append(",\n");
            sb.append("\t\t\t\t\t[\"speed\"] = ").append(speed).append(",\n");
            sb.append(AddPropAircraft.toString());
            sb.append("\t\t\t\t\t[\"type\"] = \"").append(type).append("\",\n");
            sb.append(Radio.toString());
            sb.append("\t\t\t\t\t[\"unitId\"] = ").append(unitId).append(",\n");
            sb.append("\t\t\t\t\t[\"psi\"] = ").append(psi).append(",\n");
            sb.append("\t\t\t\t\t[\"onboard_num\"] = \"").append(onboard_num).append("\",\n");
            sb.append("\t\t\t\t\t[\"parking_id\"] = \"").append(parking_id).append("\",\n");
            sb.append("\t\t\t\t\t[\"x\"] = ").append(x).append(",\n");
            sb.append("\t\t\t\t\t[\"name\"] = \"").append(name).append("\",\n");
            sb.append(payload.toString());
            sb.append("\t\t\t\t\t[\"y\"] = ").append(y).append(",\n");
            sb.append("\t\t\t\t\t[\"heading\"] = ").append(heading).append(",\n");
            sb.append(callsign.toString());
            return sb.toString();
        }
    }

    public static class AddPropAircraft {
        private boolean SoloFlight;
        private boolean ExhaustScreen;
        private int GunnersAISkill;
        private int NetCrewControlPriority;
        private int EngineResource;

        public boolean isSoloFlight() {
            return SoloFlight;
        }

        public void setSoloFlight(boolean soloFlight) {
            SoloFlight = soloFlight;
        }

        public boolean isExhaustScreen() {
            return ExhaustScreen;
        }

        public void setExhaustScreen(boolean exhaustScreen) {
            ExhaustScreen = exhaustScreen;
        }

        public int getGunnersAISkill() {
            return GunnersAISkill;
        }

        public void setGunnersAISkill(int gunnersAISkill) {
            GunnersAISkill = gunnersAISkill;
        }

        public int getNetCrewControlPriority() {
            return NetCrewControlPriority;
        }

        public void setNetCrewControlPriority(int netCrewControlPriority) {
            NetCrewControlPriority = netCrewControlPriority;
        }

        public int getEngineResource() {
            return EngineResource;
        }

        public void setEngineResource(int engineResource) {
            EngineResource = engineResource;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t\t\t[\"AddPropAircraft\"] = \n\t\t\t\t\t{\n");
            sb.append("\t\t\t\t\t\t[\"SoloFlight\"] = ").append(SoloFlight).append(",\n");
            sb.append("\t\t\t\t\t\t[\"ExhaustScreen\"] = ").append(ExhaustScreen).append(",\n");
            sb.append("\t\t\t\t\t\t[\"GunnersAISkill\"] = ").append(GunnersAISkill).append(",\n");
            sb.append("\t\t\t\t\t\t[\"NetCrewControlPriority\"] = ").append(NetCrewControlPriority).append(",\n");
            sb.append("\t\t\t\t\t\t[\"EngineResource\"] = ").append(EngineResource).append(",\n");
            sb.append("\t\t\t\t\t}, -- end of [\"AddPropAircraft\"]\n");
            return sb.toString();
        }
    }

    public static class Radio {
        private List<Channel> channels = new ArrayList<>();

        public List<Channel> getChannels() {
            return channels;
        }

        public void setChannels(List<Channel> channels) {
            this.channels = channels;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t\t\t[\"Radio\"] = \n\t\t\t\t\t{\n");
            sb.append("\t\t\t\t\t\t[\"channels\"] = {},\n");
            sb.append("\t\t\t\t\t}, -- end of [\"Radio\"]\n");
            return sb.toString();
        }
    }

    public static class Channel {
        private List<Double> channels = new ArrayList<>();
        private List<Integer> modulations = new ArrayList<>();
        private List<String> channelsNames = new ArrayList<>();

        public List<Double> getChannels() {
            return channels;
        }

        public void setChannels(List<Double> channels) {
            this.channels = channels;
        }

        public List<Integer> getModulations() {
            return modulations;
        }

        public void setModulations(List<Integer> modulations) {
            this.modulations = modulations;
        }

        public List<String> getChannelsNames() {
            return channelsNames;
        }

        public void setChannelsNames(List<String> channelsNames) {
            this.channelsNames = channelsNames;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t\t\t\t[\"channels\"] = {},\n");
            sb.append("\t\t\t\t\t\t[\"modulations\"] = {},\n");
            sb.append("\t\t\t\t\t\t[\"channelsNames\"] = {},\n");
            return sb.toString();
        }
    }

    public static class Payload {
        private List<Pylon> pylons = new ArrayList<>();
        private String fuel;
        private int flare;
        private int chaff;
        private int gun;

        public List<Pylon> getPylons() {
            return pylons;
        }

        public void setPylons(List<Pylon> pylons) {
            this.pylons = pylons;
        }

        public String getFuel() {
            return fuel;
        }

        public void setFuel(String fuel) {
            this.fuel = fuel;
        }

        public int getFlare() {
            return flare;
        }

        public void setFlare(int flare) {
            this.flare = flare;
        }

        public int getChaff() {
            return chaff;
        }

        public void setChaff(int chaff) {
            this.chaff = chaff;
        }

        public int getGun() {
            return gun;
        }

        public void setGun(int gun) {
            this.gun = gun;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t\t\t[\"payload\"] = \n\t\t\t\t\t{\n");
            sb.append("\t\t\t\t\t\t[\"pylons\"] = {},\n");
            sb.append("\t\t\t\t\t\t[\"fuel\"] = \"").append(fuel).append("\",\n");
            sb.append("\t\t\t\t\t\t[\"flare\"] = ").append(flare).append(",\n");
            sb.append("\t\t\t\t\t\t[\"chaff\"] = ").append(chaff).append(",\n");
            sb.append("\t\t\t\t\t\t[\"gun\"] = ").append(gun).append(",\n");
            sb.append("\t\t\t\t\t}, -- end of [\"payload\"]\n");
            return sb.toString();
        }
    }

    public static class Pylon {
        private String CLSID;

        public String getCLSID() {
            return CLSID;
        }

        public void setCLSID(String CLSID) {
            this.CLSID = CLSID;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t\t\t\t[\"CLSID\"] = \"").append(CLSID).append("\",\n");
            return sb.toString();
        }
    }

    public static class Callsign {
        private int[] callsign = new int[3];
        private String name;

        public int[] getCallsign() {
            return callsign;
        }

        public void setCallsign(int[] callsign) {
            this.callsign = callsign;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t\t\t[\"callsign\"] = \n\t\t\t\t\t{\n");
            sb.append("\t\t\t\t\t\t[\"callsign\"] = {},\n");
            sb.append("\t\t\t\t\t\t[\"name\"] = \"").append(name).append("\",\n");
            sb.append("\t\t\t\t\t}, -- end of [\"callsign\"]\n");
            return sb.toString();
        }
    }

    public static class Ship {
        private List<Group> group = new ArrayList<>();

        public List<Group> getGroup() {
            return group;
        }

        public void setGroup(List<Group> group) {
            this.group = group;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t\t[\"group\"] = {},\n");
            return sb.toString();
        }
    }

    public static class Vehicle {
        private List<Group> group = new ArrayList<>();

        public List<Group> getGroup() {
            return group;
        }

        public void setGroup(List<Group> group) {
            this.group = group;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t\t[\"group\"] = {},\n");
            return sb.toString();
        }
    }

    public static class Plane {
        private List<Group> group = new ArrayList<>();

        public List<Group> getGroup() {
            return group;
        }

        public void setGroup(List<Group> group) {
            this.group = group;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\t\t\t\t[\"group\"] = {},\n");
            return sb.toString();
        }
    }
}
