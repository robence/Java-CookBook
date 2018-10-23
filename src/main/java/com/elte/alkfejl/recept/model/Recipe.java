package com.elte.alkfejl.recept.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "RECIPES")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column
    @NotNull
    private String name;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime created_at;

    @Column
    @UpdateTimestamp
    private LocalDateTime updated_at;

//    @OneToMany(mappedBy = "issue")
//    private List<Ingredient> ingredients;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private User user;
}


