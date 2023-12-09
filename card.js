export class Card {
    constructor(type, amount,expirationDate, cardHolder, cardNumber){
        this.type = type
        this.cardNumber = cardNumber
        this.expiration_date = expirationDate
        this.cardHolder = cardHolder
        this.amount = amount
    }
}