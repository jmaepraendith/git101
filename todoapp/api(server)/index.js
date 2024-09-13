const express = require('express');
const { MongoClient } = require('mongodb');
const cors = require('cors');

const app = express();
app.use(cors());
app.use(express.json());

const connection_string = "mongodb+srv://marjeniss:8BT19ksAivgjyOA2@cluster0.2gbwd.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
const DATABASENAME = 'todoapp';
let database;

async function connectToDatabase() {
    try {
        const client = await MongoClient.connect(connection_string);
        database = client.db(DATABASENAME);
        if (database) {
            console.log(`Connected to database: ${DATABASENAME}`);
        } else {
            console.error('Database is undefined after connection');
        }
    } catch (error) {
        console.error('Error connecting to the database:', error);
        process.exit(1); // Exits the process if connection fails
    }
}

app.listen(5000, async () => {
    await connectToDatabase();
    console.log('Server is running on port 5000');
});

// Route to get all notes
app.get('/api/todoapp/GetNotes', async (req, res) => {
    try {
        if (!database) {
            throw new Error('Database connection is not established.');
        }

        const collection = database.collection('todoappcollection');
        const notes = await collection.find({}).toArray();
        
        res.status(200).send(notes);
    } catch (err) {
        console.error('Failed to retrieve notes:', err.message || err);
        res.status(500).send({ message: 'Failed to retrieve notes', error: err.message || err });
    }
});


app.post('/api/todoapp/AddNotes',(req,res)=>{
    database.collection('todoappcollection'.count({},(err,numofdocs){
        database.collection('todoappcollection').insertOne({
            id:(numofdocs+1).toString(),
            description:req.body.newNotes
        })
        res.json("Add Successfully")
    }))
})

app.delete('/api/todoapp/DeleteNotes',(req,res)=>{
    database.collection('todoappcollection').deleteOne({id:req.body.id})
    res.json("Delete Successfully")
})