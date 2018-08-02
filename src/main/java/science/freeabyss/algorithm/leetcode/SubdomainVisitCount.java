package science.freeabyss.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 子域名访问次数统计
 *
 * @author abyss
 * @date 2018/4/19
 */
public class SubdomainVisitCount {
    public static List<String> solution(String[] cpdomains) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> resultMap = new HashMap<>();
        for (String domain : cpdomains) {
            String[] domainArr = domain.split(" ");
            int num = Integer.valueOf(domainArr[0]);
            String address = domainArr[1];
            while (true) {
                resultMap.put(address, resultMap.getOrDefault(address, 0) + num);

                int index = address.indexOf(".");
                if (index != -1) {
                    address = address.substring(index + 1);
                } else {
                    break;
                }
            }
        }
        resultMap.forEach((k, v) -> result.add(v + " " + k));
        return result;
    }

    public static List<String> solution1(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap<>();
        for (String domain : cpdomains) {
            String[] cpinfo = domain.split("\\s+");
            String[] frags = cpinfo[1].split("\\.");
            int count = Integer.valueOf(cpinfo[0]);
            String cur = "";
            for (int i = frags.length - 1; i >= 0; --i) {
                cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
                counts.put(cur, counts.getOrDefault(cur, 0) + count);
            }
        }

        List<String> ans = new ArrayList<>();
        for (String dom : counts.keySet())
            ans.add("" + counts.get(dom) + " " + dom);
        return ans;
    }

    public static List<String> solution2(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cd : cpdomains) {
            int i = cd.indexOf(' ');
            int n = Integer.valueOf(cd.substring(0, i));
            String s = cd.substring(i + 1);
            for (i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '.') {
                    String d = s.substring(i + 1);
                    map.put(d, map.getOrDefault(d, 0) + n);
                }
            }
            map.put(s, map.getOrDefault(s, 0) + n);
        }

        List<String> res = new ArrayList<>();
        for (String d : map.keySet()) res.add(map.get(d) + " " + d);
        return res;
    }

    public static void main(String[] args) {
        String[] output = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(solution(output).stream().collect(Collectors.joining(",", "[", "]")));
    }
}
