import java.util.Scanner;

import programacion.empresaprogramacion.Empleado;
import programacion.empresaprogramacion.Empresa;
import programacion.empresaprogramacion.Gerente;
import programacion.empresaprogramacion.ParametroInvalidoException;
import programacion.empresaprogramacion.TipoEmpleado;

public class MainEmpresaProgramadores {
  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    Empresa empresa = new Empresa("Empresa del Juan de la Cierva");
    // int opcion = 0;

    // String parametros = "";

    Empleado referencia;

    // referencia = new Programador(parametros);
    // empresa.addEmpleado(referencia);

    // referencia = new Programador(parametros);
    // empresa.addEmpleado(referencia);

    try {
      referencia = new Gerente("01234567A", "Perico Palotes", 5000, "R&D");
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println("Excepción capturada: " + e.getMessage());
    }

    try {
      referencia = new Gerente("01234568B", "Benito Camelos", 50000, "Sales");
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println("Excepción capturada: " + e.getMessage());
    }

    try {
      referencia = new Gerente("01234568B", "Benito Camelos", 50000, "Sales");
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println("Excepción capturada: " + e.getMessage());
    }

    // referencia = new Programador(parametros);
    // empresa.addEmpleado(referencia);

    // referencia = new Programador(parametros);
    // empresa.addEmpleado(referencia);

    // referencia = new Programador(parametros);
    // empresa.addEmpleado(referencia);

    // referencia = new Programador(parametros);
    // empresa.addEmpleado(referencia);

    System.out.println("############### Empresa.toString():\n");
    System.out.println(empresa);
    System.out.println("###############\n");

    empresa.cargarGerentesDesdeCSV("F:/INVENT.csv");
    empresa.cargarGerentesDesdeCSV(Gerente.CSV_RUTA_FICHERO);

    System.out.println("############### SEGUNDO: Empresa.toString():\n");
    System.out.println(empresa);
    System.out.println("###############\n");

    TipoEmpleado variable = TipoEmpleado.GERENTE;
    System.out.println("variable=" + variable+ ", variable.ordinal()=" + variable.ordinal());
    variable = TipoEmpleado.PROGRAMADOR;
    System.out.println("variable=" + variable+ ", variable.ordinal()=" + variable.ordinal());

    variable = TipoEmpleado.valueOf("GERENTE");
    System.out.println("variable=" + variable+ ", variable.ordinal()=" + variable.ordinal());

    String cadenaTipo = "GERENTE";

    if(cadenaTipo.compareTo("G")==0){
      variable = TipoEmpleado.GERENTE;
    } else if(cadenaTipo.compareTo("P")==0){
      variable = TipoEmpleado.PROGRAMADOR;
    }

    // do {
    // imprimirMenu();
    // opcion = scanner.nextInt();
    // scanner.nextLine(); // Limpiar buffer

    // switch (opcion) {

    // case 1:
    // // Imprimir todos los empleados
    // empresa.toStringEmpleados();
    // break;

    // case 2:
    // // Imprimir programadores
    // empresa.toStringProgramadores();
    // break;

    // case 3:
    // // Imprimir empleados por sueldo de MAYOR A MENOR
    // empresa.toStringOrdenSueldo();
    // break;

    // case 4:
    // // Imprimir empleados por nombre
    // empresa.toStringOrdenNombre();
    // break;

    // case 5:
    // // Cargar desde CSV
    // System.out.println("Ingrese el nombre del archivo CSV a cargar:");
    // String archivoCargar = scanner.nextLine();
    // empresa.cargarDesdeCSV(archivoCargar);
    // break;

    // case 6:
    // // Guardar en CSV
    // System.out.println("Ingrese el nombre del archivo CSV para guardar:");
    // String archivoGuardar = scanner.nextLine();
    // empresa.guardarEnCSV(archivoGuardar);
    // break;

    // case 7:
    // System.out.println("Saliendo...");
    // break;

    // default:
    // System.out.println("Opción inválida");
    // break;
    // }

    // } while (opcion != 7);

    // scanner.close();
  }

  private static void imprimirMenu() {
    System.out.println("### Menú Empresa ###");
    System.out.println("1. Imprimir todos los empleados");
    System.out.println("2. Imprimir todos los programadores");
    System.out.println("3. Imprimir empleados por sueldo");
    System.out.println("4. Imprimir empleados por nombre");
    System.out.println("5. Cargar desde fichero CSV");
    System.out.println("6. Guardar en CSV");
    System.out.println("7. Salir");
    System.out.println("Introduce una opción:");
  }
}
