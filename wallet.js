const prompt = require("prompt-sync")()

let defaultUsername = "Dinasoa"
let defaultPassword = "averystrongpassword" 
let solde = 0;
let transactions = []
let monthlyBudget = 200000

const showBalance = () => {
    console.log(`Votre solde actuel: ${solde} Ar`)
}

const deposit = () => {
    const amount = parseFloat(prompt("Veuillez saisir le montant à déposer: Ar"));
    if(!isNaN(amount) && amount > 0){
        solde += amount;
        transactions.push(`Dépot de ${amount} Ar`)
        console.log(`Dépot effectué! `)
    } else {
        console.log("Le montant que vous avez saisi est invalide, veuillez verifier! ")
    }
}

const withdraw = () => {
    const amount = parseFloat(prompt("Veuillez saisir le montant à retirer: Ar"));
    if(!isNaN(amount) && amount > 0){
        if(amount <= solde){
            solde -= amount
            transactions.push(`Retrait de ${amount} Ar. `)
            console.log("Retrait effectué. ")
        } else {
            console.log("Votre solde est insuffisant. ")
        }
    } else {
        console.log("Montant invalide. ");
    }
}

const showTransactions = () => {
    console.log("Historique de transactions: ")
    for (const transaction of transactions) {
        console.log(transaction);
    }
}

const setMonthlyBudget = () => {
    const budget = parseFloat(prompt("Veuillez saisir votre nouveau budget mensuel: Ar"))
    if(!isNaN(budget) && budget > 0){
        monthlyBudget = budget;
        console.log(`Votre budget mensuel a été mis à jour: ${monthlyBudget} Ar`);
    }else{
        console.log("Montant invalide. ")
    }
}

const main = () => {
    let username = prompt("Veuillez entrer votre nom d'utilisateur: ");
    let userPassword = prompt("Veuillez confirmer votre identité en tapant le mot de passe: ");

    if(username != defaultUsername || userPassword != defaultPassword){
        console.log("Oups, vous n'avez pas acces à ce wallet, sorry. ")
    } else {
        let choice;

        do {
                console.log(`Bienvenue dans "Wallet" ${defaultUsername}, veuillez choisir une action à effectuer:
                1- Voir le solde dans mon compte
                2- Faire un dépôt
                3- Faire un retrait
                4- Afficher l'historique des transactions
                5- Mettre à jour le budget mensuel
                6- Quitter`);

                choice = +prompt("Votre choix: ");

                switch (choice) {
                case 1:
                    showBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    showTransactions();
                    break;
                case 5:
                    setMonthlyBudget();
                    break;
                case 6:
                    console.log("Merci d'utiliser le service Wallet. Au revoir!");
                    break;
                default:
                    console.log("Choix invalide. Veuillez choisir une option valide.");

                }
        } while (choice != 6)
    }

}

main()