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
                int k = 0;                
                boolean lastDigit = false;
                for(String c : letters){
                    if (c.contains("\"")){
                        continue;
                    } else if (lastDigit || (k == 2 && !c.contains("."))){
                        result.append(c);
                        break;                    
                    } else if (c.contains(".")){
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
     * Hace un set a city1 y city2.
     * @param city1 string de la nueva ciudad.
     * @param city2 string de la nueva ciudad.
     */
    public void setCities(String city1, String city2) {
        Distance.city1 = changeName(city1);
        Distance.city2 = changeName(city2);
    }

    private String changeName(String name) {
        char[] letters = name.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char letter : letters) {
            if (letter == ' ') {
                result.append("+");
            } else {
                result.append(letter);
            }
        }
        result.append("+San+José+Costa+Rica");
        return String.valueOf(result);
    }

    public static void main(String[] args){
        Distance a = new Distance();
        String ex = "\"text\" : \"136 km\",";
        System.out.println(a.getDistance(ex, "\"text\""));


    }
}
