******************************************
Samir Haq		0968761
CIS*2430		Assignment 3
November 29, 2017	samir@uoguelph.ca
******************************************

Program description
*******************
This program allows a user to keep track of an investment portfolio with stocks and mutual funds

User Guide
**********
GUI
	- Click buy in command menu to buy
             	- Choose stock to buy stock
			- Choose mutual fund to buy mutual funds
			- Enter symbol (string)
			- Enter name (string)
			- Enter quantity (int)
			- Enter price (double)
			- Click buy
			- Click reset to reset text fields
	- Click sell in command menu to sell
			- Enter symbol (string)
			- Enter quantity (int)
			- Enter price (double)
			- Click sell to sell
			- Click reset to reset text fields
	- Click update in command menu to update
			- Click Next to go to the next investment
			- Click Prev to go to the last investment
			- Enter price (double)
			- Click Save to update the investment displayed
	- Click getGain on command menu to get the gain
	- Click search on command menu to search
			- Enter search term (symbol, key words, 					highRange, lowRange) 
			- Click search to search
			- Click reset to reset fields
	- Click quit in the command menu to end program and save file
	- Clicking X on the window will not save the file but will end the program

Test plan
*********
Entering an input that is invalid either in quantity or type will
result in the program asking you to enter a valid input. Quantity must be 0 or greater

Attempting to buy a stock or mutual fund with the same symbol as that
of an investment that already exists in the list of the opposite type
will result in no investment being purchased as investment symbols
must be unique. (ie. buying stock with symbol TD then attempting to buy
mutual fund with symbol TD)

Attempting to sell a quantity greater than the quantity previously bought
will result in no investments being sold. (ie. buying 50 stocks then
attempting to sell 100)

Attempting to sell an investment that has not previously been bought will
result in the program stating "Investment not found."

Searching for a word that does not appear exactly in an investments
name instance variable will result in nothing being printed

Searching for a price range that does not exist will not print out anything and will return to the menu

If an empty string is searched for, the program will return all
investments.

Exit the program with the current inventory

Run the program in and enter an empty search, all the investments in the inventory previously should remain

Sell all current investments in a certain company and then search for the company using the keyword, it should no
longer exist.

Enter two companies with similar names (ex. Toronto Bank and Toronto Star) then in the search, enter a common
keyword (ex. Toronto). It should print out both investments. Now try searching for the full company name of one
(ex. Enter Toronto Star). The other company shall not display. (Toronto Bank will not display). If you then search
Toronto Bank Guelph, neither investment shall show.

On the Update interface if there are no investments all buttons should be disabled and nothing showing on the screen.

If you have reached the last investment the Next button should be disable and if you are on the first investment the Prev button should be disabled.








