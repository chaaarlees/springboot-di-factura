package com.charles.curso.springboot.di.factura.springboot_di_factura.models;

public class Item {

    private Product product;
    private Integer quatity;

    public Item(){};

    public Item(Product product, Integer quatity) {
        this.product = product;
        this.quatity = quatity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuatity() {
        return quatity;
    }

    public void setQuatity(Integer quatity) {
        this.quatity = quatity;
    }

    public Integer getImport(){
        return quatity  * product.getPrice();
    }

}
