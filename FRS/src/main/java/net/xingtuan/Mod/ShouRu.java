package net.xingtuan.Mod;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ShouRu {
    //        - 添加收入记录（来源、金额、日期）。
    //        - 显示所有收入记录。
    public void shouRu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("收入管理系统");
        System.out.println();
        System.out.println("功能选择(1~2)");
        System.out.println("  1. 添加收入记录");
        System.out.println("  2. 显示所有收入记录");
        System.out.print(">>");
        switch (sc.nextInt()) {
            case 1:
                while (true) {
                    System.out.println("添加收入记录");
                    System.out.println();
                    sc.nextLine();
                    System.out.print("来源: ");
                    String input = sc.nextLine();
                    System.out.print("金额: ");
                    String input2 = sc.nextInt() + "";
                    System.out.print("日期: ");
                    sc.nextLine();
                    String input3 = sc.nextLine();

                    System.out.println("确认信息!!");
                    System.out.println("  钱款来源: " + input);
                    System.out.println("  钱款金额: " + input2);
                    System.out.println("  钱款日期: " + input3);
                    System.out.println("是否正确?Y/N");

                    int i = 0;
                    try (Writer bw = new FileWriter("NewFRS.FRS", true);) {
                        if (sc.next().equals("Y")) {
//                            //是否重名
//                            while (true){
//                                File file = new File("NewFRS" + i + ".FRS");
//                                if (!file.exists()) {
//                                    break;
//                                }
//                                i++;
//                            }
                            bw.write(input + "," + input2 + "," + input3 + "\n");
//                            bw.flush();
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("存储错误");
                    }

                }
                break;
            case 2:
                try (Reader rd = new FileReader("NewFRS.FRS");) {
                    BufferedReader br = new BufferedReader(rd);
                    ArrayList<String> arrayList = new ArrayList<>();
                    ArrayList<String> arrayList1 = new ArrayList<>();
                    String red;
                    while ((red = br.readLine()) != null) {
                        arrayList.add(red);
                    }
                    for (String string : arrayList) {
                        arrayList1.addAll(Arrays.stream(string.split(",")).toList());
                    }
                    for (int i = 0; i < arrayList1.size(); i += 3) {
                        System.out.println("钱款来源: " + arrayList1.get(i));
//                        ZongLan.money += Integer.parseInt(arrayList1.get(i + 1));
                        System.out.println("  钱款金额: " + arrayList1.get(i + 1));
                        System.out.println("  钱款日期: " + arrayList1.get(i + 2));
                    }
                } catch (Exception e) {
                    System.out.println("读取错误");
                }
        }
    }
}
