export class User {
    private username: string;
    private name: string;
    private lastname: string;
    private mail: string;
    private password: string;
    private university: number;
    private role: string;

    constructor( 
        private new_name: string,
        private new_lastname: string,
        private new_mail: string,
        private new_password: string,
        private new_universiry: number,
        private new_role: string,
        private new_username: string
     ) {
         this.name = new_name;
         this.lastname = new_lastname;
         this.mail = new_mail;
         this.password = new_password;
         this.university = new_universiry;
         this.role = new_role;
         this.username = new_username;
     }
}