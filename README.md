# ICS3U-Final-Programming-Project-CMS

Geeral Format
    Option list is given to the user, and a number 1-8 is inputted for the menu options
    Four separate ArrayLists are used for student first and last names, student ID, and grades
    Accessing the ArrayLists with the CMS functions will be done so by using the same index in each of these ArrayLists
        These ArrayLists are initialized once
    The bulk of the code is encased in a while(running) loop, which allows for easier return to the main menu
    You will often find that user inputs are taken as strings, and this is to that they are easier to work with, and there is consistency is in code
     - It is easier to debug with strings
         - If the user gives me an invalid input (ex: “hello” for stuID”, then I can check the validity of the string without getting an error
  
   1) Add a student
    A for loop is used to iterate over the code twice, so that another student can be added if the user selects to
    
i is increased again if the user says no so that the for loop stops
Average of class marks
Average marks is calculated with %.2f for cleaner code
Minimum and maximum of class
Minimum and maximum is found by iterating over the ArrayList grades
Variables minPlace and maxPlace are used to identify the indexes of the min and max, so that I can draw the indexes of their respective values in the other 3 ArrayLists
Display the list of students
Variable editRunning is used to encase most of the function in a while loop so that it can be exited by using “3) Return to Main Menu”
The code allowing student data edits in inside of a while(!found) loop, which detects whether the user has entered a valid student ID
Display the mark distribution
Marks are gathered and the number of occurrences of the most frequent mark is used to determine the height of the graph
Iterations are done over each row, a bar is printed if the letter DOES have enough, and spaces are printed otherwise
This is done as many times as the chart would be tall
Search for a student
The index variable is used to determine the index of the students’ name in the list that they are found in
This is how the rest of their information is found
Display the top and bottom 20%
First, a requirement, or req is found for the top and bottom 20%
A copy of all the ArrayLists is created for the bottom and top
This is so that the lists can be edited and all the values for the bottom 20% can be printed at once, and then all the values for the top 20% can be printed at once
The minimum and maximum iterations are done req amount of times
If necessary, they are removed so that the next minimum and maximum values can be found
maxIndex and minIndex are used to find the rest of the students’ data
Exit the program
variable running is set to false so that the infinite loop terminates

At the end of the program, the variable invalid, which was declared in the beginning, is used to check if the user inputs anything other than 1-8 when selecting a menu option

Throughout the program, the same iterating minimum/maximum finding function is used

You might have also found that my 5 students are named after mathematical constants!
