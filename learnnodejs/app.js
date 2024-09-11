// console.log("hey it's my first node app!!")
// console.log("hello world")

// NO Globals variable!! cus nodejs isn't browser so no window object that we can access but still have global variable syntax tho
// __dirname - path to current directory
// __filename - file name
// require - fucntion to use modules (commonJS)
// module - info about current module (file)
// process - info about env where the program is being executed
// console - function to print to the console
// process.argv - array of command line arguments
// process.env - object containing env variables
// process.exit - exit the program
// process.on - listen for events

// process = when it comes to a node app executing on our com but when deploy api in server that in different env

// console.log(__dirname)
// setInterval(()=>{
//     console.log("hello world")
// },1000) 
//set time out, callback function, run every seconds with hello world

//  npm - global command, come with node check npm --version
//  local dependency - use it only in this particular project //npm i <packageName>

//  global dependency - use it every project 
//npm install -g <packageName>


//  yarn - package manager alternative to npm
//  package.json - store info about project and its dependencies // it's like a manifest file stores importance info about project/package
// manual approach (create package.json in the root, create properties etc)
//npm init (step by step, press enter to skip)
// npm init -y (skip all questions and create package.json with default values)

// npm install <packageName> (install package and add it to dependencies in package.json)
// npm install <packageName> --save (install package and add it to dependencies in package.json)

//  node_modules - folder where all dependencies are stored

// if i want to public the package then the name has to be unqiue
// when run command npm i lodash then refresh the folder then we gonna have an "node_modules" where stored all the dependencies
// so we have only 1 folder is lodash mean we have 1 dependency



const _ = require('lodash')

const item = [1, [2,[3,[4]]]]
const newItem = _.flattenDeep(item)
console.log(newItem)
console.log('hello world')

// for  someone who download from git when you clone or pull maybe u have to use command "npm install" to be able to run

// we use "devDependencies" while we creating an app so we not jam it with Dependencies because Dependencies are the depend that the app use not depend that create the app

// we try to install nodemon globally so we can use nodemon in all our packet so we can run like 'nodemon app.js'

