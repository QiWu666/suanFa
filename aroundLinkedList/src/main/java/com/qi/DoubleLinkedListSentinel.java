package com.qi;

public class DoubleLinkedListSentinel {
    /**
     * 哨兵
     */
    private Node sentinel = new Node(null, -1, null);
    private static class Node{
        private Node prev;
        private int value;
        private Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    public DoubleLinkedListSentinel() {
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    /**
     * 添加到第一个
     * @param value 待加入值
     */
    public void addFirst(int value) {
        Node a = sentinel;
        Node b = sentinel.next;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    /**
     * 添加到最后一个
     * @param value 待加入值
     */
    public void addLast(int value) {
        Node a = sentinel.prev;
        Node b = sentinel;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    /**
     * 删除第一个
     */
    public void removeFirst() {
        //判断链表是否有节点
        Node removed = sentinel.next;
        if (removed==sentinel) {
            exc();
        }
        Node a = sentinel;
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }

    /**
     * 删除最后一个节点
     */
    public void removeLast() {
        Node removed = sentinel.prev;
        if (removed==sentinel) {
            exc();
        }
        Node a = sentinel;
        Node b = removed.prev;
        a.prev = b;
        b.next = a;
    }

    public void removeByValue(int value) {
        Node removed = fingByNode(value);
        if (removed == null) {
            return;
        }
        Node prev = removed.prev;
        Node next = removed.next;
        prev.next = next;
        next.prev = prev;
    }

    private Node fingByNode(int value) {
        Node p = sentinel.next;
        while (sentinel != p) {
            if (value == p.value) {
                return p;
            }
            p = p.next;
        }
        return null;
    }


    private static void exc() {
        throw new IllegalArgumentException("非法");
    }
}
