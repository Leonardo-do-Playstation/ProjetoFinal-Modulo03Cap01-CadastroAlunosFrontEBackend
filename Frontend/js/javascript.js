var curses = [];

var turns = [
    { id: 1, name: "Manhã" },
    { id: 2, name: "Tarde" },
    { id: 3, name: "Noite" },
];

loadCourses();
loadStudents();

function loadStudents() {

fetch("http://localhost:8080/students")
    .then(response => response.json())
    .then(data => {

        var table = document.getElementById("studentsTable");
        table.innerHTML = "";
        for (let stud of data) {
            addNewRow(stud);
        }

    });
}

function loadCourses(){

fetch("http://localhost:8080/courses")
    .then(response => response.json())
    .then(data => {

        curses = data;

        var select = document.getElementById("inputCourse");
        select.innerHTML = "";

        for(let course of data){

            var option = document.createElement("option");

            option.value = course.id;
            option.text = course.name;

            select.appendChild(option);

        }

    });

}

function save() {
    var stud = {
         name: document.getElementById("inputName").value,
        email: document.getElementById("inputEmail").value,
        phone: document.getElementById("inputPhone").value,
        idCurso: parseInt(document.getElementById("inputCourse").value),
        period: parseInt(document.querySelector('input[name="gridRadios"]:checked').value)
    };

    fetch("http://localhost:8080/students", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(stud)
    })
        .then(response => response.json())
        .then(data => {

            loadStudents();
            document.getElementById("studentForm").reset();

        });
}


function addNewRow(stud) {
    var table = document.getElementById("studentsTable");
    var newRow = table.insertRow();

    newRow.insertCell().appendChild(document.createTextNode(stud.id));
    newRow.insertCell().appendChild(document.createTextNode(stud.name));

    var cell = newRow.insertCell();
    cell.className = "d-none d-md-table-cell";
    cell.appendChild(document.createTextNode(stud.email));

    var cell2 = newRow.insertCell();
    cell2.className = "d-none d-md-table-cell";
    cell2.appendChild(document.createTextNode(stud.phone));

    var course = curses.find(c => c.id == stud.idCurso);

    var cell3 = newRow.insertCell();
    cell3.className = "d-none d-md-table-cell";
    cell3.appendChild(document.createTextNode(course.name));

    var cell4 = newRow.insertCell();
    cell4.className = "d-none d-md-table-cell";
    cell4.appendChild(document.createTextNode(turns[stud.period - 1].name));
}
