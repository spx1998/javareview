package Algorithms.JZoffer;

import java.util.LinkedHashMap;

public class Question54 {
    private LinkedHashMap<Character,Integer> hashMap = new LinkedHashMap<>();
    public void Insert(char ch)
    {
        if(hashMap.get(ch)==null)
            hashMap.put(ch,1);
        else hashMap.remove(ch);
    }
    public char FirstAppearingOnce()
    {
        if(hashMap.size()==0)
            return '#';
        else {
            for(char c:hashMap.keySet()){
                return c;
            }
        }
        return '#';
    }
}
