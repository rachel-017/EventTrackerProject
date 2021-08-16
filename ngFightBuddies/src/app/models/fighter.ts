import { Head } from "./head";
import { Legs } from "./legs";
import { Torso } from "./torso";

export class Fighter {

  id: number;
  name: string;
  strength: number;
  speed: number;
  intelligence: number;
  health: number;
  head: Head;
  torso: Torso;
  legs: Legs;

  constructor(
    id: number = 0,
    name: string = '',
    strength: number = 0,
    speed: number = 0,
    intelligence: number = 0,
    health: number = 0,
    head: Head = new Head,
    torso: Torso = new Torso,
    legs: Legs = new Legs

  ){
    this.id = id;
    this.name = name;
    this.strength = strength;
    this.speed = speed;
    this.intelligence = intelligence;
    this.health = health;
    this.head = head;
    this.torso = torso;
    this.legs = legs;
  }

}
