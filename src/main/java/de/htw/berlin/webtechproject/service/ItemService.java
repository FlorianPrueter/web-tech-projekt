package de.htw.berlin.webtechproject.service;

import de.htw.berlin.webtechproject.api.Item;
import de.htw.berlin.webtechproject.api.ItemCreateRequest;
import de.htw.berlin.webtechproject.persistence.ItemEntity;
import de.htw.berlin.webtechproject.persistence.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAll() {
        List<ItemEntity> items = itemRepository.findAll();
        return items.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Item findById(Long id) {
        var itemEntity = itemRepository.findById(id);
        return itemEntity.map(this::transformEntity).orElse(null);
    }

    public Item create(ItemCreateRequest request) {
        var itemEntity = new ItemEntity(request.getFullName(), request.getAmount(), request.isSelected());
        itemEntity = itemRepository.save(itemEntity);
        return transformEntity(itemEntity);
    }

    private Item transformEntity(ItemEntity itemEntity) {
        return  new Item(
                itemEntity.getId(),
                itemEntity.getFullName(),
                itemEntity.getAmount(),
                itemEntity.getSelected()
        );
    }
}
