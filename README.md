
TradeShift - Backend (Minimal Demo)
----------------------------------

This is a minimal Spring Boot backend project using H2 in-memory database,
JWT utilities, basic entities (User, Portfolio, Asset), repositories, and
controllers for auth, portfolios, market (mock), and trade (buy).

How to run:
1. Ensure Java 17+ and Maven are installed.
2. Unzip and open the folder in IntelliJ IDEA as a Maven project.
3. Run: mvn spring-boot:run  OR run TradeshiftBackendApplication from IDE.
4. H2 Console: http://localhost:8080/h2-console  (JDBC URL: jdbc:h2:mem:tradeshiftdb)

Default endpoints:
- POST /api/auth/register   -> register {username,password,role}
- POST /api/auth/login      -> login {username,password}  (returns token)
- GET  /api/market/quote/{symbol}
- GET  /api/portfolios/{userId}
- POST /api/portfolios      -> create portfolio JSON
- POST /api/trade/buy       -> {portfolioId, symbol, quantity, price}

Note: JWT token generation is available; token verification in filters is not wired
to controllers in this minimal demo. This project is intended as a starting point.
