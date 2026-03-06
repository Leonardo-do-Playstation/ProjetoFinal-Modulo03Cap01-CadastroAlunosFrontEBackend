var students = [
    { id: 1, name: "Pedro Antonio", email: "pedro@abutua.com", phone: "(15) 9999-9999", curse: 2, turn: 2 },
];

var curses = [
    { id: 1, name: "Java" },
    { id: 2, name: "Angular" },
    { id: 3, name: "C#" },
    { id: 4, name: "Python" },
    { id: 5, name: "JavaScript" },
];

var turns = [
    { id: 1, name: "Manhã" },
    { id: 2, name: "Tarde" },
    { id: 3, name: "Noite" },
];

loadStudents();

function loadStudents() {
    for (let stud of students) {
        addNewRow(stud);
    }
}


function save() {
    var stud = {
        id: students.length + 1,
        name: document.getElementById("inputName").value,
        email: document.getElementById("inputEmail").value,
        phone: document.getElementById("inputPhone").value,
        curse: document.getElementById("inputCurse").value,
        turn: document.querySelector('input[name="gridRadios"]:checked').value
    };

    addNewRow(stud);
    students.push(stud);
    document.getElementById("studentForm").reset();
}


function addNewRow(stud) {
    var table = document.getElementById("studentsTable");
    var newRow = table.insertRow();

    var idNode = document.createTextNode(stud.id);
    newRow.insertCell().appendChild(idNode);

    var nameNode = document.createTextNode(stud.name);
    newRow.insertCell().appendChild(nameNode);

    var emailNode = document.createTextNode(stud.email);
    var cell = newRow.insertCell();
    cell.className = "d-none d-md-table-cell";
    cell.appendChild(emailNode);

    var phoneNode = document.createTextNode(stud.phone);
    var cell2 = newRow.insertCell();
    cell2.className = "d-none d-md-table-cell";
    cell2.appendChild(phoneNode);

    var curseNode = document.createTextNode(curses[stud.curse - 1].name);
    var cell3 = newRow.insertCell();
    cell3.className = "d-none d-md-table-cell";
    cell3.appendChild(curseNode);

    var turnNode = document.createTextNode(turns[stud.turn - 1].name);
    var cell4 = newRow.insertCell();
    cell4.className = "d-none d-md-table-cell";
    cell4.appendChild(turnNode);

}
