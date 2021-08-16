# Event Tracker Project

### Full-Stack Spring/REST/JPA Project for Skill Distillery

## Overview

FightBuddies is an app that allows the user to do all basic CRUD functions on a fighter using Angular. All fighters can be viewed, or the user can view one fighter at a time. Future user stories I would like to include are the ability for a user to train their stats (strength, speed, intelligence) by battling their Buddies, and the ability for users to fight other user's fighters, or pre-made fighters from the database. Additionally, for the time being, whenever a fighter is created, they are auto assigned a head/torso/legs id. In the future, the user will be able to choose which head/torso/legs they want their fighter to have by clicking through an option menu that has pictures of each type.

## REST Endpoints


| Method | URI                | Request Body | Response Body |
|--------|--------------------|--------------|---------------|
| GET    | `/api/fighters`      |              | Collection of representations of all _fighter_ resources
| GET    | `/api/fighters/{id}`      |              | Single representation of a _fighter_ resource
| POST    | `/api/fighters`      | Fighter             | New representation of a _fighter_ resource
| POST    | `/api/fighters/{id}`      | Updated Fighter             | Updated representation of a _fighter_ resource
| DELETE    | `/api/fighters/{id}`      |             |               |


## Technologies and Methodologies Used

- Java
- CRUD
- MySQL
- JPA
- REST
- Spring
- JSON
- Angular


## Description

The user must use the EventTrackerProject repository on github.

## Lessons Learned

While working on this project, I learned that you must have a full idea of what you want an application to be, before starting to work on it. Because I didn't plan long enough, I ran into many dead ends while trying to figure out what I should do with my application.

## Stretch Goals

- Future user stories I would like to include are the ability for a user to train their stats (strength, speed, intelligence) by battling their Buddies, and the ability for users to fight other user's fighters, or pre-made fighters from the database.

- I would also like to add more options for the user when they are creating their fighter. Such as the ability to choose whether they want their fighter to be a strength, speed, of intelligence fighter. As well as the ability to choose their preferred head/torso/legs type by clicking through a row of images.
