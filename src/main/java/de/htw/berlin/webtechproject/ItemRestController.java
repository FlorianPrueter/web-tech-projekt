package de.htw.berlin.webtechproject;

import de.htw.berlin.webtechproject.api.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ItemRestController {

    private List<Item> items;

    public ItemRestController() {
        items = new ArrayList<>();
        items.add(new Item(1, "Zwiebel", 1, true));
        items.add(new Item(2, "Gurke", 0, false));
    }

    @GetMapping(path = "/api/v1/items")
    public ResponseEntity<List<Item>> fetchItems() {
        return ResponseEntity.ok(items);

    }
}