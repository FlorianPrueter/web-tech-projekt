package de.htw.berlin.webtechproject.service;

import de.htw.berlin.webtechproject.api.Item;
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
                .map(itemEntity -> new Item(
                        itemEntity.getId(),
                        itemEntity.getName(),
                        itemEntity.getAmount(),
                        itemEntity.getSelected()
                ))
                .collect(Collectors.toList());
    }
}
