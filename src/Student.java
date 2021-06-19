public class Student {
    String name,stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double avarage;
    boolean isPass;


    Student(String name, int classes, String stuNo, Course mat,Course fizik,Course kimya) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        calcAvarage();
        this.isPass = false;
    }


    public void addBulkExamNote(int matExam,int matQuiz, int fizExam,int fizQuiz, int kimExam, int kimQuiz) {

        if (matExam >= 0 && matExam <= 100 && matQuiz >= 0 && matQuiz <= 100) {
            this.mat.quizNote = matQuiz;
            this.mat.examNote = matExam;
        }

        if (fizExam >= 0 && fizExam <= 100 && fizQuiz >= 0 && fizQuiz <= 100) {

            this.fizik.examNote = fizExam;
            this.fizik.quizNote = fizQuiz;
        }

        if (kimExam >= 0 && kimExam <= 100 && kimQuiz >= 0 && kimQuiz <= 100) {
            this.kimya.quizNote = kimQuiz;
            this.kimya.examNote= kimExam ;
        }
        this.mat.note = (this.mat.quizNote * 0.2)+(this.mat.examNote * 0.8);
        this.kimya.note = (this.fizik.quizNote * 0.2)+(this.kimya.examNote * 0.8);
        this.fizik.note = (this.kimya.quizNote * 0.2)+(this.kimya.examNote * 0.8);
    }

    public void isPass() {
        if (this.mat.note == 0 || this.fizik.note == 0 || this.kimya.note == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAvarage() {
        this.avarage = (this.fizik.note + this.kimya.note + this.mat.note) / 3;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote(){
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.mat.note);
        System.out.println("Fizik Notu : " + this.fizik.note);
        System.out.println("Kimya Notu : " + this.kimya.note);
    }

}