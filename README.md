Для данного приложения используется база данных PostgreSQL

Для настройки нужно проделать следующие шаги:
1. Создать базу данных, в которую будут помещены таблицы
2. Выполнить запросы из файла src/main/resources/sql_script.sql для создания таблиц и их содержимого
3. Настороить в конфигурационном файле src/main/resources/application.properties поля:
   a) hibernate.connection.url - изменить порт и название используемой базы данных
   b) hibernate.connection.username - логин 
   c) hibernate.connection.password - пароль
4. Запустить src/main/org/example/Main файл

Пример экспорта JSON - src/main/resources/exportExample.json
Генерируемые файлы экспорта JSON будут располагаться в папке src/main/resources
