# 🎬 TMDb API Test Automation – Postman Project

This project is a comprehensive **test automation suite** designed to test the **TMDb (The Movie Database) API** using **Postman**.  
It automates API requests and validates responses through functional assertions using Postman test scripts.

---

## 🎯 Project Goals

- Execute key TMDb API endpoints such as movie search, details retrieval, favorites management, and watchlist operations.
- Automatically validate API responses via **Postman tests**.
- Log meaningful request and response details to the Postman console.
- Organize reusable requests and environment variables for flexible and maintainable tests.

---

## 🔍 Tested API Endpoints & Features

| Function                | Description                                  |
|-------------------------|----------------------------------------------|
| Search Movie            | Search movies by keyword                      |
| Get Movie Details       | Retrieve detailed info of a specific movie   |
| Create Session          | Generate a new user session                   |
| Add to Favorite         | Add a movie to user's favorites               |
| Create Watchlist        | Create a watchlist for the user                |
| Add to Watchlist        | Add a movie to user's watchlist                 |
| Rate Movie              | Submit a rating for a movie                     |

---

## ⚙️ Technologies & Tools

- **Postman**: API request execution and test automation.
- **JavaScript**: Writing assertions and logging in Postman test scripts.
- **TMDb API**: RESTful API under test.
- **Postman Environment Variables**: For managing API keys, session IDs, and dynamic data.
- **Git + GitHub**: Source control and project sharing.

---

## 🛠️ Project Structure and Test Scenarios

### 1. Environment Variables

- `api_key` — TMDb API key.
- `session_id` — Authenticated session token.
- `account_id` — User account identifier.

### 2. Postman Collection Overview

| Request Name           | Method | Endpoint                                   | Description                          |
|------------------------|--------|--------------------------------------------|------------------------------------|
| Search Movie           | GET    | `/search/movie`                            | Search movies by keyword            |
| Get Movie Details      | GET    | `/movie/{movie_id}`                        | Fetch detailed movie information   |
| Create Session         | POST   | `/authentication/session/new`              | Create a new session token          |
| Add to Favorite        | POST   | `/account/{account_id}/favorite`           | Add a movie to favorites            |
| Create Watchlist       | POST   | `/account/{account_id}/watchlist`          | Create a watchlist                  |
| Add to Watchlist       | POST   | `/account/{account_id}/watchlist`          | Add a movie to watchlist            |
| Rate Movie             | POST   | `/movie/{movie_id}/rating`                  | Rate a movie                       |

### 3. Example Test Cases

- **Search Movie**  
  - Response status should be `200 OK`.  
  - Result list should contain at least one movie.  
  - Returned movies should include the searched keyword in titles.

- **Add to Favorite**  
  - Response status should be `200 OK`.  
  - Response body should confirm the movie is marked as favorite.

- **Rate Movie**  
  - Response status should be `201 Created`.  
  - The rating value in response matches the submitted rating.

---

## 🔥 Error Handling & Negative Testing

- Invalid API key results in `401 Unauthorized` and is asserted in tests.
- Nonexistent movie IDs return `404 Not Found`, verified by test scripts.
- API rate limiting triggers `429 Too Many Requests`, properly caught and handled.

---

## 📊 Logging & Console Outputs

Each API request logs the following in Postman Console:  
- Request URL  
- Response status code  
- Response time  
- Test pass/fail results

---

## 👩‍💻 QA Team

| İsim           | GitHub Profili                                      |
|----------------|------------------------------------------------------|
| Merve Kıtır     | [github.com/mervektr](https://github.com/mervektr)         |
| Mert Saraç      | [github.com/meertsarac](https://github.com/meertsarac)     |
| Barış Sancar    | [github.com/brssncr](https://github.com/brssncr)           |
| Tolga Aktaş     | [github.com/aktstlga](https://github.com/aktstlga)         |
| Mert Canat      | [github.com/MertCanat91](https://github.com/MertCanat91)   |
| Berk Gültekin   | [github.com/berkgltkn](https://github.com/berkgltkn)       |

---

## 📁 How to Use

1. Open Postman.
2. Import the Postman collection file (`TMDb_API.postman_collection.json`).
3. Import the environment file (`TMDb_API.postman_environment.json`).
4. Update environment variables (`api_key`, `session_id`, `account_id`) with your own TMDb credentials.
5. Run the requests in sequence to execute the automated API tests.
6. View assertion results in the Postman Test Results panel.

---

### 🎯 Project Significance

This Postman test automation project ensures **API reliability** and supports integration into **CI/CD pipelines**.  
It is a valuable addition for QA engineers to develop their API testing skills and strengthen their portfolios.

