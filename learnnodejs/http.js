const  http = require('http')

const server = http.createServer((req,res)=>{
    if(req.url === '/'){
        res.write('hello world')
       
    }
    else if(req.url === '/about'){
        res.end('about page')
    }
    res.end(`
        <h1>404 not found ka</h1>
        <p>refresh your page</p>
        <a href="/">back home</a>
        `)
})

server.listen(3200)
console.log('server is running on port 3200')
