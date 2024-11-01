Programming Language: Java
Framework: SpringBoot
Database:PostGres
JPA and Lombo are also used.

This is a quiz App. The database contains a table named 'questions', each row consists of an id, question, 
    3 options for the right answer, the right answer, the language category and difficulty of questions.

The app has 3 main layers. The 'Controller' layer is the layer that interacts with the 'User'. 
    *Controllers:
        -Question Controller:
            The question controller responds to "/question/" and is responsible for:
                1. Showing all questions ("/question/allQuestions" on the url)
                2. Showing questions by category ("/question/java or questions/python" on the url)
                3. Adding a new question in the table ("/question/add + the JSON file that contains the question)
                    You can send a JSON File with PostMan very easily
                        JSON file format:
                            {
                                "question_title": "Maximum value for short in java",
                                "option1": "1",
                                "option2": "2",
                                "option3": "3",
                                "rightAnswer": "3",
                                "difficulty_level": "Easy",
                                "category": "Java"
                            }
                4. Deleting a question from the table (NOT YET IMPLEMENTED)
        -Quiz Controller:
            The quiz controller responds to "/quiz/" and is responsible for:
                1. Creating a new Quiz ("/quiz/create?category={cat}&numQ={num}&title={name}")
                    where   {cat} = language category eg.JAVA ,
                            {num} = number of questions in the quiz,
                            {name} = name of quiz in database
                2. Getting the quiz from the database ("/quiz/get/{id}")
                    where   {id} = is the quiz id from the database 
                3. Submitting the quiz answers and receiving a result ("/quiz/submit/{id}")
                    where   {id} = is the quiz id from the database
                        JSON file format:
                            [
                                {
                                    "id":9,
                                    "response":"+"
                                },
                                {
                                    "id":6,
                                    "response":"final int x = 5;"
                                },
                                {
                                    "id":4,
                                    "response":"throw"
                                },
                                {
                                    "id":10,
                                    "response":"ArrayList"
                                },
                                {
                                    "id":2,
                                    "response":"5"
                                }
                            ]


Next up is the Service layer, which receives the info from the Controllers and handles the business logic side
    of things. Before we dive into it, the services communicate with the DAOs which are the next layer of your app,
    which we will see immediately after. Right now all you should know is, DAOs communicate with the database to fetch
    the results we want. 
    There are two services corresponding to the two controllers, Question Service and Quiz Service.
    -Question Service:
        The question Service has methods that correspond to the methods of the Question Controller eg:
            *getAllQuestions()
                Directs the Question DAO to do a 'SELECT * FROM' query to fetch all available questions.
            *getQuestionsByCategory()
                Directs the Question DAO to do a 'SELECT * FROM + WHERE ' query to fetch all questions 
                    in a certain category.
            *addQuestion()
                Directs the Question DAO to do an 'INSERT INTO' query to add a new question to the database
            *deleteQuestion() - NOT YET IMPLEMENTED
    -Quiz Service:
        The quiz Service has methods that correspond to the methods of the Quiz Controller:
            *createQuiz()
                Creates a list of random questions and then calls on the quiz DAO to save this list as 
                    a new table in the database.
            *getQuizQuestions()
                Shows questions in a quiz, but omits properties such as the right answer, question category, difficulty etc.
            *calculateResult()
                Compares each answer with the corresponding right answer to calculate a quiz result.

Last layer in our app, as mentioned above are the DAOs or Data Access Object. DAOs send querries to the database
    and then return the result to the Service Layer. DAOs use JPA to make database access easier.
    -Question DAO
        In the question DAO, we define two methods, findByCategory and findRandomQuestionsByCategory
        We define these methods because we want a List of Question objects, unlike the quiz DAO where we use it
            to return just the quiz table.
    -Quiz DAO
        As mentioned above, it is used to return a quiz table from the database



Annotations
ResponseEntity


!====TODO====!
1.Make it show error when inputing wrong or non existing category
2.Make a delete and update Mapping



Credit:
https://www.youtube.com/watch?v=vlz9ina4Usk"# quizapp" 
# quizapp
"# quizapp" 
