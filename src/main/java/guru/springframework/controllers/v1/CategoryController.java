package guru.springframework.controllers.v1;

import guru.springframework.api.v1.model.CategoryDTO;
import guru.springframework.api.v1.model.CategoryListDTO;
import guru.springframework.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public ResponseEntity<CategoryListDTO> getAll(){

        List<CategoryDTO> categoryDTOList = categoryService.getAllCategories();
        CategoryListDTO categoryListDTO = new CategoryListDTO(categoryDTOList);
        return new ResponseEntity<>(categoryListDTO, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<CategoryDTO> findByName(@PathVariable String name){

        CategoryDTO categoryDTO = categoryService.getCategoryByName(name);
        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
    }

}