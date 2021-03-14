# airline-management
1.
запустить	
-----------
скачать/разархивировать
через 'intelij' открыть	
в application.properties отредактировать:	
spring.datasource.url=jdbc:mysql://localhost:3306/ ---DATABASE_NAME--- ?useSSL=false	

spring.datasource.password=---PASSWORD---	
 
 
ПОДКЛЮЧИТЬ DB:
в папке /data найти три файла 

air_company.csv

airplane.csv

flight.csv

через MySQLWorkbench создать (new_schema)
импортировать файлы через Table Data Import Wizard


Тестировать:
в папке /data/postman найти файл testAirCompaniesManagementSystem.postman_collection.json и через постман импортировать













