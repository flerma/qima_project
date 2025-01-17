package com.qima.productsapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent", referencedColumnName = "id")
    private Category parent;

    @Column
    private Integer depthLevel;

    @Column
    private Boolean isLeaf;

    @Column
    private Long creationUser;

    @Column
    private LocalDateTime creationDate;

    @Column
    private Long updateUser;

    @Column
    private LocalDateTime updateDate;

    public String getCategoryPath() {
        List<String> path = new ArrayList<>();
        Category current = this;
        while (current != null) {
            path.add(0, current.name);
            current = current.parent;
        }
        return String.join(" > ", path);
    }
}
