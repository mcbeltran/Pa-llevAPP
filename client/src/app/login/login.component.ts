import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DatabaseService } from '../shared/database.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user = '';
  password = '';
  university = '';
  universities: string[];

  result: any;
  message: any;

  constructor( private database: DatabaseService, public router: Router ) { }

  ngOnInit() {
    this.database.listUniversities().subscribe( universities  => {
      this.universities = universities;
      this.university = universities[0];
    });
  }

  public doLogin(){

    this.database.login(this.user, this.password).subscribe(data => {

      console.log( this.university );

      this.message = 'Login Ok';
      this.database.getUser().catch(error => console.log(error));

    });

  }

  public selectUniversity( university ){
    this.university = university.value;
  }

  logout() {
    this.database.logout().subscribe(data => {
      this.message = 'Logout Ok';
    });
  }

}
