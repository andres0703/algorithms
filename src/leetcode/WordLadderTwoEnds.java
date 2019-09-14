package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadderTwoEnds {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(!wordList.contains(endWord)) return 0;
        Set<String> words = new HashSet<>(wordList);
        Set<String> startSet = new HashSet<>(), endSet = new HashSet<>();
        int level = 1;

        startSet.add(beginWord);
        endSet.add(endWord);

        while (!startSet.isEmpty() && !endSet.isEmpty()) {

            if (startSet.size() < endSet.size()) {
                Set<String> swap = endSet;
                endSet = startSet;
                startSet = swap;
            }

            Set<String> temp = new HashSet<>();

            for (String s : startSet) {
                char[] arr = s.toCharArray();

                // construct new words
                for (int i = 0; i < arr.length; i++) {
                    char original = arr[i];

                    for (char c = 'a'; c <= 'z'; c++) {

                        arr[i] = c;
                        String target = String.valueOf(arr);
                        arr[i] = original;

                        if (endSet.contains(target)) return level + 1;
                        if (words.contains(target)) {
                            temp.add(target);
                            words.remove(target);
                        }
                    }
                }
            }

            startSet = temp;
            level++;
        }
        return 0;
    }

}