/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.reto3.service;

import com.reto3.reto3.entity.Category;
import com.reto3.reto3.repository.CategoryRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ruiz Alfonso
 */
@Service
public class CategoryService {
     @Autowired
    private CategoryRepositorio mcrud;

    public List<Category> getAll(){
        return mcrud.getAll();
    }

    public Optional<Category> getCategory(int CategoryId) {
        return mcrud.getCategory(CategoryId);
    }

    public Category save(Category category){
        if(category.getId()==null){
            return mcrud.save(category);
        }else{
            Optional<Category> cat1=mcrud.getCategory(category.getId());
            if(cat1.isEmpty()){
                return mcrud.save(category);
            }else{
                return category;
            }
        }
    }

    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category> catg=mcrud.getCategory(category.getId());
            if(!catg.isEmpty()){
                if(category.getDescription()!=null){
                    catg.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    catg.get().setName(category.getName());
                }
                return mcrud.save(catg.get());
            }    
        }
        return category;
    }
    
    public boolean deleteCategory(int CategoryId){
        Boolean catd=getCategory(CategoryId).map(category -> {
            mcrud.delete(category);
            return true;
        }).orElse(false);
        return catd;
    }
}
