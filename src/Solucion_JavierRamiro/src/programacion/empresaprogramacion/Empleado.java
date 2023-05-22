package programacion.empresaprogramacion;

import java.util.Comparator;

public abstract class Empleado {
  private String dni;
  private String nombre;
  private Double sueldo;

  public static final Comparator<Empleado> COMPARADOR_EMPLEADO_SUELDO = new Comparator<Empleado>() {
    @Override
    public int compare(Empleado emp1, Empleado emp2) {
      return emp1.sueldo.compareTo(emp2.sueldo);
    }
  };


  public Empleado(String dni, String nombre, double sueldo) throws ParametroInvalidoException {
    if(dni == null || dni.isEmpty()){
      throw new ParametroInvalidoException("dni inválido: " + dni);
    }
    this.dni = dni;
    this.nombre = nombre;
    this.sueldo = sueldo;
  }

  public String getNombre() {
    return nombre;
  }

  public Double getSueldo() {
    return sueldo;
  }

  public abstract TipoEmpleado getTipo();

  @Override
  public String toString() {
    return dni + ", " + nombre + ", " + sueldo + " euros/año";
  }

  public String getDni() {
    return dni;
  }
}
