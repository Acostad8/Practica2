package Services;

import Intefaces.OperacionesServices;
import Models.Cajero;
import Models.Empleado;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class CajeroServices implements OperacionesServices {
    private Empleado empleado;
    private Cajero cajero;
    private Scanner sc;
    private ArrayList<Empleado> listaEmpleados;

    public CajeroServices(){
        cajero = new Cajero();
        sc = new Scanner(System.in);
        listaEmpleados = new ArrayList<>();
    }



    @Override
    public void menu() {
        int opcion = 0;
        do {
            System.out.println("-------------MENU DE OPCIONES CAJERO----------------");
            System.out.println("1. Agregar Cajero");
            System.out.println("2. Modificar Cajero");
            System.out.println("3. Eliminar Cajero");
            System.out.println("4. Listar Cajero");
            System.out.println("0. Salir");
            System.out.println("ingrese una opcion del menu");

            try{
                opcion = sc.nextInt();
            }catch (InputMismatchException inputMismatchException){
                sc.nextLine();
                System.out.println("ingrese solo valores numericos");
            }

            switch (opcion){
                case 1:
                    agregar();
                    break;
                case 2:
                    modificar();
                    break;
                case 3:
                    eliminar();
                    break;
                case 4:
                    listar();
                    break;
                case 0:
                    System.out.println("gracias por usar este menu");
                    break;
                default:
                    System.out.println("ingrese solo valores valido de este menu");
                    break;
            }
        }while (opcion != 0);

    }

    @Override
    public Empleado agregar() {
        System.out.println("--------------AGREGAR CAJERO---------------");
        System.out.println("ingrese el documento del Cajero");
        String documento = sc.next();
        for (Empleado empleado : listaEmpleados){
            if (empleado.getDocumento().equals(documento)){
                System.out.println("El documento ya existe en la lista");
                System.out.println("Ingrese un nuevo documento");
                menu();
            }
        }
        System.out.println("ingrese la direccion del Cajero");
        String direccion = sc.next();

        System.out.println("ingrese el nombre del Cajero");
        String nombre = sc.next();

        System.out.println("ingrese el telefono del cajero");
        String telefono = sc.next();

         double sueldoMensual = 0;
         int numeroCaja = 0;
         double ventaMensual = 0;

         try{
             System.out.println("ingrese el sueldo mensual del cajero");
             sueldoMensual  = sc.nextDouble();

             System.out.println("ingrese el numero de caja del Cajero");
             numeroCaja = sc.nextInt();

             System.out.println("ingrese la venta mensual del Cajero");
             ventaMensual = sc.nextDouble();

         }catch (InputMismatchException inputMismatchException){
             sc.nextLine();
             System.out.println("ingrese solo valores numericos");
         }

         cajero = new Cajero(documento,direccion,nombre,telefono,cajero.getSueldo(),sueldoMensual,numeroCaja,ventaMensual);
         cajero.calcularSueldo();

         listaEmpleados.add(cajero);
         System.out.println("se agrego el Cajero con Exito");
         System.out.println(cajero);
         return cajero;
    }

    @Override
    public Empleado modificar() {
        if (listaEmpleados.isEmpty()){
            System.out.println("no existen Cajero para modificar");
            return null;
        }

        System.out.println("----------MODIFICAR DOMICILIARIO----------------");
        System.out.println("ingrese el documento del cajero que desea modificar");
        String Documento = sc.next();
        for (Empleado empleado : listaEmpleados){
            if (empleado.getDocumento().equals(Documento)) {
                System.out.println("Cajero a modificar encontrado: " + cajero);

                System.out.println("---------AGREGAR CAJERO MODIFICADO-----------");
                System.out.println("ingrese el nuevo documento del Cajero");
                String documento = sc.next();
                cajero.setDocumento(documento);


                System.out.println("ingrese la nueva direccion del Cajero");
                String direccion = sc.next();
                cajero.setDireccion(direccion);


                System.out.println("ingrese el nuevo nombre del Cajero");
                String nombre = sc.next();
                cajero.setNombre(nombre);

                System.out.println("ingrese el nuevo telefono del cajero");
                String telefono = sc.next();
                cajero.setTelefono(telefono);

                double sueldoMensual = 0;
                int numeroCaja = 0;
                double ventaMensual = 0;

                try{
                    System.out.println("ingrese el nuevo sueldo mensual del cajero");
                    sueldoMensual  = sc.nextDouble();
                    cajero.setSueldoMensual(sueldoMensual);

                    System.out.println("ingrese el nuevo numero de caja del Cajero");
                    numeroCaja = sc.nextInt();
                    cajero.setNumeroCaja(numeroCaja);

                    System.out.println("ingrese la nueva venta mensual del Cajero");
                    ventaMensual = sc.nextDouble();
                    cajero.setVentaMensual(ventaMensual);

                }catch (InputMismatchException inputMismatchException){
                    sc.nextLine();
                    System.out.println("ingrese solo valores numericos");
                }

                cajero.calcularSueldo();
                System.out.println("se ha modificado el cajero con exito");
                System.out.println(cajero);
                return cajero;
            }
        }
        System.out.println("no se encontro el documento del cajero a modificar");
        return null;
    }

    @Override
    public void eliminar() {
        if (listaEmpleados.isEmpty()){
            System.out.println("no exiten cajero para eliminar");
            return;
        }

        System.out.println("-----------ELIMINAR CAJERO------------");
        System.out.println("ingrese el documento del cajero a eliminar");
        String Documento = sc.next();

        for (Empleado empleado : listaEmpleados){
            if (empleado.getDocumento().equals(Documento)) {
                System.out.println("se encontro el cajeor a eliminar:" + cajero);
                listaEmpleados.remove(empleado);
                System.out.println("se elimino correctamente el cajero");
                return;
            }
        }
        System.out.println("no se encontro el cajero a eliminar");
    }

    @Override
    public void listar() {
        if (listaEmpleados.isEmpty()){
            System.out.println("no exiten cajero para listar");
            return;
        }

        System.out.println("---------LISTA CAJEROS------------");
        int indice = 0;
        for (Empleado empleado : listaEmpleados){
            indice++;
            System.out.println(indice + "." +empleado);
        }

    }
}
