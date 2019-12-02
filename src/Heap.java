public class Heap {
    public int parent(int index) {
        return (index - 1) / 2;
    }
    public int left(int index) {
        return index * 2 + 1;
    }
    public int right(int index) {
        return index * 2 + 2;
    }
    public void heapify(int[] a, int n, int i) {
        int heapSize = n;
        int largest;
        int l = left(i);
        int r = right(i);

        if (l < heapSize && a[l] > a[i])
            largest = l;
        else
            largest = i;
        if (r < heapSize && a[r] > a[largest])
            largest = r;

        if (largest != i) {
            int swap = a[i];
            a[i] = a[largest];
            a[largest] = swap;

            heapify(a, n, largest);
        }
        /*
        int heapSize = a.length;
        int largest;
        int l = left(i);
        int r = right(i);
        if (left(i) > a.length- 1)
            l = a.length - 1;
        if (l <= heapSize && a[l] > a[i])
            largest = l;
        else
            largest = i;
        if (right(i) > a.length - 1)
            r = a.length - 1;
        if (r <= heapSize && a[r] > a[largest])
            largest = r;
        if (largest != i) {
            int swap = a[i];
            a[i] = a[largest];
            a[largest] = swap;

            heapify(a, largest);
        }

         */
    }
    public void buildHeap(int[] a) {
        int size = a.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(a, size, i);
        }
    }
    public void heapSort(int[] a) {
        int heapSize = a.length - 1;
        buildHeap(a);
        for (int i = heapSize; i >= 0; i--) {
            int swap = a[i];
            a[i] = a[0];
            a[0] = swap;
            heapSize -= 1;
            heapify(a, i, 0);
        }
    }
/*
    public void sort(int arr[])
    {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, i);

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, 0);
        }
    }


 */
    static void printArray(int arr[])
    {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};

        Heap ob = new Heap();
        ob.heapSort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}