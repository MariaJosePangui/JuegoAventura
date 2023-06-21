package com.mycompany.juegoaventura;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Jugador {
    private String nombre;
    private int vida;
    
    public Jugador(String nombre, int vida) {
        this.nombre = nombre;
        this.vida = vida;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getVida() {
        return vida;
    }
    
    public void recibirAtaque(int fuerza) {
        vida -= fuerza;
        if (vida < 0) {
            vida = 0;
        }
        System.out.println(nombre + " ha recibido un ataque. Vida restante: " + vida);
    }
    
    public boolean estaVivo() {
        return vida > 0;
    }
    
    public void atacar(Enemigo enemigo) {
        int ataque = new Random().nextInt(10) + 1;
        System.out.println(nombre + " ataca a " + enemigo.getNombre() + " con fuerza " + ataque);
        enemigo.recibirAtaque(ataque);
    }
    
    public void atacar(Jugador jugador) {
        int ataque = new Random().nextInt(10) + 1;
        System.out.println(nombre + " ataca a " + jugador.getNombre() + " con fuerza " + ataque);
        jugador.recibirAtaque(ataque);
    }
}

class Enemigo {
    private String nombre;
    private int fuerza;
    private int velocidad;
    
    public Enemigo(String nombre, int fuerza, int velocidad) {
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.velocidad = velocidad;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getFuerza() {
        return fuerza;
    }
    
    public int getVelocidad() {
        return velocidad;
    }
    
    public void recibirAtaque(int fuerza) {
        System.out.println(nombre + " ha recibido un ataque. Vida restante: " + fuerza);
    }
    
    public void atacar(Jugador jugador) {
        int ataque = fuerza + new Random().nextInt(10) + 1;
        jugador.recibirAtaque(ataque);
    }
}

public class JuegoAventura {
    public static void main(String[] args) {
        Jugador jugador1 = new Jugador("Jugador 1", 100);
        Jugador jugador2 = new Jugador("Jugador 2", 100);
        
        Enemigo enemigo1 = new Enemigo("Orco",  20, 5);
        Enemigo enemigo2 = new Enemigo("Esqueleto", 15, 8);
        Enemigo enemigo3 = new Enemigo("Goblin", 10, 10);
        
        System.out.println("Comienza la aventura:");
        
        // Combate entre jugadores
        jugador1.atacar(jugador2);
        jugador2.atacar(jugador1);
        
        System.out.println();
        
        // Combate contra enemigos
        jugador1.atacar(enemigo1);
        enemigo1.atacar(jugador1);
        
        jugador2.atacar(enemigo2);
        enemigo2.atacar(jugador2);
    
        jugador1.atacar(enemigo3);
        enemigo3.atacar(jugador1);
    }
}