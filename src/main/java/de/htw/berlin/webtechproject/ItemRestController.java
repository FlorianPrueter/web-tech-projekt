package de.htw.berlin.webtechproject;

import de.htw.berlin.webtechproject.api.Item;
import de.htw.berlin.webtechproject.api.ItemManipulationRequest;
import de.htw.berlin.webtechproject.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
public class ItemRestController {

    private final ItemService itemService;

    public ItemRestController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(path = "/api/v1/items")
    public ResponseEntity<List<Item>> fetchItems() {
        return ResponseEntity.ok(itemService.findAll());
    }

    @GetMapping(path = "/api/v1/items/{id}")
    public ResponseEntity<Item> fetchItemById(@PathVariable Long id) {
        var item = itemService.findById(id);
        return item != null? ResponseEntity.ok(item) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/items")
    public ResponseEntity<Void> createItem(@RequestBody ItemManipulationRequest request) throws URISyntaxException {
        var item = itemService.create(request);
        URI uri = new URI("/api/v1/items" + item.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/items/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody ItemManipulationRequest request) {
        var item = itemService.update(id, request);
        return item != null? ResponseEntity.ok(item) : ResponseEntity.notFound().build();
    }

    @GetMapping("/items/sort/{sortOrder}")
    public List<Item> getItemsSorted(@PathVariable String sortOrder) {
        // retrieve the items from the database
        List<Item> items = itemService.findAll();

        // sort the items based on the sort order
        if (sortOrder.equals("name")) {
            items.sort((a, b) -> a.getName().compareTo(b.getName()));
        } else if (sortOrder.equals("date")) {
            items.sort((a, b) -> a.getDateAdded().compareTo(b.getDateAdded()));
        }

        // return the sorted items
        return items;
    }

    @DeleteMapping(path = "/api/v1/items/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        boolean successful = itemService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
