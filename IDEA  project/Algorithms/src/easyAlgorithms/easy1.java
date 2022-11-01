package easyAlgorithms;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/11 - 09 - 11
 * @Description: easyAlgorithms
 */

/**
 * 双指针排序
 */
public class easy1 {
    public int Translate (int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int left = 0;
        for (int right = 1; right < A.length; right++) {
            if (A[left] != A[right]) {
                A[++left] = A[right]; // ++在前面意味着加完之后
            }
        }
        return ++left;
    }

    public static void main(String[] args) {
        easy1 test = new easy1();
        int[] arr = {1,1,2};
        test.Translate(arr);
        System.out.println();

    }
}

//class easy2 {
//
//    public static int removeDuplicates(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        int left = 0;
//        int right = 1;
//        while (nums[left] == nums[right]) { // 只会判断一次
//            right++;
//        }
//        if (nums[right] != nums[left]) {
//            nums[++left] = nums[right];
//        }
//        return ++right;
//    }
//}
//
//

class easy2 {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 1;

        if (nums[left] == nums[right]) {// 只会判断一次
            right++;
        } else {
            nums[++left] = nums[right];
        }
        return ++left;
    }

}