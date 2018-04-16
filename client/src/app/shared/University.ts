export class University {

    public id: number;
    public name: string;
    public domain: string;

    constructor( private newId: number,
                 private newName: string,
                 private newDomain: string ){
        this.id = newId;
        this.name = newName;
        this.domain = newDomain;
    }

}