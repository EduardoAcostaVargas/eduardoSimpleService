package org.example.eduardosimpleservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoes")
@CrossOrigin(origins = "http://localhost:5173")
public class ShoeController {

    private final ShoeRepository shoeRepository;

    public ShoeController(ShoeRepository shoeRepository) {
        this.shoeRepository = shoeRepository;
    }

    @RequestMapping
    public ResponseEntity<List<Shoe>> getAllShoes(){
        return ResponseEntity.ok(shoeRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shoe> getShoeById(@PathVariable Long id){

        return shoeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Shoe> addShoe(@RequestBody Shoe shoe){
        shoe.setId(null);

        Shoe savedShoe = shoeRepository.save(shoe);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedShoe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShoe(@PathVariable Long id) {
        if (!shoeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        shoeRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shoe> updateShoe(@PathVariable Long id, @RequestBody Shoe updatedShoe) {
        return shoeRepository.findById(id)
                .map(existingShoe -> {
                    existingShoe.setBrand(updatedShoe.getBrand());
                    existingShoe.setModel(updatedShoe.getModel());
                    existingShoe.setPrice(updatedShoe.getPrice());
                    existingShoe.setShoeSize(updatedShoe.getShoeSize());

                    Shoe savedShoe = shoeRepository.save(existingShoe);

                    return ResponseEntity.ok(savedShoe);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
