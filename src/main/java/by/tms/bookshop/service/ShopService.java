package by.tms.bookshop.service;

import by.tms.bookshop.entity.Book;
import by.tms.bookshop.entity.Shop;
import by.tms.bookshop.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ShopService {

    @Autowired
    ShopRepository shopRepository;


    public boolean saveShop (Shop shop){
        shopRepository.save(shop);
        return true;
    }

    public Iterable <Shop> findAllInfo (){
        return shopRepository.findAll();
    }
}
