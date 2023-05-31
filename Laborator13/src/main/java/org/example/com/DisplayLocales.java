package org.example.com;
import java.util.Locale;

public class DisplayLocales {
    public static String display()
    {
        String output= "";
        Locale available[] =
                Locale.getAvailableLocales();
        for(Locale locale : available) {
            String s = locale.getDisplayCountry() + "\t";
            output+=s+"\n";
        }
        return output;
    }
}
