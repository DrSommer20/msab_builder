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
    }

    public static class Options {
        private HiddenOnF10Map hiddenOnF10Map;

        public HiddenOnF10Map getHiddenOnF10Map() {
            return hiddenOnF10Map;
        }

        public void setHiddenOnF10Map(HiddenOnF10Map hiddenOnF10Map) {
            this.hiddenOnF10Map = hiddenOnF10Map;
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
    }

    public static class Season {
        private int temperature;

        public int getTemperature() {
            return temperature;
        }

        public void setTemperature(int temperature) {
            this.temperature = temperature;
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
    }

    public static class Halo {
        private String preset;

        public String getPreset() {
            return preset;
        }

        public void setPreset(String preset) {
            this.preset = preset;
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
    }

    public static class Visibility {
        private int distance;

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
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
    }

    public static class Goals {
        private List<String> goals = new ArrayList<>();

        public List<String> getGoals() {
            return goals;
        }

        public void setGoals(List<String> goals) {
            this.goals = goals;
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
    }

    public static class Helicopter {
        private List<Group> group = new ArrayList<>();

        public List<Group> getGroup() {
            return group;
        }

        public void setGroup(List<Group> group) {
            this.group = group;
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
    }

    public static class Route {
        private List<Point> points = new ArrayList<>();

        public List<Point> getPoints() {
            return points;
        }

        public void setPoints(List<Point> points) {
            this.points = points;
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
    }

    public static class Params {
        private List<String> tasks = new ArrayList<>();

        public List<String> getTasks() {
            return tasks;
        }

        public void setTasks(List<String> tasks) {
            this.tasks = tasks;
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
    }

    public static class Radio {
        private List<Channel> channels = new ArrayList<>();

        public List<Channel> getChannels() {
            return channels;
        }

        public void setChannels(List<Channel> channels) {
            this.channels = channels;
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
    }

    public static class Pylon {
        private String CLSID;

        public String getCLSID() {
            return CLSID;
        }

        public void setCLSID(String CLSID) {
            this.CLSID = CLSID;
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
    }

    public static class Ship {
        private List<Group> group = new ArrayList<>();

        public List<Group> getGroup() {
            return group;
        }

        public void setGroup(List<Group> group) {
            this.group = group;
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
    }

    public static class Plane {
        private List<Group> group = new ArrayList<>();

        public List<Group> getGroup() {
            return group;
        }

        public void setGroup(List<Group> group) {
            this.group = group;
        }
    }
}
