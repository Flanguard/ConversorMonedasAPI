package LanzarAplicacion;

import Conexion.ConectarAPI;
import Conexion.MisMonedas;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        DecimalFormat format = new DecimalFormat("#.##");
        boolean trueFalse = true;
        double conversion;

        ConectarAPI probando = new ConectarAPI();
        Map<String, Double> monedas;
        System.out.println("Bienvenido al conversor de monedas");
        while(trueFalse){
            System.out.println("""
                    **********************************
                    1) Peso Dominicano a Dolar Estadounidense
                    2) Dolar Estadounidense a Peso Dominicano
                    3) Peso Dominicano a Euro
                    4) Euro a Peso Dominicano
                    5) Salir
                    **********************************
                    """);
            System.out.println("Cual opcion elige?");
            int opcion = lectura.nextInt();
            switch (opcion){
                case 1:
                    System.out.print("Que valor desea convertir: ");
                    conversion = lectura.nextDouble();
                    monedas =  probando.obtenerApi("DOP").conversion_rates();
                    System.out.println("El equivalente en dolares es: " + format.format(conversion * monedas.get("USD"))+" USD");
                    break;
                case 2:
                    System.out.print("Ingrese un valor: ");
                    conversion = lectura.nextDouble();
                    monedas =  probando.obtenerApi("USD").conversion_rates();
                    System.out.println(monedas.get("USD"));
                    System.out.println("El equivalente en pesos dominicanos es: " + format.format(conversion * monedas.get("DOP"))+" DOP");
                    break;
                case 3:
                    System.out.print("Ingrese un valor: ");
                    conversion = lectura.nextDouble();
                    monedas =  probando.obtenerApi("DOP").conversion_rates();
                    System.out.println("El equivalente en Euros es: " + format.format(conversion * monedas.get("EUR"))+" EUR");
                    break;
                case 4:
                    System.out.print("Ingrese un valor: ");
                    conversion = lectura.nextDouble();
                    monedas =  probando.obtenerApi("EUR").conversion_rates();
                    System.out.println("El equivalente en pesos dominicanos es: " + format.format(conversion * monedas.get("DOP"))+" DOP");
                    break;
                default:
                    trueFalse = false;
            }
        }
    }
}
