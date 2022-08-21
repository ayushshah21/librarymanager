/* 
Ayush Shah
2-26-22
CSE 17: PP1
The IDE being used is Visual Studio Code.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Title [] titles = new Title[50];
        Catalog catalog = new Catalog();
        File file = new File("titles.txt");// txt file being read
        int count = 0;
        try{
            Scanner fileScanner = new Scanner(file);
            while(fileScanner.hasNextLine()){//Here we read through the txt file and assign elements to the titles array
                String callNumber = fileScanner.nextLine();
                if(callNumber.charAt(0) == 'B'){//For books
                    String title = fileScanner.nextLine();
                    String publisher = fileScanner.nextLine();
                    int year = Integer.valueOf(fileScanner.nextLine());
                    int copies = Integer.valueOf(fileScanner.nextLine());
                    String author = fileScanner.nextLine();
                    Long ISBN = Long.valueOf(fileScanner.nextLine());
                    titles[count++] = new Book(title, publisher, callNumber, year, copies, ISBN, author);
                }
                if(callNumber.charAt(0) == 'P'){//For periodicals
                    String title = fileScanner.nextLine();
                    String publisher = fileScanner.nextLine();
                    int year = Integer.valueOf(fileScanner.nextLine());
                    int copies = Integer.valueOf(fileScanner.nextLine());
                    int month = Integer.valueOf(fileScanner.nextLine());
                    int issueNumber = Integer.valueOf(fileScanner.nextLine());
                    titles[count++] = new Periodical(title, publisher, callNumber, year, copies, month, issueNumber);
                }
            }
       fileScanner.close();
     }
        catch(FileNotFoundException e){
            System.out.println("Cannot open file \"titles.txt\"");
        }

       int choice;
       boolean play = true;//As long as this is true, the user will keep selecting choices.
       do{
        System.out.println("Select an operation: \n1: View all titles\n2: Search by call number\n3: Search by title\n4: Search by year\n5: Add a new title\n6: Remove title\n7: Sort titles by year\n8: View titles for restoration\n9: Exit");
        choice = catalog.getInt(scnr);
        if(choice == 1){
            play = true;
            catalog.printCatalog(titles, count);//Print the array of objects
        }
        else if(choice == 2){
            play = true;
            System.out.println("Enter a call number");
            String callNumber = scnr.nextLine();
            boolean checkCall = catalog.checkCallNumber(callNumber);
            int index = catalog.searchCallNumber(titles, count, callNumber);
            if(checkCall){
                if(index != -1){
                    System.out.println("Title Found:\n" + titles[index].printString());//Print title based on call number
                }
                else{
                    System.out.println("Sorry, this title wasn't found");
                }
            }
        
            
        }
        else if(choice == 3){
            play = true;
            System.out.println("Enter a title");
            String title = scnr.nextLine();
            int [] newArr = catalog.findTitle(titles, count, title);
            int size = 0;
            for(int i = 0; i < newArr.length; i++){
                if(newArr[i] != 0){
                    size++;
                }
            }
            if(size == 0){
                System.out.println("No titles found");
            }
            if(size > 0){
                System.out.println("List of titles found: " + size);//Here we will print each object that has the same title as the one the user enetered
                System.out.printf(String.format("%-20s\t%-55s\t%-25s\t%-5s", "Call Number", "Title", "Publisher", "Year"));
                System.out.println();
            }
            for(int i = 0; i < newArr.length; i++){
                if(newArr[i] != 0){
                    System.out.println(titles[i]);
                }
            }
            }
            
        else if(choice == 4){
            play = true;
            System.out.println("Enter a year");
            int year = scnr.nextInt();
            boolean checkYear = catalog.checkYear(year);
           if(checkYear){
            int [] newArr = catalog.findYear(titles, count, year);
            int size = 0;
            for(int i = 0; i < newArr.length; i++){
                if(newArr[i] != 0){
                    size++;
                }
            }
            if(size == 0){
                System.out.println("No titles found in the year " + year);
            }
            if(size > 0){
                System.out.println("List of titles found: " + size);//Here we print the the title's info based year given
                System.out.printf(String.format("%-20s\t%-55s\t%-25s\t%-5s", "Call Number", "Title", "Publisher", "Year"));
                System.out.println();
            }
            for(int i = 0; i < newArr.length; i++){
                if(newArr[i] != 0){
                    System.out.println(titles[i]);
                }
            }
           }
        }
        else if(choice == 5){//Here the user can add a title to the array
            play = true;
            boolean checkType = false;
            boolean checkCallNumber = false;
            boolean checkDupCallNumber = false;
            String author = "";
            String type = " ";
            String callNumber = "";
            int copies = 0;
            System.out.println("Enter the title: ");
            String title = scnr.nextLine();
            System.out.println("Enter the publisher: ");
            String publisher = scnr.nextLine();
            System.out.println("Enter the year of publication: ");
            int year = scnr.nextInt();
            boolean checkYear = catalog.checkYear(year);
            if(checkYear){
                System.out.println("Enter the number of copies: ");
                copies = scnr.nextInt();
                System.out.println("Enter the type of title (book/periodical): ");
                type = scnr.next();
                checkType = catalog.checkType(type);
            }
            if(checkType){
                if(type.equalsIgnoreCase("Book")){
                    System.out.println("Enter the call number (B-ddd-ddd-ddd):");
                    callNumber = scnr.next();
                    checkCallNumber = catalog.checkSpecificCallNumber(callNumber, type);
                    checkDupCallNumber = catalog.checkDuplicateCallNum(titles, callNumber, count);
                    
                }
                else{
                    System.out.println("Enter the call number (P-ddd-ddd-ddd):");
                    callNumber = scnr.next();
                    checkCallNumber = catalog.checkSpecificCallNumber(callNumber, type);
                    checkDupCallNumber = catalog.checkDuplicateCallNum(titles, callNumber, count);
                }
            }
            if(checkCallNumber && checkDupCallNumber == true && type.equalsIgnoreCase("Book")){
                System.out.println("Enter the author: ");
                scnr.nextLine();
                author = scnr.nextLine();
                System.out.println("Enter ISBN (10 digits): ");
                Long ISBN = scnr.nextLong();
                titles[count++] = new Book(title, publisher, callNumber, year, copies, ISBN, author);
            }
            else if(checkCallNumber && checkDupCallNumber == true && type.equalsIgnoreCase("Periodical")){
                System.out.println("Enter the month: ");
                int month = scnr.nextInt();
                boolean checkMonth = catalog.checkMonth(month);
                if(checkMonth){
                    System.out.println("Enter the issue number ");
                    int issueNumber = scnr.nextInt();
                    titles[count++] = new Periodical(title, publisher, callNumber, year, copies, month, issueNumber);
                }
            }
        }
        else if(choice == 6){//Here the user can remove a title from the array by entering that title's call number
            play = true;
            System.out.println("Enter the call number (B-ddd-ddd-ddd or P-ddd-ddd-ddd): ");
            String callNumber = scnr.next();
            int callNumIndex = 0;
            boolean checkCallNum = catalog.checkCallNumber(callNumber);
            if(checkCallNum){
                boolean foundCallNum = catalog.checkForCallNum(titles, callNumber, count);
                if(foundCallNum){
                    for(int i = 0; i < count; i++){
                        if(titles[i].getCallNumber().equals(callNumber)){
                            callNumIndex = i;
                            break;
                        }
                    }
                    for(int i = callNumIndex + 1; i < count; i++){
                        titles[i - 1] = titles[i];
                    }
                    count--;
                    System.out.println("Success, Title was removed.");
                }
                else{
                    System.out.println("Title not found");
                }
            }
            
        }
        else if(choice == 7){//Here we sort the titles by year
            play = true;
            catalog.sortByYear(titles, count);
        }
        else if(choice == 8){//Here we find all restorable titles and print them
            play = true;
            int [] newArr = catalog.findRestorable(titles, count);
            int size = 0;
            for(int i = 0; i < newArr.length; i++){
                if(newArr[i] != 0){
                    size++;
                }
            }
            if(size == 0){
                System.out.println("No restorable titles found");
            }
            if(size > 0){
                System.out.println("List of restorable titles found: " + size);
                System.out.printf(String.format("%-20s\t%-55s\t%-25s\t%-5s", "Call Number", "Title", "Publisher", "Year"));
                System.out.println();
            }
            for(int i = 0; i < newArr.length; i++){
                if(newArr[i] != 0){
                    System.out.println(titles[i]);
                }
            }
        }
        else if(choice == 9){//Here we enter all updated info into the txt file
            play = false;
            file = new File("titles.txt");
            try{
                PrintWriter writeFile = new PrintWriter(file);//After the user decides to quit, we update the textfile.
                for(int i = 0; i < count; i++){
                    if(titles[i].getCallNumber().charAt(0) == ('P')){
                        writeFile.println(titles[i].simpleString());
                    }
                    else{
                        writeFile.println(titles[i].simpleString());
                    }
                }
                writeFile.close();
            }
            catch(FileNotFoundException e){
                System.out.println("Cannot open file");
            }
        }
    } while(play == true);
    }
    
}
