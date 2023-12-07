
import prompt from "readline-sync"

let defaultUsername = "random"
let defaultPassword = "strongpassword"
let username = prompt.question("Veuillez entrer votre nom d'utilisateur: ");
let userPassword = prompt.question("Veuillez confirmer votre identité en tapant le mot de passe: ");

export const auth = () => {
    if(username != defaultUsername || userPassword != defaultPassword){
         console.log("Oups, vous n'avez pas acces à ce wallet, sorry. ")
         return false
    } else {
        return true
    }
}