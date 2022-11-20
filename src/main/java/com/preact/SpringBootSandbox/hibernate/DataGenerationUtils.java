package com.preact.SpringBootSandbox.hibernate;

import com.preact.SpringBootSandbox.hibernate.modal.bidirectional.HiberItemBi;
import com.preact.SpringBootSandbox.hibernate.modal.bidirectional.HiberItemDescriptionBi;
import com.preact.SpringBootSandbox.hibernate.modal.unidirectional.HiberItem;
import com.preact.SpringBootSandbox.hibernate.modal.unidirectional.HiberItemDescription;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataGenerationUtils {

    public static List<HiberItem> generateItems(int n){
       return  IntStream.range(0,n)
               .mapToObj(item-> {
                   HiberItem newItem = new HiberItem("Item " + item);
                   newItem.setHiberItemDescription(new HiberItemDescription("Description -> "+ newItem.getName()));
                   return newItem;
               })
               .collect(Collectors.toList());
    }


    public static List<HiberItemBi> generateItemsBi(int n){
        return  IntStream.range(0,n)
                .mapToObj(item-> {
                    HiberItemBi newItem = new HiberItemBi("Item " + item);
                    newItem.setHiberItemDescriptionBi(new HiberItemDescriptionBi("Description -> "+ newItem.getName()));
                    return newItem;
                })
                .collect(Collectors.toList());
    }
}
