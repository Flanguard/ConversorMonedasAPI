package LanzarAplicacion;

import Conexion.ConectarAPI;
import CreadorDeArchivos.CrearArchivos;
import GuardarDatosAplicacion.GuardarDatos;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class dependencia {
    private String lanzador;
    Scanner keyboard = new Scanner(System.in);
    DecimalFormat formatador = new DecimalFormat("#.##");
    double conversion;
    double guardarCalculo;
    GuardarDatos guardar;
    List<GuardarDatos> guardarDatos = new ArrayList<>();
    Map<String, Double> monedas;
    CrearArchivos archivar;
    ConectarAPI conectarApi = new ConectarAPI();

    public String lanzar(int opcion) {
            System.out.print("Que valor desea convertir: ");
            while(!keyboard.hasNextDouble()){
                System.out.print("Que valor desea convertir: ");
                keyboard.next();
            }
            conversion = keyboard.nextDouble();
            switch (opcion) {
                case 1:
                    monedas = conectarApi.obtenerApi("DOP").conversion_rates();
                    guardarCalculo = Double.parseDouble(formatador.format(conversion * monedas.get("USD")));
                    guardar = new GuardarDatos("Peso Dominicano a Dolar", "USD", "DOP", conversion, guardarCalculo);
                    guardarDatos.add(guardar);
                    lanzador = "\nEl equivalente en dolares es: " + guardarCalculo + " USD\n";
                    break;
                case 2:
                    monedas = conectarApi.obtenerApi("USD").conversion_rates();
                    guardarCalculo = Double.parseDouble(formatador.format(conversion * monedas.get("DOP")));
                    guardar = new GuardarDatos("Dolar a Peso Dominicano", "DOP", "USD", conversion, guardarCalculo);
                    guardarDatos.add(guardar);
                    lanzador = "\nEl equivalente en pesos dominicanos es: " + guardarCalculo + " DOP\n";
                    break;
                case 3:
                    monedas = conectarApi.obtenerApi("DOP").conversion_rates();
                    guardarCalculo = Double.parseDouble(formatador.format(conversion * monedas.get("EUR")));
                    guardar = new GuardarDatos("Peso Dominicano a Euro", "EUR", "DOP", conversion, guardarCalculo);
                    guardarDatos.add(guardar);
                    lanzador = "\nEl equivalente en Euros es: " + guardarCalculo + " EUR\n";
                    break;
                case 4:
                    monedas = conectarApi.obtenerApi("EUR").conversion_rates();
                    guardarCalculo = Double.parseDouble(formatador.format(conversion * monedas.get("DOP")));
                    guardar = new GuardarDatos("Euro a Peso Dominicano", "DOP", "EUR", conversion, guardarCalculo);
                    guardarDatos.add(guardar);
                    lanzador = "\nEl equivalente en pesos dominicanos es: " + guardarCalculo + " DOP\n";
                    break;
                default:
                    lanzador = "Opcion no valida, el programa procedera a cerrarse\n";
            }
            //LLamar a la clase GuardarDatos para crear el archivo.
            try {
                archivar = new CrearArchivos(guardarDatos);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return lanzador;
        }
}