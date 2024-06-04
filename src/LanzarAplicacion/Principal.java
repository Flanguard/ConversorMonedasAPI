package LanzarAplicacion;

import Conexion.ConectarAPI;
import Conexion.MisMonedas;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

        Scanner lectura = new Scanner(System.in);

        ConectarAPI probando = new ConectarAPI();

        Map<String, Double> monedas = probando.obtenerApi("USD").conversion_rates();

        System.out.println(monedas.get("EUR"));
        System.out.println("Bienvenido al conversor de monedas");
        while(true){
            System.out.println("""
                    **********************************
                    
                    """);
        }


    }
}
