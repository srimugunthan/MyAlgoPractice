/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazebacktrack;

/**
 *
 * @author sdhandap
 */
public class Coords {
    int x;
        int y;

        public boolean equals(Object o) {
            Coords c = (Coords) o;
            return c.x == x && c.y == y;
        }

        public boolean equals(int xp, int yp) {

            return x == xp && y == yp;
        }

        public Coords(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

        public int hashCode() {
            return new Integer(x + "0" + y);
        }

        public void set(int xp, int yp) {
            this.x = xp;
            this.y = yp;
        }
}
