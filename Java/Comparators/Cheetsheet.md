//Sorting an array
Arrays.sort( arrayOfItems );
Arrays.sort( arrayOfItems, Collections.reverseOrder() );
Arrays.sort(arrayOfItems, 2, 6);
Arrays.parallelSort(arrayOfItems);

//Sorting a List
Collections.sort(numbersList);
Collections.sort(numbersList, Collections.reverseOrder());

//Sorting a Set
Set to List -> Sort -> List to Set
Collections.sort(numbersList);

//Sorting a Map
TreeMap<Integer, String> treeMap = new TreeMap<>(map);

unsortedeMap.entrySet()
    .stream()
    .sorted(Map.Entry.comparingByValue())
    .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

//Java 8 Lambda
Comparator<Employee> nameSorter = (a, b) -> a.getName().compareToIgnoreCase(b.getName());
Collections.sort(list, nameSorter);

Collections.sort(list, Comparator.comparing(Employee::getName));

//Group By Sorting
Collections.sort(list, Comparator
                        .comparing(Employee::getName)
                        .thenComparing(Employee::getDob));