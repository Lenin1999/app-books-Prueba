package com.distribuida.servicios;

import com.distribuida.db.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll( );

    Book findById(Integer id);

    void insert(Book book);

    void update( Book book);

   void delete( Integer id );
}
