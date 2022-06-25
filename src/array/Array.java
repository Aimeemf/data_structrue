package array;


public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity){
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public Array(E[] arr){
        this.data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        this.size = arr.length;
    }

    public Array(){
        this(10);
    }

    public int getSize(){
        return this.size;
    }

    public int getCapacity(){
        return this.data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //在数组头添加一个元素
    public void addFirst(E e){
        add(0, e);
    }

    //向所有元素后添加一个新元素
    public void addLast(E e){
//        if(size == data.length){
//            throw new IllegalArgumentException("AddLast failed. Array is full.");
//        }
//        data[size] = e;
//        size ++;
        add(size, e);
    }

    //在第index个位置插入一个新元素e
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index < size.");
        }

        if(size == data.length){
            reSize(2*data.length);
        }

        for(int i = size-1; i >= index; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //获取index索引位置的元素
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    //获取首位置的元素
    public E getFirst(){
       return get(0);
    }

    //获取index索引位置的元素
    public E getLast(){
        return get(size-1);
    }

    //修改index索引位置的元素为e
    public E set(int index, E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        return data[index] = e;
    }

    //查找数组中是否有元素e
    public boolean contains(E e){
        for(int i = 0; i < size; i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    //查找数组中元素e的索引,不存在则返回-1
    public int find(E e){
        for(int i = 0; i < size; i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    //删除数组中索引为index的元素,返回删除的元素
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("delete failed. Index is illegal.");
        }
        E ret = data[index];
        for(int i = index + 1; i < size; i++){
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;
        if(size == data.length / 4 && data.length / 2 != 0){
            reSize(data.length / 2);
        }
        return ret;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    //交换i和j
    public void swap(int i, int j){
        if(i < 0 || i >= size || j <0 || j >= size){
            throw new IllegalArgumentException("Index is illegal.");
        }
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++){
            res.append(data[i]);
            if(i != size -1){
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

    private void reSize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for(int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }
}
