import java.util.*;

public class Main {
    public static void main(String[] args) {
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_RESET = "\u001B[0m";
        //Tworzenie studentow
        Student st1= new Student("Jakub", "Sowa", StudentCondition.obecny, 2001, 10);
        Student st2= new Student("Jan", "Nowak", StudentCondition.odrabiajacy, 2000, 8);
        Student st3= new Student("Andrzej", "Armia", StudentCondition.nieobecny, 1998, 13);
        Student st4= new Student("Zbigniew", "Ziarno", StudentCondition.chory, 1994, 18);
        Student st5= new Student("Imie", "Nazwisko", StudentCondition.obecny, 2001, 10);
        Student st6= new Student("Karol", "Podloga", StudentCondition.nieobecny, 1998, 1);
        Student st7= new Student("Alicja", "Nowak", StudentCondition.chory, 1994, 20);
        Student st8= new Student("Maria", "Kowalska", StudentCondition.obecny, 2001, 25);
        //Tworzenie grupy
        Class cl1 = new Class("cl1", new ArrayList<>(), 30);
        //Tworzenie listy grup
        Map<String, Class> map1 = new TreeMap<>();
        Map<String, Class> map2 = new TreeMap<>();
        ClassContainer listaGrup1 = new ClassContainer(map1);
        ClassContainer listaGrup2 = new ClassContainer(map2);

        System.out.println(ANSI_GREEN+"Wyswietlenie pustej grupy studentow:"+ANSI_RESET);
        cl1.summary();
        //Dodawanie studentow do grupy
        cl1.addStudent(st1);
        cl1.addStudent(st2);
        cl1.addStudent(st3);
        cl1.addStudent(st4);
        cl1.addStudent(st5);
        cl1.addStudent(st6);
        cl1.addStudent(st7);
        cl1.addStudent(st8);
        System.out.println(ANSI_GREEN+"\nWyswietlenie grupy studentow:"+ANSI_RESET);
        cl1.summary();
        //Dodawanie punktow studentowi
        cl1.addPoints(st1, 5);
        System.out.println(ANSI_GREEN+"\nDodanie studentowi nr1 5 punktow i wyswietlenie listy:"+ANSI_RESET);
        cl1.summary();
        //Odejmowanie punktow studentowi
        cl1.removePoints(st2, 8);
        System.out.println(ANSI_GREEN+"\nOdjecie studentowi nr2 8 punktow i wyswietlenie listy:"+ANSI_RESET);
        cl1.summary();
        //Sprawdzenie czy student ma punktow <=0 i jesli tak to usuniecie go z grupy
        cl1.getStudent(st2);
        System.out.println(ANSI_GREEN+"\nUsuniecie z grupy studenta nr2 jesli ma punktow <=0:"+ANSI_RESET);
        cl1.summary();

        System.out.println(ANSI_GREEN+"\nWyswietlenie studentow o stanie obecny:"+ANSI_RESET);
        cl1.countByCondition(StudentCondition.obecny);

        System.out.println(ANSI_GREEN+"\nPosortowanie grupy studentow po nazwisku:"+ANSI_RESET);
        cl1.sortByName();
        cl1.summary();

        System.out.println(ANSI_GREEN+"\nPosortowanie grupy studentow po ilosci punktow:"+ANSI_RESET);
        cl1.sortByPoints();
        Collections.reverse(cl1.students);
        cl1.summary();

        System.out.println(ANSI_GREEN+"\nZmiana stanu studenta Jakub Sowa na chory i wyswietlenie listy:"+ANSI_RESET);
        cl1.changeCondition(st1, StudentCondition.chory);
        cl1.summary();

        Class cl2 = new Class("cl2", new ArrayList<>(), 30);
        System.out.println(ANSI_GREEN+"\nWyszukanie studenta o danym nazwisku 'Sowa':"+ANSI_RESET);
        cl2.students = cl1.search("Sowa");
        cl2.summary();
        System.out.println(ANSI_GREEN+"\nWyszukanie studenta o danym nazwisku 'Sowaa', jesli nie ma go w grupie:"+ANSI_RESET);
        cl2.students = cl1.search("Sowaa");
        cl2.summary();

        System.out.println(ANSI_GREEN+"\nWyszukanie studenta o danej czesci imienia/nazwiska 'ia':"+ANSI_RESET);
        cl2.students = cl1.searchPartial("so");
        cl2.summary();
        System.out.println(ANSI_GREEN+"\nWyszukanie studenta o danej czesci imienia/nazwiska 'ia', jesli nie istnieje student w grupie o takiej czesci imienia/nazwiska:"+ANSI_RESET);
        cl2.students = cl1.searchPartial("iaia");
        cl2.summary();


        Class cl3 = new Class("cl3", new ArrayList<>(), 30);
        Class cl4 = new Class("cl4", new ArrayList<>(), 30);
        cl2.addStudent(st1);
        cl2.addStudent(st2);
        cl2.addStudent(st3);
        cl3.addStudent(st4);
        cl3.addStudent(st5);
        cl3.addStudent(st6);
        //cl4 jest pusta
        //Dodanie grup do listy grup
        listaGrup1.addClass(cl1.nazwaGrupy, cl1.students,cl1.maksymalnaIloscStudentow);
        listaGrup1.addClass(cl2.nazwaGrupy, cl2.students,cl2.maksymalnaIloscStudentow);
        listaGrup1.addClass(cl3.nazwaGrupy, cl3.students,cl3.maksymalnaIloscStudentow);
        listaGrup1.addClass(cl4.nazwaGrupy, cl4.students,cl4.maksymalnaIloscStudentow);

        System.out.println(ANSI_GREEN+"\nWyswietlenie standardowych informacji o grupach w liscie:"+ANSI_RESET);
        listaGrup1.summary();
        System.out.println(ANSI_GREEN+"\nWyswietlenie standardowych informacji pustej listy grup:"+ANSI_RESET);
        listaGrup2.summary();
        System.out.println(ANSI_GREEN+"\nFunkcja szukajaca pustej grupy w liscie:"+ANSI_RESET);
        listaGrup1.findEmpty();
        System.out.println(ANSI_GREEN+"\nUsuniecie pustej grupy cl4 i wyswietlenie listy:"+ANSI_RESET);
        listaGrup1.removeClass(cl4.nazwaGrupy);
        listaGrup1.summary();
    }
}