package com.blog.average;

public class AverageCounterL3S2 {

    //Humanities
    private double humanities_first;
    private double humanities_second;

    //BSc Internship
    private double internship_evaluation_pro_skills;
    private double internship_report;
    private double internship_oral_exam;


    //Interdisciplinary project
    private double project_report;
    private double project_oral_presentation;

    //Software Certification
    private double certification_first;
    private double certification_practical;
    private double certification_final;

    //Security
    private double security_first;
    private double security_second;
    private double security_final;


    public double humanities()
    {
        return humanities_first/30*1.5+humanities_second/30*1.5;
    }

    public double internship()
    {
        return internship_evaluation_pro_skills/30*5+internship_report/30*5+internship_oral_exam/30*5;
    }

    public double project()
    {
        return project_report/30*3+project_oral_presentation/30*3;
    }

    public double certification()
    {
        return certification_first/30*0.6+certification_practical/30*1.2+certification_final/30*1.2;
    }

    public double security()
    {
        return security_first/30*0.75+security_second/30*0.75+security_final/30*1.5;
    }


    public double averageCounter()
    {
        return humanities()+internship()+project()+certification()+security();

    }





    public AverageCounterL3S2() {
    }

    public AverageCounterL3S2(double humanities_first, double humanities_second,
                              double internship_evaluation_pro_skills, double internship_report, double internship_oral_exam,
                              double project_report, double project_oral_presentation,
                              double certification_first, double certification_practical, double certification_final,
                              double security_first, double security_second, double security_final) {
        this.humanities_first = humanities_first;
        this.humanities_second = humanities_second;
        this.internship_evaluation_pro_skills = internship_evaluation_pro_skills;
        this.internship_report = internship_report;
        this.internship_oral_exam = internship_oral_exam;
        this.project_report = project_report;
        this.project_oral_presentation = project_oral_presentation;
        this.certification_first = certification_first;
        this.certification_practical = certification_practical;
        this.certification_final = certification_final;
        this.security_first = security_first;
        this.security_second = security_second;
        this.security_final = security_final;
    }

    public double getHumanities_first() {
        return humanities_first;
    }

    public void setHumanities_first(double humanities_first) {
        this.humanities_first = humanities_first;
    }

    public double getHumanities_second() {
        return humanities_second;
    }

    public void setHumanities_second(double humanities_second) {
        this.humanities_second = humanities_second;
    }

    public double getInternship_evaluation_pro_skills() {
        return internship_evaluation_pro_skills;
    }

    public void setInternship_evaluation_pro_skills(double internship_evaluation_pro_skills) {
        this.internship_evaluation_pro_skills = internship_evaluation_pro_skills;
    }

    public double getInternship_report() {
        return internship_report;
    }

    public void setInternship_report(double internship_report) {
        this.internship_report = internship_report;
    }

    public double getInternship_oral_exam() {
        return internship_oral_exam;
    }

    public void setInternship_oral_exam(double internship_oral_exam) {
        this.internship_oral_exam = internship_oral_exam;
    }

    public double getProject_report() {
        return project_report;
    }

    public void setProject_report(double project_report) {
        this.project_report = project_report;
    }

    public double getProject_oral_presentation() {
        return project_oral_presentation;
    }

    public void setProject_oral_presentation(double project_oral_presentation) {
        this.project_oral_presentation = project_oral_presentation;
    }

    public double getCertification_first() {
        return certification_first;
    }

    public void setCertification_first(double certification_first) {
        this.certification_first = certification_first;
    }

    public double getCertification_practical() {
        return certification_practical;
    }

    public void setCertification_practical(double certification_practical) {
        this.certification_practical = certification_practical;
    }

    public double getCertification_final() {
        return certification_final;
    }

    public void setCertification_final(double certification_final) {
        this.certification_final = certification_final;
    }

    public double getSecurity_first() {
        return security_first;
    }

    public void setSecurity_first(double security_first) {
        this.security_first = security_first;
    }

    public double getSecurity_second() {
        return security_second;
    }

    public void setSecurity_second(double security_second) {
        this.security_second = security_second;
    }

    public double getSecurity_final() {
        return security_final;
    }

    public void setSecurity_final(double security_final) {
        this.security_final = security_final;
    }
}
