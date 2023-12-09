import prompt from "readline-sync"
import {Card} from "./card.js"
import {CIN} from "./cin.js"
import { DriverLicences } from "./driverLicense.js";
import { VisitCard } from "./visitCard.js";

let solde = 0;
let cards = [];
let identityCard = []
let driverlicense = []
let driverLicenseTypes = []
let visitCards = []

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

export const retrieveAndShowCIN = () => {
    if(identityCard.length > 0){
        console.log("CIN récupérée. ")
        console.log(`Les details de votre CIN: 
        Nom: ${identityCard[0].lastname}
        Prenom: ${identityCard[0].firstname}
        Date de naissance: ${identityCard[0].birthdate}
        Date de delivrance: ${identityCard[0].deliveryDate}
    `)
        identityCard.pop()
    }
    console.log("Aucune carte d'identité identifiée. ")
}

export const depositDriverLicense = () => {
    console.log("Veuillez entrez les informations sur votre permis de conduire: ")
    let lastname = prompt.question("Nom: ")
    let firstname = prompt.question("Prenom: ")
    let birthdate = prompt.question("Date de naissance: ")
    let type = prompt.question("Type de permis, (separez par un virgule si vous avez plus qu'un type | a, b, c): ")
    
    if(contains(type, ",")){
        let types = type.split(",")
        for (let i = 0; i < types.length; i++) {
            driverLicenseTypes.push(types[i]);
            
        }
    }

    if(driverlicense.length == 0){
        driverlicense.push(new DriverLicences(firstname, lastname, birthdate, driverLicenseTypes))

        console.log("Depot effectué. ")
    } else{
        console.log("Votre permis de conduire devrait etre unique. ")
    }
}

export const retrieveAndShowDriverLicense = () => {
    if(driverlicense.length > 0){
        console.log("Permis de conduire récupéré. ")
        console.log(`Les details de votre permis: 
        Nom: ${driverlicense[0].lastname}
        Prenom: ${driverlicense[0].firstname}
        Date de naissance: ${driverlicense[0].birthdate}
        Type: 
        `)

        if(driverLicenseTypes.length > 0){
            for (let i = 0; i < driverLicenseTypes.length; i++) {
                console.log(`${i + 1} - ${driverLicenseTypes[i]}`);   
            }
        }
        driverlicense.pop()

    }else{
        console.log("Aucun permis de conduire identifié. ")
    }
}

export const depositVistCard = () => {
    console.log("Veuillez renseigner les informations de votre carte de visite: ")
    let lastname = prompt.question("Nom: ")
    let firstname = prompt.question("Prenom: ")
    let fonction = prompt.question("Poste: ")
    let companyName = prompt.question("Entreprise: ")

    if(visitCards.length <= 3){
        visitCards.push(new VisitCard(lastname, firstname, fonction, companyName))
        console.log("Carte de visite enregistré. ")    
    } else {
        console.log("Plus d'espace. ")
    }
}

export const retrieveVisitCards = () => {
    let cardsToRemove = [];
  
    if (!visitCards.length) {
      console.log("Vous n'avez aucune carte de visite dans votre wallet.");
      return;
    }
  
    if (visitCards.length > 1) {
      console.log("Sélectionnez les cartes que vous voulez récupérer (ex: 1,2):");
      for (let i = 0; i < visitCards.length; i++) {
        console.log(`${i + 1} - ${visitCards[i].companyName}`);
      }
  
      const choice = prompt.question("Carte à récupérer: "); 
  
      if (contains(choice, ",")) {
        cardsToRemove = choice.split(",").map(index => parseInt(index) - 1);
      } else if (!contains(choice, ",")) {
        cardsToRemove = [parseInt(choice) - 1];
      }
    } else {
      cardsToRemove = [0];
    }
  
    for (const index of cardsToRemove.reverse()) {
      const removedCard = visitCards.splice(index, 1)[0]; // Remove the card and store it
      console.log(`Carte récupérée: ${removedCard.companyName}`);
    }
  };

const contains = (string, word) => {
    for (let i = 0; i < string.length; i++) {
        if(string[i] == word){
            return true
        }
    }
    return false
}