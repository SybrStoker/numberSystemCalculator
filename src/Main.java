import java.util.Scanner;
public class Main {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        Converter conv = new Converter();

        int choice = 0;
        int sys = 16;
        int num1 = 0;
        int num2 = 0;
        String number1;
        String number2;
        boolean run = true;
        boolean runCase;



        //welcome message
        System.out.println("This program helps u to operate with another numeral systems.");

        //language switch
        do {
            System.out.println("""
                    Choose ur language:
                    1.English
                    2.German""");

            choice = scan.nextInt();
            switch (choice) {
                case 1 -> {
                    //choosing en
                    System.out.println("en");
                    run = false;
                }case 2 -> {
                    //choosing ge
                    System.out.println("ge");
                    run = false;
                }default -> System.out.println("There is no such an option");
            }
        } while(run);

        //main menu
        run = true;
        do {
            //operation switch
            System.out.println("""
                Available operations:
                1. Translation
                2. Common math
                3. Exit""");

            choice = scan.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("""
                1.1 Translate a number from a necessary ns to decimal
                1.2 Translate a decimal number to a necessary ns
                1.3 back""");

                    runCase = true;
                    do {
                        choice = scan.nextInt();
                        switch (choice){
                            case 1 -> {
                                System.out.println("Enter the number");
                                scan.nextLine();
                                number1 = setNumber(scan.nextLine());
                                System.out.println(conv.parseDecimal(number1, sys));
                                runCase = false;
                            }
                            case 2 -> System.out.println("2");
                            case 3 -> runCase = false;
                            default -> System.out.println("There is no such an option");
                        }
                    } while(runCase);
                }case 2 -> {
                    System.out.println("""
                        2.1 Addition
                        2.2 Subtraction
                        2.3 Multiplication
                        2.4 Division
                        2.5 Back""");

                    runCase = true;
                    do {
                        choice = scan.nextInt();
                        switch (choice) {
                            case 1 -> {
                                System.out.println("Enter number");
                                scan.nextLine();
                                number1 = setNumber(scan.nextLine());
                                num1 = conv.parseDecimal(number1, sys);

                                System.out.println("Enter second number");
                                number2 = setNumber(scan.nextLine());
                                num2 = conv.parseDecimal(number2, sys);

                                System.out.println(num1 + num2);
                                runCase = false;
                            }

                            case 2 -> {
                                System.out.println("Enter number");
                                scan.nextLine();
                                number1 = setNumber(scan.nextLine());
                                num1 = conv.parseDecimal(number1, sys);

                                System.out.println("Enter second number");
                                number2 = setNumber(scan.nextLine());
                                num2 = conv.parseDecimal(number2, sys);

                                System.out.println(num1 - num2);
                                runCase = false;
                            }
                            case 3 -> {
                                System.out.println("Enter number");
                                scan.nextLine();
                                number1 = setNumber(scan.nextLine());
                                num1 = conv.parseDecimal(number1, sys);

                                System.out.println("Enter second number");
                                number2 = setNumber(scan.nextLine());
                                num2 = conv.parseDecimal(number2, sys);

                                System.out.println(num1 * num2);
                                runCase = false;
                            }
                            case 4 -> System.out.println("4");
                            case 5 -> runCase = false;
                            default -> System.out.println("There is no such an option");
                        }
                    } while (runCase);
                }case 3 -> run = false;
                default -> System.out.println("There is no such an option");
            }
        } while(run);
    }

    static String setNumber(String number) {
        boolean typo = true;
        char[] allowedSymbols = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'a', 'b', 'c', 'd', 'e', 'f'};

       //limit the input symbols by allowed symbols only
       for(int i = 0; i < number.length(); i++) {
           for(int j =0; j < allowedSymbols.length; j++){
               typo = true;
               if(number.charAt(i) == allowedSymbols[j]) {
                   typo = false;
                   break;
               }
           }

           if(typo){
               return "";
           }
       }
       return number;
    }

    static int setNumber(int number, int limit) {
        return number;
    }
}
