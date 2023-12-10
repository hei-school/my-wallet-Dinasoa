package main

import (
	"fmt"
	"strconv"
	"strings"
	"os"
)

type Card struct {
	Type           string
	Amount         string
	ExpirationDate string
	CardHolder     string
	CardNumber     string
}

type CIN struct {
	LastName      string
	FirstName     string
	Birthdate     string
	DeliveryDate  string
}

type DriverLicense struct {
	LastName   string
	FirstName  string
	Birthdate  string
	LicenseTypes []string
}

type VisitCard struct {
	LastName    string
	FirstName   string
	Position    string
	CompanyName string
}

var solde = 0.0
var cards []Card
var identityCard []CIN
var driverLicense []DriverLicense
var driverLicenseTypes []string
var visitCards []VisitCard

func showBalance() {
	fmt.Printf("Votre solde actuel: %.2f Ar\n", solde)
}

func depositCash() {
	var amountStr string
	fmt.Print("Veuillez saisir le montant à déposer: Ar ")
	fmt.Scanln(&amountStr)

	amount, err := strconv.ParseFloat(amountStr, 64)
	if err == nil && amount > 0 {
		solde += amount
		fmt.Println("Dépôt effectué!")
	} else {
		fmt.Println("Le montant que vous avez saisi est invalide, veuillez vérifier!")
	}
}

func withdrawCash() {
	var amountStr string
	fmt.Print("Veuillez saisir le montant à retirer: Ar ")
	fmt.Scanln(&amountStr)

	amount, err := strconv.ParseFloat(amountStr, 64)
	if err == nil && amount > 0 {
		if amount <= solde {
			solde -= amount
			fmt.Println("Retrait effectué.")
		} else {
			fmt.Println("Votre solde est insuffisant.")
		}
	} else {
		fmt.Println("Montant invalide.")
	}
}

func depositCard() {
	var cardType, amount, expirationDate, cardHolder, cardNumber string
	fmt.Print("Veuillez saisir le type de carte: ")
	fmt.Scanln(&cardType)
	fmt.Print("Veuillez saisir le montant dans votre carte: ")
	fmt.Scanln(&amount)
	fmt.Print("Veuillez saisir la date d'expiration de la carte: ")
	fmt.Scanln(&expirationDate)
	fmt.Print("Veuillez saisir le propriétaire de cette carte: ")
	fmt.Scanln(&cardHolder)
	fmt.Print("Veuillez saisir le numéro de carte: ")
	fmt.Scanln(&cardNumber)

	card := Card{Type: cardType, Amount: amount, ExpirationDate: expirationDate, CardHolder: cardHolder, CardNumber: cardNumber}
	amountFloat, _ := strconv.ParseFloat(amount, 64)
	solde += amountFloat
	cards = append(cards, card)

	fmt.Println("Votre carte bancaire a bien été déposée.")
}

func recoveredCard() {
	if len(cards) >= 1 {
		fmt.Println("Cartes disponibles à récupérer:")
		for i, card := range cards {
			fmt.Printf("%d- Type: %s, Numéro de carte: %s\n", i+1, card.Type, card.CardNumber)
		}

		var questionStr string
		fmt.Print("Quelle carte voulez-vous récupérer (entrez le numéro correspondant): ")
		fmt.Scanln(&questionStr)

		question, err := strconv.Atoi(questionStr)
		if err == nil && question >= 1 && question <= len(cards) {
			cardIndex := question - 1
			recoveredCard := cards[cardIndex]
			solde -= amountToFloat(recoveredCard.Amount)
			fmt.Printf("La carte récupérée: Type - %s, Numéro de carte - %s\n", recoveredCard.Type, recoveredCard.CardNumber)
			cards = append(cards[:cardIndex], cards[cardIndex+1:]...)
		} else {
			fmt.Println("Veuillez ne saisir que les choix proposés.")
		}
	} else {
		fmt.Println("Vous n'avez aucune carte à récupérer.")
	}
}

func depositCIN() {
	fmt.Println("Veuillez entrer les informations sur votre CIN:")
	var lastName, firstName, birthdate, deliveryDate string
	fmt.Print("Nom: ")
	fmt.Scanln(&lastName)
	fmt.Print("Prenom: ")
	fmt.Scanln(&firstName)
	fmt.Print("Date de naissance: ")
	fmt.Scanln(&birthdate)
	fmt.Print("Date de delivrance: ")
	fmt.Scanln(&deliveryDate)

	identity := CIN{LastName: lastName, FirstName: firstName, Birthdate: birthdate, DeliveryDate: deliveryDate}

	if len(identityCard) == 0 {
		identityCard = append(identityCard, identity)
		fmt.Println("Depot de CIN effectué.")
	} else if len(identityCard) == 1 {
		fmt.Println("Votre CIN devrait être unique.")
	}
}

func retrieveAndShowCIN() {
	if len(identityCard) > 0 {
		fmt.Println("CIN récupérée.")
		fmt.Printf("Les détails de votre CIN:\nNom: %s\nPrenom: %s\nDate de naissance: %s\nDate de delivrance: %s\n",
			identityCard[0].LastName, identityCard[0].FirstName, identityCard[0].Birthdate, identityCard[0].DeliveryDate)
		identityCard = nil
	} else {
		fmt.Println("Aucune carte d'identité identifiée.")
	}
}

