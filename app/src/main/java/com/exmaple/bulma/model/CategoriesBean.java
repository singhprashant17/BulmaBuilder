package com.exmaple.bulma.model;

import com.prashant.java.bulmabuilder.BulmaBuilder;

import java.util.List;

@BulmaBuilder
public class CategoriesBean {
    /**
     * id : 1
     * name :  Casuals
     * products : [{"id":1,"name":"Nike Sneakers","date_added":"2016-12-09T11:16:11.000Z",
     * "variants":[{"id":1,"color":"Blue","size":42,"price":1000},{"id":2,"color":"Red",
     * "size":42,"price":1000},{"id":3,"color":"Blue","size":44,"price":1200},{"id":4,
     * "color":"Red","size":44,"price":1200}],"tax":{"name":"VAT","value":12.5}},{"id":2,
     * "name":"Adidas Running Shoes","date_added":"2016-11-05T11:16:11.000Z",
     * "variants":[{"id":5,"color":"White","size":40,"price":2000},{"id":6,"color":"Black",
     * "size":40,"price":2000},{"id":7,"color":"White","size":44,"price":2200},{"id":8,
     * "color":"Red","size":44,"price":2200}],"tax":{"name":"VAT4","value":4}},{"id":21,
     * "name":"Roadster Loafers","date_added":"2016-01-18T11:16:11.000Z",
     * "variants":[{"id":65,"color":"Black","size":44,"price":3500},{"id":66,"color":"Blue",
     * "size":44,"price":3200}],"tax":{"name":"VAT4","value":4}},{"id":22,"name":"Light
     * Loafers","date_added":"2016-01-18T11:16:11.000Z","variants":[{"id":67,"color":"Blue",
     * "size":42,"price":2800},{"id":68,"color":"Yellow","size":42,"price":2800}],
     * "tax":{"name":"VAT4","value":4}},{"id":23,"name":"Floaters",
     * "date_added":"2016-01-18T11:16:11.000Z","variants":[{"id":69,"color":"Black",
     * "size":40,"price":3500},{"id":70,"color":"Red","size":40,"price":3500}],
     * "tax":{"name":"VAT4","value":4}}]
     * child_categories : []
     */

    private int id;
    private String name;
    private List<ProductsBean> products;
    private List<?> child_categories;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductsBean> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsBean> products) {
        this.products = products;
    }

    public List<?> getChild_categories() {
        return child_categories;
    }

    public void setChild_categories(List<?> child_categories) {
        this.child_categories = child_categories;
    }

}
