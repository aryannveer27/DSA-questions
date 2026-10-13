
class Solution {
    public int maximumCount(int[] arr) {
        int n = arr.length;

        int low = 0, high = n - 1;
        int firstnonnegative = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= 0) {
                firstnonnegative = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        low = 0;
        high = n - 1;
        int firstpositive = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > 0) {
                firstpositive = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        int negativecount = firstnonnegative;
        int positivecount = n - firstpositive;

        return Math.max(negativecount, positivecount);
    }
}

