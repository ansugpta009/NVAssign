const app = require("express")();
const http = require("http").createServer(app);
const io = require("socket.io")(http);
const port = process.env.port || 3000;

let users = {};
let connectCounter=0;

app.get("/", (req, res) => {
  res.sendFile(__dirname + "/client/index.html");
});

app.get("/script", (req, res) => {
  res.sendFile(__dirname + "/client/script.js");
});

io.on("connect", (socket) => {
  socket.on("new-user", (user) => {
    connectCounter++;
    console.log(connectCounter + " users connected");
   // socket.broadcast.emit( socket.client.conn.server.clientsCount + " users connected");
    users[socket.id] = user;
    socket.broadcast.emit("user-connected", user);
    
  });
  socket.on("typing", (data) => {
    socket.broadcast.emit("typing_status", data);
  });
  socket.on("chat-message", (msg) => {
    socket.broadcast.emit("chat-message", {
      username: users[socket.id],
      message: msg,
    });
  });
  socket.on("disconnect", () => {
    connectCounter--;
    console.log(connectCounter + " users connected");
   
    socket.broadcast.emit("user-disconnected", users[socket.id]);
    delete users[socket.id];
  });
});

http.listen(port, () => {
  console.log(`Listeing to http://localhost:${port}`);
});
