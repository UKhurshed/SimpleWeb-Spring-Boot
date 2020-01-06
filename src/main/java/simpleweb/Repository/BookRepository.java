package simpleweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import simpleweb.Entity.BookNote;

@Repository
public interface BookRepository extends JpaRepository<BookNote, Long> {
}
