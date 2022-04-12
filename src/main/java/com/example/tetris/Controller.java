package com.example.tetris;

import javafx.scene.shape.Rectangle;

public class Controller {

    //récupérer les infos du Tetris

    static final int MOVE = Tetris.MOVE;
    static final int SIZE = Tetris.SIZE;
    static int X_MAX = Tetris.X_MAX;
    static int Y_MAX = Tetris.Y_MAX;
    static int [][] MESH =  Tetris.MESH;



    public static Form makeBlock(){

        //Couleur aléatoire du block
        int block = (int) (Math.random()* 100);
        String name;

        //block composé de 4 petit carré
        Rectangle a = new Rectangle(SIZE-1, SIZE-1),
                b = new Rectangle(SIZE-1, SIZE-1),
                c = new Rectangle(SIZE-1, SIZE-1),
                d = new Rectangle(SIZE-1, SIZE-1);

        if (block < 15) {
            a.setX(X_MAX / 2 - SIZE);
            b.setX(X_MAX / 2 - SIZE);
            b.setY(SIZE);
            c.setX(X_MAX / 2);
            c.setY(SIZE);
            d.setX(X_MAX / 2 + SIZE);
            d.setY(SIZE);
            name = "j";
        } else if (block < 30) {
            a.setX(X_MAX / 2 + SIZE);
            b.setX(X_MAX / 2 - SIZE);
            b.setY(SIZE);
            c.setX(X_MAX / 2);
            c.setY(SIZE);
            d.setX(X_MAX / 2 + SIZE);
            d.setY(SIZE);
            name = "l";
        } else if (block < 45) {
            a.setX(X_MAX / 2 - SIZE);
            b.setX(X_MAX / 2);
            c.setX(X_MAX / 2 - SIZE);
            c.setY(SIZE);
            d.setX(X_MAX / 2);
            d.setY(SIZE);
            name = "o";
        } else if (block < 60) {
            a.setX(X_MAX / 2 + SIZE);
            b.setX(X_MAX / 2);
            c.setX(X_MAX / 2);
            c.setY(SIZE);
            d.setX(X_MAX / 2 - SIZE);
            d.setY(SIZE);
            name = "s";
        } else if (block < 75) {
            a.setX(X_MAX / 2 - SIZE);
            b.setX(X_MAX / 2);
            c.setX(X_MAX / 2);
            c.setY(SIZE);
            d.setX(X_MAX / 2 + SIZE);
            name = "t";
        } else if (block < 90) {
            a.setX(X_MAX / 2 + SIZE);
            b.setX(X_MAX / 2);
            c.setX(X_MAX / 2 + SIZE);
            c.setY(SIZE);
            d.setX(X_MAX / 2 + SIZE + SIZE);
            d.setY(SIZE);
            name = "z";
        } else {
            a.setX(X_MAX / 2 - SIZE - SIZE);
            b.setX(X_MAX / 2 - SIZE);
            c.setX(X_MAX / 2);
            d.setX(X_MAX / 2 + SIZE);
            name = "p";
        }
        return new Form(a, b, c, d, name);
    }

    //Déplacement des blocks

    //Déplacement Droite
    public static void MoveRight(Form form){
        if(form.a.getX() + MOVE <= X_MAX - SIZE && form.b.getX() + MOVE <= X_MAX - SIZE
                && form.c.getX() + MOVE <= X_MAX - SIZE && form.d.getX() + MOVE <= X_MAX - SIZE){

            int movea = MESH[((int) form.a.getX()/SIZE) +1][((int) form.a.getY() / SIZE)];
            int moveb = MESH[((int) form.b.getX()/SIZE) +1][((int) form.b.getY() / SIZE)];
            int movec = MESH[((int) form.c.getX()/SIZE) +1][((int) form.c.getY() / SIZE)];
            int moved = MESH[((int) form.d.getX()/SIZE) +1][((int) form.d.getY() / SIZE)];

            if(movea ==0 && movea == moveb && moveb == movec && movec == moved){
                form.a.setX(form.a.getX() + MOVE);
                form.b.setX(form.b.getX() + MOVE);
                form.c.setX(form.c.getX() + MOVE);
                form.d.setX(form.d.getX() + MOVE);
            }

        }
    }

    //Déplacement Gauche
    public static void MoveLeft(Form form){
        if(form.a.getX() - MOVE >= 0 && form.b.getX() - MOVE >= 0
                && form.c.getX() - MOVE >= 0 - SIZE && form.d.getX() - MOVE >= 0){

            int movea = MESH[((int) form.a.getX()/SIZE) -1][((int) form.a.getY() / SIZE)];
            int moveb = MESH[((int) form.b.getX()/SIZE) -1][((int) form.b.getY() / SIZE)];
            int movec = MESH[((int) form.c.getX()/SIZE) -1][((int) form.c.getY() / SIZE)];
            int moved = MESH[((int) form.d.getX()/SIZE) -1][((int) form.d.getY() / SIZE)];

            if(movea ==0 && movea == moveb && moveb == movec && movec == moved){
                form.a.setX(form.a.getX() - MOVE);
                form.b.setX(form.b.getX() - MOVE);
                form.c.setX(form.c.getX() - MOVE);
                form.d.setX(form.d.getX() - MOVE);
            }

        }
    }

}
