package de.sommer.msab_builder.util;

import java.util.ArrayList;

public class MissionDefault {

    public static Mission createDefaultMission() {
        Mission mission = new Mission();
        
        mission.groundControl = new Mission.GroundControl();
        mission.groundControl.setPasswords(new Mission.Passwords());
        mission.groundControl.setRoles(new Mission.Roles());
        mission.groundControl.setPilotControlVehicles(false);

        mission.requiredModules = new Mission.RequiredModules();
        mission.requiredModules.setMassun92_Humans("Massun92-Humans");
        mission.requiredModules.setUH_60L("UH-60L");

        mission.date = new Mission.Date();
        mission.date.setDay(1);
        mission.date.setYear(2020);
        mission.date.setMonth(6);

        mission.trig = new Mission.Trig();
        // ...initialize trig fields...

        mission.maxDictId = 75;

        mission.result = new Mission.Result();
        mission.result.setOffline(new Mission.Offline());
        mission.result.setTotal(0);
        mission.result.setBlue(new Mission.BlueResult());
        mission.result.setRed(new Mission.Red());

        mission.pictureFileNameN = new Mission.PictureFileName();
        mission.drawings = new Mission.Drawings();
        mission.drawings.setOptions(new Mission.Options());
        mission.drawings.setLayers(new ArrayList<>());

        mission.descriptionNeutralsTask = "DictKey_descriptionNeutralsTask_4";
        mission.pictureFileNameServer = new Mission.PictureFileName();

        mission.weather = new Mission.Weather();
        // ...initialize weather fields...

        mission.theatre = "Syria";
        mission.triggers = new Mission.Triggers();
        mission.triggers.setZones(new ArrayList<>());

        mission.map = new Mission.Map();
        mission.map.setCenterY(-170438.7492169);
        mission.map.setZoom(1107.7676144061);
        mission.map.setCenterX(-298219.92724044);

        mission.coalitions = new Mission.Coalitions();
        mission.coalitions.setBlue(null); // Set blue coalition to null
        mission.coalitions.setNeutrals(new ArrayList<>());
        mission.coalitions.setRed(new ArrayList<>());

        mission.descriptionText = "DictKey_descriptionText_1";
        mission.pictureFileNameR = new Mission.PictureFileName();
        mission.descriptionBlueTask = "DictKey_descriptionBlueTask_3";
        mission.goals = new Mission.Goals();
        mission.descriptionRedTask = "DictKey_descriptionRedTask_2";
        mission.pictureFileNameB = new Mission.PictureFileName();

        mission.coalition = new Mission.Coalition();
        mission.coalition.setNeutrals(new Mission.Neutrals());
        mission.coalition.setBlue(null); // Set blue coalition to null

        return mission;
    }
}
