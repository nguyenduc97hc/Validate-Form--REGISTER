package com.codegym.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

@Component
public class User implements Validator {
    @NotEmpty
    @Size(min = 5,max = 45)
    private String firstName;
    @NotEmpty
    @Size(min = 5,max = 45)
    private String lastName;
    @Min(18)
    private int age;
    @Email
    private String email;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    private String phonenumber;
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String number = user.getPhonenumber();
        ValidationUtils.rejectIfEmpty(errors, "phonenumber", "number.empty");
        if (number.length()>11 || number.length()<10){
            errors.rejectValue("phonenumber", "number.length");
        }
        if (!number.startsWith("0")){
            errors.rejectValue("phonenumber", "number.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phonenumber", "number.matches");
        }
    }

}

