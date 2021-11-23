package pl.jsystems.qa.qajunit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tags({@Tag("junit"), @Tag("smoke"), @Tag("param")})
@DisplayName("Param test")
public class JavaParamTest {

    @ParameterizedTest(name = "Parameter test with value {0}")
    @ValueSource(ints = {5,15,25})
    public void firstParamTest(int number){
        assertEquals(number % 5,0);

    }

    @ParameterizedTest(name = "Parameter test with string {0}")
    @ValueSource(strings = {"hello","hello junit","helo students"})
    public void stringParamTest(String tekst){
        assertThat(tekst).contains("hello");
    }

    @ParameterizedTest(name = "Parameter test with multi param {0},{1}")
    @CsvSource(value = {"Hello;5","Hello junit;15","Helo students;25"}, delimiter = ';')
    public void multiParamTest(String strParam,int numParam){
        assertThat(strParam).contains("Hello");
        assertEquals(numParam % 5,0);
    }

    @ParameterizedTest(name = "Parameter test with multi param {0},{1}")
    @CsvFileSource(resources = "/plik.csv",delimiter = ',')
    public void multiParamFromFileTest(String strParam,int numParam){
        assertThat(strParam).contains("Hello");
        assertEquals(numParam % 5,0);
    }

    @ParameterizedTest(name = "Enum test {0}")
    @EnumSource(value = ParamEnum.class)
    public void enumParamTest(ParamEnum enumParam){
        assertThat(enumParam.toString()).contains("ENUM");
    }

    enum ParamEnum{
        ENUM_ONE,
        ENUM_TWO
    }
}
