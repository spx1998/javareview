package Algorithms.practice.huawei2019;

import java.util.*;

/**
 *给定多组原本的航班预订信息（航班号，座位号，乘客姓名），以及多组要改签的航班信息（原本航班号，原本座位号，新航班号，新座位号）
 * 输出最后的航班预订信息，要是有重复的内容，以最新改签的为标准
 * 输入的内容如下： 3 表示原本的航班信息数，2表示要改签的航班数
  3
  CZ7132,A1,ZHANGSAN
  CZ7132,A2,ZHAOSI
  CZ7156,A2,WANGWU
  2
  CZ7132,A1,CZ7156,A2
  CZ7156,A2,CZ7156,A3
 *
 * 输出内容如下：
 * CZ7132,A2,ZHAOSI
 * CZ7156,A2,ZHANGSA
 * CZ7156,A3,WANGW
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            ArrayList<Information> information = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                String s = scanner.next();
                String[] strings = s.split(",");
                information.add(new Information(strings[0], strings[1], strings[2]));
            }
            int m = scanner.nextInt();
            for (int i = 0; i < m; i++) {
                String s = scanner.next();
                String[] strings = s.split(",");
                String name = "";
                Iterator<Information> it = information.iterator();
                while (it.hasNext()) {
                    Information infor = it.next();
                    if (infor.a.equals(strings[0]) && infor.b.equals(strings[1])) {
                        name = infor.c;
                        it.remove();
                        break;
                    }
                }
                information.add(new Information(strings[2], strings[3], name));
            }
            ArrayList<String> arrayList = new ArrayList<>();
            HashSet<Information> hashSet = new HashSet<>();
            for(Information infor:information){
                if(!hashSet.add(infor)){
                    hashSet.remove(infor);
                    hashSet.add(infor);
                }
            }
            for (Information infor : hashSet) {
                arrayList.add(infor.a + "," + infor.b + "," + infor.c);
            }
            Collections.sort(arrayList);
            for (String infor : arrayList) {
                System.out.println(infor);
            }
        }
    }
    static class Information{
        public String a;
        public String b;
        public String c;
        public Information(String a,String b, String c){
            this.a =a;
            this.b =b;
            this.c =c;
        }
        @Override
        public int hashCode(){
            return 0;
        }
        @Override
        public boolean equals(Object o){
            Information infor = (Information)o;
            if(infor.a.equals(this.a)&&infor.b.equals(this.b)){
                return true;
            }
            if(infor.c.equals(this.c)&&infor.a.equals(this.a)){
                return true;
            }
            return false;

        }

    }

}
