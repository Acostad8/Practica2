package Intefaces;

import Models.Empleado;

import java.util.ArrayList;

public interface OperacionesServices {
    void menu();
    Empleado agregar();
    Empleado modificar();
    void eliminar();
    void listar();
}
