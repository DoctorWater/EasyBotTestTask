# EasyBotTestTask
## Порядок сборки и запуска проекта
1. Склонируйте папку в новый локальный репозиторий.
2. Войдите на уровень ../EasyBotTestTask и запустите "gradle clean".
3. На том же уровне запустите "gradle build".
4. Затем -- "gradle bootJar".
5. Перейдите на уровень ../EasyBotTestTask/build/libs и найдите исполняемый файл формата ".jar" без пометки "plain" в названии.
6. Запустите его командой "java -jar <имя файла>"
## Некоторые пояснения к архитектуре
В данной работе использован нестандартный подход к организации репозиториев и сервисов: вместо создания отдельных классов для каждой дочерней сущности класса Product созданы типизируемые репозиторий и сервис. Такой подход позволяет проще расширять приложение в дальнейшем, соблюдая принципы SOLID. 
