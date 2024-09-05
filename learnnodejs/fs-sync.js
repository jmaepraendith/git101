//file system
const {readFileSync,writeFileSync} = require('fs')
// const fs = require('fs')
// fs.readFileSync == const {readFileSync} = require('fs')

const first = readFileSync('./content/first.txt','utf8')
const second = readFileSync('./content/second.txt','utf8')
console.log(first,second)

writeFileSync(
    './content/result-sync.txt',
    `here is the result : ${first} , ${second}`,
    {flag:'a'} //a - append, w - write, r - read
)
console.log(readFileSync('./content/result-sync.txt','utf8'))

