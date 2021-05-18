

VIEW ALL ORDER
METHOD-GET
URL-   http://localhost:9091/orders/viewAllOrder


BookOrderInfo
METHOD-POST
URL -  http://localhost:9091/orders/insertOrder/0/101/401    (cartid/customerid/couponid)


UpdateOrder
METHOD-PUT
URL-http://localhost:9091/orders/UpdateOrder

{
"orderId": 3,
"coupan":
{
    "coupanId":201
},
"finalPrice": 100.0,
"orderStatus": "NotPicked",
"cart": {
    "cartId":0
},
"orderDate": "2021-05-18",
"customer":{
"customerId": 101
}
}

//First update the order,then book the order  



ViewOrder
METHOD-GET
URL - http://localhost:9091/orders/viewOrderByOrderandCustomerId/101/2  (customerId/orderId)


DeleteOrder
METHOD-DELETE
URL -  http://localhost:9091/orders/DeleteOrder/3













