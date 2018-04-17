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
  private universities: University[] = [];
  private newU: University;
  private newUser: User;
  private imageUrl: string = "/assets/pa-llevapp-logo.png";

  private selectedFile: File = null;

  constructor(private database: DatabaseService) { }

  ngOnInit() {

    this.database.listUniversities().subscribe(universities => {

      for (let u of universities) {
        this.universities.push(new University(u[0], u[1], u[2]));
      }
      this.university = universities[0].id;

    });

  }

  public doRegister() {

    if (this.password != '' && this.password == this.verify_password) {
      this.newUser = new User(this.name, this.lastname, this.mail, this.password, this.university, this.role, this.username);
      if( this.selectedFile != null )
        this.database.uploadFile(this.selectedFile, 'profile_picture_' + this.username + '.' + this.selectedFile.type.split( '/' )[1] ).subscribe();
      this.database.registerUser(this.newUser).subscribe(
        () => {

          window.alert("¡" + this.lastname + " te has registrado exitosamente en la Pa' llevAPP!");
        }
      );
    } else {
      window.alert("¡Los datos no han sido ingresados correctamente!");
    }


  }

  public selectUniversity(university) {
    this.university = university.value;
  }

  public selectRole(role) {
    this.role = role.value;
  }

  public onFileSelected(file: FileList) {
    this.selectedFile = file.item(0);
  }

  public loadImage( file_name: string ) {
    this.database.loadFile( file_name ).subscribe(file => {

      if( this.selectedFile != null ){

        var reader: FileReader = new FileReader();

        reader.onload = (event: any) => {
          this.imageUrl = event.target.result;
        }

        var blobToFile = (image: Blob, fileName: string): File => {
          var b: any = image;
          b.lastModifiedDate = new Date();
          b.name = fileName;

          return <File>image;
        }

        this.selectedFile = blobToFile(file, 'myImage.png');

        reader.readAsDataURL(this.selectedFile);

      } else {
        this.imageUrl = "/assets/img/default.jpg";
      }
    });
  }

}
