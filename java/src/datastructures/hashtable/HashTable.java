package datastructures.hashtable;

import datastructures.linkedlist.LinkedList;

public class HashTable<T> {

    public static void main(String[] args) {
        HashTable<String> hashTable = new HashTable<String>();
        Node<String> node  = new Node<String>();
        node.key = "MyKey";
        node.value = "Hello!";

        Node<String> node2  = new Node<String>();
        node2.key = "TheKey";
        node2.value = "Hello2!";

        hashTable.put(node);
        hashTable.put(node2);

        System.out.println(hashTable.toString());
        System.out.println(hashTable.getItemByKey(node.key));
    }

    int maxSize = 10;
    int size = 0;

    LinkedList<Node>[] hashTable = new LinkedList[maxSize];

    int getHash(String key) {
        char c = key.toLowerCase().charAt(0);
        return (c - 'a') % maxSize;
    }

    public void put(Node node) {
        if (size == (hashTable.length - 1)) {
            duplicate();
        }
        int hash = getHash(node.key);

        if (hashTable[hash] == null) hashTable[hash] = new LinkedList<>();
        LinkedList<Node> itemList = hashTable[hash];

        itemList.addValue(node);
        hashTable[hash] = itemList;
        size++;
    }

    private void duplicate() {
        maxSize = maxSize * 2;
        LinkedList<Node>[] newHashTable = new LinkedList[maxSize];
        for (int i = 0; i < hashTable.length; i++) {
            newHashTable[i] = hashTable[i];
        }
        hashTable = newHashTable;
    }

    private LinkedList<Node> getItemByKey(String key) {
        int hash = getHash(key);
        if (hashTable[hash] == null) return null;
        return hashTable[hash];
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MAX-SIZE: " + maxSize + ";\n");
        stringBuilder.append("ACTUAL-SIZE: " + size + ";\n");
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] == null) continue;
            stringBuilder.append("POSITION: " + i + "; KEY-VALUES: " + hashTable[i].toString());
            stringBuilder.append("\n\n\n");
        }

        return stringBuilder.toString();
    }


    static class Node<T> {
        String key;
        T value;

        @Override
        public String toString() {
            return "Key: " + key + "; Value: " + value.toString();
        }
    }
}
