import './App.css';
import { Component } from 'react';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      notes: []
    };
  }

  API_URL = "http://localhost:5000/";

  // Lifecycle method to load existing notes when the component mounts
  componentDidMount() {
    this.refreshNotes();
  }

  // Fetch all notes from the server
  async refreshNotes() {
    try {
      const response = await fetch(this.API_URL + "api/todoapp/GetNotes");
      const data = await response.json();

      // Check if data is correctly formatted and update the state
      if (Array.isArray(data)) {
        this.setState({ notes: data });
      } else {
        console.error("Unexpected data format:", data);
      }
    } catch (error) {
      console.error('Error fetching notes:', error);
    }
  }

  // Delete a note by ID and refresh the list
  async deleteNote(id) {
    try {
      const response = await fetch(this.API_URL + "api/todoapp/DeleteNotes?id=" + id, {
        method: "DELETE"
      });

      const result = await response.json();
      alert(result);
      this.refreshNotes();  // Refresh the notes after deletion
    } catch (error) {
      console.error("Error deleting note:", error);
    }
  }

  // Add a new note
  async addeNote() {
    const newNotes = document.getElementById("newNotes").value;
    if (!newNotes) {
      alert("Please enter a note.");
      return;
    }

    const data = new FormData();
    data.append("newNotes", newNotes);

    try {
      const response = await fetch(this.API_URL + "api/todoapp/AddNotes", {
        method: "POST",
        body: data
      });

      const result = await response.json();
      alert(result);
      document.getElementById("newNotes").value = ""; // Clear the input after adding
      this.refreshNotes();  // Refresh the notes after adding a new one
    } catch (error) {
      console.error("Error adding note:", error);
    }
  }

  render() {
    const { notes } = this.state;

    return (
      <div className="App">
        <h1>ToDo APP</h1>
        
        {/* Input for adding a new note */}
        <input id="newNotes" type="text" placeholder="New note" />
        <button onClick={() => this.addeNote()}>Add note</button>

        {/* List of existing notes */}
        {notes.length > 0 ? (
          notes.map(note => (
            <p key={note._id}>
              <b>* {note.description}</b>
              <button onClick={() => this.deleteNote(note._id)}>Delete</button>
            </p>
          ))
        ) : (
          <p>No notes found.</p> // Message when there are no notes
        )}
      </div>
    );
  }
}

export default App;
