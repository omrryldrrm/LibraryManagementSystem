package net.omrryldrm.library.repository;

import net.omrryldrm.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "select * from book e where  e.book_name like %:keyword% or e.book_series_name like %:keyword% or e.isbn_no like %:keyword%", nativeQuery = true)
    List<Book> findByKeyword(@Param("keyword") String keyword);

}
