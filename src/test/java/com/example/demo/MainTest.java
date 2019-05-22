package com.example.demo;

import com.example.demo.config.mapUtils.GaodeApi;
import com.example.demo.model.User;

import java.util.*;

import static java.util.Comparator.comparingLong;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * @author AxeLai
 * @date 2019-04-24 21:58
 */
public class MainTest {
    public static void main(String[] args) {
//        List<String> a1 = Arrays.asList("a", "b", "c");
//        a1.forEach(MainTest::printValur);
//        Consumer<String> consumer = MainTest::printValur;
//        a1.forEach(x -> consumer.accept(x));
    }

    public static void printValur(String str) {
        System.out.println("print value : " + str);
    }

    //直接输出了10个随机数
//    Random random = new Random();
//        random.ints().limit(10).forEach(System.out::println);
//        System.out.println("---------------");
//        for (int i =0;i<10;i++){
//        System.out.println(random.nextInt());
//    }


//        List<String> list = new ArrayList<>();
//        list.add("c");
//        list.add("c");
//        list.add("a");
//        list.add("a");
//        list.add("b");
//        //1.set集合去重，不改变原有的顺序
//        pastLeep1(list);
//        //2.遍历后判断赋给另一个list集合  不改变原有的顺序
//        pastLeep2(list);
//        //3.set去重  并按自然顺序排序
//        pastLeep3(list);
//        //4.set去重（缩减为一行）
//        pastLeep4(list);
//        //5.去重并按自然顺序排序
//        pastLeep5(list);

    //        List<User>userList = new ArrayList<>();
//        userList.add(new User(1,"小李","男"));
//        userList.add(new User(5,"小李","男"));
//        userList.add(new User(7,"小李","男"));
//        userList.add(new User(3,"小李","男"));
//        userList.add(new User(1,"小李","男"));
//        userList.add(new User(5,"小李","男"));
//        //6.对象 根据指定属性去重 并按自然顺序排序
//        System.out.println(removeDuplicateUser(userList));
//        //7. 根据指定属性去重 并按自然顺序排序2
//        System.out.println(removeDuplicateUser2(userList));
    //1.set集合去重，不改变原有的顺序
    public static void pastLeep1(List<String> list){
        System.out.println("list = [" + list.toString() + "]");
        List<String> listNew=new ArrayList<>();
        Set set=new HashSet();
        for (String str:list) {
            if(set.add(str)){
                listNew.add(str);
            }
        }
        System.out.println("listNew = [" + listNew.toString() + "]");
    }

    //2.遍历后判断赋给另一个list集合 不改变原有的顺序
    public static void pastLeep2(List<String> list){
        System.out.println("list = [" + list.toString() + "]");
        List<String> listNew=new ArrayList<>();
        for (String str:list) {
            if(!listNew.contains(str)){
                listNew.add(str);
            }
        }
        System.out.println("listNew = [" + listNew.toString() + "]");
    }

    //3.set去重  并按自然顺序排序
    public static void pastLeep3(List<String> list){
        System.out.println("list = [" + list + "]");
        Set set = new HashSet();
        List<String> listNew=new ArrayList<>();
        set.addAll(list);
        listNew.addAll(set);
        System.out.println("listNew = [" + listNew + "]");
    }

    //4.set去重（缩减为一行） 并按自然顺序排序
    public static void pastLeep4(List<String> list){
        System.out.println("list = [" + list + "]");
        List<String> listNew=new ArrayList<>(new HashSet(list));
        System.out.println("listNew = [" + listNew + "]");
    }

    //5.去重并按自然顺序排序
    public static void pastLeep5(List<String> list){
        System.out.println("list = [" + list + "]");
        List<String> listNew=new ArrayList<>(new TreeSet<String>(list));
        System.out.println("listNew = [" + listNew + "]");
    }


    //6.对象 根据指定属性去重 并按自然顺序排序
    public static ArrayList<User> removeDuplicateUser(List<User> users) {
        Set<User> set = new TreeSet<User>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return new Integer(o1.getId()).compareTo(new Integer(o2.getId()));
            }
        });
        set.addAll(users);
        return new ArrayList<User>(set);
    }

    //7. 根据指定属性去重 并按自然顺序排序2
    public static List<User> removeDuplicateUser2(List<User> list){
        List<User> unique = list.stream().collect(
                collectingAndThen(
                        toCollection(() -> new TreeSet<>(comparingLong(User::getId))), ArrayList::new)
        );
        return unique;
    }



    //Stream中删除数据
    private static void deleteAtStream() {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(4);
        array.add(5);
        array.add(5);
        array.add(6);
        array.stream().forEach(integer -> {
            if(integer.equals(5)){
                array.remove(integer);
            }
        });
        System.out.println(array);
    }

    //foreach中删除数据
    private static void deleteAtForeach() {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(2);
        array.add(3);
        for (Integer a:array) {
            if (2==a){
                array.remove(a);
            }
        }
    }
    //Iterator遍历器中删除数据
    private static void deleteAtIterator() {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(4);
        array.add(5);
        array.add(5);
        array.add(6);
        Iterator<Integer>iterator = array.iterator();
        while (iterator.hasNext()){
            if (iterator.next().equals(5)){
                iterator.remove();
            }
        }
        System.out.println(array);
    }


    //for循环中删除数据
    private static void deleteAtFor() {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(4);
        array.add(5);
        array.add(5);
        array.add(6);
        for(int i=0;i<array.size();i++){
            if(array.get(i).equals(5)){
                array.remove(i--);
            }
        }
        System.out.println(array);
    }


    //set排序
    private static void sortSet() {
        Set<User> userList = new TreeSet<>();
        userList.add(new User(1,"小李","男"));
        userList.add(new User(5,"小李","男"));
        userList.add(new User(7,"小李","男"));
        userList.add(new User(3,"小李","男"));
        for (User user:userList) {
            System.out.println(user.getId());
        }
    }
    //List排序
    private static void sortList() {
        List<User>userList = new ArrayList<>();
        userList.add(new User(1,"小李","男"));
        userList.add(new User(5,"小李","男"));
        userList.add(new User(7,"小李","男"));
        userList.add(new User(3,"小李","男"));
        //通过sort方法的第二个参数传入一个Comparator接口对象 相当于是传入一个比较对象大小的算法到sort方法中
        Collections.sort(userList,new Comparator<User>() {
            @Override
            public int compare(User user0, User user1) {
                //降序排序
                return user1.getId()-user0.getId();
            }
        });
        for (User user:userList) {
            System.out.println(user.getId());
        }
    }
}
