package app;

import utils.DynamicArrayList;

import java.util.Scanner;

/**
 *
 * @author michelle
 */
public class ShoppingList {

    public static void main(String[] args) {
        DynamicArrayList productList = new DynamicArrayList();
        Scanner sc = new Scanner(System.in);


            System.out.println("How many entries you would like to add to your shopping list?");
            int desiredNumOfEntries = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < desiredNumOfEntries; i++) {
                System.out.println("Please enter entry " + (i+1) + ":");
                productList.add(sc.nextLine());
            }


            System.out.println(" Content of your list: ");
            for (int i = 0; i < productList.size(); i++) {
                System.out.println(productList.get(i));
            }

        while (true){
            System.out.println("Would you like to create a shopping list with specified initial capacity?  y-yes, n-no" );
            if (sc.nextLine().equals("y")){
                System.out.println("Please enter desired initial capacity: ");
                int newCapacity = sc.nextInt();
                sc.nextLine();

                DynamicArrayList productListWithSpecifiedCapacity = new DynamicArrayList(newCapacity);

                System.out.println("Please enter the name of the product to add: ");
                String product = sc.nextLine();

                System.out.println("Please enter the position in the list to add: ");
                int pos = sc.nextInt();
                sc.nextLine();

                try {
                    productListWithSpecifiedCapacity.add(product, pos);
                    System.out.println("Product successfully added!");
                } catch (IndexOutOfBoundsException e){
                    System.out.println("As there are no elements in the list, you can not add product with specified index(");
                    System.out.println("Error: " + e.getMessage());
                }


                System.out.println("Do you want to clear(remove all) specified products in the list? y-yes, n-no");
                if (sc.nextLine().equals("y")){
                    System.out.println("Please enter a product to remove from the list: ");
                    if (productListWithSpecifiedCapacity.removeAll(sc.nextLine())){
                        System.out.println("Product(s) were/was removed successfully!");
                    } else {
                        System.out.println("No specified products were found!");
                    }
                }
                System.out.println("Do you need to find the index of last instance of specified product in the list? y-yes, n-no");
                if (sc.nextLine().equals("y")){
                    System.out.println("Please enter a name of product: ");
                    int index = productListWithSpecifiedCapacity.lastIndexOf(sc.nextLine());
                    if (index > -1){
                        System.out.println("Index of last instance of your products is - " + index);
                    } else {
                        System.out.println("No specified product was found!");
                    }

                }
            }

            System.out.println("Repeat the process? y-yes, n-no");
            if (sc.nextLine().equals("n")){
                break;
            }
        }



    }
}