func depositDriverLicense() {
	fmt.Println("Veuillez entrez les informations sur votre permis de conduire:")
	var lastName, firstName, birthdate, licenseTypesStr string
	fmt.Print("Nom: ")
	fmt.Scanln(&lastName)
	fmt.Print("Prenom: ")
	fmt.Scanln(&firstName)
	fmt.Print("Date de naissance: ")
	fmt.Scanln(&birthdate)
	fmt.Print("Type de permis (séparez par un virgule si vous avez plus qu'un type | a, b, c): ")
	fmt.Scanln(&licenseTypesStr)

	licenseTypes := strings.Split(licenseTypesStr, ",")

	if len(driverLicense) == 0 {
		driverLicense = append(driverLicense, DriverLicense{LastName: lastName, FirstName: firstName, Birthdate: birthdate, LicenseTypes: licenseTypes})
		fmt.Println("Depot effectué.")
	} else {
		fmt.Println("Votre permis de conduire devrait être unique.")
	}
}

func retrieveAndShowDriverLicense() {
	if len(driverLicense) > 0 {
		fmt.Println("Permis de conduire récupéré.")
		fmt.Printf("Les détails de votre permis:\nNom: %s\nPrenom: %s\nDate de naissance: %s\nType:\n",
			driverLicense[0].LastName, driverLicense[0].FirstName, driverLicense[0].Birthdate)

		for i, licenseType := range driverLicense[0].LicenseTypes {
			fmt.Printf("%d - %s\n", i+1, licenseType)
		}

		driverLicense = nil
	} else {
		fmt.Println("Aucun permis de conduire identifié.")
	}
}

func depositVisitCard() {
	fmt.Println("Veuillez renseigner les informations de votre carte de visite:")
	var lastName, firstName, position, companyName string
	fmt.Print("Nom: ")
	fmt.Scanln(&lastName)
	fmt.Print("Prenom: ")
	fmt.Scanln(&firstName)
	fmt.Print("Poste: ")
	fmt.Scanln(&position)
	fmt.Print("Entreprise: ")
	fmt.Scanln(&companyName)

	if len(visitCards) <= 3 {
		visitCards = append(visitCards, VisitCard{LastName: lastName, FirstName: firstName, Position: position, CompanyName: companyName})
		fmt.Println("Carte de visite enregistrée.")
	} else {
		fmt.Println("Plus d'espace.")
	}
}

func retrieveVisitCards() {
	var cardsToRemove []int

	if len(visitCards) == 0 {
		fmt.Println("Vous n'avez aucune carte de visite dans votre wallet.")
		return
	}

	if len(visitCards) > 1 {
		fmt.Println("Sélectionnez les cartes que vous voulez récupérer (ex: 1,2):")
		for i, visitCard := range visitCards {
			fmt.Printf("%d - %s\n", i+1, visitCard.CompanyName)
		}

		var choice string
		fmt.Print("Carte à récupérer: ")
		fmt.Scanln(&choice)

		if strings.Contains(choice, ",") {
			indices := strings.Split(choice, ",")
			for _, indexStr := range indices {
				index, err := strconv.Atoi(indexStr)
				if err == nil {
					cardsToRemove = append(cardsToRemove, index-1)
				}
			}
		} else {
			index, err := strconv.Atoi(choice)
			if err == nil {
				cardsToRemove = append(cardsToRemove, index-1)
			}
		}
	} else {
		cardsToRemove = append(cardsToRemove, 0)
	}

	for _, index := range cardsToRemove {
		removedCard := visitCards[index]
		fmt.Printf("Carte récupérée: %s\n", removedCard.CompanyName)
		visitCards = append(visitCards[:index], visitCards[index+1:]...)
	}
}

func main() {
	if auth() {
		var choice int

		for {
			fmt.Println(`Bienvenue dans "Wallet", veuillez choisir une action à effectuer:
                1- Voir le solde dans mon compte
                2- Faire un dépôt
                3- Faire un retrait en cash
                4- Deposer une carte bancaire
                5- Recuperer une carte bancaire
                6- Deposer une CIN
                7- Recuperer une CIN
                8- Deposer un permis de conduire
                9- Recuperer et afficher les informations d'un permis de conduire
                10- Deposer une carte de visite
                11- Recuperer une carte de visite
                12- Quitter`)

			fmt.Print("Votre choix: ")
			fmt.Scanln(&choice)

			switch choice {
			case 1:
				showBalance()
			case 2:
				depositCash()
			case 3:
				withdrawCash()
			case 4:
				depositCard()
			case 5:
				recoveredCard()
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
				fmt.Println("Merci d'utiliser le service Wallet. Au revoir!")
				os.Exit(0)
			default:
				fmt.Println("Choix invalide. Veuillez choisir une option valide.")
			}
		}
	}
}

func auth() bool {
	defaultUsername := "random"
	defaultPassword := "strongpassword"

	var username, userPassword string

	fmt.Print("Veuillez entrer votre nom d'utilisateur: ")
	fmt.Scanln(&username)
	fmt.Print("Veuillez confirmer votre identité en tapant le mot de passe: ")
	fmt.Scanln(&userPassword)

	if username != defaultUsername || userPassword != defaultPassword {
		fmt.Println("Oups, vous n'avez pas accès à ce wallet, désolé.")
		return false
	}
	return true
}

func amountToFloat(amount string) float64 {
	amountFloat, _ := strconv.ParseFloat(amount, 64)
	return amountFloat
}
