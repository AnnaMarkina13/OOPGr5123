package ru.markina.student.app.services;

import java.time.LocalDate;
import java.util.List;

public interface PersonService<T> {

    List<T> getAll();

    T create(String name, LocalDate birthDate);
}
