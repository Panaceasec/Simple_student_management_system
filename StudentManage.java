package test;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManage {
    /*
        用输出语句完成主界面的编写
        用Scanner实现键盘录入数据
        用switch完成操作的选择
        用循环完成再次回到主界面
     */
    public static void main(String[] args) {
        //创建集合对象，用于存储学生数据
        ArrayList<Student> array = new ArrayList<Student>();

        //用输出语句完成主界面的编写
        while (true){
            //用输出语句完成主界面的编写
            System.out.println("---------欢迎来到学生管理系统---------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看所有学生");
            System.out.println("5 退出");
            System.out.println("请输入你的选择：");

            //用Scanner实现键盘录入数据
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();

            //用switch完成操作的选择
            switch (line){
                case "1":
                    addStudent(array);
                    break;
                case "2":
                    deleteStudent(array);
                    break;
                case "3":
                    updateStudent(array);
                    break;
                case "4":
                    findAllStudent(array);
                    break;
                case "5":
                    System.out.println("谢谢使用");
                    System.exit(0);
            }
        }

    }
    //定义添加学生信息方法
    public static void addStudent(ArrayList<Student> array){
        //键盘录入学生对象所需的数据，显示提示信息，提示要输入哪种信息
        Scanner sc = new Scanner(System.in);
        String sid = sc.nextLine();

        //为了让程序继续回到这里，使用循环进行实现
        while (true){
            System.out.println("请输入学生学号：");
            sid = sc.nextLine();
            boolean flag = isUsed(array,sid);
            if (flag){
                System.out.println("输入的学号已被使用");
            }else {
                break;
            }
        }
        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄：");
        String age = sc.nextLine();
        System.out.println("请输入学生居住地：");
        String address = sc.nextLine();

        //创建学生对象，把键盘录入的数据赋值给学生对象的成员变量
        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);

        //将学生对象添加到集合中
        array.add(s);

        //给出添加成功提示
        System.out.println("添加学生成功");
    }

    //判断学生学号是否被使用
    public static boolean isUsed(ArrayList<Student> array, String sid) {
        //如果集合中的某一个学生学号相同则返回true，否则返回false
        boolean flag = false;
        for (int i =0; i < array.size(); i++){
            Student s = array.get(i);
            if (s.getSid().equals(i)){
                flag = true;
                break;
            }
        }

        return flag;
    }

    //定义查看学生信息方法
    public static void findAllStudent(ArrayList<Student> array) {
        //判断集合汇总稿呢是否有数据，如果没有显示提示信息
        if (array.size() == 0){
            System.out.println("无信息，请先添加信息");
            return;
        }

        //显示表头信息
        System.out.println("学号\t姓名\t\t年龄\t\t居住地");
        //将集合中的数据提取出来
        for (int i=0; i < array.size(); i++){
            Student s = array.get(i);
            System.out.println(s.getSid() + "\t" + s.getName() + "\t" + s.getAge() + "岁" + "\t" + s.getAddress());
        }

    }

    //定义删除学生信息方法
    public static void deleteStudent(ArrayList<Student> array) {
        //用键盘录入选择删除学生信息,显示提示信息
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要删除的学生的学号");
        String sid = sc.nextLine();

        //定义一个负数索引用来判断要删除的学号是否存在
        int index = -1;
        //遍历集合将对应学生对象从集合中删除
        for (int i=0; i < array.size(); i++){
            Student s = array.get(i);
            if (s.getSid().equals(sid)){
                index = i;
                break;
            }
        }
        if (index == -1){
            System.out.println("该学生信息不存在");
        }else {
            array.remove(index);
            //给出删除成功提示
            System.out.println("删除学生成功");
        }
    }

    //定义修改学生信息方法
    public static void updateStudent(ArrayList<Student> array) {
        //键盘录入要修改的学生学号
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要修改的学生的学号");
        String sid = sc.nextLine();

        //键盘录入要修改的学生信息
        System.out.println("请输入学生的新姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生的新年龄：");
        String age = sc.nextLine();
        System.out.println("请输入学生的新居住地：");
        String address = sc.nextLine();

        //创建学生对象
        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);

        //定义负数索引
        int index = -1;
        //遍历集合修改对应的学生信息
        for (int i = 0; i < array.size(); i++) {
            Student student = array.get(i);
            //如果集合中的学生sid和录入的dis值相同则将索引置为非负数
            if (student.getSid().equals(sid)){
                index = i;
                break;
            }
        }
        if (index == -1){
            System.out.println("该学生信息不存在");
        }else {
            array.set(index,s);
            //给出修改成功提示
            System.out.println("修改学生信息成功");
        }

    }
}

