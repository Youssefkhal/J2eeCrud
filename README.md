

# Application Web Jakarta EE - Gestion des Articles

## Description du projet

Ce projet consiste à développer une application web respectant le standard **Jakarta EE**, avec **JDK 17** et **Tomcat 10**. L'application met en œuvre plusieurs services essentiels pour la gestion des utilisateurs et des articles. L'application est construite avec les technologies suivantes :

* **Servlets** : pour gérer la logique de traitement des requêtes.
* **JSP (Java Server Pages)** : pour générer dynamiquement le contenu HTML.
* **JSTL (JavaServer Pages Standard Tag Library)** : pour simplifier l'intégration de la logique Java dans les pages JSP.
* **Filtres** : pour appliquer des traitements avant ou après l'exécution des requêtes HTTP.
* **Bootstrap** : pour rendre l'application responsive et moderne.
* **JDBC** : pour l'accès à la base de données relationnelle MySQL.

## Fonctionnalités

L'application offre les services suivants :

1. **Service d'authentification** :

   * Un système de login simple avec un nom d'utilisateur et un mot de passe.
   * Les utilisateurs sont sauvegardés dans une base de données relationnelle (ex. MySQL 8), dans la table **login**.
   * L'utilisateur peut se connecter et accéder à la page principale s'il est authentifié.

2. **Service pour créer un nouvel article** :

   * Les utilisateurs peuvent créer de nouveaux articles, avec les informations suivantes :

     * **id** : Identifiant unique de l'article (généré automatiquement).
     * **title** : Titre de l'article.
     * **content** : Contenu de l'article.
     * **author** : Auteur de l'article.
   * Les articles sont sauvegardés dans la base de données, dans la table **articl**.

3. **Service pour modifier un article existant** :

   * Les utilisateurs peuvent modifier les informations d'un article existant en fonction de son identifiant (`id`).

4. **Service pour supprimer un article existant** :

   * Les utilisateurs peuvent supprimer un article existant en fonction de son identifiant (`id`).

5. **Service de recherche multicritère** :

   * Les utilisateurs peuvent effectuer une recherche sur les articles en fonction de plusieurs critères comme le **title**, **content**, ou **author**.
   * Le système retourne les articles correspondant aux critères de recherche.

## Architecture de l'application

L'application suit le modèle **MVC** (Modèle-Vue-Contrôleur), où :

* **Modèle** : représente les objets de données, comme les articles et les utilisateurs.
* **Vue** : est générée via les pages JSP et utilise Bootstrap pour l'interface utilisateur.
* **Contrôleur** : est constitué des servlets qui gèrent la logique métier.

### Technologies utilisées

* **Jakarta EE** : pour la gestion des servlets, des filtres, et des pages JSP.
* **JDK 17** : pour la version de Java.
* **Tomcat 10** : comme serveur d'application.
* **JDBC** : pour l'interaction avec la base de données MySQL 8.
* **MySQL 8** : pour la base de données relationnelle qui stocke les utilisateurs et les articles.
* **Bootstrap 5** : pour un design réactif et moderne.
* **JSTL** : pour simplifier l'affichage des données dans les JSP.

## Installation

### Prérequis

* **Java JDK 17** : Téléchargez et installez la version JDK 17.
* **MySQL 8** : Installez et configurez une instance de MySQL.
* **Tomcat 10** : Téléchargez et configurez Tomcat 10 pour déployer l'application.

### Configuration de la base de données

1. **Création de la base de données** :

   ```sql
   CREATE DATABASE gestion_articles;
   ```

2. **Table des utilisateurs (login)** :

   ```sql
   CREATE TABLE login (
       
       username VARCHAR(50) NOT NULL,
       password VARCHAR(255) NOT NULL
   );
   ```

3. **Table des articles (articl)** :

   ```sql
   CREATE TABLE article (
       id INT AUTO_INCREMENT PRIMARY KEY,
       title VARCHAR(255) NOT NULL,
       content TEXT NOT NULL,
       author VARCHAR(255) NOT NULL
   );
   ```

### Déploiement de l'application

1. **Téléchargez le code source** de l'application depuis le dépôt GitHub.
2. **Déployez l'application sur Tomcat** :

   * Placez le fichier WAR dans le répertoire `webapps` de votre installation Tomcat.
   * Démarrez Tomcat pour que l'application soit accessible via `http://localhost:8080`.

## Utilisation

1. **Authentification des utilisateurs** :

   * Accédez à la page de connexion via `login.jsp`.
   * Entrez le nom d'utilisateur et le mot de passe pour vous authentifier.

2. **Gestion des articles** :

   * **Créer un nouvel article** : Accédez à la page `addArticle.jsp` pour ajouter un nouvel article avec un titre, contenu, et auteur.
   * **Modifier un article** : Cliquez sur l'article à modifier et accédez à la page de modification `editArticle.jsp`.
   * **Supprimer un article** : Sélectionnez un article et cliquez sur "Supprimer".
   * **Rechercher un article** : Utilisez la fonction de recherche sur la page d'accueil pour filtrer les articles par critères (titre, contenu, auteur).

## Structure du projet

Voici la structure des fichiers du projet :

```
|-- src/
|   |-- net/
|   |   |-- javaguides/
|   |   |   |-- login/
|   |   |   |   |-- bean/
|   |   |   |   |   |-- Article.java
|   |   |   |   |-- database/
|   |   |   |   |   |-- ArticleDao.java
|   |-- webapp/
|   |   |-- WEB-INF/
|   |   |   |-- web.xml
|   |   |-- index.jsp
|   |   |-- login.jsp
|   |   |-- addArticle.jsp
|   |   |-- editArticle.jsp
|   |   |-- listArticles.jsp
|-- lib/ (contient les bibliothèques nécessaires)
```

## Contribution

Si vous souhaitez contribuer à l'application :

1. Forkez le projet.
2. Clonez votre fork localement.
3. Créez une branche pour vos modifications (`git checkout -b feature/mon-feature`).
4. Faites vos changements.
5. Commitez vos changements avec des messages clairs (`git commit -m "Ajout de fonctionnalité"`).
6. Poussez vos modifications vers votre fork (`git push origin feature/mon-feature`).
7. Ouvrez une Pull Request.

---

## Auteurs

* **Nom de l'auteur 1**
* **Nom de l'auteur 2**



https://github.com/user-attachments/assets/dd50235f-b53c-4213-b11d-a0f0585a478e


