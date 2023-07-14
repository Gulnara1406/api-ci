package ru.netology.rest;

import org.hamcrest.core.StringContains;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

class MobileBankApiTestV1 {
    @Test
    void shouldReturnDemoAccounts() {
      // Given - When - Then
      // Предусловия
      given()
          .baseUri("http://localhost:9999/api/v1")
      // Выполняемые действия
      .when()
          .get("/demo/accounts")
      // Проверки
      .then()
              .statusCode(200)
              // static import для JsonSchemaValidator.matchesJsonSchemaInClasspath
              .body(matchesJsonSchemaInClasspath("accounts.schema.json"))
              .body("[1].currency", equalTo("USD"));
    }
}
