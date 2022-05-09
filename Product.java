import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Product {
    static Scanner input=new Scanner(System.in);

    private int id;
    private static int idNotebook=0;
    private static int idMobilePhone=0;

    private double unitPrice;
    private double discountRate;
    private int stock;

    private String model;
    private String nameBrand;
    private String productName;
    private Brand brand;

    private int storage;
    private double screenSize;
    private double camera;
    private int battery;
    private int Ram;
    private String colour;

    private static HashMap<String, ArrayList<Product>>products=new HashMap<>(){{
        put("Notebook",new ArrayList<Product>());
        put("Mobilephone",new ArrayList<Product>());
    }};

    public Product(int id, double unitPrice, double discountRate, int stock, String model, String nameBrand, int storageInput, double screenSizeInput, int storage, int screenSize, int Ram, String colourInput){
        this.id=id;
        this.unitPrice=unitPrice;
        this.discountRate=discountRate;
        this.stock=stock;
        this.model=model;
        this.nameBrand=nameBrand;
        this.brand=new Brand(nameBrand);
        this.storage=storage;
        this.screenSize=screenSize;
        this.Ram=Ram;
    }
    public Product(int id, double unitPrice, double discountRate, int stock, String model, String nameBrand, int storage, double screenSize, int camera){
        this.id=id;
        this.unitPrice=unitPrice;
        this.discountRate=discountRate;
        this.stock=stock;
        this.model=model;
        this.nameBrand=nameBrand;
        this.storage=storage;
        this.screenSize=screenSize;
        this.camera=camera;
        this.battery=battery;
        this.Ram=Ram;
        this.colour=colour;
    }
    public static void processMenu(int num){
        if (num==1){
            System.out.println();
            System.out.println("Notebook");
        }else {
            System.out.println();
            System.out.println("Mobile phone");
        }
        System.out.println("--------------");
        System.out.println("1 - List Items");
        System.out.println("2 - Add Items");
        System.out.println("3 - Delete Items");
        System.out.println("4 - Filter Items");
        System.out.println("Please select that you want!");
        int select=input.nextInt();
        System.out.println();

        switch (select){
            case 1 : listItems(num);
            case 2 : addItems(num);
            case 3 : deleteItems(num);
            case 4 : filterItems(num);
            default:{
                System.out.println();
                System.out.println("selection that has been entered is wrong");
                processMenu(num);
            }
        }
    }
    public static void listItems(int num){
        if (num%2!=0){
            //Notebook
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println("| ID | Product Name                   | Price      | Brand      | Storage    | Screen Size  | RAM        |");
            System.out.println("----------------------------------------------------------------------------------------------------------");
            ArrayList<Product>productList=products.get("Notebook");
            if (!productList.isEmpty()){
                for (Product product:productList) {
                    String productName = product.getNameBrand() + " " + product.getModel();
                    product.setProductName(productName);

                    System.out.printf("| %-2s | %-30s | %-10s TL | %-10s|%-10s |%-12s | %-10s |\n", product.getId(), product.getProductName(), product.getUnitPrice(), product.getNameBrand(), product.getStorage(), product.getScreenSize(), product.getRam());
                }
                System.out.println("---------------------------------------------------------------------------------------------");
                }
            System.out.println();
            }else {
            // Mobilephone
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("| ID | Product Name                   | Price      | Brand      | Storage    | Screen Size  | Camera     | Battery    | RAM        | COLOR      |");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");

            ArrayList<Product> productList = products.get("MobilePhone");

            if (!productList.isEmpty()) {
                for (Product product : productList) {
                    String productName = product.getNameBrand() + " " + product.getModel();
                    product.setProductName(productName);

                    System.out.printf("| %-2s | %-30s| %-10s TL | %-10s| %-10s| %-12s | %-10s | %-10s | %-10s | %-10s |\n" ,
                            product.getId(), product.getProductName(), product.getUnitPrice(), product.getNameBrand(),
                            product.getStorage(), product.getScreenSize(), product.getCamera(), product.getBattery(), product.getRam(), product.getColour());
                }
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");

            }
            System.out.println();

        }
    }
    public static void addItems(int num){
        System.out.print("Unit Price: ");
        double unitPriceInput = input.nextDouble();
        System.out.print("Discount Rate: ");
        double discountRateInput = input.nextDouble();
        System.out.print("Stock: ");
        int stockInput = input.nextInt();
        System.out.print("Brand: ");
        String brandInput = input.next();
        input.nextLine();
        System.out.print("Model: ");
        String modelInput = input.nextLine();
        System.out.print("Storage: ");
        int storageInput = input.nextInt();
        System.out.print("Screen Size: ");
        double screenSizeInput = input.nextDouble();
        System.out.print("RAM: ");
        int RAMInput = input.nextInt();

        if (num%2 != 0){
            idNotebook=idNotebook+1;
            int id=idNotebook;

            Product newNotebook= new Product(id,unitPriceInput,discountRateInput,stockInput,modelInput,brandInput,storageInput, screenSizeInput,RAMInput);
            products.get("Notebook").add(newNotebook);
        }else {
            //Monilephone
            idMobilePhone=idMobilePhone+1;
            int id=idMobilePhone;

            System.out.print("Camera: ");
            int cameraInput = input.nextInt();
            System.out.print("Battery Capacity: ");
            int batteryInput = input.nextInt();
            input.nextLine();
            System.out.print("Colour: ");
            String colourInput = input.nextLine();

            Product newMobilePhone = new Product(id, unitPriceInput, discountRateInput, stockInput, modelInput, brandInput, storageInput, screenSizeInput, cameraInput, batteryInput, RAMInput, colourInput);
            products.get("MobilePhone").add(newMobilePhone);

        }
    }
    public static void deleteItems(int num){
        System.out.println("Please enter Id that you want to delete");
        int idProduct=input.nextInt();
        boolean notExist=true;
        if (num%2 !=0){
            for (Product product:products.get("Notebook")) {
                if (product.getId()==idProduct){
                    notExist=false;
                    System.out.println("This product"+idProduct+"has been deleted");
                    break;
                }

            }
        }else {
            for (Product product:products.get("Mobile phone")){
                if (product.getId()==idProduct){
                    notExist=false;
                    System.out.println("ID"+idProduct+"has been deleted");
                    break;
                }
            }
        }
        if (notExist){
            System.out.println("Id is not found, try again");
        }
    }
    public static void filterItems(int num){
        System.out.println("Enter ıd to filter product if you do not want please enter 0");
        int idProduct=input.nextInt();
        boolean idExists=idProduct!=0;

        System.out.println("Enter brand to filter products or no");
        String brandProduct=input.next();
        boolean brandExists = !brandProduct.equals("no");

        ArrayList<Product>filteredProducts=new ArrayList<>();

        if (num%2 !=0){
            if (idExists && brandExists){
                for (Product product:products.get("Notebook")) {
                    if (brandProduct.equals(product.getNameBrand())&& product.getId()==idProduct){
                        filteredProducts.add(product);
                        listFilteredItems(num,filteredProducts);
                        break;

                    }else {
                        System.out.println("Id value or brand is wrong");
                        filterItems(num);
                    }
                }
            }else {
                if (brandExists){
                    for (Product product:products.get("Notebook")) {
                        if (brandProduct.equals(product.getNameBrand())){
                            filteredProducts.add(product);
                        }

                    }
                    listFilteredItems(num,filteredProducts);
                }else {
                    System.out.println("Brand could not found");
                    filterItems(num);
                }
            }
        }
    }
    private static void listFilteredItems(int num,ArrayList<Product>filteredProductList){
        if (num%2!=0){
            //Notebook
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            System.out.println("| ID | Product Name                   | Price           | Brand      | Storage    | Screen Size  | RAM        |");
            System.out.println("---------------------------------------------------------------------------------------------------------------");

            if (!filteredProductList.isEmpty()) {
                for (Product product : filteredProductList) {
                    System.out.printf("| %-2s | %-30s| %-15s TL | %-10s| %-10s| %-12s | %-10s |\n",
                            product.getId(), product.getProductName(), product.getUnitPrice(), product.getNameBrand(),
                            product.getStorage(), product.getScreenSize(), product.getRam());
                }
                System.out.println("---------------------------------------------------------------------------------------------------------------");
            }
            System.out.println();

        } else {
            // Mobile phone
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("| ID | Product Name                   | Price           | Brand      | Storage    | Screen Size  | Camera     | Battery    | RAM        | COLOR      |");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");

            if (!filteredProductList.isEmpty()) {
                for (Product product : filteredProductList) {
                    System.out.printf("| %-2s | %-30s| %-15s TL | %-10s| %-10s| %-10s | %-12s | %-10s | %-10s | %-10s |\n" ,
                            product.getId(), product.getProductName(), product.getUnitPrice(), product.getNameBrand(),
                            product.getStorage(), product.getScreenSize(), product.getCamera(), product.getBattery(), product.getRam(), product.getColour());
                }
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");

            }
            System.out.println();

        }
    }

    public static Scanner getInput() {
        return input;
    }

    public static void setInput(Scanner input) {
        Product.input = input;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getIdNotebook() {
        return idNotebook;
    }

    public static void setIdNotebook(int idNotebook) {
        Product.idNotebook = idNotebook;
    }

    public static int getIdMobilePhone() {
        return idMobilePhone;
    }

    public static void setIdMobilePhone(int idMobilePhone) {
        Product.idMobilePhone = idMobilePhone;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public double getCamera() {
        return camera;
    }

    public void setCamera(double camera) {
        this.camera = camera;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public int getRam() {
        return Ram;
    }

    public void setRam(int ram) {
        Ram = ram;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public static HashMap<String, ArrayList<Product>> getProducts() {
        return products;
    }

    public static void setProducts(HashMap<String, ArrayList<Product>> products) {
        Product.products = products;
    }
}



