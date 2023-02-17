package com.distribuida.servicios;

import com.distribuida.db.Book;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;


@ApplicationScoped

public class BookRepositoryImpl implements BookRepository {

    @PersistenceContext(unitName = "PersistBook")
    private EntityManager em;


    @Override
    public List<Book> findAll() {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b", Book.class);
        return query.getResultList();
    }

    @Override
    public Book findById(Integer id) {
    //  Book book = em.find(Book.class, Integer.valueOf(id));

        return em.find(Book.class, Integer.valueOf(id));
    }

    @Override
    public void insert(Book book) {
        em.persist(book);
    }



    @Override
    public void delete(Integer id) {
        em.remove(findById(id));
    }

    @Override
    public void update(Book book) {
       var BookU = findById(book.getId());
        BookU.setAuthor(book.getAuthor());
        BookU.setIsbn(book.getIsbn());
        BookU.setTitle(book.getTitle());
        BookU.setPrice(book.getPrice());
em.persist(BookU);
    }




}
