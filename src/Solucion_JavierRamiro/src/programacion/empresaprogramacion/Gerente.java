package programacion.empresaprogramacion;

public class Gerente extends Empleado {
  private String departamento;

  public Gerente(String dni, String nombre, double sueldo, String departamento) throws ParametroInvalidoException {
    super(dni,nombre, sueldo);
    this.departamento = departamento;
  }

  public String getDepartamento() {
    return departamento;
  }

  @Override
  public TipoEmpleado getTipo() {
    return TipoEmpleado.GERENTE;
  }

  @Override
  public String toString() {
    return super.toString() + ", " + departamento;
  }
}
