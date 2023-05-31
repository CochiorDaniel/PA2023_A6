package org.example.com;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

public class Info {
    public static String viewInfo(Locale locale)
    {
        String output="";
        Currency currency=Currency.getInstance(locale);
        DateFormatSymbols symbols=new DateFormatSymbols(locale);
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd MM yyyy",locale);
        output+="\n"+"Country: "+locale.getDisplayCountry()+"\n"
        + "Language: "+ locale.getDisplayLanguage()+"\n"
        +"Currency: "+ currency.getCurrencyCode()+"\n"
        +"Week days: "+String.join(", ",symbols.getWeekdays())+"\n"
        +"Months: "+ String.join(", ",symbols.getMonths())+"\n"
        +"Today: "+ dateFormat.format(new Date());
        return output;
    }

}
