package com.preact.SpringBootSandbox.hibernate;

import com.preact.SpringBootSandbox.hibernate.modal.onetoone.bidirectional.HiberItemBi;
import com.preact.SpringBootSandbox.hibernate.modal.onetoone.bidirectional.HiberItemDescriptionBi;
import com.preact.SpringBootSandbox.hibernate.modal.onetoone.unidirectional.HiberItem;
import com.preact.SpringBootSandbox.hibernate.modal.onetoone.unidirectional.HiberItemDescription;
import com.preact.SpringBootSandbox.hibernate.modal.onetomany.ItemManufacturerOTM;
import com.preact.SpringBootSandbox.hibernate.modal.onetomany.ItemOTM;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@SpringBootTest
class HibernateServiceTest {

    @Autowired
    HibernateService hibernateService;

    @Autowired
    EntityManager entityManager;

    @Test
    @DirtiesContext
    @Transactional
    // This is required when the fetch type is set to Lazy for the mapped item
    // when the mapped item is fetched if the transaction is not present persistent context is not found,so it fails
    public void testingInsertion(){

        List<HiberItem> currentItems = hibernateService.findAllItemsInDb();
        Assertions.assertThat(currentItems)
                .isEmpty();

        hibernateService.addData2Database(10);

        List<HiberItem> itemsAfterInsertion = hibernateService.findAllItemsInDb();

        Assertions.assertThat(itemsAfterInsertion)
                .hasSize(10)
                .allMatch(item-> Objects.nonNull(item.getId()))
                .allMatch(item-> {
                    HiberItemDescription description = item.getHiberItemDescription();
                    return Objects.nonNull(description)
                            && Objects.nonNull(description.getId())
                            && Objects.nonNull(description.getDescription()) // this line fails if the fetch type is lazy and not transaction
                            ;
                });

    }


    @Test
    @Transactional
    public void testingInsertionBi(){
        List<HiberItemBi> currentItems = hibernateService.findAllItemsInDbBi();
        Assertions.assertThat(currentItems)
                .isEmpty();

        hibernateService.addData2DatabaseBi(10);

        List<HiberItemBi> itemsAfterInsertion = hibernateService.findAllItemsInDbBi();

        Assertions.assertThat(itemsAfterInsertion)
                .hasSize(10)
                .allMatch(item-> Objects.nonNull(item.getId()))
                .allMatch(item-> {
                    HiberItemDescriptionBi description = item.getHiberItemDescriptionBi();
                    return Objects.nonNull(description)
                            && Objects.nonNull(description.getId())
                            && Objects.nonNull(description.getDescription()) // this line fails if the fetch type is lazy and not transaction
                            ;
                });

    }


    @Test
    @Transactional
    public void testingFetchByItemDescriptionBi(){
        List<HiberItemBi> currentItems = hibernateService.findAllItemsInDbBi();
        Assertions.assertThat(currentItems)
                .isEmpty();

        hibernateService.addData2DatabaseBi(2);

        List<HiberItemDescriptionBi> itemsAfterInsertion = hibernateService
                .findAllHiberItemDescriptionBiFromDb()
                .stream().peek(item->{
                    entityManager.refresh(item); // since we are fetching the entity by query need to make the entity persist in the persistence context
                }).collect(Collectors.toList());


        Assertions.assertThat(itemsAfterInsertion)
                .hasSize(2)
                .allMatch(item-> Objects.nonNull(item.getId()))
                .allMatch(item-> {
                    HiberItemBi hiberItem = item.getHiberItemBi(); //

                    return Objects.nonNull(hiberItem)
                            && Objects.nonNull(hiberItem.getId())
                            && Objects.nonNull(hiberItem.getName()) // this line fails if the fetch type is lazy and not transaction
                            ;
                });

    }

    @Test
    @Transactional
    void addOTMData2Db() {

        List<ItemManufacturerOTM> itemManufacturerOTMS = hibernateService.addOTMData2Db(10);

        Assertions.assertThat(itemManufacturerOTMS)
                .hasSize(10);

        ItemManufacturerOTM item = itemManufacturerOTMS.stream().findFirst().orElse(null);
        Assertions.assertThat(item)
                .isNotNull();

        ItemManufacturerOTM manItemFromDb = entityManager.find(ItemManufacturerOTM.class, item.getId());

        Assertions.assertThat(manItemFromDb)
                .isNotNull();

        Assertions.assertThat(manItemFromDb.getItems()) // will fail if the @Transaction annotation is not there because of lack of persistence context
                .hasSize(10)
                .allMatch(it-> Objects.nonNull(it.getItemName()));

        ItemOTM item2Fetch = manItemFromDb.getItems().get(0);

        ItemOTM itemFromDb = entityManager.find(ItemOTM.class, item2Fetch.getId());

        Assertions.assertThat(itemFromDb)
                .isNotNull()
                .matches(it->Objects.nonNull(it.getItemManufacturer().getManufacturerName()),"manufacturer not found");

    }
}