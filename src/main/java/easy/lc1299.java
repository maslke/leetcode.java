class lc1299 {
    public int[] replaceElements(int[] arr) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                arr[i] = -1;
            } else {
                if (i < index) {
                    arr[i] = arr[index];
                } else {
                    index = maxIndex(arr, i + 1);
                    arr[i] = arr[index];
                }
            }
        }   
        return arr;
    }
    
    private int maxIndex(int[] arr, int begin) {
        int max = Integer.MIN_VALUE;
        int result = -1;
        for (int i = begin; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                result = i;
            }
        }
        return result;
    }
}