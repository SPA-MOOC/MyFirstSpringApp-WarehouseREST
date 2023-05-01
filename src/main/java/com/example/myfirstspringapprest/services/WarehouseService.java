package com.example.myfirstspringapprest.services;

import com.example.myfirstspringapprest.data.WarehouseItem;
import com.example.myfirstspringapprest.repositories.WarehouseItemRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@Getter
public class WarehouseService {
    @Autowired
    WarehouseItemRepository warehouse;

    public List<WarehouseItem> getAllItems(){
        return warehouse.getItems();
    }

    public WarehouseItem getItem(String name){
        return warehouse.getItem(name);
    }

    public boolean isItemAvailable(String name){
        return warehouse.getItem(name).getAvailable();
    }

    public boolean areAvail(List<String> items){
        System.out.println(!this.warehouse.getItems().stream().
                filter(item->items.contains(item.getName())&&item.getAvailable()==false).findFirst().isPresent());
        return !this.warehouse.getItems().stream().filter(item->items.contains(item.getName())&&item.getAvailable()==false).findFirst().isPresent();
    }
}
