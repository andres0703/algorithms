package leetcode;

public class WaterPlants {

    public int countSteps(int[] input, int cap) {
        int n = input.length;
        int steps = 0, remain = cap;

        for (int i = 0; i < n; i++) {
            if (remain < input[i]) {
                steps += 2 + 2 * (i - 1);
                remain = cap;
            }
            steps++;
            remain -= input[i];
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 4, 5, 1, 2};
        WaterPlants waterPlants = new WaterPlants();
        System.out.println(waterPlants.countSteps(input, 6));
    }
}
