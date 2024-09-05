const path = require('path')

console.log(path.sep) // sep return specific separator '/'

const filePath = path.join('/content','subfoldder','text.txt')
console.log(filePath)

const base = path.basename(filePath)
console.log(base)

const absolute = path.resolve(__dirname,'content','subfolder','text.txt')
console.log(absolute) 