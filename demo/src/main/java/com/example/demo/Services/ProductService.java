package com.example.demo.Services;

import com.example.demo.Reposetory.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    private List<Product> list=new ArrayList<>();
    public  ProductService(){
        list.add(new Product(1,"a",10));
        list.add(new Product(2,"b",20));
    }

    public List<Product> getList() {
         return list;
    }

    public void setList(Product product) {
        list.add(product);
    }
    public void updateList(Product product){
        Optional<Product> update=list
                .stream()
                .filter(p -> p.getId()==product.getId()).findFirst();
        update.ifPresent(p -> {
            p.setName(product.getName());
            p.setPrice(product.getPrice());
        });
    }
    public void delete(Product product){
        Optional<Product> delete=list
                .stream()
                .filter(p -> p.getId()==product.getId()).findFirst();
        delete.ifPresent(p->list.remove(p));
    }
}
