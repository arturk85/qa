package pl.jsystems.qa.qaapi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.jsystems.qa.qaapi.author.model.Author;
import pl.jsystems.qa.qaapi.author.service.AuthorService;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.hamcrest.Matchers.*;

public class ApiTest {

    AuthorService authorService;

    @BeforeEach
    public void setUp(){
        authorService = new AuthorService();
    }

    @Test
    public void firstApiTest(){
        RestAssured.given().get("https://fakerestapi.azurewebsites.net/api/v1/Activities")
                .then().assertThat().statusCode(200)
                .body("[0].id",equalTo(1))
                .body("[0].title",equalTo("Activity 1"))
                .body("[0].dueDate",startsWith("2021-11"))
                .body("[0].completed",is(false));

    }


    @Test
    public void apiTest(){
        List<Author> author = RestAssured
                .given().get("https://fakerestapi.azurewebsites.net/api/v1/Authors")
                .then().assertThat().statusCode(200)
                .extract()
                .body().jsonPath()
                .getList("",Author.class);

        assertThat(author.get(0).id).isEqualTo(1);
    }


    @Test
    public void authorByIdTest(){
//        Author author = RestAssured
//                .given().get("https://fakerestapi.azurewebsites.net/api/v1/Authors/{id}",1)
//                .then().assertThat().statusCode(200)
//                .extract()
//                .body().jsonPath()
//                .getObject("",Author.class);

//        Response response = RestAssured
//                .given().get("https://fakerestapi.azurewebsites.net/api/v1/Authors/{id}",1)
//                .andReturn();
//
//        Author author = response
//                .then().assertThat().statusCode(200)
//                .extract()
//                .body().jsonPath()
//                .getObject("",Author.class);

        Author author = authorService.getAuthorById(1);
        assertThat(author.id).isEqualTo(1);
        assertThat(author.idBook).isEqualTo(1);
    }

    @Test
    public void authorTest(){
        List<Author> authors = authorService.getAuthors();
        assertThat(authors.get(0).id).isEqualTo(1);
        assertThat(authors.get(0).idBook).isEqualTo(1);
    }

    @Test
    public void postAuthorTest(){
        Author author = Author.builder().firstName("Batman").id(690l)
                .idBook(69l).lastName("Robin").build();
        final Author createdAuthor = authorService.postAuthor(author);
        System.out.println(createdAuthor.toString());

//        assertThat(createdAuthor.getId()).isEqualTo(613);
//        assertThat(createdAuthor.getIdBook()).isEqualTo(200);
    }

    @Test
    public void deleteAuthorTest(){

        authorService.deleteAuthor(1);

//        assertThat(createdAuthor.getId()).isEqualTo(613);
//        assertThat(createdAuthor.getIdBook()).isEqualTo(200);
    }

    @Test
    public void putAuthorTest(){
        Author author = Author.builder().firstName("Batman").id(690l)
                .idBook(69l).lastName("Robin").build();
        authorService.putAuthor(author,222);

//        assertThat(createdAuthor.getId()).isEqualTo(613);
//        assertThat(createdAuthor.getIdBook()).isEqualTo(200);
    }
}
