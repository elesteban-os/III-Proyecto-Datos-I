package GoogleAPI;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Clase Distancia.
 */
public class Distance {
    private static final String API_KEY = "AIzaSyBMLdQm4ZQ217hYicRS4vtukNSCPBuMt4o";
    private static String city1 = "";
    private static String city2 = "";

    /**
     * Funcion que se conecta a las API de Google y obtiene un JSON con datos que existen entre los dos puntos.
     * @return JSON de los datos.
     * @throws Exception excepción.
     */
    public static String getDistanceData() throws Exception {
        var url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + city1 + "&destinations=" + city2 + "&key=" + API_KEY;
        var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        var client = HttpClient.newBuilder().build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        System.out.println(url);
        return response;
    }
    
    /**
     * Función que obtiene el mensaje de la API y busca la distancia entre dos puntos.
     * @param json mensaje de la API.
     * @param searching elemento que se está buscando.
     * @return retorna la distancia entre dos puntos.
     */
    public String getDistance(String json, String searching){
        String[] words = json.split(" ");
        int n = 0;
        StringBuilder result = new StringBuilder();
        for(String p : words){
            if (n == 2){
                String[] letters = p.split("");
                
                boolean lastDigit = false;
                for(String c : letters){
                    if (c.contains("\"")){
                        continue;
                    } else if (lastDigit){
                        result.append(c);
                        System.out.println(result.toString());
                        break;
                    } else if (c.contains(".")) {
                        result.append(c);
                        lastDigit = true;                       
                    } else {
                        result.append(c);
                    }
                }
                break;
            } else if (n == 1 || p.contains(searching)){
                n++;
            }
        }
        return result.toString();
    }

    /**
     * Hace un set a city1.
     * @param city1 string de la nueva ciudad.
     */
    public void setCity1(String city1) {
        this.city1 = city1;
    }

    /**
     * Hace un set a city2.
     * @param city2 string de la nueva ciudad.
     */
    public void setCity2(String city2) {
        this.city2 = city2;
    }

    public static void main(String[] args) throws Exception {
        Distance distance = new Distance();
        distance.setCity1("San+Jose+San+Jose+Costa+Rica");
        distance.setCity2("Desamparados+San+Jose+Costa+Rica");

        String kms = getDistanceData();
        System.out.println(kms);
        String distancia = distance.getDistance(kms, "text");
        double distDou = Double.parseDouble(distancia);
    }
}
