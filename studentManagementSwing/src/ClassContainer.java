import java.util.*;

public class ClassContainer {
    Map<String, Class> grupy;

    public ClassContainer(Map<String, Class> grupy) {
        this.grupy = grupy;
    }

    public List<String> getName(){
        List<String> name = new ArrayList<>();
        for (Class grupa : grupy.values()) {
            //System.out.println("Nazwa grupy: " + grupa.nazwaGrupy + " Procentowe zapelnienie: " + (grupa.getSize() / grupa.maksymalnaIloscStudentow) * 100.0 + "%");
            name.add(grupa.nazwaGrupy);

        }
        return name;
    }

    public List<Double> getIlosc(){
        List<Double> ilosc = new ArrayList<>();
        for (Class grupa : grupy.values()) {
            //System.out.println("Nazwa grupy: " + grupa.nazwaGrupy + " Procentowe zapelnienie: " + (grupa.getSize() / grupa.maksymalnaIloscStudentow) * 100.0 + "%");
            //listaGrup[0][0] = grupa.nazwaGrupy;
            ilosc.add(grupa.getSize() / grupa.maksymalnaIloscStudentow);

        }
        return ilosc;
    }
    public void addClass(String nazwa, List<Student> grupa, double pojemnosc) {
        grupy.put(nazwa, new Class(nazwa, grupa, pojemnosc));
    }
    public void removeClass(String grupa)
    {
        grupy.remove(grupa);
    }
    public List<Class> findEmpty(){
        int j=0;
        List<Class> empty = new ArrayList<>();
        for (Class grupa : grupy.values()) {
            if(grupa.getSize()==0) {
                System.out.println("Grupa "+grupa.nazwaGrupy+" jest pusta");
                empty.add(grupa);
                j++;
            }
        }
        if(j==0){
            System.out.println("Brak pustych grup");
        }
        return empty;
    }
    public void summary(){
        if(grupy.size()>0){
            //Collections.sort(grupy, Collections.reverseOrder());
            for (Class grupa : grupy.values()) {
                System.out.println("Nazwa grupy: " + grupa.nazwaGrupy + " Procentowe zapelnienie: " + (grupa.getSize() / grupa.maksymalnaIloscStudentow) * 100.0 + "%");
            }
        }
        else{
            System.out.println("Lista grup jest pusta");
        }
    }
}
