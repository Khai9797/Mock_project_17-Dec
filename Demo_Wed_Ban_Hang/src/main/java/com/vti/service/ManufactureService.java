package com.vti.service;

import com.vti.entity.Manufacture;
import com.vti.entity.Product;
import com.vti.form.CreatingManufactureForm;
import com.vti.form.UpdatingManufactureForm;
import com.vti.repository.ICategoryRepository;
import com.vti.repository.IManufactureRepository;
import com.vti.repository.IProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ManufactureService implements IManufactureService {

    @Autowired
    private IManufactureRepository manufactureRepository;

    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Manufacture> getAllManufacture() {
        return manufactureRepository.findAll();
    }

    @Override
    public void createManufacture(CreatingManufactureForm form) {
        Manufacture manufacture = manufactureRepository.save(modelMapper.map(form, Manufacture.class));
        List<Product> products = new ArrayList<>();
        List<CreatingManufactureForm.ProductForm> productForms = form.getProducts();
        productForms.forEach(productForm -> {
            Product product = modelMapper.map(productForm, Product.class);
            product.setManufacture(manufacture);
            product.setManufacture(manufactureRepository.findById(productForm.getManufactureId()));
            product.setCategory(categoryRepository.findById(productForm.getCategoryId()));
            products.add(product);
        });
        productRepository.saveAll(products);
    }

    @Override
    public void updateManufacture(UpdatingManufactureForm form) {
        manufactureRepository.save(modelMapper.map(form, Manufacture.class));
    }

    @Override
    public void deleteManufacture(int id) {
        manufactureRepository.deleteById(id);
    }

    @Override
    public Manufacture getManufactureById(int id) {
        return manufactureRepository.findById(id);
    }

    @Override
    public boolean isManufactureExistsByName(String name) {
        return manufactureRepository.existsByName(name);
    }
}
