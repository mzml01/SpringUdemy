package com.mzml.themleafdemo.Model;

import com.mzml.themleafdemo.Validator.CoursePrefix;
import jakarta.validation.constraints.*;

import java.util.List;

public class Student {
    private String firstName;
    @NotNull(message = "is required")
    @Size(min = 1, message = "must be greater than 1")
    private String lastName;
    private String country;
    private List<String> favoriteLanguage;
    @NotNull(message="is Required!!")
    @Min(value = 0, message = "must be greater than or equal to zero")
    @Max(value=10, message = "must be less than or equal to 10")
    private Integer freePass;
    @Pattern(regexp = "^\\d{6}$", message = "only 6 chars/digits")
    private String postalCode;
    @CoursePrefix()
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String CourseCode) {
        courseCode = CourseCode;
    }

    @Pattern(regexp = "^\\d{6}$", message = "only 6 chars/digits")
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(@Pattern(regexp = "^\\d{6}$", message = "only 6 chars/digits") String postalCode) {
        this.postalCode = postalCode;
    }

    @Min(value = 0, message = "must be greater than or equal to zero")
    @Max(value = 10, message = "must be less than or equal to 10")
    public Integer getFreePass() {
        return freePass;
    }

    public void setFreePass(@Min(value = 0, message = "must be greater than or equal to zero") @Max(value = 10, message = "must be less than or equal to 10") Integer freePass) {
        this.freePass = freePass;
    }

    public List<String> getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(List<String> favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Student() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
