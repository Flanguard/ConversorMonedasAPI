package LanzarAplicacion;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        //Variables para pasar a la clase dependencia
        Scanner keyboard = new Scanner(System.in);
        boolean trueFalse = true;
        dependencia dependencia = new dependencia();
        int opcion;
        //Variable del menu
        String menu = """
                    Bienvenido al conversor de monedas\n
                    **********************************
                    1) Peso Dominicano a Dolar Estadounidense
                    2) Dolar Estadounidense a Peso Dominicano
                    3) Peso Dominicano a Euros
                    4) Euro a Peso Dominicano
                    5) Salir
                    **********************************
                    """;

        //Iniciar el programa
        while(true) {
            System.out.println(menu);
            System.out.println("Cual opcion elige?");
            while(!keyboard.hasNextInt()){
                System.out.println(menu);
                keyboard.next();
            }
            opcion = keyboard.nextInt();
            if (opcion  >= 5 || opcion <=0){
                break;
            }
            //LLamar a la dependencia
            System.out.println(dependencia.lanzar(opcion));

        }
    }
}
