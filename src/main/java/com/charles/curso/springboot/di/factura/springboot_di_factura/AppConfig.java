package com.charles.curso.springboot.di.factura.springboot_di_factura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.charles.curso.springboot.di.factura.springboot_di_factura.models.Item;
import com.charles.curso.springboot.di.factura.springboot_di_factura.models.Product;

@Configuration
@PropertySources(
    @PropertySource(value="classpath:data.properties",encoding = "UTF-8")
)
public class AppConfig {

    @Bean
    List<Item> itemsInvoice(){
        Product p1 = new Product("Camara Sony", 200);
        Product p2 = new Product("XBOX Series X", 300);
        Product p3 = new Product("Bicicleta Bianchi 25", 1200);
        return  Arrays.asList(new Item(p1,2), new Item(p2,4), new Item(p3,5)); 
    }

    // @Primary
    @Bean("default")
    List<Item> itemsInvoiceOffice(){
        Product p1 = new Product("Monitor ASUS", 250);
        Product p2 = new Product("Notebook Razer", 1400);
        Product p3 = new Product("Impresora HP", 600);
        Product p4 = new Product("Escritorio oficina", 500);
        return  Arrays.asList(new Item(p1,7), new Item(p2,3), new Item(p3,2), new Item(p4,3)); 
    }
}
