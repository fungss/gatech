public class Testing {
    public static void main(String[] args){
        System.out.println("-------------testing begin-------------");
        ExternalChainingHashMap<Integer, Integer> testMap = new ExternalChainingHashMap<>();
        // System.out.printf("The initial size of the hashmap is: %d", testMap.size());
        // System.out.println();
        // System.out.printf("The initial length of the hashmap is: %d", testMap.getTable().length);
        // System.out.println();
        // // System.out.println("-------------add nulls-------------");
        // // System.out.println(testMap.put(null,64));
        // // System.out.println(testMap.put(32,null));
        // System.out.println("-------------simple adding-------------");
        // System.out.println(testMap.put(64,64));
        // System.out.println(testMap.put(32,32));
        // System.out.println(testMap.put(7,7));
        // System.out.printf("The size of the hashmap is: %d", testMap.size());
        // System.out.println();
        // System.out.println("-------------replace value if key duplicates-------------");
        // System.out.println(testMap.put(1, 1));
        // System.out.println(testMap.put(1, 2));
        // System.out.printf("The size of the hashmap is: %d", testMap.size());
        // System.out.println();
        // System.out.println("-------------chain if collide-------------");
        // System.out.println(testMap.put(92,92));
        // System.out.println(testMap.getTable()[1].getValue());
        // System.out.println(testMap.getTable()[1].getNext().getValue());
        // System.out.println(testMap.getTable()[1].getNext().getNext());
        // System.out.printf("The size of the hashmap is: %d", testMap.size());
        // System.out.println();
        // System.out.println("-------------resize if load factor above threshold-------------");
        // System.out.println(testMap.put(42,42));
        // System.out.println(testMap.put(43,43));
        // System.out.println(testMap.put(44,44));
        // System.out.println(testMap.put(44,47));
        // System.out.printf("The length of the hashmap is: %d", testMap.getTable().length);
        // System.out.println();
        // System.out.printf("The size of the hashmap is: %d", testMap.size());
        // System.out.println();
        // System.out.println("-------------test remove-------------");
        // System.out.println(testMap.remove(44));
        // System.out.printf("The size of the hashmap is: %d", testMap.size());
        // System.out.println();
        // System.out.println("-------------remove null-------------");
        // System.out.println(testMap.remove(null));
        // System.out.println("-------------remove non-existing key-------------");
        // System.out.println(testMap.remove(77));
        // System.out.printf("The size of the hashmap is: %d", testMap.size());
        // System.out.println();
    
    
        // from test report
        // failure 1
        // for (int i=0; i<9;i++){
        //     testMap.put(i,i);
        // }
        // System.out.printf("The size of the hashmap is: %d", testMap.size());
        // System.out.println();
        // System.out.printf("The length of the hashmap is: %d", testMap.getTable().length);
        // System.out.println();
        // failure 2
        // int[] input = new int[]{13, 53, 15, 3, 17, 5, 19, 218, 1};
        // for (int i:input){
        //     testMap.put(i,i);
        // }
        // System.out.printf("The length of the hashmap is: %d", testMap.getTable().length);
        // System.out.println();
        // System.out.println(testMap.getTable()[testMap.getTable().length-1].toString());
        // failure 3
        // for (int i=0; i<19; i++){
        //     testMap.put(i,i);
        // }
        // System.out.printf("The length of the hashmap is: %d", testMap.getTable().length);
        // System.out.println();
        // System.out.println(testMap.getTable()[18].toString());
        // System.out.println(testMap.getTable()[19]);
        // failure 4
        // testMap.put(4,4);
        // System.out.printf("The size of the hashmap is: %d", testMap.size());
        // System.out.println();
        // System.out.printf("The length of the hashmap is: %d", testMap.getTable().length);
        // System.out.println();
        // System.out.println(testMap.remove(4));
        // System.out.println(testMap.getTable()[4]);
        // failure 5
        // testMap.put(4,4);
        // System.out.printf("The size of the hashmap is: %d", testMap.size());
        // System.out.println();
        // System.out.printf("The length of the hashmap is: %d", testMap.getTable().length);
        // System.out.println();
        // System.out.println(testMap.remove(5));
        // System.out.println(testMap.getTable()[4]);
        // failure 6
        // int[] input = new int[]{37, 24, 11};
        // for (int i:input){
        //     testMap.put(i,i);
        // }
        // System.out.println(testMap.remove(24));
        // System.out.println(testMap.getTable()[11]);
        // System.out.println(testMap.getTable()[11].getNext());
        // failure 7
        // int[] input = new int[]{1, 6, 19, 8, 37, 24, 11};
        // for (int i:input){
        //     testMap.put(i,i);
        // }
        // System.out.println(testMap.remove(37));
        // System.out.println(testMap.getTable()[11]);
        // System.out.println(testMap.getTable()[11].getNext());
        // System.out.printf("The size of the hashmap is: %d", testMap.size());
        // failure 8
        // [Test Failure: remove] [-0.4] : NoSuchElementException not thrown when attempting to remove an element (without chaining) not in the HashMap.
        System.out.println(testMap.remove(37));
    }
}
