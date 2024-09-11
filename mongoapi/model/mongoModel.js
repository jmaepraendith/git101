const mongoose = require('mongoose');

const modelSchema = new mongoose.Schema({
    ModelName: String,
    ModelID : String,
    ModelDuration: String,
    ModelFee: String
});

mongoose.model('Model', modelSchema); 
