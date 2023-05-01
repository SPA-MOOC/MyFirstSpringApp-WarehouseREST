package com.example.myfirstspringapprest.controllers;

import com.example.myfirstspringapprest.data.WarehouseItem;
import com.example.myfirstspringapprest.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class RestItemsController {

    @Autowired
    WarehouseService warehouseService;

    @RequestMapping(method = RequestMethod.GET,produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<WarehouseItem> getItems(){
        return warehouseService.getAllItems();
    }

    @RequestMapping(value="/{name}",method = RequestMethod.GET,produces = "application/json")
    @ResponseStatus(HttpStatus.FOUND)
    public @ResponseBody WarehouseItem getItem(@PathVariable String name){
        return warehouseService.getItem(name);
    }

    @RequestMapping(value="/avail/{name}",method = RequestMethod.GET,produces = "application/json")
    @ResponseStatus(HttpStatus.FOUND)
    public @ResponseBody boolean isAvail(@PathVariable String name){
        return warehouseService.isItemAvailable(name);
    }

    @RequestMapping(value="/order",method = RequestMethod.POST,consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody boolean orderItems(@RequestBody List<String> items){
        System.out.println("order items "+items.size());

        return warehouseService.areAvail(items);
    }
}
