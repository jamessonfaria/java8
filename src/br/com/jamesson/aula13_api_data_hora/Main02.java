package br.com.jamesson.aula13_api_data_hora;

import java.time.*;

public class Main02 {

    public static void main(String[] args) {

        // Period - trabalha com duração baseada em datas - ex: 1 mes, 1 ano, 2 dias
        Period period = Period.of(1, 10, 2);
        System.out.println(period);

        Period period5 = Period.ofDays(5);
        System.out.println(period5);

        LocalDate ldNow = LocalDate.now();
        System.out.println(ldNow);
        LocalDate ld = LocalDate.of(1990, Month.AUGUST, 6);
        System.out.println(ld);
        Period between = Period.between(ld, ldNow);
        System.out.println(between);

        Period periodPlus2 = between.plusMonths(2);
        System.out.println(periodPlus2);

        Period until = ld.until(ldNow);
        System.out.println(until);

        LocalDate dtPlus5Y = ld.plus(period5);
        System.out.println(dtPlus5Y);

        System.out.println("-----------");

        // Duration - trabalha com duração baseada em tempo - ex: 1 minuto, 2 horas, 2 segundos
        Duration duration = Duration.ofDays(2);
        System.out.println(duration);

        Duration durMin = Duration.ofMinutes(500);
        System.out.println(durMin);

        Duration durSec = Duration.ofSeconds(10, 5000);
        System.out.println(durSec);

        LocalTime ltNow = LocalTime.now();
        System.out.println(ltNow);
        LocalTime lt = LocalTime.of(14, 20, 22);
        System.out.println(lt);
        Duration betweenTime = Duration.between(lt, ltNow);
        System.out.println(betweenTime);

        Duration plus1d = betweenTime.plusDays(2);
        System.out.println(plus1d);

    }

}
