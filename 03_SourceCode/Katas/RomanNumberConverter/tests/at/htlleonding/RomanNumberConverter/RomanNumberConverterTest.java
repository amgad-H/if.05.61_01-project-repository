package at.htlleonding.RomanNumberConverter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * unit test for simple App
 */

public class RomanNumberConverterTest {
    /*
     * Rigoures Test
     * */

    @Test
    public void itShouldReturnI_Given1(){
        assertEquals("I", RomanNumberConverter.toRoman(1));
    }

    @Test
    public void itShouldReturnII_Given2() {
        assertEquals("II", RomanNumberConverter.toRoman(2));
    }

    @Test
    public void itShouldReturnV_Given5(){
        assertEquals("V", RomanNumberConverter.toRoman(5));
    }

    @Test
    void itShouldReturnVIs_GivenBetween6And8() {
        assertEquals("VI", RomanNumberConverter.toRoman(6));
        assertEquals("VII", RomanNumberConverter.toRoman(7));
    }

    @Test
    public void itShouldReturnX_Given10(){
        assertEquals("X", RomanNumberConverter.toRoman(10));
    }

    @Test
    public void itShouldReturnXXI_Given21(){
        assertEquals("XXI", RomanNumberConverter.toRoman(21));
    }

    @Test
    public void itShouldReturnIV_Given4(){
        assertEquals("IV", RomanNumberConverter.toRoman(4));
    }

    @Test
    public void itShouldReturnIX_Given9(){
        assertEquals("IX", RomanNumberConverter.toRoman(9));
    }



    @Test
    public void itShouldReturn1_GivenI(){
        assertEquals(1, RomanNumberConverter.toArabic("I"));
    }

    @Test
    public void itShouldReturn2_GivenII(){
        assertEquals(2, RomanNumberConverter.toArabic("II"));
    }

    @Test
    public void itShouldReturn3_GivenIII(){
        assertEquals(3, RomanNumberConverter.toArabic("III"));
    }

    @Test
    public void itShouldReturn4_GivenIV(){
        assertEquals(4, RomanNumberConverter.toArabic("IV"));
    }

    @Test
    public void itShouldReturn5_GivenV(){
        assertEquals(5, RomanNumberConverter.toArabic("V"));
    }

    @Test
    public void itShouldReturn6And7_GivenVIAndVII(){
        assertEquals(6, RomanNumberConverter.toArabic("VI"));
        assertEquals(7, RomanNumberConverter.toArabic("VII"));
    }

    @Test
    public void itShouldReturn10_GivenX(){
        assertEquals(10, RomanNumberConverter.toArabic("X"));
    }

    @Test
    public void itShouldReturn21_GivenXXI(){
        assertEquals(21, RomanNumberConverter.toArabic("XXI"));
    }

    @Test
    public void itShouldReturn9_GivenIX(){
        assertEquals(9, RomanNumberConverter.toArabic("IX"));
    }


}
