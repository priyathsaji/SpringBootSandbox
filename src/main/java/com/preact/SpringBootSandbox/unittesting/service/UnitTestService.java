package com.preact.SpringBootSandbox.unittesting.service;

import com.preact.SpringBootSandbox.unittesting.modal.Item;
import com.preact.SpringBootSandbox.unittesting.repository.UnitTestItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class UnitTestService {

    @EventListener(ApplicationReadyEvent.class)
    @Profile("default")
    public void init(){
        if(unitTestItemRepository.count() == 0){
            List<Item> items = Arrays.asList("Item:10:100", "Item2:20:1","Item3:10:2")
                    .stream().map(item->{
                        String[] dash = item.split(":");
                        return new Item(dash[0], null,Integer.parseInt(dash[1]));
                    }).collect(Collectors.toList());

            unitTestItemRepository.saveAll(items);
        }
    }

    private final UnitTestItemRepository unitTestItemRepository;

    @Autowired
    public UnitTestService(UnitTestItemRepository unitTestItemRepository) {
        this.unitTestItemRepository = unitTestItemRepository;
    }

    public List<Integer> getValue2N(int n) {
        return IntStream.range(1,n+1)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Item> getItemsFromDb() {
        return unitTestItemRepository.findAll();
    }
}
