import java.util.*;
import java.io.*;

public class SistemaCitas {
    // Listas para almacenar doctores, pacientes y citas
    static ArrayList<String> doctores = new ArrayList<>();
    static ArrayList<String> pacientes = new ArrayList<>();
    static ArrayList<String> citas = new ArrayList<>();

    static final String USUARIO = "Diego2u";
    static final String CONTRASENA = "Computación en java";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean accesoValido = false;
        while (!accesoValido) {
            System.out.print("Ingrese usuario: ");
            String usuario = scanner.nextLine();
            System.out.print("Ingrese contraseña: ");
            String contrasena = scanner.nextLine();

            if (usuario.equals(USUARIO) && contrasena.equals(CONTRASENA)) {
                accesoValido = true;
            } else {
                System.out.println("Usuario o contraseña incorrectos. Intente nuevamente.");
            }
        }

        boolean continuar = true;

        while (continuar) {
            System.out.println("Menu:");
            System.out.println("1. Dar de alta doctores");
            System.out.println("2. Dar de alta pacientes");
            System.out.println("3. Crear cita");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            String opcion = scanner.nextLine();

            if (opcion.equals("1")) {
                darAltaDoctor(scanner);
            } else if (opcion.equals("2")) {
                darAltaPaciente(scanner);
            } else if (opcion.equals("3")) {
                crearCita(scanner);
            } else if (opcion.equals("4")) {
                continuar = false;
            } else {
                System.out.println("Opción no válida.");
            }
        }

        scanner.close();
        System.out.println("Sistema cerrado.");
    }

    // Dar de alta a los doctores
    public static void darAltaDoctor(Scanner scanner) {
        System.out.print("ID del doctor: ");
        String id = scanner.nextLine();
        System.out.print("Nombre del doctor: ");
        String nombre = scanner.nextLine();
        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();

        String doctor = id + "," + nombre + "," + especialidad;
        doctores.add(doctor);
        guardarEnArchivo("doctores.csv", doctor);
        System.out.println("Doctor registrado con éxito.");
    }

    // Dar de alta pacientes
    public static void darAltaPaciente(Scanner scanner) {
        System.out.print("ID del paciente: ");
        String id = scanner.nextLine();
        System.out.print("Nombre del paciente: ");
        String nombre = scanner.nextLine();

        String paciente = id + "," + nombre;
        pacientes.add(paciente);
        guardarEnArchivo("pacientes.csv", paciente);
        System.out.println("Paciente registrado con éxito.");
    }

    // Citas
    public static void crearCita(Scanner scanner) {
        System.out.print("ID de la cita: ");
        String id = scanner.nextLine();
        System.out.print("Fecha y hora de la cita: ");
        String fechaHora = scanner.nextLine();
        System.out.print("Motivo de la cita: ");
        String motivo = scanner.nextLine();

        System.out.print("ID del doctor: ");
        String doctorId = scanner.nextLine();
        System.out.print("ID del paciente: ");
        String pacienteId = scanner.nextLine();

        String cita = id + "," + fechaHora + "," + motivo + "," + doctorId + "," + pacienteId;
        citas.add(cita);
        guardarEnArchivo("citas.csv", cita);
        System.out.println("Cita creada con éxito.");
    }

    // Guardar en archivo
    public static void guardarEnArchivo(String nombreArchivo, String contenido) {
        try {
            FileWriter fw = new FileWriter(nombreArchivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error al guardar en el archivo: " + e.getMessage());
        }
    }
}