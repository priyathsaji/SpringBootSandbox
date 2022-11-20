package com.preact.SpringBootSandbox.hibernate;

import com.preact.SpringBootSandbox.hibernate.modal.onetoone.bidirectional.HiberItemBi;
import com.preact.SpringBootSandbox.hibernate.modal.onetoone.bidirectional.HiberItemDescriptionBi;
import com.preact.SpringBootSandbox.hibernate.modal.onetoone.unidirectional.HiberItem;
import com.preact.SpringBootSandbox.hibernate.modal.onetoone.unidirectional.HiberItemDescription;
import com.preact.SpringBootSandbox.hibernate.modal.onetomany.ItemManufacturerOTM;
import com.preact.SpringBootSandbox.hibernate.modal.onetomany.ItemOTM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class HibernateService {


    @Autowired
    EntityManager entityManager;


    @Transactional
    public List<HiberItem> addData2Database(int n) {
        List<HiberItem> items2Save = DataGenerationUtils.generateItems(n);
        items2Save.forEach(item -> {
            HiberItemDescription description = item.getHiberItemDescription();
            if (description.getId() == null) {
                entityManager.persist(description);
            } else {
                entityManager.merge(description);
            }
            entityManager.flush();
            item.setHiberItemDescription(description);
            entityManager.merge(item);
            entityManager.flush();
        });
        return items2Save;
    }


    @Transactional
    public List<HiberItemBi> addData2DatabaseBi(int n) {
        List<HiberItemBi> items2Save = DataGenerationUtils.generateItemsBi(n);
        items2Save.forEach(item -> {
            HiberItemDescriptionBi description = item.getHiberItemDescriptionBi();
            if (description.getId() == null) {
                entityManager.persist(description);
            } else {
                entityManager.merge(description);
            }
            item.setHiberItemDescriptionBi(description);
            entityManager.persist(item);

        });
        entityManager.flush();
        return items2Save;
    }


    public List<HiberItemBi> findAllItemsInDbBi() {
        return entityManager
                .createQuery("select c from HiberItemBi c", HiberItemBi.class)
                .getResultList();
    }


    public List<HiberItemDescriptionBi> findAllHiberItemDescriptionBiFromDb() {
        return entityManager
                .createQuery("select h from HiberItemDescriptionBi h", HiberItemDescriptionBi.class)
                .getResultList();
    }


    public List<HiberItem> findAllItemsInDb() {
        return entityManager
                .createQuery("select c from HiberItem c", HiberItem.class)
                .getResultList();
    }


    public List<ItemOTM> generateItems(ItemManufacturerOTM itemManufacturerOTM, int n){
        return IntStream
                .range(1, n+1)
                .mapToObj(item->{
                    ItemOTM itemOTM = new ItemOTM("Item "+ item );
                    itemOTM.setItemManufacturer(itemManufacturerOTM);
                    entityManager.persist(itemOTM);
                    return itemOTM;
                }).collect(Collectors.toList());
    }

    @Transactional
    public List<ItemManufacturerOTM> addOTMData2Db(int n) {
        List<ItemManufacturerOTM> data2return =  IntStream
                .range(1, n + 1)
                .mapToObj(item -> {
                    ItemManufacturerOTM manufacturerOTM = new ItemManufacturerOTM("Manufacturer : " + item);
                    entityManager.persist(manufacturerOTM);
                    return manufacturerOTM;
                })
                .peek(item->{
                    item.setItems(generateItems(item,10));
                    entityManager.merge(item);
                })
                .collect(Collectors.toList());

        entityManager.flush();
        return data2return;
    }


}
