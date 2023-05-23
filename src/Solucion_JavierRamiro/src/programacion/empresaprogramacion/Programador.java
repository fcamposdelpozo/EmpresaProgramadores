package programacion.empresaprogramacion;

public class Programador extends Empleado {
  private String lenguaje;
  private boolean plusIdioma;

  public Programador(String nombre) {
      super(nombre, sueldo);
  }

  public String getLenguaje() {
      return lenguaje;
  }

  public boolean recibePlusIdioma() {
      return plusIdioma;
  }

  @Override
  public TipoEmpleado getTipo() {
      return TipoEmpleado.PROGRAMADOR;
  }

  @Override
  public String toString() {
      return super.toString() + ", " + lenguaje + ", " + (plusIdioma?"si":"no") + " sabe idiomas";
  }
}
