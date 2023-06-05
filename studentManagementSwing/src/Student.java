public class Student implements Comparable<Student>{
    String imie;
    String nazwisko;
    StudentCondition stanStudenta;
    int rokUrodzenia;
    double iloscPunktow;

    public Student(String imie, String nazwisko, StudentCondition stanStudenta, int rokUrodzenia, double iloscPunktow){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stanStudenta = stanStudenta;
        this.rokUrodzenia = rokUrodzenia;
        this.iloscPunktow = iloscPunktow;

    }
    public StudentCondition getStanStudenta(){
        return stanStudenta;
    }
    public String getNazwisko(){
        return nazwisko;
    }
    public double getIloscPunktow() {
        return iloscPunktow;
    }
    public void print(){
        System.out.println("Imie: "+ imie +" Nazwisko: "+ nazwisko +" Rok urodzenia: "+ rokUrodzenia +" Ilosc punktow: "+ iloscPunktow+" Stan studenta: "+stanStudenta);
    }
    public int compare(String search){
        if(nazwisko.toLowerCase().equals(search.toLowerCase())){
            return 0;
        }
        else{
            return 1;
        }
    }
}
