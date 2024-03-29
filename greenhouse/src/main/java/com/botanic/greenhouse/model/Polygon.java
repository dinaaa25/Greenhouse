package com.botanic.greenhouse.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table
class Point {
    @Id
    @GeneratedValue
    private int id;

    public final int x;
    public final int y;

    @ManyToOne
    @JsonBackReference
    private Polygon polygon;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPolygon(Polygon polygon) {
        this.polygon = polygon;
    }

    public Polygon getPolygon() {
        return this.polygon;
    }

    // create and initialize a point with given (x, y)
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // return Euclidean distance between this point and that point
    public double distanceTo(Point that) {
        if (that == null) return Double.POSITIVE_INFINITY;
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        return Math.hypot(dx, dy);
    }

    // is a->b->c a counter-clockwise turn?
    // +1 if counter-clockwise, -1 if clockwise, 0 if collinear
    public static int ccw(Point a, Point b, Point c) {
        // return a.x*b.y - a.y*b.x + a.y*c.x - a.x*c.y + b.x*c.y - b.y*c.x;
        double area2 = (b.x - a.x) * (c.y - a.y) - (c.x - a.x) * (b.y - a.y);
        if (area2 < 0) return -1;
        else if (area2 > 0) return +1;
        else return 0;
    }

    // is a-b-c collinear?
    public static boolean collinear(Point a, Point b, Point c) {
        return ccw(a, b, c) == 0;
    }

    // is c between a and b?
    // Reference: O' Rourke p. 32
    public static boolean between(Point a, Point b, Point c) {
        if (ccw(a, b, c) != 0) return false;
        if (a.x == b.x && a.y == b.y) {
            return a.x == c.x && a.y == c.y;
        } else if (a.x != b.x) {
            // ab not vertical
            return (a.x <= c.x && c.x <= b.x) || (a.x >= c.x && c.x >= b.x);
        } else {
            // ab not horizontal
            return (a.y <= c.y && c.y <= b.y) || (a.y >= c.y && c.y >= b.y);
        }
    }


    // return string representation of this point
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}

@Entity
@Table
public class Polygon {
    @Id
    @GeneratedValue
    private int id;

    private int N;        // number of points in the polygon

    @OneToOne
    @JsonBackReference
    private Area area;

    @OneToMany(mappedBy = "polygon", cascade = {CascadeType.REMOVE})
    @JsonManagedReference
    private Point[] a;    // the points, setting points[0] = points[N]

    public int getN() {
        return N;
    }

    public Point[] getA() {
        return a;
    }

    // default buffer = 4
    public Polygon() {
        N = 0;
        a = new Point[4];
    }

    // double size of array
    private void resize() {
        Point[] temp = new Point[2 * N + 1];
        for (int i = 0; i <= N; i++) temp[i] = a[i];
        a = temp;
    }

    // return size
    public int size() {
        return N;
    }


    // add point p to end of polygon
    public void add(Point p) {
        if (N >= a.length - 1) resize();   // resize array if needed
        a[N++] = p;                        // add point
        a[N] = a[0];                       // close polygon
    }

    // return the perimeter
    public double perimeter() {
        double sum = 0.0;
        for (int i = 0; i < N; i++)
            sum = sum + a[i].distanceTo(a[i + 1]);
        return sum;
    }

    // return signed area of polygon
    public double area() {
        double sum = 0.0;
        for (int i = 0; i < N; i++) {
            sum = sum + (a[i].x * a[i + 1].y) - (a[i].y * a[i + 1].x);
        }
        return 0.5 * sum;
    }

    // does this Polygon contain the point p?
    // if p is on boundary then 0 or 1 is returned, and p is in exactly one point of every partition of plane
    // Reference: http://exaflop.org/docs/cgafaq/cga2.html
    public boolean contains2(Point p) {
        int crossings = 0;
        for (int i = 0; i < N; i++) {
            int j = i + 1;
            boolean cond1 = (a[i].y <= p.y) && (p.y < a[j].y);
            boolean cond2 = (a[j].y <= p.y) && (p.y < a[i].y);
            if (cond1 || cond2) {
                // need to cast to double
                if (p.x < (a[j].x - a[i].x) * (p.y - a[i].y) / (a[j].y - a[i].y) + a[i].x)
                    crossings++;
            }
        }
        if (crossings % 2 == 1) return true;
        else return false;
    }

    // does this Polygon contain the point p?
    // Reference: http://softsurfer.com/Archive/algorithm_0103/algorithm_0103.htm
    public boolean contains(Point p) {
        int winding = 0;
        for (int i = 0; i < N; i++) {
            int ccw = Point.ccw(a[i], a[i + 1], p);
            if (a[i + 1].y > p.y && p.y >= a[i].y)  // upward crossing
                if (ccw == +1) winding++;
            if (a[i + 1].y <= p.y && p.y < a[i].y)  // downward crossing
                if (ccw == -1) winding--;
        }
        return winding != 0;
    }


    // return string representation of this point
    public String toString() {
        if (N == 0) return "[ ]";
        String s = "";
        s = s + "[ ";
        for (int i = 0; i <= N; i++)
            s = s + a[i] + " ";
        s = s + "]";
        return s;
    }


}
