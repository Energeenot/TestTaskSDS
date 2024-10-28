# Инструкция по развертыванию проекта
## Предварительные требования:
JDK версии 22
Java 22 или sdk default
Среда разработки IntelliJ IDEA
MongoDB установленный локально или доступный через внешний сервер.
1) Склонируйте репозиторий
2) Настройте параметры подключения в application.properties:
  spring.data.mongodb.uri=mongodb://localhost:27017/имя_базы_данных
  имя_базы_данных следует заменить на фактическое имя базы данных
  При первом сохранении данных автоматически создается коллекция с именем students, которая будет хранить данные студентов.
4) Запустите проект
5) Использование API
  Получение токена: POST /auth/token
  CRUD для студентов: GET, POST, PUT, DELETE запросы к /rest/students
6) Приложение будет доступно по адресу http://localhost:8080
Примеры запросов в формате CURL:
  Windows (cmd):
    1) Получение токена
    curl -X POST http://localhost:8080/auth/token -H "Content-Type: application/x-www-form-urlencoded" -d "username=username&password=password"

    2) Получение списка студентов
    curl -X GET http://localhost:8080/rest -H "Authorization: Bearer your_access_token_here"

    3) Добавление нового студента
    curl -X PUT http://localhost:8080/rest/add -H "Authorization: Bearer your_access_token_here" -H "Content-Type: application/json" -d "{\"surname\": \"Ivanov\", \"name\": \"Ivan\", \"patronymic\": \"Ivanovich\", \"group\": \"A1\", \"averageMark\": 4.5}"

    4) Редактирование студента
   curl -X POST http://localhost:8080/rest/{id} -H "Authorization: Bearer your_access_token_here" -H "Content-Type: application/json" -d "{\"surname\": \"Petrov\", \"name\": \"Petr\", \"patronymic\": \"Petrovich\", \"group\": \"B2\", \"averageMark\": 4.2}"

    5) Удаление студента 
    curl -X DELETE http://localhost:8080/rest/{id} -H "Authorization: Bearer your_access_token_here"
   
