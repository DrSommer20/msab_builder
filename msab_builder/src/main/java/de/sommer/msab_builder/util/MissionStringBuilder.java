package de.sommer.msab_builder.util;

import de.sommer.msab_builder.db.SQLDB;

public class MissionStringBuilder {

    private Mission mission;

    private String groundControl;
    private String requiredModules;
    private String date;
    private String trig;
    private String maxDictId;
    private String result;
    private String pictureFileNameN;
    private String drawings;
    private String descriptionNeutralsTask;
    private String pictureFileNameServer;
    private String weather;
    private String theatre;
    private String triggers;
    private String map;
    private String coalitions;
    private String descriptionText;
    private String pictureFileNameR;
    private String descriptionBlueTask;
    private String goals;
    private String descriptionRedTask;
    private String pictureFileNameB;
    private String coalition;
    private String sortie;
    private String version;
    private String trigrules;
    private String currentKey;
    private String failures;
    private String forcedOptions;
    private String start_time;



    public MissionStringBuilder(Mission mission) {
        this.mission = mission;
        setParameters();
    }

    private void setParameters(){
        groundControl = SQLDB.getMissionJSON("groundControl");
        requiredModules = SQLDB.getMissionJSON("requiredModules");
        date = SQLDB.getMissionJSON("date");
        trig = SQLDB.getMissionJSON("trig");
        maxDictId = SQLDB.getMissionJSON("maxDictId");
        result = SQLDB.getMissionJSON("result");
        pictureFileNameN = SQLDB.getMissionJSON("pictureFileNameN");
        drawings = SQLDB.getMissionJSON("drawings");
        descriptionNeutralsTask = SQLDB.getMissionJSON("descriptionNeutralsTask");
        pictureFileNameServer = SQLDB.getMissionJSON("pictureFileNameServer");
        weather = SQLDB.getMissionJSON("weather");
        theatre = SQLDB.getMissionJSON("theatre");
        triggers = SQLDB.getMissionJSON("triggers");
        map = SQLDB.getMissionJSON("map");
        coalitions = SQLDB.getMissionJSON("coalitions");
        descriptionText = SQLDB.getMissionJSON("descriptionText");
        pictureFileNameR = SQLDB.getMissionJSON("pictureFileNameR");
        descriptionBlueTask = SQLDB.getMissionJSON("descriptionBlueTask");
        goals = SQLDB.getMissionJSON("goals");
        descriptionRedTask = SQLDB.getMissionJSON("descriptionRedTask");
        pictureFileNameB = SQLDB.getMissionJSON("pictureFileNameB");
        coalition = SQLDB.getMissionJSON("coalition");
        sortie = SQLDB.getMissionJSON("sortie");
        version = SQLDB.getMissionJSON("version");
        trigrules = SQLDB.getMissionJSON("trigrules");
        currentKey = SQLDB.getMissionJSON("currentKey");
        failures = SQLDB.getMissionJSON("failures");
        forcedOptions = SQLDB.getMissionJSON("forcedOptions");
        start_time = SQLDB.getMissionJSON("start_time");
    }

    public String buildMissionString() {
        StringBuilder missionString = new StringBuilder();
        missionString.append("mission = \n{\n");
        missionString.append(groundControl).append(",\n");
        missionString.append(requiredModules).append(",\n");
        missionString.append(date).append(",\n");
        missionString.append(trig).append(",\n");
        missionString.append(maxDictId).append(",\n");
        missionString.append(result).append(",\n");
        missionString.append(pictureFileNameN).append(",\n");
        missionString.append(drawings).append(",\n");
        missionString.append(descriptionNeutralsTask).append(",\n");
        missionString.append(pictureFileNameServer).append(",\n");
        missionString.append(weather).append(",\n");
        missionString.append(theatre).append(",\n");
        missionString.append(triggers).append(",\n");
        missionString.append(map).append(",\n");
        missionString.append(coalitions).append(",\n");
        missionString.append(descriptionText).append(",\n");
        missionString.append(pictureFileNameR).append(",\n");
        missionString.append(descriptionBlueTask).append(",\n");
        missionString.append(goals).append(",\n");
        missionString.append(descriptionRedTask).append(",\n");
        missionString.append(pictureFileNameB).append(",\n");
        missionString.append(coalition).append(",\n");
        missionString.append(sortie).append(",\n");
        missionString.append(version).append(",\n");
        missionString.append(trigrules).append(",\n");
        missionString.append(currentKey).append(",\n");
        missionString.append(failures).append(",\n");
        missionString.append(forcedOptions).append(",\n");
        missionString.append(start_time).append(",\n");
        missionString.append("}");
        return missionString.toString();
    }

    public static void main(String[] args) {
        Mission mission = new Mission();
        MissionStringBuilder missionStringBuilder = new MissionStringBuilder(mission);
        System.out.println(missionStringBuilder.buildMissionString());
    }
    
}
