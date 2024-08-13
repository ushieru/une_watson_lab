package com.ushieru.une.watson.lab.controller;

import com.ushieru.une.watson.lab.model.Book;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/books")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookController {

    @GET
    public List<Book> list (
        @QueryParam("title") String title,
        @QueryParam("author") String author
    ) {
        if (title != null) {
            return Book.list("title ILIKE ?1", "%" + title + "%");
        }
        if (author != null) {
            return Book.list("author.name ILIKE ?1", "%" + author + "%");
        }
        return Book.listAll();
    }
}
