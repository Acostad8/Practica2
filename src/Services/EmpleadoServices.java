package Services;

import Intefaces.OperacionesServices;
import Models.Domiciliario;
import Models.Empleado;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmpleadoServices  {

    private Empleado empleado;
    private CajeroServices cajeroServices;
    private DomiciliarioServices domiciliarioServices;
    private Scanner sc;
    private ArrayList<Empleado> listaEmpleado;

    public EmpleadoServices(){
        cajeroServices = new CajeroServices();
        domiciliarioServices = new DomiciliarioServices();
        listaEmpleado = new ArrayList<>();
        sc = new Scanner(System.in);
    }


    public void menu() {
        int opcion = -1;

        do {
            System.out.println("---------MENU DE OPCIONES--------------");
            System.out.println("1. Agregar Cajero");
            System.out.println("2. Agregar Domiciliario");
            System.out.println("0. Salir");
            System.out.println("ingrese una opcion del menu");

            try{
                opcion = sc.nextInt();
            }catch (InputMismatchException inputMismatchException){
                sc.nextLine();
                System.out.println("ingrese solo valores numericos");
            }

            switch(opcion){
                case 1:
                    cajeroServices.menu();
                    break;
                case 2:
                    domiciliarioServices.menu();
                    break;
                case 0:
                    System.out.println("gracias por usar este menu");
                    break;
                default:
                    System.out.println("ingrese solo valores validos del menu");
                    break;
            }
        }while (opcion != 0);

    }
}
