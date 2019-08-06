package experiment;

import java.util.ArrayList;
import java.util.Arrays;

public class Array2ListTest {
    public static void main(String[] args) {
        int[] ints = {1,2,3,4,5};
        System.out.println(Arrays.asList(ints).size());//size为1，因为基本数据类型数组的aslist 会生成一个 数组的list，即该list 只有一个元素，是一个int数组。
        Integer[] integers = {1,2,3,4,5};
        System.out.println(Arrays.asList(integers).size());//size=5.
//        Arrays.asList(integers).add(6);//报错：UnsupportedOperationException aslist生成的数组 不支持add remove等操作。

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.toArray();//返回object[],但是object无法直接转化为string数组，而要遍历object数组，逐个转化。
        String[] strings = arrayList.toArray(new String[0]);//建议使用的toArray方法。
        System.out.println(Arrays.toString(strings));
    }
}
