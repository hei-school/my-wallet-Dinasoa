import { About } from "./about.js";

export class VisitCard extends About{
    constructor(lastname, firstname, fonction, companyName){
        super(firstname, lastname)
        this.fonction = fonction
        this.companyName = companyName
    }
}