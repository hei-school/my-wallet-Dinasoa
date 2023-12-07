from auth import auth
from features import show_balance, deposit, withdraw, show_transactions, set_monthly_budget, show_monthly_budget

if __name__ == '__main__':
    if auth() == True:
        choice = 0
        while choice != 7:
            print(f"Bienvenue dans 'Wallet', veuillez choisir une action à effectuer:"
                  "\n1- Voir le solde dans mon compte"
                  "\n2- Faire un dépôt"
                  "\n3- Faire un retrait"
                  "\n4- Afficher l'historique des transactions"
                  "\n5- Mettre à jour le budget mensuel"
                  "\n6- Voir le budget mensuel"
                  "\n7- Quitter")

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
                show_monthly_budget()
            elif choice == 7:
                print(f"Merci d'utiliser le service Wallet. Au revoir! ")
            else:
                print("Choix invalide. Veuillez choisir une option valide. ")