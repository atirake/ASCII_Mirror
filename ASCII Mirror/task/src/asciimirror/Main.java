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
        File file = new File(filePath);

        try (Scanner scan = new Scanner(file);
        Scanner scan1 = new Scanner(file)) {
            int maxLengthLine = Integer.MIN_VALUE;
            List<StringBuilder> stringList = new ArrayList<>();
            while (scan.hasNextLine()) {
                String tempStr = scan.nextLine();
                if (tempStr.length() > maxLengthLine) {
                    maxLengthLine = tempStr.length();
                }
            }
            while (scan1.hasNextLine()) {
                String tempStr = scan1.nextLine();
                StringBuilder stringBuilder = new StringBuilder(tempStr);
                stringBuilder.append(" ".repeat(Math.max(0, maxLengthLine - tempStr.length())));
                stringList.add(stringBuilder);
            }
            for (StringBuilder str : stringList) {
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