package com.tnm.tony.photos.app;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;

@RestController
public class PhotosRest {
    private final       HashMap<String, Integer> map = new HashMap<String, Integer>() {{
        put("Nabil", 75);
        put("Tony",38);
    }};
    @GetMapping("/")
    public String getAll(){
        return "Hello World";
    }
    @GetMapping("/{name}")
    public String getOne(@PathVariable String name){
        if(map.get(name)==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Name not found");
        }
        return String.format("Hello %s, you are %d years old", name,map.get(name));
    }

}
