package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.model.ProductRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @PostMapping("/addProduct")
    @ApiResponses({
        @ApiResponse(code = 10, message = "Required fields not informed.")
    })
    @ApiOperation("Responsável por adicionar um produto")
    public void addProduct(@RequestBody Product product) {
        this.repository.addProduct(product);
    }

    @GetMapping("/allProducts")
    @ApiResponses({
            @ApiResponse(code = 11, message = "Warning - the process returned more than 1000 products.")
    })
    @ApiOperation("Responsável por retornar uma lista de produtos.")
    public List<Product> getAllProducts() {
        return this.repository.getAllProducts();
    }

    @GetMapping("/findProductById/{id}")
    @ApiResponses({
            @ApiResponse(code = 12, message = "The field id not informed. This information is required.")
    })
    @ApiOperation("Responsável por retornar um produto pelo id.")
    public Product findProductById(@PathVariable int id) {
        return this.repository.getProductById(id);
    }

    @DeleteMapping("/removeProduct")
    @ApiResponses({
            @ApiResponse(code = 13, message = "User not allowed to remove a product from this category.")
    })
    @ApiOperation("Responsável por remover um produto.")
    public void deleteProductById(@RequestParam("id") int id) {
        Product product = this.repository.getProductById(id);

        this.repository.removeProduct(product);
    }

    @PutMapping("/updateProduct")
    @ApiResponses({
            @ApiResponse(code = 14, message = "No information has been updated. The new information is the same as recorded in the database.")
    })
    @ApiOperation("Responsável por atualizar um produto")
    public void updateProduct(@RequestBody Product product) {
        this.repository.updateProduct(product);
    }

    @GetMapping("/welcome")
    @ApiOperation("Responsável por retornar uma mensagem de boas vindas.")
    public String welcome() {
        return "Bem vindo";
    }
}
