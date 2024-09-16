package net.xingtuan.Mod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;

public class ZongLan {
    public static int money2;
    public static int money;
    //减去
    ArrayList<Integer> array = new ArrayList<>();
    //增加
    ArrayList<Integer> array2 = new ArrayList<>();

    //        显示总收入、总支出和余额。
    public void zongLan() {
        try (Reader rd = new FileReader("money.FRS")){
            BufferedReader br = new BufferedReader(rd);
            money = Integer.parseInt(br.readLine());
            money2 = money;
            System.out.println("开始余额: " + money);
        } catch (Exception e) {
            System.out.println("读取错误");
        }
        System.out.println("===========总支出==========");
        try (Reader rd = new FileReader("NewFRSzc.FRS")) {
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
                System.out.println("支出来源: " + arrayList1.get(i));
                ZongLan.money -= Integer.parseInt(arrayList1.get(i + 1));
                array.add(Integer.parseInt(arrayList1.get(i + 1)));
                System.out.println("  支出金额: " + arrayList1.get(i + 1));
                System.out.println("  支出日期: " + arrayList1.get(i + 2));
            }
        } catch (Exception e) {
            System.out.println("读取错误");
        }
        System.out.println("===========总收入==========");
        try (Reader rd = new FileReader("NewFRS.FRS")) {
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
                ZongLan.money += Integer.parseInt(arrayList1.get(i + 1));
                array2.add(Integer.parseInt(arrayList1.get(i + 1)));
                System.out.println("  钱款金额: " + arrayList1.get(i + 1));
                System.out.println("  钱款日期: " + arrayList1.get(i + 2));
            }
        } catch (Exception e) {
            System.out.println("读取错误");
        }
        System.out.println("========余额=========");
        System.out.print("你的余额: " + money2);
        for (int i: array){
            System.out.print(" - " + i);
        }
        for (int i: array2){
            System.out.print(" + " + i);
        }
        System.out.println();
        System.out.println("你的最终余额: " + money);
    }
}
