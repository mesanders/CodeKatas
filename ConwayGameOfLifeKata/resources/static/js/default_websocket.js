var ws = new WebSocket("ws://localhost:8080/game");

// Called when the socket connection established
ws.onopen = function() {
	appendLog("Connected to the websocket service.");
};

// Called when a message is received from the server
ws.onmessage = function (event) {
	// Javascript event is :MessageEvent type. Data is an object and in this case it's a string.
	if (!event.data.includes("*")) { 
		appendLog(event.data);
	} else {
		appendGameOfLife(event.data);
	}
};

ws.onclose = function() {
	appendLog("Disconnected from Web Service");
};

ws.onerror = function(error) {
	console.log("There was an error: " + error);
};

// appends logText to log text area
function appendLog(logText) {
	var log = document.getElementById("log");
	log.value = log.value + logText + "\n";
}

// Refreshes Conway Game "of Life
function appendGameOfLife(logText) {
	var log = document.getElementById("log");
	log.value = logText;
}

// sends msg to the server over websocket
function sendToServer(message) {
	ws.send(message);
}

