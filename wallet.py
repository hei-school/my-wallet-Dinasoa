default_username = "Dinasoa"
default_password = "averystrongpassword"
solde = 0
transactions = []
monthly_budget = 200000


def show_balance():
    print(f"Votre solde actuel: {solde} Ar. ")


def deposit():
    global solde
    amount = float(input("Veuillez saisir le montant à déposer: Ar "))
    try:
        if amount > 0:
            solde += amount
            transactions.append(f"Depot de {amount} Ar. ")
    except ValueError:
        print(f"Montan invalide, veuillez verifier! ")


def withdraw():
    global solde
    amount = float(input("Veuillez saisir le montant à retirer: Ar "))
    try:
        if amount <= solde:
            solde -= amount
            transactions.append(f"Retrait de {amount} Ar. ")
        else:
            print("Votre solde est insuffisant. ")
    except ValueError:
        print(f"Montan invalide, veuillez verifier! ")


def show_transactions():
    print(f"Historique des transactions: ")
    for transaction in transactions:
        print(transaction)


def set_monthly_budget():
    global monthly_budget
    budget = float(input("Veuillez saisir votre nouveau budget mensuel: Ar "))

    if budget > 0:
        monthly_budget = budget
        print(f"Votre budget mensuel a été mis à jour: {monthly_budget} Ar")
    else:
        print("Montant invalide. ")

if __name__ == '__main__':
    username = input(f"Veuillez entrer votre nom: ")
    user_password = input(f"Veuillez confirmer votre identité en tapant le mot de passe: ")

    if username != default_username or user_password != default_password:
        print(f"Oups, vous n'avez pas acces à ce wallet, sorry. ")
    else:
        choice = 0

        while choice != 6:
            print(f"Bienvenue dans 'Wallet' {default_username}, veuillez choisir une action à effectuer:"
                  "\n1- Voir le solde dans mon compte"
                  "\n2- Faire un dépôt"
                  "\n3- Faire un retrait"
                  "\n4- Afficher l'historique des transactions"
                  "\n5- Mettre à jour le budget mensuel"
                  "\n6- Quitter")

            choice = int(input("Votre choix: "))

            if choice == 1:
                show_balance()
            elif choice == 2:
                deposit()
            elif choice == 3:
                withdraw()
            elif choice == 4:
                show_transactions()
            elif choice == 5:
                set_monthly_budget()
            elif choice == 6:
                print(f"Merci d'utiliser le service Wallet. Au revoir! ")
            else:
                print("Choix invalide. Veuillez choisir une option valide. ")