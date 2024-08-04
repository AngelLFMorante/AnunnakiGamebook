package com.annunaki.gamebook.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "basepersonajes")
public class BasePersonaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "puntos_vida", nullable = false)
    @NotNull
    private int puntosVida; 
    
    @Column(name = "puntos_destino", nullable = false)
    @NotNull
    private int puntosDestino;
    
    @Column(name = "puntos_experiencia", nullable = false)
    @NotNull
    private int puntosExperiencia;
    
    @Column(name = "fuerza", nullable = false)
    @NotNull
    private int fuerza;
    
    @Column(name = "destreza", nullable = false)
    @NotNull
    private int destreza;

    @Column(name = "percepcion", nullable = false)
    @NotNull
    private int percepcion;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personaje_id", nullable = false, unique = true)
    private Personaje personajeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesion_id", nullable = false)
    private Profesion profesionId;

    
}
