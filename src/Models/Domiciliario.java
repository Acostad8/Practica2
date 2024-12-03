package Models;

public class Domiciliario extends Empleado{
    private int cantidadDomicilios;
    private double valorDomicilio;
    private String placaVehiculo;

    public Domiciliario() {

    }

    public Domiciliario(int cantidadDomicilios, double valorDomicilio, String placaVehiculo) {
        this.cantidadDomicilios = cantidadDomicilios;
        this.valorDomicilio = valorDomicilio;
        this.placaVehiculo = placaVehiculo;
    }

    public Domiciliario(String documento, String direccion, String nombre, String telefono, double sueldo, int cantidadDomicilios, double valorDomicilio, String placaVehiculo) {
        super(documento, direccion, nombre, telefono, sueldo);
        this.cantidadDomicilios = cantidadDomicilios;
        this.valorDomicilio = valorDomicilio;
        this.placaVehiculo = placaVehiculo;
    }

    public int getCantidadDomicilios() {
        return cantidadDomicilios;
    }

    public void setCantidadDomicilios(int cantidadDomicilios) {
        this.cantidadDomicilios = cantidadDomicilios;
    }

    public double getValorDomicilio() {
        return valorDomicilio;
    }

    public void setValorDomicilio(double valorDomicilio) {
        this.valorDomicilio = valorDomicilio;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    @Override
    public void calcularSueldo() {
        setSueldo(cantidadDomicilios * valorDomicilio);
    }

    @Override
    public String toString() {
        return "Domiciliario{" +
                "documento='" + getDocumento() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", sueldo=" + getSueldo() + '\'' +
                ", cantidadDomicilios=" + cantidadDomicilios + '\'' +
                ", valorDomicilio=" + valorDomicilio + '\'' +
                ", placaVehiculo='" + placaVehiculo + '\'' +
                '}';
    }


}
