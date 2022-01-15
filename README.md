
### install

```
    git clone https://github.com/maksim-maslov/2021-12-otus-javaQA
```

### run tests

```
    mvn clean test -Dbrowser=CHROME -Dcourse="PHP Developer. Basic" -Dorder=min -Dcourses="Популярные курсы"
        
    mvn clean test -Dbrowser=OPERA -Dcourse="Специализация С#" -Dorder=max -Dcourses="Специализации"
    
    browser - CHROME / FIREFOX / OPERA
    course - Название курса для поиска ("PHP Developer. Basic", "Специализация C#", ...)
    order - min / max (самый ранний, поздний курс) 
    courses - Популярные курсы / Специализации    
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
  pom.xml			        --> конфигурация maven
  testng.xml				--> конфигурация testng
  .gitignore				--> gitignore
  README.md			        --> описание проекта
```
