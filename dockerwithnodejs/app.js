const express = require('express')
const app = express()

app.get("/", (req,res)=>{
    res.send("Hello World")
})

app.listen(3008, ()=>{
    console.log('Server is running on port 3008')
})


//the Dockerfile will tell the docker what to do