package com.qi.hashTable;

public class HashTable {
    /**
     * 节点类
     */
    public static class Entry {
        int hash; // 哈希码
        Object key; // 键
        public Object value; // 值
        public Entry next;

        public Entry(int hash, Object key, Object value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }


    public Entry[] table = new Entry[16];
    public int size = 0; // 元素个数
    float loadFactor = 0.75f; // 加载因子
    int threshold = (int) (loadFactor * table.length); // 阈值 12

    /**
     * 求模运算替换为位运算
     * 前提：数组长度是 2的n次方：
     * hash % 数组长度 等价于 hash &（数组长度-1）
     */

    // 根据 hash码获取value
    public Object get(int hash, Object key) {
        int index = hash & (table.length - 1);
        if (table[index] == null) {
            return null;
        }
        Entry p = table[index];
        while (p != null) {
            if (p.key.equals(key)) {
                return p.value;
            }
            p = p.next;
        }
        return null;
    }

    // 向 hash表存入新key value，如果key重复，则更新 value
    public void put(int hash, Object key, Object value) {
        int idx = hash & (table.length - 1);
        if (table[idx] == null) {
            // 1. idx 处有空位, 直接新增
            table[idx] = new Entry(hash, key, value);
        } else {
            // 2．idx 处无空位, 沿链表查找 有重复key更新，否则新增
            Entry p = table[idx];
            while (true) {
                if (p.key == key) {
                    p.value = value;
                    return;
                }
                // 数组最后一个数据为空
                if (p.next == null) {
                    break;
                }
                p = p.next;
            }
            p.next = new Entry(hash, key, value); // 新增
        }
        size++;
        if (size > threshold) {
            resize();
        }
    }

    // TODO P26-28
    private void resize() {
        Entry[] newTable = new Entry[table.length << 1];
        for (int i = 0; i < table.length; i++) {
            Entry p = table[i]; // 拿到每个链表头
            if (p != null) {
                // 拆分链表，移动到新数组
                /**
                 * 拆分规律
                 *  一个链表最多拆成两个
                 *  hash & table.length == 0 的一组
                 *  hash & table.length != 0 的一组
                 */
                // a b 代表各自链表的尾指针
                Entry a = null;
                Entry b = null;
                Entry aHead = null;
                Entry bHead = null;
                while (p != null) {
                    //规律：a链表保持索引位置不变，b链表 索引位置 + table.length
                    if ((p.hash & table.length) == 0) {
                        if (a != null) {
                            a.next = p;
                        } else {
                            aHead = p;
                        }
                        a = p; // 更新 a 链表的尾节点
                    } else {
                        if (b != null) {
                            b.next = p;
                        } else {
                            bHead = p;
                        }
                        // 更新 b 链表的尾节点
                        b = p;
                    }
                    p = p.next;
                }
                // 收尾工作
                if (a != null) {
                    a.next = null;
                    newTable[i] = aHead;
                }
                if (b != null) {
                    b.next = null;
                    newTable[i + table.length] = bHead;
                }
            }
        }
        table = newTable;
        threshold = (int) (loadFactor * table.length); // 阈值
    }

    // 根据 hash 码删除，返回删除的 value
    public Object remove(int hash, Object key) {
        int idx = hash & (table.length - 1);
        if (table[idx] == null) {
            return null;
        }
        Entry p = table[idx];
        Entry prev = null;
        while (p != null) {
            if (p.key == key) {
                if (prev != null) {
                    // 找到了删除
                    prev.next = p.next;
                } else {
                    table[idx] = p.next;
                }
                size--;
                return p.value;
            }
            prev = p;
            p = p.next;
        }
        return null;
    }

    public Object get(Object key) {
        int hash = key.hashCode();
        return get(hash, key);
    }

    public void put(Object key, Object value) {
        int hash = key.hashCode();
        put(hash, key, value);
    }

    public Object remove(Object key) {
        int hash = key.hashCode();
        return remove(hash, key);
    }

}
