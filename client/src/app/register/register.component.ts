import { Component, OnInit } from '@angular/core';
import { DatabaseService } from '../shared/database.service';
import { User } from '../shared/User';
import { University } from '../shared/University';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  private username: string = '';
  private name: string = '';
  private lastname: string = '';
  private mail: string = '';
  private password: string = '';
  private verify_password: string = '';
  private role: string = 'ROLE_UNIVENDEDOR';
  private university: number;
  universities: University[] = [];
  private newU: University;

  private newUser: User;

  constructor(private database: DatabaseService) { }

  ngOnInit() {

    this.database.listUniversities().subscribe( universities  => {

      for ( let u of universities ){
        this.universities.push( new University( u[0], u[1], u[2] ) );
      }
      this.university = universities[0].id;

    });

  }

  public doRegister(){

    console.log( this.university );

    

    if( this.password == this.verify_password ){

      this.newUser = new User(this.name, this.lastname, this.mail, this.password, this.university, this.role, this.username );
      this.database.registerUser( this.newUser ).subscribe();

    }
  }

  public selectUniversity( university ){
    this.university = university.value;
  }

  public selectRole( role ) {
    this.role = role.value;
    console.log( this.role );
  }

}
