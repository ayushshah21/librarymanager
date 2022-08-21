import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Catalog {
        Title [] titles = new Title[50];
        File file = new File("titles.txt");// text file being read
       int count = 0;
        /*try{
            Scanner fileScanner = new Scanner(file);
            while(fileScanner.hasNextLine()){//Here we will read in the file and assign the values to be part of the array of titles
                String callNumber = fileScanner.nextLine();
                if(callNumber.charAt(0) == 'B'){//Book objects
                    String title = fileScanner.nextLine();
                    String publisher = fileScanner.nextLine();
                    int year = Integer.valueOf(fileScanner.nextLine());
                    int copies = Integer.valueOf(fileScanner.nextLine());
                    String author = fileScanner.nextLine();
                    Long ISBN = Long.valueOf(fileScanner.nextLine());
                    titles[count++] = new Book(title, publisher, callNumber, year, copies, ISBN, author);
                }
                if(callNumber.charAt(0) == 'P'){//Periodical objects
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
        }*/

   /***
	 * Method that prints the array of objects
	 * @param	list for the list of objects 
     * @param	type for the int count
	 * @return	no return value
	 */
    public void printCatalog(Title [] list, int count){
        System.out.printf(String.format("%-20s\t%-55s\t%-25s\t%-5s", "Call Number", "Title", "Publisher", "Year"));
        System.out.println();
        for(int i = 0; i < count; i++){
            System.out.println(list[i].toString());
        }
    }
    /***
	 * Method that finds the index of a specified title and returns its index
	 * @param	list for the list of objects 
     * @param	count for the count of # of objects 
     * @param	callNumber for the callNumber of the title
	 * @return	return the index of Title
	 */
    public int searchCallNumber(Title[] list, int count, String callNumber){
        int index = -1;
        for(int i = 0; i < count; i++){
            ++index;
            if(list[i].getCallNumber().equalsIgnoreCase(callNumber)){
                return index;
            }
        }
        return -1;
        
    } 
    /***
	 * Method that checks that the user entered a proper call number
	 * @param	callNumber for callNumber of title
	 * @return	returns a boolean
	 */
    public Boolean checkCallNumber(String callNumber) throws InvalidDataException{
        try{
            if(callNumber.matches("[P|B]-\\d{3}-\\d{3}-\\d{3}")){
                    return true;
                }
                else{
                    throw new InvalidDataException("Invalid Call Number. Must be B-ddd-ddd-ddd or P-ddd-ddd-ddd");
                }
    }
        catch(InvalidDataException e){
            System.out.println(e.getMessage());
        }
        return false;
}
    /***
	 * Method that checks if the call number matches any call numbers from array. This is used to determine if element can be removed from array
	 * @param	list for array of objects
     * @param   callNumber for the call Number
     * @param   count number of created objects
	 * @return	returns a boolean
	 */
    public Boolean checkForCallNum(Title [] list, String callNumber, int count){
            for(int i = 0; i < count; i++){
                if(callNumber.equalsIgnoreCase(list[i].getCallNumber())){
                    return true;
                }
            }
            return false;
        }
    /***
	 * Method that checks that the user doesn't input an invalid call number
	 * @param	list for array of objects
     * @param   callNumber for the call Number
     * @param   count number of created objects
	 * @return	returns a boolean
	 */
    public Boolean checkDuplicateCallNum(Title [] list, String callNumber, int count) throws InvalidDataException{
        boolean original = true;
        try{
            for(int i = 0; i < count; i++){
                if(callNumber.equalsIgnoreCase(list[i].getCallNumber())){
                    original = false;
                    throw new InvalidDataException("Duplicate Call Number");
                }
        }
    }
        catch(InvalidDataException e){
            System.out.println(e.getMessage());
        }
        return original;
}
    /***
	 * Method that checks that the inputs a proper call number 
     * @param   callNumber for the call Number
     * @param   type for book or periodical
	 * @return	returns a boolean
	 */
    public Boolean checkSpecificCallNumber(String callNumber, String type) throws InvalidDataException{
        try{
            if(type.equalsIgnoreCase("Book")){
                if(callNumber.matches("[B]-\\d{3}-\\d{3}-\\d{3}")){
                    return true;
                }
                else{
                    throw new InvalidDataException("Invalid Call Number. Must be B-ddd-ddd-ddd");
                }
            }
            else{
                if(callNumber.matches("[P]-\\d{3}-\\d{3}-\\d{3}")){
                    return true;
                }
                else{
                    throw new InvalidDataException("Invalid Call Number. Must be P-ddd-ddd-ddd");
                }
            }
    }
        catch(InvalidDataException e){
            System.out.println(e.getMessage());
        }
        return false;
}
/***
	 * Method that finds the title the user enters
	 * @param	titles for the objects of type Title
     * @param	count for the count of # of objects 
     * @param	title for the title
	 * @return	return the indices of the titles that match
	 */
    public int [] findTitle(Title[] titles, int count, String title){
        int [] titlesFound = new int[20];
        int index = 1;
        for(int i = 0; i < count; i++){
            if(titles[i].getTitle().equalsIgnoreCase(title)){
                titlesFound[i] = index;
            }
            index++;
        }
        return titlesFound;
        
    }
   /***
	 * Method that finds the restorable titles in the array
	 * @param	titles for the objects of type Title
     * @param	count for the count of # of objects 
	 * @return	return the indices of the titles that are restorable
	 */
    public int [] findRestorable(Title[] titles, int count){
        int [] titlesFound = new int[40];
        int index = 1;
        for(int i = 0; i < count; i++){
            if(titles[i].isRestorable()){
                titlesFound[i] = index;
            }
            index++;
        }
        return titlesFound;
        
    }
    /***
	 * Method that finds the indices of all titles in a given year
	 * @param	titles for the array of objects 
     * @param	count for the count of # of objects 
     * @param	year for the year of the title
	 * @return	return the index of media
	 */
    public int [] findYear(Title[] titles, int count, int year){
        int [] titlesFound = new int[30];
        int index = 1;
        for(int i = 0; i < count; i++){
            if(titles[i].getYear() == year){
                titlesFound[i] = index;
            }
            index++;
        }
        return titlesFound;
        
    }
    /***
	 * Method that checks if the year the user entered for the title is in the valid range
	 * @param	year for year of title publication
	 * @return	returns a boolean
	 */
    public Boolean checkYear(int year) throws InvalidDataException{
        try{
            if(year >= 1900 && year <= 2022){
                    return true;
                }
                else{
                    throw new InvalidDataException("Invalid Year. Must be between 1900 and 2022");
                }
    }
        catch(InvalidDataException e){
            System.out.println(e.getMessage());
        }
        return false;
}
    /***
	 * Method that checks that the user entered a month in the range 1-12
	 * @param	month for month of title
	 * @return	returns a boolean
	 */
    public Boolean checkMonth(int month) throws InvalidDataException{
        try{
            if(month >= 1 && month <= 12){
                    return true;
                }
                else{
                    throw new InvalidDataException("Invalid Month. Must be between 1 and 12");
                }
    }
        catch(InvalidDataException e){
            System.out.println(e.getMessage());
        }
        return false;
}
 /***
	 * Method that checks that the user entered a book or periodical to add to array
	 * @param	type for type of title
	 * @return	returns a boolean
	 */
    public Boolean checkType(String type) throws InvalidDataException{
        try{
            if(type.equalsIgnoreCase("Book") || type.equalsIgnoreCase("Periodical")){
                    return true;
                }
                else{
                    throw new InvalidDataException("Invalid type. Must be Book or Periodical");
                }
    }
        catch(InvalidDataException e){
            System.out.println(e.getMessage());
        }
        return false;
}
    /***
	 * Method that sorts the array of objects by their year
	 * @param	list for the list of objects 
     * @param   count for the count of objects
	 * @return	no return value
	 */
    public void sortByYear(Title[] list, int count){
        for(int i=1; i<count; i++) {
            //Insert element i in the sorted sub-list
            Title currentVal = list[i];
            int j = i;
            while (j>0 && currentVal.compareTo(list[j - 1]) < 0){
                 // Shift element (j-1) into element (j)
                 list[j] = list[j - 1];
                 j--;
            }
            // Insert currentVal at position j
            list[j] = currentVal;
         }
        }
    /***
	 * Method that gets user input for an int value from 1-9
	 * @param	scnr for user input
	 * @return	returns an int value from 1-9
	 */
    public int getInt(Scanner scnr) {
        boolean correct;
        int choice = 0; 
        do {
            correct = scnr.hasNextInt();
            if (correct == false) {
                System.out.println("You did not enter an integer value");
                scnr.nextLine();
            } else {
                choice = scnr.nextInt();
                if (choice < 1 || choice > 9) {
                    System.out.println("You did not enter a value between 1 and 9 (inclusive)");
                    correct = false;
                }
                scnr.nextLine();
            }
        } while (!correct);
        return choice;
    }    
}

