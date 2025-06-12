package controller;

import java.util.Scanner;
import models.Contacto;
import view.ConsoleView;

public class MenuController {
    private ContactManager contactManager;
    private ConsoleView consoleView;

    public MenuController() {
        this.contactManager = new ContactManager();
        this.consoleView = new ConsoleView();
    }

    public void showMenu() {
        int option;
        Scanner scanner = new Scanner(System.in);

        do {
            consoleView.displayMenu();
            System.out.print("Seleccione una opción: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor ingrese un número.");
                scanner.next(); // limpiar entrada inválida
                System.out.print("Seleccione una opción: ");
            }
            option = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (option) {
                case 1 -> addContact(scanner);
                case 2 -> findContact(scanner);
                case 3 -> deleteContact(scanner);
                case 4 -> printList();
                case 0 -> consoleView.showMessage("Saliendo del programa...");
                default -> consoleView.showMessage("Opción inválida. Intente de nuevo.");
            }

        } while (option != 0);

        scanner.close();
    }

    private void addContact(Scanner scanner) {
        String name = consoleView.getInput("Ingrese nombre del contacto: ");
        String phone = consoleView.getInput("Ingrese teléfono del contacto: ");
        contactManager.addContact(new Contacto(name, phone));
        consoleView.showMessage("Contacto agregado.");
    }

    private void findContact(Scanner scanner) {
        String name = consoleView.getInput("Ingrese nombre a buscar: ");
        Contacto found = contactManager.findContactByName(name);
        if (found != null) {
            consoleView.showMessage("Contacto encontrado: " + found.getNombre() + " - " + found.getTelefono());
        } else {
            consoleView.showMessage("Contacto no encontrado.");
        }
    }

    private void deleteContact(Scanner scanner) {
        String name = consoleView.getInput("Ingrese nombre a eliminar: ");
        contactManager.deleteContactByName(name);
    }

    private void printList() {
        contactManager.printList();
    }
}
