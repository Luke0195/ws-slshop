package br.com.barbershop.domain;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="cities")
@SequenceGenerator(name="seq_cities",sequenceName = "seq_cities", allocationSize = 1, initialValue = 1)
public class City implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cities")
  private Long id;
  
  private String name;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="state_id")
  private State state;
  
  @Column(name = "created_at")
  private Instant createdAt;
  
  @Column(name="updated_at")
  private Instant updatedAt;

  @PrePersist
  void prePersist(){
    this.createdAt = Instant.now();
  }

  @PreUpdate
  void preUpdate(){
    this.updatedAt = Instant.now();
  }

  
}
