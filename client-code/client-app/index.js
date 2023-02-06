fetch('http://localhost:8080/api/products')
.then(data=>data.json())
.then(products=>{
    console.log(products)
})

