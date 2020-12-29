package com.algorithms.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 */
public class Solution149 {
    //    y = ax+b;
    static class Line {
        int a;
        int b;
        int count;

        Line(int a, int b) {
            this.a = a;
            this.b = b;
            count = 1;
        }


        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Line)) {
                return false;
            }
            Line line = (Line) obj;
            return line.a == this.a && line.b == this.b;
        }

    }

    public int maxPoints(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        List<Line> lineList = new ArrayList<>();
        for (int[] point : points) {
//            计算四条直线的a和b 有则count+1，无则新建。
            int a, b;
            a = 1;
            b = point[1] - point[0];
            Line line = new Line(a, b);
            if (lineList.contains(line)) {
                lineList.get(lineList.indexOf(line)).count += 1;
            } else {
                lineList.add(line);
            }

            a = -1;
            b = point[1] - point[0];
            line = new Line(a, b);
            if (lineList.contains(line)) {
                lineList.get(lineList.indexOf(line)).count += 1;
            } else {
                lineList.add(line);
            }

            a = 0;
            b = point[1];
            line = new Line(a, b);

            if (lineList.contains(line)) {
                lineList.get(lineList.indexOf(line)).count += 1;
            } else {
                lineList.add(line);
            }

            a = 2;
            b = point[0];
            line = new Line(a, b);
            if (lineList.contains(line)) {
                lineList.get(lineList.indexOf(line)).count += 1;
            } else {
                lineList.add(line);
            }
        }

        return lineList.stream().map(o -> o.count).max(Integer::compareTo).orElse(0);
    }
}
