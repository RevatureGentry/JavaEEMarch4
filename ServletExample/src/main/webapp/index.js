window.onload = () => {
	getAllTodos();
	document.getElementById("createTodoBtn").addEventListener("click", createTodo);
}

const getAllTodos = () => {
	// Step 1: Create an XMLHttpRequest object
	const xhr = new XMLHttpRequest();
	
	// Step 2: Assign a callback function to xhr.onreadystatechange
	xhr.onreadystatechange = () => {
		// Step 5: We handle each of the different possible outcomes from making this request
		if (xhr.status === 200 && xhr.readyState === 4) {
			const json = xhr.responseText;
			populateTodoTable(JSON.parse(json));
		}
	};
	
	// Step 3: We call xhr.open(), passing in 2 strings for the HTTP Method and URL
	xhr.open("GET", "http://localhost:8080/ServletExample/api/todos");
	
	// Step 4: We call xhr.send() to actually fire off your HTTP Request
	xhr.send();
}


const populateTodoTable = (listOfTodos) => {
	// The for...of loop is Javascript's version of the enchanced for loop
	// The for...in loop, this iterates over every property of a JS object
	for (let todo of listOfTodos) {
		// Create a table cell for each property of our object
		const tdId = document.createElement("td");
		const tdTitle = document.createElement("td");
		const tdDescription = document.createElement("td");
		
		// Set the value of each cell
		tdId.textContent = todo.id;
		tdTitle.textContent = todo.title;
		tdDescription.textContent = todo.description;
		
		// Create a row to be appended onto our table
		const row = document.createElement("tr");
		
		// Set the td's to the corresponding order of our table header
		row.appendChild(tdId);
		row.appendChild(tdTitle);
		row.appendChild(tdDescription);
		
		
		// Append our row onto our table of todos
		document.getElementById("todoTable").appendChild(row);
	}
}


const createTodo = () => {
	// Step 1: Create the XHR object
	const xhr = new XMLHttpRequest();
	
	// Step 1a: Create a helper variable for your form data
	const formData = parseForm();
	
	// Step 2: Assign the callback function to xhr.onreadystatechange
	xhr.onreadystatechange = () => {
		if (xhr.status === 200 && xhr.readyState === 4) {
			const json = xhr.responseText;
			
			console.log(json);
		}
	}
	
	// Step 3: Open up the request
	xhr.open("POST", "http://localhost:8080/ServletExample/api/todos");
	
	// Step 4: We send off the request
	xhr.send(JSON.stringify(formData));
}

const parseForm = () => {
	const titleText = document.getElementById("title").value;
	const descriptionText = document.getElementById("description").value;
	return {
		title: titleText,
		description: descriptionText
	}
}



















