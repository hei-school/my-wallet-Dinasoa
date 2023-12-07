import prompt from "readline-sync"

let solde = 0;
let transactions = []
let monthlyBudget = 200000

export const showBalance = () => {
    console.log(`Votre solde actuel: ${solde} Ar`)
}

export const deposit = () => {
    const amount = parseFloat(prompt.question("Veuillez saisir le montant à déposer: Ar"));
    if(!isNaN(amount) && amount > 0){
        solde += amount;
        transactions.push(`Dépot de ${amount} Ar`)
        console.log(`Dépot effectué! `)
    } else {
        console.log("Le montant que vous avez saisi est invalide, veuillez verifier! ")
    }
}

export const withdraw = () => {
    const amount = parseFloat(prompt.question("Veuillez saisir le montant à retirer: Ar"));
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

export const showTransactions = () => {
    console.log("Historique de transactions: ")
    for (const transaction of transactions) {
        console.log(transaction);
    }
}

export const setMonthlyBudget = () => {
    const budget = parseFloat(prompt.question("Veuillez saisir votre nouveau budget mensuel: Ar"))
    if(!isNaN(budget) && budget > 0){
        monthlyBudget = budget;
        console.log(`Votre budget mensuel a été mis à jour: ${monthlyBudget} Ar`);
    }else{
        console.log("Montant invalide. ")
    }
}

export const showMonthlyBudget = () => {
    console.log(`Votre budget mensuel est: ${monthlyBudget}`)
}
