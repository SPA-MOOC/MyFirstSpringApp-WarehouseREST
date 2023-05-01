package com.example.myfirstspringapprest.repositories;

import com.example.myfirstspringapprest.data.WarehouseItem;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
@Getter
public class WarehouseItemRepository {
    List<WarehouseItem> items;


    public WarehouseItemRepository(){
        items = new LinkedList<>();
        items.add(new WarehouseItem("protein bar",true));
        items.add(new WarehouseItem("water",false));
        items.add(new WarehouseItem("candy",true));
        items.add(new WarehouseItem("bread",true));

    }

    public WarehouseItem getItem(String name){
        return  items.stream().filter(item->item.getName().equals(name)).findFirst().get();
    }



}
