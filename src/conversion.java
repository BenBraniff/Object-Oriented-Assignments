import java.util.Scanner;
public class conversion {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int i = 0;

            display();

            System.out.println("Enter your desired conversion number:");
            i = scanner.nextInt();

            if(i != 1 && i != 2 && i != 3 && i != 4 && i != 5) {
                System.out.println("your number was not one of the options");
                i = 5;
            }
            int j = 0;
            switch(i) {
                case 1:
                    j = 1;
                    while(j == 1) {
                        System.out.println("Enter the weight (in pounds) you would like to convert into kilograms.");
                        int pounds = scanner.nextInt();
                        convertPounds(pounds);
                        System.out.println("Would you like to continue? (1 = Yes; 2 = No)");
                        j = scanner.nextInt();
                    }
                    break;
                
                case 2:
                    j = 1;
                    while(j == 1) {
                        System.out.println("Enter the weight (in grams) you would like to convert into ounces.");
                        int Grams = scanner.nextInt();
                        convertGrams(Grams);
                        System.out.println("Would you like to continue? (1 = Yes; 2 = No)");
                        j = scanner.nextInt();
                    }
                    break;   
                
                case 3:
                    j = 1;
                    while(j == 1) {
                        System.out.println("Enter the length (in feet) you would like to convert into meters.");
                        int Feet = scanner.nextInt();
                        convertFeet(Feet);
                        System.out.println("Would you like to continue? (1 = Yes; 2 = No)");
                        j = scanner.nextInt();
                    }
                    break; 
                
                case 4:
                    j = 1;
                    while(j == 1) {
                        System.out.println("Enter the length (in inches) you would like to convert into centimeters.");
                        int inches = scanner.nextInt();
                        convertInches(inches);
                        System.out.println("Would you like to continue? (1 = Yes; 2 = No)");
                        j = scanner.nextInt();
                    }
                    break;
                    
                case 5:
                    break; 
            }
        }
    }

    public static void convertPounds(int pounds) {
        double kg;
        kg = (pounds * .4536);
        System.out.println(pounds + " pounds = " + kg + " kilograms");
    }

    public static void convertGrams(int grams) {
        double oz;
        oz = (grams * .03527);
        System.out.println(grams + " grams = " + oz + " ounces");
    }

    public static void convertFeet(int feet) {
        double meters;
        meters = (feet * .3048);
        System.out.println(feet + " feet = " + meters + " feet");
    }

    public static void convertInches(int inches) {
        double centimeters;
        centimeters = (inches * 2.54);
        System.out.println(inches + " inches = " + centimeters + " centimeters");
    }

    public static void display() {
        System.out.println("Hello! Welcome to my conversion program!");
        System.out.println("This program allows you to do four types of conversions!");
        System.out.println("1 is pounds to kilograms");
        System.out.println("2 is grams to ounces");
        System.out.println("3 is feet to meters");
        System.out.println("4 is inches to centimeters");
        System.out.println("5 is to exit conversion \n");
    }
}