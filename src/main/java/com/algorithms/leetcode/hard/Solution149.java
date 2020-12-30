package com.algorithms.leetcode.hard;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * 解法：
 * 两个内部类line和pointer，遍历pointer，建立line。用count记录line中点的数量和坐标相同的pointer数量
 * 解法0：暴力法
 * 解法1：也暴力，但是计算b的值的时候，会出现浮点型计算导致的错误，实际上第一种方法也可能出现这个问题，只不过用例中没有。更严谨的做法应该用🈷约分后的分数表示a和b。
 */
public class Solution149 {
    public static void main(String[] args) {
        int i = new Solution149().maxPoints(new int[][]{{-54, -297}, {-36, -222}, {3, -2}, {30, 53}, {-5, 1}, {-36, -222}, {0, 2}, {1, 3}, {6, -47}, {0, 4}, {2, 3}, {5, 0}, {48, 128}, {24, 28}, {0, -5}, {48, 128}, {-12, -122}, {-54, -297}, {-42, -247}, {-5, 0}, {2, 4}, {0, 0}, {54, 153}, {-30, -197}, {4, 5}, {4, 3}, {-42, -247}, {6, -47}, {-60, -322}, {-4, -2}, {-18, -147}, {6, -47}, {60, 178}, {30, 53}, {-5, 3}, {-42, -247}, {2, -2}, {12, -22}, {24, 28}, {0, -72}, {3, -4}, {-60, -322}, {48, 128}, {0, -72}, {-5, 3}, {5, 5}, {-24, -172}, {-48, -272}, {36, 78}, {-3, 3}});
        System.out.println(i);
    }

    public int maxPoints0(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }
        int i = 0;
        for (; i < points.length - 1; i++) {
            if (points[i][0] != points[i + 1][0] || points[i][1] != points[i + 1][1]) {
                break;
            }

        }
        if (i == points.length - 1) {
            return points.length;
        }
        int max = 0;
        for (i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    continue;
                }
                int tempMax = 0;
                for (int k = 0; k < points.length; k++) {
                    if (k != i && k != j) {
                        if (test(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1])) {
                            tempMax++;
                        }
                    }

                }
                if (tempMax > max) {
                    max = tempMax;
                }
            }
        }
        //加上直线本身的两个点
        return max + 2;
    }

    private boolean test(int x1, int y1, int x2, int y2, int x, int y) {
        return (long) (y2 - y1) * (x - x2) == (long) (y - y2) * (x2 - x1);
    }


    //    y = ax+b;
    static class Line {
        Double a;
        Double b;
        int count;

        Line(Double a, Double b, Integer count) {
            this.a = a;
            this.b = b;
            this.count = count;
        }


        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Line)) {
                return false;
            }
            Line line = (Line) obj;
            return ((line.a == null && this.a == null) || (line.a != null && line.a.equals(this.a))) && line.b.equals(this.b);
        }
    }

    static class Point {
        int x;
        int y;
        int count;

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Point)) {
                return false;
            }
            Point p = (Point) obj;
            return this.x == p.x && this.y == p.y;
        }

        @Override
        public int hashCode() {
            return this.x + this.y + this.x * this.y;
        }
    }

    public int maxPoints(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        List<Point> pointList = new ArrayList<>(Arrays.stream(points).map(o -> {
            Point point = new Point();
            point.x = o[0];
            point.y = o[1];
            point.count = 1;
            return point;
        }).collect(Collectors.toMap(p -> p, p -> p, (a, b) -> {
            a.count++;
            return a;
        })).values());

        List<Line> lineList = new ArrayList<>();
        for (int i = 0; i < pointList.size(); i++) {
//            计算四条直线的a和b 有则count+1，无则新建。

            Point p1 = pointList.get(i);
            Double a, b;
            List<Line> lines = new ArrayList<>();

            for (int j = 0; j < i; j++) {
                Point p2 = pointList.get(j);
                if (p1.x == p2.x) {
                    a = null;
                    b = (double) p1.x;
                } else {
                    a = BigDecimal.valueOf(((double) (p1.y - p2.y)) / (double) (p1.x - p2.x)).setScale(15, BigDecimal.ROUND_DOWN).doubleValue();
                    if (a.equals(-0.0)) {
                        a = 0.0;
                    }
                    b = new BigDecimal(p1.y - a * p1.x).setScale(10, BigDecimal.ROUND_DOWN).doubleValue();
                }
                Line line = new Line(a, b, p1.count + p2.count);
                if (!lines.contains(line)) {
                    lines.add(line);
                }
            }
            for (Line line : lines) {
                if (lineList.contains(line)) {
                    lineList.get(lineList.indexOf(line)).count += p1.count;
                } else {
                    lineList.add(line);
                }
            }
        }
        lineList.stream().forEach(o -> {
            System.out.print(o.a+"   ");
            System.out.print(o.b+"   ");
            System.out.print(o.count);
            System.out.println();
        });
        return lineList.stream().map(o -> o.count).max(Integer::compareTo).orElse(pointList.stream().map(p -> p.count).max(Integer::compareTo).orElse(0));
    }
}
