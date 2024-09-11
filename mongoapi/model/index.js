// mongoose use for connecting nodels envi with mongodb server
const mongoose = require('mongoose');

mongoose.connect("mongodb://localhost:27017/testmongoapi")
    .then(() => {
        console.log("connected to database successfully");
    })
    .catch((err) => {
        console.log("Error connected to database!!!", err);
    });

const Model = require("./mongoModel")