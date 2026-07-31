# Library-Management-System
This is a small library system that allows users to add and borrow books. Users are then able to search for titles and view a popularity report that showcases books that have been borrowed frequently This program also saves the library data to a txt file and reloads it when the program starts. 

This project was made by utilising Array-Lists, linear searches, selection sort and simple file handling.

--**Features**--

**Save and load** -- allows for the number of books, each title and each borrow count to be saved in a txt file which is reloaded on start-up. 

**Popularity Report **-- creates for a copy of the book list and sorts it using selection sort, this allows the original list to not be modified.

**Search** -- uses a case-insensitive linear search to find a book and return its index.

**Borrow** -- finds a book by its title and increases its borrow count by 1.

**Add** -- adds a new book to the list.

--**Class Structure**-- 

**Book Record**-- represents a single book, within the class the title and the borrow count is stored. Book Record provides incrementBorrow and getDetails.

**Library Handler**-- handles the logic for the system, this includes adding books, search, borrowing, generating the popularity report, saving and loading from a txt file. Library Handler implements linear search for finding titles and selection sort for ranking books by their borrow count.

**Library App**-- is the main class that runs the menu. Library app loads the data at the start of the program, displaying the menu, reading user input and saving data before exiting. 

**File Format**-- The save file utilises underscores to replace spaces in book titles, when loading the underscores are replaced by spaces to fix book titles and incrementBorrow is called to recreate the book's borrow count.

**How to Run**-- 

-- Compile all .java files.

-- Run Library App. 

-- A file named library_data.txt will be created.

-- Use the menu to add, borrow, search, and view reports. 

-- When you exit the program saves all data in the library_data.txt.
