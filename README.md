# Quiz App Overview

**Programming Language:** Java  
**Framework:** Spring Boot  
**Database:** PostgreSQL  
**Technologies Used:** JPA, Lombok

## Database Structure

The database contains a table named `questions`. Each row consists of:
- **id**
- **question**
- **3 options** for the right answer
- **right answer**
- **language category**
- **difficulty of questions**

## Application Layers

The app has three main layers:

### 1. Controller Layer

The `Controller` layer interacts with the user.

#### Controllers

- **Question Controller:**
  - Responds to `/question/` and is responsible for:
    1. Showing all questions (`/question/allQuestions`)
    2. Showing questions by category (e.g., `/question/java`, `/question/python`)
    3. Adding a new question to the table (`/question/add + JSON file`)
        - **JSON file format:**
          ```json
          {
              "question_title": "Maximum value for short in java",
              "option1": "1",
              "option2": "2",
              "option3": "3",
              "rightAnswer": "3",
              "difficulty_level": "Easy",
              "category": "Java"
          }
          ```
    4. Deleting a question from the table (NOT YET IMPLEMENTED)

- **Quiz Controller:**
  - Responds to `/quiz/` and is responsible for:
    1. Creating a new Quiz (`/quiz/create?category={cat}&numQ={num}&title={name}`)
        - where `{cat}` = language category (e.g., JAVA), `{num}` = number of questions, `{name}` = quiz name
    2. Getting the quiz from the database (`/quiz/get/{id}`)
        - where `{id}` = quiz id from the database
    3. Submitting the quiz answers and receiving a result (`/quiz/submit/{id}`)
        - where `{id}` = quiz id from the database
        - **JSON file format:**
          ```json
          [
              {"id": 9, "response": "+"},
              {"id": 6, "response": "final int x = 5;"},
              {"id": 4, "response": "throw"},
              {"id": 10, "response": "ArrayList"},
              {"id": 2, "response": "5"}
          ]
          ```

### 2. Service Layer

The Service layer receives information from the Controllers and handles the business logic. Services communicate with the DAOs, which access the database.

#### Services

- **Question Service:**
  - Corresponds to the Question Controller methods:
    - `getAllQuestions()`: Fetches all available questions.
    - `getQuestionsByCategory()`: Fetches questions in a specific category.
    - `addQuestion()`: Adds a new question to the database.
    - `deleteQuestion()`: NOT YET IMPLEMENTED.

- **Quiz Service:**
  - Corresponds to the Quiz Controller methods:
    - `createQuiz()`: Creates a list of random questions and saves it as a new table in the database.
    - `getQuizQuestions()`: Shows questions in a quiz, omitting certain properties.
    - `calculateResult()`: Compares answers with the correct ones to calculate a result.

### 3. DAO Layer

The DAO (Data Access Object) layer sends queries to the database and returns results to the Service layer. DAOs use JPA for easier database access.

#### DAOs

- **Question DAO:**
  - Contains methods like `findByCategory` and `findRandomQuestionsByCategory`, returning a list of Question objects.

- **Quiz DAO:**
  - Used to return a quiz table from the database.

## TODO List

1. Show an error when inputting a wrong or non-existing category.
2. Implement delete and update mappings.

## Credits

[Video Tutorial](https://www.youtube.com/watch?v=vlz9ina4Usk)
