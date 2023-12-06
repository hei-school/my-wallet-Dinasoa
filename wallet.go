package main

import (
	"fmt"
	"strconv"
)

var solde float64
var transactions []string
var cards []Card
var identityCards []CIN
var driverLicenses []DriverLicense
var visitCards []VisitCard

type Card struct {
	CardType       string
	Amount         float64
	ExpirationDate string
	CardHolder     string
	CardNumber     string
}

type CIN struct {
	Firstname    string
	Lastname     string
	Birthdate    string
	DeliveryDate string
}

type DriverLicense struct {
	Firstname     string
	Lastname      string
	Birthdate     string
	LicenseTypes  []string
}

type VisitCard struct {
	Lastname    string
	Firstname   string
	Function    string
	CompanyName string
}

func showBalance() {
	fmt.Printf("Votre solde actuel: %.2f Ar\n", solde)
}

func deposit() {
	var amountStr string
	fmt.Print("Veuillez saisir le montant à déposer: Ar ")
	fmt.Scan(&amountStr)

	amount, err := strconv.ParseFloat(amountStr, 64)
	if err != nil {
		fmt.Println("Montant invalide, veuillez vérifier!")
		return
	}

	if amount > 0 {
		solde += amount
		transactions = append(transactions, fmt.Sprintf("Depot de %.2f Ar.", amount))
		fmt.Println("Dépôt effectué!")
	} else {
		fmt.Println("Le montant doit être supérieur à zéro.")
	}
}

func withdraw() {
	var amountStr string
	fmt.Print("Veuillez saisir le montant à retirer: Ar ")
	fmt.Scan(&amountStr)

	amount, err := strconv.ParseFloat(amountStr, 64)
	if err != nil {
		fmt.Println("Montant invalide, veuillez vérifier!")
		return
	}

	if amount <= solde {
		solde -= amount
		transactions = append(transactions, fmt.Sprintf("Retrait de %.2f Ar.", amount))
		fmt.Println("Retrait effectué.")
	} else {
		fmt.Println("Votre solde est insuffisant.")
	}
}

func depositCard() {
	var cardType, amountStr, expirationDate, cardHolder, cardNumber string
	fmt.Print("Veuillez saisir le type de carte: ")
	fmt.Scan(&cardType)

	fmt.Print("Veuillez saisir le montant dans votre carte: Ar ")
	fmt.Scan(&amountStr)

	amount, err := strconv.ParseFloat(amountStr, 64)
	if err != nil {
		fmt.Println("Montant invalide, veuillez vérifier!")
		return
	}

	fmt.Print("Veuillez saisir la date d'expiration de la carte: ")
	fmt.Scan(&expirationDate)

	fmt.Print("Veuillez saisir le propriétaire de cette carte: ")
	fmt.Scan(&cardHolder)

	fmt.Print("Veuillez saisir le numéro de carte: ")
	fmt.Scan(&cardNumber)

	card := Card{
		CardType:       cardType,
		Amount:         amount,
		ExpirationDate: expirationDate,
		CardHolder:     cardHolder,
		CardNumber:     cardNumber,
	}

	solde += card.Amount
	cards = append(cards, card)
	fmt.Println("Votre carte bancaire a bien été déposée.")
}

func retrieveCard() {
	if len(cards) >= 1 {
		fmt.Println("Cartes disponibles à récupérer:")
		for i, card := range cards {
			fmt.Printf("%d- Type: %s, Numéro de carte: %s\n", i+1, card.CardType, card.CardNumber)
		}

		var questionStr string
		fmt.Print("Quelle carte voulez-vous récupérer (entrez le numéro correspondant): ")
		fmt.Scan(&questionStr)

		question, err := strconv.Atoi(questionStr)
		if err != nil || question < 1 || question > len(cards) {
			fmt.Println("Veuillez ne saisir que les choix proposés.")
			return
		}

		cardIndex := question - 1
		retrievedCard := cards[cardIndex]
		solde -= retrievedCard.Amount
		cards = append(cards[:cardIndex], cards[cardIndex+1:]...)
		fmt.Printf("La carte récupérée: Type - %s, Numéro de carte - %s\n", retrievedCard.CardType, retrievedCard.CardNumber)
	} else {
		fmt.Println("Vous n'avez aucune carte à récupérer")
	}
}

func depositCIN() {
	var firstname, lastname, birthdate, deliveryDate string
	fmt.Println("Veuillez entrer les informations sur votre CIN: ")
	fmt.Print("Nom: ")
	fmt.Scan(&lastname)
	fmt.Print("Prénom: ")
	fmt.Scan(&firstname)
	fmt.Print("Date de naissance: ")
	fmt.Scan(&birthdate)
	fmt.Print("Date de délivrance: ")
	fmt.Scan(&deliveryDate)

	// Utilisez append sur la variable globale identityCards
	identityCard := CIN{
		Firstname:    firstname,
		Lastname:     lastname,
		Birthdate:    birthdate,
		DeliveryDate: deliveryDate,
	}

	identityCards = append(identityCards, identityCard)
	fmt.Println("Dépôt de CIN effectué. ")
}


func retrieveAndShowCIN() {
	if len(identityCards) > 0 {
		fmt.Println("CIN récupérée. ")
		fmt.Printf("Les détails de votre CIN: \nNom: %s\nPrénom: %s\nDate de naissance: %s\nDate de délivrance: %s\n",
			identityCards[0].Lastname, identityCards[0].Firstname, identityCards[0].Birthdate, identityCards[0].DeliveryDate)
		identityCards = nil
	} else {
		fmt.Println("Aucune carte d'identité identifiée. ")
	}
}

