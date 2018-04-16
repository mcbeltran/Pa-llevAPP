import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Http, Response, Headers, RequestOptions, URLSearchParams } from '@angular/http';
import { User } from './User';
import { University } from './University';

@Injectable()
export class DatabaseService {

  url_database = 'http://localhost:8080/';

  user = '';
  pass = '';
  more = '';

  constructor( private http: HttpClient ) { }

   /*----------- INICIO LOGIN/LOGOUT ---------*/

   login(username: string, password: string) {
    this.user = username;
    this.pass = password;
    this.more = "My University";
    
    const headers = new HttpHeaders();
    headers.append('Content-Type', 'application/x-www-form-urlencoded');

    const params = new HttpParams()
      .set('username', username)
      .set('password', password);

    return this.http.post('http://localhost:8080/login', null, {
      headers: headers,
      params: params,
      withCredentials: true
    });
  }

  logout() {
    return this.http.post('http://localhost:8080/logout', '', {
      withCredentials: true
    });
  }

  /*----------- FIN LOGIN/LOGOUT ---------*/

  /*----------- Recuperar Usuario ---------*/
  getUser(): Promise<any> {
    const headers = new HttpHeaders();
    const params = new HttpParams()
      .set('username', this.user)
      .set('password', this.pass);
    return (this.http.get('http://localhost:8080/api/current-user', {
      headers: headers,
      params: params,
      withCredentials: true
    })
      .toPromise()
      .then(this.extractData)
      .catch(this.handleError));
  }

  private extractData(res: Response) {
    var obj = JSON.parse(JSON.stringify(res));
    return (obj.rol);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }

  /*----------- FIN Recuperar Usuario ---------*/

  /*----------- INICIO listar Us Usuario ---------*/

  listUniversities(): Observable<University[]> {

    return (this.http.get<University[]>(this.url_database + 'services/universities', {
      withCredentials: true
    }));

  }

  /*----------- FIN listar Us Usuario ---------*/

  /*----------- INICIO añadir Usuario ---------*/

  public registerUser( newUser: User ) {
    return this.http.post( this.url_database + 'services/register', newUser, { withCredentials: true } );
  }

  /*----------- FIN añadir Usuario ---------*/

}
