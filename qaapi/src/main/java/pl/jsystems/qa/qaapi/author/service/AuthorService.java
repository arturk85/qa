package pl.jsystems.qa.qaapi.author.service;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.Filter;
import io.restassured.http.*;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.*;
import pl.jsystems.qa.qaapi.author.model.Author;
import pl.jsystems.qa.qaapi.author.spec.AzureSpecification;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.security.KeyStore;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class AuthorService {

    private static final String AUTHORS = "/Authors";
    private static final String AUTHORS_BY_ID = "/Authors/{id}";

    AzureSpecification azureSpec = new AzureSpecification();
    public Author getAuthorById(int id) {
        return getAuthorByIdReponse(id).then().assertThat().statusCode(200)
                .extract()
                .body().jsonPath()
                .getObject("",Author.class);
    }

    public List<Author> getAuthors() {
        return getAuthorsReponse().then().assertThat().statusCode(200)
                .extract()
                .body().jsonPath()
                .getList("",Author.class);
    }

    public Response getAuthorByIdReponse(int id){
        return RestAssured.given()
                .spec(azureSpec.azureSpec())
                .get(AUTHORS_BY_ID,1)
                .andReturn();
    }

    public Response getAuthorsReponse(){
        return RestAssured.given()
                .spec(azureSpec.azureSpec())
                .get(AUTHORS)
                .andReturn();

    }


}
