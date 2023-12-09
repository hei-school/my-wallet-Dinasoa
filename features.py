from CIN import CIN
from card import Card
from driver_license import DriverLicense
from visit_card import VisitCard

solde = 0
cards = []
identity_cards = []
driver_licenses = []
driver_license_types = []
visit_cards = []


def show_balance():
    print(f"Votre solde actuel: {solde} Ar. ")

def deposit_cash():
    global solde
    amount_str = input("Veuillez saisir le montant à déposer: Ar ")
    try:
        amount = float(amount_str)
        if amount > 0:
            solde += amount
            print("Dépôt effectué! ")
        else:
            print("Le montant doit être supérieur à zéro. ")
    except ValueError:
        print("Montant invalide, veuillez vérifier! ")

def withdraw_cash():
    global solde
    amount_str = input("Veuillez saisir le montant à retirer: Ar ")
    try:
        amount = float(amount_str)
        if amount <= solde:
            solde -= amount
            print("Retrait effectué. ")
        else:
            print("Votre solde est insuffisant. ")
    except ValueError:
        print("Montant invalide, veuillez vérifier! ")

def deposit_card():
    global cards, solde
    card_type = input("Veuillez saisir le type de carte: ")
    amount = input("Veuillez saisir le montant dans votre carte: ")
    expiration_date = input("Veuillez saisir la date d'expiration de la carte: ")
    card_holder = input("Veuillez saisir le propriétaire de cette carte: ")
    card_number = input("Veuillez saisir le numéro de carte: ")

    card = Card(card_type, amount, expiration_date, card_holder, card_number)
    solde += float(card.amount)
    cards.append(card)
    print("Votre carte bancaire a bien été déposée. ")

def retrieve_card():
    global cards, solde
    if len(cards) >= 1:
        print("Cartes disponibles à récupérer:")
        for i, card in enumerate(cards):
            print(f"{i + 1} - Type: {card.card_type}, Numéro de carte: {card.card_number}")

        card_index = int(input("Quelle carte voulez-vous récupérer (entrez le numéro correspondant): ")) - 1

        if 0 <= card_index < len(cards):
            retrieved_card = cards.pop(card_index)
            solde -= float(retrieved_card.amount)
            print(f"La carte récupérée: Type - {retrieved_card.card_type}, Numéro de carte - {retrieved_card.card_number}")
        else:
            print("Veuillez saisir un choix valide.")
    else:
        print("Vous n'avez aucune carte à récupérer")

def deposit_cin():
    global identity_cards
    print("Veuillez entrer les informations sur votre CIN: ")
    lastname = input("Nom: ")
    firstname = input("Prénom: ")
    birthdate = input("Date de naissance: ")
    delivery_date = input("Date de délivrance: ")

    new_identity_card = CIN(firstname, lastname, birthdate, delivery_date)

    if not any(existing_card.is_equal(new_identity_card) for existing_card in identity_cards):
        identity_cards.append(new_identity_card)
        print("Dépôt de CIN effectué. ")
    else:
        print("Vous avez déjà un CIN dans votre porte-feuille.")

def retrieve_and_show_cin():
    global identity_cards
    if identity_cards:
        print("CIN récupérée. ")
        print(f"Les détails de votre CIN: \nNom: {identity_cards[0].lastname}\nPrénom: {identity_cards[0].firstname}\nDate de naissance: {identity_cards[0].birthdate}\nDate de délivrance: {identity_cards[0].delivery_date}")
        identity_cards.pop()
    else:
        print("Aucune carte d'identité identifiée. ")

def deposit_driver_license():
    global driver_licenses, driver_license_types
    print("Veuillez entrer les informations sur votre permis de conduire: ")
    lastname = input("Nom: ")
    firstname = input("Prénom: ")
    birthdate = input("Date de naissance: ")
    type_str = input("Type de permis (séparez par une virgule si vous avez plus d'un type | a, b, c): ")

    if "," in type_str:
        types = type_str.split(",")
        for license_type in types:
            driver_license_types.append(license_type.strip())

    if not driver_licenses:
        driver_licenses.append(DriverLicense(firstname, lastname, birthdate, driver_license_types))
        print("Dépôt effectué. ")
    else:
        print("Votre permis de conduire devrait être unique. ")

def retrieve_and_show_driver_license():
    global driver_licenses, driver_license_types
    if driver_licenses:
        print("Permis de conduire récupéré. ")
        print(f"Les détails de votre permis: \nNom: {driver_licenses[0].lastname}\nPrénom: {driver_licenses[0].firstname}\nDate de naissance: {driver_licenses[0].birthdate}\nType: {', '.join(driver_license_types)}")
        driver_licenses.pop()
    else:
        print("Aucun permis de conduire identifié. ")

def deposit_visit_card():
    global visit_cards
    print("Veuillez renseigner les informations de votre carte de visite: ")
    lastname = input("Nom: ")
    firstname = input("Prénom: ")
    function = input("Poste: ")
    company_name = input("Entreprise: ")

    if len(visit_cards) <= 3:
        visit_cards.append(VisitCard(lastname, firstname, function, company_name))
        print("Carte de visite enregistrée. ")
    else:
        print("Plus d'espace. ")

def retrieve_visit_cards():
    global visit_cards
    cards_to_remove = []

    if not visit_cards:
        print("Vous n'avez aucune carte de visite dans votre wallet.")
        return

    if len(visit_cards) > 1:
        print("Sélectionnez les cartes que vous voulez récupérer (ex: 1,2):")
        for i, visit_card in enumerate(visit_cards):
            print(f"{i + 1} - {visit_card.company_name}")

        choice = input("Carte à récupérer: ")

        if "," in choice:
            cards_to_remove = [int(index) - 1 for index in choice.split(",")]
        elif "," not in choice:
            cards_to_remove = [int(choice) - 1]
    else:
        cards_to_remove = [0]

    for index in reversed(cards_to_remove):
        removed_card = visit_cards.pop(index)
        print(f"Carte récupérée: {removed_card.company_name}")
