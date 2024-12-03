package Services;

import Intefaces.OperacionesServices;
import Models.Domiciliario;
import Models.Empleado;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DomiciliarioServices implements OperacionesServices {
    private Empleado empleado;
    private Domiciliario domiciliario;
    private Scanner sc;
    private ArrayList<Empleado> listaempleados;

    public DomiciliarioServices(){
        domiciliario = new Domiciliario();
        sc = new Scanner(System.in);
        listaempleados = new ArrayList<>();
    }

    @Override
    public void menu() {
        int opcion = 0;
        do {
            System.out.println("---------------MENU DOMICILIARIO---------------");
            System.out.println("1. Agregar Domiciliario");
            System.out.println("2. Modificar Domiciliario");
            System.out.println("3. Eliminar Domiciliario");
            System.out.println("4. Listar Domiciliario");
            System.out.println("0. salir");
            System.out.println("Ingrese una opcion del Menu");

            try{
                opcion = sc.nextInt();
            }catch (InputMismatchException inputMismatchException){
                sc.next();
                System.out.println("ingrese solo valores numericos");
            }

            switch(opcion){
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
                    System.out.println("ingrese una opcion valida de este menu");
                    break;
            }
        }while (opcion != 0);
    }

    @Override
    public Empleado agregar() {

        System.out.println("----------AGREGAR DOMICILIARO---------------");
        System.out.println("ingrese documento del domiciliario");
        String documento = sc.next();
        for (Empleado empleado : listaempleados){
            if (empleado.getDocumento().equals(documento)){
                System.out.println("el documento ya esta en la lista");
                System.out.println("porfavor agrege un documento diferente");
                menu();
            }
        }

        System.out.println("ingrese la direccion del domiciliario");
        String direccion = sc.next();

        System.out.println("ingrese el nombre del domiciliario");
        String nombre = sc.next();

        System.out.println("ingrese el telefono del domiciliario");
        String telefono = sc.next();

        int cantidadDomicilios = 0;
        double valorDomicilio = 0;

        try{
            System.out.println("ingrese la cantidad de domicilios");
            cantidadDomicilios = sc.nextInt();

            System.out.println("ingrese el valor del domiclio");
            valorDomicilio = sc.nextDouble();
        }catch (InputMismatchException inputMismatchException){
            sc.next();
            System.out.println("ingrese solo valores numericos");
        }
        System.out.println("ingrese la placa del vehiculo");
        String placaVehiculo = sc.next();

        domiciliario = new Domiciliario(documento,direccion,nombre,telefono,domiciliario.getSueldo(),cantidadDomicilios,valorDomicilio,placaVehiculo);
        domiciliario.calcularSueldo();
        listaempleados.add(domiciliario);
        System.out.println("domiciliario agregado con exito");
        return domiciliario;
    }

    @Override
    public Empleado modificar() {
        if (listaempleados.isEmpty()){
            System.out.println("no existen Domiciliarios para modificar");
            return null;
        }

        System.out.println("----------MODIFICAR DOMICILIARIO-------------");
        System.out.println("ingrese el documento del domiciliario a modificar");
        String Documento = sc.next();
        for (Empleado empleado : listaempleados){
            if (empleado.getDocumento().equals(Documento)) {
                System.out.println("Domiciliaro a modificar encontrado :" + empleado);

                System.out.println("----------AGREGAR DOMICILIARO MODIFICADO---------------");
                System.out.println("ingrese nuevo documento del domiciliario");
                String documento = sc.next();
                domiciliario.setDocumento(documento);


                System.out.println("ingrese la nueva direccion del domiciliario");
                String direccion = sc.next();
                domiciliario.setDireccion(direccion);


                System.out.println("ingrese el nuevo nombre del domiciliario");
                String nombre = sc.next();
                domiciliario.setNombre(nombre);


                System.out.println("ingrese el nuevo telefono del domiciliario");
                String telefono = sc.next();
                domiciliario.setTelefono(telefono);


                int cantidadDomicilios = 0;
                double valorDomicilio = 0;

                try{
                    System.out.println("ingrese la nueva cantidad de domicilios");
                    cantidadDomicilios = sc.nextInt();
                    domiciliario.setCantidadDomicilios(cantidadDomicilios);

                    System.out.println("ingrese el valor del domiclio");
                    valorDomicilio = sc.nextDouble();
                    domiciliario.setValorDomicilio(valorDomicilio);

                }catch (InputMismatchException inputMismatchException){
                    sc.next();
                    System.out.println("ingrese solo valores numericos");
                }
                System.out.println("ingrese la nueva placa del vehiculo");
                String placaVehiculo = sc.next();
                domiciliario.setPlacaVehiculo(placaVehiculo);


                domiciliario.calcularSueldo();
                System.out.println("se ha modificado correctamente el domiciliaro");

                System.out.println(domiciliario);
                return domiciliario;
            }
        }
        System.out.println("no se encontro el documento del domiciliario a modificar");
        return null;
    }

    @Override
    public void eliminar() {
        if (listaempleados.isEmpty()){
            System.out.println("no existen domiciliarios a eliminar");
            return;
        }
        System.out.println("----------ELIMINAR DOMICILIARIO---------------");
        System.out.println("ingrese el documento del domiciliario a eliminar");
        String Documento = sc.next();

        for(Empleado empleado : listaempleados){
            if (empleado.getDocumento().equals(Documento)) {
                System.out.println("se encontro del domiciliario a eliminar: " + empleado);
                listaempleados.remove(empleado);
                System.out.println("se elimino correctamente el domiciliario");
                return;
            }
        }
        System.out.println("no se econtro el domiciliario a eliminar ");
    }

    @Override
    public void listar() {
        if (listaempleados.isEmpty()){
            System.out.println("no existen Domiciliarios a listar");
            return;
        }
        System.out.println("----------LISTA DE DOMICILIARIOS----------");
        for (Empleado empleado : listaempleados){
            System.out.println(empleado);

        }
    }
}
