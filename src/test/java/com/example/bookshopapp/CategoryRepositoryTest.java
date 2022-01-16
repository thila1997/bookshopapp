package com.example.bookshopapp;

import static org.assertj.core.api.Assertions.assertThat;


import com.example.bookshopapp.Category.Category;
import com.example.bookshopapp.Category.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repo;

    @Test
    public void testCreateCategory(){

        Category savedCategory = repo.save(new Category("Electronics"));

        assertThat(savedCategory.getId()).isGreaterThan(0);
    }
}