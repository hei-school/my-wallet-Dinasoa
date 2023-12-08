import { auth } from "./auth.js"
import { showBalance, depositCard, recoveredCard, depositCash, withdrawCash } from "./walletfeatures.js"

import prompt from "readline-sync"


const main = () => {
   if(auth() == true) {
        let choice;
        
        do {
                console.log(`Bienvenue dans "Wallet", veuillez choisir une action à effectuer:
                1- Voir le solde dans mon compte
                2- Faire un dépôt
                3- Faire un retrait
                4- Deposer une carte bancaire
                5- Recuperer une carte bancaire
                6- Quitter`);

                choice = +prompt.question("Votre choix: ");

                switch (choice) {
                case 1:
                    showBalance()
                    break;
                case 2:
                    depositCash()
                    break;
                case 3:
                    withdrawCash()
                    break;
                case 4: 
                    depositCard()
                    break;
                case 5: 
                    recoveredCard()
                    break;
                case 6:
                    console.log("Merci d'utiliser le service Wallet. Au revoir!");
                    break;
                default:
                    console.log("Choix invalide. Veuillez choisir une option valide.");

                }
        } while (choice != 7)
    }
}

main()