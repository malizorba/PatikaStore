import java.util.Scanner;

public class StoreMenu {
    Scanner input = new Scanner(System.in);

    public void run(){
        while (true){
            System.out.println();
            System.out.println("Patika store management panel");

            System.out.println("1 - Notebook ");
            System.out.println("2 - Mobile Phone");
            System.out.println("3 - List Brands");
            System.out.println("0 - Exit");

            System.out.println(" Your selection");

            int selection=input.nextInt();

            String [] brands= {"Samsung","Lenovo","Apple","Huawei","Casper","Asus","HP","Xiaomi","Monster"};

            int index=0;
            for (String brand:brands) {
                Brand.addBrand(brand,index++);
            }
            boolean isExit=false;

            switch (selection){
                case 1:
                    System.out.println("Notebook");
                    Product.processMenu(1);
                case 2:
                    System.out.println("Mboile phone");
                    Product.processMenu(2);
                case 3:
                    System.out.println("Listing Brands");
                    Brand.printBrands();
                case 0:
                    isExit=true;
                default:
                    System.out.println();
                    System.out.println("Your selection is wrong ! Try again");
                    System.out.println();
            }
            if (isExit){
                System.out.println();
                System.out.println("You have left store");
                return;
            }
        }

    }
}
