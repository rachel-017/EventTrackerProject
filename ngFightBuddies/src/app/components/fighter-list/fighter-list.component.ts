import { Component, OnInit } from '@angular/core';
import { Fighter } from 'src/app/models/fighter';
import { FightService } from 'src/app/services/fight.service';

@Component({
  selector: 'app-fighter-list',
  templateUrl: './fighter-list.component.html',
  styleUrls: ['./fighter-list.component.css']
})
export class FighterListComponent implements OnInit {

  fighters: Fighter[] = [];

  selected: Fighter | null = null;
  newFighter = new Fighter();
  editFighter: Fighter | null = null;

  title = 'Welcome to Fight Buddies';

  constructor(
    private fightService: FightService
  ) { }

  ngOnInit(): void {
    this.loadFighters();
  }

  loadFighters(){
  this.fightService.index().subscribe(
    fighters => {
      this.fighters = fighters;
    },
    noFighters => {
      console.error('FighterListComponent.loadFighters(): error retrieving fighter list');
      console.error(noFighters);
    }
  );
  }

  getFighterCount() : Number {
    return this.fighters.length;
  }

  displayFighter(fighter: any): void {
    this.selected = fighter;
  }

  displayTable(): void {
    this.selected = null;
  }


  addFighter() : void {
    this.fightService.create(this.newFighter).subscribe(
      data => {
        this.loadFighters();
      },
      error => {
        console.log(error);
        console.log("Error creating fighter through service.")
      }
    );
    this.newFighter = new Fighter();
  }


  setEditFighter() : void {
    this.editFighter = Object.assign({}, this.selected);
  }

  updateFighter(fighter: Fighter) {
    this.fightService.update(fighter).subscribe(
      data => {
        this.loadFighters();
      },
      error => {
        console.log(error);
        console.log("error updating fighter through service")
      }
    );
    this.editFighter = null;
    this.selected = null;
    // this.todos = this.todoService.index();
  }

  deleteFighter(id: number) {
    this.fightService.destroy(id).subscribe(
      data => {
        this.loadFighters();
      },
      error => {
        console.log(error);
        console.log("error deleting fighter through service")
      }
    );
    // this.todos = this.todoService.index();
  }

}
