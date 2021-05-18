ADD PIZZA
Method-POST
URL-http://localhost:9091/pizza/add
Body 1-{
    "pizzaType": "Extra Cheese",
    "pizzaName": "Chicken tikka Pizza",
    "pizzaDescription": "Chicken tikka toppings with extra cheese",
    "pizzaCost": 500,
    "pizzaQuantity": 4
}

Body 2-{
    "pizzaType": "Extra Chicken",
    "pizzaName": "Chicken Sausage Pizza",
    "pizzaDescription": "Chicken sausage toppings with extra chicken",
    "pizzaCost": 500,
    "pizzaQuantity": 4
}



DELETE PIZZA
Method-DELETE
URL-http://localhost:9091/pizza/delete/1



VIEW ALL PIZZA
Method-GET
URL-http://localhost:9091/pizza/viewAllPizza



VIEW PIZZA BY ID
Method-GET
URL-http://localhost:9091/pizza/viewpizza/2



UPDATE PIZZA
Method-PUT
URL-http://localhost:9091/pizza/UpdatePizza
Body-{
    "pizzaId": 2,
    "pizzaType": "Extra Olive",
    "pizzaName": "Chicken Sausage Pizza",
    "pizzaDescription": "Chicken sausage toppings with extra chicken",
    "pizzaCost": 500,
    "pizzaQuantity": 6
}



VIEW PIZZA WITHIN MINIMUM COST AND MAXIMUM COST
Method-GET
URL-http://localhost:9091/pizza//viewPizzaList/100/600
