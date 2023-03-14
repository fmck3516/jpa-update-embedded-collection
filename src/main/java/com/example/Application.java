package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.support.TransactionTemplate;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    TransactionTemplate transactionTemplate;

    @Bean
    public CommandLineRunner demo() {
        return (args) -> {
            transactionTemplate.executeWithoutResult(tx -> {
                Customer customer = new Customer();
                customer.id = "customer-0";

                customer = customerRepository.save(customer);

                Order order = new Order();
                order.id = "order-0";
                order.customer = customer;

                orderRepository.save(order);

                System.out.println(customerRepository.findById("customer-0"));
            });
            transactionTemplate.executeWithoutResult(tx -> {
                System.out.println(customerRepository.findById("customer-0"));
            });
        };
    }

}
