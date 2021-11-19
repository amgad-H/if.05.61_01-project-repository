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

        if(roman == "V") {
            arabic += 5;
        }
        if(roman == "IV") {
            arabic += 4;
        }
        if(roman == "III") {
            arabic += 3;
        }
        if(roman == "II") {
            arabic += 2;
        }
        if(roman == "I") {
            arabic += 1;
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
