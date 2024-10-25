package src.project01am.day08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws IOException {
        List<Product> products = new ArrayList<>();
        Long counter = 1L;

        if (args.length < 1) {
            System.exit(0);
        }
        File file = new File(args[0]);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();
        while (line != null) {
            line = br.readLine();
            if(line == null){
                break;
            }
            String[] attributes = line.split(",");
            String name = attributes[0];
            String des = attributes[1];
            String cat = attributes[2];
            Float price = Float.parseFloat(attributes[3]);
            Date date = new Date();
            Product newProduct = new Product(counter, name, des, cat, price, date);
            products.add(newProduct);

            counter++;
        }
        br.close();

        List<Product> phones = products
                .stream()
                .filter(product -> product.getProdCat().equals("Mobile")) // Corrected string comparison
                .filter(product -> product.getPrice() > 1500) // Added filter for price
                .sorted(Comparator.comparing(Product::getPrice)) // Sorting by price
                .collect(Collectors.toList());

        for (Product product : phones) {
            System.out.println(product.toString());
        }
    }
}
