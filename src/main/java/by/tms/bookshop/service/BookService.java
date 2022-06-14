package by.tms.bookshop.service;
import by.tms.bookshop.entity.Book;
import by.tms.bookshop.entity.User;
import by.tms.bookshop.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public boolean addBook(Book book) {
        if (book != null) {
            bookRepository.save(book);
            return true;
        }
        return false;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> findBookById(long id) {
        return bookRepository.findById(id);
    }

    public boolean existBookById(long id) {
        return bookRepository.existsById(id);
    }

    public void addBook111(Book book, User user) {
        user.addBook(book);
    }

    public boolean deleteBook(Book book) {
        if (book != null) {
            bookRepository.delete(book);
            return true;
        }
        return false;
    }

//     public List <Book> addBookToBasket (Book book, int quantity){
//        int summ;
//         List<Book> listBooks = new ArrayList<>();
//         if (book!=null && book.getAmount()>=quantity) {
//             summ = book.getAmount() - quantity;
//             book.setAmount(summ);
//             listBooks.add(book);
//         }
//         listBooks.add(book);
//    return listBooks;
//}


//      public Double buyBooks (List <Book> books){
//       //   bookRepository - юзеру;
//          // cost
//
//      }
//
//    public String buyBook (Book book, int quantity){
//        double cost = 0;
//        if (quantity<=book.getAmount()){
//            cost = book.getCost()*quantity;
//            return "Книг на сумму "+ cost;
//        }
//        return "Столько книг нет, проверьте ко-во";
//    }

}
