# Testez Application Full Stack

SpringBoot : 3.4.0  
Java : 11  
Maven : 4.0.0  
JDK : 21  

## Installations

1. [Angular CLI](https://angular.io/cli)
2. [Node.js](https://nodejs.org/)
3. [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
4. [MySQL Server and MySQL Workbench](https://dev.mysql.com/downloads/)
5. [Maven](https://maven.apache.org/)

## Base de données : configuration

### MySQL : configuration

Rendez-vous sur l'adresse suivante : localhost  
L'utilisateur par défaut est root, il n'y a pas de mot de passe.

### Création Base de données dans PhpMyAdmin

Connectez-vous.  
Créez votre base de données.  
Depuis l'onglet import, importez le script pour la création de la base de données qui se trouve :  
`Projet5Test\resources\sql\script.sql`

## Téléchargement du projet

```sh
git clone https://github.com/ShaiD9/Projet5Test.git
```

## Configuration et exécution du Back-end

1. Ouvrez le fichier `application.properties`.
2. Insérez votre identifiant et mot de passe SQL Server pour les lignes suivantes :
```sh
spring.datasource.username=
spring.datasource.password=
```
3. Naviguez vers le dossier back :
```sh
cd back
```
4. Exécutez le projet :
```sh
mvn spring-boot:run
```
5. Installez les dépendances :
```sh
npm install
```
6. Exécutez le projet :
```sh
npm start
```

L'application sera accessible à l'adresse : [http://localhost:4200](http://localhost:4200)

Connectez-vous avec les identifiants suivants :

- Email : yoga@studio.com
- Mot de passe : test!1234

## Tests Front-end

Pour exécuter les tests front-end :
```sh
npx jest --coverage
```

## Tests End-to-end

Pour exécuter les tests end-to-end :
```sh
npm run e2e
```
En utilisant le test runner Cypress, exécutez le fichier nommé `allTestCoverage.cy.ts` pour obtenir la couverture de tous les tests end-to-end du projet.

Pour générer le fichier de couverture (uniquement si le test e2e est terminé avant) :
```sh
npm run e2e:coverage
```

## Tests Back-end

Naviguez vers le dossier back du projet et exécutez les tests back-end :
```sh
mvn clean test
```