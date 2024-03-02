
import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class TalHRanMTalB_Stress extends Simulation {

  private HttpProtocolBuilder httpProtocol = http
    .baseUrl("http://localhost:8081")
    .inferHtmlResources(AllowList(), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*\\.svg", ".*detectportal\\.firefox\\.com.*"))
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("en-US,en;q=0.9,he-IL;q=0.8,he;q=0.7")
    .contentTypeHeader("application/x-www-form-urlencoded")
    .originHeader("http://localhost:8081")
    .upgradeInsecureRequestsHeader("1")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36");
  
  private Map<CharSequence, String> headers_0 = Map.ofEntries(
    Map.entry("Cache-Control", "max-age=0"),
    Map.entry("Sec-Fetch-Dest", "document"),
    Map.entry("Sec-Fetch-Mode", "navigate"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("Sec-Fetch-User", "?1"),
    Map.entry("sec-ch-ua", "Chromium\";v=\"122\", \"Not(A:Brand\";v=\"24\", \"Google Chrome\";v=\"122"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows")
  );


  private ScenarioBuilder scn = scenario("TalHRanMTalB_Stress")
    .exec(
      http("request_0")
        .post("/Tal-Hasson/response.jsp")
        .headers(headers_0)
        .formParam("name", "Tal Hasson")
    );

  {
	   setUp(scn.injectOpen(
			constantUsersPerSec(30).during(10),
			constantUsersPerSec(60).during(10),
			constantUsersPerSec(80).during(20),
			constantUsersPerSec(90).during(40),
			constantUsersPerSec(100).during(40),
			constantUsersPerSec(90).during(30),
			constantUsersPerSec(100).during(40),
			constantUsersPerSec(90).during(30),
			constantUsersPerSec(50).during(10),
			constantUsersPerSec(20).during(10),
			rampUsersPerSec(20).to(0).during(1)
        ).protocols(httpProtocol));
  }
}


