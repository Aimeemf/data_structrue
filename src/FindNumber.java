import sort.ArrayGenerator;

public class FindNumber {
    private FindNumber(){}

    public static <E> int find(E[] nums, E target){
        int index = -1;
        if(nums.length == 0 || target == null){
            return index;
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i].equals(target)){
                return i;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        Integer[] nums = ArrayGenerator.generateOrderedArray(10000000);
//        Student[] students = {new Student("lily"), new Student("tom"), new Student("jerry")};
        Integer target = 1000000000;
//        Student tom = new Student("tom");
//        int i = find(students, tom);
        int i = 0;
        long sTime = System.nanoTime();
        for(int k =0; k < 1000; k++) {
          i = find(nums, 1000000000);
        }
        long eTime = System.nanoTime();
        double time = (eTime - sTime) / 1000000000.0;
//        System.out.println("###target is: " + tom + ",index is: " + i);
        System.out.println("###target is: " + target + ",index is: " + i + ",time is: " + time);
    }
}
