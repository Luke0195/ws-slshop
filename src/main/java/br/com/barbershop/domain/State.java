package br.com.barbershop.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="tb_states")
@SequenceGenerator(name = "seq_state", sequenceName = "seq_state", allocationSize = 1, initialValue = 1)
public class State implements Serializable{

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_state")
  private Long id;
  private String name;
  private String uf;
}