func depositDriverLicense() {
	var firstname, lastname, birthdate, licenseTypeStr string
	fmt.Println("Veuillez entrer les informations sur votre permis de conduire: ")
	fmt.Print("Nom: ")
	fmt.Scan(&lastname)
	fmt.Print("Prénom: ")
	fmt.Scan(&firstname)
	fmt.Print("Date de naissance: ")
	fmt.Scan(&birthdate)
	fmt.Print("Type de permis (séparez par une virgule si vous avez plus d'un type | a, b, c): ")
	fmt.Scan(&licenseTypeStr)

	licenseTypes := make([]string, 0)
	if len(licenseTypeStr) > 0 {
		licenseTypes = append(licenseTypes, licenseTypeStr)
	}

	driverLicense := DriverLicense{
		Firstname:    firstname,
		Lastname:     lastname,
		Birthdate:    birthdate,
		LicenseTypes: licenseTypes,
	}

	driverLicenses = append(driverLicenses, driverLicense)
	fmt.Println("Dépôt effectué. ")
}

func retrieveAndShowDriverLicense() {
	if len(driverLicenses) > 0 {
		fmt.Println("Permis de conduire récupéré. ")
		fmt.Printf("Les détails de votre permis: \nNom: %s\nPrénom: %s\nDate de naissance: %s\nType: %v\n",
			driverLicenses[0].Lastname, driverLicenses[0].Firstname, driverLicenses[0].Birthdate, driverLicenses[0].LicenseTypes)
		driverLicenses = nil
	} else {
		fmt.Println("Aucun permis de conduire identifié. ")
	}
}

func depositVisitCard() {
	var lastname, firstname, function, companyName string
	fmt.Println("Veuillez renseigner les informations de votre carte de visite: ")
	fmt.Print("Nom: ")
	fmt.Scan(&lastname)
	fmt.Print("Prénom: ")
	fmt.Scan(&firstname)
	fmt.Print("Poste: ")
	fmt.Scan(&function)
	fmt.Print("Entreprise: ")
	fmt.Scan(&companyName)

	if len(visitCards) <= 3 {
		visitCard := VisitCard{
			Lastname:    lastname,
			Firstname:   firstname,
			Function:    function,
			CompanyName: companyName,
		}
		visitCards = append(visitCards, visitCard)
		fmt.Println("Carte de visite enregistrée. ")
	} else {
		fmt.Println("Plus d'espace. ")
	}
}

func retrieveVisitCards() {
	if len(visitCards) > 0 {
		cardsToRemove := make([]int, 0)

		if len(visitCards) > 1 {
			fmt.Println("Sélectionnez les cartes que vous voulez récupérer (ex: 1, 2):")
			for i, visitCard := range visitCards {
				fmt.Printf("%d - %s\n", i+1, visitCard.CompanyName)
			}

			var choiceStr string
			fmt.Print("Carte à récupérer: ")
			fmt.Scan(&choiceStr)

			if len(choiceStr) > 0 {
				if choiceStr[0] == ',' {
					choiceStr = choiceStr[1:]
				}
				choices := append(cardsToRemove, convertStrToIntSlice(choiceStr)...)
				cardsToRemove = uniqueIntSlice(choices)
			}
		} else {
			cardsToRemove = append(cardsToRemove, 0)
		}

		for i := len(cardsToRemove) - 1; i >= 0; i-- {
			index := cardsToRemove[i]
			if index >= 0 && index < len(visitCards) {
				removedCard := visitCards[index]
				fmt.Printf("Carte récupérée: %s\n", removedCard.CompanyName)
				visitCards = append(visitCards[:index], visitCards[index+1:]...)
			}
		}
	} else {
		fmt.Println("Vous n'avez aucune carte de visite dans votre wallet.")
	}
}

func convertStrToIntSlice(input string) []int {
	slice := make([]int, 0)
	indices := append(slice, convertToIntSlice(input)...)
	return uniqueIntSlice(indices)
}

func convertToIntSlice(input string) []int {
	slice := make([]int, 0)
	for _, v := range input {
		if v >= '0' && v <= '9' {
			slice = append(slice, int(v-'0'))
		}
	}
	return slice
}

func uniqueIntSlice(input []int) []int {
	keys := make(map[int]bool)
	result := make([]int, 0)

	for _, entry := range input {
		if _, value := keys[entry]; !value {
			keys[entry] = true
			result = append(result, entry)
		}
	}
	return result
}

func main() {
	choice := 0
	for choice != 9 {
		fmt.Println("\nBienvenue dans 'Wallet', veuillez choisir une action à effectuer:",
			"\n1- Voir le solde dans mon compte",
			"\n2- Faire un dépôt",
			"\n3- Faire un retrait",
			"\n4- Déposer une carte",
			"\n5- Récupérer une carte",
			"\n6- Déposer une CIN",
			"\n7- Récupérer une CIN",
			"\n8- Déposer un permis de conduire",
			"\n9- Récupérer un permis de conduire",
			"\n10- Déposer une carte de visite",
			"\n11- Récupérer des cartes de visite",
			"\n12- Quitter")

		fmt.Print("Votre choix: ")
		fmt.Scan(&choice)

		switch choice {
		case 1:
			showBalance()
		case 2:
			deposit()
		case 3:
			withdraw()
		case 4:
			depositCard()
		case 5:
			retrieveCard()
		case 6:
			depositCIN()
		case 7:
			retrieveAndShowCIN()
		case 8:
			depositDriverLicense()
		case 9:
			retrieveAndShowDriverLicense()
		case 10:
			depositVisitCard()
		case 11:
			retrieveVisitCards()
		case 12:
			fmt.Println("Merci d'utiliser le service Wallet. Au revoir! ")
		default:
			fmt.Println("Choix invalide. Veuillez choisir une option valide. ")
		}
	}
}
