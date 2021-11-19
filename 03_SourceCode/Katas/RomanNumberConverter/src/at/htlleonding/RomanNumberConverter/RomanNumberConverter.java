/*----------------------------------------------------------
 *                HTBLA-Leonding / Class: < 3CHIF >
 * ---------------------------------------------------------
 * Exercise Number: 0
 * Title:
 * Author: Amgad Hammash
 * ----------------------------------------------------------
 * Description:
 * ----------------------------------------------------------
 */
package at.htlleonding.RomanNumberConverter;

public class RomanNumberConverter {

    public static String toRoman(int arabicNumber) {
        var romanNumber = "";
        for (var numeral : Numeral.values()){
            while (arabicNumber >= numeral.mArabic) {
                romanNumber += numeral.mRoman;
                arabicNumber -= numeral.mArabic;
            }
        }
        return romanNumber;
    }

    public static int toArabic(String roman) {
        int arabic = 0;
        int romanLength = roman.length();

        for (int i = 0; i < romanLength ; i++){


            for(var num : Numeral.values()){
                char firstRomanChar = roman.charAt(i);;
                char secondRomanChar = 0;
                if (i < romanLength-1){
                    firstRomanChar = roman.charAt(i);
                    secondRomanChar = roman.charAt(i+1);
                    if((Character.toString(firstRomanChar) + Character.toString(secondRomanChar)).equals(num.mRoman)){
                        arabic += num.mArabic;
                        i++;
                    }
                }

                if(Character.toString(firstRomanChar).equals(num.mRoman)){
                    arabic += num.mArabic;
                }
            }
        }
        return arabic;
    }


    enum Numeral{
        TEN(10,"X"),
        NINE(9, "IX"),
        FIVE(5, "V"),
        FOUR(4, "IV"),
        ONE(1, "I");

        private final int mArabic;
        private final String mRoman;

        Numeral(int arabic, String roman) {

            mArabic = arabic;
            mRoman = roman;
        }
    }
}
