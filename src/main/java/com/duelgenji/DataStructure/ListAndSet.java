package com.duelgenji.DataStructure;

public class ListAndSet {


    /**
     * 接口 interface
     * SortedSet
     * NavigableSet -> SortedSet 可以sub map
     *
     *
     * RandomAccess 支持快速随机访问( implementation : ArrayList  Vector<-Stack RandomAccessSubList )
     * AbstractSequentialList ( implementation : LinkedList ）
     *
     *
     */

    /**
     * List 可重复数据
     *
     * ArrayList 随机查询快 插入慢 ，容量不足时要增加，查快因为是直接查询，插入到指定位置慢是因为 arraycopy index之后的所有元素
     * 遍历用 for（int i=0 ....) ，因为直接按下标查更快
     *
     * LinkedList 随机查询慢 插入快，插入时查找index 找到后插入新节点，加速动作 < 1/2 从前往后，反之从后往前。
     * 遍历用 迭代器和foreach（底层实现就是迭代器 用的指针）
     *
     * Vector 线程安全 synchronized
     * 对比arraylist 多了扩容容量系数（另外2个是size 和 数据的数组）
     * 不支持序列化 arraylist 有 transient（短暂的）
     * 容量增加方式 vector是有系数+系数没有就*2，arrayList *1.5+1
     *
     * Stack 栈 后进先出 extends Vector ，但都弃用了
     *
     * Set 不重复数据
     *
     * HashSet 底层实现 HastMap 用的是HashMap的Key来保存 因为不可重复 value内部统一
     * TreeSet 底层 TreeMap 不重复且有序
     * LinkedHashSet
     * BitSet
     * EnumSet 抽象 具体根据数据是否大于 64
     * <=64 RegularEnumSet ,long elements
     * >64 JumboEnumSet, long elements[]
     */



}
