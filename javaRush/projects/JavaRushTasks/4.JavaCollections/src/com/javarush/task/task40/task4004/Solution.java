package com.javarush.task.task40.task4004;

import java.util.ArrayList;
import java.util.List;

/* 
Принадлежность точки многоугольнику
http://www.sanfoundry.com/java-program-check-whether-given-point-lies-given-polygon/
https://habrahabr.ru/post/144571/
*/

class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public static void main(String[] args) {
        List<Point> polygon = new ArrayList<>();
        polygon.add(new Point(0, 0));
        polygon.add(new Point(0, 10));
        polygon.add(new Point(10, 10));
        polygon.add(new Point(10, 0));

        System.out.println(isPointInPolygon(new Point(5, 5), polygon));
        System.out.println(isPointInPolygon(new Point(100, 100), polygon));
    }

    public static boolean isPointInPolygon(Point point, List<Point> polygon) {

        //напишите тут ваш код
        // A point is inside the polygon if either count of intersections is odd or point lies on an edge of polygon.
        // If none of the conditions is true, then point lies outside
        boolean result = false;
        int INF = 10000;
        int n = polygon.size();

        // If number of point less then 3 (triangular) - return false
        if (n < 3) return false;

        // Get extreme point (x coordinate "infinite" = 10,000)
        // Draw a horizontal line to the right of each point and extend it to infinity
        Point extreme = new Point(INF, point.y);

        // Count the number of times the line intersects with polygon edges
        int count = 0;
        int i = 0;
        do {
            int next = (i + 1) % n;
            if (doIntersect(polygon.get(i), polygon.get(next), point, extreme)) {
                if (orientation(polygon.get(i), point, polygon.get(next)) == 0)
                    return onSegment(polygon.get(i), point, polygon.get(next));

                count++;
            }
            i = next;
        } while (i != 0);

        // if count number odd - intersects
        return (count & 1) == 1 ? true : false;
    }


    public static boolean onSegment(Point p, Point q, Point r)
    {
        if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x)
                && q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y))
            return true;
        return false;
    }

    // Check where point r is (on line pq, to the left or to the right)
    // Vector pq x Vector qr: z = PxQy - PyQx
    // z > 0 (from the left)
    // z < 0 (from the right)
    // z = 0 PQ & QR on the same line
    public static int orientation(Point p, Point q, Point r) {

        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

        if (val == 0)   return 0;
        return (val > 0) ? 1 : 2;
    }

    // Arguments 4 points:
    // p1 - point of polygon
    // q1 - next point of polygon
    // p2 - point to check
    // q2 - extreme point
    public static boolean doIntersect(Point p1, Point q1, Point p2, Point q2) {

        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);

        if (o1 != o2 && o3 != o4)               return true;

        if (o1 == 0 && onSegment(p1, p2, q1))   return true;

        if (o2 == 0 && onSegment(p1, q2, q1))   return true;

        if (o3 == 0 && onSegment(p2, p1, q2))   return true;

        if (o4 == 0 && onSegment(p2, q1, q2))   return true;

        return false;
    }
}

