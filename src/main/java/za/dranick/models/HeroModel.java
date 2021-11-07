package za.dranick.models;

import javax.validation.constraints.*;

public class HeroModel {

    private int id;

    @NotEmpty(message = "Name is shouldn't be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;

    @NotEmpty(message = "Name is shouldn't be empty")
    @Size(min = 2, max = 30, message = "align should be between 2 and 30 characters")
    private String align;

    @NotEmpty(message = "Name is shouldn't be empty")
    @Size(min = 2, max = 30, message = "align should be between 2 and 30 characters")
    private String hair;

    @NotEmpty(message = "Name is shouldn't be empty")
    @Size(min = 2, max = 30, message = "align should be between 2 and 30 characters")
    private String gender;

    @NotEmpty(message = "Name is shouldn't be empty")
    @Size(min = 2, max = 30, message = "align should be between 2 and 30 characters")
    private int appearances;

    @NotEmpty(message = "Name is shouldn't be empty")
    @Size(min = 2, max = 30, message = "align should be between 2 and 30 characters")
    private String universe;

    @NotNull(message = "Year is shouldn't be empty")
    @Positive(message = "Age should be greater than 0")
    private int year;

    public HeroModel(String name, String align, String hair, String gender, int appearances, String universe, int year) {
        this.name = name;
        this.align = align;
        this.hair = hair;
        this.gender = gender;
        this.appearances = appearances;
        this.universe = universe;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAlign() {
        return align;
    }

    public String getHair() {
        return hair;
    }

    public String getGender() {
        return gender;
    }

    public int getAppearances() {
        return appearances;
    }

    public String getUniverse() {
        return universe;
    }

    public int getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAppearances(int appearances) {
        this.appearances = appearances;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
