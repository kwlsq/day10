package org.vincent.entity.menu;

import org.vincent.entity.material.Book;
import org.vincent.entity.material.DVD;
import org.vincent.entity.material.Magazine;
import org.vincent.entity.material.MaterialImpl;
import org.vincent.entity.user.Role;
import org.vincent.entity.user.UserImpl;

import java.util.*;

public class Library {
    private final Scanner scanner = new Scanner(System.in);
    HashMap<UUID, MaterialImpl> materialList = new HashMap<>();


    public void libraryPrompt(Role role, UserImpl currentUser) {
        materialList.put(UUID.randomUUID(), new Book("Math", 1));
        materialList.put(UUID.randomUUID(), new DVD("Black panther", 2));
        materialList.put(UUID.randomUUID(), new Magazine("Tempo", 3 ));

        while (true) {
            if (role == Role.ADMIN) {
                System.out.println("1. View materials");
                System.out.println("2. Add materials");
                System.out.println("3. User management");
                System.out.println("4. Logout");
            } else {
                System.out.println("1. View materials to Borrow");
                System.out.println("2. Borrow materials");
                System.out.println("3. Return materials");
                System.out.println("4. Logout");
            }

            System.out.println("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();
            System.out.print("\033[H\033[2J");

            switch (option) {
                case 1 -> viewMaterials();
                case 2 -> {
                    if (role == Role.ADMIN) {
                        addMaterials();
                    } else {
                        borrowMaterials(currentUser);
                    }
                }
                case 3 -> {
                    if (role == Role.ADMIN) {
//                        userManagement();
                    } else {
                        returnMaterial(currentUser);
                    }
                }
//                case 5 -> logout();
                default -> System.out.println("Invalid option");
            }
        }
    }

    public void viewMaterials() {
        System.out.println("\nMaterials List:");
        if (!materialList.isEmpty()) {
            int index = 1;
            for (MaterialImpl material : materialList.values()) {
                System.out.println(index + ". " + material.getTitle() + " | " + (!material.getIsAvailable() ? "not available" : "Stock : " + material.getStock()));
                index++;
            }
            System.out.println("\n");
        } else {
            System.out.println("========= No Materials yet ==========\n");
        }
    }

    public void addMaterials() {
        UUID materialID = getMaterialUUIDByIndex("add");
        System.out.print("Add material type: ");
//        System.out.print("Enter material type: ");
    }

    public void borrowMaterials(UserImpl currentUser) {
        UUID materialID = getMaterialUUIDByIndex("borrow");
        MaterialImpl selectedMaterial = materialList.get(materialID);

        if (selectedMaterial.getIsAvailable()) {
            selectedMaterial.borrow(currentUser);
            System.out.println(selectedMaterial.getTitle() + " successfully borrowed.");
        } else {
            System.out.println("Material is not available to borrow.");
        }
    }

    public void returnMaterial(UserImpl currentUser) {
        UUID materialID = getMaterialUUIDByIndex("return");
        MaterialImpl selectedMaterial = materialList.get(materialID);

        if(selectedMaterial.getBorrowedBy().contains(currentUser.getName())){
            selectedMaterial.returnBorrow(currentUser);
            System.out.println(selectedMaterial.getTitle() + " successfully returned.");
        }else{
            System.out.println("You haven't borrowed this material");
        }
    }

    private UUID getMaterialUUIDByIndex(String action) {
        viewMaterials();
        if (materialList.isEmpty()) {
            return null;
        }

        System.out.print("Select Material to " + action + " (number): ");
        int selectedIndex = scanner.nextInt();
        scanner.nextLine();

        List<UUID> materialKeys = new ArrayList<>(materialList.keySet());

        if (selectedIndex > 0 && selectedIndex <= materialKeys.size()) {
            return materialKeys.get(selectedIndex - 1);
        } else {
            System.out.println("Invalid material number. Try again.");
            return null;
        }
    }


}
