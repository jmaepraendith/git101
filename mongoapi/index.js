const connecting = require("./model")

const express = require('express')
const path = require('path')
const { create } = require('express-handlebars');
const bodyParser = require('body-parser')

const app = express();

const rountController = require('./controller/rounts')

app.use(bodyParser.urlencoded({
    extended: true
}))

app.set('views', path.join(__dirname, "/views/"))

// Use the `create` method for express-handlebars
app.engine('hbs', create({
    extname: "hbs",
    defaultLayout: "mainlayout",
    layoutsDir: __dirname + '/views/layouts'
}).engine);

app.set("view engine", 'hbs')

app.get("/", (req,res)=>{
    //res.send('<h1>Hello World<h1>')
    res.render("index",{})
})

app.use("/rount", rountController)

app.listen("3008", ()=>{
    console.log("Server is listening on port 3008")
})