class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> remaining = new ArrayList<>();
        int i, counter = 0;
        int arr[] = new int[arr1.length];

        for (i = 0; i < arr1.length; i++) {
            freqMap.put(arr1[i], freqMap.getOrDefault(arr1[i], 0) + 1);
        }

        for (i = 0; i < arr2.length; i++) {
            if (freqMap.containsKey(arr2[i])) {
                while (freqMap.get(arr2[i]) > 0) {
                    arr[counter] = arr2[i];
                    counter++;
                    freqMap.put(arr2[i], freqMap.get(arr2[i]) - 1);
                }
            } 
            freqMap.remove(arr2[i]);
        }

        //System.out.println(freqMap);

        for(Map.Entry<Integer, Integer> items : freqMap.entrySet()) {
            while(items.getValue() > 0) {
                remaining.add(items.getKey());
                freqMap.put(items.getKey(), items.getValue()-1);
            }
        }

        Collections.sort(remaining);

        for (int item : remaining) {
            arr[counter] = item;
            counter++;
        }

        return arr;
    }
}