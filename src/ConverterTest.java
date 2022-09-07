import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {
    static class ParseNumbersToStringTest{
        @Test
        void arrayToHexString() {
            var conv = new Converter();
            ArrayList<Integer> arrayOfIntNumbers = new ArrayList<>();
            arrayOfIntNumbers.add(4);
            arrayOfIntNumbers.add(15);
            arrayOfIntNumbers.add(3);
            arrayOfIntNumbers.add(11);
            arrayOfIntNumbers.add(6);
            assertEquals("4F3B6" , conv.parseNumbersToString(arrayOfIntNumbers));
        }

        @Test
        void arrayToHexString2() {
            var conv = new Converter();
            ArrayList<Integer> arrayOfIntNumbers = new ArrayList<>();
            arrayOfIntNumbers.add(15);
            arrayOfIntNumbers.add(14);
            arrayOfIntNumbers.add(13);
            arrayOfIntNumbers.add(12);
            arrayOfIntNumbers.add(11);
            arrayOfIntNumbers.add(10);
            assertEquals("FEDCBA" , conv.parseNumbersToString(arrayOfIntNumbers));
        }
    }

    static class DivideNumByBaseTest{
        @Test
        void divide3456By16() {
            var conv = new Converter();
            ArrayList<Integer> arrayOfIntNumbers = new ArrayList<>();
            arrayOfIntNumbers.add(0);
            arrayOfIntNumbers.add(8);
            arrayOfIntNumbers.add(13);
            assertEquals(arrayOfIntNumbers , conv.divideNumByBase(3456,16));
        }

        @Test
        void divide1234673By16() {
            var conv = new Converter();
            ArrayList<Integer> arrayOfIntNumbers = new ArrayList<>();
            arrayOfIntNumbers.add(1);
            arrayOfIntNumbers.add(15);
            arrayOfIntNumbers.add(6);
            arrayOfIntNumbers.add(13);
            arrayOfIntNumbers.add(2);
            arrayOfIntNumbers.add(1);
            assertEquals(arrayOfIntNumbers , conv.divideNumByBase(1234673,16));
        }

    }

    static class ParseDecimalToBaseTest {

        @Test
        void binary() {
            var conv = new Converter();
            assertEquals("100100101001", conv.parseDecimalToBase(2345, 2));
        }

        @Test
        void base3() {
            var conv = new Converter();
            assertEquals("11200212", conv.parseDecimalToBase(3425, 3));
        }

        @Test
        void base4() {
            var conv = new Converter();
            assertEquals("203222113203", conv.parseDecimalToBase(9348579, 4));
        }

        @Test
        void base5() {
            var conv = new Converter();
            assertEquals("2430144", conv.parseDecimalToBase(45674, 5));
        }

        @Test
        void base6() {
            var conv = new Converter();
            assertEquals("400502043", conv.parseDecimalToBase(6757803, 6));
        }

        @Test
        void base7() {
            var conv = new Converter();
            assertEquals("560456", conv.parseDecimalToBase(98678, 7));
        }

        @Test
        void octal() {
            var conv = new Converter();
            assertEquals("374554", conv.parseDecimalToBase(129388, 8));
        }

        @Test
        void base9() {
            var conv = new Converter();
            assertEquals("8532662", conv.parseDecimalToBase(4568456, 9));
        }

        @Test
        void decimal() {
            var conv = new Converter();
            assertEquals("4359879", conv.parseDecimalToBase(4359879, 10));
        }

        @Test
        void base11() {
            var conv = new Converter();
            assertEquals("5A5300", conv.parseDecimalToBase(958683, 11));
        }

        @Test
        void base12() {
            var conv = new Converter();
            assertEquals("2346B4" , conv.parseDecimalToBase(567784, 12));
        }

        @Test
        void base13() {
            var conv = new Converter();
            assertEquals("C1AA5" , conv.parseDecimalToBase(346754, 13));
        }

        @Test
        void base14() {
            var conv = new Converter();
            assertEquals("A29DB60" , conv.parseDecimalToBase(76754664, 14));
        }

        @Test
        void base15() {
            var conv = new Converter();
            assertEquals("76AED2" , conv.parseDecimalToBase(5656472, 15));
        }

        @Test
        void hex() {
            var conv = new Converter();
            assertEquals("149C32F9" , conv.parseDecimalToBase(345780985, 16));
        }
    }

    static class ParseBaseToDecimalTest {

        @Test
        void binary() {
            var conv = new Converter();
            assertEquals(61 , conv.parseBaseToDecimal("0111101", 2));
        }

        @Test
        void base3() {
            var conv = new Converter();
            assertEquals(208 , conv.parseBaseToDecimal("021201", 3));
        }

        @Test
        void base4() {
            var conv = new Converter();
            assertEquals(3227 , conv.parseBaseToDecimal("302123", 4));
        }

        @Test
        void base5() {
            var conv = new Converter();
            assertEquals(14236 , conv.parseBaseToDecimal("423421", 5));
        }

        @Test
        void base6() {
            var conv = new Converter();
            assertEquals(827 , conv.parseBaseToDecimal("3455", 6));
        }

        @Test
        void base7() {
            var conv = new Converter();
            assertEquals(1861 , conv.parseBaseToDecimal("5266", 7));
        }

        @Test
        void octal() {
            var conv = new Converter();
            assertEquals(14719 , conv.parseBaseToDecimal("34577", 8));
        }

        @Test
        void base9() {
            var conv = new Converter();
            assertEquals(1880 , conv.parseBaseToDecimal("2518", 9));
        }

        @Test
        void decimal() {
            var conv = new Converter();
            assertEquals(4359879 , conv.parseBaseToDecimal("4359879", 10));
        }

        @Test
        void base11() {
            var conv = new Converter();
            assertEquals(1223 , conv.parseBaseToDecimal("A12", 11));
        }

        @Test
        void base12() {
            var conv = new Converter();
            assertEquals(335 , conv.parseBaseToDecimal("23B", 12));
        }

        @Test
        void base13() {
            var conv = new Converter();
            assertEquals(4965 , conv.parseBaseToDecimal("234C", 13));
        }

        @Test
        void base14() {
            var conv = new Converter();
            assertEquals(44561 , conv.parseBaseToDecimal("1234D", 14));
        }

        @Test
        void base15() {
            var conv = new Converter();
            assertEquals(114558 , conv.parseBaseToDecimal("23E23", 15));
        }

        @Test
        void hex() {
            var conv = new Converter();
            assertEquals(255 , conv.parseBaseToDecimal("FF", 16));
        }

        @Test
        void hexBigNumber() {
            var conv = new Converter();
            assertEquals(16702650 , conv.parseBaseToDecimal("FEDCBA", 16));
        }

        @Test
        void hexBigNumberLowerCase() {
            var conv = new Converter();
            assertEquals(16702650 , conv.parseBaseToDecimal("fedcba", 16));
        }
    }
}

