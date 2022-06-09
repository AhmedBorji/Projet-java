/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;




/**
 *
 * @author medal
 */
public class question {
    private int Id_Q;
    private int Id_certif;
    private String Question;
    private String rep1;
    private String rep2;
    private String rep3;
    private String Rep_correct;
    private int Score;
    private int Resultat;

    public question() {
    }

    public question(int Id_Q, int Id_certif, String Question, String rep1, String rep2, String rep3, String Rep_correct, int Score, int Resultat) {
        this.Id_Q = Id_Q;
        this.Id_certif = Id_certif;
        this.Question = Question;
        this.rep1 = rep1;
        this.rep2 = rep2;
        this.rep3 = rep3;
        this.Rep_correct = Rep_correct;
        this.Score = Score;
        this.Resultat = Resultat;
    }

    public int getId_Q() {
        return Id_Q;
    }

    public int getId_certif() {
        return Id_certif;
    }

    public String getQuestion() {
        return Question;
    }

    public String getRep1() {
        return rep1;
    }

    public String getRep2() {
        return rep2;
    }

    public String getRep3() {
        return rep3;
    }

    public String getRep_correct() {
        return Rep_correct;
    }

    public int getScore() {
        return Score;
    }

    public int getResultat() {
        return Resultat;
    }

    public void setId_Q(int Id_Q) {
        this.Id_Q = Id_Q;
    }

    public void setId_certif(int Id_certif) {
        this.Id_certif = Id_certif;
    }

    public void setQuestion(String Question) {
        this.Question = Question;
    }

    public void setRep1(String rep1) {
        this.rep1 = rep1;
    }

    public void setRep2(String rep2) {
        this.rep2 = rep2;
    }

    public void setRep3(String rep3) {
        this.rep3 = rep3;
    }

    public void setRep_correct(String Rep_correct) {
        this.Rep_correct = Rep_correct;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public void setResultat(int Resultat) {
        this.Resultat = Resultat;
    }

    @Override
    public String toString() {
        return "question{" + "Id_Q=" + Id_Q + ", Id_certif=" + Id_certif + ", Question=" + Question + ", rep1=" + rep1 + ", rep2=" + rep2 + ", rep3=" + rep3 + ", Rep_correct=" + Rep_correct + ", Score=" + Score + ", Resultat=" + Resultat + '}';
    }
}

