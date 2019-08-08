package offer_test.reorder_array;

public class ReOrderArray {
    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int l = 0, r = array.length - 1;
        while (l < r) {
            while (l < r && (array[l] & 0x01) == 1) {
                l++;
            }
            while (l < r && (array[r] & 0x01) == 0) {
                r--;
            }
            if (l < r) {
                int temp = array[l];
                array[l] = array[r];
                array[r] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        new ReOrderArray().reOrderArray(array);

        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
