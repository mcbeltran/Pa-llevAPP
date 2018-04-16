import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DatabaseService } from '../shared/database.service';
import { University } from '../shared/University';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user:string = '';
  password:string = '';
  university: number;
  universities: University[];

  result: any;
  message: any;

  constructor( private database: DatabaseService, public router: Router ) { }

  ngOnInit() {
    this.database.listUniversities().subscribe( universities  => {
      this.universities = universities;
      this.university = universities[0].id;
    });
  }

  public doLogin(){

    this.database.login(this.user, this.password).subscribe(data => {

      window.alert("Sesión iniciada correctamente");

      this.message = 'Login Ok';
      this.database.getUser();

    });

  }

  public selectUniversity( university ){
    this.university = university.value;
  }

  logout() {
    this.database.logout().subscribe(data => {

      window.alert("Usted ha salido de la aplicación exitosamente");
      this.message = 'Logout Ok';
    });
  }

}
