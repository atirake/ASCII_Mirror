package asciimirror;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the file path:");
        String filePath = scanner.nextLine();
        try (Scanner scan = new Scanner(new File(filePath))) {
            int maxLengthLine = Integer.MIN_VALUE;
            List<StringBuilder> stringList = new ArrayList<>();
            while (scan.hasNextLine()) {
                String tempStr = scan.nextLine();
                StringBuilder stringBuilder = new StringBuilder(tempStr);
                if (tempStr.length() > maxLengthLine) {
                    maxLengthLine = tempStr.length();
                }
                stringList.add(stringBuilder);
            }
            for (StringBuilder str : stringList) {
                str.append(" ".repeat(Math.max(0, maxLengthLine - str.length())));
                System.out.print(str);
                System.out.print(" | ");
                str.reverse();
                for (char c : str.toString().toCharArray()) {
                    switch (c) {
                        case '/' -> System.out.print("\\");
                        case '\\' -> System.out.print("/");
                        case '{' -> System.out.print("}");
                        case '}' -> System.out.print("{");
                        case ']' -> System.out.print("[");
                        case '[' -> System.out.print("]");
                        case '(' -> System.out.print(")");
                        case ')' -> System.out.print("(");
                        case '>' -> System.out.print("<");
                        case '<' -> System.out.print(">");
                        default -> System.out.print(c);
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}