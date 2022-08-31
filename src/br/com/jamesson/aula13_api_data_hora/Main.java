package br.com.jamesson.aula13_api_data_hora;

import java.time.*;

public class Main {

    public static void main(String[] args) {

        // LocalDate - representa a data: ex: 06/08/1990
        LocalDate ldNow = LocalDate.now();
        System.out.println(ldNow);
        LocalDate ld = LocalDate.of(1990, Month.AUGUST, 6);
        System.out.println(ld);

        // LocalTime - representa a hora: ex: 11:40:22
        LocalTime ltNow = LocalTime.now();
        System.out.println(ltNow);
        LocalTime lt = LocalTime.of(14, 20, 22, 33988888);
        System.out.println(lt);

        // LocalDateTime - representa data+hora: ex: 06/08/1990  11:40:22 (Não tem timezone)
        LocalDateTime ldtNow = LocalDateTime.now();
        System.out.println(ldtNow);
        LocalDateTime ldt = LocalDateTime.of(ldNow, ltNow);
        System.out.println(ldt);

        // Instant - representa um instante/momento na linha do tempo, ela não armazena o TimeZone ela esta no GMT-0:
        // ex: 06/08/1990 11:40:22 GMT/UTC
        // (milissegundos a partir de 01/01/1970 00:00:00)
        Instant instant = Instant.now();
        System.out.println(instant);
        Instant inst = Instant.ofEpochMilli(500000000000L);
        System.out.println(inst);

        // ZonedDateTime - representa o LocalDateTime com TimeZone, classe mais completa:
        // ex: 06/08/1990 11:40:22 GMT-3 (America/Sao_Paulo)
        ZonedDateTime zdtNow = ZonedDateTime.now();
        System.out.println(zdtNow);
        ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.of("America/Montevideo"));
        System.out.println(zdt);

        System.out.println("----------");

        // calculo com datas
        System.out.println(ld.plusWeeks(2));
        System.out.println(zdt.minusMonths(4).minusDays(2).plusYears(10));

    }

}
