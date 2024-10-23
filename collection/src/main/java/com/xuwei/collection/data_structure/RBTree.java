package com.xuwei.collection.data_structure;

/**
 * @program: study
 * @Date: 2024/10/22 11:37
 * @Author: Mr.Xu
 * @Description: 红黑树实现
 */
public class RBTree<K extends Comparable<K>,V> {

    public static void main(String[] args) throws InterruptedException {
        RBTree<String,String> tree = new RBTree<>();
        for (int i = 0; i < 10; i++) {
            tree.put("key:" + i,"value:"+i);
        }
        System.out.println(1);
    }

    private static final boolean RED = false;   // 红色节点状态常量
    private static final boolean BLACK = true;  // 黑色节点状态常量

    private RBNode<K, V> root; // 根节点

    // 1.旋转  2.变色  3.插值  4.删除  5.遍历

    /**
     * 插入元素
     * @param key
     * @param value
     */
    public void put(K key,V value){
        doPut(key, value);
        // TODO 加入旋转和变色操作
    }

    /**
     * 具体的插入操作
     * @param key
     * @param value
     */
    private void doPut(K key, V value) {
        if (key == null){
            throw new NullPointerException();
        }

        if (this.root == null){
            this.root = new RBNode<>(key,value,null);
            return;
        }
        RBNode<K, V> n = this.root;

        int cmp;
        RBNode<K, V> parent;
        do{
            parent = n;
            cmp = key.compareTo( n.key);
            if (cmp < 0){
                // 左侧找
                n = n.left;
            }else if (cmp > 0){
                n = n.right;
            }else {
                n.setValue(value);
                return;
            }
        }while (n != null);

        RBNode<K, V> node = new RBNode<>(key, value, parent);

        if (cmp < 0){
            parent.left = node;
        }else {
            parent.right = node;
        }
    }

    /**
     * 左旋
     *
     * @param p
     */
    public void leftRotate(RBNode<K, V> p) {
        if (p != null && p.right != null) {
            RBNode<K, V> rightChild = p.right;//右子节点
            p.right = rightChild.left;//将右子节点指向右子节点的左子节点
            if (rightChild.left != null) {
                rightChild.left.parent = p;//如果右子节点的左子节点不为空，就将其父节点指向p
            }
            rightChild.parent = p.parent;//更新右子节点的父节点为p节点的父节点
            if (p.parent == null) {
                root = rightChild;//如果p节点的父节点为空，说明p节点是root节点，所以右子节点现在成为root节点，root节点指向右子节点
            } else if (p == p.parent.left) {
                p.parent.left = rightChild;//如果p是父节点的左子节点，则把父节点的左子节点指向右子节点
            } else {
                p.parent.right = rightChild;//如果p是父节点的右节点，则把父节点的右子节点指向右子节点
            }
            rightChild.left = p; //将右子节点的左子节点指向p
            p.parent = rightChild;//将p节点的父节点指向右子节点

        }
    }

    /**
     * 右旋
     *
     * @param p
     */
    public void rightRotate(RBNode<K, V> p) {
        if (p != null && p.left != null) {
            RBNode<K, V> leftChild = p.left;
            p.left = leftChild.right;
            if (leftChild.right != null) {
                leftChild.right.parent = p;
            }

            leftChild.parent = p.parent;
            if (p.parent == null) {
                root = leftChild;
            } else if (p == p.parent.left) {
                p.parent.left = leftChild;
            } else {
                p.parent.right = leftChild;
            }

            leftChild.right = p;
            p.parent = leftChild;
        }
    }

    static class RBNode<K extends Comparable<K>, V> {

        private RBNode<K, V> parent; // 父节点
        private RBNode<K, V> left;   // 左子节点
        private RBNode<K, V> right;  // 右子节点

        private boolean color; // 节点颜色

        private K key;
        private V value;

        private RBNode(K key, V value, RBNode<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        public RBNode getParent() {
            return parent;
        }

        public void setParent(RBNode<K, V> parent) {
            this.parent = parent;
        }

        public RBNode getLeft() {
            return left;
        }

        public void setLeft(RBNode<K, V> left) {
            this.left = left;
        }

        public RBNode getRight() {
            return right;
        }

        public void setRight(RBNode<K, V> right) {
            this.right = right;
        }

        public boolean isColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        private void setValue(V value) {
            this.value = value;
        }

        private RBNode(boolean color, K key, V value,RBNode<K, V> parent) {
            this.color = color;
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        private RBNode(RBNode<K, V> parent, RBNode<K, V> left, RBNode<K, V> right, boolean color, K key, V value) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.color = color;
            this.key = key;
            this.value = value;
        }

        public RBNode() {
        }
    }

}
