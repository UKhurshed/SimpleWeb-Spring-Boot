package simpleweb.repository.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import simpleweb.repository.entity.abs.BaseEntity;

@Entity
@Table(name = "book")
@Getter
@Setter
public class Book extends BaseEntity {
    private String name;
    private String description;
    private String author;
}
