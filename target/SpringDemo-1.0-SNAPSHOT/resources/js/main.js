/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function addToCart(id,name,price) {
    fetch("/SpringDemo/api/add-cart", {
        method: 'post',
        body: JSON.stringify({
            "id": id,
            "name":name,
            "price": price,
            "quantity": 1
        }),
        header: {
            'Content-Type': 'application/json'
        }
    }).then(res => res.json()).then(data => {
        console.info(data)
    })
}



