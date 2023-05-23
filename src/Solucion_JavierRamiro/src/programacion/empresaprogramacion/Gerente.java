package programacion.empresaprogramacion;

public class Gerente extends Empleado {
  public static final String CSV_SEPARATOR = ";";
  public static final String CSV_RUTA_FICHERO = "gerentes.csv";
  public static final Integer CSV_NUMERO_DE_CAMPOS = 4;

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

  @Override
  public int compareTo(Empleado o) {
    return getSueldo().compareTo(o.getSueldo());
  }

  
}
