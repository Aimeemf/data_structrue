package countingsort;

import java.util.Random;

class Main {

    public static void main(String[] args) {
       int n = 26 * 26 * 26 * 26;
        Student[] students = new Student[n];
        int k = 0;
        Random rnd = new Random();
        for(char c1 = 'a'; c1 <= 'z'; c1++){
            for(char c2 = 'a'; c2 <= 'z'; c2++){
                for(char c3 = 'a'; c3 <= 'z'; c3++){
                    for(char c4 = 'a'; c4 <= 'z'; c4++){
                        students[k] = new Student("" + c1 + c2 + c3 + c4, rnd.nextInt(101));
                        k ++;
                    }
                }
            }
        }

        //处理元素取值范围是[0,R)的计数排序
        int R = 101;
        int[] cnt = new int[R];
        for (int i = 0; i < students.length; i++) {
            cnt[students[i].getScore()] ++;
        }

        //从[index[i], index[i+1])的值为i
        int[] index = new int[R + 1];
        for (int i = 0; i < R; i++) {
            index[i + 1] = index[i] + cnt[i];
        }

        Student[] temp = new Student[n];
        for (Student student : students) {
            temp[index[student.getScore()]] = student;
            index[student.getScore()] ++;
        }

        for (int i = 0; i < n; i++) {
            students[i] = temp[i];
        }

        //验证计数排序法
        for (int i = 1; i < n; i++) {
            if(students[i - 1].getScore() > students[i].getScore()){
                throw new RuntimeException("Sort failed.");
            }

            if(students[i - 1].getScore() == students[i].getScore()){
                if(students[i - 1].getName().compareTo(students[i].getName()) > 0) {
                    throw new RuntimeException("Non-Stabled Counting Sort.");
                }
            }
        }
    }
}