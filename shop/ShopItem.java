package shop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShopItem {
    public static void main(String[] args) {

        try {
            List<Product> products = Stream.of(
                    new Product("Sneaker", 100.0),
                    new Product("T-Shirt", 50.0),
                    new Product("Jeans", 120.0),
                    new Product("Jacket", 200.0)).collect(Collectors.toList());
            System.out.println("=====================================");
            products.forEach(e -> System.out.println(e.getName() + " " + e.getPrice()));
            System.out.println("=====================================");

            Optional<Product> minProduct = products.stream().min(Comparator.comparingDouble(Product::getPrice));
            System.out.println("Min: " + minProduct.get().getName() + " " + minProduct.get().getPrice());

            Optional<Product> maxProduct = products.stream().max(Comparator.comparingDouble(Product::getPrice));
            System.out.println("Max: " + maxProduct.get().getName() + " " + maxProduct.get().getPrice());

            Double avgPrice = products.stream().mapToDouble(Product::getPrice).average().getAsDouble();
            System.out.println("Avg: " + avgPrice);

            // System.out.println("---- Price < 50 ----");
            // products.stream().filter(e -> e.getPrice() < 50).forEach(e -> System.out.println(e.getName() + " " + e.getPrice()));
            // System.out.println("=====================================");

            List<Product> discount50 = products.stream().map(e -> {
                e.setPrice(e.getPrice() * 0.5);
                return e;
            }).toList();
            
            System.out.println("---- Discount 50% ----");
            discount50.forEach(item -> {
                System.out.println(item.getName() + " " + item.getPrice());
            });
            System.out.println("=====================================");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
