# this is the version of image not node tho
FROM node:16 

WORKDIR /app
# 1st create working directory for docker so to tell docker want to do or where to collect file

COPY package.json /app
# copy the package.json file from the current directory to the working directory inside the container

RUN npm install 
# will install what is in pakage.json

COPY . /app

CMD node app.js

# your application's default port
EXPOSE 3008