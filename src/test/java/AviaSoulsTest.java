import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {
    Ticket one = new Ticket("Пулково", "Домодедово", 6000, 13 - 00, 14 - 00);
    Ticket two = new Ticket("Сочи", "Шереметьево", 7000, 14 - 00, 15 - 00);
    Ticket three = new Ticket("Геленджик", "Внуково", 6000, 15 - 00, 16 - 00);
    Ticket four = new Ticket("Пулково", "Казань", 9000, 16 - 00, 19 - 00);
    Ticket five = new Ticket("Новосибирск", "Чебоксары", 10000, 17 - 00, 19 - 00);


    //тесты на метод compareTo
    //все билеты от меньшей стоимости к большей
    @Test
    public void priceCompareTo() {

        AviaSouls manager = new AviaSouls();
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);

        manager.sortTickets();

        Ticket[] actual = manager.findAll();
        Ticket[] expected = {one, three, two, four, five}; // Ожидаемый порядок после сортировки по стоимости
        Assertions.assertArrayEquals(expected, actual);
    }

    //первый билет дороже второго
    @Test
    public void priceCompareTo1() {

        Ticket one = new Ticket("Пулково", "Домодедово", 10000, 13 - 00, 14 - 00);
        Ticket two = new Ticket("Пулково", "Шереметьево", 5000, 14 - 00, 15 - 00);

        AviaSouls manager = new AviaSouls();
        manager.add(one);
        manager.add(two);

        manager.sortTickets();

        Ticket[] actual = manager.findAll();
        Ticket[] expected = {two, one}; // Ожидаемый порядок после сортировки по стоимости
        Assertions.assertArrayEquals(expected, actual);
    }

    //первый билет дешевле второго
    @Test
    public void priceCompareTo2() {

        Ticket one = new Ticket("Пулково", "Домодедово", 5000, 13 - 00, 14 - 00);
        Ticket two = new Ticket("Пулково", "Шереметьево", 10000, 14 - 00, 15 - 00);

        AviaSouls manager = new AviaSouls();
        manager.add(one);
        manager.add(two);

        manager.sortTickets();

        Ticket[] actual = manager.findAll();
        Ticket[] expected = {one, two}; // Ожидаемый порядок после сортировки по стоимости
        Assertions.assertArrayEquals(expected, actual);
    }

    //билеты с одинаковой стоимостью
    @Test
    public void priceCompareTo3() {

        Ticket one = new Ticket("Пулково", "Домодедово", 10000, 13 - 00, 14 - 00);
        Ticket two = new Ticket("Пулково", "Шереметьево", 10000, 14 - 00, 15 - 00);

        AviaSouls manager = new AviaSouls();
        manager.add(one);
        manager.add(two);

        manager.sortTickets();

        Ticket[] actual = manager.findAll();
        Ticket[] expected = {one, two}; // Ожидаемый порядок после сортировки по стоимости
        Assertions.assertArrayEquals(expected, actual);
    }


    //тесты на метод search
    //поиск по существующим аэропортам в билетах и сортировка по цене
    @Test
    public void priceSearch() {

        Ticket one = new Ticket("Пулково", "Домодедово", 8000, 13 - 00, 14 - 00);
        Ticket two = new Ticket("Сочи", "Шереметьево", 7000, 14 - 00, 15 - 00);
        Ticket three = new Ticket("Пулково", "Домодедово", 6000, 15 - 00, 16 - 00);
        Ticket four = new Ticket("Пулково", "Казань", 9000, 16 - 00, 19 - 00);
        Ticket five = new Ticket("Новосибирск", "Чебоксары", 10000, 17 - 00, 19 - 00);

        AviaSouls manager = new AviaSouls();
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);

        manager.sortTickets(); // Сортируем билеты
        Ticket[] actual = manager.search("Пулково", "Домодедово");
        Ticket[] expected = {three, one}; // Ожидаемый порядок после сортировки по стоимости
        Assertions.assertArrayEquals(expected, actual);
    }

    //поиск по не существующим аэропортам в билетах и сортировка по цене
    @Test
    public void priceSearch1() {

        Ticket one = new Ticket("Пулково", "Домодедово", 8000, 13 - 00, 14 - 00);
        Ticket two = new Ticket("Сочи", "Шереметьево", 7000, 14 - 00, 15 - 00);
        Ticket three = new Ticket("Пулково", "Домодедово", 6000, 15 - 00, 16 - 00);
        Ticket four = new Ticket("Пулково", "Казань", 9000, 16 - 00, 19 - 00);
        Ticket five = new Ticket("Новосибирск", "Чебоксары", 10000, 17 - 00, 19 - 00);

        AviaSouls manager = new AviaSouls();
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);

        manager.sortTickets(); // Сортируем билеты
        Ticket[] actual = manager.search("Караганда", "Челябинск");
        Ticket[] expected = {}; // Ожидаемый порядок после сортировки по стоимости
        Assertions.assertArrayEquals(expected, actual);
    }


    //тесты на метод searchAndSortBy
    //поиск по существующим аэропортам в билетах и сортировка по времени отпарвления
    @Test
    public void timeFromSearchAndSortBy() {

        Ticket one = new Ticket("Пулково", "Домодедово", 8000, 13 - 00, 14 - 00);
        Ticket two = new Ticket("Сочи", "Шереметьево", 7000, 14 - 00, 15 - 00);
        Ticket three = new Ticket("Пулково", "Домодедово", 6000, 15 - 00, 16 - 00);
        Ticket four = new Ticket("Пулково", "Казань", 9000, 13 - 00, 19 - 00);
        Ticket five = new Ticket("Новосибирск", "Чебоксары", 10000, 17 - 00, 19 - 00);

        AviaSouls manager = new AviaSouls();
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);

        TicketTimeComparator timeFromComparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("Пулково", "Домодедово", timeFromComparator);
        Arrays.sort(actual, timeFromComparator);

        Ticket[] expected = {one, three}; // Ожидаемый порядок после сортировки по времени отправления
        Assertions.assertArrayEquals(expected, actual);
    }

    //поиск по не существующим аэропортам в билетах и сортировка по времени отпарвления
    @Test
    public void timeFromSearchAndSortBy1() {

        Ticket one = new Ticket("Пулково", "Домодедово", 8000, 13 - 00, 14 - 00);
        Ticket two = new Ticket("Сочи", "Шереметьево", 7000, 14 - 00, 15 - 00);
        Ticket three = new Ticket("Пулково", "Домодедово", 6000, 15 - 00, 16 - 00);
        Ticket four = new Ticket("Пулково", "Казань", 9000, 13 - 00, 19 - 00);
        Ticket five = new Ticket("Новосибирск", "Чебоксары", 10000, 17 - 00, 19 - 00);

        AviaSouls manager = new AviaSouls();
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);

        TicketTimeComparator timeFromComparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("Караганда", "Челябинск", timeFromComparator);
        Arrays.sort(actual, timeFromComparator);

        Ticket[] expected = {}; // Ожидаемый порядок после сортировки по времени отправления
        Assertions.assertArrayEquals(expected, actual);
    }
}
