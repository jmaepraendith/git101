const express = require('express')
const cors = require('cors')
const {connect} = require('mongoose')
require('dotenv').config()

const app = express()

connect(process.env.MONGO_URI).then(app.listen(500, () => console.log(`Serveris running on port ${process.env.PORT}`))).catch(error =>{console.log(error)})



