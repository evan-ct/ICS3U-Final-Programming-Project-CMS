//NAME: Evan Trinh

import java.util.ArrayList;
import java.util.Scanner;

public class CMS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Add the starting 5 students
        ArrayList<String> firstNames = new ArrayList<String>();
        firstNames.add("Pibble"); firstNames.add("Taubble"); firstNames.add("Eulbble"); firstNames.add("Pythbble"); firstNames.add("S.Devbble");
        ArrayList<String> lastNames = new ArrayList<String>();
        lastNames.add("P"); lastNames.add("T"); lastNames.add("E"); lastNames.add("P"); lastNames.add("SD");
        ArrayList<Double> grades = new ArrayList<Double>();
        grades.add(31.41); grades.add(62.83); grades.add(27.18); grades.add(14.14); grades.add(68.27);
        ArrayList<Integer> stuID = new ArrayList<Integer>();
        stuID.add(314159); stuID.add(628319); stuID.add(271828); stuID.add(141421); stuID.add(682689);

        //Greeting message
        System.out.println("Welcome to the CMS!");

        //Keep the program running and detect for invalid inputs
        boolean invalid = false;
        boolean running = true;
        while (running) {

            //Menu options
            System.out.println("1) Add a student\n2) Average of class marks\n3) Minimum and Maximum mark in the class\n4) Display the list of the students" +
                    "\n5) Display the Mark Distribution\n6) Search a Student\n7) Display the top and bottom 20%\n8) Exit the program");
            if (!invalid) {
                System.out.print("Please select an option number above: ");
            } else {
                System.out.print("Invalid option, please select an option number above: ");
            }
            invalid = false;

            //Take input from user
            String option = sc.nextLine();
            System.out.println("-----------------------------");

            if (option.equals("1")) { //Add a student
                for (int i = 0; i < 2; i++) { //Loop mechanism for adding 2 students

                    //Edit options
                    System.out.println("Add a Student");
                    System.out.print("First name: ");
                    firstNames.add(sc.nextLine());
                    System.out.print("Last name: ");
                    lastNames.add(sc.nextLine());
                    System.out.print("Grade: ");
                    grades.add(sc.nextDouble());
                    sc.nextLine();
                    System.out.print("Student ID: ");

                    //Make sure student ID is at the desirable length
                    String newID = sc.nextLine();
                    while (!(newID.length() == 6)) {
                        System.out.print("Invalid ID. Must be 6 digits: ");
                        newID = sc.nextLine();
                    }
                    stuID.add(Integer.parseInt(newID));

                    if (i < 1) {//Prevent asking for another student if the user previously said "yes"
                        System.out.print("Do you want to add another student?: "); //Ask for addition of a second student
                        String ans = sc.nextLine().toLowerCase();
                        while (!(ans.equals("yes") || ans.equals("y") || ans.equals("no") || ans.equals("n"))) { //Detect invalid input
                            System.out.print("Invalid input. Enter \"yes\" or \"no\":");
                        }
                        if (ans.equals("no") || ans.equals("n")) { //End loop if user says no
                            i++;
                        }
                    }
                }
            } else if (option.equals("2")) { //Average of class marks
                double total = 0;
                for (double mark : grades) { //Get sum of grades
                    total += mark;
                }
                System.out.println("Average: " + String.format("%.2f", total/grades.size())); //Return the sum/number for average
            } else if (option.equals("3")) { //Minimum and Maximum mark in the class

                double minimum = grades.get(0); //Set values for temporary min and max
                double maximum = grades.get(0);
                int minPlace = 0; //Create holders for the indexes of min and max
                int maxPlace = 0;

                for (int i = 1; i < grades.size(); i++) { //Iterate through grades to find min and max
                    if (grades.get(i) < minimum) {
                        minimum = grades.get(i);
                        minPlace = i;
                    }
                    if (grades.get(i) > maximum) {
                        maximum = grades.get(i);
                        maxPlace = i;
                    }
                }
                //Print min and max using the gathered indexes
                System.out.println("Minimum: " + grades.get(minPlace) + " | " + lastNames.get(minPlace) + ", " + firstNames.get(minPlace));
                System.out.println("Maximum: " + grades.get(maxPlace) + " | " + lastNames.get(maxPlace) + ", " + firstNames.get(maxPlace));

            } else if (option.equals("4")) { //Display list of students

                //Print list
                System.out.println("ID      Mark   Last, First");
                for (int i = 0; i < firstNames.size(); i++) {
                    System.out.println(stuID.get(i) + "  " + String.format("%.2f", grades.get(i)) + "  " + lastNames.get(i) + ", " + firstNames.get(i));
                }

                //Loop to allow the Return to Menu function to work
                boolean editRunning = true;
                while (editRunning) {
                    System.out.println("-----------------------------");
                    System.out.println("1) Edit a Student\n2) Remove a Student\n3) Return to Main Menu");
                    String editAns = sc.nextLine();

                    //Deny values other than 1, 2, or 3
                    while (!(editAns.equals("1") || editAns.equals("2") || editAns.equals("3"))) {
                        System.out.print("Invalid option: ");
                        editAns = sc.nextLine();
                    }
                    if (editAns.equals("1")) {
                        boolean found = false;
                        System.out.print("Enter student's ID: ");

                        //Loop that detects invalid ID
                        while (!found) {
                            String editID = sc.nextLine();

                            //Compares the inputted ID with all student IDs in the ArrayList
                            for (int i = 0; i < stuID.size(); i++) {
                                if (editID.equals(stuID.get(i).toString())) {
                                    found = true;
                                    System.out.print("Update First Name: ");
                                    firstNames.set(i, sc.nextLine());
                                    System.out.print("Update Last Name: ");
                                    lastNames.set(i, sc.nextLine());
                                    System.out.print("Update Grade: ");
                                    grades.set(i, sc.nextDouble());
                                    sc.nextLine(); //Consume extra \n
                                }
                            }
                            if (!found) {
                                System.out.print("Invalid ID, try again: ");
                            }
                        }
                    } else if (editAns.equals("2")) {
                        System.out.print("Enter student's ID: ");
                        String editID = sc.nextLine();

                        //Compare the user's inputted student ID with all other in the ArrayList
                        //and remove all data based on that index
                        for (int i = 0; i < stuID.size(); i++) {
                            if (editID.equals(stuID.get(i))) {
                                stuID.remove(i);
                                firstNames.remove(i);
                                lastNames.remove(i);
                                grades.remove(i);
                            }
                        }
                    } else {
                        editRunning = false;
                    }
                }
            } else if (option.equals("5")) { //Display the mark distribution
                int[] letter = new int[5];

                //Find occurrences of each letter grade
                for (double mark : grades) {
                    if (mark >= 80) {
                        letter[0]++;
                    } else if (mark >= 70) {
                        letter[1]++;
                    } else if (mark >= 60) {
                        letter[2]++;
                    } else if (mark >= 50) {
                        letter[3]++;
                    } else {
                        letter[4]++;
                    }
                }

                //Use the value of the highest letter grade to determine
                //the height of the graph
                int highest = letter[0];
                for (int i = 1; i < 5; i++) {
                    if (letter[i] > letter[i - 1]) {
                        highest = letter[i];
                    }
                }

                //Iterate over each row (the height that we found before)
                for (int i = highest; i > 0; i--) {
                    //Iterate over each letter in the row and print blocks if they
                    //are large enough, but print blanks if they are not
                    for (int k = 0; k < letter.length; k++) {
                        if (letter[k] >= i) {
                            System.out.print("███");
                        } else {
                            System.out.print("   ");
                        }
                        System.out.print(" ");
                    }
                    System.out.println("");
                }
                System.out.println("-------------------");
                System.out.println(" A   B   C   D   F ");
            } else if (option.equals("6")) { //Search a student
                System.out.print("Search for a student: ");
                int index = 0;

                //Take a user input to search
                String search = sc.nextLine().toLowerCase();

                //Compare user input with available first names
                for (int i = 0; i < firstNames.size(); i++) {
                    if (firstNames.get(i).toLowerCase().contains(search)) {
                        index = i;
                    }
                }
                //Compare user input with available last names
                for (int i = 0; i < lastNames.size(); i++) {
                    if (lastNames.get(i).toLowerCase().contains(search)) {
                        index = i;
                    }
                }

                //Print search results
                System.out.println("ID      Mark   Last, First");
                System.out.println(stuID.get(index) + "  " + String.format("%.2f", grades.get(index)) + "  " + lastNames.get(index) + ", " + firstNames.get(index));

            } else if (option.equals("7")) { //Displat the top and bottom 20%

                //Determine how many values constitute as the "top"/"bottom" (req for requirement)
                int req = (int) Math.round(firstNames.size() / 5.0);

                //Create copies of the original ArrayLists, one for top and one for bottom
                //This is so that we can remove values as we iterate and print the top values, and then
                //move on to the bottom 20% with a fresh set of ArrayLists
                ArrayList<Double> gradesCopyTop = new ArrayList<Double>(); //Copy the grades ArrayList
                for (double mark : grades) gradesCopyTop.add(mark);
                ArrayList<String> firstCopyTop = new ArrayList<String>(); //Copy the grades firstNames
                for (String name : firstNames) firstCopyTop.add(name);
                ArrayList<String> lastCopyTop = new ArrayList<String>(); //Copy the grades lastnames
                for (String name : lastNames) lastCopyTop.add(name);
                ArrayList<Integer> idCopyTop = new ArrayList<Integer>(); //Copy the grades stuID
                for (int num : stuID) idCopyTop.add(num);

                ArrayList<Double> gradesCopyBottom = new ArrayList<Double>(); //Copy the grades ArrayList
                for (double mark : grades) gradesCopyBottom.add(mark);
                ArrayList<String> firstCopyBottom = new ArrayList<String>(); //Copy the grades firstNames
                for (String name : firstNames) firstCopyBottom.add(name);
                ArrayList<String> lastCopyBottom = new ArrayList<String>(); //Copy the grades lastnames
                for (String name : lastNames) lastCopyBottom.add(name);
                ArrayList<Integer> idCopyBottom = new ArrayList<Integer>(); //Copy the grades stuID
                for (int num : stuID) idCopyBottom.add(num);

                System.out.println("Bottom 20%");
                System.out.println("ID      Mark   Last, First");

                //Find thd bottom req number of students
                //minIndex is used to determine their indexes to access the rest of their data
                for (int i = 0; i < req; i++) {
                    double minimum = gradesCopyBottom.get(0);
                    int minIndex = 0;
                    for (int k = 1; k < gradesCopyBottom.size(); k++) { //Iterate through grades to find min
                        if (gradesCopyBottom.get(k) < minimum){
                            minimum = gradesCopyBottom.get(k);
                            minIndex = k;
                        }
                    }

                    //Print the data using the copies
                    System.out.println(idCopyBottom.get(minIndex) + "  " + String.format("%.2f", gradesCopyBottom.get(minIndex))
                            + "  " + lastCopyBottom.get(minIndex) + ", " + firstCopyBottom.get(minIndex));
                    //Data is then removed so that we can iterate over the grades again
                    //and find the remaining bottom values needed
                    gradesCopyBottom.remove(minIndex); firstCopyBottom.remove(minIndex); lastCopyBottom.remove(minIndex); idCopyBottom.remove(minIndex);
                }

                System.out.println("-----------------------------");
                System.out.println("Top 20%");
                System.out.println("ID      Mark   Last, First");

                //Find thd top req number of students
                //maxIndex is used to determine their indexes to access the rest of their data
                for (int i = 0; i < req; i++) {
                    double maximum = gradesCopyTop.get(0);
                    int maxIndex = 0;
                    for (int k = 1; k < gradesCopyTop.size(); k++) { //Iterate through grades to find max
                        if (gradesCopyTop.get(k) > maximum){
                            maximum = gradesCopyTop.get(k);
                            maxIndex = k;
                        }
                    }

                    //Print the data using the copies
                    System.out.println(idCopyTop.get(maxIndex) + "  " + String.format("%.2f", gradesCopyTop.get(maxIndex))
                            + "  " + lastCopyTop.get(maxIndex) + ", " + firstCopyTop.get(maxIndex));
                    //Data is then removed so that we can iterate over the grades again
                    //and find the remaining top values needed
                    gradesCopyTop.remove(maxIndex); firstCopyTop.remove(maxIndex);lastCopyTop.remove(maxIndex);idCopyTop.remove(maxIndex);
                }

            } else if (option.equals("8")) { //Exit the program
                System.out.println("Thank you for using the CMS!");
                running = false;
            } else {
                invalid = true; //Check for inputs that are not 1-8
            }
            System.out.println("-----------------------------");
        }
        sc.close();
    }
}
