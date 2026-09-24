package org.example.eduardosimpleservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shoes")
public class ShoeController {

    List<Shoe> shoes = new ArrayList<>();


    public ShoeController() {
        shoes.add(new Shoe(
                1,
                "Nike",
                "Romaleos",
                12,
                400.50
        ));

        shoes.add(new Shoe(
                2,
                "Nike",
                "Air Force",
                11.5,
                100
        ));

    }

    @RequestMapping
    public List<Shoe> getShoes(){
        return shoes;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shoe> getShoe(@PathVariable int id){
        for(Shoe shoe : shoes) {
            if (shoe.getId() == id) {
                return ResponseEntity.ok(shoe);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Shoe> addShoe(@RequestBody Shoe shoe){

        int newId = shoes.size() + 1;
        shoe.setId(newId);

        shoes.add(shoe);

        return ResponseEntity.status(200).body(shoe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShoe(@PathVariable int id) {
        for (Shoe shoe : shoes) {
            shoes.remove(shoe);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shoe> updateShoe(@PathVariable int id, @RequestBody Shoe updatedShoe) {
        for (Shoe shoe : shoes) {
            if (shoe.getId() == id) {
                shoe.setBrand(updatedShoe.getBrand());
                shoe.setModel(updatedShoe.getModel());
                shoe.setShoeSize(updatedShoe.getShoeSize());
                shoe.setPrice(updatedShoe.getPrice());

                return ResponseEntity.ok(shoe);
            }
        }

        return ResponseEntity.notFound().build();
    }

}
