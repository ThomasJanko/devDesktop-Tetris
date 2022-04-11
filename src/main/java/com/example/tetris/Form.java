package com.example.tetris;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Form {

    Rectangle a, b, c, d;
    Color color;
    String name;
    int form = 1;

    //Block composé de 4 petit carré
    public Form(Rectangle a, Rectangle b,Rectangle  c,Rectangle d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Form(Rectangle a, Rectangle b,Rectangle  c,Rectangle d, String name){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.name=name;

        //Couleur des block

        switch (name) {
            case "j":
                color = Color.SLATEGRAY;
                break;
            case "l":
                color = Color.DARKGOLDENROD;
                break;
            case "o":
                color = Color.INDIANRED;
                break;
            case "s":
                color = Color.FORESTGREEN;
                break;
            case "t":
                color = Color.CADETBLUE;
                break;
            case "p":
                color = Color.HOTPINK;
                break;
            case "z":
                color = Color.RED;
                break;

        }

        this.a.setFill(color);
        this.b.setFill(color);
        this.c.setFill(color);
        this.d.setFill(color);
    }



    //récupération de la lettre
    public String getName(){
        return name;
    }

    //rotation du block
    public void changeForm(){
        //ratation 360 degré max
        if(form !=4){
            form++;
        }
        //reviens à position de départ
        else {
            form = 1;
        }
    }



}

