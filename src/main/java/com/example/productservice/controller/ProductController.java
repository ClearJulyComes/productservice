package com.example.productservice.controller;

import com.example.productservice.serviceinterface.ProductService;
import com.example.productservice.view.FilterName;
import com.example.productservice.view.ProductSave;
import com.example.productservice.view.ProductView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/save")
    public String saveProduct (@RequestBody ProductSave productSave) {
        productService.save(productSave);
        return "Saved";
    }

    @PutMapping("/update")
    public String updateProduct (@RequestBody ProductView productView){
        productService.update(productView);
        return "Updated";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct (@PathVariable Integer id){
        productService.delete(id);
        return "Deleted";
    }

    @PostMapping("/name")
    public ProductView getProduct (@RequestBody FilterName name){
        return productService.findByName(name.getName());
    }

    @PostMapping("/brand")
    public List<ProductView> getProducts (@RequestBody FilterName name){
        return productService.findByBrand(name.getName());
    }

    @GetMapping("/leftovers")
    public List<ProductView> getLeftovers (){
        return productService.findLeftovers();
    }
}
