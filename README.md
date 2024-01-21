Changelog:

-Now uses the "https://moneyconvert.net/" API after the original service's API key ran out of uses. This API does not return the name of the currency, only the code.

-Swing interface is now connected to the API logic for display of real values.

-API logic has been refactored and organized into the JSONInterpreter and API interfaces (fixerws package).

-Program now accounts for null and negative amounts of money.

-"Calculate" button is now capitalized.

-Main method is "SwingMain".