
// commonJS, every file is module (by default)
// Modules - encapsulated code (only share minimum)

const Name = require('./Name') // it's like import file
const sayHi = require('./Utils')

const data = require('./alternativeFlavor')
console.log(data)

//when u import a module then it invoke it
require('./mindGrenade') // it runs without assigned to variable bc we have a function inside of the module

// sayHi("susan")
// sayHi(Name.john)
// sayHi(Name.peter)