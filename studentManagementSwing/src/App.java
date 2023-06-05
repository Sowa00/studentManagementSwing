import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class App extends JFrame implements ActionListener{
    JButton showList, addStudent, deleteStudent, Points, changeCondition, search, searchPartial,
            showGroups, addList, removeList, findEmpty, addL, exit, removeL, searchstd, searchstdp, addPoints, removePoints, delstd, change;

    JFrame menuFrame = new JFrame();
    JFrame classFrame = new JFrame();
    JFrame addFrame = new JFrame();
    JFrame textFrame = new JFrame();
    JFrame text1Frame = new JFrame();
    JFrame nazwiskoFrame = new JFrame();
    JFrame pointsFrame = new JFrame();
    JFrame stanFrame = new JFrame();
    JFrame deletestdFrame = new JFrame();
    JFrame partialFrame = new JFrame();

    Class cl1, cl2, cl3, cl4;
    Class tempCl;
    Student tempStd;
    Object[][] classes;
    Map<String, Class> map1;
    ClassContainer listaGrup1;
    Object[][] listaGrup;

    JButton addStd;
    JLabel lImie, lNazwisko, lRokUrodzenia, lIloscPunktow, lStanStudenta, test, lClas, lMax, llabel, lAddP;
    JTextField tImie, tNazwisko, tRokUrodzenia, tIloscPunktow, tClas, tMax, ttest, tPoints, tnazw;
    JComboBox cbStanStudenta, cbShowList, cbChoose, cbAddList, cbRemoveList, cbShowSearched, cbShowSearchedPartial, cbClassList, cbStdList;
    String tempImie, tempNazwisko, tempClas;
    double tempIloscPunktow, tempMax, tempIlPkt;
    int tempRokUrodzenia;
    int rozmiarKlasy1, rozmiarGrupy1;
    StudentCondition tempStanStudenta;
    boolean tru = false;


    public App(){
        //frames


//        classFrame.setSize(600,600);
//        classFrame.setTitle("Student app");
//        classFrame.setLayout(null);
//        classFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        classFrame.setVisible(false);
        //tables
        //JTable classTab = new JTable();
        //classTab.setBounds(30, 40, 200, 300);
        //JScrollPane sp = new JScrollPane(classTab);
        //classFrame.add(classTab);
        //buttons
        showList = new JButton("Wyswietl klase");
        showList.setBounds(0, 30 ,150, 30);
        menuFrame.add(showList);
        showList.addActionListener(this);

        addStudent = new JButton("Dodaj studenta");
        addStudent.setBounds(150, 0 ,150, 30);
        menuFrame.add(addStudent);
        addStudent.addActionListener(this);

        deleteStudent = new JButton("Usun studenta");
        deleteStudent.setBounds(300, 0 ,150, 30);
        menuFrame.add(deleteStudent);
        deleteStudent.addActionListener(this);

        Points = new JButton("Zarzadzaj punktami");
        Points.setBounds(150, 30 ,150, 30);
        menuFrame.add(Points);
        Points.addActionListener(this);

        changeCondition = new JButton("Zmien stan");
        changeCondition.setBounds(300, 30 ,150, 30);
        menuFrame.add(changeCondition);
        changeCondition.addActionListener(this);

        search = new JButton("Szukaj");
        search.setBounds(0, 60 ,150, 30);
        menuFrame.add(search);
        search.addActionListener(this);

        searchPartial = new JButton("Szukaj czesciowo");
        searchPartial.setBounds(150, 60 ,150, 30);
        menuFrame.add(searchPartial);
        searchPartial.addActionListener(this);

//        countByCondition = new JButton("Count by condition");
//        countByCondition.setBounds(300, 30 ,150, 30);
//        menuFrame.add(countByCondition);
//        countByCondition.addActionListener(this);

//        sortByName = new JButton("Sort by name");
//        sortByName.setBounds(300, 140 ,150, 30);
//        menuFrame.add(sortByName);
//        sortByName.addActionListener(this);

//        sortByPoints = new JButton("Sort by points");
//        sortByPoints.setBounds(150, 140 ,150, 30);
//        menuFrame.add(sortByPoints);
//        sortByPoints.addActionListener(this);

//        listMax = new JButton("Max points");
//        listMax.setBounds(0, 140 ,150, 30);
//        menuFrame.add(listMax);
//        listMax.addActionListener(this);

        showGroups = new JButton("Pokaz grupy");
        showGroups.setBounds(0, 120 ,150, 30);
        menuFrame.add(showGroups);
        showGroups.addActionListener(this);

        addList = new JButton("Dodaj klase");
        addList.setBounds(150, 120 ,150, 30);
        menuFrame.add(addList);
        addList.addActionListener(this);

        removeList = new JButton("Usun klase");
        removeList.setBounds(300, 120 ,150, 30);
        menuFrame.add(removeList);
        removeList.addActionListener(this);

        findEmpty = new JButton("Znajdz pusta klase");
        findEmpty.setBounds(0, 150 ,150, 30);
        menuFrame.add(findEmpty);
        findEmpty.addActionListener(this);

        exit = new JButton("Wyjscie");
        exit.setBounds(300, 180 ,150, 30);
        menuFrame.add(exit);
        exit.addActionListener(this);

        cbShowList = new JComboBox();
        cbShowList.setBounds(0, 00, 150, 30);
        cbShowList.addItem("cl1");
        cbShowList.addItem("cl2");
        cbShowList.addItem("cl3");
        cbShowList.addItem("cl4");
        menuFrame.add(cbShowList);
        cbShowList.addActionListener(this);

        Student st1= new Student("Jakub", "Sowa", StudentCondition.obecny, 2001, 10);
        Student st2= new Student("Jan", "Nowak", StudentCondition.odrabiajacy, 2000, 8);
        Student st3= new Student("Andrzej", "Armia", StudentCondition.nieobecny, 1998, 13);
        Student st4= new Student("Zbigniew", "Ziarno", StudentCondition.chory, 1994, 18);
        Student st5= new Student("Imie", "Nazwisko", StudentCondition.obecny, 2001, 10);
        Student st6= new Student("Karol", "Podloga", StudentCondition.nieobecny, 1998, 1);
        Student st7= new Student("Alicja", "Nowak", StudentCondition.chory, 1994, 20);
        Student st8= new Student("Maria", "Kowalska", StudentCondition.obecny, 2001, 25);

        cl1 = new Class("cl1", new ArrayList<>(), 30);
        cl1.addStudent(st1);
        cl1.addStudent(st2);
        cl1.addStudent(st3);
        cl1.addStudent(st4);
        cl1.addStudent(st5);
        cl1.addStudent(st6);
        cl1.addStudent(st7);
        cl1.addStudent(st8);
        cl2 = new Class("cl2", new ArrayList<>(), 30);
        cl3 = new Class("cl3", new ArrayList<>(), 30);
        cl4 = new Class("cl4", new ArrayList<>(), 30);
        cl2.addStudent(st1);
        cl2.addStudent(st2);
        cl2.addStudent(st3);
        cl3.addStudent(st4);
        cl3.addStudent(st5);
        cl3.addStudent(st6);
        rozmiarGrupy1 = 1;
        map1 = new TreeMap<>();
        listaGrup1 = new ClassContainer(map1);
        listaGrup1.addClass(cl1.nazwaGrupy, cl1.students,cl1.maksymalnaIloscStudentow);
        tempCl = cl1;

        menuFrame.setSize(468,250);
        menuFrame.setTitle("Student app");
        menuFrame.setLayout(null);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        if(s==showList){//przycisk Show list
            classes = new Object[tempCl.getSize()][5];
            for(int i =0;i<tempCl.getSize();i++){
                classes[i][0] = tempCl.students.get(i).imie;
                classes[i][1] = tempCl.students.get(i).nazwisko;
                classes[i][2] = tempCl.students.get(i).rokUrodzenia;
                classes[i][3] = tempCl.students.get(i).iloscPunktow;
                classes[i][4] = tempCl.students.get(i).stanStudenta;
            }
            String column[]={"Imie", "Nazwisko", "Rok urodzenia", "Ilosc punktow", "Stan studenta"};

            TableModel model = new DefaultTableModel(classes, column) {
                public java.lang.Class<?> getColumnClass(int column) {
                    java.lang.Class<?> returnValue;
                    if ((column >= 0) && (column < getColumnCount())) {
                        returnValue = getValueAt(0, column).getClass();
                    } else {
                        returnValue = Object.class;
                    }
                    return returnValue;
                }
            };

            JTable classTab = new JTable(model);
            classTab.setBounds(30, 40, 200, 300);
            JScrollPane sp = new JScrollPane(classTab);
            RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
            classTab.setRowSorter(sorter);
            classFrame.add(sp);
            classFrame.setSize(600,600);
            classFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            classFrame.setVisible(true);
        }
        else if(s==findEmpty){
            String empty = "";
            int j=0;
            List<String> nazw1 = listaGrup1.getName();
            List<Double> ilosc1 = listaGrup1.getIlosc();
            for (int i =0;i<listaGrup1.grupy.size();i++) {
                if(ilosc1.get(i)==0) {
                    empty +=(nazw1.get(i));
                    empty +=" ";
                    j++;
                }
            }
            if(j==0){
                empty +="Brak pustych grup";
            }
            JOptionPane.showMessageDialog(null, empty, "Puste klasy:", JOptionPane.PLAIN_MESSAGE);
        }
        else if(s==changeCondition){
            lStanStudenta = new JLabel("Stan studenta:");
            lStanStudenta.setBounds(10, 10, 150, 30);
            stanFrame.add(lStanStudenta);

            cbStanStudenta = new JComboBox();
            cbStanStudenta.setBounds(160, 10, 150, 30);
            cbStanStudenta.addItem("Obecny");
            cbStanStudenta.addItem("Nieobecny");
            cbStanStudenta.addItem("Chory");
            cbStanStudenta.addItem("Odrabiajacy");
            stanFrame.add(cbStanStudenta);
            cbStanStudenta.addActionListener(this);

            change = new JButton("Zmien stan");
            change.setBounds(10, 70 ,150, 30);
            stanFrame.add(change);
            change.addActionListener(this);


            cbClassList = new JComboBox();
            cbClassList.setBounds(10, 40, 150, 30);
            cbClassList.addItem("cl1");
            cbClassList.addItem("cl2");
            cbClassList.addItem("cl3");
            cbClassList.addItem("cl4");
            stanFrame.add(cbClassList);
            cbClassList.addActionListener(this);

            cbStdList = new JComboBox();
            cbStdList.setBounds(160, 40, 150, 30);
            for(int i =0;i<tempCl.getSize();i++){
                cbStdList.addItem(tempCl.students.get(i).imie+" "+tempCl.students.get(i).nazwisko);
            }
            stanFrame.add(cbStdList);
            cbStdList.addActionListener(this);

            test = new JLabel("");
            test.setBounds(300, 200, 150, 30);
            stanFrame.add(test);

            stanFrame.setSize(350,500);
            stanFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            stanFrame.setVisible(true);
        }
        else if(s==change){
            tempStd.stanStudenta = tempStanStudenta;
        }
        else if(s==deleteStudent){
            JLabel lst = new JLabel("Wybierz studenta do usuniecia jesli ma 0 pkt");
            lst.setBounds(10, 10, 350, 30);
            deletestdFrame.add(lst);

            delstd = new JButton("Usun studenta");
            delstd.setBounds(10, 70, 150, 30);
            deletestdFrame.add(delstd);
            delstd.addActionListener(this);

            cbClassList = new JComboBox();
            cbClassList.setBounds(10, 40, 150, 30);
            cbClassList.addItem("cl1");
            cbClassList.addItem("cl2");
            cbClassList.addItem("cl3");
            cbClassList.addItem("cl4");
            deletestdFrame.add(cbClassList);
            cbClassList.addActionListener(this);

            cbStdList = new JComboBox();
            cbStdList.setBounds(160, 40, 150, 30);
            for(int i =0;i<tempCl.getSize();i++){
                cbStdList.addItem(tempCl.students.get(i).nazwisko);
            }
            deletestdFrame.add(cbStdList);
            cbStdList.addActionListener(this);

            test = new JLabel("");
            test.setBounds(300, 300, 150, 30);
            deletestdFrame.add(test);
            deletestdFrame.setSize(350,500);
            deletestdFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            deletestdFrame.setVisible(true);
        }
        else if(s==delstd){
            tempCl.getStudent(tempStd);
        }
        else if(s==Points){
            lAddP = new JLabel("Ilosc punktow:");
            lAddP.setBounds(10, 10, 150, 30);
            pointsFrame.add(lAddP);

            tPoints = new JTextField("");
            tPoints.setBounds(160, 10, 150, 30);
            pointsFrame.add(tPoints);

            addPoints = new JButton("Dodaj");
            addPoints.setBounds(10, 40 ,150, 30);
            pointsFrame.add(addPoints);
            addPoints.addActionListener(this);

            removePoints = new JButton("Usun");
            removePoints.setBounds(160, 40 ,150, 30);
            pointsFrame.add(removePoints);
            removePoints.addActionListener(this);

            cbClassList = new JComboBox();
            cbClassList.setBounds(10, 70, 150, 30);
            cbClassList.addItem("cl1");
            cbClassList.addItem("cl2");
            cbClassList.addItem("cl3");
            cbClassList.addItem("cl4");
            pointsFrame.add(cbClassList);
            cbClassList.addActionListener(this);

            cbStdList = new JComboBox();
            cbStdList.setBounds(160, 70, 150, 30);
            for(int i =0;i<tempCl.getSize();i++){
                cbStdList.addItem(tempCl.students.get(i).nazwisko);
            }
            pointsFrame.add(cbStdList);
            cbStdList.addActionListener(this);

            test = new JLabel("");
            test.setBounds(300, 200, 150, 30);
            pointsFrame.add(test);

            pointsFrame.setSize(350,500);
            pointsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            pointsFrame.setVisible(true);
        }
        else if(s==addPoints){

            tempIlPkt = Double.parseDouble(tPoints.getText());
            tempStd.iloscPunktow += tempIlPkt;

        }
        else if(s==removePoints){
            tempIlPkt = Double.parseDouble(tPoints.getText());
            tempStd.iloscPunktow -= tempIlPkt;
        }
        else if(s==cbStdList){
            String stanNazwisko = (String) cbStdList.getSelectedItem();
            for(int i =0;i<tempCl.getSize();i++){
                if(stanNazwisko == tempCl.students.get(i).nazwisko){
                    tempStd = tempCl.students.get(i);
                }
            }
        }
        else if(s==cbClassList){
            String stan = cbClassList.getSelectedItem().toString();
            if(stan.equals("cl1")){
                cbStdList.removeAllItems();
                tempCl = cl1;
                for(int i =0;i<tempCl.getSize();i++){
                    cbStdList.addItem(tempCl.students.get(i).nazwisko);
                }
            }
            else if(stan.equals("cl2")){
                cbStdList.removeAllItems();
                tempCl = cl2;
                for(int i =0;i<tempCl.getSize();i++){
                    cbStdList.addItem(tempCl.students.get(i).nazwisko);
                }
            }
            else if(stan.equals("cl3")){
                cbStdList.removeAllItems();
                tempCl = cl3;
                for(int i =0;i<tempCl.getSize();i++){
                    cbStdList.addItem(tempCl.students.get(i).nazwisko);
                }
            }
            else if(stan.equals("cl4")){
                cbStdList.removeAllItems();
                tempCl = cl4;
                for(int i =0;i<tempCl.getSize();i++){
                    cbStdList.addItem(tempCl.students.get(i).nazwisko);
                }
            }
        }
        else if(s==cbShowList){
            String stan = cbShowList.getSelectedItem().toString();
            if(stan.equals("cl1")){
                tempCl = cl1;
            }
            else if(stan.equals("cl2")){
                tempCl = cl2;
            }
            else if(stan.equals("cl3")){
                tempCl = cl3;
            }
            else if(stan.equals("cl4")){
                tempCl = cl4;
            }
        }
        else if(s==cbShowSearched){
            String stan = cbShowSearched.getSelectedItem().toString();
            if(stan.equals("cl1")){
                tempCl = cl1;
            }
            else if(stan.equals("cl2")){
                tempCl = cl2;
            }
            else if(stan.equals("cl3")){
                tempCl = cl3;
            }
            else if(stan.equals("cl4")){
                tempCl = cl4;
            }
        }
        else if(s==cbRemoveList){
            String stan = cbRemoveList.getSelectedItem().toString();
            if(stan.equals("cl1")){
                tempCl = cl1;
            }
            else if(stan.equals("cl2")){
                tempCl = cl2;
            }
            else if(stan.equals("cl3")){
                tempCl = cl3;
            }
            else if(stan.equals("cl4")){
                tempCl = cl4;
            }
        }
        else if(s==cbShowSearchedPartial){
            String stan = cbShowSearchedPartial.getSelectedItem().toString();
            if(stan.equals("cl1")){
                tempCl = cl1;
            }
            else if(stan.equals("cl2")){
                tempCl = cl2;
            }
            else if(stan.equals("cl3")){
                tempCl = cl3;
            }
            else if(stan.equals("cl4")){
                tempCl = cl4;
            }
        }
        else if(s==searchPartial){
            tNazwisko = new JTextField();

            lNazwisko = new JLabel("Czesc nazwiska:");
            lNazwisko.setBounds(10, 10, 150, 30);
            partialFrame.add(lNazwisko);
            tNazwisko = new JTextField("");
            tNazwisko.setBounds(160, 10, 150, 30);
            partialFrame.add(tNazwisko);
            searchstdp = new JButton("Szukaj czesciowo");
            searchstdp.setBounds(160, 40 ,150, 30);
            partialFrame.add(searchstdp);
            searchstdp.addActionListener(this);

            cbShowSearchedPartial = new JComboBox();
            cbShowSearchedPartial.setBounds(10, 40, 150, 30);
            cbShowSearchedPartial.addItem("cl1");
            cbShowSearchedPartial.addItem("cl2");
            cbShowSearchedPartial.addItem("cl3");
            cbShowSearchedPartial.addItem("cl4");
            partialFrame.add(cbShowSearchedPartial);
            cbShowSearchedPartial.addActionListener(this);
            test = new JLabel("");
            test.setBounds(300, 399, 150, 30);
            partialFrame.add(test);



            partialFrame.setSize(350,200);
            partialFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            partialFrame.setVisible(true);
        }
        else if(s==searchstdp){

            //System.out.println(tempNazwisko);
            Class searchedClass = new Class("searched", new ArrayList<>(), 30);
            Class tempCla = new Class("tempcla", new ArrayList<>(), 30);
            tempCla.students = tempCl.students;
            tempNazwisko = tNazwisko.getText();
            searchedClass.students = tempCla.searchPartial(tempNazwisko);
            searchedClass.summary();
            //searchedClass.summary();
            if(searchedClass.getSize()==0){
                JOptionPane.showMessageDialog(null, "Brak studenta o danej czesci nazwiska", "Error", JOptionPane.PLAIN_MESSAGE);
            }
            else{
                nazwiskoFrame.dispose();
                classes = new Object[searchedClass.getSize()][5];
                for(int i =0;i<searchedClass.getSize();i++){
                    classes[i][0] = searchedClass.students.get(i).imie;
                    classes[i][1] = searchedClass.students.get(i).nazwisko;
                    classes[i][2] = searchedClass.students.get(i).rokUrodzenia;
                    classes[i][3] = searchedClass.students.get(i).iloscPunktow;
                    classes[i][4] = searchedClass.students.get(i).stanStudenta;
                }
                String column[]={"Imie", "Nazwisko", "Rok urodzenia", "Ilosc punktow", "Stan studenta"};

                JTable classTab = new JTable(classes,column);
                classTab.setBounds(30, 40, 200, 300);
                JScrollPane sp = new JScrollPane(classTab);

                classFrame.add(sp);
                classFrame.setSize(600,600);
                classFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                classFrame.setVisible(true);
            }
        }
        else if(s==search){
            tNazwisko = new JTextField();

            lNazwisko = new JLabel("Nazwisko:");
            lNazwisko.setBounds(10, 10, 150, 30);
            nazwiskoFrame.add(lNazwisko);

            tNazwisko = new JTextField("");
            tNazwisko.setBounds(160, 10, 150, 30);

            nazwiskoFrame.add(tNazwisko);
            searchstd = new JButton("Szukaj");
            searchstd.setBounds(160, 40 ,150, 30);
            nazwiskoFrame.add(searchstd);
            searchstd.addActionListener(this);


            cbShowSearched = new JComboBox();
            cbShowSearched.setBounds(10, 40, 150, 30);
            cbShowSearched.addItem("cl1");
            cbShowSearched.addItem("cl2");
            cbShowSearched.addItem("cl3");
            cbShowSearched.addItem("cl4");
            nazwiskoFrame.add(cbShowSearched);
            cbShowSearched.addActionListener(this);

            test = new JLabel("");
            test.setBounds(300, 399, 150, 30);
            nazwiskoFrame.add(test);

            nazwiskoFrame.setSize(350,200);
            nazwiskoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            nazwiskoFrame.setVisible(true);
        }
        else if(s==searchstd){

            tempNazwisko = tNazwisko.getText();
            //System.out.println(tempNazwisko);
            Class searchedClass = new Class("searched", new ArrayList<>(), 30);
            Class tempCla = new Class("tempcla", new ArrayList<>(), 30);
            for(int i =0;i<tempCl.getSize();i++)
            {
//                tempCla.students.get(i).nazwisko = tempCl.students.get(i).nazwisko;
//                tempCla.students.get(i).imie = tempCl.students.get(i).imie;
//                tempCla.students.get(i).iloscPunktow = tempCl.students.get(i).iloscPunktow;
//                tempCla.students.get(i).rokUrodzenia = tempCl.students.get(i).rokUrodzenia;
//                tempCla.students.get(i).stanStudenta = tempCl.students.get(i).stanStudenta;
                tempCla.students.add(tempCl.students.get(i));
            }
            //tempCla.students = tempCl.students;

            searchedClass.students = tempCla.search(tempNazwisko);
            //searchedClass.summary();
            if(searchedClass.getSize()==0){
                JOptionPane.showMessageDialog(null, "Brak studenta o danym nazwisku", "Error", JOptionPane.PLAIN_MESSAGE);
            }
            else{
                nazwiskoFrame.dispose();
                classes = new Object[searchedClass.getSize()][5];
                for(int i =0;i<searchedClass.getSize();i++){
                    classes[i][0] = searchedClass.students.get(i).imie;
                    classes[i][1] = searchedClass.students.get(i).nazwisko;
                    classes[i][2] = searchedClass.students.get(i).rokUrodzenia;
                    classes[i][3] = searchedClass.students.get(i).iloscPunktow;
                    classes[i][4] = searchedClass.students.get(i).stanStudenta;
                }
                String column[]={"Imie", "Nazwisko", "Rok urodzenia", "Ilosc punktow", "Stan studenta"};

                JTable classTab = new JTable(classes,column);
                classTab.setBounds(30, 40, 200, 300);
                JScrollPane sp = new JScrollPane(classTab);

                classFrame.add(sp);
                classFrame.setSize(600,600);
                classFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                classFrame.setVisible(true);
            }
        }

        else if(s==deleteStudent){

        }
        else if(s==addStudent){//tworzenie nowego studenta i dodawanie go do klasy


            addStd = new JButton("Dodaj studenta");
            addStd.setBounds(170, 200 ,150, 30);
            addFrame.add(addStd);
            addStd.addActionListener(this);



            llabel = new JLabel("Wybierz klase:");
            llabel.setBounds(20, 170, 150, 30);
            addFrame.add(llabel);

            lImie = new JLabel("Imie:");
            lImie.setBounds(20, 20, 150, 30);
            addFrame.add(lImie);
            tImie = new JTextField("");
            tImie.setBounds(170, 20, 150, 30);
            addFrame.add(tImie);

            lNazwisko = new JLabel("Nazwisko:");
            lNazwisko.setBounds(20, 50, 150, 30);
            addFrame.add(lNazwisko);
            tNazwisko = new JTextField("");
            tNazwisko.setBounds(170, 50, 150, 30);
            addFrame.add(tNazwisko);

            lRokUrodzenia = new JLabel("Rok urodzenia:");
            lRokUrodzenia.setBounds(20, 80, 150, 30);
            addFrame.add(lRokUrodzenia);
            tRokUrodzenia = new JTextField("");
            tRokUrodzenia.setBounds(170, 80, 150, 30);
            addFrame.add(tRokUrodzenia);

            lIloscPunktow = new JLabel("Punkty:");
            lIloscPunktow.setBounds(20, 110, 150, 30);
            addFrame.add(lIloscPunktow);
            tIloscPunktow = new JTextField("");
            tIloscPunktow.setBounds(170, 110, 150, 30);
            addFrame.add(tIloscPunktow);

            lStanStudenta = new JLabel("Stan studenta:");
            lStanStudenta.setBounds(20, 140, 150, 30);
            addFrame.add(lStanStudenta);
            cbStanStudenta = new JComboBox();
            cbStanStudenta.setBounds(170, 140, 150, 30);
            cbStanStudenta.addItem("Obecny");
            cbStanStudenta.addItem("Nieobecny");
            cbStanStudenta.addItem("Chory");
            cbStanStudenta.addItem("Odrabiajacy");
            addFrame.add(cbStanStudenta);
            cbStanStudenta.addActionListener(this);

            cbChoose = new JComboBox();
            cbChoose.setBounds(170, 170, 150, 30);
            cbChoose.addItem("cl1");
            cbChoose.addItem("cl2");
            cbChoose.addItem("cl3");
            cbChoose.addItem("cl4");
            addFrame.add(cbChoose);
            cbChoose.addActionListener(this);

            test = new JLabel("");
            test.setBounds(300, 399, 150, 30);
            addFrame.add(test);
            //Student student();
            //cl1
            addFrame.setSize(400,350);
            addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            addFrame.setVisible(true);

        }
        else if(s==addStd){
            tempImie = tImie.getText();
            tempNazwisko = tNazwisko.getText();
            tempRokUrodzenia = Integer.parseInt(tRokUrodzenia.getText());
            tempIloscPunktow = Double.parseDouble(tIloscPunktow.getText());
            //System.out.println(tempImie+tempNazwisko+tempRokUrodzenia+tempIloscPunktow+tempStanStudenta);

            tempCl.addStudent(new Student(tempImie, tempNazwisko, tempStanStudenta, tempRokUrodzenia, tempIloscPunktow));

        }
        else if(s==cbChoose){
            String stan = cbChoose.getSelectedItem().toString();
            if(stan.equals("cl1")){
                tempCl=cl1;
            }
            else if(stan.equals("cl2")){
                tempCl=cl2;
            }
            else if(stan.equals("cl3")){
                tempCl=cl3;
            }
            else if(stan.equals("cl4")){
                tempCl=cl4;
            }
        }
        else if(s==cbStanStudenta){
            String stan = cbStanStudenta.getSelectedItem().toString();
            if(stan.equals("Obecny")){
                tempStanStudenta = StudentCondition.obecny;
            }
            else if(stan.equals("Nieobecny")){
                tempStanStudenta = StudentCondition.nieobecny;
            }
            else if(stan.equals("Chory")){
                tempStanStudenta = StudentCondition.chory;
            }
            else if(stan.equals("Odrabiajacy")){
                tempStanStudenta =StudentCondition.odrabiajacy;
            }
        }

        else if(s==showGroups){//przycisk Show groups

            listaGrup = new Object[listaGrup1.grupy.size()][2];
            List<String> nazw1 = listaGrup1.getName();
            List<Double> ilosc1 = listaGrup1.getIlosc();
            for(int i =0;i<listaGrup1.grupy.size();i++){
                listaGrup[i][0] = nazw1.get(i);
                listaGrup[i][1] = ilosc1.get(i);
            }
            String column[]={"Nazwa klasy", "Procentowe zapełnienie"};
            JTable classTab = new JTable(listaGrup, column);
            classTab.setBounds(30, 40, 200, 300);
            JScrollPane sp = new JScrollPane(classTab);
            classFrame.add(sp);
            classFrame.setSize(600,600);
            classFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            classFrame.setVisible(true);
        }
        else if(s==addList) {
            addL = new JButton("Dodaj klase");
            addL.setBounds(10, 10, 150, 30);
            textFrame.add(addL);
            addL.addActionListener(this);

//            lClas = new JLabel("Nazwa klasy:");
//            lClas.setBounds(20, 20, 250, 30);
//            textFrame.add(lClas);
//            tClas = new JTextField("");
//            tClas.setBounds(270, 20, 150, 30);
//            textFrame.add(tClas);
//
//            lMax = new JLabel("Maksymalna ilosc studentow:");
//            lMax.setBounds(20, 50, 250, 30);
//            textFrame.add(lMax);
//            tMax = new JTextField("");
//            tMax.setBounds(270, 50, 150, 30);
//            textFrame.add(tMax);
//            ttest = new JTextField("");
//            ttest.setBounds(270, 300, 0, 0);
//            textFrame.add(ttest);

            cbChoose = new JComboBox();
            cbChoose.setBounds(10, 50, 150, 40);
            cbChoose.addItem("cl1");
            cbChoose.addItem("cl2");
            cbChoose.addItem("cl3");
            cbChoose.addItem("cl4");
            textFrame.add(cbChoose);
            cbChoose.addActionListener(this);

            test = new JLabel("");
            test.setBounds(100, 200, 150, 30);
            textFrame.add(test);

            textFrame.setSize(200, 250);
            textFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            textFrame.setVisible(true);
        }
        else if (s==addL) {
            //tempClas = tClas.getText();
            //tempMax = Double.parseDouble(tMax.getText());

            rozmiarGrupy1++;
            listaGrup1.addClass(tempCl.nazwaGrupy, tempCl.students,tempCl.maksymalnaIloscStudentow);
            //listaGrup1.addClass(tempClas, new ArrayList<>(), tempMax);
        }
        else if(s==removeL){
            listaGrup1.removeClass(tempCl.nazwaGrupy);
        }
        else if(s==removeList){
            removeL = new JButton("Usun klase");
            removeL.setBounds(10, 10, 150, 30);
            text1Frame.add(removeL);
            removeL.addActionListener(this);


            cbRemoveList = new JComboBox();
            cbRemoveList.setBounds(10, 50, 150, 40);
            cbRemoveList.addItem("cl1");
            cbRemoveList.addItem("cl2");
            cbRemoveList.addItem("cl3");
            cbRemoveList.addItem("cl4");
            text1Frame.add(cbRemoveList);
            cbRemoveList.addActionListener(this);

            test = new JLabel("");
            test.setBounds(100, 200, 150, 30);
            text1Frame.add(test);

            text1Frame.setSize(200, 250);
            text1Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            text1Frame.setVisible(true);
        }
        else if(s==exit){//przycisk Exit
            menuFrame.dispose();
            addFrame.dispose();
            classFrame.dispose();
            textFrame.dispose();
            text1Frame.dispose();
            nazwiskoFrame.dispose();
            pointsFrame.dispose();
            deletestdFrame.dispose();

        }
    }
}
