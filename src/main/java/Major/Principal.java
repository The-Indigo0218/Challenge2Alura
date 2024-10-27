package Major;


import Models.ConversionCore;
import Models.ConversionExchangerate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static Util.Help.options;
import static Util.Help.process;

public class Principal {


    public static void main(String[] args) throws IOException, InterruptedException {
        int option = options();
        String url = process(option);
        System.out.println(url);
        client(url);
    }


    private static void client(String url) throws IOException, InterruptedException {
        try {


            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            Gson gson = new GsonBuilder().create();

            ConversionExchangerate dto = gson.fromJson(json, ConversionExchangerate.class);
            ConversionCore conversionCore = new ConversionCore(dto);
            System.out.println(dto);
            System.out.println("conversionCore = " + conversionCore);

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("Algo fue mal");
            throw new RuntimeException(e);
        }

    }

}
