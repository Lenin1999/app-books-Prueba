package com.distribuida.rest;

import com.distribuida.clientes.authors.AuthorRestProxy;
import com.distribuida.db.Book;
import com.distribuida.servicios.BookRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookRest {

    @Inject BookRepository bookService;

    @RestClient
    @Inject
    AuthorRestProxy proxyAuthor;

    /**
     * GET          /books/{id}     buscar un libro por ID
     * GET          /books          listar todos
     * POST         /books          insertar
     * PUT/PATCH    /books/{id}     actualizar
     * DELETE       /books/{id}     eliminar
     */

    @GET
    @Operation(summary = "Retorna Todos los Libros de la Base de Datos")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Retorna un Libro Especifico de la Base de Datos")
    public Book findById(@PathParam("id") Integer id) {
        return bookService.findById(id);
    }




    @POST
    @Transactional
    @Operation(summary = "Crea un Nuevo Libro en la Base de Datos")
    public void insert(Book book) {


        bookService.insert(book);
    }



    @DELETE
    @Path("/{id}")

    @Transactional
    @Operation(summary = "Elimina un Libro Especifico de la Base de Datos")
    public void delete( @PathParam("id") Integer id ) {

        bookService.delete(id);

    }

    @PUT
    @Path("/{id}")
    @Transactional
    @Operation(summary = "Modifica un Libro Especifico de la Base de Datos")
    public void update(Book book, @PathParam("id") Integer id) {
        book.setId(id);

        bookService.update(book);
    }



}
