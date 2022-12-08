import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Medlemsadministration {
    //Formandens muligheder og standardadministration
    public static ArrayList<Medlem> opretMedlem(ArrayList<Medlem> medlemmer) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("indtast medlemsnavn: ");
        String navn = sc.nextLine();
        System.out.println(" indtast f�dselsdag som YYYY-MM-DD: ");
        //DateTimeFormatter format = DateTimeFormatter.ofPattern("YYYY-MM-DD");
        String date = sc.next();

        //convert String to LocalDate
        LocalDate bday = LocalDate.parse(date);

        System.out.println(" indtast k�n: M/K: ");
        boolean gender = false;
        if (sc.next().equalsIgnoreCase("M")) {
            gender = true;
        }
        System.out.println(" Har medlem betalt? [J/N]");
        boolean harBetalt = false;
        if (sc.next().equalsIgnoreCase("J")) {
            harBetalt = true;
        }
        System.out.println("�nsker du at v�re aktivt medlem? [J/N]");
        if (sc.next().equalsIgnoreCase("N")) {
            Medlem nytmedlem = new PassivMedlem(navn, bday, gender, harBetalt);
            nytmedlem.setType("PassivMedlem");
            skrivMedlemmerTilFil(nytmedlem);
            medlemmer.add(nytmedlem);
            return medlemmer;
        }
        System.out.println("�nsker du at v�re konkurrencesv�mmer? [J/N]");
        if (sc.next().equalsIgnoreCase("n")) {
            Medlem nytmedlem = new Medlem(navn, bday, gender, harBetalt);
            nytmedlem.setType("Medlem");
            skrivMedlemmerTilFil(nytmedlem);
            medlemmer.add(nytmedlem);
            return medlemmer;
        }
        else{
        String aktivdisciplin = "";
        System.out.println("tast de discipliner du vil stille op i, uden komma i mellem: ");
        System.out.println("brystsv�mnin=b, crawl=c, ryg=r, butterfly=f");
        aktivdisciplin = aktivdisciplin.concat(sc.next());

        Medlem nytmedlem = new Konkurrencesv�mmer(navn, bday, gender, harBetalt, aktivdisciplin);
        nytmedlem.setType("Konkurrencesv�mmer");
        skrivMedlemmerTilFil(nytmedlem);
        medlemmer.add(nytmedlem);}
        return medlemmer;
        // tilf�j nyt medlem til ArrayList
    }

    public static void skrivMedlemmerTilFil(Medlem m) throws FileNotFoundException {
        File medlemsliste = new File("medlemsliste.txt");

        PrintStream medlemprint = new PrintStream(new FileOutputStream(medlemsliste, true));
        medlemprint.println(m);

    }
    public static ArrayList<Medlem> indl�sMedlemmer() throws FileNotFoundException{
        DateTimeFormatter tidsformat = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        Scanner sc=new Scanner(new File("medlemsliste.txt"));
        ArrayList<Medlem> medlemmer=new ArrayList<>();
        int antalMedlemmer;
        int medlemnr;
        String medlemnavn;
        LocalDate bday;
        boolean isMale;
        String memberType;
        double fee;
        boolean hasPaid;
        String line="";
        while (sc.hasNextLine()){
            line= sc.nextLine();
            Scanner nsc=new Scanner(line);
            while (nsc.hasNext()) {

                antalMedlemmer = Integer.parseInt(String.valueOf(nsc.next()));
                medlemnr = Integer.parseInt(String.valueOf(nsc.next()));
                medlemnavn = nsc.next();
                bday = LocalDate.parse(nsc.next());
                isMale = Boolean.parseBoolean(nsc.next());
                memberType = nsc.next();
                fee = Double.parseDouble(nsc.next()); //int medlemsnummer, String navn, LocalDate foedselsdag, boolean gender, String type, double kontingent, boolean harBetalt
                hasPaid = Boolean.parseBoolean(nsc.next());
                if (memberType.equals("Medlem")) {
                    Medlem nytMedlem = new Medlem(medlemnr, medlemnavn, bday, isMale, memberType, fee, hasPaid);
                    medlemmer.add(nytMedlem);
                }
                if (memberType.equals("PassivMedlem")) {
                    PassivMedlem nytmedlem=new PassivMedlem(medlemnr, medlemnavn, bday, isMale, memberType, fee, hasPaid);

                } else{
                    boolean[] aktivediscipliner=new boolean[4];
                    LocalTime[] res=new LocalTime[4];

                    for(int i=0;i<4;i++){
                        aktivediscipliner[i]=Boolean.parseBoolean(nsc.next());
                    }
                    for(int j=0;j<4;j++) {
                        if (aktivediscipliner[j]) {
                            nsc.next();
                            res[j] = LocalTime.parse(nsc.next(),tidsformat);
                        } else {
                            nsc.next();
                            res[j] = LocalTime.parse("23:59:59.999",tidsformat);
                        }
                    }
                    Medlem nytMedlem=new Konkurrencesv�mmer(medlemnr, medlemnavn, bday, isMale, memberType, fee, hasPaid,aktivediscipliner,res);
                    medlemmer.add(nytMedlem);
                }
                if(nsc.hasNext()){
                    nsc.nextLine();
                }

            }

        }
        return medlemmer;
    }
    //Tr�nerens muligheder
    public static void seTop5(ArrayList<Medlem> medlemmer, String discplinK�nAlder) {
        ArrayList<Konkurrencesv�mmer> top5 = new ArrayList<>();
        for (Medlem m : medlemmer) {
            if (m.getType().equals("Konkurrencesv�mmer")) {
                Konkurrencesv�mmer k = (Konkurrencesv�mmer) m;
                if (discplinK�nAlder.contains("b")) {         //Brystsv�mning
                    if (discplinK�nAlder.contains("mj")) {
                        if (k.getAktivdisciplin()[0] && k.isGender() && k.getAlder(k.getFoedselsdag()) < 18) {
                            top5.add(k);
                        }
                    }
                    if (discplinK�nAlder.contains("kj")) {
                        if (k.getAktivdisciplin()[0] && !k.isGender() && k.getAlder(k.getFoedselsdag()) < 18) {
                            top5.add(k);
                        }
                    }
                    if (discplinK�nAlder.contains("ks")) {
                        if (k.getAktivdisciplin()[0] && !k.isGender() && k.getAlder(k.getFoedselsdag()) >= 18) {
                            top5.add(k);
                        }
                    }
                    if (discplinK�nAlder.contains("ms")) {
                        if (k.getAktivdisciplin()[0] && k.isGender() && k.getAlder(k.getFoedselsdag()) >= 18) {
                            top5.add(k);
                        }
                    }
                    Collections.sort(top5, new SorterResultat(0));
                }


                if (discplinK�nAlder.contains("c")) {         //crawl
                    if (discplinK�nAlder.contains("mj")) {
                        if (k.getAktivdisciplin()[1] && k.isGender() && k.getAlder(k.getFoedselsdag()) < 18) {
                            top5.add(k);
                        }
                    }
                    if (discplinK�nAlder.contains("kj")) {
                        if (k.getAktivdisciplin()[1] && !k.isGender() && k.getAlder(k.getFoedselsdag()) < 18) {
                            top5.add(k);
                        }
                    }
                    if (discplinK�nAlder.contains("ks")) {
                        if (k.getAktivdisciplin()[1] && !k.isGender() && k.getAlder(k.getFoedselsdag()) >= 18) {
                            top5.add(k);
                        }
                    }
                    if (discplinK�nAlder.contains("ms")) {
                        if (k.getAktivdisciplin()[1] && k.isGender() && k.getAlder(k.getFoedselsdag()) >= 18) {
                            top5.add(k);
                        }
                    }
                    Collections.sort(top5, new SorterResultat(1));
                }
                if (discplinK�nAlder.contains("r")) {         //ryg
                    if (discplinK�nAlder.contains("mj")) {
                        if (k.getAktivdisciplin()[2] && k.isGender() && k.getAlder(k.getFoedselsdag()) < 18) {
                            top5.add(k);
                        }
                    }
                    if (discplinK�nAlder.contains("kj")) {
                        if (k.getAktivdisciplin()[2] && !k.isGender() && k.getAlder(k.getFoedselsdag()) < 18) {
                            top5.add(k);
                        }
                    }
                    if (discplinK�nAlder.contains("ks")) {
                        if (k.getAktivdisciplin()[2] && !k.isGender() && k.getAlder(k.getFoedselsdag()) >= 18) {
                            top5.add(k);
                        }
                    }
                    if (discplinK�nAlder.contains("ms")) {
                        if (k.getAktivdisciplin()[2] && k.isGender() && k.getAlder(k.getFoedselsdag()) >= 18) {
                            top5.add(k);
                        }
                    }
                    Collections.sort(top5, new SorterResultat(2));
                }
                if (discplinK�nAlder.contains("f")) {         //butterfly
                    if (discplinK�nAlder.contains("mj")) {
                        if (k.getAktivdisciplin()[3] && k.isGender() && k.getAlder(k.getFoedselsdag()) < 18) {
                            top5.add(k);
                        }
                    }
                    if (discplinK�nAlder.contains("kj")) {
                        if (k.getAktivdisciplin()[3] && !k.isGender() && k.getAlder(k.getFoedselsdag()) < 18) {
                            top5.add(k);
                        }
                    }
                    if (discplinK�nAlder.contains("ks")) {
                        if (k.getAktivdisciplin()[3] && !k.isGender() && k.getAlder(k.getFoedselsdag()) >= 18) {
                            top5.add(k);
                        }
                    }
                    if (discplinK�nAlder.contains("ms")) {
                        if (k.getAktivdisciplin()[3] && k.isGender() && k.getAlder(k.getFoedselsdag()) >= 18) {
                            top5.add(k);
                        }
                    }
                    Collections.sort(top5, new SorterResultat(3));
                }


            }


        }

        for(int i = 0; i<5; i++){
            System.out.println(top5.get(i).printTilKonsol());
        }


    }

    public static void seMedlemsListe(ArrayList<Medlem> medlemmer) {
        for(Medlem m:medlemmer){
            System.out.println(m.printTilKonsol());
        }
    }

    public static ArrayList<Medlem>  sletMedlem(ArrayList<Medlem> medlemmer, int mnr) {
        File medlemsliste = new File("medlemsliste.txt");
        PrintStream medlemprint = new PrintStream(new FileOutputStream(medlemsliste));//den gamle fil overskrives
        medlemmer.remove(mnr-1);
        for(Medlem m:medlemmer){
            medlemprint.println(m);
        }
        return medlemmer;

    }

    public static ArrayList<Medlem> redigerStamoplysninger(ArrayList<Medlem> medlemmer, int mnr) {
        Scanner sc=new Scanner(System.in);
        System.out.println(" hvilke stamoplysninger �snker du at �ndre?: ");
        System.out.println("1: �ndre navn");
        System.out.println("2: �ndre medlemskab");
        System.out.println("3: tilf�je eller fjerne sv�mmediscipliner");
        System.out.println("4: afslut og returner til hovedmenu");
        int valg=sc.nextInt();
        String rep;
        switch (valg) {
            case 1:
                System.out.println("indtast det nye navn");
                String nytNavn = sc.nextLine();
                if (nytNavn.contains(" ")) {
                    nytNavn.replace(" ", "_");
                }
                medlemmer.get(mnr - 1).setNavn(nytNavn);
                break;
            case 2:
                System.out.println("vil �ndre til pasivt medlemskab? [J/N]: ");
                rep = sc.next();
                if (rep.equalsIgnoreCase("j")) {
                    medlemmer.get(mnr - 1).setType("PassivMedlem");
                    File medlemsliste = new File("medlemsliste.txt");
                    PrintStream medlemprint = new PrintStream(new FileOutputStream(medlemsliste));//den gamle fil overskrives
                    for (Medlem m : medlemmer) {
                        medlemprint.println(m);
                    }
                    medlemmer = indl�sMedlemmer();
                }
                    System.out.println("vil du �ndre til aktivt medlemskab (Motionist)? [J/N]: ");
                    rep = sc.next();
                if (rep.equalsIgnoreCase("j")) {
                    medlemmer.get(mnr - 1).setType("Medlem");
                    File medlemsliste = new File("medlemsliste.txt");
                    PrintStream medlemprint = new PrintStream(new FileOutputStream(medlemsliste));//den gamle fil overskrives
                    for (Medlem m : medlemmer) {
                        medlemprint.println(m);
                    }
                    medlemmer = indl�sMedlemmer();
                }
                    System.out.println("vil du �ndre til konkurrencesv�mmer? ");
                    rep= sc.next();
                if (rep.equalsIgnoreCase("j")) {
                    medlemmer.get(mnr - 1).setType("Konkurrencesv�mmer");
                    File medlemsliste = new File("medlemsliste.txt");
                    PrintStream medlemprint = new PrintStream(new FileOutputStream(medlemsliste));//den gamle fil overskrives
                    for (Medlem m : medlemmer) {
                        medlemprint.println(m);
                    }
                    medlemmer = indl�sMedlemmer();
                    valg=3;
                }
                    return medlemmer;
                    break;
            case 3:
                System.out.println("vil du tilf�je discipliner");
                Konkurrencesv�mmer k=(Konkurrencesv�mmer) medlemmer.get(mnr-1);
                k.tilf�jDisciplin();
                return medlemmer;
                break;

            }
        }

    }

    public static void opdaterResultater(Konkurrencesv�mmer k, int disciplinnummer, int tr�nerinput) { //del af tr�nerens muligheder

        Scanner sc= new Scanner(System.in);
        switch (tr�nerinput){
            case 1:

                System.out.println("indtast tr�ningsdato som [YYYY-MM-DD]: ");

                String dato=sc.next();
                System.out.println("indtast tr�ningstid som [HH:MM:ss.SSS]: ");
                String tr�ningstid=sc.next();
                k.getDiscipliner()[disciplinnummer].getResultater().setTr�ningsresultater(dato,tr�ningstid);
                break;
            case 2:
                System.out.println("indtast st�vnenavn");
                String st�vnenavn=sc.next();
                System.out.println("indtast placering: ");
                int placering=sc.nextInt();
                System.out.println("indtast tid som [HH:MM:SS,nn]:");
                String tid=sc.next();
                k.getDiscipliner()[disciplinnummer].getResultater().setSt�vneresultater(st�vnenavn,placering,tid);
                break;
        }

    }
}
