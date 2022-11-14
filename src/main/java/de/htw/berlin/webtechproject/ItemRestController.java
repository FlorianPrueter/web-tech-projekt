package de.htw.berlin.webtechproject;

import de.htw.berlin.webtechproject.api.Item;
import de.htw.berlin.webtechproject.api.ItemCreateRequest;
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
    public ResponseEntity<Void> createItem(@RequestBody ItemCreateRequest request) throws URISyntaxException {
        var item = itemService.create(request);
        URI uri = new URI("/api/v1/items" + item.getId());
        return ResponseEntity.created(uri).build();
    }
}