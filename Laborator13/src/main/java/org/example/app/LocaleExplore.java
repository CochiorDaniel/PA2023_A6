package org.example.app;

import org.example.com.DisplayLocales;
import org.example.com.Info;
import org.example.com.SetLocale;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleExplore {
public static void displayMessages(Locale locale) {
    String baseName = "res.Messages";
    ResourceBundle messages = ResourceBundle.getBundle(baseName, locale);
    while(true) {
        System.out.println(messages.getString("prompt"));
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        String pattern = messages.getString(s);
        String output = null;
        if (Objects.equals(s, "locales")) {
            output = DisplayLocales.display();
        }
        else if (Objects.equals(s, "locales.set")) {
            SetLocale.setLocals(locale);
            output = Info.viewInfo(locale.getDefault());
        }
        else if (Objects.equals(s, "info")) {
            output =Info.viewInfo(locale);
        }
        String formattedMessage = MessageFormat.format(pattern, output);
        System.out.println(formattedMessage);
    }

}
    public static void main(String args[]) throws IOException {
       //displayMessages(new Locale("ro","RO"));
        displayMessages(Locale.getDefault());
    }
}