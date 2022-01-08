Домашние задания для курса "Java QA Engineer. Professional " в OTUS 

Группа 2021-12

Maksim Maslov (Максим Маслов)

ДЗ 1: Автотест со своими ожиданиями
Цель:

Реализовать на практике полученные знания, с использованием Actions и своих ожиданий.

Необходимо создать проект в Maven'e и реализовать:

Фабрику (WebDriverFactory), которая будет получать значение из окружения и запускать соответствующий браузер Браузеры: Chrome, Firefox, Opera
Реализовать подсветку элементов перед нажатием, после нажатия вернуть данные в исходное состояние
На главной странице Otus'a снизу найти список курсов(популярные курсы, специализации, рекомендации) и реализовать:

Метод фильтр по названию курса
Метод выбора курса, стартующего раньше всех/позже всех (при совпадении дат - выбрать любой) при помощи reduce

Реализовать движение мыши при помощи и выбор курса при помощи библиотеки Actions



### preinstall

```
    install and run Intellij Idea
```

### install

```
    git clone https://github.com/maksim-maslov/2021-12-otus-javaQA
```

### run tests

```
    mvn clean test -Dbrowser=CHROME -Dcourse="PHP Developer. Basic" -Dorder=max
```

### Структура файлов проекта

```
app/                    	
  src/                  
    main/
	test/
	  java/
		ru.otus.homework/
		  driver/			--> конфигурация webdriver
		  listener/			--> listener
		  page/				--> pageobject
		  test/				--> тесты
  pom.xml					--> конфигурация maven
  testng.xml				--> конфигурация testng
  .gitignore				--> gitignore
  README.md					--> описание проекта
```
