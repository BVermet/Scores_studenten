package be.howest.nmct.evaluationstudents.admin;

import java.util.HashMap;
import java.util.Map;

public class Student implements Comparable<Student> {


    public enum DIPLOMAGRAAD {
        GROOTSTE("Grootste onderscheiding",16.5f,20f,"Geslaagd met de grootste onderscheiding"),
        GROTE("Grote onderscheiding",15f,16.5f,"Geslaagd met grote onderscheiding"),
        ONDERSCHEIDING("Onderscheiding",13.5f,15f,"Geslaagd met onderscheiding"),
        VOLDOENING("Voldoening",10f,13.5f,"Geslaagd op voldoende wijze"),
        NIET_GESLAAGD("Niet geslaagd",0f,10f,"Niet geslaagd");


        private String naam;
        private float benedengrens;
        private float bovengrens;
        private String omschrijving;


        DIPLOMAGRAAD(String naam, float benedengrens, float bovengrens, String omschrijving) {
            this.naam = naam;
            this.benedengrens = benedengrens;
            this.bovengrens = bovengrens;
            this.omschrijving = omschrijving;
        }


        public String getNaam() {
            return naam;
        }
        public float getBenedengrens() {
            return benedengrens;
        }
        public float getBovengrens() {
            return bovengrens;
        }
        public String getOmschrijving() {
            return omschrijving;
        }


        public boolean isBinnenGrenzen(float score) {
            return score >= benedengrens && score < bovengrens;
        }


        public static DIPLOMAGRAAD getDiplomagraad(float score) {
            for(DIPLOMAGRAAD diplomagraad : DIPLOMAGRAAD.values()) {
                if(diplomagraad.isBinnenGrenzen(score)) return diplomagraad;
            }
            if (score == 20f) return DIPLOMAGRAAD.GROOTSTE;
            return null;
        }
    }

    private String naamStudent;
    private String voornaamStudent;
    private String emailStudent;
    private Map<String, ModulePunt> scoresStudent = new HashMap<String, ModulePunt>();


    public Student(String emailStudent) {
        super();
        this.emailStudent = emailStudent;
    }


    public Student(String emailStudent, String voornaam, String naam) {
        this(emailStudent);
        this.naamStudent = naam;
        this.voornaamStudent = voornaam;
    }

    public String getNaamStudent() {
        return naamStudent;
    }

    public void setNaamStudent(String naamStudent) {
        this.naamStudent = naamStudent;
    }

    public String getVoornaamStudent() {
        return voornaamStudent;
    }

    public void setVoornaamStudent(String voornaamStudent) {
        this.voornaamStudent = voornaamStudent;
    }


    public String getEmailStudent() {
        return emailStudent;
    }
    public void setEmailStudent(String emailStudent) {
        this.emailStudent = emailStudent;
    }
    public Map<String, ModulePunt> getScoresStudent() {
        return scoresStudent;
    }

    public void voegScoreToe(String sModuleNaam, double score) {
        ModulePunt mp = new ModulePunt(sModuleNaam, score);
        getScoresStudent().put(sModuleNaam, mp);
    }


    public void voegScoreToe(String sModuleNaam, int aantalStudiePunten,
                             double score) {
        ModulePunt mp = new ModulePunt(sModuleNaam, aantalStudiePunten, score);
        getScoresStudent().put(sModuleNaam, mp);
    }


    public double getTotaleScoreStudent() {

        int iTotaalStptn = 0;
        for (ModulePunt mp : this.getScoresStudent().values()) {
            iTotaalStptn += mp.getAantalStudiePunten();
        }

        double dTotaleScore = 0;

        for (ModulePunt mp : this.getScoresStudent().values()) {
            double dGewicht = (double) mp.getAantalStudiePunten()
                    / iTotaalStptn;
            dTotaleScore += (mp.getScore() * dGewicht);
        }

        return dTotaleScore;
    }


    @Override
    public String toString() {
        return "Student [emailStudent=" + emailStudent + ", scoresStudent="
                + scoresStudent + "]";
    }

    @Override
    public int compareTo(Student other) {

        double mijnTotaleScore = this.getTotaleScoreStudent();
        double andereTotaleScore = other.getTotaleScoreStudent();
        double dVerschil = mijnTotaleScore - andereTotaleScore;


        if (dVerschil > 0)
            return +1;
        if (dVerschil < 0)
            return -1;
        return 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((emailStudent == null) ? 0 : emailStudent.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (emailStudent == null) {
            if (other.emailStudent != null)
                return false;
        } else if (!emailStudent.equals(other.emailStudent))
            return false;
        return true;
    }

    public DIPLOMAGRAAD getDiplomagraad(){
        return DIPLOMAGRAAD.getDiplomagraad((float)getTotaleScoreStudent());
    }






}
