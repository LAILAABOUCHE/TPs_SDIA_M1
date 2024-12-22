package org.example.EX3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Product>{
    private List<Product> products;
    private File file;

    public MetierProduitImpl() {}

    public MetierProduitImpl(List<Product> products, File file) {
        this.products = products;
        this.file = file;
    }

    @Override
    public Product add(Product o) {
        products.add(o);
        return o;
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product findByNom(String nom) {
        for(Product p: products) {
            if(p.getName().equals(nom)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void delete(String nom) {
        getAll().removeIf(p -> p.getName().equals(nom));
    }

    @Override
    public void saveAll() {
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(file, false);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
