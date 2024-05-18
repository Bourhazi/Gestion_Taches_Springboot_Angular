import { Component, OnInit } from '@angular/core';
import { TacheService } from './tache.service';
import { Tache } from './tache';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  public tachees: Tache[] =[];
  public edittache!: Tache | null;
  public deletetache: Tache | null | undefined;


  constructor(private tacheService: TacheService) {}

  ngOnInit(){
    this.gettaches();
    console.log("test"); 
  }

  public gettaches():void{

    this.tacheService.getTaches().subscribe(
      (Response: Tache[]) => {
        this.tachees = Response;
        console.log(this.tachees);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }


  public onAddTache(addForm: NgForm): void{
    document.getElementById('add-employee-form')?.click();
    this.tacheService.addTache(addForm.value).subscribe(
      (Response: Tache) => {
        console.log(Response);
        this.gettaches();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onUpdateTache(tache: Tache): void{
    document.getElementById('edit-employee-form')?.click();
    this.tacheService.updateTache(tache).subscribe(
      (Response: Tache) => {
        console.log(Response);
        this.gettaches();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteTache(tacheId: number): void{
    //document.getElementById('edit-employee-form')?.click();
    this.tacheService.deleteTache(tacheId).subscribe(
      (Response: void) => {
        console.log(Response);
        this.gettaches();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchTache(key: string): void {
    console.log(key);
    const results: Tache[] = [];
    for (let tache of this.tachees) {
      console.log(this.tachees);
      if ((tache.nom.toUpperCase().indexOf(key.toUpperCase())) !== -1) {
        results.push(tache);
        //console.log(results);
      }
    }
    this.tachees = results;
    console.log(this.tachees);
     if (results.length === 0 || !key) {
       this.gettaches();
     }
  }



  public onOpenModal(tache: Tache | null  ,mode: string): void{
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display='none';
    button.setAttribute('data-toggle','modal');
    if(mode =='add'){
      button.setAttribute('data-target','#addTacheModal');
    }
    if(mode =='edit'){
      this.edittache = tache;
      button.setAttribute('data-target','#updateTacheModal');
    }
    if(mode =='delete'){
      this.deletetache = tache;
      button.setAttribute('data-target','#deleteTacheModal');
    }
    container?.appendChild(button);
    button.click();
  }


}
