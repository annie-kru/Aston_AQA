package com.aston.aqajava.lesson09;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task05 {
    public static void main(String[] args) {
        login();
    }
    public static void login() {
        Scanner scanner = new Scanner(System.in);
        String login;
        ArrayList<String> loginsArray = new ArrayList<>();
        while (true){
            System.out.print("Enter login: > ");
            login = scanner.nextLine();
            if (login.equals("")){
                break;
            }
            loginsArray.add(login);
        }

        List<String> loginWithF = loginsArray.stream()
                .filter((string) -> string.charAt(0) == 'f')
                .collect(Collectors.toList()
                );
        System.out.println(loginWithF);
    }
}
