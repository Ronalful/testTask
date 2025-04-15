package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.model.Order;
import org.example.model.Product;
import org.example.service.OrderService;
import org.example.service.ProductService;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final OrderService orderService = new OrderService();
    private static final ProductService productService = new ProductService();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n\nВыберете действие:");
            System.out.println("1 - Добавить продукт");
            System.out.println("2 - Создать заказ");
            System.out.println("3 - Вывести заказы с фильтрацией по имени покупателя");
            System.out.println("4 - Экспортировать заказы в JSON");
            System.out.println("5 - Выйти");

            switch (System.console().readLine()) {
                case "1":
                    createProduct();
                    break;
                case "2":
                    createOrder();
                    break;
                case "3":
                    findAllByCustomerName();
                    break;
                case "4":
                    exportJSON();
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Повторите еще раз");
            }
        }
    }

    private static void createProduct() {
        Product product = new Product();

        try {
            System.out.println("\nВведите имя продукта");
            String name = System.console().readLine();
            product.setName(name);

            System.out.println("\nВведите цену продукта");
            String price = System.console().readLine();
            product.setPrice(new BigDecimal(price));
        } catch (Exception e) {
            System.out.println("Произошла ошибка ввода данных");
            return;
        }


        if (productService.save(product)) {
            System.out.println("Продукт добавлен успешно");
        }
        else {
            System.out.println("Продукт c данным названием уже присутствует");
        }
    }

    private static void createOrder() {
        Order order = new Order();

        try {
            System.out.println("\nВведите имя покупателя");
            String customerName = System.console().readLine();
            order.setCustomerName(customerName);

            System.out.println("\nВведите, сколько вы хотите добавить продуктов");
            int numOfProducts = Integer.parseInt(System.console().readLine());

            if (numOfProducts < 1) {
                System.out.println("Недопустимое количество продуктов");
                return;
            }

            List<String> productsName = new ArrayList<>();
            for (int i = 0; i < numOfProducts; i++) {
                System.out.println("\nВведите имя продукта");
                productsName.add(System.console().readLine());
            }

            BigDecimal totalPrice = new BigDecimal(0);
            List<Product> products = new ArrayList<>();
            for (var product : productsName) {
                var result = productService.findProductByName(product);
                if (result.isEmpty()) {
                    System.out.println("Продукт с именем " + product + " не был найден. Поэтому он не будет добавлен");
                }
                else {
                    products.add(result.getFirst());
                    totalPrice = totalPrice.add(result.getFirst().getPrice());
                }
            }

            if (products.isEmpty()) {
                System.out.println("Пустой заказ не может быть создан");
                return;
            }

            order.setProducts(products);
            order.setTotalPrice(totalPrice);
        } catch (Exception e) {
            System.out.println("Произошла ошибка ввода данных");
            return;
        }

        orderService.save(order);
        System.out.println("Заказ добавлен успешно");
    }

    private static void findAllByCustomerName() {
        try {
            System.out.println("\nВведите имя покупателя");
            String customerName = System.console().readLine();
            orderService.findAllOrderByCustomerName(customerName).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Произошла ошибка ввода данных");
        }
    }

    private static void exportJSON() {
        var orders = orderService.findAll();
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        try {
            ow.writeValue(new File("./src/main/resources/export.json"), orders);
        } catch (IOException e) {
            System.out.println("Произошла ошибка при экспорте списка заказов в JSON файл" + e.getMessage());
            return;
        }

        System.out.println("Экспорт произошел успешно");
    }
}