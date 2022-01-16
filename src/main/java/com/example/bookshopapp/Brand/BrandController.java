package com.example.bookshopapp.Brand;

import com.example.bookshopapp.Category.Category;
import com.example.bookshopapp.Category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BrandController {

    @Autowired
    private BrandRepository brandrepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @GetMapping("/brands/new")
    public String showCreateNewBrandForm(Model model){
        List<Category> listCategories = categoryRepo.findAll();

        model.addAttribute("listCategories", listCategories);
        model.addAttribute("brand", new Brand());

        return "brand_form";
    }

    @PostMapping("brands/save")
    public String saveBrand(Brand brand){
        brandrepo.save(brand);

        return "redirect:/brands";
    }

    @GetMapping("/brands")
    public String  listBrands(Model model){
        List<Brand> listBrands = brandrepo.findAll();
        model.addAttribute("listBrands", listBrands);

        return "brands";

    }

    @GetMapping("brands/edit/{id}")
    public String showEditBrandsForm(@PathVariable("id") Integer id, Model model){
        List<Category> listCategories = categoryRepo.findAll();
        Brand brand = brandrepo.findById(id).get();

        model.addAttribute("listCategories", listCategories);
        model.addAttribute("brand", brand);

        return "brand_form";
    }


}
