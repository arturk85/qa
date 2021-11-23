package pl.jsystems.qa.qajunit;


import static org.junit.jupiter.api.Assertions.*;
import static com.google.common.truth.Truth.*;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Tags({@Tag("junit"),@Tag("schooltest")})
@DisplayName("jsystem test")
public class JunitTest {

    final String STRING_TESTOWY = "testowo";

    @BeforeAll
    public static void beforeAll(){
        System.out.println("=====beforeAll=====");
        System.out.println("hahaha");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("=====afterAll=====");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("====beforeEach====");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("====afterEach=====");
    }

    @Tag("myfirst")
    @Test
    public void firstTest(){


        assertEquals(2 + 3,5);
        assertEquals("testowo",STRING_TESTOWY);
        assertTrue(STRING_TESTOWY.contains("test"));

    }

    @Test
    public void junitTest(){
        System.out.println();
        double result = new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue();
        assertEquals(result , 0.04);
    }

    @Test
    public void stringTest(){
        String simpleString = "simpleString";
        String simple = "simpleString";

        String simpleString_2 = new String("simpleString");
        String simpleString_3 = new String("simpleString");

        assertSame("simpleString", simpleString);
        assertSame(simple, simpleString);
        assertSame(simple, simpleString);
        assertNotSame(simple, simpleString_2);

        assertTrue(simpleString == simple);
        assertFalse(simpleString == simpleString_3,"wiadomosc");
        assertTrue(simpleString.equals(simpleString_3));

        assertEquals(simple , simpleString);

        assertEquals(simpleString, simpleString_2);

        assertEquals(simpleString_3 , simpleString_2);

    }

    @Test
    public void googleThruthTest(){
        assertThat(STRING_TESTOWY).contains("owo");
    }

    @Tag("zad1")
    @Test
    public void zadanie1(){
        String resultString = "Wordpress powers 100% of the internet";
        String expectedString = "Wordpress powers [number]% of the internet";

        assertThat(resultString).startsWith("Wordpress powers ");
        assertThat(resultString).endsWith("% of the internet");
        assertThat(resultString).matches("Wordpress powers \\d+% of the internet");
        String result = resultString.replace("Wordpress powers ","").replace("% of the internet","");
        assertThat(result).matches("\\d+$");
        int intResult = new Integer(result);
        assertThat(intResult).isLessThan(102);
    }

    @Tags({@Tag("nested"),@Tag("myfirst")})
    @DisplayName("Nested")
    @Nested
    public class NestedTest{

        @Test
        public void listTest(){
            List<Integer> result = Arrays.asList(1,2,3,4,5);
            List<Integer> expected = Arrays.asList(3,4,5);

        }

        @Test
        public void exceptionTest(){
            final GamePlay gamePlay = new GamePlay();
            Assertions.assertThrows(IllegalArgumentException.class,()->gamePlay.play(0));
        }
    }
}
