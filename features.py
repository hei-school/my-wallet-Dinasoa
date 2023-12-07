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
            print("Retrait effectué. ")
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

def show_monthly_budget():
    print(f"Votre budget mensuel est: {monthly_budget}. ")