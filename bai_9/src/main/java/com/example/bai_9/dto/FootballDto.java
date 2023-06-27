package com.example.bai_9.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FootballDto implements Validator {

    private int id;
    @Size(min = 5,max = 100, message = "Tên cầu thủ phải trong khoảng từ 5 đến 100 kí tự!")
    @NotBlank(message = "Vui lòng nhập tên cầu thủ!")
    @Pattern(regexp = "^[\\\\p{Lu}][\\\\p{Ll}]*([\\\\s][\\\\p{Lu}][\\\\p{Ll}]*)*$")
    private String name;
    @NotBlank(message = "Tuổi không được để trống!")
    private String dateOfBirth;
    @Min(value = 1, message = "Kinh  nghiệm phải lớn hơn hoặc bằng 1!")
    @NotBlank(message = "Kinh nghiệm không được để trống kinh nghiệm!")
    private String experience;
    @NotBlank(message = "Vị trí không được để trống!")
    @Pattern(regexp = "^(Trung vệ|Hậu vệ|Tiền vệ|Tiền đạo|Thủ môn)$")
    private String location;
    @NotBlank(message = "Không được để trống hình ảnh cầu thủ!")
    private String image;
    private boolean status;

    public FootballDto() {
    }

    public FootballDto(int id, String name, String dateOfBirth, String experience, String location, String image, boolean status) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.experience = experience;
        this.location = location;
        this.image = image;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FootballDto footballDto = (FootballDto) target;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate age = LocalDate.parse(footballDto.getDateOfBirth(), formatter);
            LocalDate now = LocalDate.now();
            int yearOld = Period.between(age, now).getYears();
            if (yearOld < 16 || yearOld > 100){
                errors.rejectValue("age","Tuổi tối thiểu là từ 16 và tối đa 100 tuổi!");
            }
        }catch (DateTimeParseException e){
            errors.rejectValue("age","age","Định dạng ngày không hợp lệ, vui lòng nhập lại!");
        }
    }
}
