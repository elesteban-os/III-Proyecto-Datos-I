import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Distance {
    private static final String API_KEY = "AIzaSyBMLdQm4ZQ217hYicRS4vtukNSCPBuMt4o";
    private static String city1 = "";
    private static String city2 = "";

    public static String getDistanceData() throws Exception {
        var url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + city1 + "&destinations=" + city2 + "&key=" + API_KEY;
        var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        var client = HttpClient.newBuilder().build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        System.out.println(url);
        return response;
    }

    public void getDistance(String json, String searching){
        String[] words = json.split(" ");
        int n = 0;
        for(String p : words){
            if (n == 2){
                String[] letters = p.split("");
                StringBuilder result = new StringBuilder();
                for(String c : letters){
                    if (c.contains("\"")){
                        continue;
                    } else if (c.contains(".")) {
                        System.out.println(result);
                        break;                        
                    } else {
                        result.append(c);
                    }
                }
                break;
            } else if (n == 1 || p.contains(searching)){
                n++;
            }
        }
    }

    public String getCity1() {
        return city1;
    }

    public void setCity1(String city1) {
        this.city1 = city1;
    }

    public String getCity2() {
        return city2;
    }

    public void setCity2(String city2) {
        this.city2 = city2;
    }

    public static void main(String[] args) throws Exception {
        Distance distance = new Distance();
        distance.setCity1("Juan+Viñas+Cartago");
        distance.setCity2("Turrialba+Cartago");

        String kms = getDistanceData();
        System.out.println(kms);
        distance.getDistance(kms, "text");
    }
}
