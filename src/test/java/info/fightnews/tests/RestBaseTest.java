package info.fightnews.tests;

import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;

/**
 * Created by mlukianenko on 6/8/17.
 */
public class RestBaseTest {

    @BeforeClass
    public static void setup() {
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(80);
        }
        else{
            RestAssured.port = Integer.valueOf(port);
        }


        String basePath = System.getProperty("server.base");
        if(basePath==null){
            basePath = "/all";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if(baseHost==null){
            baseHost = "http://services.groupkt.com/country/get";
        }
        //RestAssured.baseURI = baseHost;

    }
}
