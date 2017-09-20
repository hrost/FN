package info.fightnews.tests;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import org.hamcrest.Matchers.*;

import static com.jayway.restassured.RestAssured.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Created by mlukianenko on 6/7/17.
 */
public class TestRestAPI extends RestBaseTest {

@Test
public void basicPingTest() {
    given().
            contentType("application/json").
            when().
            get("http://jsonplaceholder.typicode.com/users/1").
            then().
                body("id", equalTo(2));
}

}
