package com.example.catwiki.controller;

import com.example.catwiki.model.Cat;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cats")
public class CatController {
    private final List<Cat> catList = new ArrayList<Cat>();

    public CatController() {
        // 예시 데이터 추가
        catList.add(new Cat(1L, "Milo", "black", 3));
        catList.add(new Cat(2L, "Luna", "white", 4));
        catList.add(new Cat(3L, "Leo", "yellow", 1));
    }

    // 고양이 리스트를 반환
    // http://localhost:8080/cats
    @GetMapping
    public List<Cat> getAllCats() {
        return catList;
    }

    //고양이 정보 조회
    @GetMapping("/{id}")
    public Cat getCatById(@PathVariable Long id) {
//        Optional<Cat> cat = catList.stream().filter(c->c.getId().equals(id)).findFirst();
//        return cat.orElse(null);
        for( Cat cat : catList ) {
            if (cat.getId().equals(id)) {
                return cat;
            }
        }
        return null;
    }

    // 새로운 고양이 추가
    @PostMapping
    public Cat addCat(@RequestBody Cat cat) {
        cat.setId((catList.size() + 1L));
        catList.add(cat);
        return cat;
    }

    // 고양이 삭제
    @DeleteMapping("/{id}")
    public String deleteCat(@PathVariable Long id) {
//        boolean removed = catList.removeIf(c -> c.getId().equals(id));
//        return removed ? "고양이 정보 삭제 완료" : "해당 아이디의 고양이를 찾지 못했습니다.";
        for(int i=0; i<catList.size(); i++) {
            if(catList.get(i).getId().equals(id)) {
                catList.remove(i);
                return "고양이 정보 삭제 완료";
            }
        }
        return "해당 아이디의 고양이를 찾지 못했습니다.";
    }
}
