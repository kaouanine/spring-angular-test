Node.js	16.17.0
Angular CLI		14.1.3
Java SE	17.0.4

-Specifications:

- Application that provides the following endpoints:

  •	POST /articles: This endpoint allows to create an Article in our in-memory database (H2) using Spring JPA.
    An Article is described by his ID, name, price, and picture.
  
  •	GET /articles/{id}: This endpoint allows to fetch an article by ID from the database and return an ArticleDTO as JSON.
    If the article is not found will return 400 http response.
  
  •	GET /articles: This endpoint allows to fetch all existing Articles in the database is return a List<ArticleDTO> as JSON and
    if the database is empty return empty array.
  
  •	GET /orders: This endpoint allows to fetch all existing Orders from the database return a List<OrderDto> and
    if the database is empty return empty array.
  
  •	POST /orders: this endpoint allows to create an order, an order is described by his ID,
    Reference (random alphanumeric string),List<Article>,date.
  
  •	PUT /orders/{id}: this endpoint allows to edit articles (remove/add new article) of an order and
    if is not found will return 400 http response.
