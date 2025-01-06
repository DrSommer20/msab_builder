# MSAB Mission Builder

## Overview

MSAB Mission Builder is a work-in-progress project aimed at providing a comprehensive mission planning and building tool for DCS (Digital Combat Simulator). The project is designed to facilitate the creation, management, and customization of missions within the DCS environment, offering a user-friendly interface and advanced features to enhance the mission-building experience.

## Features

- **Mission Planning Panel**: Allows users to plan and configure missions with various settings and parameters.
- **Loadout Panel**: Provides options to customize aircraft loadouts, including selecting pylons and weapons.
- **Flight Groups Management**: Enables the creation and management of flight groups, including checking for duplicate parking slots.
- **Database Integration**: Supports the integration of mission data with a PostgreSQL database for persistent storage and retrieval.
- **Modern UI Theme**: Utilizes the IntelliJ Night Owl theme for a modern and visually appealing user interface.


## Key Components

### `App.java`
The main entry point of the application. It sets up the IntelliJ Night Owl theme and initializes the main frame of the application.

###  `MissionPlanningPanel.java`
A panel that allows users to plan and configure missions. It includes features such as setting the layout, adding buttons, and managing mission parameters.

### `LoadoutPanel.java`
A panel for customizing aircraft loadouts. It dynamically creates labels and comboboxes for each pylon and populates them with available weapons.

### `FlightGroupsTabPanel.java`
Manages flight groups, including adding new flight group panels and checking for duplicate parking slots.

### `todb`
Contains Python scripts for integrating mission data with a PostgreSQL database.

This project is a work in progress, and we appreciate your patience and feedback as we continue to develop and improve the MSAB Mission Builder. Thank you for your support!
