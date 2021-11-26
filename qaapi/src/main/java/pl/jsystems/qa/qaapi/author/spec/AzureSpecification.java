package pl.jsystems.qa.qaapi.author.spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static pl.jsystems.qa.qaapi.author.config.ApiConfig.AZURE_BASE_PATH;

public class AzureSpecification {

    private static final String BASE_URI = "/api/v1/";
    public RequestSpecification azureSpec() {
        RequestSpecification spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization","ApiKey")
                .setBasePath(BASE_URI)
                .setBaseUri(AZURE_BASE_PATH)
                .build();
        return spec;
    }
}
