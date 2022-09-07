import java.util.ArrayList;
import java.util.Collections;

public class Converter {
    private final char[] upperCaseSymbols = {'A', 'B', 'C', 'D', 'E', 'F'};
    private final char[] lowerCaseSymbols = {'a', 'b', 'c', 'd', 'e', 'f'};
    private final int[] lettersAsNumbers = {10, 11, 12, 13, 14, 15};

    public int parseBaseToDecimal(String number, final int base) {
        char[] digitChar = new char[20];
        ArrayList<Integer> digitArray;

        number.getChars(0, number.length(), digitChar, 0);

        digitArray = parseCharsToNumbers(number, digitChar);

        //if don't assign a value to var script doesn't work
        int counter = 0;
        int decimalNumber = 0;
        for(int i = digitArray.size() - 1; i >= 0; i--) {
            decimalNumber += (int) (digitArray.get(i) * Math.pow(base, counter));
            counter++;
        }

        return decimalNumber;
    }

    ArrayList<Integer> parseCharsToNumbers(String number, char[] chars) {
        ArrayList<Integer> arrayOfIntNumbers = new ArrayList<>();

        for (int i = 0; i < number.length(); i++) {
            boolean digit = true;

            //exchange a symbol to a number
            for(int j = 0; j < this.upperCaseSymbols.length;j++){
                if(chars[i] == this.upperCaseSymbols[j] ||
                        chars[i] == this.lowerCaseSymbols[j]) {
                    arrayOfIntNumbers.add(this.lettersAsNumbers[j]);
                    digit = false;
                    break;
                }
            }

            if(digit) {
                arrayOfIntNumbers.add(Integer.parseInt(String.valueOf(chars[i])));
            }
        }

        return arrayOfIntNumbers;
    }

    public String parseDecimalToBase(double decimalNumber, final double base){
        String number;
        ArrayList<Integer> digitArray;

        digitArray = this.divideNumByBase(decimalNumber, base);
        Collections.reverse(digitArray);

        number = this.parseNumbersToString(digitArray);

        return number;
    }

    ArrayList<Integer> divideNumByBase(double decimalNumber, final double base){
        ArrayList<Integer> store = new ArrayList<>();
        double remainder;
        boolean quotientMoreBase = true;

        do{
            remainder = decimalNumber % base;
            store.add((int) remainder);
            decimalNumber /= base;

            if(decimalNumber < base) {
                store.add((int) decimalNumber);
                quotientMoreBase = false;
            }

        } while(quotientMoreBase);

        return store;
    }

    String parseNumbersToString(ArrayList<Integer> digitArray) {
        StringBuilder number = new StringBuilder();

        for (Integer digit : digitArray) {
            boolean lessThan10 = true;

            //exchange a symbol to a number
            for (int j = 0; j < this.lettersAsNumbers.length; j++) {
                if (digit == this.lettersAsNumbers[j]) {
                    number.append(this.upperCaseSymbols[j]);
                    lessThan10 = false;
                    break;
                }
            }

            if (lessThan10) {
                number.append(digit);
            }
        }

        return number.toString();
    }
}

