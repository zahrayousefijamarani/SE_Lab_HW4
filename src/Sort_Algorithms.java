
public class Sort_Algorithms {
    public static void main(String[] args) {
        list = new int[len_list];
        reset_list();
        // Please uncomment only one of the following lines to profile running of that algorithm, while the other line is commented.
//        bubble_sort();
        merge_sort(0, list.length - 1);
    }

    private static final int len_list = 400000;
    private static int[] list;

    private static void reset_list() {
        for (int i = 0; i < list.length; i++)
            list[i] = list.length - i;
    }

    private static void bubble_sort() {
        for (int i = list.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    private static void merge_sort(int low, int high) {
        if (low == high)
            return;
        int mid;
        mid = (low + high) / 2;
        merge_sort(low, mid);
        merge_sort(mid + 1, high);
        merge(low, high);
    }

    private static void merge(int low, int high) {
        int[] merged = new int[high - low + 1];
        int mid = (low + high) / 2;
        int i = low, j = mid + 1, merged_idx = 0;
        while (i <= mid && j <= high) {
            if (list[i] < list[j])
                merged[merged_idx++] = list[i++];
            else
                merged[merged_idx++] = list[j++];
        }
        if (i > mid)
            while (j <= high)
                merged[merged_idx++] = list[j++];
        else
            while (i <= mid)
                merged[merged_idx++] = list[i++];
        for (i = low; i <= high; i++)
            list[i] = merged[i - low];
    }
}
