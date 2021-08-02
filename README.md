# Event Tracker Project

### Full-Stack Spring/REST/JPA Project for Skill Distillery

## Overview

FightBuddies is an app that allows the user to do all basic CRUD functions on a fighter. All fighters can be viewed, or the user can view one fighter at a time. Future user stories I would like to include are the ability for a user to train their stats (strength, speed, intelligence) by battling their Buddies, and the ability for users to fight other user's fighters, or pre-made fighters from the database.

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
- Spring MVC

## Description

The user must use the endpoints to access all functions.

## Lessons Learned

While working on this project, I learned how important it is to have your project's plan completed before beginning on any other parts of the project.

## Stretch Goals

- Future user stories I would like to include are the ability for a user to train their stats (strength, speed, intelligence) by battling their Buddies, and the ability for users to fight other user's fighters, or pre-made fighters from the database.
