import { About } from "./about.js"

export class CIN extends About{
    constructor(firstname, lastname, birthdate, deliveryDate){
        super(firstname, lastname, birthdate)
        this.deliveryDate = deliveryDate
    }
}