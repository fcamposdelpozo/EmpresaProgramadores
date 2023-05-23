package programacion.empresaprogramacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Empresa {
  private String nombre;
  // private List<Empleado> empleados;
  private Map<String, Empleado> empleados;

  public Empresa(String nombre) {
    this.nombre = nombre;
    this.empleados = new TreeMap<>();
  }

  @Override
  public String toString() {
    String cadena = "";
    cadena = "Empresa '" + nombre + "'\n";
    cadena += toStringEmpleados();
    return cadena;
  }

  public void addEmpleado(Empleado empleado) throws ParametroInvalidoException {
    // empleados.add(empleado);
    if (empleados.containsKey(empleado.getDni())) {
      throw new ParametroInvalidoException("El empleado con dni '" + empleado.getDni()
          + "' ya está registrado");
    }
    empleados.put(empleado.getDni(), empleado);
  }

  public String toStringEmpleados() {
    String cadena = "";

    // ArrayList<Empleado> listaEmpleados = new ArrayList<>(empleados.values());

    for (Empleado empleado : empleados.values()) {
      cadena += empleado + "\n";
    }
    return cadena;
  }

  public void toStringProgramadores() {
    for (Empleado empleado : empleados.values()) {
      if (empleado.getTipo() == TipoEmpleado.PROGRAMADOR) {
        System.out.println(empleado);
      }
    }
  }

  // public void toStringOrdenSueldo() {
  // Collections.sort(empleados, );

  // for (Empleado empleado : empleados) {
  // System.out.println(empleado);
  // }
  // }

  // public void toStringOrdenNombre() {
  // Collections.sort(empleados, new Comparator<Empleado>() {
  // @Override
  // public int compare(Empleado emp1, Empleado emp2) {
  // return emp1.getNombre().compareTo(emp2.getNombre());
  // }
  // });

  // for (Empleado empleado : empleados) {
  // System.out.println(empleado);
  // }
  // }
  public void cargarGerentesDesdeCSV(String archivo) {
    int contadorLineas = 0;
    String linea;
    try (BufferedReader lectorConBuffer = new BufferedReader(new FileReader(archivo))) {
      while ((linea = lectorConBuffer.readLine()) != null) {
        contadorLineas++;
        if(contadorLineas == 1){
          //Ignoramos la cabecera
          continue;
        }
        
        String[] camposDeLinea = linea.split(Gerente.CSV_SEPARATOR);
        if (camposDeLinea.length != Gerente.CSV_NUMERO_DE_CAMPOS) {
          System.out.println("Error: número de campos inválido");
          continue;
        }

        Double sueldo = 0.0;
        try {
          sueldo = Double.parseDouble(camposDeLinea[2]);
        } catch (NullPointerException e) {
          System.out.println("Error parseando el campo sueldo: NULL");
          continue;
        } catch (NumberFormatException e) {
          System.out.println("Error parseando el campo sueldo: '" + camposDeLinea[2] + "'");
          continue;
        }

        Gerente gerente = null;
        try {
          gerente = new Gerente(camposDeLinea[0], camposDeLinea[1], sueldo, camposDeLinea[3]);
        } catch (ParametroInvalidoException e) {
          System.out.println("Excepción capturada creando gerente desde CSV: " + e.getMessage());
          continue;
        }

        try {
          addEmpleado(gerente);
        } catch (ParametroInvalidoException e) {
          System.out.println("Excepción capturada agregando gerente a la empresa: " + e.getMessage());
        }

      }
    } catch (FileNotFoundException e) {
      System.out.println("Excepción capturada, no se ha encontrado el fichero '" + archivo + "': " + e.getMessage() );
    } catch (IOException e){
      System.out.println("IOException capturada: " + e.getMessage() );
    }
  }

  // public void cargarDesdeCSV(String archivo) {
  // try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
  // String linea;
  // while ((linea = br.readLine()) != null) {
  // String[] partes = linea.split(",");
  // if (partes.length != 5) {
  // throw new ParametroInvalidoException("Número incorrecto de parámetros en la
  // línea: " + linea);
  // }

  // String tipoStr = partes[0];
  // String nombre = partes[1];
  // double sueldo = Double.parseDouble(partes[2]);
  // String lenguaje = partes[3];
  // Boolean.parseBoolean(partes[4]);

  // TipoEmpleado tipo = TipoEmpleado.valueOf(tipoStr.toUpperCase());

  // Empleado empleado;
  // if (tipo == TipoEmpleado.GERENTE) {
  // String departamento = lenguaje;
  // empleado = new Gerente(nombre, sueldo, departamento);
  // } else if (tipo == TipoEmpleado.PROGRAMADOR) {
  // empleado = new Programador(nombre);
  // } else {
  // throw new ParametroInvalidoException("Tipo de empleado inválido en la línea:
  // " + linea);
  // }

  // empleados.add(empleado);
  // }
  // System.out.println("Datos cargados desde el archivo CSV correctamente.");
  // } catch (IOException e) {
  // System.out.println("Error al leer el archivo CSV: " + e.getMessage());
  // } catch (NumberFormatException e) {
  // System.out.println("Error al convertir el sueldo a número en el archivo CSV:
  // " + e.getMessage());
  // } catch (ParametroInvalidoException e) {
  // System.out.println("Error en los parámetros del archivo CSV: " +
  // e.getMessage());
  // } catch (IllegalArgumentException e) {
  // System.out.println("Error en el tipo de empleado en el archivo CSV: " +
  // e.getMessage());
  // }
  // }

  // public void guardarEnCSV(String archivo) {
  // try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
  // for (Empleado empleado : empleados) {
  // String tipoStr = empleado.getTipo().name().toLowerCase();
  // String nombre = empleado.getNombre();
  // double sueldo = empleado.getSueldo();
  // String lenguaje = "";
  // String plusIdioma = "";

  // if (empleado.getTipo() == TipoEmpleado.GERENTE) {
  // Gerente gerente = (Gerente) empleado;
  // lenguaje = gerente.getDepartamento();
  // } else if (empleado.getTipo() == TipoEmpleado.PROGRAMADOR) {
  // Programador programador = (Programador) empleado;
  // lenguaje = programador.getLenguaje();
  // plusIdioma = String.valueOf(programador.recibePlusIdioma());
  // }

  // String linea = tipoStr + "," + nombre + "," + sueldo + "," + lenguaje + "," +
  // plusIdioma;
  // bw.write(linea);
  // bw.newLine();
  // }
  // System.out.println("Datos guardados en el archivo CSV correctamente.");
  // } catch (IOException e) {
  // System.out.println("Error al escribir en el archivo CSV: " + e.getMessage());
  // }
  // }

}