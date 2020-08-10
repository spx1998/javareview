package com.algorithms.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串s和一些<b>长度相同</b>的单词words。找出 s 中恰好可以由words 中所有单词串联形成的子串的起始位置。
 * 注意子串要与words 中的单词完全匹配，中间不能有其他字符，但不需要考虑words中单词串联的顺序。
 * 我的解法：瞎了狗眼 没有看到<b>字符串等长</b>的条件。找出所有拼接后字符串的可能字符串，然后去s中进行匹配。超时。
 * 修改后的解法：用hashmap存words中的单词和出现的次数，然后逐个字符开始遍历字符串s，查看每len位字串是否出现在words中。
 * 优化：不必逐个字符遍历，前len个字符逐个开始遍历字符串，然后每次向后移动len位，移动后在hashmap中验证和增减两端的两个len位长的子串即可。
 *
 */
public class Solution30 {
    public static void main(String[] args) {
//        new Solution30().findSubstring("pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel",
//                new String[]{"dhvf", "sind", "ffsl", "yekr", "zwzq", "kpeo", "cila", "tfty", "modg", "ztjg", "ybty", "heqg", "cpwo", "gdcj", "lnle", "sefg", "vimw", "bxcb"}).forEach(System.out::println);
        new Solution30().findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"});
    }

    public List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int len = words[0].length();
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String str : words) {
            hashMap.merge(str.intern(), 1, Integer::sum);
        }
        for (int i = 0; i <= s.length() - len * words.length; i++) {
            HashMap<String, Integer> tempMap = new HashMap<>(hashMap);
            boolean include = true;
            for (int j = i; j < i + len * words.length; j += len) {
                if (tempMap.get(s.substring(j, j + len)) == null || tempMap.get(s.substring(j, j + len)) == 0) {
                    include = false;
                    break;
                }
                tempMap.put(s.substring(j, j + len), tempMap.get(s.substring(j, j + len)) - 1);
            }
            if (include) {
                list.add(i);
            }
        }
        return list;
    }

}
