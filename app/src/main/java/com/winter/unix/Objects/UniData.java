package com.winter.unix.Objects;

public class UniData {

    String Courses,Uni_Country,Uni_Name,What_they_offer;

    public UniData(){


    }

    public UniData(String Courses,String Uni_Country,String Uni_Name,String What_they_offer){

        this.Courses = Courses;
        this.Uni_Country = Uni_Country;
        this.Uni_Name = Uni_Name;
        this.What_they_offer = What_they_offer;

    }


    public String getCourses() {
        return Courses;
    }

    public String getUni_Country() {
        return Uni_Country;
    }

    public String getUni_Name() {
        return Uni_Name;
    }

    public String getWhat_they_offer() {
        return What_they_offer;
    }
}
