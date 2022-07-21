
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class HTTPSTest {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Usage: "+HTTPSTest.class.getName()+" <host> <port>");
            System.exit(1);
        }
        HTTPSTest httpTest = new HTTPSTest();
        httpTest.get("https://"+args[0] + ":" + args[1]);
    }
    public void get(String uri) throws Exception {
        Properties props = System.getProperties();
        props.setProperty("jdk.internal.httpclient.disableHostnameVerification", Boolean.TRUE.toString());
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }

}

