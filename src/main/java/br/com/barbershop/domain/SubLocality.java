package br.com.barbershop.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="sublocalities")
@SequenceGenerator(name = "seq_sublocality",sequenceName = "seq_sublocallity",  initialValue = 1, allocationSize = 1)
public class SubLocality implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_sublocality")
    private Long id;
    private String name;
    @Column(name="created_at")
    private Instant createdAt;
    @Column(name="updated_at")
    private Instant updatedAt;

    @PrePersist
    void prePersist(){
        this.createdAt = Instant.now();
    }

    @PreUpdate
    void preUpdated(){
        this.updatedAt = Instant.now();
    }

}
