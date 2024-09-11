const express = require('express');
const mongoose = require('mongoose');

const router = express.Router(); 
const rountModel = mongoose.model('Model'); // Ensure 'Model' is correctly defined

router.get('/add', (req, res) => {
    res.render('add-model'); 
});

router.post('/add', async (req, res) => {
    try {
        // Create a new document using the rountModel
        const model = new rountModel({
            ModelName: req.body.ModelName,
            ModelDuration: req.body.ModelDuration,
            ModelFee: req.body.ModelFee,
            ModelID: Math.ceil(Math.random() * 100000) + ""
        });

        // Save the model to the database using Promises
        await model.save();
        res.redirect('/rount/list'); // Redirect to list after saving

    } 
        
    catch { (err)=> {
                console.error("Error adding data: ", err);
                res.status(500).send("Error occurred while adding data");
            }
        }
        
});

router.get('/list', async (req, res) => {
    try {
        const docs = await rountModel.find().lean(); // Find all documents
        console.log('Docs:', docs); // Log the documents
        res.render('list', { data: docs }); // Render the list view
    } catch (err) {
        console.error("Error fetching data: ", err);
        res.status(500).send("Error");
    }
});


module.exports = router;
