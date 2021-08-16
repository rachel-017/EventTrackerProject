import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FightService } from './services/fight.service';
import { FighterListComponent } from './components/fighter-list/fighter-list.component';

@NgModule({
  declarations: [
    AppComponent,
    FighterListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    FightService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
