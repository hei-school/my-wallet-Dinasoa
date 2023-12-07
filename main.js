import { auth } from "./auth.js"
import { showBalance, deposit, withdraw, showTransactions, setMonthlyBudget, showMonthlyBudget } from "./walletfeatures.js"

import prompt from "readline-sync"


const main = () => {
   if(auth() == true) {
        let choice;
        
        do {
                console.log(`Bienvenue dans "Wallet", veuillez choisir une action à effectuer:
                1- Voir le solde dans mon compte
                2- Faire un dépôt
                3- Faire un retrait
                4- Afficher l'historique des transactions
                5- Mettre à jour le budget mensuel
                6- Afficher le budget mensuel
                7- Quitter`);

                choice = +prompt.question("Votre choix: ");

                switch (choice) {
                case 1:
                    showBalance()
                    break;
                case 2:
                    deposit()
                    break;
                case 3:
                    withdraw()
                    break;
                case 4:
                    showTransactions();
                    break;
                case 5:
                    setMonthlyBudget();
                    break;
                case 6:
                    showMonthlyBudget();
                case 7:
                    console.log("Merci d'utiliser le service Wallet. Au revoir!");
                    break;
                default:
                    console.log("Choix invalide. Veuillez choisir une option valide.");

                }
        } while (choice != 7)
    }
}

main()