package org.example;

import java.util.Scanner;

interface CRUD_OPERATIONS {
    void CreateExercise(Scanner scanner);
    void ReadExercise();
    void UpdateExercise(Scanner scanner);
    void DeleteExercise(Scanner scanner);
}

//The four CRUD Operations
//Admin will be able to Use all Four
//User will only be able to use the 'Read' operations