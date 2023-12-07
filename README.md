# Wallet Project

This is a simple wallet program that allows you to perform the same actions as with a physical wallet. It has implementations in four different languages: JavaScript, Java, Python, and Go.

Here we are going to see how to launch it in __GO__

### Requirements:

* IDE
* Go archive installation

### Features:

The following actions are available within the wallet:

    1. Show balance
    2. Deposit cash
    3. Withdraw cash
    4. Deposit card
    5. Retrieve card
    6. Deposit National ID card (CIN)
    7. Retrieve National ID card (CIN)
    8. Deposit driver's license
    9. Retrieve and display driver's license information
    10. Deposit business card
    11. Retrieve business cards

### CONSTRAINT:
__Common points__:

    Deposit and retrieve/withdraw operations

__National ID card (CIN)__:

    Case 1: If a CIN is retrieved and not returned to the wallet, attempting to retrieve it again will result in an error.
    Case 2: Only one CIN can be stored at a time.
    Case 3: If there is no CIN in the wallet when attempting to retrieve it, an error will occur.

__Money__:

    Case 1: The withdrawal amount must not be less than or exceed the available balance; otherwise, an error will occur.

__Bank cards__:

    Case 1: If there are multiple cards, you can choose which one to retrieve, but only one at a time.
    Case 2: You can have a maximum of three bank cards in your wallet.
    Reference: Case 3 for National ID card

__Driver's license__:

    References all cases for the National ID card

__Business cards__:

    References Case 1 and Case 3 for the National ID card
    You can retrieve multiple business cards at once.

# How to run the program in Go:

The project structure is as follows:

```tree

└───wallet.go (Entrypoint and features implementation)

```

To launch the program, run the following commands in your terminal:

```agsl
    go run main.py
```
Authentication:

To access the wallet, enter the following credentials:

    Username: random
    Password: strongpassword

You can then perform the desired actions within the wallet.