package com.qi.hashTable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HashTableTest {

    private HashTable table = new HashTable();

    @Test
    public void testPut() {
        // 测试空桶插入新键值对
        table.put(10, "key1", "value1");
        assertEquals("value1", table.get(10, "key1"));
        assertEquals(1, table.size);

        // 测试同一hash且key相同的情况，更新已有键值对
        table.put(10, "key1", "newValue");
        assertEquals("newValue", table.get(10, "key1"));
        assertEquals(1, table.size);

        // 测试链表中存在多个元素时的插入和更新操作
        table.put(20, "key2", "value2");
        assertEquals("value2", table.get(20, "key2"));
        table.put(20, "key3", "value3"); // 同一个桶内新增键值对
        assertEquals("value3", table.get(20, "key3"));
        table.put(20, "key4", "value4"); // 再次新增键值对
        assertEquals("value4", table.get(20, "key4"));
        assertEquals(4, table.size);

    }

    @Test
    void put2() {

        // Put values into the table
        table.put(1, "zhang", "张三");
        table.put(17, "li", "李四");
        table.put(2, "wang", "王五");

        // Check the size of table
        assertEquals(3, table.size);
        // Access values from the table
        assertEquals("张三", table.table[1].value);
        assertEquals("李四", table.table[1].next.value);

        // Overwrite the values in the table
        table.put(1, "zhang", "张4");
        table.put(17, "li", "李5");
        assertEquals("张4", table.table[1].value);
        assertEquals("李5", table.table[1].next.value);

    }

    @Test
    void remove1() {
        HashTable table = new HashTable();
        table.put(1, "zhang", "张三");//1
        table.put(17, "li","李四");//1
        table.put(2, "wang", "王五");
        table.remove(1, "zhang");
        assertEquals(2, table.size);
        assertEquals("李四", table.table[1].value);
        assertNull(table.table[1].next);
    }

    @Test
    void remove2() {
        HashTable table = new HashTable();
        table.put(1, "zhang", "张三"); // 将 key: "zhang", value: "张三" 存入哈希表
        table.put(17, "li", "李四"); // 将 key: "li", value: "李四" 存入哈希表
        table.put(2, "wang", "王五"); // 将 key: "wang", value: "王五" 存入哈希表
        table.remove(17, "li"); // 移除 key: "li" 对应的条目
        assertEquals(2, table.size); // 断言哈希表的大小为 2
        assertEquals("张三", table.table[1].value); // 断言 key: "zhang" 对应的值为 "张三"
        assertNull(table.table[1].next); // 断言 key: "li" 对应的值为空（已被移除）
    }

    @Test
    void testHashBoom() {
        HashTable table = new HashTable();
        for (int i = 0; i < 200; i = i+16) {
            table.put(i, i, i);
        }
        System.out.println(table);
    }
}
