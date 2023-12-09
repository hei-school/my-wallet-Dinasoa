import { About } from "./about.js";

export class DriverLicences extends About{
    constructor(firstname, lastname, birthdate, type){
        super(firstname, lastname, birthdate)
        this.type = type
    }
}