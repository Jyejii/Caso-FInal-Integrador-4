package org.main;
import java.util.*;

public class Agenda {
    private Map<String, Contacto> contactos;

    public Agenda() {
        contactos = new HashMap<>();
    }

    // para agregar un nuevo contacto
    public void agregarContacto(String nombre, String email, String telefono) {
        Contacto contacto = new Contacto(nombre, email, telefono);
        contactos.put(nombre, contacto);
        System.out.println("Contacto agregado correctamente.");
    }

    //eliminar un contacto
    public void eliminarContacto(String nombre) {
        if (contactos.containsKey(nombre)) {
            contactos.remove(nombre);
            System.out.println("Contacto eliminado correctamente.");
        } else {
            System.out.println("El contacto no existe en la agenda.");
        }
    }

    // mostrar todos los contactos
    public void mostrarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            System.out.println("Lista de contactos:");
            for (Map.Entry<String, Contacto> entry : contactos.entrySet()) {
                System.out.println(entry.getValue());
            }
        }
    }

    private class Contacto {
        private String nombre;
        private String email;
        private String telefono;

        public Contacto(String nombre, String email, String telefono) {
            this.nombre = nombre;
            this.email = email;
            this.telefono = telefono;
        }

        @Override
        public String toString() {
            return "Nombre: " + nombre + ", Email: " + email + ", Teléfono: " + telefono;
        }
    }

    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        // Ejemplo de uso
        agenda.agregarContacto("Jiachen", "Jiachenye0@gmail.com", "660660660");
        agenda.agregarContacto("Albert", "Albert@myuax.com", "123456789");

        agenda.mostrarContactos();

        agenda.eliminarContacto("Juan");

        agenda.mostrarContactos();
    }
}
