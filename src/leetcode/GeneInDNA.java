package leetcode;

import com.sun.tools.javah.Gen;

import java.util.*;

public class GeneInDNA {

    public List<String> find(String dna, String[] genes) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String gene : genes) {
            map.put(gene, 0);
        }

        for (int i = 0; i < dna.length(); i++) {

            for (String gene : map.keySet()) {

                int cur = map.get(gene);
                char curChar = gene.charAt(cur);

                Set<String> added = new HashSet<>();
                if (curChar == dna.charAt(i)) {
                    cur++;
                    if (cur == gene.length()) {
                        res.add(gene);
                        added.add(gene);
                    } else {
                        map.put(gene, cur);
                    }
                } else {
                    map.put(gene, 0);
                }
                map.remove(added);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String dna = "TTTCATGGC";
        String[] genes = {"CAT", "TCATGGC", "GTAC", "TC"};
        GeneInDNA gd = new GeneInDNA();
        List<String> ans = gd.find(dna, genes);
        ans.forEach(s -> System.out.print(s + " "));
    }
}
