ADD PIZZA TO CARTITEM
Method-POST
URL-http://localhost:9091/cart/addItem/{customerid}
Body 1-{

    "pizzaId": 1,
    "pizzaSize": "large",
    "quantity": 1,
    "customerId": 101
    
}
Body 2-{

    "pizzaId": 301,
    "pizzaSize": "medium",
    "quantity": 2,
    "customerId": 101
    
}

CREATE CART
Method-POST
URL-http://localhost:9091/cart/createCart/{customerid}

UPDATE CART QUANTITY
Method-PUT
URL-http://localhost:9091/cart/updateCartQuantity/{customerid}/{itemid}/{quant}

DELETE CARTITEM 
Method-DELETE
URL-http://localhost:9091/cart/deleteItemFromCart/{cutomerid}/{itemid}

CLEAR CART
Method-DELETE
URL-http://localhost:9091/cart/clearCart/{id}

