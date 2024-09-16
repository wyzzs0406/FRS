package net.xingtuan;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fileName = "money.FRS"; // 要检查的文件名

        File file = new File(fileName);
        if (!file.exists()) {
            while (true) {
                System.out.println("你好,这里是FRS智能财务管理系统,请告诉我你的账户余额，我将为你管理收入和支出");
                System.out.print("你的余额: ");
                Scanner scanner = new Scanner(System.in);
                try (FileWriter fileWriter = new FileWriter(file)) {
                    int money = scanner.nextInt();
                    fileWriter.write(money + "\n");
                    break;
                } catch (Exception e) {
                    System.out.println("哎呀，怎么这么不小心，要输入数字哦(●'◡'●)");
                }
            }
        } new Run().run();
    }
}