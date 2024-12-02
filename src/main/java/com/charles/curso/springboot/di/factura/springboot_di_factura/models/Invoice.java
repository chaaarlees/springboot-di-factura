package com.charles.curso.springboot.di.factura.springboot_di_factura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@RequestScope
@JsonIgnoreProperties({"targetSource", "advisors"})//ignorar atributos residuales del proxy
public class Invoice {

    @Autowired
    private Client client;

    // @Value("${invoice.description}")
    @Value("${invoice.description.office}")
    private String description;
    
    @Autowired
    @Qualifier("default")
    private List<Item> items;

    public Invoice(){
        System.out.println("Constructor del componente de la factura");
        // System.out.println(client);
        // System.out.println(description);
    }

    @PostConstruct
    public void init(){
        System.out.println("Creando el componente de la factura");
        // System.out.println(client);
        // System.out.println(description);
        client.setName(client.getName().concat(" Pepe"));
        description= description.concat(" del cliente: ").concat(client.getName());
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Desctruyendo el componente invoice");
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Integer getTotal(){
        // --Forma 1-- 
        // Integer total = 0;
        // for (Item item : items) {
        //     total += item.getImport();
        // }
        // return total;
        // --Forma 2--
        // return items.stream().mapToInt(item -> item.getImport()).sum();
        return items.stream().mapToInt(Item::getImport).sum();
    }

}
