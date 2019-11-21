public class Heap {

    //int[] a = {1,3,5,2,4,9,7,8};
    public int parent(int index) {
        return (int)index / 2;
    }
    public int left(int index) {
        return index * 2;
    }
    public int right(int index) {
        return index * 2 + 1;
    }
    public void heapify(int[] a, int i) {
        int heapSize = a.length;
        int largest;
        int l = left(i);
        int r = right(i);
        if (l <= heapSize && a[l] > a[i])
            largest = l;
        else
            largest = i;
        if (r <= heapSize && a[r] > a[largest])
            largest = r;
        if (largest != i) {
            int swap = a[i];
            a[i] = a[largest];
            a[largest] = swap;

            heapify(a, largest);
        }
    }
    public void buildHeap(int[] a) {
        int size = a.length;
        for (int i = size / 2; i >= 0; i+=-1) {
            heapify(a, i);
        }
    }
    public void heapSort(int[] a) {
        int heapSize = a.length;
        buildHeap(a);
        for (int i = a.length; i >= 1; i+=-1) {
            int swap = a[i];
            a[i] = a[1];
            a[1] = swap;
            heapSize -=1;
            heapify(a, 1);
        }
    }

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





    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        Heap ob = new Heap();
        ob.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}
