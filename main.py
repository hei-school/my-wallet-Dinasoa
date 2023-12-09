from auth import auth
from features import show_balance, deposit_cash, withdraw_cash, deposit_card, retrieve_card, deposit_cin, retrieve_and_show_cin, deposit_driver_license, retrieve_and_show_driver_license, deposit_visit_card, retrieve_visit_cards

if __name__ == "__main__":
    choice = 0
    if auth() == True:
        while choice != 12:
            print("Bienvenue dans 'Wallet', veuillez choisir une action à effectuer:"
                  "\n1- Voir le solde dans mon compte"
                  "\n2- Faire un dépôt"
                  "\n3- Faire un retrait en cash"
                  "\n4- Deposer une carte de credit"
                  "\n5- Recuperer une carte de credit"
                  "\n6- Deposer une CIN"
                  "\n7- Recuperer et afficher les informations de la CIN"
                  "\n8- Deposer un permis de conduire"
                  "\n9- Recuperer et afficher les informations du permis de conduire"
                  "\n10- Deposer une carte de visite"
                  "\n11- Recuperer une ou plusieurs cartes de visite"
                  "\n12- Quitter")

            choice = int(input("Votre choix: "))

            if choice == 1:
                show_balance()
            elif choice == 2:
                deposit_cash()
            elif choice == 3:
                withdraw_cash()
            elif choice == 4:
                deposit_card()
            elif choice == 5:
                retrieve_card()
            elif choice == 6:
                deposit_cin()
            elif choice == 7:
                retrieve_and_show_cin()
            elif choice == 8:
                deposit_driver_license()
            elif choice == 9:
                retrieve_and_show_driver_license()
            elif choice == 10:
                deposit_visit_card()
            elif choice == 11:
                retrieve_visit_cards()
            elif choice == 12:
                print("Merci d'utiliser le service Wallet. Au revoir!")
            else:
                print("Choix invalide. Veuillez choisir une option valide.")