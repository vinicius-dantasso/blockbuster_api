![block buster](https://user-images.githubusercontent.com/44126505/220794093-2592d051-0487-48c0-a4dd-8454638b4016.png)

# Introduction
Blockbuster is a project developed for the Web Development discipline of the Computer Science course at  [Universidade Federal Rural do Semiárido - UFERSA](https://cc.ufersa.edu.br/). The main purpose of the project is to create an API for a movie and series purchase and rental system.

# Installation
1. Clone the repository
2. Set the mysql database username and password in the application.properties file

# Routes
## Movies
- GET - /api/movies 
- GET - /api/movies/{uuid}
- POST - /api/movies
- PUT - /api/movies
- DELETE - /api/movies/{uuid}

## Series
- GET - /api/series
- GET - /api/series/get_By_Id/{id}
- POST - /api/series
- GET - /api/series/get_By_Title/{title}
- PUT - /api/series
- DELETE - /api/series/{uuid}

## Users
- GET - /api/user
- GET - /api/user/{userId}
- POST - /api/user
- PUT - /api/user
- PATCH - /api/user
- DELETE - /api/user/{userId}
- PATCH - /api/my_list/movies
- PATCH - /api/my_list/series

# Uploads
- POST - /api/images/upload
- GET - /api/images/{filename}