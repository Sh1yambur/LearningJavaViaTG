package lesson_34_date.task_3;

/*
 * Реализуйте программу, выводящую в консоль количество времени между двумя введенными с клавиатуры датами и временем
 * в секундах, минутах, часах, днях, месяцах и годах.
 * Примечание: данная задача не предполагает реализацию через наследников интерфейса TemporalAmount.
 * Однако вы можете использовать их для альтернативного решения.
 */

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Task {
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        String early = getInput("early");
        String late = getInput("late");

        System.out.println(getValuesBetween(makeDateTimeObj(early), makeDateTimeObj(late)));

        System.out.println(getPeriodBetween(makeDateTimeObj(early), makeDateTimeObj(late)));

        //LocalDateTime earlyDate = makeDateTimeObj("28.06.1932 02:51:56"); // mock
        //LocalDateTime lateDate = makeDateTimeObj("20.12.2022 20:16:00"); // mock

        //System.out.println(getValuesBetween(earlyDate, lateDate));
        //System.out.println(getPeriodBetween(earlyDate, lateDate));
    }

    private static String getValuesBetween(LocalDateTime earlyDate, LocalDateTime lateDate) {
        long years = earlyDate.until(lateDate, ChronoUnit.YEARS);
        long months = earlyDate.until(lateDate, ChronoUnit.MONTHS);
        long days = earlyDate.until(lateDate, ChronoUnit.DAYS);
        long hours = earlyDate.until(lateDate, ChronoUnit.HOURS);
        long minutes = earlyDate.until(lateDate, ChronoUnit.MINUTES);
        long seconds = earlyDate.until(lateDate, ChronoUnit.SECONDS);

        // rewrite it more gracefully!
        String summary = String.format(
                "%d years, %d months, %d days, %02d hours %02d minutes %02d seconds",
                years,
                earlyDate.until(lateDate.minus(years, ChronoUnit.YEARS), ChronoUnit.MONTHS),
                earlyDate.until(lateDate.minus(months, ChronoUnit.MONTHS), ChronoUnit.DAYS),
                earlyDate.until(lateDate.minus(days, ChronoUnit.DAYS), ChronoUnit.HOURS),
                earlyDate.until(lateDate.minus(hours, ChronoUnit.HOURS), ChronoUnit.MINUTES),
                earlyDate.until(lateDate.minus(minutes, ChronoUnit.MINUTES), ChronoUnit.SECONDS)
        );

        return """
                  Seconds: %d
                  Minutes: %d
                  Hours: %d
                  Days: %d
                  Months: %d
                  Years: %d
                  Summary: %s
                """.formatted(seconds, minutes, hours, days, months, years, summary);
    }

    private static String getPeriodBetween(LocalDateTime earlyDate, LocalDateTime lateDate) {
        Period period = Period.between(earlyDate.toLocalDate(), lateDate.toLocalDate());
        Duration duration = Duration.between(earlyDate, lateDate);

        String summary = String.format(
                "%d years, %d months, %d days, %02d hours %02d minutes %02d seconds",
                period.getYears(),
                period.getMonths(),
                period.getDays(),
                duration.toHoursPart(),
                duration.toMinutesPart(),
                duration.toSecondsPart()
        );

        return """
                  Seconds: %d
                  Minutes: %d
                  Hours: %d
                  Days: %d
                  Months: %d
                  Years: %d
                  Summary: %s
                """.formatted(duration.toSeconds(),
                duration.toMinutes(),
                duration.toHours(),
                duration.toDays(),
                period.toTotalMonths(),
                period.getYears(),
                summary);
    }

    private static LocalDateTime makeDateTimeObj(String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        return LocalDateTime.parse(input, formatter);
    }

    private static String getInput(String msg) {
        System.out.printf("(%s) <== ", msg);
        return SC.nextLine();
    }
}
