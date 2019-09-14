package test;

import java.util.*;

class NSum {

    public static void nSum(int[] input, int target, int n) {

        int[] nums = Arrays.copyOf(input, input.length);
        Map<Integer, List<Integer>> map = new HashMap<>();
        mapIndex(map, nums);

        Arrays.sort(nums);
        List<List<Integer>> numCombination = kSum(nums, 0, n, target);

        // each list in res is a index combination that sum to target
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> list : numCombination) {
            List<List<Integer>> idx = new ArrayList<>();
            // for each number in the combination, get it's list of index in the original array
            for (int i = 0; i < list.size(); i++) {
                idx.add(map.get(list.get(i)));
            }
            List<List<Integer>> permutatedList = permutate(idx);
            res.addAll(permutatedList);
        }

        Collections.sort(res, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                for (int i = 0; i < o1.size(); i++) {
                    int c = o1.get(i).compareTo(o2.get(i));
                    if (c != 0) {
                        return c;
                    }
                }
                return 0;
            }
        });
        printAnswer(res, target, input);
    }

    // get num to list of index mapping
    private static void mapIndex(Map<Integer, List<Integer>> map, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            List<Integer> idx = map.getOrDefault(nums[i], new ArrayList<>());
            idx.add(i);
            map.put(nums[i], idx);
        }
    }

    // return list of number combinations to get sum equals target
    private static List<List<Integer>> kSum (int[] nums, int start, int k, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        // base case: two sum
        if (k == 2) { //two pointers from left and right
            int left = start, right = len - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> path = new ArrayList<Integer>();

                    path.add(nums[left]);
                    path.add(nums[right]);
                    res.add(path);

                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < target) { //move left
                    left++;
                } else { //move right
                    right--;
                }
            }
        }

        // recursively call kSum
        else {
            for(int i = start; i < len - (k - 1); i++) {
                if(i > start && nums[i] == nums[i - 1]) continue;
                List<List<Integer>> temp = kSum(nums, i + 1, k - 1, target - nums[i]);
                for(List<Integer> t : temp) {
                    t.add(0, nums[i]);
                }
                res.addAll(temp);
            }
        }

        return res;
    }

    // permutation of index combinations
    private static List<List<Integer>> permutate(List<List<Integer>> input) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, input, new HashSet<>(), new HashSet<>());
        return res;
    }

    // helper function for permutation
    private static void backtrack(List<List<Integer>> res, List<List<Integer>> input, Set<Integer> set, Set<Set<Integer>> resSet) {
        if (set.size() == input.size()) {
            if (resSet.contains(set)) return;
            List<Integer> next = new ArrayList<>(set);
            Collections.sort(next);
            res.add(next);
            resSet.add(set);
            return;
        }

        List<Integer> nextIdxList = input.get(set.size());
        for (int idx : nextIdxList) {
            if (set.contains(idx)) continue;
            set.add(idx);
            backtrack(res, input, set, resSet);
            set.remove(idx);
        }
    }

    // print out the answer in required format
    private static void printAnswer(List<List<Integer>> res, int target, int[] nums) {
        if (res.size() == 0) {
            System.out.println("No answer found.");
            return;
        }

        for (List<Integer> list : res) {
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size() - 1) {
                    System.out.print("Element" + (list.get(i) + 1));
                } else {
                    System.out.print("Element" + (list.get(i) + 1) + " + ");
                }
            }
            System.out.print(" = " + target + "\n");

            for (int i = 0; i < list.size(); i++) {
                if (i == list.size() - 1) {
                    System.out.print(nums[list.get(i)]);
                } else {
                    System.out.print(nums[list.get(i)] + " + ");
                }
            }
            System.out.print(" = " + target + "\n\n");
        }
    }

    public static void main(String[] args) {
        //                      1   2   3   4    5   6   7    8    9    10    11   12   13   14
        int[] test = new int[]{ 3,  4,  6,  7,  10,  3,  9,  15,  17,  17,   -5,  10,   7,   -1};
        nSum(test, 20, 2);
        nSum(test, 20, 3);
        nSum(test, 20, 4);
    }
}
