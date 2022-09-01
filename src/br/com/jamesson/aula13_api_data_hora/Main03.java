package br.com.jamesson.aula13_api_data_hora;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Main03 {

    public static void main(String[] args) {

        // LocalDateTime - Data + Hora (Quando vc quer usar calculos com essa data,
        // porem nao se preocupa com o utc, ele pega a data e hora do server)
        LocalDateTime ldt = LocalDateTime.now().plusDays(3);
        System.out.println(ldt);


        // Instant - Data + Hora + GMT (Se vc vai precisar usar calculos com a data nao deveria usar o Instant)
        // É ideal para representar o evento na linha do tempo
        Instant now = Instant.now();
        //now.plus(5, ChronoUnit.MONTHS);
        // Converteu um instant em um zoneddatetime, ai a partir dai pode realizar os calculos
        ZonedDateTime zdt = now.atZone(ZoneId.of("America/Sao_Paulo"));
        System.out.println(zdt);

        // ZonedDateTime - Data + Hora + Fuso Horario Especifico (Quando vc quer usar calculos
        // com essa data, porem se preocupa com o utc)
        ZonedDateTime zdtn = ZonedDateTime.now();
        System.out.println(zdtn);

    }

}
