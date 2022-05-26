package org.example.models;

import javax.validation.constraints.*;

public class Simple {

    @NotEmpty(message = "Name should not be fcking empty")
    @Size(min = 2, max = 30, message = "The lenght should be between 2 and 30")
    private String name;


    public Simple(){

    }

    public Simple(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Simple{" +
                "name='" + name + '\'' +
                '}';
    }
}
