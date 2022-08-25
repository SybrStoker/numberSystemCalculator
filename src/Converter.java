import java.util.ArrayList;

public class Converter {
    char[] allowedSymbols = {'A', 'B', 'C', 'D', 'E', 'F'};
    char[] lowerCaseSymbols = {'a', 'b', 'c', 'd', 'e', 'f'};
    int[] lettersAsNumbers = {10, 11, 12, 13, 14, 15};

    int parseDecimal(String userInput, int system) {
        ArrayList<Character> digitChar = new ArrayList<>();
        ArrayList<Integer> digitArray = new ArrayList<>();

        for(int i = 0; i < userInput.length(); i++) {
            digitChar.add(userInput.charAt(i));
        }

        for (Character character : digitChar) {
            boolean number = true;
            //exchange a symbol to a number
            for(int i = 0; i < this.allowedSymbols.length;i++){
                if(character.equals(this.allowedSymbols[i]) ||
                        character.equals(this.lowerCaseSymbols[i])) {
                    digitArray.add(this.lettersAsNumbers[i]);
                    number = false;
                    break;
                }
            }

            if(number) {
                digitArray.add(Integer.parseInt(String.valueOf(character)));
            }
        }
        int counter = 0;
        int decimalNumber = 0;
        for(int i = digitArray.size() - 1; i >= 0; i--) {
            decimalNumber += (int) (digitArray.get(i) * Math.pow(system, counter));
            counter++;
        }

        return decimalNumber;
    }
}
