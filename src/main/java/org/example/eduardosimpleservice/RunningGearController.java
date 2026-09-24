package org.example.eduardosimpleservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/running_gear")
public class RunningGearController {

    List<RunningGear> items = new ArrayList<>();

    public RunningGearController(){

        items.add(new RunningGear(
                1,
                "shirt",
                'L',
                "White",
                25.99
        ));

        items.add(new RunningGear(
                2,
                "running shorts",
                'L',
                "Black",
                35.99
        ));

        items.add(new RunningGear(
                3,
                "Shirt",
                'L',
                "Red",
                25.99
        ));

    }

    @RequestMapping
    public List<RunningGear> getItems(){return items;}

    @RequestMapping("/{id}")
    public ResponseEntity<RunningGear> getItem(@PathVariable int id) {
        for (RunningGear item : items) {
            if (item.getId() == id){
                return ResponseEntity.ok(item);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<RunningGear> addItem(@RequestBody RunningGear item) {
        int newId = items.size() + 1;
        item.setId(newId);

        items.add(item);

        return ResponseEntity.status(200).body(item);
    }

    @DeleteMapping
    public ResponseEntity<RunningGear> deleteItem(@PathVariable int id) {
        for (RunningGear item : items) {
            if (item.getId() == id) {
                items.remove(item);

                ResponseEntity.noContent().build();
            }
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RunningGear> updateItem(@PathVariable int id, @RequestBody RunningGear updatedItem) {

        for (RunningGear item : items) {
            if (item.getId() == id) {
                item.setTypeOfGear(updatedItem.getTypeOfGear());
                item.setSize(updatedItem.getSize());
                item.setColor(updatedItem.getColor());
                item.setPrice(updatedItem.getPrice());

                return ResponseEntity.ok(item);
            }
        }

        return ResponseEntity.notFound().build();
    }
}
