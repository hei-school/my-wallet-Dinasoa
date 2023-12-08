import prompt from "readline-sync"
import {Card} from "./card.js"
import {CIN} from "./cin.js"

let solde = 0;
let cards = [];
let identityCard = []

export const showBalance = () => {
    console.log(`Votre solde actuel: ${solde} Ar`)
}

export const depositCash = () => {
    const amount = parseFloat(prompt.question("Veuillez saisir le montant à déposer: Ar"));
    if(!isNaN(amount) && amount > 0){
        solde += amount;
        console.log(`Dépot effectué! `)
    } else {
        console.log("Le montant que vous avez saisi est invalide, veuillez verifier! ")
    }
}

export const withdrawCash = () => {
    const amount = parseFloat(prompt.question("Veuillez saisir le montant à retirer: Ar"));
    if(!isNaN(amount) && amount > 0){
        if(amount <= solde){
            solde -= amount
            console.log("Retrait effectué. ")
        } else {
            console.log("Votre solde est insuffisant. ")
        }
    } else {
        console.log("Montant invalide. ");
    }
}

export const depositCard = () => {
    let type = prompt.question("Veuillez saisir le type de carte: ")
    let amount = prompt.question("Veuillez saisir le montant dans votre carte: ")
    let expirationDate = prompt.question("Veuillez saisir la date d'expiration de la carte: ")
    let cardHolder = prompt.question("Veuillez saisir le propriétaire de cette carte: ")
    let cardNumber = prompt.question("Veuillez saisir le numero de carte: ")

    const card = new Card(type, amount, expirationDate, cardHolder, cardNumber)
    solde += parseFloat(card.amount)
    cards.push(card)

    console.log("Votre carte bancaire a bien été deposée. ")
}

export const recoveredCard = () => {
    if (cards.length >= 1) {
        console.log("Cartes disponibles à récupérer:");
        for (let i = 0; i < cards.length; i++) {
            console.log(`${i+1}- Type: ${cards[i].type}, Numéro de carte: ${cards[i].cardNumber}`);
        }

        let question = parseInt(prompt.question("Quelle carte voulez-vous récupérer (entrez le numéro correspondant): "));
        
        if (question >= 1 && question <= cards.length) {
            cardIndex = question - 1
            let recoveredCard = cards.splice(cardIndex, 1)[0];
            solde -= recoveredCard.amount;
            console.log(`La carte récupérée: Type - ${recoveredCard.type}, Numéro de carte - ${recoveredCard.cardNumber}`);
        } else {
            console.log("Veuillez ne saisir que les choix proposés.");
        }
    } else {
        console.log("Vous n'avez aucune carte à récupérer");
    }
};

export const depositCIN = () => {
    console.log("Veuillez entrer les informations sur votre CIN: ")
    let lastname = prompt.question("Nom: ")
    let firstname = prompt.question("Prenom: ")
    let birthdate = prompt.question("Date de naissance: ")
    let deliveryDate = prompt.question("Date de delivrance: ")

    let identity = new CIN(firstname, lastname, birthdate, deliveryDate)

    if(identityCard.length == 0){
        identityCard.push(identity)
        console.log("Depot de CIN effectué. ")
    } else if (identityCard.length == 1){
        console.log("Votre CIN devrait etre unique")
    }
}

export const retrieveCIN = () => {
    if(identityCard.length > 0){
        identityCard.pop()
        console.log("CIN récupérée. ")
    }
    console.log("Aucune carte d'identité identifiée. ")
}

export const showCIN = () => {
    console.log(`Les details de votre CIN: 
        Nom: ${lastname}
        Prenom: ${firstname}
        Date de naissance: ${birthdate}
        Date de delivrance: ${deliveryDate}
    `)
}