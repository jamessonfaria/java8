package br.com.jamesson.aula13_api_data_hora;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Locale;

public class Main04 {

    public static void main(String[] args) {

        // Antes - DateFormat e SimpleDateFormat
        // Agora Java 8
        // DateTimeFormatter - faz varias formatações diferentes
        DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_TIME;
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter formatterMedium = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        DateTimeFormatter formatterFull = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);

        LocalDateTime ldtNow = LocalDateTime.now();
        System.out.println(ldtNow);

        String format1 = isoDateTime.format(ldtNow);
        System.out.println(format1);

        String format2 = formatter.format(ldtNow);
        System.out.println(format2);

        String format3 = formatterMedium.format(ldtNow);
        System.out.println(format3);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        String format4 = formatterFull.format(zonedDateTime);
        System.out.println(format4);

        // Locale
        Locale.setDefault(Locale.TAIWAN);
        System.out.println(format4);

        // Pattern
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String newFormat = pattern.format(zonedDateTime);
        System.out.println(newFormat);

        // Invertido
        String format = ldtNow.format(pattern);
        System.out.println(format);

        // Parse de uma data
        TemporalAccessor parse = pattern.parse("29/07/2019 10:00:20");
        LocalDate from = LocalDate.from(parse);
        System.out.println(from);

        DateTimeFormatter patternHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        TemporalAccessor parse1 = patternHora.parse("12:21:00");
        System.out.println(parse1);
        LocalTime from2 = LocalTime.from(parse1);
        System.out.println(from2);

    }

}
